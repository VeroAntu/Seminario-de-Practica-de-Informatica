package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Empresa {
    
    private int empresa_id;
    private String razon_social;
    private String domicilio;
    private String cuit;
    private String tel;
    private String mail;
    private String web;
    private String cdad;
    private String pcia;

    public Empresa() {
    }

    public Empresa(int empresa_id, String razon_social, String domicilio, String cuit, String tel, String mail, String web, String cdad, String pcia) {
        this.empresa_id = empresa_id;
        this.razon_social = razon_social;
        this.domicilio = domicilio;
        this.cuit = cuit;
        this.tel = tel;
        this.mail = mail;
        this.web = web;
        this.cdad = cdad;
        this.pcia = pcia;
    }

    public int getEmpresa_id() {
        return empresa_id;
    }

    public void setEmpresa_id(int empresa_id) {
        this.empresa_id = empresa_id;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getCdad() {
        return cdad;
    }

    public void setCdad(String cdad) {
        this.cdad = cdad;
    }

    public String getPcia() {
        return pcia;
    }

    public void setPcia(String pcia) {
        this.pcia = pcia;
    }
    
    public void insertarEmpresa(String razonsocial, String domi,String cuit, String tel, String mail, String web, String cdad, String pcia) throws SQLException {
        
         System.out.println("insertar empr");
        String consultaSQL = "INSERT INTO empresa (razon_social,domicilio,cuit,tel,mail,web,cdad,pcia) VALUES (razonsocial,domi,cuit,tel,mail,web,cdad,pcia)";         
     
        
    }
}
