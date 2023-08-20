package Practica;

import javax.swing.JOptionPane;
import java.util.LinkedList;
public class prueba {
    LinkedList <Integer> cola = new LinkedList<Integer>();
    LinkedList <Integer> pila = new LinkedList<Integer>();
    private Integer xelem;
    int numSearch, numSearchCola;
    int pilaTemp [];
    //Insertar Dato al final de la cola
    public void insertarDato() {
        xelem=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de cliente: "));
        cola.add(xelem);
    }
    //Eliminar el primer elemento
    public void eliminarPrimerElemento() {
        if(!cola.isEmpty()){
        }
        else {
            JOptionPane.showMessageDialog(null, "NO HAY ELEMENTOS QUE ELIMINAR");
        }
    }
    //Eliminar elemento de la pila
    public boolean pilaContiene() {
        numSearch=Integer.parseInt(JOptionPane.showInputDialog(null,"Inserte el numero a eliminar"));
        if (pila.contains(numSearch)) {
            return true;
        }
        else {
            return false;
        }
    }
    //Eliminar si es el ultimo
    public void eliminarSiEsElUltimo() {
        if (pilaContiene()==true) {
            if(numSearch==pila.getLast()) {
                pila.poll();
            }
        }
        else {
            JOptionPane.showInputDialog(null,"El cliente "+numSearch+" ah sido movido a "
                    + "la pila temporal");
        }
    }
    //Imprimir la cola y pila
    public void imprimirColaYPila(){
        if (cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay elementos que imprimir");
        }
        else {
            JOptionPane.showMessageDialog(null, "Los elementos de la cola son "+cola+"\n "
                    + " y de la pila "+pila);
        }
    }
    //Tamaño de la pila y cola
    public void medidas () {
        JOptionPane.showMessageDialog(null, "La pila contiene: "+pila.size()+" elementos\n"
                + "La cola contiene: "+cola.size()+"elementos");
    }
    //Imprimir primer elemento insertado de la cola
    public void primerEleCola() {
        JOptionPane.showMessageDialog(null, "El primer elemento insertado es: "+cola.getFirst());
    }
    //Imprimir ultimo elemento insertado de la cola
    public void ultimoEleCola() {
        JOptionPane.showMessageDialog(null, "El primer elemento insertado es: "+cola.getLast());
    }
    //Imprimir ultimo elemento insertado de la pila
    public void ultimoElePila() {
        JOptionPane.showMessageDialog(null,"El primer elemento insertado es: "+pila.getLast());
    }
    //Saber si un elemento existe en la pila
    public boolean colaContiene() {
        numSearchCola=Integer.parseInt(JOptionPane.showInputDialog(null,"Inserte el numero a "
                + "buscar"));
        if (cola.contains(numSearchCola)){
            return true;
        }
        else {
            return false;
        }
    }
    //Mensaje de si esta en la cola
    public void ImprimirMensaje() {
        if (colaContiene()==true) {
            JOptionPane.showMessageDialog(null,numSearchCola+" sí está en la cola.");
        }
        else {
            JOptionPane.showMessageDialog(null,numSearchCola+" NO está en la cola.");
        }
    }
    //crear cola
    public void crearCola() {
        xelem=Integer.parseInt(JOptionPane.showInputDialog(null, "Teclee la cantidad de elementos a "
                + "agregar: "));
    }
    //Cola Vacia
    public boolean colaVacia() {
        if (cola.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La cola está vacía");
            return true;
        }
        else {
            JOptionPane.showMessageDialog(null, "La cola no está vacía y contiene: "+cola);
            return false;
        }
    }
}//end class