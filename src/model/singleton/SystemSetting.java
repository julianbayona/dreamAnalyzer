package model.singleton;

import config.PropertiesHandler;

public class SystemSetting {
    private static SystemSetting instance;
    private PropertiesHandler propertiesHandler;

    private SystemSetting() {
        propertiesHandler = new PropertiesHandler();
    }

    public static SystemSetting getInstance() {
        if (instance == null) {
            instance = new SystemSetting();
        }
        return instance;
    }

    public String get(String key) {
        return propertiesHandler.getProperty(key, "Configuración no encontrada");
    }
}