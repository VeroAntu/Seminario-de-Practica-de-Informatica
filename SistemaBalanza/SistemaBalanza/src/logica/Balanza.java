package logica;

import java.util.Date;

public class Balanza {
    
    private int balanza_id;
    private String descrip;
    private int cap_max;
    private String modelo;
    private String marca;
    private String serie;
    private int precision;
    private String nro_cert;
    private Date fecha_vto_cert;
    private Date fecha_cert;

    public Balanza() {
    }

    public Balanza(int balanza_id, String descrip, int cap_max, String modelo, String marca, String serie, int precision, String nro_cert, Date fecha_vto_cert, Date fecha_cert) {
        this.balanza_id = balanza_id;
        this.descrip = descrip;
        this.cap_max = cap_max;
        this.modelo = modelo;
        this.marca = marca;
        this.serie = serie;
        this.precision = precision;
        this.nro_cert = nro_cert;
        this.fecha_vto_cert = fecha_vto_cert;
        this.fecha_cert = fecha_cert;
    }

    public int getBalanza_id() {
        return balanza_id;
    }

    public void setBalanza_id(int balanza_id) {
        this.balanza_id = balanza_id;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getCap_max() {
        return cap_max;
    }

    public void setCap_max(int cap_max) {
        this.cap_max = cap_max;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public String getNro_cert() {
        return nro_cert;
    }

    public void setNro_cert(String nro_cert) {
        this.nro_cert = nro_cert;
    }

    public Date getFecha_vto_cert() {
        return fecha_vto_cert;
    }

    public void setFecha_vto_cert(Date fecha_vto_cert) {
        this.fecha_vto_cert = fecha_vto_cert;
    }

    public Date getFecha_cert() {
        return fecha_cert;
    }

    public void setFecha_cert(Date fecha_cert) {
        this.fecha_cert = fecha_cert;
    }
    
    
    
}
