package model.prototype;

public class Dream implements Prototype<Dream> {
    private String name;
    private int duration;
    private int visualLight;
    private String narrative;

    public Dream(String name, int duration, int visualLight, String narrative) {
        this.name = name;
        this.duration = duration;
        this.visualLight = visualLight;
        this.narrative = narrative;
    }

    private Dream(Dream dream) {
        this.name = dream.name;
        this.duration = dream.duration;
        this.visualLight = dream.visualLight;
        this.narrative = dream.narrative;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getVisualLight() {
        return visualLight;
    }

    public String getNarrative() {
        return narrative;
    }

    public void modifyName(String name) {
        this.name = name;
    }

    public void modifyDuration(int duration) {
        this.duration = duration;
    }

    public void modifyVisualLight(int visualLight) {
        this.visualLight = visualLight;
    }

    public void modifyNarrative(String narrative) {
        this.narrative = narrative;
    }

    @Override
    public Dream clone() {
        return new Dream(this);
    }
}
