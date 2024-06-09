package logica;

import java.time.LocalDateTime;
import jdk.jfr.Timestamp;

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

    public Ticket_pesaje() {
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
        
        this.setBalanza_id(balanza_id);
        this.setEmpresa_id(empresa_id);
        this.setFecha_hora(fecha_hora);
        this.setPatente_c(patente_c);
        this.setPeso_v(peso_v);
        this.setObs(obs);
    }
    
     public void registrar_ticket_camion_ll(int balanza_id,int empresa_id, int prod, String patente_a,double peso_ll, String obs)
    {
        this.setBalanza_id(balanza_id);
        this.setEmpresa_id(empresa_id);
        this.setProd_id(prod);
        this.setPatente_a(patente_a);
        this.setPeso_ll(peso_ll);
        this.setObs(obs);
    }
}
