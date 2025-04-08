package presenter;

import java.util.ArrayList;
import java.util.List;
import model.Constants;
import model.Dream;
import model.Manager;
import model.Patient;
import view.ViewClass;

public class PresenterClass {

    private ViewClass view;
    private Manager manager;

    public PresenterClass() {
        manager = new Manager();
        view = new ViewClass();
        manager = new Manager();
        this.init();
    }

    public String showMenuSession() {
        return view.showMenuSession();
    }

    public void showCreateReport() {
        int id = view.getUserId();
        System.out.println(manager.getDreamsById(id));
        int idDream = view.getDreamId();
        Dream dream = manager.getDreamById(id, idDream);
        System.out.println(dream);
        showDream(dream);
        changeApproach();
        withSummary();
    }

    private void patientFlow() {
        while (true) {
            String choice = view.showLogin("PACIENTE");
            switch (choice) {
                case "1":
                    String name = view.getUserName();
                    boolean exists = manager.loginPatient(name);
                    if (exists) {
                        patientOptions(manager.getPatientByName(name));
                    } else {
                        view.showMessage("Usuario no registrado dentro del sistema");
                    }
                    break;
                case "2":
                    Object[] patientParams = view.registerPatient();
                    registerPatient(patientParams);
                    // showDreams(patient);
                    break;
                case "3":
                    return;
                default:
                    view.showMessage("\n Opcion no valida.");
            }
        }
    }

    private void therapistFlow() {
        while (true) {
            String choice = view.showLogin("TERAPEUTA");
            switch (choice) {
                case "1":
                    String name = view.getUserName();
                    boolean exists = manager.loginTherapist(name);
                    if (exists) {
                        therapistOptions();
                    } else {
                        view.showMessage("Usuario no registrado dentro del sistema");
                    }
                    break;
                case "2":
                    Object[] therapistParams = view.registerTherapist();
                    registerTherapist(therapistParams);
                    break;
                case "3":
                    return;
                default:
                    view.showMessage("Opcion no valida.");
            }
        }
    }

    public void init() {
        Boolean exit = false;

        while (exit == false) {
            String session = view.showMenuSession();
            if (session.equals("Therapist")) {
                therapistFlow();
                // sessionTherapist();
            } else if (session.equals("Patient")) {
                patientFlow();
                // sessionPatient();
            } else if (session.equals("exit")) {
                exit = true;
                view.exitMessage();
            } else {
                System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    private void patientOptions(Patient patient) {
        while (true) {
            String choice = view.showPatientOptions();
            switch (choice) {
                case "1":
                    Object[] dreamParams = view.registerDream();
                    registerDream(patient, dreamParams);
                    view.showMessage("\nSueño registrado con exito.");
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

    private void therapistOptions() {
        while (true) {
            String choice = view.showTherapistOptions();
            switch (choice) {
                case "1":
                    view.showPatients(getPatientsForView());
                    break;
                case "2":
                    int patientId = view.getUserId();
                    Patient patient = manager.getPatientById(patientId);
                    if (patient != null) {
                        view.showDreams(getDreamsForView(patient.getId()));
                        int dreamId = view.getDreamId();
                        String repositoryIndex = view.showRepositories();
                        String repotype = selectRepository(repositoryIndex);
                        manager.createRepository(repotype);
                        manager.saveDreamToRepository(manager.getDreamById(patientId, dreamId), repotype);
                    } else {
                        view.showMessage("No hay usuarios registrados con ese nombre.");
                    }
                    break;
                case "3":
                    showCreateReport();
                    break;
                case "5":
                    analyseDream();
                    break;

                case "6":
                    selectConfigMenu();
                    break;
                case "7":
                    return;
                default:
                    view.showMessage("Opcion no valida.");
            }
        }
    }

    public void analyseDream() {
        String option = "";
        Dream dream = dreamToAnalyse();
        changeApproach();
        realizeAnalysis(option, dream);
    }

    public Dream dreamToAnalyse() {
        String idUser = view.getInput("Ingrese el id del usuario al que le analizará el sueño:");
        view.showDreams(getDreamsForView(Integer.parseInt(idUser)));
        String idDream = view.getInput("Ingrese el id del sueño que desea analizar:");
        return manager.getDreamById(Integer.parseInt(idUser), Integer.parseInt(idDream));
    }

    public void changeApproach() {
        String approach = view.getInput("Ingrese el tipo de enfoque que desea utilizar:\n"
                + "1. Jungiano\n"
                + "2. conductual\n");
        switch (approach) {
            case "1":
                manager.changeApproach(Constants.JUNGIANO);
                break;
            case "2":
                manager.changeApproach(Constants.CONDUCTUAL);
                break;
            default:
                break;
        }
    }

    public void withSummary() {
        boolean inLoop = true;
        while (inLoop) {
            String approach = view.getInput("Ingrese si desea el reporte con:\n"
                    + "1. resumen\n"
                    + "2. analisis cognitivo\n"
                    + "3. analisis emocional\n"
                    + "4. analisis estatico\n"
                    + "5. analisis symbolico\n"
                    + "6. Grafico\n"
                    + "7. mostrar\n");
            switch (approach) {
                case "1":
                    manager.createReportWithSummary();
                    break;

                case "2":
                    manager.createReportWithAnalizisCognitive();
                    break;

                case "3":
                    manager.createReportWithAnalizisEmotional();
                    break;

                case "4":
                    manager.createReportWithAnalizisStatical();
                    break;

                case "5":
                    manager.createReportWithAnalizisSymbolic();
                    break;

                case "6":
                    manager.createReportWithgraph();
                    break;

                case "7":
                    System.out.println(manager.getReport().toString());
                    inLoop = false;
                    break;
                default:
                    break;
            }
        }

    }

    public void realizeAnalysis(String option, Dream dream) {
        while (!option.equals("5")) {
            option = view.getInput("Ingrese el tipo de análisis que desea realizar:\n"
                    + "1. Cognitivo\n"
                    + "2. Emocional\n"
                    + "3. Estadísitco\n"
                    + "4. Simbólico\n"
                    + "5. Atrás\n");
            switch (option) {
                case "1":
                    showDream(dream);
                    view.showMessage(manager.analyzeDream(Constants.COGNITIVE, dream));
                    break;
                case "2":
                    showDream(dream);
                    view.showMessage(manager.analyzeDream(Constants.EMOTIONAL, dream));
                    break;
                case "3":
                    showDream(dream);
                    view.showMessage(manager.analyzeDream(Constants.STATISTICAL, dream));
                    break;
                case "4":
                    showDream(dream);
                    view.showMessage(manager.analyzeDream(Constants.SYMBOLIC, dream));
                    break;
                default:
                    break;
            }
        }
    }

    public void showDream(Dream dream) {
        view.showMessage("--------------------------");
        view.showMessage("Sueño analizado:");
        view.showMessage("Duración: " + dream.getDuration() + " min");
        view.showMessage("   Intensidad Emocional: " + dream.getEmotionalIntensity());
        view.showMessage("   Narrativa: " + dream.getNarrative());
        view.showMessage("   Nivel de Luz Visual: " + dream.getVisualLight());
    }

    public String selectRepository(String repositoryIndex) {
        String repoType = "";
        switch (repositoryIndex) {
            case "1":
                repoType = "historical";
                break;
            case "2":
                repoType = "temporary";
                break;
        }
        return repoType;
    }

    public void registerDream(Patient patient, Object[] dreamParams) {
        manager.registerDream(patient, (Integer) dreamParams[0], (Integer) dreamParams[1], (Integer) dreamParams[2],
                (String) dreamParams[3]);
    }

    public void registerPatient(Object[] patientParams) {
        manager.registerPatient((String) patientParams[0], (Integer) patientParams[1]);
    }

    public void registerTherapist(Object[] therapistParams) {
        manager.registerTherapist((String) therapistParams[0], (Integer) therapistParams[1]);
    }

    public List<Object[]> getDreamsForView(int patientId) {
        List<Dream> dreams = manager.getDreamsById(patientId);
        List<Object[]> dreamList = new ArrayList<>();

        if (dreams != null) {
            for (Dream dream : dreams) {
                dreamList.add(new Object[]{dream.getDuration(), dream.getEmotionalIntensity(), dream.getNarrative(),
                    dream.getVisualLight()});
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

    public void selectConfigMenu(){
        String option = view.showSystemConfigOptions();
        switch (option) {
            case "1":
                getConfigKeyMenu();
                break;
            case "2":
                setConfigKeyMenu();
                break;
            case "3":
                getConfigsKeyMenu();
                break;
            case "4":
                break;
            default:
                view.showMessage("Opción no válida.");
        }
    }

    public void getConfigKeyMenu(){
        String key = view.showConfigKeyMenu("Ver", "visualizar");
        String configValue = view.convertConfigValue(key);
        if (configValue == null) {
            view.showErrorConfig();
        } else if(configValue.equals("13")){
            return;  
        } else {
            String value = manager.getSystemConfig(configValue);
            view.showMessage("--- Configuración del sistema ---\n" + configValue + ": " + value);
            view.getInput("(Presione cualquier tecla para continuar...)");
        }
    }

    public void setConfigKeyMenu(){
        String key = view.showConfigKeyMenu("Actualizar", "actualizar");
        String configValue = view.convertConfigValue(key);
        if (configValue == null) {
            view.showErrorConfig();
        } else if(configValue.equals("13")){
            return;  
        } else {
            String newValue = view.showAndGetValue(configValue, manager.getSystemConfig(configValue));
            manager.setSystemConfig(configValue, newValue);
            view.showSucessUpdateConfig();
        }
    }

    public void getConfigsKeyMenu(){
        String[] keyValues = manager.getAllConfigKeys();
        view.showMessage("--- Configuraciones del sistema ---");
        for(String keyValue : keyValues) {
            if (keyValue == null) {
                view.showErrorConfig();
            } else {
                view.showMessage(keyValue + ": " + manager.getSystemConfig(keyValue));
            }
        }
        view.getInput("(Presione cualquier tecla para continuar...)");
    }

}
