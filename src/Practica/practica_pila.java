package Practica;

import java.util.Scanner;
import java.util.Stack;

public class practica_pila {
Scanner s= new Scanner(System.in);
    Stack<Integer> pila= new Stack<>();
    public void agregar(){
        System.out.println("Valor que quieres agregar a la pila");
        pila.push(s.nextInt());
    }
    public void eliminar(){
        pila.pop();
    }
    public void ultimo_ingresado(){
        System.out.println(pila.peek());

    }
    public  boolean esta_vacia(){
       return pila.isEmpty();
    }
    public   void tamaño_de_la_pila(){
        System.out.println(pila.size());
    }
   public boolean  verificar_si_esta_tal_dato(){
       System.out.println("cual dato vas a cerificar si esta");
        return pila.contains(s.nextInt());
   }
public void imprimir(){
    System.out.println(pila);
}
    public static void main(String[] args) {
        practica_pila pila= new practica_pila();
        Scanner s= new Scanner(System.in);
        int opcion;
        do{

            System.out.println("1.insertar\n" +
                    "2.eliminar\n" +
                    "3.verificar si esta vacia\n" +
                    "4.verificar si esta tal dato\n" +
                    "5.tamaño de la pila\n" +
                    "6.ultimo ingresado\n" +
                    "7.imprimir pila");
            opcion=s.nextInt();
            switch (opcion){
                case  1:
                    pila.agregar();
                    break;
                case 2:
                    pila.eliminar();
                    break;
                case 3:
                    System.out.println(pila.esta_vacia());
                    break;
                case 4:
                    System.out.println( pila.verificar_si_esta_tal_dato());
                    break;
                case 5:
                    pila.tamaño_de_la_pila();
                    break;
                case 6:
                    pila.ultimo_ingresado();
                    break;
                case 7:
                pila.imprimir();
                    break;
                default:
                    System.out.println("intete de nuevo");
            }
        }
        while (opcion!= 8);
    }
}
