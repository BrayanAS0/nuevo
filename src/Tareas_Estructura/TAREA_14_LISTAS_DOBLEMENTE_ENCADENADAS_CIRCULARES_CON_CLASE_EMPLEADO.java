package Tareas_Estructura;

import javax.swing.*;

/*Desarrollar un programa en JAVA que utiliza una clase LISTA DOBLEMENTE ENCADENADA CIRCULAR (LDEC), con los datos :



public class Node {

Node next ;

int numemp;

int depto;

String nombre;

float sueldo;

Node prev;

}



Con los métodos de:

Crear nodo cabeza sin datos.

Insertar un nodo en la LDEC ordenando los datos por el campo de DEPTO y dentro de el por NUMEMP de menor a mayor.

Baja de un nodo de la LDEC localizando el dato por NUMEMP.

Imprimir la cantidad de elementos de la LDEC.

Imprimir los datos de la LDEC recorriendo hacia adelante la lista (next).

Imprimir los datos de la LDEC recorriendo hacia atrás la lista (prev).

Imprimir el nodo con SUELDO mayor.

Imprimir los datos de la LDEC solo de los empleados de un DEPTO=X. */
public class TAREA_14_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES_CON_CLASE_EMPLEADO {


    public static class nodo {

        nodo next, nodo_cabeza, anterior;

        int numemp, tamaño_De_nodo;

        int departamento;

        String nombre;

        float sueldo;

        nodo prev, temporal;

        public nodo(int numero, String nom, float sue,
                    int depa) {
            this.nombre = nom;
            this.sueldo = sue;
            this.departamento = depa;
            this.numemp = numero;

        }

        public nodo() {

        }

        public void insertar() {
            String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre");
            int numero_empleado = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero del empleado"));
            Float sueldo = Float.parseFloat(JOptionPane.showInputDialog(null, "Sueldo del empleado"));
            int depa = Integer.parseInt(JOptionPane.showInputDialog(null, "Departamento del empleado"));

            nodo nodo = new nodo(numero_empleado, nombre, sueldo, depa);
            if (nodo_cabeza == null) {
                nodo_cabeza = new nodo();
                nodo_cabeza.next = nodo_cabeza;
                nodo_cabeza.prev = nodo_cabeza;
                tamaño_De_nodo = 0;
            }
            temporal = nodo_cabeza.next;
            anterior = nodo_cabeza;
            while ((temporal != nodo_cabeza) && (temporal.departamento < nodo.departamento)) {
                temporal = temporal.next;

            }
            while ((temporal != nodo_cabeza) && (temporal.departamento == nodo.departamento) && (temporal.numemp < nodo.numemp)) {
                temporal = temporal.next;
            }
            anterior = temporal.prev;
            nodo.next = temporal;
            nodo.prev = anterior;
            temporal.prev = nodo;
            anterior.next = nodo;
            tamaño_De_nodo++;
        }

        public void borrar() {
            temporal = nodo_cabeza.next;
            int numero_empleado = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de empleado que quieres eliminar"));
            nodo sig, ant;
            ant = nodo_cabeza.next;
            if (nodo_cabeza == temporal) {
                JOptionPane.showMessageDialog(null, "La lista esta vacia");
                return;
            }
            while ((temporal != nodo_cabeza) && (temporal.numemp != numero_empleado)) {
                temporal = temporal.next;
            }
            if (temporal == nodo_cabeza) {
                JOptionPane.showMessageDialog(null, "Ese numero de empleado no existe");
                return;
            }
            anterior = temporal.prev;
            sig = temporal.next;
            anterior.next = sig;
            sig.prev = ant;
            tamaño_De_nodo--;

        }

        public void imprimi_derecha() {
            String lista = "";
            nodo temp1 = nodo_cabeza.next;
            if (temp1 == nodo_cabeza) {
                JOptionPane.showMessageDialog(null, "La lista esta vacia");

            } else {
                while (temp1 != nodo_cabeza) {
                    lista = lista + "Nombre del empleado: " + temp1.nombre + "\nNumero de empleado: " + temp1.numemp + "\nSueldo: " + temp1.sueldo + "\nDepartamento: " + temp1.departamento + "\n" +
                            "/////////////////////////////////////////////////////////////////////////////////////////////////////////////\n";
                    temp1 = temp1.next;

                }
            }

            JOptionPane.showMessageDialog(null, lista);
        }

        public void imprimir_izquierda() {
            String lista = "";
            nodo temp1 = nodo_cabeza.prev;
            if (temp1 == nodo_cabeza) {
                JOptionPane.showMessageDialog(null, "La lista esta vacia");

            } else {
                while (temp1 != nodo_cabeza) {
                    lista = lista + "Nombre del empleado: " + temp1.nombre + "\nNumero de empleado: " + temp1.numemp + "\nSueldo: " + temp1.sueldo + "\nDepartamento: " + temp1.departamento + "\n" +
                            "/////////////////////////////////////////////////////////////////////////////////////////////////////////////\n";
                    temp1 = temp1.prev;

                }
            }

            JOptionPane.showMessageDialog(null, lista);
        }

        public void imprimir_el_empleado_con_sueldo_mayor() {

            String lista = "\nEl empleado con el sueldo mayor es ";
            nodo temp1 = nodo_cabeza.next;
            float  sueldo_mayor=temp1.sueldo;

            if (temp1 == nodo_cabeza) {
                JOptionPane.showMessageDialog(null, "La lista esta vacia");
                return;
            } else {

                while (temp1 != nodo_cabeza) {
                    if (temp1.sueldo >= sueldo_mayor) {
                        sueldo_mayor=temp1.sueldo;
                    }
                    temp1 = temp1.next;
                }
                temp1=nodo_cabeza.next;
                while (temp1 != nodo_cabeza) {
                    if (temp1.sueldo == sueldo_mayor) {
                        lista = lista + "\nNombre del empleado: " + temp1.nombre + "\nNumero de empleado: " + temp1.numemp + "\nSueldo: " + temp1.sueldo + "\nDepartamento: " + temp1.departamento + "\n" +
                                "/////////////////////////////////////////////////////////////////////////////////////////////////////////////\n";


                    }
                    temp1 = temp1.next;
                }
                JOptionPane.showMessageDialog(null, lista);
            }
        }

        public void imprimir_x_departamento() {
            int departamento = Integer.parseInt(JOptionPane.showInputDialog(null, "Indique un departamento"));
            String lista = "\nLos empleados con departamento:  " + departamento + "\n";
            nodo temp1 = nodo_cabeza.next;
            if (temp1 == nodo_cabeza) {
                JOptionPane.showMessageDialog(null, "La lista esta vacia");
                return;
            } else {

                while (temp1 != nodo_cabeza) {
                    if (temp1.departamento == departamento) {
                        lista = lista + "Nombre del empleado: " + temp1.nombre + "\nNumero de empleado: " + temp1.numemp + "\nSueldo: " + temp1.sueldo + "\nDepartamento: " + temp1.departamento + "\n" +
                                "/////////////////////////////////////////////////////////////////////////////////////////////////////////////\n";


                    }
                    temp1 = temp1.next;
                }
                JOptionPane.showMessageDialog(null, lista);
            }
        }

        public void tamaño_de_la_lista() {
            JOptionPane.showMessageDialog(null, "Tamaño de la lista: " + tamaño_De_nodo);
        }


    }

    public static void main(String[] args) {
        int op;
        nodo p = new nodo();
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Opcion: \n" +
                    "0.Salir del programa\n" +
                    "1.Agregar un nuevo empleado\n" +
                    "2.Borrar un empleado por numero de empelado\n" +
                    "3.Imprimir la lista por la derecha\n" +
                    "4.Imprimir la lista por la izquierda\n" +
                    "5.Tamaño de la lista\n" +
                    "6.Imprimir los emplados dado que tiene tal sueldo o es igual\n" +
                    "7.Imprimir por departamento"));
            switch (op) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
                case 1:
                    p.insertar();
                    break;
                case 2:
                    p.borrar();
                    break;
                case 3:
                    p.imprimi_derecha();
                    break;
                case 4:
                    p.imprimir_izquierda();
                    break;
                case 5:
                    p.tamaño_de_la_lista();
                    break;
                case 6:
                    p.imprimir_el_empleado_con_sueldo_mayor();
                    break;
                case 7:
                    p.imprimir_x_departamento();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");

            }

        } while (op != 0);
    }
}