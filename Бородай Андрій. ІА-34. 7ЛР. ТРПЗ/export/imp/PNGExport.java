package org.example.export.imp;

import org.example.exception.ExportException;
import org.example.export.ExportImplementation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class PNGExport implements ExportImplementation {
    @Override
    public File export(byte[] imageData, String filename) throws ExportException {
        try {
            String fullPath = filename + "." + getFileExtension();
            File file = new File(fullPath);

            Files.write(file.toPath(), imageData);
            return file;

        } catch (IOException e) {
            throw new ExportException("Помилка експорту в PNG: " + e.getMessage(), e);
        }
    }

    @Override
    public String getFileExtension() { return "png"; }

    @Override
    public boolean supportsMetadata() { return false; }

    @Override
    public String getFormatName() { return "PNG Image"; }
}




