package ru.job4j.dreamjob.model;

public class City {
    private final Integer id;
    private final String name;

    public City(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
