package Practica;




import Tareas_Estructura.TAREA_17_ARBOLES_BINARIO;

import javax.swing.*;

public class basura {
//arbol
    static String com="";
basura izq, raiz = null, der;
int contador_arbol=0;
//pila
static  int tamaño_de_pila;
     basura top=null;
       basura siguiente_pila=null;
      basura temporal_pila,ant;

    //cola
    static  int tamaño_de_cola;
     basura inicio =null;
     basura siguiente=null,fin=null;
     basura temporal;

    //atributo
     int dato;
     char estatus;

    public basura(int dato, char status) {
        this.dato = dato;
        this.estatus = status;
    }
    public basura() {

    }
    public void insertar_arbol() {
        contador_arbol++;

        int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte el dato:"));
        basura nodo_nuevo = new basura(dato, 'a');
        if (raiz == null) {
            raiz = nodo_nuevo;
        } else {
            basura aux = raiz;
            basura padre;
            while (true) {
                padre = aux;
                if (dato < aux.dato) {
                    aux = aux.izq;
                    if (aux == null) {
                        padre.izq = nodo_nuevo;
                        return;
                    }
                } else {
                    aux = aux.der;
                    if (aux == null) {
                        padre.der = nodo_nuevo;
                        return;
                    }
                }
            }
        }
    }
    public void eliminar_De_manera_logica(basura n, int mat) {

        if (n != null) {
            if (n.dato == mat) {
                n.estatus = 'b';
                contador_arbol--;
                return;
            }
            eliminar_De_manera_logica(n.izq, mat);
           // com = com + "La matricula es: " + n.matricula + " Y su nombre es: " + n.nombre + "\n";
            eliminar_De_manera_logica(n.der, mat);
        }
    }
    public  void pasar_de_arbol_a_cola_parte_2 (basura nuevo_nodo) {



        nuevo_nodo.siguiente=null;
        if(inicio==null){
            inicio=nuevo_nodo;
            fin=nuevo_nodo;
        }
        fin.siguiente=nuevo_nodo;
        fin=nuevo_nodo;
        tamaño_de_cola++;
    }
    public void pasar_de_arbol_a_cola_parte_1(basura n) {
        if (n != null && n.estatus != 'b') {

            pasar_de_arbol_a_cola_parte_1(n.izq);
pasar_de_arbol_a_cola_parte_2(n);
          //  com = com + "La matricula es: " + n.matricula + " Y su nombre es: " + n.nombre + "\n";
            pasar_de_arbol_a_cola_parte_1(n.der);
        }
        if (n != null && n.estatus == 'b') {
            pasar_de_arbol_a_cola_parte_1(n.izq);
            pasar_de_arbol_a_cola_parte_1(n.der);
        }
    }
    public void imprimir_lista_cola() {

        basura lista = new basura();
        lista = inicio;
        while (inicio != null) {
            System.out.println(inicio.dato);
            inicio = inicio.siguiente;
        }
        inicio =lista;
    }
    public void orden(basura n) {
        if (n != null && n.estatus != 'b') {

            orden(n.izq);

            com = com + "dato:"+n.dato+"\n";
            orden(n.der);
        }
        if (n != null && n.estatus == 'b') {
            orden(n.izq);
            orden(n.der);
        }
    }
    public static void main(String[] args) {
        basura a=new basura();
        a.insertar_arbol();
        a.insertar_arbol();
        a.insertar_arbol();
        a.orden(a.raiz);
        JOptionPane.showMessageDialog(null, com);
     a.eliminar_De_manera_logica(a.raiz,4);
     com="";
a.orden(a.raiz);
        JOptionPane.showMessageDialog(null, com);
    }
}