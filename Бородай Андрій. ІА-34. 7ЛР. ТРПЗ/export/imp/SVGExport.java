package org.example.export.imp;

import org.example.exception.ExportException;
import org.example.export.ExportImplementation;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class SVGExport implements ExportImplementation {
    @Override
    public File export(byte[] svgData, String filename) throws ExportException {
        try {
            String fullPath = filename + "." + getFileExtension();
            File file = new File(fullPath);

            String svgContent = new String(svgData, StandardCharsets.UTF_8);
            Files.write(file.toPath(), svgContent.getBytes(StandardCharsets.UTF_8));
            return file;

        } catch (IOException e) {
            throw new ExportException("Помилка експорту в SVG: " + e.getMessage(), e);
        }
    }

    @Override
    public String getFileExtension() { return "svg"; }

    @Override
    public boolean supportsMetadata() { return true; }

    @Override
    public String getFormatName() { return "SVG Vector"; }
}