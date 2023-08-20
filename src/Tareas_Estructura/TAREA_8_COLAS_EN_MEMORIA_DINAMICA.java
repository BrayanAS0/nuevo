package Tareas_Estructura;

import java.util.LinkedList;
import java.util.Scanner;

public class TAREA_8_COLAS_EN_MEMORIA_DINAMICA {
    /*Desarrollar un programa en JAVA que maneje una
    COLA usando memoria dinámica con la clase

            LINKEDLIST

    LinkedList<Integer> cola= new LinkedList<Integer>();



    Y los métodos de:

    Crear la cola

    Verificar si esta vacia

    Insertar un elemento al final de la cola

    Borrar un elemento del inicio de la cola

    Imprimir todos los elementos de la cola

    Imprimir el primer elemento insertado

    Imprimir el último elemento insertado

    Imprimir la cantidad de elementos (tamaño) de la cola*/
    static LinkedList<Integer> cola ;
    static Scanner s= new Scanner(System.in);
    public static boolean preguntar_si_vacia(){
        return cola.isEmpty();
    }
    public static void insertar(){

        System.out.println("Valor que quieres  ingresar");
        cola.add(s.nextInt());
    }
    public static void eliminar(){
        if(!cola.isEmpty()){
            System.out.println(cola.poll());
        }else{
            System.out.println("la cola esta vacia");
        }
    }
    public static void imprimir_toda_la_cola(){
        System.out.println(cola);
    }
    public static void imprimir_el_ultimo(){
        System.out.println(cola.getLast());
    }
    public static void tamaño_cola(){
        System.out.println(cola.size());
    }
    public static void imprimir_primero(){
        System.out.println(cola.getFirst());
    }
    public static boolean contains(){
        System.out.println("Valor que buscas en la cola");
        int loquebuca=s.nextInt();
       return cola.contains(loquebuca);
    }
    public static void borrar_todo(){
        cola.clear();
    }
    public static  void crear_cola(){
        cola= new LinkedList <Integer> ();
    }
    public static void menu(){
   /*
    Y los métodos de:

    Crear la cola

    Verificar si esta vacia

    Insertar un elemento al final de la cola

    Borrar un elemento del inicio de la cola

    Imprimir todos los elementos de la cola

    Imprimir el primer elemento insertado

    Imprimir el último elemento insertado

    Imprimir la cantidad de elementos (tamaño) de la cola*/
        int opcion;
        do {
            System.out.println("Ingrese la opcion\n" +
                    "1.Insertar un elemento al final de la cola\n" +
                    "2.Borrar un elemento del inicio de la cola\n" +
                    "3.Verificar si esta vacia\n" +
                    "4.Buscar un elemento en la cola\n" +
                    "5.crear cola\n" +
                    "6.Imprimir todos los elementos de la cola\n" +
                    "7.imprimir el primero elemento\n" +
                    "8.Imprimir el último elemento insertado\n" +
                    "9.Imprimir la cantidad de elementos (tamaño) de la cola\n" +
                    "10.Borrar todo\n"+
                    "11.Salir del programa");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:

                    insertar();
                    break;
                case 2:
                    eliminar();
                    break;
                case 3:
                    System.out.println(preguntar_si_vacia());
                    break;
                case 4:
                    System.out.println(contains());
                    break;
                case 5:
                    crear_cola();
                    break;
                case 6:
                   imprimir_toda_la_cola();
                    break;
                case 7:
                    imprimir_primero();
                    break;
                case 8:
                    imprimir_el_ultimo();
                    break;
                case 9:
                    tamaño_cola();
                    break;
                case 10:
                   borrar_todo();
                    break;
                case 11:
                    System.out.println("saliendo del programa");
                    break;
                default:
                    System.out.println("Inserte de nuevo");
            }

        }
        while (opcion != 11);
    }

    public static void main(String[] args) {
        menu();
    }
}
