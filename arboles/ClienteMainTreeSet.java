package arboles;

import java.util.TreeSet;
import java.util.Iterator;

public class ClienteMainTreeSet {
    public static void main(String[] args) {
        TreeSet<Integer> t = new TreeSet<>();
        if(t.isEmpty())
            System.out.println("El arbol esta vacio");

        //añadir algunos elementos
        t.add(5);
        t.add(3);
        t.add(9);
        t.add(2);
        t.add(5);

        System.out.println(t.contains(5));
        System.out.println(t.contains(12));

        System.out.println("Tamanio: "+t.size());
        System.out.println("Utilizando Iteradores");
        for(Iterator<Integer> it = t.iterator(); it.hasNext();){
            System.out.println(it.next());
        }

        System.out.println("Utilizando for each");
        for(Integer i:t){
            System.out.println(i);
        }

        //eliminar algunos elementos
        t.remove(5);
        t.remove(12);
        System.out.println("Tamanio: "+t.size());

        System.out.println(t.first());
        System.out.println(t.last());

        //Un TreeSet de Estudiante
        TreeSet<Persona> t1 = new TreeSet<>();
        //añadir algunos objetos estudiantes
        t1.add(new Persona(5,"Zulema"));
        t1.add(new Persona(2,"Ana"));
        t1.add(new Persona(1,"Carlos"));
        t1.add(new Persona(3,"Felipe"));

        System.out.println("Utilizando Iteradores");
        for(Iterator<Persona> it = t1.iterator(); it.hasNext();){
            System.out.println(it.next());
        }

        System.out.println("Utilizando for each");
        for(Persona i:t1){
            System.out.println(i);
        }







        
    }
    
}
