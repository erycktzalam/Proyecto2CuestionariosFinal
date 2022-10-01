package com.proyecto2.proyecto2cuestionarios;

import java.util.ArrayList;

public class Cuestionario {

    private static int correlativo = 1;
    private int id;
    private int pin;
    private String titulo;
    private String descripcion;
    private boolean registrado;
    private boolean activado;
    public static ArrayList<Pregunta> preguntas;

    public Cuestionario(String titulo, String descripcion) {
        id = correlativo;
        pin = 0;
        this.titulo = titulo;
        this.descripcion = descripcion;
        registrado = true;
        activado = false;
        preguntas = new ArrayList<>();
        correlativo++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void agregarPreguntas(Pregunta p) {
        preguntas.add(p);
    }

    public static int getCorrelativo() {
        return correlativo;
    }

    public static void setCorrelativo(int correlativo) {
        Cuestionario.correlativo = correlativo;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isRegistrado() {
        return registrado;
    }

    public void setRegistrado(boolean registrado) {
        this.registrado = registrado;
    }

    public boolean isActivado() {
        return activado;
    }

    public void setActivado(boolean activado) {
        this.activado = activado;
    }
    public static ArrayList<Pregunta> getPreguntas() {
        return preguntas;
    }
    public static void setPreguntas(ArrayList<Pregunta> preguntas) {
        Cuestionario.preguntas = preguntas;
    }

    @Override
    public String toString() {
        return "Cuestionario{" +
                "id=" + id +
                ", pin=" + pin +
                ", titulo='" + titulo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", registrado=" + registrado +
                ", activado=" + activado +
                '}';
    }
}
