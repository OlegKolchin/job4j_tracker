package ru.job4j.tracker;

public class Programmer extends Engineer {

    private String lang;

    public String spec(String language) {
        this.lang = language;
        return this.lang;
    }

    public void currentProjects(Project project) {
    }

}
