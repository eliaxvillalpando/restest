package com.examen.demo;

import java.util.Date;

public class Incidencia {

    private int id;
    private int id_operador;
    private Date fecha;
    private boolean estatus = true;

    public Incidencia() {
    }

    public Incidencia(int id_operador, Date fecha, boolean estatus) {
        this.id_operador = id_operador;
        this.fecha = fecha;
        this.estatus = estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_operador() {
        return id_operador;
    }

    public void setId_operador(int id_operador) {
        this.id_operador = id_operador;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEstatus() {
        return estatus;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

}
