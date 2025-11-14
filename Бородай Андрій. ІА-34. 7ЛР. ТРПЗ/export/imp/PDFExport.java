package org.example.export.imp;

import org.example.exception.ExportException;
import org.example.export.ExportImplementation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class PDFExport implements ExportImplementation {
    @Override
    public File export(byte[] pdfData, String filename) throws ExportException {
        try {
            String fullPath = filename + "." + getFileExtension();
            File file = new File(fullPath);

            Files.write(file.toPath(), pdfData);
            return file;

        } catch (IOException e) {
            throw new ExportException("Помилка експорту в PDF: " + e.getMessage(), e);
        }
    }

    @Override
    public String getFileExtension() { return "pdf"; }

    @Override
    public boolean supportsMetadata() { return true; }

    @Override
    public String getFormatName() { return "PDF Document"; }
}