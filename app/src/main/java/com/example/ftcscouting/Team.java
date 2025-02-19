package com.example.ftcscouting;

import android.graphics.Bitmap;

import java.util.List;

public class Team {
    private String name;
    private boolean auto;
    private boolean autoSamples;
    private int autoSamplesCount;
    private String autoSamplesType;
    private boolean autoSpecimens;
    private int autoSpecimensCount;
    private String autoSpecimensType;
    private String autoParkingType;
    private int autoAscentLevel;
    private boolean teleOp;
    private boolean teleOpSamples;
    private int teleOpSamplesCount;
    private String teleOpSamplesType;
    private boolean teleOpSpecimens;
    private int teleOpSpecimensCount;
    private String teleOpSpecimensType;
    private boolean endGameAscent;
    private int endGameAscentLevel;
    private List<String> notes;
    private Bitmap drawing;

    public Team(String name, boolean auto, boolean autoSamples, int autoSamplesCount, String autoSamplesType, boolean autoSpecimens, int autoSpecimensCount, String autoSpecimensType, String autoParkingType, int autoAscentLevel, boolean teleOp, boolean teleOpSamples, int teleOpSamplesCount, String teleOpSamplesType, boolean teleOpSpecimens, int teleOpSpecimensCount, String teleOpSpecimensType, boolean endGameAscent, int endGameAscentLevel, List<String> notes, Bitmap drawing) {
        this.name = name;
        this.auto = auto;
        this.autoSamples = autoSamples;
        this.autoSamplesCount = autoSamplesCount;
        this.autoSamplesType = autoSamplesType;
        this.autoSpecimens = autoSpecimens;
        this.autoSpecimensCount = autoSpecimensCount;
        this.autoSpecimensType = autoSpecimensType;
        this.autoParkingType = autoParkingType;
        this.autoAscentLevel = autoAscentLevel;
        this.teleOp = teleOp;
        this.teleOpSamples = teleOpSamples;
        this.teleOpSamplesCount = teleOpSamplesCount;
        this.teleOpSamplesType = teleOpSamplesType;
        this.teleOpSpecimens = teleOpSpecimens;
        this.teleOpSpecimensCount = teleOpSpecimensCount;
        this.teleOpSpecimensType = teleOpSpecimensType;
        this.endGameAscent = endGameAscent;
        this.endGameAscentLevel = endGameAscentLevel;
        this.notes = notes;
        this.drawing = drawing;
    }

    // Getters and Setters for each property
    public Bitmap getDrawing() {
        return drawing;
    }
    public void setDrawing(Bitmap drawing) {
        this.drawing = drawing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }

    public boolean isAutoSamples() {
        return autoSamples;
    }

    public void setAutoSamples(boolean autoSamples) {
        this.autoSamples = autoSamples;
    }

    public int getAutoSamplesCount() {
        return autoSamplesCount;
    }

    public void setAutoSamplesCount(int autoSamplesCount) {
        this.autoSamplesCount = autoSamplesCount;
    }

    public String getAutoSamplesType() {
        return autoSamplesType;
    }

    public void setAutoSamplesType(String autoSamplesType) {
        this.autoSamplesType = autoSamplesType;
    }

    public boolean isAutoSpecimens() {
        return autoSpecimens;
    }

    public void setAutoSpecimens(boolean autoSpecimens) {
        this.autoSpecimens = autoSpecimens;
    }

    public int getAutoSpecimensCount() {
        return autoSpecimensCount;
    }

    public void setAutoSpecimensCount(int autoSpecimensCount) {
        this.autoSpecimensCount = autoSpecimensCount;
    }

    public String getAutoSpecimensType() {
        return autoSpecimensType;
    }

    public void setAutoSpecimensType(String autoSpecimensType) {
        this.autoSpecimensType = autoSpecimensType;
    }

    public String getAutoParkingType() {
        return autoParkingType;
    }

    public void setAutoParkingType(String autoParkingType) {
        this.autoParkingType = autoParkingType;
    }

    public int getAutoAscentLevel() {
        return autoAscentLevel;
    }

    public void setAutoAscentLevel(int autoAscentLevel) {
        this.autoAscentLevel = autoAscentLevel;
    }

    public boolean isTeleOp() {
        return teleOp;
    }

    public void setTeleOp(boolean teleOp) {
        this.teleOp = teleOp;
    }

    public boolean isTeleOpSamples() {
        return teleOpSamples;
    }

    public void setTeleOpSamples(boolean teleOpSamples) {
        this.teleOpSamples = teleOpSamples;
    }

    public int getTeleOpSamplesCount() {
        return teleOpSamplesCount;
    }

    public void setTeleOpSamplesCount(int teleOpSamplesCount) {
        this.teleOpSamplesCount = teleOpSamplesCount;
    }

    public String getTeleOpSamplesType() {
        return teleOpSamplesType;
    }

    public void setTeleOpSamplesType(String teleOpSamplesType) {
        this.teleOpSamplesType = teleOpSamplesType;
    }

    public boolean isTeleOpSpecimens() {
        return teleOpSpecimens;
    }

    public void setTeleOpSpecimens(boolean teleOpSpecimens) {
        this.teleOpSpecimens = teleOpSpecimens;
    }

    public int getTeleOpSpecimensCount() {
        return teleOpSpecimensCount;
    }

    public void setTeleOpSpecimensCount(int teleOpSpecimensCount) {
        this.teleOpSpecimensCount = teleOpSpecimensCount;
    }

    public String getTeleOpSpecimensType() {
        return teleOpSpecimensType;
    }

    public void setTeleOpSpecimensType(String teleOpSpecimensType) {
        this.teleOpSpecimensType = teleOpSpecimensType;
    }

    public boolean isEndGameAscent() {
        return endGameAscent;
    }

    public void setEndGameAscent(boolean endGameAscent) {
        this.endGameAscent = endGameAscent;
    }

    public int getEndGameAscentLevel() {
        return endGameAscentLevel;
    }

    public void setEndGameAscentLevel(int endGameAscentLevel) {
        this.endGameAscentLevel = endGameAscentLevel;
    }

    public List<String> getNotes() {
        return notes;
    }

    public void setNotes(List<String> notes) {
        this.notes = notes;
    }
}
