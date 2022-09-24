package com.proyecto2.proyecto2cuestionarios;

import java.util.ArrayList;

public class Pregunta {

    private String pregunta;
    private int tiempo;
    private int puntos;
    private ArrayList<Respuesta> respuestas;

    public Pregunta(String pregunta, int tiempo, int puntos, ArrayList<Respuesta> respuestas) {
        this.pregunta = pregunta;
        this.tiempo = tiempo;
        this.puntos = puntos;
        this.respuestas = new ArrayList<>();
    }

    public void agregarRespuesta (Respuesta r){
        this.respuestas.add(r);
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
}
