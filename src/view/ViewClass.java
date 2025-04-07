package view;

import java.util.Scanner;

public class ViewClass {
    Scanner scanner;

    public ViewClass() {
        scanner = new Scanner(System.in);
    }

    public String showMenuSession() {
        System.out.println("Bienvenido al sistema de análisis de sueños, como queiere iniciar sesión");
        System.out.println("1. Usuario");
        System.out.println("2. Administrador");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
        return scanner.next();
    }

    public String getInput(String prompt) {
        System.out.print(prompt + ": ");
        return new java.util.Scanner(System.in).nextLine();
    }

    public void showMenu() {
        System.out.println("1. Create Repository");
        System.out.println("2. Register Dream");
        System.out.println("3. Analyze Dream");
        System.out.println("4. Configure System");
        System.out.println("5. Create Report");
        System.out.println("6. Exit");
    }
}
