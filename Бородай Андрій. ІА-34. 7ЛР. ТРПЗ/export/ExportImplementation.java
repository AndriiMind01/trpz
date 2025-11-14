package org.example.export;

import org.example.exception.ExportException;

import java.io.File;

public interface ExportImplementation {
    File export(byte[] data, String filename) throws ExportException;
    String getFileExtension();
    boolean supportsMetadata();
    String getFormatName();
}
