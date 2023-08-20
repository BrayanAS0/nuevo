package Practica;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

public class practica_12_marzo {
    practica_12_marzo siguiente,inicio,ultimo;
    Stack <Integer> pila= new Stack<>();
    LinkedList<Integer>cola = new LinkedList<>();
    int numero;
    int nodo_tamaño;
    public practica_12_marzo (){

    }
    public practica_12_marzo(int n){
        this.numero=n;
    }
    public void agregar_a_cola(){
        for (int i = 1; i < 10; i++) {
            cola.add(i);
        }

    }
    public void borrar_de_cola(){
        pila.push(cola.poll());
    }
    public void borrar_de_pila(){
        int dato=Integer.parseInt(JOptionPane.showInputDialog(null, "Dato que quires borrar de la pila\n"+pila));
        if(pila.contains(dato)&& pila.isEmpty()==false) {
            if (pila.peek() == dato) {
                pila.pop();
            }else{
                int tamaño=pila.size();
                for (int i = 0; i < tamaño; i++) {
                    if(pila.peek()==dato){
                        pila.pop();
                        break;
                    }else{
                        practica_12_marzo nodo= new practica_12_marzo(pila.pop());
                        if(inicio==null) {
                            inicio = nodo;
                            ultimo = nodo;
                            nodo_tamaño++;

                        }  else{
                               nodo.siguiente=ultimo;
                                ultimo=nodo;
                            nodo_tamaño++;
                            }

                    }
                }
                inicio=ultimo;
                while (inicio!=null){
                    pila.push(inicio.numero);
                    inicio=inicio.siguiente;
                    nodo_tamaño--;
                }

            }

        }//del contains
    }
    public void mostrar_pila(){
        JOptionPane.showMessageDialog(null, pila);
    }
    public void mostrar_cola(){
        JOptionPane.showMessageDialog(null, cola);
    }
    public void tamaños(){
        JOptionPane.showMessageDialog(null, "tamaño de nodo"+nodo_tamaño);
    }
    public static void main(String[] args) {
        practica_12_marzo n= new practica_12_marzo();
        int op;

        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Opciones" +
                    "\n0.Salir del programa" +
                    "\n1.Ingresar a cola" +
                    "\n2.Eliminar de cola" +
                    "\n3.Mostrar lo que contiene cola" +
                    "\n4.Mostar lo que contiene pila" +
                    "\n5.Eliminar un elemento de pila" +
                    "\n6.Tamaño de nodo , pila y cola " +
                    "\n7.Imprimir node" +
                    "\n8.Imprimir el primer elemento de cola" +
                    "\n9.Imprimir el ultimo elemento de pila" +
                    "\n10.Imprimir el ultimo elemento de cola","Braya Arias Sanchez",1));
            switch (op) {
                case 0:
                    JOptionPane.showMessageDialog(null, "saliendo del programa");
                    break;
                case 1:
                    n.agregar_a_cola();
                    break;
                case 2:
    n.borrar_de_cola();
                    break;
                case 3:
                    n.mostrar_cola();
                    break;
                case 4:
                    n.mostrar_pila();
                    break;
                case 5:
              n.borrar_de_pila();
                    break;
                case 6:
                 n.tamaños();
                    break;
                case 7:
                //    n.imprimirnode();
                    break;
                case 8:
                 //   n.primero_de_cola();
                    break;
                case 9:
                 //  n.ultimo_de_pila();
                    break;
                case 10:
                   // n.ultimo_de_cola();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "intente de nuevo");
            }
        } while (op != 0);
    }
}
