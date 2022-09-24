package com.proyecto2.proyecto2cuestionarios;

import java.util.ArrayList;

public class Cuestionario {

    private int pin;
    private String titulo;
    private String descripcion;
    private boolean registrado;
    private ArrayList<Pregunta> preguntas;

    public Cuestionario (String titulo, String descripcion){
        pin = 0;
        this.titulo = titulo;
        this.descripcion = descripcion;
        registrado = true;
        this.preguntas = new ArrayList<>();
    }

    public void agregarPreguntas (Pregunta p){
        this.preguntas.add(p);
    }

}
