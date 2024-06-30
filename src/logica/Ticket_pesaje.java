package logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import jdk.jfr.Timestamp;
import persistencia.Conexion;

public class Ticket_pesaje {
    
    private int ticket_id;
    private int balanza_id;
    private int prod_id;
    private int empresa_id;
    private LocalDateTime fecha_hora;
    private String patente_c;
    private String patente_a;
    private Double peso_v;
    private Double peso_ll;
    private String obs;
    private Conexion cn;
    private PreparedStatement ps;

    public Ticket_pesaje() {
        
         ps = null;
         cn = new Conexion();
    }

    public Ticket_pesaje(int ticket_id, int balanza_id, int prod_id, int empresa_id, LocalDateTime fecha_hora, String patente_c, String patente_a, Double peso_v, Double peso_ll, String obs) {
        this.ticket_id = ticket_id;
        this.balanza_id = balanza_id;
        this.prod_id = prod_id;
        this.empresa_id = empresa_id;
        this.fecha_hora = fecha_hora;
        this.patente_c = patente_c;
        this.patente_a = patente_a;
        this.peso_v = peso_v;
        this.peso_ll = peso_ll;
        this.obs = obs;
    }

    public int getTicket_id() {
        return ticket_id;
    }

    public void setTicket_id(int ticket_id) {
        this.ticket_id = ticket_id;
    }

    public int getBalanza_id() {
        return balanza_id;
    }

    public void setBalanza_id(int balanza_id) {
        this.balanza_id = balanza_id;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public int getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public LocalDateTime getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(LocalDateTime fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public String getPatente_c() {
        return patente_c;
    }

    public void setPatente_c(String patente_c) {
        this.patente_c = patente_c;
    }

    public String getPatente_a() {
        return patente_a;
    }

    public void setPatente_a(String patente_a) {
        this.patente_a = patente_a;
    }

    public Double getPeso_v() {
        return peso_v;
    }

    public void setPeso_v(Double peso_v) {
        this.peso_v = peso_v;
    }

    public Double getPeso_ll() {
        return peso_ll;
    }

    public void setPeso_ll(Double peso_ll) {
        this.peso_ll = peso_ll;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
    public void registrar_ticket_camion_v(int balanza_id,int empresa_id, LocalDateTime fecha_hora, String patente_c,double peso_v, String obs)
    {       
         String consultaSQL = "insert into ticket_pesaje (balanza_id,empresa_id,patente_c,peso_v,obs) values (?,?,?,?,?)";
               try{
                ps = cn.conectarBD().prepareStatement(consultaSQL);   
                ps.setInt(1, balanza_id);
                ps.setInt(2, empresa_id);
                //ps.setDate(3, fecha);
                 
                ps.setString(3, patente_c);
                ps.setDouble(4, peso_v);
                ps.setString(5, obs);
                
                ps.executeUpdate();
                System.out.println("El Ticket fue agregado con éxito");  
               } catch(SQLException e){
                   System.err.println("Error al guardar " + e.getMessage());
               }finally {
               ps=null;
               cn.close();
               }              
    }
    
     public void registrar_ticket_camion_ll(int ticket_id, int prod, String patente_a,double peso_ll, String obs)
    {
       
        ResultSet resultSet = null;
        int res = 0;
        String consultaSQL = "select * from ticket_pesaje where ticket_id =  " + ticket_id;   
       
        try {                
            ps = cn.conectarBD().prepareStatement(consultaSQL);                      
            resultSet = ps.executeQuery();          
            
            if(!resultSet.next()){
                
                System.out.println("El ticket de pesaje ingresado no existe en la base de datos");
            }else
            {      
              
                String consultaSQLup = "update ticket_pesaje set prod_id = '"+prod+"',patente_a = '"+patente_a+"',peso_ll = '"+peso_ll+"', obs = '"+obs+"' where ticket_id= " + ticket_id;
                                                    
                ps = cn.conectarBD().prepareStatement(consultaSQLup); 
               
                res= ps.executeUpdate();
                
                if (res>0){
                     System.out.println("El ticket ha sido actualizado correctamente");
                }
                                            
            }
        }catch (SQLException e){
                   System.err.println("Error al guardar " + e.getMessage());
               }finally {
               ps = null;
               cn.close();
               }           
    }    
     
     public void listarTickets() throws SQLException {
        
        ResultSet resultSet = null;
        
        System.out.println("Listado de Tickets de Pesajes");
        Connection cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sistema_balanza", "root", "root");
        String consultaSQL = "select * from ticket_pesaje order by ticket_id";
        System.out.println("_________________________________________________________________________");
         System.out.println("NRO TICKET - PROD - EMPRESA - PATENTE C - PATENTE A - PESO V - PESO LL ");
         System.out.println("________________________________________________________________________");
        try (PreparedStatement sentencia = cn.prepareStatement(consultaSQL);){
        
            resultSet = sentencia.executeQuery();
                       
             while (resultSet.next()) {
                int id   = resultSet.getInt("ticket_id");
                int id_p = resultSet.getInt("prod_id");
                int id_e = resultSet.getInt("empresa_id");
                //LocalDateTime fecha = resultSet.getDate("fecha_hora");
                
                String patente_c = resultSet.getString("patente_c");
                String patente_a = resultSet.getString("patente_a");
                Double peso_v = resultSet.getDouble("peso_v");
                Double peso_ll = resultSet.getDouble("peso_ll");
                System.out.print("    " + id);
                System.out.print("    -     " + id_p + " ");
                System.out.print("    -  " + id_e + " ");
                System.out.print("  -   " + patente_c + " ");
                System.out.print("  - " + patente_a + " ");
                System.out.print("  - " + peso_v + " ");
                System.out.println("  - " + peso_ll);               
                
             }
                
        }         
          cn.close();
    }         
}
