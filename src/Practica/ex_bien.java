package Practica;

import java.util.LinkedList;
import java.util.Scanner;

public class ex_bien {
    Scanner s = new Scanner(System.in);
    LinkedList<Integer> cola = new LinkedList<Integer>();
    LinkedList<Integer> pila = new LinkedList<Integer>();

    public void agregar() {
        System.out.println("Numero");
        cola.add(s.nextInt());
    }

    public boolean pila_contiene() {
        System.out.println("valor que buscas en la pila");
        return pila.contains(s.nextInt());
    }


    public void borrar_cola_primero() {
        pila.push(cola.poll());
    }

    public void imprimir_cola_y_pila() {
        System.out.println("Cola");
        System.out.println(cola);
        System.out.println("pila");
        System.out.println(pila);
    }

    public void eliminar_de_pila() {
        if (pila.isEmpty()) {
            System.out.println("pila esta vacia");
        } else {
            pila.pop();

        }
    }
    public  void  tamaño_cola_y_pila(){
        System.out.println("tamaño de cola :"+cola.size());
        System.out.println("tamaño de pila :"+pila.size());
    }
    public void primer_elemento_cola(){
        System.out.println("Primer elemento de cola"+cola.getFirst());
    }
    public void ultimo_elemento_cola(){
        System.out.println("Ultimo elemento de cola"+cola.getLast());
    }
    public void ultimo_elemento_de_pila(){
        System.out.println("ultimo elemento de pila: "+pila.peek());
    }

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        ex_bien p= new ex_bien();
        int opc;


        do{
            System.out.println("1.Agregar \n" +
                    "2.Borrar \n" +
                    "3.Eliminar de pila el ultimo\n" +
                    "4.Imprimir cola y pila\n" +
                    "5.Imprimir tamaño de pila y cola\n" +
                    "6.Imprimir ultimo elemento de cola\n" +
                    "7.Imprimir primero de cola\n" +
                    "8.Imprimir el ultimo de pila\n" +
                    "9.salir" +
                    "");
            opc=s.nextInt();
            switch (opc){
                case 1:
                    p.agregar();
                    break;
                case 2:
                    p.borrar_cola_primero();
                    break;
                case 3:
                    p.eliminar_de_pila();
                    break;
                case 4:
                    p.imprimir_cola_y_pila();
                    break;
                case 5:
                    p.tamaño_cola_y_pila();
                    break;
                case 6:
                    p.ultimo_elemento_cola();
                    break;
                case 7:
                    p.primer_elemento_cola();
                    break;
                case 8:
                    p.ultimo_elemento_de_pila();
                    break;
                case 9:
                    System.out.println("saliendo del programa");
                    break;
                default:
                    System.out.println("intente de nuevo");
            }
        }while (opc!=9);
    }
}