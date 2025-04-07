package model;

import java.util.HashMap;

public class Manager {

    String systemSetting; //debe ser de tipo de systemSetting pero lo dejo asi mientras para no error
    String repository; //debe ser de tipo de AbstractProductRepository pero lo dejo asi mientras para no error
    HashMap<String, String> dreamMap; //el segundo atributo debe ser Dream pero lo dejo mientras asi para no error

    public Manager() {
        this.systemSetting = "aqui va el sistema setting";
        this.dreamMap = new HashMap<>();
    }

    public void createRepository(String repository) {
        //logica para elegir el repositorio, recuerden cambiar los tipos de los atributos
    }

    public void regysterDream(String dream) {
        //logica para registrar el sueño, recuerden cambiar los tipos de los atributos
    }

    public String analizeDream (String Analizer, String Dream){
        //logica para analizar el sueño, recuerden cambiar los tipos de los atributos
        return "aqui va el analisis del sueño";
    }

    public void systemConfig(){
        //logica para configurar el sistema, recuerden cambiar los tipos de los atributos
    }

    public String createReport (String dreamAnaliced){
        //logica para crear el reporte, recuerden cambiar los tipos de los atributos
        return "aqui va el reporte del sueño analizado";
    }
}
