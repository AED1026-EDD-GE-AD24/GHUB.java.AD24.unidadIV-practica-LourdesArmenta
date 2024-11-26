package arboles;

public class ClienteMainArbolBinarioBusqueda {
    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol =new ArbolBinarioBusqueda();
        try{

            arbol.insertar(new Entero(10));
            arbol.insertar(new Entero(15));
            arbol.insertar2(new Entero(30));
            arbol.insertar2(new Entero(5));
            arbol.insertar2(new Entero(2));
            arbol.insertar2(new Entero(1));
            arbol.insertar2(new Entero(10));

        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
        //Recorridos
        System.out.println("\n Recorrido Postorden");
        arbol.postorden();
        System.out.println("\n Recorrido Inorden");
        arbol.inorden();
        System.out.println("\n Recorrido Preorden");
        arbol.preordenIterativo();
        System.out.println();
        System.out.println("\n Recorrido por Niveles");
        arbol.recorridoPorNiveles();
        System.out.println();
        System.out.println("Recorrido Jerarquico");
        BTreePrinter.printNode(arbol.getRaiz());
        System.out.println();

        //eliminando algunos elementos
        arbol.eliminar(new Entero(1));

        BTreePrinter.printNode(arbol.getRaiz());
        System.out.println();

        arbol.eliminar(new Entero(15));

        BTreePrinter.printNode(arbol.getRaiz());
        System.out.println();

        try{
            arbol.insertar2(new Entero(6));
            arbol.insertar2(new Entero(8));

        }catch(Exception e){

        }

        BTreePrinter.printNode(arbol.getRaiz());
        System.out.println();

        arbol.eliminar(new Entero(10));

        BTreePrinter.printNode(arbol.getRaiz());
        System.out.println();

        Nodo aux =arbol.buscar(new Entero(6));
        if(aux ==null)
            System.out.println("NO ENCONTRADO");
        else
            System.out.println("ELEMENTO ENCONTRADO: "+aux.getValor());

        aux =arbol.buscar(new Entero(16));
        if(aux ==null)
            System.out.println("NO ENCONTRADO");
        else
            System.out.println("ELEMENTO ENCONTRADO: "+aux.getValor());
            












        
    }
    
}
