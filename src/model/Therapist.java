package model;

import model.factoryMethod.AbstractProductRepository;

public class Therapist {

    private int id;
    private String name;
    private int age;


    public Therapist(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /*public void analyzeAndStoreDream(Dream dream, AbstractProductRepository repository) {
        repository.saveDream(dream);
        System.out.println("Therapist " + name + " stored the dream in " + repository.getClass().getSimpleName());
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}