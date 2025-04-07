package model;

public class Dream {
    private int duration;
    private int emotionalIntensity;
    private int visualLight;
    private String narrative;


    public Dream(int duration, int emotionalIntensity, String narrative, int visualLight) {
        this.duration = duration;
        this.emotionalIntensity = emotionalIntensity;
        this.narrative = narrative;
        this.visualLight = visualLight;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getEmotionalIntensity() {
        return emotionalIntensity;
    }

    public void setEmotionalIntensity(int emotionalIntensity) {
        this.emotionalIntensity = emotionalIntensity;
    }

    public int getVisualLight() {
        return visualLight;
    }

    public void setVisualLight(int visualLight) {
        this.visualLight = visualLight;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

}
