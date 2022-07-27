package com.example.computerbbdd;
public class Computer {
    private int id;
    private String marca;
    private String cpu;
    private String os;
    private float precio;

    // Constructor de un objeto Contactos

    public Computer(int id, String marca, String cpu, String os, float precio) {
        this.id = id;
        this.marca = marca;
        this.cpu = cpu;
        this.os = os;
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
