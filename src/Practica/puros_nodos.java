package Practica;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/*La empresa ACME maneja información de sus clientes de manera que combina las clases de
 STACK PILA y PILA TEMPORAL Y LINKEDLIST COLA1 Y COLA 2, utilizando datos tipo integer
 (numero de turno); con todos sus métodos de insertar, borrar, consultar, vacío, etc..
  Desarrollar a partir de eso los siguientes métodos:

Método que permita la llegada de CLIENTES a una COLA1 para que sea atendido en ese orden.

Método que borre de la COLA1 e inserte ese cliente en una PILA de tipo de datos igual.

Método que borre un elemento de la PILA, con la premisa que si es el del tope(último elemento insertado)
simplemente se borra y se manda a la COLA2 (SE PUEDE IMPRIMIR SI LO DESEAN) , si no es el del tope, sacar elemento de la PILA y
 pasarlo a otra clase PILA TEMPORAL hasta eliminar el elemento indicado, después regresar de la PILATEMPORAL a la PILA.

Método que borra de la COLA2 y lo mande a imprimir.

Método para imprimir la PILA.

Método para imprimir la COLA1.

Método para imprimir la COLA2

Método para imprimir el tamaño de la PILA y de la COLA1 y COLA2.

Método para imprimir el primer elemento insertado de la COLA1

Método para imprimir el primer elemento de la COLA2.

Método para imprimir el último elemento insertado de la PILA.

Método para imprimir el último elemento insertado en la COLA. */
public class puros_nodos {

    public static class nodo {
      nodo siguinete, ultimo,inicio;
        nodo siguinete_cola2, ultimo_cola2,inicio_cola2;
        nodo siguinete_pila1, ultimo_pila1,inicio_pila1;
        nodo siguinete_pila_2, ultimo_pila_2,inicio_pila_2;
         LinkedList<Integer> cola2 = new LinkedList<>();
          Stack<Integer> pila1 = new Stack<>();
            Stack<Integer> pila2 = new Stack<>();
            Scanner s = new Scanner(System.in);
int numero;
        public nodo(int numero) {
this.numero=numero;
        }

        public nodo() {

        }

        public void agregar() {
            System.out.println("numero que quieres ingresar");
            int numero = s.nextInt();
        nodo nodo_de_info = new nodo(numero);
         /*      nodo_de_info.siguinete = ultimo;
            ultimo = nodo_de_info;*/  ///para tipo pila
              if(inicio==null){
        inicio=nodo_de_info;
        ultimo=nodo_de_info;
    }
            ultimo.siguinete=nodo_de_info;
            ultimo=nodo_de_info;
   // tamaño++;  //contador
        }

        public void eliminar_de_principal() {
            if(ultimo==inicio){
                inicio=null;
                ultimo=null;
            }else{
                inicio=inicio.siguinete;
            }
            pila1.push(ultimo.numero);
            //tamaño--;//para tamaño

      /*      pila1.push(ultimo.numero);
           ultimo=ultimo.siguinete;*/  //para tipo pila
        }

        public void imprimir_pila_temporal() {
            System.out.println(pila1);
        }
public  void impirmr_cola(){
    System.out.println(cola2);
}

public  void  impirmirnodo(){
            nodo auxiliar=ultimo;//si es tipo pila cambair a ultimo ya que inicio no existe en pila
            while (auxiliar!=null){
                System.out.println(auxiliar.numero);
                auxiliar=auxiliar.siguinete;
            }
}
public void metodo_del_3(){
    System.out.println("dato que quietes borrar");
int n=s.nextInt();

            if(pila1.peek()==n){
                System.out.println("antes de eliminar "+pila1.peek());
                cola2.add(pila1.pop());
                System.out.println("peek de pila 1  "+ cola2.getFirst());
            }
            else{
int tamaño= pila1.size();
                for (int i = 0; i < tamaño; i++) {
                    if(pila1.peek()==n){
                        pila1.pop();
                        break;
                    }else{
                        pila2.push(pila1.pop());
                    }
                }
                tamaño=pila2.size();
                for (int i = 0; i < tamaño; i++) {
                   pila1.push(pila2.pop());
                }
            }
}
        public void pila2_imprimir(){
            System.out.println(pila2);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        nodo n = new nodo();
        int op = 0;
        for (int i = 0; i <= 9; ) {
            System.out.println("Opcion que quieres hacer\n" +
                    "0.salir\n" +
                    "1.agregar\n" +
                    "2.eliminar de nodo el primero\n" +
                    "3.impimir pila\n" +
                    "4.imprimir nodo" +
                    "\n5.eliminar de pila 1\n" +
                    "6.imprimir pila 2\n" +
                    "7.imprimir cola ");
            op = s.nextInt();
            if (op == 1) {
                n.agregar();
            } else if (op == 2) {
                n.eliminar_de_principal();

            } else if (op == 0) {
                System.out.println("saliendo del programa");
                i = 10;

            } else if (op == 3) {
                n.imprimir_pila_temporal();
            } else if (op==4) {
               n.impirmirnodo();
            } else if (op==5) {
                n.metodo_del_3();
            }else if (op==6) {
           n.pila2_imprimir();
            }else if (op==7) {
               n.impirmr_cola();
            }

        }
    }
}
