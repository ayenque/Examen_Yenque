package com.upc.examen_yenque.entidades;

import java.util.Date;

public class Letra {

    private int id;
    private String serie;
    private int correlativo;
    private String ruc;
    private String razonSocial;
    private String numUnico;
    private double nimporte;
    private String fecEmision;
    private String fecVencimiento;
    private String comentario;

    public Letra(String serie, int correlativo, String ruc, String razonSocial, String numUnico, double nimporte, String fecEmision, String fecVencimiento, String comentario) {
        this.serie = serie;
        this.correlativo = correlativo;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.numUnico = numUnico;
        this.nimporte = nimporte;
        this.fecEmision = fecEmision;
        this.fecVencimiento = fecVencimiento;
        this.comentario = comentario;
    }

    public Letra(int id, String serie, int correlativo, String ruc, String razonSocial, String numUnico, double nimporte, String fecEmision, String fecVencimiento, String comentario) {
        this.id = id;
        this.serie = serie;
        this.correlativo = correlativo;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.numUnico = numUnico;
        this.nimporte = nimporte;
        this.fecEmision = fecEmision;
        this.fecVencimiento = fecVencimiento;
        this.comentario = comentario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getCorrelativo() {
        return correlativo;
    }

    public void setCorrelativo(int correlativo) {
        this.correlativo = correlativo;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNumUnico() {
        return numUnico;
    }

    public void setNumUnico(String numUnico) {
        this.numUnico = numUnico;
    }

    public double getNimporte() {
        return nimporte;
    }

    public void setNimporte(double nimporte) {
        this.nimporte = nimporte;
    }

    public String getFecEmision() {
        return fecEmision;
    }

    public void setFecEmision(String fecEmision) {
        this.fecEmision = fecEmision;
    }

    public String getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(String fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}


