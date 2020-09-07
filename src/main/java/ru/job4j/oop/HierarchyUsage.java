package ru.job4j.oop;

public class HierarchyUsage {
    public static void main(String[] args) {
        Car car = new Car();
        Transport tp = car;
        java.lang.Object obj = car;
        java.lang.Object ocar = new Car();
        Car carFromObject = (Car) ocar;

        java.lang.Object bycicle = new Bicycle();
        Car cb = (Car) bycicle;
    }
}
