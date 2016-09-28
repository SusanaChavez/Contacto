package com.monti.contacto;

import java.util.Date;

/**
 * Created by Susana on 27/09/2016.
 */
public class Contacto {
    private String nombre;
    private Date fecha;
    private String telefono;
    private String email;
    private String descripcion;

    public Contacto(String nombre, Date fecha, String telefono, String email, String descripcion) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.telefono = telefono;
        this.email = email;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
