package presenter;

import model.Dream;
import model.Manager;
import model.Patient;
import model.Therapist;
import view.ViewClass;

import java.util.ArrayList;
import java.util.List;

public class PresenterClass {
    private ViewClass view;
    private Manager manager;

    public PresenterClass() {
        manager = new Manager();
        view = new ViewClass();
        manager = new Manager();
        this.starSession();
        //init();
        //this.inicioSecion();
    }

    public void init(){
        while (true){
            String choice = showMenuSession();
            System.out.println(choice);
            switch (choice) {
                case "1":
                    patientFlow();
                    break;
                case "2":
                    therapistFlow();
                    break;
                case "3":
                    //System.out.println("Saliendo del sistema...");
                    return;
                default:
                    //System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    public String showMenuSession(){
        return view.showMenuSession();
    }

    private void patientFlow() {
        while (true) {
            String choice = view.showLogin();
            switch (choice) {
                case "1":
                    String name = view.getUserName();
                    boolean exists =  manager.loginPatient(name);
                    if(exists) {
                        patientOptions(manager.getPatientByName(name));
                    }else{
                        view.showMessage("Usuario no registrado dentro del sistema");
                    }
                    break;
                case "2":
                    Object [] patientParams = view.registerPatient();
                    registerPatient(patientParams);
                    //showDreams(patient);
                    break;
                case "3":
                    return;
                default:
                    view.showMessage("Opcion no valida.");
            }
        }
    }

    private void therapistFlow() {
        while (true) {
            String choice = view.showLogin();
            switch (choice) {
                case "1":
                    String name = view.getUserName();
                    boolean exists =  manager.loginTherapist(name);
                    if(exists) {
                        therapistOptions(manager.getTherapistByName(name));
                    }else{
                        view.showMessage("Usuario no registrado dentro del sistema");
                    }
                    break;
                case "2":
                    Object [] therapistParams = view.registerTherapist();
                    registerTherapist(therapistParams);
                    break;
                case "3":
                    return;
                default:
                    view.showMessage("Opcion no valida.");
            }
        }
    }

    public void starSession(){
        Boolean exit=false;

        while (exit==false){
            String session = view.showMenuSession();
            if (session.equals("Therapist")){
                therapistFlow();
                //sessionTherapist();
            }else if (session.equals("Patient")){
                patientFlow();
                //sessionPatient();
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
    private void patientOptions(Patient patient){
        while (true) {
            String choice = view.showPatientOptions();
            switch (choice) {
                case "1":
                    Object [] dreamParams = view.registerDream();
                    registerDream(patient,dreamParams);
                    view.showMessage("Sueno registrado con exito.");
                    break;
                case "2":
                    view.showDreams(getDreamsForView(patient.getId()));
                    break;
                case "3":
                    return;
                default:
                    view.showMessage("Opcion no valida.");
            }
        }
    }

    private void therapistOptions(Therapist therapist){
        while (true) {
            String choice = view.showTherapistOptions();
            switch (choice) {
                case "1":
                    view.showPatients(getPatientsForView());
                    break;
                case "2":
                    int patientId = view.getUserId();
                    Patient patient = manager.getPatientById(patientId);
                    if(patient!= null){
                        view.showDreams(getDreamsForView(patient.getId()));
                        int dreamId = view.getDreamId();
                        String repositoryIndex = view.showRepositories();
                        String repotype = selectRepository(repositoryIndex);
                        manager.createRepository(repotype);
                        manager.saveDreamToRepository(manager.getDreamById(patientId,dreamId),repotype);
                    }else{
                        view.showMessage("No hay usuarios registrados con ese nombre.");
                    }
                    break;
                case "3":
                    return;
                default:
                    view.showMessage("Opcion no valida.");
            }
        }
    }

    public String selectRepository(String repositoryIndex){
        String repoType = "";
        switch (repositoryIndex){
            case "1":
                repoType = "historical";
                break;
            case"2":
                repoType = "temporary";
                break;
        }
        return repoType;
    }

    public void registerDream(Patient patient, Object [] dreamParams){
        manager.registerDream(patient, (Integer) dreamParams[0], (Integer)  dreamParams[1], (Integer) dreamParams[2], (String)dreamParams[3]);
    }

    public void registerPatient(Object [] patientParams){
        manager.registerPatient((String) patientParams[0],(Integer) patientParams[1]);
    }

    public void registerTherapist(Object [] therapistParams){
        manager.registerTherapist((String) therapistParams[0],(Integer) therapistParams[1]);
    }

    public List<Object[]> getDreamsForView(int patientId) {
        List<Dream> dreams = manager.getDreamsById(patientId);
        List<Object[]> dreamList = new ArrayList<>();

        if (dreams != null) {
            for (Dream dream : dreams) {
                dreamList.add(new Object[]{dream.getDuration(), dream.getEmotionalIntensity(), dream.getNarrative(), dream.getVisualLight()});
            }
        }
        return dreamList;
    }

    public List<Object[]> getPatientsForView() {
        List<Patient> patients = manager.getAllPatients();
        List<Object[]> patientList = new ArrayList<>();

        if (patients != null) {
            for (Patient patient : patients) {
                patientList.add(new Object[]{patient.getName(), patient.getId(), patient.getAge()});
            }
        }
        return patientList;
    }


}
