package presenter;

import model.Manager;
import view.ViewClass;

public class PresenterClass {
    private ViewClass view;
    private Manager manager;

    public PresenterClass() {
        view = new ViewClass();
        manager = new Manager();
        this.starSession();
    }

    public void starSession(){
        Boolean exit=false;
        
        while (exit==false){
            String session = view.showMenuSession();
            if (session.equals("Therapist")){
                sessionTherapist();
            }else if (session.equals("Patient")){
                sessionPatient();
                
            }else if (session.equals("exit")){
                exit=true;
                view.exitMessage();
            }else {
                System.out.println("Opción no válida, intente de nuevo.");
            }   
        }
    }

    public void sessionTherapist(){
        Boolean exit=false;
        while (exit==false){
            view.showMenuTherapist();
            String option = view.getInput("Seleccione la opcion a realizar");
            switch (option) {
                case "1":
                    // Analizar sueño (recuerden cambar segun la logica)
                    manager.analizeDream(option, option);
                    break;
                case "2":
                    // Duplicar y experimentar con un sueño
                    //Agregar la logica de duplicar y experimentar con un sueño del manager
                    break;
                case "3":
                    // Generar informe de un sueño (recuerden cambar segun la logica)
                    manager.createReport(option);
                    break;
                case "4":
                    // Configure System (recuerden cambar segun la logica)
                    manager.systemConfig();
                    break;
                case "5":
                    // exit
                    view.exitMessage();
                    exit=true;
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
    
    public void sessionPatient(){
        Boolean exit=false;
        while (exit==false){
            view.showMenuPatient();
            String option = view.getInput("Seleccione la opcion a realizar");
            switch (option) {
                case "1":
                    // Registrar sueño (recuerden cambar segun la logica)
                    manager.regysterDream(option);
                    break;
                case "2":
                    // exit
                    view.exitMessage();
                    exit=true;
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
}
