package org.example.export;

import org.example.exception.ExportException;
import org.example.model.MentalMap;

import java.io.File;

/**
 * Abstraction - визначає інтерфейс для клієнтського коду
 */
public abstract class MapExporter {
    protected ExportImplementation exportImpl;

    protected MapExporter(ExportImplementation exportImpl) {
        this.exportImpl = exportImpl;
    }

    // Основний метод експорту
    public abstract File exportMap(MentalMap map, String filename) throws ExportException;

    // Додаткові методи
    public String getSupportedFormats() {
        return exportImpl.getFormatName() + " (*." + exportImpl.getFileExtension() + ")";
    }

    public boolean canIncludeMetadata() {
        return exportImpl.supportsMetadata();
    }

    // Можливість змінити імплементацію під час виконання
    public void setExportImplementation(ExportImplementation impl) {
        this.exportImpl = impl;
    }
}
