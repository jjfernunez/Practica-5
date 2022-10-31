/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Herramienta;
import java.util.GregorianCalendar;

/**
 *
 * @author alumno
 */
public class Caballo {
    
    private int id;
    private int jiCodigo;
    private String raza;
    private float precio;
    private GregorianCalendar fechaNac;
    private int altura;
    private int victorias;
            
    
    public Caballo(){
        
    }
    
    public Caballo(int id, int jiCodigo, String raza, float precio, GregorianCalendar fecha,int altura, int victorias){
        
        this.id = id;
        this.jiCodigo = jiCodigo;
        this.raza = raza;
        this.precio = precio;
        this.fechaNac = fecha;
        this.altura = altura;
        this.victorias = victorias;
        
        
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the jiCodigo
     */
    public int getJiCodigo() {
        return jiCodigo;
    }

    /**
     * @param jiCodigo the jiCodigo to set
     */
    public void setJiCodigo(int jiCodigo) {
        this.jiCodigo = jiCodigo;
    }

    /**
     * @return the raza
     */
    public String getRaza() {
        return raza;
    }

    /**
     * @param raza the raza to set
     */
    public void setRaza(String raza) {
        this.raza = raza;
    }

    /**
     * @return the precio
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    /**
     * @return the fechaNac
     */
    public GregorianCalendar getFechaNac() {
        return fechaNac;
    }

    /**
     * @param fechaNac the fechaNac to set
     */
    public void setFechaNac(GregorianCalendar fechaNac) {
        this.fechaNac = fechaNac;
    }

    /**
     * @return the altura
     */
    public int getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * @return the victorias
     */
    public int getVictorias() {
        return victorias;
    }

    /**
     * @param victorias the victorias to set
     */
    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }
    
    public String toString(){
        
        String res =""+ this.raza+", "+this.altura+", "+ Herramienta.gregorianCalendarToString(this.fechaNac)+", "+this.precio+", "+this.victorias ; 
        
        return res;
    }
    
}
