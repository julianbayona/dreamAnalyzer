package model;

import model.abstractFactory.FactoryProvider;
import model.abstractFactory.factories.TherapeuticApproachFactory;
import model.factoryMethod.AbstractProductRepository;
import model.factoryMethod.DreamRepositoryFactory;
import model.singleton.SystemSetting;

import java.util.*;

public class Manager {

    private SystemSetting systemSetting; //debe ser de tipo de systemSetting pero lo dejo asi mientras para no error
    private Map<Integer, List<Dream>> patientDreams; //el segundo atributo debe ser Dream pero lo dejo mientras asi para no error
    private List<Patient> patients;
    private List<Therapist> therapists;
    private AbstractProductRepository historicalRepository;
    private AbstractProductRepository temporaryRepository;
    private DreamRepositoryFactory dreamRepositoryFactory;
    private TherapeuticApproachFactory approachFactory;
    private FactoryProvider factoryProvider;

    public Manager() {
        this.systemSetting = SystemSetting.getInstance();
        this.patientDreams = new HashMap<>();
        this.patients = new ArrayList<>();
        this.therapists = new ArrayList<>();
        dreamRepositoryFactory = new DreamRepositoryFactory();
        loadData();
    }

    public void registerDream(Patient patient, int duration, int emotionalIntensity, int visualLight,
            String narrative) {
        Dream newDream = new Dream(duration, emotionalIntensity, narrative, visualLight);

        List<Dream> dreams = patientDreams.get(patient.getId());

        if (dreams == null || !(dreams instanceof ArrayList)) {
            dreams = new ArrayList<>(dreams != null ? dreams : new ArrayList<>());
            patientDreams.put(patient.getId(), dreams); // Reemplaza la lista
        }

        dreams.add(newDream);
    }

    public void registerPatient(String name, int age) {
        int id = patients.size() + 1;
        boolean exists = patients.stream().anyMatch(p -> p.getId() == id);
        if (exists) {
            System.out.println("Error: Ya existe un paciente con el ID " + id);
            return;
        }
        Patient newPatient = new Patient(name, id, age);
        patients.add(newPatient);
    }

    public void registerTherapist(String name, int age) {
        int id = patients.size() + 1;
        Therapist newTherapist = new Therapist(id, name, age);
        therapists.add(newTherapist);
    }

    public boolean loginPatient(String name) {
        if (getPatientByName(name) == null) {
            return false;
        }
        return true;
    }

    public boolean loginTherapist(String name) {
        if (getTherapistByName(name) == null) {
            return false;
        }
        return true;
    }

    public Patient getPatientByName(String name) {
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

    public Therapist getTherapistByName(String name) {
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

        if (dreams != null && dreamIndex >= 0 && dreamIndex <= dreams.size()) {
            return dreams.get(dreamIndex - 1);
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

    public void saveDreamToRepository(Dream dream, String repoType) {
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
                new Dream(15, 7, "Sueño en un bosque", 6));

        List<Dream> dreamsP2 = Arrays.asList(
                new Dream(12, 9, "Sueño de caer al vacío", 5),
                new Dream(20, 6, "Sueño con extraterrestres", 9));

        List<Dream> dreamsP3 = Arrays.asList(
                new Dream(8, 4, "Sueño con un océano infinito", 7));

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
        // logica para registrar el sueño, recuerden cambiar los tipos de los atributos
    }

    public String analyzeDream(String analyzer, Dream Dream) {
        if (approachFactory == null) {
            return null;
        } else {
            switch (analyzer) {
                case Constants.COGNITIVE:
                    return approachFactory.getCognitiveAnalyzer().analyzeDream();
                case Constants.EMOTIONAL:
                    return approachFactory.getEmotionalAnalyzer().analyzeDream();
                case Constants.STATISTICAL:
                    return approachFactory.getStatisticalAnalyzer().analyzeDream();
                case Constants.SYMBOLIC:
                    return approachFactory.getSymbolicAnalyzer().analyzeDream();
            }
        }
        return null;
    }

    
    public String getSystemConfig(String configKey) {
        return systemSetting.get(configKey);
    }

    public void setSystemConfig(String configKey, String configValue) {
        systemSetting.set(configKey, configValue);
    }

    public String createReport(String dreamAnaliced) {
        // logica para crear el reporte, recuerden cambiar los tipos de los atributos
        return "aqui va el reporte del sueño analizado";
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public void changeApproach(String approach) {
        this.approachFactory = factoryProvider.getFactory(approach);
    }
    
    public String[] getAllConfigKeys() {
        return systemSetting.getAllKeys();
    }

    public boolean existApproach(){
        return approachFactory != null;
    }
}
