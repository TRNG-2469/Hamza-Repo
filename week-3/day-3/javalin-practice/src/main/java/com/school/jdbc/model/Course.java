package com.school.jdbc.model;

public class Course {

    private int id;
    private String code;
    private String title;
    private int credits;

    public Course() {
    }

    public Course(int id, String code, String title, int credits) {
        this.id = id;
        this.code = code;
        this.title = title;
        this.credits = credits;
    }

    public Course(String code, String title, int credits) {
        this(0, code, title, credits);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "Course{id=" + id + ", code='" + code + "', title='" + title
                + "', credits=" + credits + '}';
    }
}
