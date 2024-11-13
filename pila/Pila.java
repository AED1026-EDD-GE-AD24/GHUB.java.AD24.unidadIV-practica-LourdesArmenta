package pila;

public class Pila<T> {
    //atributos de la pila
    private Nodo<T> cabeza;
    private int tamanio;

    public Pila() {
        cabeza = null;
        tamanio = 0;

    }

   

    public int getTamanio() {
        return tamanio;
    }

    public boolean esVacia(){
        return (cabeza == null);
    }

    public void apilar(T valor){
        //Crear un nuevo Nodo
        Nodo<T> nodo = new Nodo<T>();
        //fijar el valor dentro de nodo
        nodo.setValor(valor);
        if (this.esVacia()){
            //Cabeza apunto al nuevo nodo
            cabeza = nodo;

        }else{
            //se enlaza el campo siguiebte de nuevo con la cabeza
            nodo.setSiguiente(cabeza);
            //la nueva cabeza de la pila pasa a ser nuevo
            cabeza = nodo;
        }
        tamanio++;
    }

    //Elimina un elemento de la pila
    public void retirar(){
        if (!esVacia()){
            cabeza = cabeza.getSiguiente();
            tamanio--;
        }
    }

    //Devuelve el elemento almacenado en el tope de la pila
    public T cima(){
        if (!esVacia())
           return cabeza.getValor();
        else 
           return null;
    }
   
    
}
