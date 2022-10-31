/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Jinete;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class JineteBD {
    
   private static Connection con = null;
   private static Statement stmt = null;
   private static ResultSet rset = null;
    
    public static Jinete getJinete(String usuario, String contrasenia){
    
        
        try{
            con = Conexion.getConnection();
            
            stmt = con.createStatement();
        
        String sql = "SELECT * FROM JINETE WHERE USUARIO = '"+ usuario + "' AND CONTRASENA = '" + contrasenia+"'";
            
            rset = stmt.executeQuery(sql);
            rset.next();
           
       Jinete jinete = new Jinete(rset.getInt(1), rset.getString(2), rset.getFloat(3), Herramienta.dateToGregorianCalendar(rset.getDate(4)), rset.getString(5), rset.getInt(6), usuario, contrasenia);
        
        
        
        return jinete;
        
        
        }catch(Exception e){
            
            System.out.println("Error al obtener el jinete");
            
        }
        
    
       return null;
    
    }
    
    public static void introducirVictorias(int victorias, Jinete jinete){
        
       try {
           stmt = con.createStatement();
           
           String sql = "UPDATE JINETE SET VICTORIAS_TOTAL = "+ victorias+" WHERE USUARIO = '"+ jinete.getUsuario() + "' AND CONTRASENA = '" + jinete.getContrasenia()+"'";
           
           System.out.println(jinete.getContrasenia());
           
           stmt.executeUpdate(sql);
           
       } catch (SQLException ex) {
           Logger.getLogger(JineteBD.class.getName()).log(Level.SEVERE, null, ex);
       }
        
        
    }
    
    public static void cerrar(){
       try {
           stmt.close();
           rset.close();
       } catch (SQLException ex) {
           Logger.getLogger(CaballoDB.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
}
