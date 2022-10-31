/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.GregorianCalendar;

/**
 *
 * @author alumno
 */
public class Jinete {
    
    private int codigo;
    private String nombre;
    private float sueldo;
    private GregorianCalendar fechaNac;
    private String foto;
    private int victoriasTotal;
    private String usuario;
    private String contrasenia;
    
    
    public Jinete(){
        
    }
    
    public Jinete(int codigo, String nombre, float sueldo, GregorianCalendar fecha, String foto, int victoriasTotal, String usuario, String contrasenia){
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.fechaNac = fecha;
        this.foto = foto;
        this.victoriasTotal = victoriasTotal;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        
        
        
    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the sueldo
     */
    public float getSueldo() {
        return sueldo;
    }

    /**
     * @param sueldo the sueldo to set
     */
    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
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
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * @return the victoriasTotal
     */
    public int getVictoriasTotal() {
        return victoriasTotal;
    }

    /**
     * @param victoriasTotal the victoriasTotal to set
     */
    public void setVictoriasTotal(int victoriasTotal) {
        this.victoriasTotal = victoriasTotal;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contrasenia
     */
    public String getContrasenia() {
        return contrasenia;
    }

    /**
     * @param contrasenia the contrasenia to set
     */
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    @Override
    public String toString(){
        
        String res =this.nombre + this.sueldo;
        
        return res;
        
    }
    
    
}
