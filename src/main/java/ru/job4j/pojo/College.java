package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Oleg Kolchin");
        student.setGroup(1);
        student.setAdmission(new Date());
        System.out.println(student.getName() + System.lineSeparator() +  student.getGroup()
                + System.lineSeparator() + student.getAdmission());
    }
}
