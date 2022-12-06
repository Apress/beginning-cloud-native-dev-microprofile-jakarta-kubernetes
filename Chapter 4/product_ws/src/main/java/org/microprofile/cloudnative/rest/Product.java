package org.microprofile.cloudnative.rest;

public class Product {
    private Integer id;
    private String name;

    public Product() {
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

