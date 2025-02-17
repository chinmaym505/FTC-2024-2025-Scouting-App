package com.example.ftcscouting;

import java.util.List;

public class Team {
    private String name;
    private boolean auto;
    private int autoSpecimens;
    private int autoSamples;
    private boolean teleOp;
    private int teleOpSpecimens;
    private int teleOpSamples;
    private List<String> notes;

    public Team(String name, boolean auto, int autoSpecimens, int autoSamples, boolean teleOp, int teleOpSpecimens, int teleOpSamples, List<String> notes) {
        this.name = name;
        this.auto = auto;
        this.autoSpecimens = autoSpecimens;
        this.autoSamples = autoSamples;
        this.teleOp = teleOp;
        this.teleOpSpecimens = teleOpSpecimens;
        this.teleOpSamples = teleOpSamples;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public boolean isAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }

    public int getAutoSpecimens() {
        return autoSpecimens;
    }

    public void setAutoSpecimens(int autoSpecimens) {
        this.autoSpecimens = autoSpecimens;
    }

    public int getAutoSamples() {
        return autoSamples;
    }

    public void setAutoSamples(int autoSamples) {
        this.autoSamples = autoSamples;
    }

    public boolean isTeleOp() {
        return teleOp;
    }

    public void setTeleOp(boolean teleOp) {
        this.teleOp = teleOp;
    }

    public int getTeleOpSpecimens() {
        return teleOpSpecimens;
    }

    public void setTeleOpSpecimens(int teleOpSpecimens) {
        this.teleOpSpecimens = teleOpSpecimens;
    }

    public int getTeleOpSamples() {
        return teleOpSamples;
    }

    public void setTeleOpSamples(int teleOpSamples) {
        this.teleOpSamples = teleOpSamples;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }
}
