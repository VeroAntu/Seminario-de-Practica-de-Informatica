package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {
    
   private Connection cn;
   private Conexion conec;

   public Conexion() {
        cn = null;
   }

    public Connection conectarBD() {
        try{
            cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_balanza", "root", "root");
                
            return cn;
            
        }catch (Exception e){
            
            System.out.println("Conexión Fallida" +e);
                           
        }
        return cn;
    }
    
    public void close(){
        try{
            cn.close();
            
        }catch(SQLException e){
             System.err.println("Error al guardar " + e.getMessage());
            }
    }
    
    public Conexion getInstance(){
        
        if(conec == null){
            conec = new Conexion();
            
        }
        
        return conec;
    }
}
