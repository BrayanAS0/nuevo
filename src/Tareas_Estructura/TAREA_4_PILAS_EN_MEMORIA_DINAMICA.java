
/*Crear una estructura PILA usando LA CLASE STACK DE JAVA CON SUS METODOS YA DEFINIDOS, para hacer un programa en java con los opciones
del menú que llamen a los métodos:

static Stack <Integer> pila = new Stack <Integer> ();



Crea PILA

De Vacía PILA true o false

De Inserta elemento en la PILA

De borrar elemento de la PILA

Imprimir todos los elementos de  la PILA.

Imprimir el elemento del tope de la PILA.

Imprimir la cantidad de elementos de la PILA.

Menú principal que llame a los métodos anteriores, entendiendo que para borrar se tiene que validar el método de vació antes de borrar. */
package Tareas_Estructura;

import javax.swing.*;
import java.util.Scanner;
import java.util.Stack;

public class TAREA_4_PILAS_EN_MEMORIA_DINAMICA {
    static Scanner s= new Scanner(System.in);
    static Stack<Integer> pila ;
    public static  void crear_pila(){
        pila=new Stack <Integer> ();
    }
    public static boolean preguntar_si_esta_vacia(){
        if(pila.isEmpty()){
            return true;
        }else return false;

    }
    public static void insetar(){
        System.out.println("Inserte el numero que dese agregar a la pila");
        int numero=s.nextInt();
        pila.push(numero);

    }
    public static void eliminar(){
        if(pila.isEmpty()){
            System.out.println("La pila esta vacia");
        }else {
            System.out.println("Elemto que se eliminara "+pila.peek());
            pila.pop();
        }
    }
    public static void imprimir_pila(){
        if(pila.isEmpty()) {
            System.out.println("La pila esta vacia");
        }else {
            System.out.println(pila);
        }

    }
    public static void imprimir_el_ultimo_de_la_pila(){
        if(pila.isEmpty()) {
            System.out.println("La pila esta vacia");
        }else {
            System.out.println("El ultimo elemento de la pila es " + pila.peek());
        }
    }
    public static void tamano_de_la_pila(){
        if(pila.isEmpty()) {
            System.out.println("La pila esta vacia");
        }else {
            System.out.println(pila.size());
        }

    }

    public static void menu(){
        Scanner s = new Scanner(System.in);

        System.out.println("Elige una opcion\n" +
                "1.Crear una PILA \n" +
                "2.Preguntar si la PILA esta vacia\n" +

                "4.Insertar un elemento en la PILA\n" +
                "5.Borrar elemento de la PILA\n" +
                "6.Imprimir los elementos de la PILA\n" +
                "7.Imprimir el tope de la PILA\n" +
                "8.Imprimir la cantidad de elementos que contiene la PILA\n" +
                "Si ninguna de estas opciones es la que necesitas escribe otro numero");
        int opcion=s.nextInt();
        if(opcion==1 ){
            crear_pila();
            menu();
        }
        else if(opcion== 2 ){
            System.out.println(preguntar_si_esta_vacia());
            menu();
        }
        else if(opcion== 4 ){
     insetar();
            menu();
        }
        else if(opcion== 5 ){
           eliminar();
            menu();

        }
        else if(opcion== 6 ){
            imprimir_pila();
            menu();
        }  else if(opcion== 7 ){
      imprimir_el_ultimo_de_la_pila();
            menu();
        }
        else if(opcion== 8 ) {
          tamano_de_la_pila();
            menu();
        }
        else {
            System.out.println("Saliendo del programa");
        }
    }

    public static void main(String[] args) {
menu();
    }
}
