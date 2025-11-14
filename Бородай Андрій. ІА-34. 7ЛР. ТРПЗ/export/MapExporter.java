package org.example.export;

import org.example.exception.ExportException;
import org.example.model.MentalMap;

import java.io.File;

public abstract class MapExporter {
    protected ExportImplementation exportImpl;

    protected MapExporter(ExportImplementation exportImpl) {
        this.exportImpl = exportImpl;
    }

    public abstract File exportMap(MentalMap map, String filename) throws ExportException;

    public String getSupportedFormats() {
        return exportImpl.getFormatName() + " (*." + exportImpl.getFileExtension() + ")";
    }

    public boolean canIncludeMetadata() {
        return exportImpl.supportsMetadata();
    }

    public void setExportImplementation(ExportImplementation impl) {
        this.exportImpl = impl;
    }
}
