package arboles;

public class TestComparable {
    public static void main(String[] args) {
        Estudiante e1 = new Estudiante(1234,"Pito Perez");
        Estudiante e2 = new Estudiante(1200," Monica Naranjo");
        if(e1.esIgual(e2))
           System.out.println("El estudiante "+e1.getNombre()
                +" tiene el mismo codigo que "+e2.getNombre());
        else if(e1.esMayor(e2))
             System.out.println("El estudiante "+e1.getNombre()
                +" es Mayor que el codigo de"+e2.getNombre());
        else
            System.out.println("El estudiante "+e1.getNombre()
            +" es Menor que el codigo de"+e2.getNombre());

        Entero ent1 = new Entero(80);
        Entero ent2 = new Entero(100);
        if (ent1.esIgual(ent2))
           System.out.println("Son iguales");
        else if (ent1.esMayor(ent2))
            System.out.println("Es mayor");
        else
            System.out.println("Es menor");



        
    }
    
}
