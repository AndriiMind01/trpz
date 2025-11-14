package org.example.exception;

public class ExportException extends Exception {
    private final String format;
    private final String filename;

    public ExportException(String message) {
        super(message);
        this.format = "unknown";
        this.filename = "unknown";
    }

    public ExportException(String message, Throwable cause) {
        super(message, cause);
        this.format = "unknown";
        this.filename = "unknown";
    }

    public ExportException(String message, String format, String filename) {
        super(message);
        this.format = format;
        this.filename = filename;
    }

    public ExportException(String message, Throwable cause, String format, String filename) {
        super(message, cause);
        this.format = format;
        this.filename = filename;
    }

    public String getFormat() { return format; }
    public String getFilename() { return filename; }
}