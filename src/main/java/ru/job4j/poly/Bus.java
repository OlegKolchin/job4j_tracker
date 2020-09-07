package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void ride() {
        System.out.println("Мы едем, едем, едем");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("В автобусе " + passengers + " пассажиров.");
    }

    @Override
    public int refuel(int amount) {
        int liter = 40;
        int price = amount * liter;
        return price;
    }
}
