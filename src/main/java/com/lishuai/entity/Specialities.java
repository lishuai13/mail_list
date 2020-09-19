package com.lishuai.entity;

/**
 * 专业信息
 */
public class Specialities {

    private int specialitiesId;
    private String specialitiesName;
    private String description;

    public Specialities() {
    }

    public Specialities(int specialitiesId, String specialitiesName, String description) {
        this.specialitiesId = specialitiesId;
        this.specialitiesName = specialitiesName;
        this.description = description;
    }

    public int getSpecialitiesId() {
        return specialitiesId;
    }

    public void setSpecialitiesId(int specialitiesId) {
        this.specialitiesId = specialitiesId;
    }

    public String getSpecialitiesName() {
        return specialitiesName;
    }

    public void setSpecialitiesName(String specialitiesName) {
        this.specialitiesName = specialitiesName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
