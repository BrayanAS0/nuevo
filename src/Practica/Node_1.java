package Practica;


import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

public class Node_1 {
    Node_1 siguiente, inicio, ultimo;
    LinkedList<Integer> cola = new LinkedList<>();
    Stack<Integer> pila = new Stack<>();
    int numero, tamaño;

    public Node_1() {

    }

    public Node_1(int n) {
        numero = n;
    }

    public void agregar_a_cola() {
       cola.add(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero ", "Brayan Arias Sanchez", 3)));

    }

    public void eliminar_de_cola() {
        JOptionPane.showMessageDialog(null, ("Dato que se eliminara de cola y se enviara a pila ") + pila.push(cola.poll()));
    }

    public void mostrar_cola() {
        JOptionPane.showMessageDialog(null, cola, "numeros que tiene la cola", 1);
    }

    public void mostrar_pila() {
        JOptionPane.showMessageDialog(null, pila, "numeros que tiene la pila", 1);
    }

    public void eliminar_de_pila() {

        int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "dato que quieres borrar de la pila\n" + pila, "Brayan Arias Sanchez", 3));
        if (pila.peek() == dato) {
            pila.pop();
        } else {
            if (pila.contains(dato)) {
                int size = pila.size();
                for (int i = 0; i < size; i++) {
                    if (pila.peek() == dato) {
                        pila.pop();
                        break;
                    } else {

                        Node_1 nuevo_nodo = new Node_1(pila.pop());

                        if (inicio == null) {
                            inicio = nuevo_nodo;
                            ultimo = nuevo_nodo;
                            tamaño++;
                        }
                        ultimo.siguiente = nuevo_nodo;
                        ultimo = nuevo_nodo;
                        tamaño++;

                    }
                }
                Node_1 lista;
                lista = inicio;
                while (inicio != null) {
                    tamaño--;
                    pila.push(inicio.numero);
                    inicio = inicio.siguiente;

                }
                tamaño--;


            } else {
                JOptionPane.showMessageDialog(null, "la pila no contiene ese dato");
            }

        }
    }

    public void tamaños() {
        JOptionPane.showMessageDialog(null, "tamaño de cola: " + cola.size() + "\nTamaño de la pila:" + pila.size() +
                "\ntamaño del nodo:" + tamaño);
    }
public void imprimirnode(){

    Node_1 lista;
    lista = inicio;
    String node="[";
        while (inicio != null) {
            node=node+inicio.numero;
            inicio=inicio.siguiente;
        }
        node=node+"]";
        JOptionPane.showMessageDialog(null, node);
        inicio =lista;

}
public void primero_de_cola(){
        JOptionPane.showMessageDialog(null, cola.getFirst());
}
    public void ultimo_de_pila(){
        JOptionPane.showMessageDialog(null, pila.peek());
    }
    public void ultimo_de_cola(){
        JOptionPane.showMessageDialog(null, cola.getLast());
    }
    public static void main(String[] args) {
        Node_1 n = new Node_1();
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
                    n.eliminar_de_cola();
                    break;
                case 3:
                    n.mostrar_cola();
                    break;
                case 4:
                    n.mostrar_pila();
                    break;
                case 5:
                    n.eliminar_de_pila();
                    break;
                case 6:
                    n.tamaños();
                    break;
                case 7:
                    n.imprimirnode();
                    break;
                case 8:
                  n.primero_de_cola();
                    break;
                case 9:
                    n.ultimo_de_pila();
                    break;
                case 10:
               n.ultimo_de_cola();
               break;
                default:
                    JOptionPane.showMessageDialog(null, "intente de nuevo");
            }
        } while (op != 0);
    }
}
