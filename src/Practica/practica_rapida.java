package Practica;

import Tareas_Estructura.Node;

import javax.swing.*;
/*
Crear nodo cabeza sin datos.

        Insertar un nodo en la LDEC ordenando los datos por el campo de DEPTO y dentro de el por NUMEMP de menor a mayor.

        Baja de un nodo de la LDEC localizando el dato por NUMEMP.

        Imprimir la cantidad de elementos de la LDEC.

        Imprimir los datos de la LDEC recorriendo hacia adelante la lista (next).

        Imprimir los datos de la LDEC recorriendo hacia atrás la lista (prev).

        Imprimir el nodo con SUELDO mayor.

        Imprimir los datos de la LDEC solo de los empleados de un DEPTO=X. */
public class practica_rapida {
    int numero_de_articulo,departamento,contador;
    practica_rapida nc,prev,siguiente;

    float precio;
    String nombre;
    public practica_rapida()
    {

    }
    public practica_rapida(int numero_de_articulo,float precio,String nombre,int depa){
        this.numero_de_articulo=numero_de_articulo;
        this.nombre=nombre;
        this.precio=precio;
    this.departamento=depa;

    }
    public void insertar(){
        practica_rapida temporal,anteriror;
        int numero=Integer.parseInt(JOptionPane.showInputDialog(null, "Numero del articulo"));
       float precio=Float.parseFloat(JOptionPane.showInputDialog(null, "Precio del articulo" ));
       String nombre=JOptionPane.showInputDialog(null, "Nombre del articulo");
     int depa=Integer.parseInt(JOptionPane.showInputDialog(null,"Departamento"));
        practica_rapida nuevo_nodo= new practica_rapida(numero, precio, nombre, depa);
        if(nc== null){
            nc= new practica_rapida();
            nc.siguiente=nc;
            nc.prev=nc;
            contador++;
        }
        temporal=nc.siguiente;
        anteriror=nc;
       while ((temporal!= nc)&&(temporal.numero_de_articulo< nuevo_nodo.numero_de_articulo) ){
            temporal=temporal.siguiente;
        }
        anteriror=temporal.prev;
nuevo_nodo.siguiente=temporal;
nuevo_nodo.prev=anteriror;
temporal.prev=nuevo_nodo;
anteriror.siguiente=nuevo_nodo;
contador++;


    }
    public void imprimir(){
        practica_rapida  temporal=nc.siguiente;
String lista="";
while( temporal!= nc){
    lista=lista+"Nombre del articulo: "+temporal.nombre+"\nNumero del articulo: "+temporal.numero_de_articulo+"\nPrecio: "+temporal.precio;
    temporal=temporal.siguiente;
    }
JOptionPane.showMessageDialog(null, lista);

}

    public void preguntar_si_esta_vacia(){
        if(nc!=null){
            JOptionPane.showMessageDialog(null, "La lista contiene datos");

        }else {
            JOptionPane.showMessageDialog(null, "la lista esta vacia");
        }
    }

public void imprimir_x_depa(){
    practica_rapida  temporal=nc.siguiente;
   int depa=Integer.parseInt( JOptionPane.showInputDialog(null, "Departo donde buscaras los nodos"));
    String lista="";
    while( temporal!= nc){
        if(temporal.departamento==depa) {
            lista = lista + "Nombre del articulo: " + temporal.nombre + "\nNumero del articulo: " + temporal.numero_de_articulo + "\nPrecio: " + temporal.precio;
            temporal = temporal.siguiente;
        }
    }
    JOptionPane.showMessageDialog(null, lista);

}
    public void imprimir_x_sueldo(){
        practica_rapida  temporal=nc.siguiente;
        int depa=Integer.parseInt( JOptionPane.showInputDialog(null, "suedlo donde buscaras los nodos"));
        String lista="";
        while( temporal!= nc){
            if(temporal.departamento>=depa) {
                lista = lista + "Nombre del articulo: " + temporal.nombre + "\nNumero del articulo: " + temporal.numero_de_articulo + "\nPrecio: " + temporal.precio;
                temporal = temporal.siguiente;
            }
        }
        JOptionPane.showMessageDialog(null, lista);

    }
    public void tamaño(){
        JOptionPane.showMessageDialog(null, "tamaño del nodo:"+contador);
    }
    public static void main(String[] args) {
        int op;
        practica_rapida n= new practica_rapida();
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la opcion:\n" +
                    "\n0.salir del programa\n" +
                    "\n1.Insertar un nodo en la LDEC ordenando los datos por el campo de DEPTO y dentro de el por NUMEMP de menor a mayor. \n" +
                    "\n" +
                    "2.Baja de un nodo de la LDEC localizando el dato por NUMEMP. \n" +
                    "\n" +
                    "3.Imprimir la cantidad de elementos de la LDEC. \n" +
                    "\n" +
                    "4.Imprimir los datos de la LDEC recorriendo hacia adelante la lista (next). \n" +
                    "\n" +
                    "5.Imprimir los datos de la LDEC recorriendo hacia atrás la lista (prev). \n" +
                    "\n" +
                    "6.Imprimir el nodo con SUELDO mayor. \n" +
                    "\n" +
                    "7.Imprimir los datos de la LDEC solo de los empleados de un DEPTO=X. 1"));
            switch (op){
                case 0 :
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
                case 1:
                   n.insertar();
                   break;
                case 2:

                    break;
                case 3:
n.tamaño();
                    break;
                case 4:
                    n.imprimir();
                    break;
                case 6:
                    n.imprimir_x_sueldo();
                    break;
                case 7:
                  n.imprimir_x_depa();
            }

        }while (op!=0);
    }
}
