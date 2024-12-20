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

    /**
     * insertar2 es la interfaz de la operacion, llama al metodo
     * insertarRecursivo que realiza la operacion y devuelve la raiz del nuevo arbol
     * A este metodo interno que se le pasa la raiz actual, a partir del cual se
     * describe el camino de busqueda y al final, se enlaza en un arbol binario de busqueda
     * donde no hay duplicados, por ello si se encuentra un noso iagual quel que se
     * desea insertar, se lanza una excepcion
     * @param valor, valor a insertar
     * @throws Exception
     */
    public void insertar2(Object valor) throws Exception{
        Comparable dato = (Comparable)valor;
        raiz = insertarRec(raiz,dato);
    }
    /**
     * 
     * @param raizSub
     * @param dato a insertar
     * @return
     * @throws Exception, si el dato que se intenta insertar ya existe en el arbol
     */

    private Nodo insertarRec(Nodo raizSub, Comparable dato) throws Exception{
        if(raizSub == null){
            //caso base, termina la recursividad
            raizSub = new Nodo(dato);
        }else{
            if (dato.esMenor(raizSub.getValor())){
                Nodo iz = insertarRec(raizSub.getIzquierdo(),dato);
                raizSub.setIzquierdo(iz);
            }else{
                if(dato.esMayor(raizSub.getValor())){
                    Nodo dr = insertarRec(raizSub.getDerecho(), dato);
                    raizSub.setDerecho(dr);
                }
                else{
                    //Dato duplicado
                    throw new Exception("Nodo Duplicado");
                }
            }
        }
        return raizSub;
    }

    /**
     * 
     * @param valor, es el valor buscado
     * @return en nodo buscado si lo encuentra y si no retorna null
     */

    public Nodo buscar(Object valor){
        Comparable dato = (Comparable)valor;
        if(raiz == null)
           return raiz;
        else{
            //aux: auxiliar que va recorriendo los nodos, desde la raiz
            Nodo aux = raiz;
            while (aux !=null){
                if (dato.esIgual(aux.getValor()))
                   return aux;
                if(dato.esMenor(aux.getValor()))
                   aux = aux.getIzquierdo();
                else
                   aux = aux.getDerecho();

            }
            return null;
        }
    }

    /**
     * Interfaz de buscar que invoca el metodo recursivo
     * @param buscado
     * @return
     */

    public Nodo buscar2(Object buscado){
        Comparable dato = (Comparable) buscado;
        if (raiz == null)
           return null;
        else
           return localizar(raiz,dato);
    }

    private Nodo localizar(Nodo raizSub, Comparable buscado){
        if(raizSub == null)
           return null; //caso base
        else if(buscado.esIgual(raizSub.getValor()))
           return raizSub; //caso base
        else if(buscado.esMenor(raizSub.getValor()))
           return localizar(raizSub.getIzquierdo(), buscado);
        else
          return localizar(raizSub.getDerecho(), buscado);
    }

    public boolean eliminar(Object valor){
        Comparable dato = (Comparable)valor;
        //buscar el nodo a elimina y su antecedor
        Nodo antecesor = null; //antecesor del noso a eliminar
        //aux: auxiliar que va recorriendo los nodos, desde la raiz hasta
        // el nodo a eliminar
        Nodo aux = raiz; 
        while(aux !=null){
            if(dato.esIgual(aux.getValor()))
               break;
            antecesor = aux;
            if(dato.esMenor(aux.getValor()))
                aux = aux.getIzquierdo();
            else
                aux = aux.getDerecho();
        }
        //
        if(aux==null)
            return false;
        //si llega a este punto, el nodo a eliminar existe y es aux
        //y su antecesor es antecesor
        //Examinar cada caso
        //1. Si tiene al menos dos hijos, incluso una hoja, reajustas los
        //enlaces del antecesor
        if (aux.getIzquierdo() == null)
            if (((Comparable)aux.getValor()).esMenor(antecesor.getValor()))
               antecesor.setIzquierdo(aux.getDerecho());
            else
               antecesor.setDerecho(aux.getDerecho());
        else if(aux.getDerecho()==null)
            if (((Comparable)aux.getValor()).esMenor(antecesor.getValor()))
    
               antecesor.setIzquierdo(aux.getIzquierdo());
            else
               antecesor.setDerecho(aux.getIzquierdo());
        else
            //El nodo a eleminar tiene rama izquiera y rama derecha
            //2
            reemplazarPorMayorIzquierda(aux);
        
        aux =null;
        return true;

    }

    private void reemplazarPorMayorIzquierda(Nodo act){
         Nodo mayor=act;
       Nodo ant = act;
       mayor =act.getIzquierdo();
       //buscar el mayor de la rama izquierda
       //ant es el antecesor de mayor
       while(mayor.getDerecho() != null){
           ant = mayor;
           mayor =mayor.getDerecho();

       }
       act.setValor(mayor.getValor());//reemplazo
       //reajuste
       if (ant == act)
          ant.setIzquierdo(mayor.getIzquierdo());
       else
         ant.setDerecho(mayor.getIzquierdo());

    }

    
}
