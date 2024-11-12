package arboles;

public class ArbolBinario {
    protected Nodo raiz;

    public ArbolBinario(){
        this.raiz = null;
    }
    public ArbolBinario(Nodo raiz){
        this.raiz = raiz;
    }

    public Nodo getRaiz() {
        return raiz;
    }
    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }
    //invoca al metodo recursivo
    public void preorden(){
        preorden(raiz);
    
    }

    private void preorden(Nodo aux){
        if (aux !=null){
            visitar(aux);
            preorden(aux.getIzquierdo());
            preorden(aux.getDerecho());
        }
    }

    private void visitar(Nodo aux){
        System.out.println(aux.getValor()+" ");

    }

    public void inorden(){
        inorden(raiz);
    }

    private void inorden(Nodo aux){
        if (aux !=null){
            inorden(aux.getIzquierdo());
            visitar(aux);
            inorden(aux.getDerecho());
        }
    }

    public void postorden(){
        postorden(raiz);
    }

    public void postorden(Nodo aux){
     if (aux !=null){
            postorden(aux.getIzquierdo());
            postorden(aux.getDerecho());
            visitar(aux);
        }
    }




    
}
