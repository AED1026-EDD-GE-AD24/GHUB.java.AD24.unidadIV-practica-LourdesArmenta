package arboles;

public class ArbolBinarioBusqueda  extends ArbolBinario{
    public ArbolBinarioBusqueda(){
        super();
    }
    public ArbolBinarioBusqueda(Nodo raiz){
        super(raiz);
    }
    public void insertar(Object valor) throws Exception{
        Comparable dato = (Comparable)valor;
        Nodo nuevo = new Nodo();
        nuevo.setValor(dato);
        if (raiz == null){
            raiz = nuevo;
        }else{
            //anterior: referencia al padre de aux
            Nodo anterior = null;
            //aux : auxiliar que va recorriendo los nodos, desde la raiz
            Nodo aux = raiz;
            while( aux != null){
                anterior = aux;
                if(dato.esMenor(aux.getValor()))
                   aux = aux.getIzquierdo();
                else if (dato.esMayor(aux.getValor()))
                   aux = aux.getDerecho();
                else    
                   throw new Exception("Dato Duplicado");
            }
            if(dato.esMayor(anterior.getValor()))
               anterior.setIzquierdo(nuevo);
            else  
               anterior.setDerecho(nuevo);
        }



    }

    
}
