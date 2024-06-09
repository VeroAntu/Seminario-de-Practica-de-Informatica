package logica;

public class Categoria_prod {
    
    private int categ_id;
    private String descrip;

    public Categoria_prod() {
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
    
       
}
