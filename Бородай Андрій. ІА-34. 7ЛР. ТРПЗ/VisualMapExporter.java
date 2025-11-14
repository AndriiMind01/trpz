package org.example;

import org.example.exception.ExportException;
import org.example.export.ExportImplementation;
import org.example.export.MapExporter;
import org.example.export.imp.PDFExport;
import org.example.export.imp.PNGExport;
import org.example.model.Edge;
import org.example.model.MentalMap;
import org.example.model.Node;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class VisualMapExporter extends MapExporter {
    private boolean includeBackground = true;
    private boolean highQuality = false;
    private int imageWidth = 1920;
    private int imageHeight = 1080;

    public VisualMapExporter(ExportImplementation exportImpl) {
        super(exportImpl);
    }

    @Override
    public File exportMap(MentalMap map, String filename) throws ExportException {
        byte[] exportData;

        if (exportImpl instanceof PNGExport) {
            exportData = convertToPNG(map);
        } else if (exportImpl instanceof PDFExport) {
            exportData = convertToPDF(map);
        } else {
            throw new ExportException(
                    "Формат " + exportImpl.getFormatName() + " не підтримується для візуального експорту",
                    exportImpl.getFormatName(),
                    filename
            );
        }

        return exportImpl.export(exportData, filename);
    }

    private byte[] convertToPNG(MentalMap map) throws ExportException {
        try {
            BufferedImage image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = image.createGraphics();

            if (highQuality) {
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            }

            if (includeBackground) {
                g2d.setColor(Color.WHITE);
                g2d.fillRect(0, 0, imageWidth, imageHeight);
            }

            drawGraph(g2d, map);

            g2d.dispose();

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "PNG", baos);
            return baos.toByteArray();

        } catch (IOException e) {
            throw new ExportException("Помилка конвертації в PNG: " + e.getMessage(), e);
        }
    }

    private byte[] convertToPDF(MentalMap map) throws ExportException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            String pdfContent = generatePDFContent(map);

            return pdfContent.getBytes(StandardCharsets.UTF_8);

        } catch (Exception e) {
            throw new ExportException("Помилка конвертації в PDF: " + e.getMessage(), e);
        }
    }

    private void drawGraph(Graphics2D g2d, MentalMap map) {
        g2d.setColor(Color.GRAY);
        for (Edge edge : map.getEdges()) {
            Node fromNode = findNodeById(map, edge.getFromNodeId());
            Node toNode = findNodeById(map, edge.getToNodeId());

            if (fromNode != null && toNode != null) {
                int x1 = scaleX(fromNode.getX());
                int y1 = scaleY(fromNode.getY());
                int x2 = scaleX(toNode.getX());
                int y2 = scaleY(toNode.getY());

                g2d.drawLine(x1, y1, x2, y2);
            }
        }

        for (Node node : map.getNodes()) {
            int x = scaleX(node.getX());
            int y = scaleY(node.getY());

            g2d.setColor(getColorFromHex(node.getColor()));
            g2d.fillRect(x - 40, y - 20, 80, 40);
            g2d.setColor(Color.BLACK);
            g2d.drawRect(x - 40, y - 20, 80, 40);

            g2d.setColor(Color.BLACK);
            drawCenteredString(g2d, node.getContent(), x, y);
        }
    }

    private int scaleX(double x) { return (int) (x * imageWidth / 800.0); }
    private int scaleY(double y) { return (int) (y * imageHeight / 600.0); }

    private Color getColorFromHex(String hex) {
        if (hex == null || hex.isEmpty()) return Color.LIGHT_GRAY;
        try {
            return Color.decode(hex);
        } catch (NumberFormatException e) {
            return Color.LIGHT_GRAY;
        }
    }

    private void drawCenteredString(Graphics2D g2d, String text, int x, int y) {
        FontMetrics fm = g2d.getFontMetrics();
        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();

        if (textWidth > 70) {
            text = text.substring(0, Math.min(10, text.length())) + "...";
            textWidth = fm.stringWidth(text);
        }

        g2d.drawString(text, x - textWidth / 2, y + textHeight / 4);
    }

    private String generatePDFContent(MentalMap map) {
        StringBuilder pdf = new StringBuilder();
        pdf.append("%PDF-1.4\n");
        pdf.append("1 0 obj\n<< /Type /Catalog /Pages 2 0 R >>\nendobj\n");
        pdf.append("2 0 obj\n<< /Type /Pages /Kids [3 0 R] /Count 1 >>\nendobj\n");
        pdf.append("3 0 obj\n<< /Type /Page /Parent 2 0 R /MediaBox [0 0 612 792] /Contents 4 0 R >>\nendobj\n");
        pdf.append("4 0 obj\n<< /Length 200 >>\nstream\nBT\n/F1 12 Tf\n50 750 Td\n(").append(map.getTitle()).append(") Tj\nET\n");

        int yPos = 700;
        for (Node node : map.getNodes()) {
            pdf.append("BT\n/F1 10 Tf\n50 ").append(yPos).append(" Td\n(")
                    .append(node.getContent()).append(") Tj\nET\n");
            yPos -= 20;
        }

        pdf.append("endstream\nendobj\n");
        pdf.append("xref\n0 5\n0000000000 65535 f \n0000000010 00000 n \n0000000053 00000 n \n0000000110 00000 n \n0000000234 00000 n \n");
        pdf.append("trailer\n<< /Size 5 /Root 1 0 R >>\nstartxref\n500\n%%EOF");

        return pdf.toString();
    }

    private Node findNodeById(MentalMap map, String nodeId) {
        return map.getNodes().stream()
                .filter(node -> node.getId().equals(nodeId))
                .findFirst()
                .orElse(null);
    }
    
    public VisualMapExporter withBackground(boolean include) {
        this.includeBackground = include;
        return this;
    }

    public VisualMapExporter withHighQuality(boolean highQuality) {
        this.highQuality = highQuality;
        return this;
    }

    public VisualMapExporter withDimensions(int width, int height) {
        this.imageWidth = width;
        this.imageHeight = height;
        return this;
    }
}
