package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistencia.Conexion;

public class Producto {
    
    private int prod_id;
    private String descrip;
    private int categ;
    private Conexion cn;
    private PreparedStatement ps;

    public Producto() {
          ps = null;
        cn = new Conexion();
    }

    public Producto(int prod_id, String descrip, int categ) {
        this.prod_id = prod_id;
        this.descrip = descrip;
        this.categ = categ;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getCateg() {
        return categ;
    }

    public void setCateg(int categ) {
        this.categ = categ;
    }
    
     public void listarProd() throws SQLException {
        
        ResultSet resultSet = null;
        
        System.out.println("Listado de Productos");
        Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_balanza", "root", "root");
        String consultaSQL = "select * from producto order by prod_id";
        System.out.println("______________________________________________");
         System.out.println("CODIGO - CATEGORIA - DESCRIPCION");
         System.out.println("______________________________________________");
        try (PreparedStatement sentencia = cn.prepareStatement(consultaSQL);){
        
            resultSet = sentencia.executeQuery();
                       
             while (resultSet.next()) {
                int id   = resultSet.getInt("prod_id");
                int id_c = resultSet.getInt("categ_id");
                String descrip = resultSet.getString("descrip");              
                System.out.print("  " + id);
                System.out.print("    -    " + id_c + "   ");
                System.out.println("   -  " + descrip );
                
             }
                
        }         
          cn.close();
    }
    
    public void insertarProd(int categ_id, String descripcion)  {        
            
               String consultaSQL = "insert into producto (categ_id,descrip) values (?,?)";
               try{
                ps = cn.conectarBD().prepareStatement(consultaSQL);   
                ps.setInt(1, categ_id);
                ps.setString(2, descripcion);
                ps.executeUpdate();
                System.out.println("El Producto fue agregado con éxito");  
               } catch(SQLException e){
                   System.err.println("Error al guardar " + e.getMessage());
               }finally {
               ps=null;
               cn.close();
               }            
    }
    
    public void modificarProd(int prod_id, String prod_descrip) throws SQLException {
        
        ResultSet resultSet = null;
        int res = 0;
        String consultaSQL = "select * from producto where prod_id =  " + prod_id;   
       
        try {                
            ps = cn.conectarBD().prepareStatement(consultaSQL);                      
            resultSet = ps.executeQuery();          
            
            if(!resultSet.next()){
                
                System.out.println("El Producto no existe en la base de datos");
            }else
            {      
              
                String consultaSQLup = "update producto set descrip = '"+prod_descrip+"' where prod_id= " + prod_id;
                ps = cn.conectarBD().prepareStatement(consultaSQLup); 
               
                res= ps.executeUpdate();
                
                if (res>0){
                     System.out.println("El producto se ha modificado correctamente");
                }
                                            
            }
        }catch (SQLException e){
                   System.err.println("Error al guardar " + e.getMessage());
               }finally {
               ps = null;
               cn.close();
               }           
    }             
    
    public void eliminarProd(int prod_id) throws SQLException {
        
        ResultSet resultSet = null;
        int res = 0;
        String consultaSQL = "select * from producto where prod_id =  " + prod_id;
         
        try {                
                ps = cn.conectarBD().prepareStatement(consultaSQL);   
                                  
                resultSet = ps.executeQuery();         
            
            if(!resultSet.next()){
                
                System.out.println("El producto no existe en la base de datos");
            }else
            {      
              
                String consultaSQLup = "delete from producto where prod_id= " + prod_id;
                ps = cn.conectarBD().prepareStatement(consultaSQLup); 
               
                res= ps.executeUpdate();
                
                if (res>0){
                     System.out.println("El producto se ha eliminado correctamente");
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
