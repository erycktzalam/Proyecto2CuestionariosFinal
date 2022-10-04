package com.proyecto2.proyecto2cuestionarios;

import java.util.ArrayList;

public class Pregunta {

    private String pregunta;
    private int tiempo;
    private int puntos;

    public static ArrayList<Respuesta> respuestas;

    public Pregunta(String pregunta, int tiempo, int puntos) {
        this.pregunta = pregunta;
        this.tiempo = tiempo;
        this.puntos = puntos;
        respuestas = new ArrayList<>();
    }

    public void agregarRespuesta (Respuesta r){
        respuestas.add(r);
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

    public int obtenerTamanioArrayRespuestas (){
        int size = respuestas.size();
        return size;
    }

    public String obtenerRespuestas (){
        String r1 = null;
        for (Respuesta respuesta : respuestas){
            respuesta.getRespuesta();
        }
        return null;
    }

    public boolean obtenerCorrecta (){
        boolean r2 = false;
        for (Respuesta respuesta : respuestas){
            respuesta.isCorrecta();
        }
        return r2;
    }
    @Override
    public String toString() {
        return "Pregunta{" +
                "pregunta='" + pregunta + '\'' +
                ", tiempo=" + tiempo +
                ", puntos=" + puntos +
                '}';
    }
}
