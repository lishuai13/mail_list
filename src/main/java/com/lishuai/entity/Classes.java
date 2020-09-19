package com.lishuai.entity;

public class Classes {
    private int classesId;
    private String classesName;
    private String description;

    public Classes() {
    }

    public Classes(int classesId, String classesName, String description) {
        this.classesId = classesId;
        this.classesName = classesName;
        this.description = description;
    }

    public int getClassesId() {
        return classesId;
    }

    public void setClassesId(int classesId) {
        this.classesId = classesId;
    }

    public String getClassesName() {
        return classesName;
    }

    public void setClassesName(String classesName) {
        this.classesName = classesName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
