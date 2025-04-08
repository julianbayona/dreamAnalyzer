package view;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ViewClass {
    Scanner scanner;

    public ViewClass() {
        scanner = new Scanner(System.in);
    }

    public String showMenuSession() {
        Boolean sesion =false;
        String option = "";
        while(sesion==false){
            System.out.println("\nBienvenido al sistema de análisis de sueños, como queiere iniciar sesión");
            System.out.println("1. Terapeuta");
            System.out.println("2. Paciente");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextLine();
            if (option.equals("1")) {
                option = "Therapist";
                sesion=true;
            } else if (option.equals("2")) {
                option = "Patient";
                sesion=true;
            } else if (option.equals("3")) {
                option = "exit";
                sesion=true;
            } else {
                System.out.println("Opción no válida, intente de nuevo.");
            }
        }
        return option;
    }

    public String getInput(String prompt) {
        System.out.print(prompt + ": ");
        return new java.util.Scanner(System.in).nextLine();
    }

    public int getChoice(){
        return scanner.nextInt();
    }

    public void exitMessage(){
        System.out.println("Sesion cerrada, gracias por usar el sistema de analisis de sueños");
    }

    public String showLogin(String userType) {
        System.out.println("\n--- INICIO " + userType + " ---");
        System.out.println("1. Iniciar sesion");
        System.out.println("2. Registrarme");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.nextLine().trim();
    }

    public String getUserName(){
        System.out.print("\nIngrese nombre del usuario: "); 
        return scanner.nextLine();
    }

    public int getUserId(){
        System.out.println("\nIngrese id del usuario: ");
        return Integer.parseInt(scanner.nextLine()) ;
    }

    public int getDreamId(){
        System.out.println("\nIngrese id del sueño: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public Object[] registerPatient() {
        System.out.println("\n--- Registro de Paciente ---");
        
        System.out.print("Ingrese el nombre del paciente: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese la edad del paciente: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("\nPaciente registrado exitosamente.");
        return new Object[]{name, age};
    }

    public Object[] registerTherapist() {
        System.out.println("\n--- Registro de Terapeuta ---");
        
        System.out.print("Ingrese el nombre del terapeuta: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese la edad del terapeuta: ");
        int age = scanner.nextInt();
        scanner.nextLine(); 

        System.out.println("\nTerapeuta registrado exitosamente.");
        return new Object[]{name, age};
    }

    public Object[] registerDream() {
        System.out.println("\n--- Registro de Sueño ---");
        
        System.out.print("Ingrese la duración del sueño (minutos): ");
        int duration = scanner.nextInt();

        System.out.print("Ingrese la intensidad emocional (1-10): ");
        int emotionalIntensity = scanner.nextInt();

        System.out.print("Ingrese el nivel de luz visual en el sueño (1-10): ");
        int visualLight = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Describa el sueño: ");
        String narrative = scanner.nextLine();
        return new Object[]{duration, emotionalIntensity, visualLight, narrative};
    }

    public void showDreams(List<Object[]> dreams) {
        if (dreams == null || dreams.isEmpty()) {
            System.out.println("No hay sueños registrados.");
            return;
        }

        System.out.println("\n--- Lista de Sueños ---");
        int index = 1;
        for (Object[] dream : dreams) {
            System.out.println(index + ". Duración: " + dream[0] + " min");
            System.out.println("   Intensidad Emocional: " + dream[1]);
            System.out.println("   Narrativa: " + dream[2]);
            System.out.println("   Nivel de Luz Visual: " + dream[3]);
            System.out.println("--------------------------");
            index++;
        }
    }

    public String showPatientOptions() {
        System.out.println("\n--- Opciones de Paciente ---");
        System.out.println("1. Registrar mis sueños");
        System.out.println("2. Ver mis sueños");
        System.out.println("3. Volver al menu principal");
        System.out.print("Seleccione una opción: ");
        return scanner.nextLine();
    }

    public void showPatients(List<Object[]> patients) {
        if (patients == null || patients.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        System.out.println("\n--- Lista de Pacientes ---");
        int index = 1;
        for (Object[] patient : patients) {
            System.out.println(index + ". Nombre: " + patient[0]);
            System.out.println("   ID: " + patient[1]);
            System.out.println("   Edad: " + patient[2] + " años");
            System.out.println("--------------------------");
            index++;
        }
    }

    public String showTherapistOptions() {
        System.out.println("1. Ver lista de pacientes");
        System.out.println("2. Almacenar sueño en repositorio");
        System.out.println("3. Generar informe de análisis");
        System.out.println("4. Duplicar sueño para modificar narrativa");
        System.out.println("5. Analizar sueño");
        System.out.println("6. Configurar sistema");
        System.out.println("7. Salir");
        return scanner.nextLine();
    }

    public String showRepositories(){
        System.out.println("Seleccione el tipo de repositorio:");
        System.out.println("1. Histórico");
        System.out.println("2. Temporal");
        System.out.print("Opción: ");
        return scanner.next();
    }

    public void showMessage(String message){
        System.out.println(message);
    }

    
    public String showSystemConfigOptions(){
        System.out.println("--- Configuración del Sistema ---");
        System.out.println("1. Ver configuración del sistema");
        System.out.println("2. Cambiar configuración del sistema");
        System.out.println("3. Ver todas las configuraciones del sistema");
        System.out.println("4. Salir");
        return scanner.nextLine();
    }

    public String showConfigKeyMenu(String verb, String action) {
        System.out.println("--- " + verb + " Configuración del Sistema ---");
        System.out.println("Seleccione la configuración que desea " + action + ":");
        System.out.println("1. Edad máxima de los pacientes (edad-maxima-paciente)");
        System.out.println("2. Edad mínima de los pacientes (edad-minima-paciente)");
        System.out.println("3. Duración máxima de la consulta (duracion-maxima-consulta)");
        System.out.println("4. Duración mínima de la consulta (duracion-minima-consulta)");
        System.out.println("5. Idioma predeterminado (idioma-predeterminado)");
        System.out.println("6. Idiomas soportados (idiomas-soportados)");
        System.out.println("7. Formato de fecha (formato-fecha)");
        System.out.println("8. Formato de hora (formato-hora)");
        System.out.println("9. Lenguaje explícito (lenguaje-explicito)");
        System.out.println("10. Período de retención de datos (periodo-retencion-datos)");
        System.out.println("12. Aplicar guía ética estricta (aplicar-guia-etica-estricta)");
        System.out.println("13. Salir");
        return scanner.nextLine();
    }

    public String convertConfigValue(String key) {
        String value = "";
        switch(key){
            case "1":
                value = "edad-maxima-paciente";
                break;
            case "2":
                value = "edad-minima-paciente";
                break;
            case "3":
                value = "duracion-maxima-consulta";
                break;
            case "4":   
                value = "duracion-minima-consulta";
                break;
            case "5":
                value = "idioma-predeterminado";
                break;
            case "6":
                value = "idiomas-soportados";
                break;
            case "7":
                value = "formato-fecha";
                break;
            case "8":
                value = "formato-hora";
                break;
            case "9":
                value = "lenguaje-explicito";
                break;
            case "10":
                value = "periodo-retencion-datos";
                break;
            case "11":
                value = "permitir-datos-anonimos";
                break;
            case "12":
                value = "aplicar-guia-etica-estricta";
                break;
            case "13":
                value = "13";
                break;
            default:
                value = null;
                break;
        }
        return value;
    }
    
    public void showSucessUpdateConfig(){
        showMessage("Configuración del sistema actualizada.");
        getInput("(Presione cualquier tecla para continuar...)");
    }

    public void showErrorConfig(){
        showMessage("Seleccione una configuracion valida");
        getInput("(Presione cualquier tecla para continuar...)");
    }

    public String showAndGetValue(String configValue, String value){
        showMessage("--- Configuración del sistema ---\n" + configValue + ": " + value);
        return getInput("Ingrese el nuevo valor para " + configValue);
    }

    public void showConfig(String configValue, String value) {
        showMessage("--- Configuración del sistema ---\n" + configValue + ": " + value);
    }
}
