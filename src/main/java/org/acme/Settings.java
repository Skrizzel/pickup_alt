package org.acme;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Settings {
    private static Properties properties = new Properties();
    private static final Properties defaultProperties = new Properties();
    private static boolean isLoaded = false;

    // Define default configuration keys and values
    static {
        defaultProperties.setProperty("app.name", "MyApplication");
        defaultProperties.setProperty("app.version", "1");
        defaultProperties.setProperty("debug", "false");
        defaultProperties.setProperty("APIKey", "Stinker2");
    }

    /**
     * Load configuration from an INI file, creating it with default values if it doesn't exist.
     * @param filePath Path to the INI file.
     * @throws IOException If the file cannot be created or read.
     */
    public static void load(String filePath) throws IOException {
        File configFile = new File(filePath);

        if (!configFile.exists()) {
            createDefaultConfigFile(configFile);
        }

        properties = new Properties(defaultProperties); // Load defaults first
        try (FileReader reader = new FileReader(configFile)) {
            properties.load(reader);
        }
        isLoaded = true;
    }

    /**
     * Get a property value as a string.
     * @param key The property key.
     * @return The property value as a string, or null if not found.
     */
    public static String getProperty(String key) {
        if (!isLoaded) {
            throw new IllegalStateException("Configuration not loaded.");
        }
        return properties.getProperty(key);
    }

    /**
     * Creates a configuration file with default values.
     * @param file The file to create.
     * @throws IOException If the file cannot be created or written.
     */
    private static void createDefaultConfigFile(File file) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            defaultProperties.store(writer, "Default Configuration");
        }
    }
}