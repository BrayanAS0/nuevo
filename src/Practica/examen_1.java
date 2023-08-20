// Nombre: Brayan Arias Sanchez
//Matricula: 16586095
//materia Estructura de Datos
package Practica;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class examen_1 {
    Scanner s = new Scanner(System.in);
    LinkedList<Integer> cola1 = new LinkedList<>();
    LinkedList<Integer> cola2 = new LinkedList<>();
    Stack<Integer> pila = new Stack<>();
    Stack<Integer> pila_temporal = new Stack<>();

    public void agregar() {
        System.out.println("clinete que llegara a cola 1");
        cola1.add(s.nextInt());
    }

    public void borrar_de_cola1() {
        if (!cola1.isEmpty()) {
            pila.push(cola1.poll());
        } else {
            System.out.println("cola 1 esta vacia");
        }
    }

    public void borrar_de_pila1() {
        if (!pila.isEmpty()) {
            System.out.println("elemto que quieres eliminar de pila 1");
            int dato_que_quiero_borrars = s.nextInt();

            if (pila.peek() == dato_que_quiero_borrars) {
                System.out.println("se mandara a cola 2" + (cola2.add(pila.pop())));
            } else {
                int tamaño = pila.size();
                for (int i = 0; i < tamaño; i++) {
                    if (pila.peek() == dato_que_quiero_borrars) {
                        break;
                    } else {
                        pila_temporal.push(pila.pop());
                    }
                }
                System.out.println("expulsado de la pila : " + pila.pop());
                tamaño = pila_temporal.size();

                for (int i = 0; i < tamaño; i++) {
                    pila.push(pila_temporal.pop());
                }
            }
        } else {
            System.out.println("pila esta vacia");
        }
    }

    public void borrar_de_cola2() {
        if (!cola2.isEmpty()) {
            System.out.println(cola2.poll());
        } else {
            System.out.println("cola 2 esta vacia");

        }
    }

    public void imrpimir_pila() {
        if (!pila.isEmpty()) {
            System.out.println(pila);
        } else {
            System.out.println("la pila esta vacia ");
        }
    }

    public void imprimir_cola1() {
        if(!cola1.isEmpty()){
        System.out.println(cola1);
        }else{
            System.out.println("la cola 1 esta vacia");
        }

    }

    public void imprimir_cola2() {
        if(!cola2.isEmpty()) {
            System.out.println(cola2);
        }else {
            System.out.println("cola 2 esta vacia");
        }
    }

    public void tamaño() {
        System.out.println("Tamaño de pila :" + pila.size());
        System.out.println("Tamaño de cola 1  :" + cola1.size());
        System.out.println("Tamaño de cola 2 :" + cola2.size());

    }

    public void primer_elemeto_de_cola1() {
        if (!cola1.isEmpty()) {
            System.out.println("Primer elemto de cola 1 : " + cola1.getFirst());
        } else {
            System.out.println("cola 1 esta vacia");
        }
    }

    public void primer_elemeto_de_cola2() {
        if (!cola2.isEmpty()) {
            System.out.println("Primer elemto de cola 2 : " + cola2.getFirst());
        } else {
            System.out.println("cola 2 esta vacia");
        }
    }

    public void ultimo_elemeto_de_pila() {
        if (!pila.isEmpty()) {
            System.out.println("Ultimo elelemto de pila : " + pila.peek());
        } else {
            System.out.println("pila esta vacia");
        }
    }

    public void ultimo_elemeto_de_cola() {
        if (!cola1.isEmpty()) {
            System.out.println("Ultimo elelemto de cola : " + cola1.getLast());
        } else {
            System.out.println("cola 1 esta vacia");
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        examen_1 p = new examen_1();
        int opc;
        do {

            System.out.println("1.Método que permita la llegada de CLIENTES a una COLA1 para que sea atendido en ese orden. \n" +
                    "" +
                    "2.Método que borre de la COLA1 e inserte ese cliente en una PILA de tipo de datos igual. \n" +
                    "" +
                    "3.Método que borre un elemento de la PILA, con la premisa que si es el del tope(último elemento insertado) " +
                    "\nsimplemente se borra y se manda a la COLA2 (SE PUEDE IMPRIMIR SI LO DESEAN) , si no es el del tope, sacar elemento de la PILA " +
                    "\ny pasarlo a otra clase PILA TEMPORAL hasta eliminar el elemento indicado, después regresar de la PILATEMPORAL a la PILA. \n" +
                    "" +
                    "4.Método que borra de la COLA2 y lo mande a imprimir. \n" +

                    "5.Método para imprimir la PILA. \n" +

                    "6.Método para imprimir la COLA1. \n" +

                    "7.Método para imprimir la COLA2 \n" +

                    "8.Método para imprimir el tamaño de la PILA y de la COLA1 y COLA2. \n" +

                    "9.Método para imprimir el primer elemento insertado de la COLA1 \n" +

                    "10.Método para imprimir el primer elemento de la COLA2. \n" +

                    "11.Método para imprimir el último elemento insertado de la PILA. \n" +

                    "12.Método para imprimir el último elemento insertado en la COLA. \n" +
                    "13.Salir");
            opc = s.nextInt();
            switch (opc) {
                case 1:
                    p.agregar();
                    break;
                case 2:
                    p.borrar_de_cola1();
                    break;
                case 3:
                    p.borrar_de_pila1();
                    break;
                case 4:
                    p.borrar_de_cola2();
                    break;
                case 5:
                    p.imrpimir_pila();
                    break;
                case 6:
                    p.imprimir_cola1();
                    break;
                case 7:
                    p.imprimir_cola2();
                    break;
                case 8:
                    p.tamaño();
                    break;
                case 9:
                    p.primer_elemeto_de_cola1();
                    break;
                case 10:
                    p.primer_elemeto_de_cola2();
                    break;
                case 11:
                    p.ultimo_elemeto_de_pila();
                    break;
                case 12:
                    p.ultimo_elemeto_de_cola();
                    break;
                case 13:
                    System.out.println("saliendo del progama");
                    break;
                default:
                    System.out.println("intente otra opcion");
            }
        } while (opc != 13);
    }
}
