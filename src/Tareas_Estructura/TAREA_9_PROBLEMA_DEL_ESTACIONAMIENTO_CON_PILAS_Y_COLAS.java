package Tareas_Estructura;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*Desarrollar un programa en JAVA que contenga los métodos de :

. Definir o crear Clase COLA tipo string clase  linkedlist

. Definir o crear Clase PILA con tipo string  clase stack

. Alta de un vehículo en la COLA como estacionamiento principal

. Baja de un vehículo de la COLA si no es de los primeros insertados pasar temporalmente a la PILA hasta encontrar el vehículo deseado. Regresar de la PILA a la COLA.

Imprimir COLA

Imprimir PILA  (siempre estará vacía) */
public class TAREA_9_PROBLEMA_DEL_ESTACIONAMIENTO_CON_PILAS_Y_COLAS {
    static Scanner s = new Scanner(System.in);

   static LinkedList<String> cola;
    static Stack<String> pila;


    public static void crear_cola() {
        cola = new LinkedList<>();

    }

    public static void crear_pila() {
        pila = new Stack<>();
    }

    public static void dar_de_alta() {
        System.out.println("alta del vehiculo que quierede dar de alta en el estacionamiento");
        cola.add(s.next());
    }

    public static void dar_de_baja() {
        //Baja de un vehículo de la COLA si no es de los primeros insertados pasar temporalmente a la PILA hasta encontrar el vehículo deseado. Regresar de la PILA a la COLA.
        System.out.println("cual es el carro que va dar de baja");//preguntar el carro que quiere sacar
        String placa = s.next();
        int tamaño=cola.size();
        if (!cola.getFirst().equalsIgnoreCase(placa)) {//si el carro que quiere sacar no es el primero hacer los pasos

            for (int i = 0; i < tamaño ; i++) {//repetirse como el tamaño de la cola
                if(cola.getFirst().equalsIgnoreCase(placa)){// si el que buscas ya lo ayo
                  cola.poll();

break;//salirse del for
                }else{

                    pila.push(cola.getFirst());
                    cola.poll();

                }
            }// acabaa el for




            //termina el for
            int pilatamalo=pila.size();
            for (int j = 0; j < pilatamalo; j++) {//repetirse con el tamaño de la cola

                cola.addFirst(pila.pop());//quitar el first

            }

        } else {//si es el primero saca  inmediatamente si entrar al al if
            cola.poll();
        }

    }

    public static void imprimir_cola() {
        System.out.println(cola);
        }

    public static void imprimir_pila(){
        System.out.println(pila);
    }
public static void menu(){
    int opcion;
    do {
        System.out.println("Ingrese la opcion\n" +
                "1.Alta de un vehículo en la COLA como estacionamiento principal\n" +
                "2.Borrar un elemento de la cola\n" +
                "3.Crear cola\n" +
                "4.Crear pila\n" +
                "5.Salir del programa\n"+
                "6.Imprimir  cola\n" +
                "7.imprimir pila\n" );


        opcion = s.nextInt();
        switch (opcion) {
            case 1:

                dar_de_alta();
                break;
            case 2:
            dar_de_baja();
                break;
            case 3:
    crear_cola();
                break;
            case 4:
    crear_pila();
                break;
            case 5:
                System.out.println("saliendo del programa");
                break;
            case 6:
                imprimir_cola();
                break;
            case 7:
           imprimir_pila();
                break;

            default:
                System.out.println("Inserte de nuevo");
        }

    }
    while (opcion != 5);
}

    public static void main(String[] args) {
        menu();
    }
}
