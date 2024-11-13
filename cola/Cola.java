package cola;
public class Cola <T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola; 
    private int tamanio;
    //constructor por defecto
    public Cola() {
        cabeza = null;
        cola = null;
        tamanio = 0;
    }

    //Devuelve el total de elementos de la cola
    public int getTamanio() {
        return tamanio;
    }

    //Verifica si la cola esta vacia
    public boolean esVacia(){
        return (cabeza==null);
         
    }

    //Encola un elemento nuevo
    public void encolar(T valor){
        //Crear un nuevo nodo
        Nodo<T> nuevo = new Nodo<T>();
        //fijar el valor dentro del nodo
        nuevo.setValor(valor);

        if(this.esVacia()){
            //cabeza y la cola apuntan al nuevo elemento
            cabeza=nuevo;
            cola =nuevo;
        }else{
            //se enlaza el campo siguiente de la cola con el nuevo elemento
            cola.setSiguiente(nuevo);
            cola = nuevo;
        }
        //incremntar el tamaño porque se agregó un nuevo elemento
        tamanio++;

    }

    //Elimina el primer elemento de la cola
    public void desencolar(){
        if (!esVacia()){
            //verificar si solo hay un elemento en la cola
            if(cabeza==cola){
                cabeza=null;
                cola=null;
            }else{
                //se elimina el primer elemento de la cola
                //desplazando la cabeza al siguiente nodo
                cabeza=cabeza.getSiguiente();
            }
            tamanio--;

        }
    }

    //Devuelve al primer elemento de la cola
    //si esta vacia regresa un null
    public T frente(){
        if (!esVacia()){
            return cabeza.getValor();
        }else{
            return null;
        }

    }
}
    
    