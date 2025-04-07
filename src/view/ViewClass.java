package view;

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

    public void showMenuTherapist() {
        System.out.println("1. Analizar Sueño");
        System.out.println("2. Duplicar y experimentar con un sueño");
        System.out.println("3. Generar informe de un sueño");
        System.out.println("4. Configurar sistema");
        System.out.println("5. Exit");
    }

    public void showMenuPatient() {
        System.out.println("1. Registrar sueño");
        System.out.println("2. Exit");
    }

    public void exitMessage(){
        System.out.println("Sesion cerrada, gracias por usar el sistema de analisis de sueños");
    }
}
