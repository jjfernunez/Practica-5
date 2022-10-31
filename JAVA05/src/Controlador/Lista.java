/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Lista {
    
    ArrayList lista = new ArrayList();
    
    
    public Lista(){
        
        
        
    }
    
    public void getCaballo(int codJinete){
        try{
        Connection con = Conexion.getConnection();
        
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        
        String sql = "SELECT * FROM Caballo WHERE jiCodigo = " + codJinete;
        
        ResultSet rset = stmt.executeQuery(sql);
        
        lista.clear();
        
        while(rset.next()){
            lista.add(new Caballo(rset.getInt(1), rset.getInt(2), rset.getString(3), rset.getFloat(4), Herramienta.dateToGregorianCalendar(rset.getDate(5)), rset.getInt(6), rset.getInt(7)));
        }
        
        
        rset.close();
        stmt.close();
        
        }catch(Exception e){
            System.out.println("Error");
        }
        
        
        
    }
    
    public ArrayList getLista(){
        return lista;
    }
}
