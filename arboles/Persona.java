package arboles;
import java.lang.Comparable;

public class Persona implements Comparable<Persona>{

    private int codigo;
    private String nombre;

    public Persona(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona [codigo=" + codigo + ", nombre=" + nombre + "]";
    }

    @Override
    public int compareTo(Persona o) {
        /* 
        if (this.codigo == o.getCodigo())
            return 0;
        else if (this.codigo>o.getCodigo())
            return 1;
        else
            return -1;
        */
        if (this.nombre.equals(o.getNombre()))
            return 0;
        else if (this.nombre.compareTo(o.getNombre())>0)
           return 1;
        else
            return -1;
            

    }

    
    

    
}
