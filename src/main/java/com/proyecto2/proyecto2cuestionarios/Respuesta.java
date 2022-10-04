package com.proyecto2.proyecto2cuestionarios;

public class Respuesta {

    private String respuesta;
    private boolean correcta;

    public Respuesta(String respuesta, boolean correcta) {
        this.respuesta = respuesta;
        this.correcta = correcta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "respuesta='" + respuesta + '\'' +
                ", correcta=" + correcta +
                '}';
    }
}
