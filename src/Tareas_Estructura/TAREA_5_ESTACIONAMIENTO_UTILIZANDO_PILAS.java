/*Utilizando clases tipo  PILA(Lista LIFO) en memoria dinámica (STACK) desarrollar un programa en JAVA
que simule un problema del estacionamiento donde llegan y salen vehículos de manera que se tiene que hacer los métodos en JAVA de:

Crear de la clase Pila con objeto STRING dos PILAS(PILAPRIN Y PILATEMP) para poder manejar las placas de los vehículos.

Llegada de un vehículo al estacionamiento principal PILAPRIN. Se inserta en esa pila.

Salida de un vehículo del estacionamiento principal, si no es el del top (peek()) pasar los vehículos del
 estacionamiento principal(PILAPRIN) al estacionamiento temporal (PILATEMP) hasta encontrar el vehículo a
  borrar del estacionamiento principal. Después regresar los vehículos del estacionamiento temporal(PILATEMP)
   al estacionamiento principal (PILAPRIN)

Imprimir los vehículos del estacionamiento principal PILAPRIN

Indicar cuantos vehículos hay en el estacionamiento principal PILAPRIN

Mostrar el último elemento insertado en el estacionamiento principal (PILAPRIN)

Menú principal que mande llamar los métodos anteriores.





Es necesario utilizar los métodos ya definidos de la clase STACK y definir el objeto placa
de tipo string String placa; que es el que se usara para insertar y borrar los elementos de las pilas.



En el caso  de tipo string utilizar el método de comparación  pilaprin.peek().equalsIgnorecase(placa)
para saber si es el vehículo que se require borrar de la pila principal

El Nombre de PILAPRIN puede ser diferente, solo hace referencia a una pila definida preferentemente,
 con clase Stack */
package Tareas_Estructura;
import javax.swing.*;

import java.util.Stack;
public class TAREA_5_ESTACIONAMIENTO_UTILIZANDO_PILAS {
    static Stack<String> PILAPRIN =new Stack <String> ();
    static Stack<String> PILATEMP =new Stack <String> ();

    public static void salida_de_vehiculo() {
    /*    Salida de un vehículo del estacionamiento principal, si no es el del top (peek()) pasar los vehículos del
        estacionamiento principal(PILAPRIN) al estacionamiento temporal (PILATEMP) hasta encontrar el vehículo a
        borrar del estacionamiento principal. Después regresar los vehículos del estacionamiento temporal(PILATEMP)
        al estacionamiento principal (PILAPRIN)*/
        String el_que_saldra = JOptionPane.showInputDialog("Cual es el carro que va salir");
        if (!el_que_saldra.equalsIgnoreCase(PILAPRIN.peek())) {
            int contador=0;

PILATEMP= (Stack<String>) PILAPRIN.clone();
            for (int i = 0; i < PILAPRIN.size(); i++) {
                if (PILATEMP.peek().equalsIgnoreCase(el_que_saldra)) {
                    PILATEMP.pop();

                    break;
                } else {
                    PILATEMP.pop();
                    contador++;
                }

            }

            for (int j = 0; j < contador; j++) {
                PILATEMP.push(PILAPRIN.peek());
                PILAPRIN.pop();

            }
            PILAPRIN.pop();

            for (int j = 0; j <contador; j++) {
                PILAPRIN.push(PILATEMP.peek());
                PILATEMP.pop();
            }
        }else{
            PILAPRIN.pop();
        }
    }

    public static void insetar(){

        String numero=JOptionPane.showInputDialog("Inserte el numero que dese agregar a la pila");
        PILAPRIN.push(numero);

    }
    public static void imprimir_pila(){
       JOptionPane.showMessageDialog(null, PILAPRIN);

    }
    public static void tamaño_de_la_pila(){

        JOptionPane.showMessageDialog(null, PILAPRIN.size());
    }
public static void ultimo_ingresado(){

    JOptionPane.showMessageDialog(null, PILAPRIN.peek());
}
public static void menu() {

   /* Llegada de un vehículo al estacionamiento principal PILAPRIN. Se inserta en esa pila.

            Salida de un vehículo del estacionamiento principal, si no es el del top (peek()) pasar los vehículos del
    estacionamiento principal(PILAPRIN) al estacionamiento temporal (PILATEMP) hasta encontrar el vehículo a
    borrar del estacionamiento principal. Después regresar los vehículos del estacionamiento temporal(PILATEMP)
    al estacionamiento principal (PILAPRIN)

    Imprimir los vehículos del estacionamiento principal PILAPRIN

    Indicar cuantos vehículos hay en el estacionamiento principal PILAPRIN

    Mostrar el último elemento insertado en el estacionamiento principal (PILAPRIN)

    Menú principal que mande llamar los métodos anteriores. */
    int opcion;
    do {
        opcion = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion\n" +
                "1.Insetar\n" +
                "2.Salida de un vehiculo\n" +
                "3.Imprimir los vehiculos\n" +
                "4.Cuantos vehiculos ahi en el estacionamiento\n" +
                "5.El ultimo vehiculo insertado\n" +
                "6.Salir del programa"));
        switch (opcion) {
            case 1:

                insetar();
                break;
            case 2:
                salida_de_vehiculo();
                break;
            case 3:
                imprimir_pila();
                break;
            case 4:
                tamaño_de_la_pila();
                break;
            case 5:
                ultimo_ingresado();
                break;
            case 6:
                JOptionPane.showMessageDialog(null, "Saliendo del programa");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Inserte de nuevo");
        }

    } while (opcion != 6);
}
    public static void main(String[] args) {

        menu();
    }
}
