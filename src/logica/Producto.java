package logica;

public class Producto {
    
    private int prod_id;
    private String descrip;
    private int categ;

    public Producto() {
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
    
    
    
}
