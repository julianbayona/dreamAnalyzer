package view;

import java.util.List;
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
        return scanner.nextInt();
    }

    public int getDreamId(){
        System.out.println("\nIngrese id del sueño: ");
        return scanner.nextInt();
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
        System.out.println("\n--- Opciones de Terapeuta ---");
        System.out.println("1. Ver lista de pacientes");
        System.out.println("2. Almacenar sueño en repositorio");
        System.out.println("3. Generar informe de análisis--(no implementado)");
        System.out.println("4. Duplicar sueño para otro análisis--(no implementado)");
        System.out.println("5. Analizar sueño--(no implementado)");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opción: ");
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
}
