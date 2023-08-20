package Tareas_Estructura;

import javax.swing.*;
import java.util.LinkedList;

public class TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS {

    //linkedlist
    static LinkedList<Integer> cola = new LinkedList<>();
    //arbol binario
    TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS izq, raiz = null, der;
    static int contador_De_arbol = 0;

    /// atributos


    char estatus = 'a';
    static String com = "";

    int numero_empelado;
    float sueldo;
    String nombre_empleado;

    //
    //lista encadenada simple circular
    static int contador_de_lista = 0;
    TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS siguiente;
    static TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS nc;
    TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS anterior;
    TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS temp;

    //constrcutotres
    public TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS(char estatus, int numero_empelado, float sueldo, String nombre_empleado) {

        this.estatus = estatus;
        this.numero_empelado = numero_empelado;
        this.sueldo = sueldo;
        this.nombre_empleado = nombre_empleado;
    }

    public TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS() {

    }

    public void insertar_en_arbol() {
        contador_De_arbol++;
        String nombre = JOptionPane.showInputDialog(null, "Inserte el nombre");
        int numero_de_empleado = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de empleado:"));
        int s = Integer.parseInt(JOptionPane.showInputDialog(null, "Sueldo:"));
        TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS nodo_nuevo = new TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS('a', numero_de_empleado, s, nombre);
        if (raiz == null) {
            raiz = nodo_nuevo;
        } else {
            TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS aux = raiz;
            TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS padre;
            while (true) {
                padre = aux;
                if (numero_de_empleado < aux.numero_empelado) {
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

    public void insertar_en_lista() {

        String nombre = JOptionPane.showInputDialog(null, "Inserte el nombre");
        int numero_de_empleado = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de empleado:"));
        int s = Integer.parseInt(JOptionPane.showInputDialog(null, "Sueldo:"));
        TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS nodo_nuevo = new TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS('a', numero_de_empleado, s, nombre);

        if (nc == null) {
            nc = new TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS();
            nc.siguiente = nc;


        }
        temp = nc.siguiente;
        anterior = nc;
        while ((temp != nc) && (temp.numero_empelado < nodo_nuevo.numero_empelado)) {
            anterior = temp;
            temp = temp.siguiente;

        }
        contador_de_lista++;
        nodo_nuevo.siguiente = anterior.siguiente;
        anterior.siguiente = nodo_nuevo;


    }

    //////////////////////////////////////////
    public void pasar_de_arbol_a_lista_parte_3(TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS nuevo_nodo) {
//aqui es donde se agregan  a lista

        if (nc == null) {
            nc = new TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS();
            nc.siguiente = nc;


        }
        temp = nc.siguiente;
        anterior = nc;
        while ((temp != nc) && (temp.numero_empelado < nuevo_nodo.numero_empelado)) {
            anterior = temp;
            temp = temp.siguiente;

        }
        contador_de_lista++;
        nuevo_nodo.siguiente = anterior.siguiente;
        anterior.siguiente = nuevo_nodo;


    }

    public void pasar_de_arbol_a_lista_parte_2(TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS n) {
        if (n != null && n.estatus != 'b') {

            pasar_de_arbol_a_lista_parte_2(n.izq);
            //aqui va donde pasa  a lista

            pasar_de_arbol_a_lista_parte_3(n);
            pasar_de_arbol_a_lista_parte_2(n.der);
        }
        if (n != null && n.estatus == 'b') {
            pasar_de_arbol_a_lista_parte_2(n.izq);
            pasar_de_arbol_a_lista_parte_2(n.der);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    public void pasar_de_arbol_a_lista_linkedList(TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS n) {
        if (n != null && n.estatus != 'b') {

            pasar_de_arbol_a_lista_linkedList(n.izq);
            //aqui va donde pasa  a lista

            cola.add(n.numero_empelado);
            pasar_de_arbol_a_lista_linkedList(n.der);
        }
        if (n != null && n.estatus == 'b') {
            pasar_de_arbol_a_lista_linkedList(n.izq);
            pasar_de_arbol_a_lista_linkedList(n.der);
        }
    }

    public void orden(TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS n) {
        if (n != null && n.estatus != 'b') {

            orden(n.izq);
            com = com + "Numero de empleado: " + n.numero_empelado + "\nSueldo: " + n.sueldo + "\nNombre: " + n.nombre_empleado + "\n----------------------------------------------------------------------------------------\n";

            orden(n.der);
        }
        if (n != null && n.estatus == 'b') {
            orden(n.izq);
            orden(n.der);
        }
    }

    public void imprimir_lista() {
        TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS temp = nc.siguiente;
        String datos = "";
        while (temp != nc) {
            datos = datos + "Numero de empleado: " + temp.numero_empelado + "\nSueldo: " + temp.sueldo + "\nNombre: " + temp.nombre_empleado + "\n----------------------------------------------------------------------------------------\n";
            temp = temp.siguiente;
        }
        JOptionPane.showMessageDialog(null, datos);
    }

    public void post_orden(TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS n) {
        if (n != null && n.estatus != 'b') {
            post_orden(n.izq);
            post_orden(n.der);
            com = com + "Numero de empleado: " + n.numero_empelado + "\nSueldo: " + n.sueldo + "\nNombre: " + n.nombre_empleado + "\n----------------------------------------------------------------------------------------\n";

        }
        if (n != null && n.estatus == 'b') {
            post_orden(n.izq);
            post_orden(n.der);
        }
    }

    public void pre_orden(TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS n) {
        if (n != null && n.estatus != 'b') {
            com = com + "Numero de empleado: " + n.numero_empelado + "\nSueldo: " + n.sueldo + "\nNombre: " + n.nombre_empleado + "\n----------------------------------------------------------------------------------------\n";
            pre_orden(n.izq);
            pre_orden(n.der);

        }
        if (n != null && n.estatus == 'b') {
            pre_orden(n.izq);
            pre_orden(n.der);
        }

    }

    public int profundidad(TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int profundidadIzquierda = profundidad(nodo.izq);
            int profundidadDerecha = profundidad(nodo.der);
            return 1 + Math.max(profundidadIzquierda, profundidadDerecha);//para irme al que mas se acerque
        }
    }

    public void pasar_de_lista_simple_circular_a_arbol_parte_1() {
        TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS temp = nc.siguiente;

        while (temp != nc) {
            pasar_de_lista_simple_circular_a_arbol_parte_2(temp);
            temp = temp.siguiente;
        }

    }

    public void pasar_de_lista_simple_circular_a_arbol_parte_2(TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS nodo_nuevo) {
        contador_De_arbol++;

        if (raiz == null) {
            raiz = nodo_nuevo;
        } else {
            TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS aux = raiz;
            TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS padre;
            while (true) {
                padre = aux;
                if (nodo_nuevo.numero_empelado < aux.numero_empelado) {
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

    public static void main(String[] args) {
        TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS a = new TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS();
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte una opcion:\n" +
                    "0.Salir del programa\n" +


                    "2.-ALTA DE UN ELEMENTO EN EL ARBOL BINARIO ORDENADOLOS DE MENOR A MAYOR POR EL NUMEMP\n" +

                    "3.-ALTA DE UN ELEMENTO EN LA LISTA  ENCADENADA SIMPLE  CIRCULAR ORDENANDOLO POR EL CAMPO NUMEMP\n" +

                    "4.-PASAR EL CAMPO DE NUMEMP DEL ARBOL BINARIO A LA LISTA LINKEDLIST ORDENADO DE MENOR A MAYOR.\n" +

                    "5.-LOS RECORRIDOS DE ARBOL BINARIO : PREORDER, INORDER Y POSTORDER (IMPRIMIR LOS DATOS DE NUMEMP,NOMEMP,SUELDO POR CADA NODO).\n" +

                    "6.-IMPRIMIR LOS DATOS DE LA LISTA  ENCADENADA SIMPLE CIRCULAR\n" +

                    "7.-IMPRIMIR LOS DATOS DE  LA LISTA LINKEDLIST\n" +

                    "8.-CANTIDAD DE NODOS EN LA LISTA ENCADENADA SIMPLE CIRCULAR\n" +

                    "9.-CANTIDAD DE NODOS EN EL ARBOL BINARIO\n" +

                    "10.-PROFUNDIDAD DEL ARBOL BINARIO\n" +

                    "11.-BORRAR LA LISTA  ENCADENADA SIMPLE CIRCULAR Y PASAR TODOS LOS DATOS DEL ARBOL BINARIO A ESA LISTA ORDENADOS DE MENOR A MAYOR\n" +

                    "12.-PASAR LOS ELEMENTOS DE LA LISTA  ENCADENADA SIMPLE CIRCULAR AL ARBOL BINARIO."));


            switch (op) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;

                case 2:
                    a.insertar_en_arbol();
                    //    a.nodo_raiz();
                    break;
                case 3:
                    a.insertar_en_lista();
                    //    a.cantidad_de_nodos();
                    break;
                case 4:
                    if (a.raiz != null)
                        a.pasar_de_arbol_a_lista_linkedList(a.raiz);
                    else
                        JOptionPane.showMessageDialog(null, "el arbol no tiene nodos");
                    break;
                case 5:
                    if (a.raiz != null) {
                        com = "In-Orden\n\n";
                        a.orden(a.raiz);
                        JOptionPane.showMessageDialog(null, com);

                        com = "Post-Orden\n\n";
                        a.post_orden(a.raiz);
                        JOptionPane.showMessageDialog(null, com);
                        com = "Pre-Orden\n\n";
                        a.pre_orden(a.raiz);
                        JOptionPane.showMessageDialog(null, com);
                    } else
                        JOptionPane.showMessageDialog(null, "el arbol no tiene nodos");
                    break;
                case 6:
                    if (contador_de_lista == 0)
                        JOptionPane.showMessageDialog(null, "la lista no tiene nodos");

                    else
                        a.imprimir_lista();
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, cola);
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Cantidad de nodos que tiene la lista: " + contador_de_lista);
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Cantidad de nodos que tiene el arbol: " + contador_De_arbol);
                    break;
                case 10:

                    JOptionPane.showMessageDialog(null, "La profundidad del arbol es: " + a.profundidad(a.raiz));
                    break;
                case 11:
                    contador_de_lista = 0;
                    TAREA_18_ARBOLES_BINARIOS_CON_LISTAS_ENCADENADAS p = null;
                    nc = p;
                    a.pasar_de_arbol_a_lista_parte_2(a.raiz);
                    break;
                case 12:
                    a.pasar_de_lista_simple_circular_a_arbol_parte_1();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Inserte una opcion valida");


            }

        } while (op != 0);

    }
}

/*EFECTUAR LOS METODOS DE:

12.- PASAR LOS ELEMENTOS DE LA LISTA  ENCADENADA SIMPLE CIRCULAR AL ARBOL BINARIO.

VALIDAR CONDICIONES DE VACIO DEL ARBOL BINARIO, LISTA ENCADENADA SIMPLE CIRCULAR Y LISTA LINKEDLIST.

 */
