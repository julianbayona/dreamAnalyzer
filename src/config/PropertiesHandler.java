package config;

import java.io.*;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PropertiesHandler {
    private Properties properties;
    private String filePath;

    public PropertiesHandler() {
        verifyResourcesDirectory();
        this.filePath = "resources/config.properties";
        properties = new Properties();
        loadProperties();
    }

    private void verifyResourcesDirectory() {
        File resourcesDir = new File("dreamAnalyzer/resources");
        if (!resourcesDir.exists()) {
            resourcesDir.mkdirs();
        }
    }

    private void loadProperties() {
        File file = new File(filePath);
        if (!file.exists()) {
            createDefaultPropertiesFile();
        }
        try (InputStream input = new FileInputStream(file)) {
            properties.load(input);
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de configuraciones. ");
        }
    }

    private void createDefaultPropertiesFile() {
        try (OutputStream output = new FileOutputStream(filePath)) {
            properties.setProperty("defaultKey", "defaultValue");
            properties.store(output, "Archivo de configuración creado por defecto");
        } catch (IOException e) {
            System.err.println("Error al crear el archivo de configuraciones");
        }
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public void setProperty(String key, String value) {
        properties.setProperty(key, value);
        try (OutputStream output = new FileOutputStream(filePath)) {
            properties.store(output, "Archivo de configuración actualizado");
        } catch (IOException e) {
            System.err.println("Error al guardar la propiedad en el archivo de configuraciones");
        }
    }

    public String[] getAllKeys() {
        return properties.keySet().toArray(new String[0]);
    }
}