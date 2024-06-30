package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import persistencia.Conexion;
import java.sql.*;

public class Categoria_prod {
    
    private int categ_id;
    private String descrip;
    private Connection conect;
    private Conexion cn;
    private PreparedStatement ps;
    
    
    
    public Categoria_prod() throws SQLException {
        
        ps = null;
        cn = new Conexion();         
        }            
    

    public Categoria_prod(int categ_id, String descrip) {
        this.categ_id = categ_id;
        this.descrip = descrip;
    }

    public int getCateg_id() {
        return categ_id;
    }

    public void setCateg_id(int categ_id) {
        this.categ_id = categ_id;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    
    public void listarCateg() throws SQLException {
        
        ResultSet resultSet = null;
        
        System.out.println("Listado de Categorías");
        Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_balanza", "root", "root");
        String consultaSQL = "select * from categoria_prod order by categ_id";
       
        try (PreparedStatement sentencia = cn.prepareStatement(consultaSQL);){
        
            resultSet = sentencia.executeQuery();
                       
             while (resultSet.next()) {
                int id = resultSet.getInt("categ_id");
                String descrip = resultSet.getString("descrip");              
                System.out.print(id);
                System.out.println(" - " + descrip + "    ");
                
             }
                
        }         
          cn.close();
    }
    
    public void insertarCateg(String descripcion)  {  
                    
               String consultaSQL = "insert into categoria_prod (descrip) values (?)";
               try{
                ps = cn.conectarBD().prepareStatement(consultaSQL);            
                ps.setString(1, descripcion);
                ps.executeUpdate();
                System.out.println("La Categoría fue agregada con éxito");  
               } catch(SQLException e){
                   System.err.println("Error al guardar " + e.getMessage());
               }finally {
               ps = null;
               cn.close();
               }            
    }
    
    public void modificarCateg(int categ_id, String categ_descrip) throws SQLException {
        
        ResultSet resultSet = null;
        int res = 0;
        String consultaSQL = "select * from categoria_prod where categ_id =  " + categ_id;   
       
        try {                
            ps = cn.conectarBD().prepareStatement(consultaSQL);                      
            resultSet = ps.executeQuery();          
            
            if(!resultSet.next()){
                
                System.out.println("La categoría no existe en la base de datos");
            }else
            {      
              
                String consultaSQLup = "update categoria_prod set descrip = '"+categ_descrip+"' where categ_id= " + categ_id;
                ps = cn.conectarBD().prepareStatement(consultaSQLup); 
               
                res= ps.executeUpdate();
                
                if (res>0){
                     System.out.println("La categoría se ha modificado correctamente");
                }
                                            
            }
        }catch (SQLException e){
                   System.err.println("Error al guardar " + e.getMessage());
               }finally {
               ps = null;
               cn.close();
               }           
    } 
    
    public void eliminarCateg(int categ_id) throws SQLException {
        
        ResultSet resultSet = null;
        int res = 0;
        String consultaSQL = "select * from categoria_prod where categ_id =  " + categ_id;
         
        try {                
                ps = cn.conectarBD().prepareStatement(consultaSQL);   
                                  
                resultSet = ps.executeQuery();         
            
            if(!resultSet.next()){
                
                System.out.println("La categoría no existe en la base de datos");
            }else
            {             
                String consultaSQLup = "delete from categoria_prod where categ_id= " + categ_id;
                ps = cn.conectarBD().prepareStatement(consultaSQLup); 
               
                res= ps.executeUpdate();
                
                if (res>0){
                     System.out.println("La categoría se ha eliminado correctamente");
                }
                                            
            }
        }catch (SQLException e){
                   System.err.println("Error al guardar " + e.getMessage());
               }finally {
               ps = null;
               cn.close();
               }
    }         
}