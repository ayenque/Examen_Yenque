package com.upc.examen_yenque.entidades;

import java.util.Date;

public class Letra {

    private int id;
    private String serie;
    private int correlativo;
    private int ruc;
    private String razonSocial;
    private String numUnico;
    private Date fecEmision;
    private Date fecVencimiento;
    private String comentario;

    public Letra(String serie, int correlativo, int ruc, String razonSocial, String numUnico, Date fecEmision, Date fecVencimiento, String comentario) {
        this.serie = serie;
        this.correlativo = correlativo;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.numUnico = numUnico;
        this.fecEmision = fecEmision;
        this.fecVencimiento = fecVencimiento;
        this.comentario = comentario;
    }

    public Letra(int id, String serie, int correlativo, int ruc, String razonSocial, String numUnico, Date fecEmision, Date fecVencimiento, String comentario) {
        this.id = id;
        this.serie = serie;
        this.correlativo = correlativo;
        this.ruc = ruc;
        this.razonSocial = razonSocial;
        this.numUnico = numUnico;
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

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
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

    public Date getFecEmision() {
        return fecEmision;
    }

    public void setFecEmision(Date fecEmision) {
        this.fecEmision = fecEmision;
    }

    public Date getFecVencimiento() {
        return fecVencimiento;
    }

    public void setFecVencimiento(Date fecVencimiento) {
        this.fecVencimiento = fecVencimiento;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}


