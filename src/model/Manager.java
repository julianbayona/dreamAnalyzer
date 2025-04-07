package model;

import model.abstractFactory.analyzer.conductuals.ConductualCognitive;
import model.abstractFactory.analyzer.conductuals.ConductualEmotional;
import model.abstractFactory.analyzer.conductuals.ConductualStatistical;
import model.abstractFactory.analyzer.conductuals.ConductualSymbolic;
import model.abstractFactory.analyzer.jungianos.JungianoCognitive;
import model.abstractFactory.analyzer.jungianos.JungianoEmotional;
import model.abstractFactory.analyzer.jungianos.JungianoStatistical;
import model.abstractFactory.analyzer.jungianos.JungianoSymbolic;
import model.builder.DreamReport;
import model.builder.DreamReportBuilder;
import model.factoryMethod.AbstractProductRepository;
import model.factoryMethod.DreamRepositoryFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.*;


public class Manager {

    String systemSetting; //debe ser de tipo de systemSetting pero lo dejo asi mientras para no error
    private Map<Integer, List<Dream>> patientDreams; //el segundo atributo debe ser Dream pero lo dejo mientras asi para no error
    private List<Patient> patients;
    private List<Therapist> therapists;
    private AbstractProductRepository historicalRepository;
    private AbstractProductRepository temporaryRepository;
    private DreamRepositoryFactory dreamRepositoryFactory;
    private DreamReportBuilder dreamReportBuilder;


    public Manager() {
        this.systemSetting = "aqui va el sistema setting";
        this.patientDreams = new HashMap<>();
        this.patients = new ArrayList<>();
        this.therapists = new ArrayList<>();
        dreamRepositoryFactory = new DreamRepositoryFactory();
        this.dreamReportBuilder = new DreamReportBuilder();
        loadData();
    }

    public void registerDream(Patient patient, int duration, int emotionalIntensity, int visualLight, String narrative) {
        Dream newDream = new Dream(duration, emotionalIntensity, narrative, visualLight);

        List<Dream> dreams = patientDreams.get(patient.getId());

        if (dreams == null || !(dreams instanceof ArrayList)) {
            dreams = new ArrayList<>(dreams != null ? dreams : new ArrayList<>());
            patientDreams.put(patient.getId(), dreams); // Reemplaza la lista
        }

        dreams.add(newDream);
    }

    public void registerPatient(String name, int age) {
        int id = patients.size()+1;
        boolean exists = patients.stream().anyMatch(p -> p.getId() == id);
        if (exists) {
            System.out.println("Error: Ya existe un paciente con el ID " + id);
            return;
        }
        Patient newPatient = new Patient(name, id, age);
        patients.add(newPatient);
    }

    public void registerTherapist(String name, int age) {
        int id = patients.size()+1;
        Therapist newTherapist = new Therapist(id,name,age);
        therapists.add(newTherapist);
    }


    public boolean loginPatient(String name){
        if(getPatientByName(name)==null){
            return false;
        }
        return true;
    }

    public boolean loginTherapist(String name){
        if(getTherapistByName(name)==null){
            return false;
        }
        return true;
    }

    public Patient getPatientByName(String name){
        return patients.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public Patient getPatientById(int patientId) {
        return patients.stream()
                .filter(p -> p.getId() == patientId)
                .findFirst()
                .orElse(null);
    }

    public Therapist getTherapistByName(String name){
        return therapists.stream()
                .filter(t -> t.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    public List<Dream> getDreamsById(int patientId) {
        return patientDreams.getOrDefault(patientId, new ArrayList<>());
    }

    public Dream getDreamById(int patientId, int dreamIndex) {
        List<Dream> dreams = patientDreams.get(patientId);

        if (dreams != null && dreamIndex >= 0 && dreamIndex < dreams.size()) {
            return dreams.get(dreamIndex-1);
        }
        return null;
    }

    public AbstractProductRepository createRepository(String repoType) {
        if (repoType.equalsIgnoreCase("historical")) {
            if (historicalRepository == null) { // Si no existe, lo crea
                historicalRepository = dreamRepositoryFactory.create(repoType);
            }
            return historicalRepository; // Retorna el repositorio existente o el recién creado
        } else if (repoType.equalsIgnoreCase("temporary")) {
            if (temporaryRepository == null) { // Si no existe, lo crea
                temporaryRepository = dreamRepositoryFactory.create(repoType);
            }
            return temporaryRepository; // Retorna el repositorio existente o el recién creado
        }
        throw new IllegalArgumentException("Tipo de repositorio no válido: " + repoType);
    }

    public void saveDreamToRepository(Dream dream, String repoType){
        if (repoType.equalsIgnoreCase("historical")) {
            historicalRepository.saveDream(dream);
        } else if (repoType.equalsIgnoreCase("temporary")) {
            temporaryRepository.saveDream(dream);
        }
    }

    private void loadData() {
        Patient p1 = new Patient("Alice", 1, 25);
        Patient p2 = new Patient("Bob", 2, 30);
        Patient p3 = new Patient("Charlie", 3, 22);

        patients.addAll(Arrays.asList(p1, p2, p3));

        List<Dream> dreamsP1 = Arrays.asList(
                new Dream(10, 5, "Sueño de volar", 8),
                new Dream(15, 7, "Sueño en un bosque", 6)
        );

        List<Dream> dreamsP2 = Arrays.asList(
                new Dream(12, 9, "Sueño de caer al vacío", 5),
                new Dream(20, 6, "Sueño con extraterrestres", 9)
        );

        List<Dream> dreamsP3 = Arrays.asList(
                new Dream(8, 4, "Sueño con un océano infinito", 7)
        );

        patientDreams.put(p1.getId(), dreamsP1);
        patientDreams.put(p2.getId(), dreamsP2);
        patientDreams.put(p3.getId(), dreamsP3);

        therapists.add(new Therapist(1, "Juan Perez", 45));
        therapists.add(new Therapist(2, "María López", 38));
        therapists.add(new Therapist(3, "Carlos García", 50));
        therapists.add(new Therapist(4, "Ana Torres", 42));
        therapists.add(new Therapist(5, "Luis Fernández", 37));

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

    public void createReportWithSummary (int option){
        if(option == 1) {
            dreamReportBuilder.withSummary();
        }
    }





    public void createReportWithAnalyzeJuguiano (int option){

        switch (option){
            case 1:
                dreamReportBuilder.withSymbolicSection(new JungianoSymbolic());
                break;
            case 2:
                dreamReportBuilder.withStaticalSection(new JungianoStatistical());
                break;
            case 3:
                dreamReportBuilder.withEmotionalSection(new JungianoEmotional());
                break;
            case 4:
                dreamReportBuilder.withCognitiveSection(new JungianoCognitive());
                break;
            default:
        }
    }

    public void createReportWithAnalyzeConductual (int option){

        switch (option){
            case 1:
                dreamReportBuilder.withSymbolicSection(new ConductualSymbolic());
                break;
            case 2:
                dreamReportBuilder.withStaticalSection(new ConductualStatistical());
                break;
            case 3:
                dreamReportBuilder.withEmotionalSection(new ConductualEmotional());
                break;
            case 4:
                dreamReportBuilder.withCognitiveSection(new ConductualCognitive());
                break;
            default:
        }
    }



    public List<Patient> getAllPatients() {
        return patients;
    }


}
