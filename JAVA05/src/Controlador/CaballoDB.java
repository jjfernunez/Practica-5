
package Controlador;

import Modelo.Caballo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author alumno
 */
public class CaballoDB {
    
   private static Connection con = null;
   private static Statement stmt = null;
   private static ResultSet rset = null;
   
   
   public static Caballo getCaballo(int jiCodigo){
       
       
       
       try{
        con = Conexion.getConnection();
            
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        
        String sql = "SELECT * FROM CABALLO WHERE JICODIGO = "+ jiCodigo ;
            
        rset = stmt.executeQuery(sql);
           
        rset.next();
           
        
       Caballo caballo = new Caballo(rset.getInt(1), rset.getInt(2),rset.getString(3), rset.getFloat(4), Herramienta.dateToGregorianCalendar(rset.getDate(5)), rset.getInt(6), rset.getInt(7));
      rset.next();
      
       return caballo;
         }catch(Exception e){
            
            System.out.println("Error al obtener el jinete");
            
        }
       
       
       return null;
   }
   
   public static String[] getCaballoArray(int jiCodigo){
       
      
       
       try{
            con = Conexion.getConnection();
            
            stmt = con.createStatement();
        
        String sql = "SELECT * FROM CABALLO WHERE JICODIGO = "+ jiCodigo ;
               
            rset = stmt.executeQuery(sql);
           
    
    String[] array = new String[10];
    int cont = 0;
    Caballo caballo;
       while( rset.next()){
           
           caballo = new Caballo(rset.getInt(1), rset.getInt(2),rset.getString(3), rset.getFloat(4), Herramienta.dateToGregorianCalendar(rset.getDate(5)), rset.getInt(6), rset.getInt(7));
           array[cont]= caballo.toString();
           
           cont++;
       }
           
        
        rset.close();
       stmt.close();
       return array;
         }catch(Exception e){
            
            System.out.println("Error al obtener el caballo");
            
            return null;
        }
       
       
   }
   
  
   public static Caballo getCaballoSiguiente(){
       try{
        

            Caballo caballo = new Caballo(rset.getInt(1), rset.getInt(2),rset.getString(3), rset.getFloat(4), Herramienta.dateToGregorianCalendar(rset.getDate(5)), rset.getInt(6), rset.getInt(7));
            rset.next();


        return caballo;
        
       }catch(Exception e){
           System.out.println("Error al avanzar");
           
       }
       return null;
   }
   
   public static Caballo getCaballoAnterior(){
       try{
       
       
       Caballo caballo = new Caballo(rset.getInt(1), rset.getInt(2),rset.getString(3), rset.getFloat(4), Herramienta.dateToGregorianCalendar(rset.getDate(5)), rset.getInt(6), rset.getInt(7));
        rset.previous();
       
       return caballo;
       
       }catch(Exception e){
           System.out.println("Error al retrasar");
       }
       return null;
   }
   
   
   public static boolean compruebaSiguiente(){
       try{
           rset.next();
           Caballo caballo = new Caballo(rset.getInt(1), rset.getInt(2),rset.getString(3), rset.getFloat(4), Herramienta.dateToGregorianCalendar(rset.getDate(5)), rset.getInt(6), rset.getInt(7));
       if(caballo == null){
           rset.previous();
           return false;
       }
       else {
           rset.previous();
           return true;
       }
       }catch(Exception e){
           System.out.println("Error");
       }
      
       return false;
   }
    public static boolean compruebaAnterior(){
       try{
           rset.previous();
           Caballo caballo = new Caballo(rset.getInt(1), rset.getInt(2),rset.getString(3), rset.getFloat(4), Herramienta.dateToGregorianCalendar(rset.getDate(5)), rset.getInt(6), rset.getInt(7));
       if(caballo == null){
           rset.next();
           return false;
       }
       else{
           rset.next();
           return true;
       }
       }catch(Exception e){
           System.out.println("Error");
       }
       
       return false;
   }
      public static Caballo devolverPrimero(){
       try{
           rset.first();
           Caballo caballo = new Caballo(rset.getInt(1), rset.getInt(2),rset.getString(3), rset.getFloat(4), Herramienta.dateToGregorianCalendar(rset.getDate(5)), rset.getInt(6), rset.getInt(7));
       
      return caballo;
       }catch(Exception e){
           System.out.println("Error");
       }
       
       return null;
   }

    
   public static Caballo devolverUltimo(){
       try{
           rset.last();
           Caballo caballo = new Caballo(rset.getInt(1), rset.getInt(2),rset.getString(3), rset.getFloat(4), Herramienta.dateToGregorianCalendar(rset.getDate(5)), rset.getInt(6), rset.getInt(7));
       
      return caballo;
       }catch(Exception e){
           System.out.println("Error");
       }
       
       return null;
   }

   public static void cerrar(){
       try {
           stmt.close();
           rset.close();
       } catch (SQLException ex) {
           Logger.getLogger(CaballoDB.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   
   
    public static void modificarFechaVictorias(int idCaballo, GregorianCalendar fecha, int vic) {
       try {
           stmt = con.createStatement();
           
           String sql = "UPDATE CABALLO SET VICTORIAS = "+ vic +" WHERE ID = "+idCaballo;
           String sql2 = "UPDATE CABALLO SET FECHA_NAC = '"+fecha.get(Calendar.MONTH)+"/"+fecha.get(Calendar.DAY_OF_MONTH)+"/"+fecha.get(Calendar.YEAR)+"' WHERE ID = "+idCaballo;
           
           
           stmt.executeUpdate(sql);
           stmt.executeUpdate(sql2);
       } catch (SQLException ex) {
           
       }
        
        
    }
}
