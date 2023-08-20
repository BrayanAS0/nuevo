package Practica;

import javax.swing.*;

/*Desarrollar un programa en JAVA que utiliza una clase LISTA DOBLEMENTE ENCADENADA CIRCULAR (LDEC), con los datos :

public class Node {

Node next ;

int numart;

String nombre;

int existencia;

// int depto;

float precio;

        Node prev;

}



Con los métodos de:

Crear nodo cabeza sin datos.

Insertar un nodo en la LDEC ordenando los datos por el campo de NUMART de menor a mayor.

Baja de un nodo de la LDEC localizando el dato por NUMART.







Imprimir el nodo con precio más alto.  */
public class PRACTICA_16_DE_MARZO_2023_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES {


    PRACTICA_16_DE_MARZO_2023_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES next, nodo_cabeza, anterior;

    int numero_de_articulo, tamaño_De_nodo;

    int existencia;

    String nombre;

    float precio;

    PRACTICA_16_DE_MARZO_2023_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES previo,temporal;

    public PRACTICA_16_DE_MARZO_2023_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES(int numero, String nom, float precio, int existencia) {
        this.nombre = nom;
        this.precio = precio;
        this.existencia = existencia;
        this.numero_de_articulo = numero;

    }

    public PRACTICA_16_DE_MARZO_2023_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES() {

    }

    public void insertar() {
        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre");
        int numero_artticulo = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero del articulo"));
        Float precio = Float.parseFloat(JOptionPane.showInputDialog(null, "Precio"));
        int existencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Existencia"));

        PRACTICA_16_DE_MARZO_2023_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES nodo = new PRACTICA_16_DE_MARZO_2023_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES(numero_artticulo, nombre, precio, existencia);
        if (nodo_cabeza == null) {
            nodo_cabeza = new PRACTICA_16_DE_MARZO_2023_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES();
            nodo_cabeza.next = nodo_cabeza;
            nodo_cabeza.previo = nodo_cabeza;
            tamaño_De_nodo = 0;
        }
 temporal=nodo_cabeza.next;
        anterior=nodo_cabeza;
        while ((temporal!= nodo_cabeza)&&(temporal.numero_de_articulo< nodo.numero_de_articulo)){
          temporal=temporal.next;

        }

anterior=temporal.previo;
nodo.next=temporal;
nodo.previo =anterior;
temporal.previo =nodo;
anterior.next=nodo;
tamaño_De_nodo++;
    }
    public void borrar(){
        temporal=nodo_cabeza.next;
        int numer_de_articulo=Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de articulo que quieras borrar"));
       PRACTICA_16_DE_MARZO_2023_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES sig,ant;
     ant=nodo_cabeza.next;
        if(nodo_cabeza==temporal){
            JOptionPane.showMessageDialog( null, "La lista esta vacia");
    return;
        }
        while ((temporal!=nodo_cabeza)&&(temporal.numero_de_articulo !=numer_de_articulo)){
            temporal=temporal.next;
        }
        if( temporal==nodo_cabeza){
            JOptionPane.showMessageDialog(null, "Ese numero de articulo no existe");
return;
        }
        anterior=temporal.previo;
        sig=temporal.next;
    anterior.next=sig;
      sig.previo =ant;
   tamaño_De_nodo--;

    }
    public void imprimi_derecha(){
        String lista="";
     PRACTICA_16_DE_MARZO_2023_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES temp1=nodo_cabeza.next;
   if( temp1== nodo_cabeza){
       JOptionPane.showMessageDialog(null, "La lista esta vacia");

   }else{
       while (temp1!=nodo_cabeza){
           lista=lista+"Nombre del empleado: "+temp1.nombre+"\nNumero de articulo: "+temp1.numero_de_articulo +"\nPrecio: "+temp1.precio +"\nExistencia: "+temp1.existencia+"\n" +
                   "/////////////////////////////////////////////////////////////////////////////////////////////////////////////\n";
           temp1=temp1.next;

       }
   }

JOptionPane.showMessageDialog(null, lista);
    }
public void imprimir_izquierda(){
    String lista="";
    PRACTICA_16_DE_MARZO_2023_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES temp1=nodo_cabeza.previo;
    if( temp1== nodo_cabeza){
        JOptionPane.showMessageDialog(null, "La lista esta vacia");

    }else{
        while (temp1!=nodo_cabeza){
            lista=lista+"Nombre del empleado: "+temp1.nombre+"\nNumero de articulo: "+temp1.numero_de_articulo +"\nPrecio: "+temp1.precio +"\nExistencia: "+temp1.existencia+"\n" +
                    "/////////////////////////////////////////////////////////////////////////////////////////////////////////////\n";
            temp1=temp1.previo;

        }
    }

    JOptionPane.showMessageDialog(null, lista);
}
public void articulo_mas_caro() {

    String lista = "\nEl artiuclo con el precio mas alto es \n";
    PRACTICA_16_DE_MARZO_2023_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES temp1 = nodo_cabeza.next;
    if (temp1 == nodo_cabeza) {
        JOptionPane.showMessageDialog(null, "La lista esta vacia");
return;
    } else {

        while (temp1 != nodo_cabeza) {
            if(temp1.precio >= 0){
            lista =  "Nombre del empleado: " + temp1.nombre + "\nNumero de empleado: " + temp1.numero_de_articulo + "\nSueldo: " + temp1.precio + "\nDepartamento: " + temp1.existencia ;



        }
            temp1 = temp1.next;
        }
        JOptionPane.showMessageDialog(null, lista);
    }
}

public  void tamaño_de_la_lista(){
        JOptionPane.showMessageDialog(null, "Tamaño de la lista: "+tamaño_De_nodo);
}
    public static void main(String[] args) {
        int op;
        PRACTICA_16_DE_MARZO_2023_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES p= new PRACTICA_16_DE_MARZO_2023_LISTAS_DOBLEMENTE_ENCADENADAS_CIRCULARES();
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(null, "Opcion: \n" +
                    "0.Salir del programa\n" +
                    "1.Agregar un nuevo articulo\n" +
                    "2.Borrar un articulo\n" +
                    "3.Imprimir la lista por la derecha\n" +
                    "4.Imprimir la lista por la izquierda\n" +
                    "5.Tamaño de la lista\n" +
                    "6.Articulo con el precio mas alto"));
            switch (op){
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
            p.articulo_mas_caro();
  break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");

            }

        }while (op!=0);
    }
}


