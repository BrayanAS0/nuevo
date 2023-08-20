package Practica;

import java.util.Scanner;

public class pila_estatica {
    static Scanner s = new Scanner(System.in);

    static int[] pila;
    static int top = -1, tamaño;

    public static void crear_pila() {
        System.out.println("tamaño de pila");
        tamaño = s.nextInt();
        pila = new int[tamaño];

    }

    public static boolean pila_vacia() {
        if (top == -1) {
            System.out.println("Pila esta vacia");
            return true;

        } else {
            return false;
        }
    }

    public static boolean llena() {
        return top == tamaño;
    }

    public static void agregar() {
        if (!llena()) {

                top++;

                System.out.println("valor que quieres agregar");
                pila[top] = s.nextInt();

        } else {
            System.out.println("pila esta llena");
        }
    }

    public static void imprimir() {
        if (pila_vacia()==false) {
            for (int i = 0; i <= top ; i++) {
                System.out.println(pila[i]);
            }
        }
    }
    public static void eliminar(){
    if(!pila_vacia()){
        top--;
    } System.out.println("pila vacia");

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salida = false;
        while (!salida) {
            System.out.println("Eliga una opcion " +
                    "\n1.salida" +
                    "\n2.agregar" +
                    "\n3.crear pila" +
                    "\n4.imprimir" +
                    "\n5.eliminar " +
                    "\n6.Imprimir sueldo que sea mayor a tal sueldo " +
                    "\n7.Invertir" +
                    "\n8.Imprimir de un departamento en especifico" +
                    "\n9.Esta vacia " +
                    "\n10.Imprimir el primer elemento");
            int opcion = sc.nextInt();
            switch (opcion) {

                case 2:

                    agregar();
                    break;
                case 3:
                    crear_pila();
                    break;
                case 4:
                    imprimir();
                    break;
                case 5:
                    eliminar();
                    break;

                default:
                    System.out.println("opcion incorrecta");
            }
        }
    }
}
