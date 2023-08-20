//Brayan Arias Sanchez
//Matricula:16586095
package Tareas_Estructura;




import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

public class EXAMEN_ORDI {

    Stack<String> pila=new Stack<>();
    LinkedList <String> cola= new LinkedList<>();


    //Arbol Atributos
    EXAMEN_ORDI izq, raiz = null, der;
    int contador_arbol = 0;
   static String com="";
   char estatus ;

    public EXAMEN_ORDI(char estatus, int placa) {
        this.estatus = estatus;
        this.placa = placa;
    }

    //atributo solo
    int placa ;

    public EXAMEN_ORDI() {
    }


    ///Atributos

    public void insertar_en_pila(){
        String placa=JOptionPane.showInputDialog(null,"Inserte la placa del carro");
        pila.push(placa);
    }
    public void sacar_de_pila(String placa){
        while (!pila.peek().equalsIgnoreCase(placa)) {
            if (pila.peek().equalsIgnoreCase(placa)) {
                pila.pop();
            } else {
                cola.add(pila.pop());
            }
        }
        pila.pop();
        while (cola.size()!=0){
            pila.push(cola.poll());
        }
    }
    public void imprimir_pila(){
        JOptionPane.showMessageDialog(null, pila);
    }

    public void insertar_en_arbol() {
        contador_arbol++;

        int placa = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de la placa:"));
        EXAMEN_ORDI nodo_nuevo = new EXAMEN_ORDI('a',placa);
        if (raiz == null) {
            raiz = nodo_nuevo;
        } else {
            EXAMEN_ORDI aux = raiz;
            EXAMEN_ORDI padre;
            while (true) {
                padre = aux;
                if (placa < aux.placa) {
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
    public void post_orden(EXAMEN_ORDI n) {
        if (n != null ) {
            post_orden(n.izq);
            post_orden(n.der);
            if(n.estatus!='b')
            com = com + "Placa: " + n.placa + "\n"+ "\n----------------------------------------------------------------------------------------\n";

        }

    }

    public void pre_orden(EXAMEN_ORDI n) {
        if (n != null && n.estatus != 'b') {
            com = com + "Placa: " + n.placa + "\n"+ "\n----------------------------------------------------------------------------------------\n";            pre_orden(n.izq);
            pre_orden(n.der);

        }
        if (n != null && n.estatus == 'b') {
            pre_orden(n.izq);
            pre_orden(n.der);
        }

    }

    public void orden(EXAMEN_ORDI n) {
        if (n != null && n.estatus != 'b') {

            orden(n.izq);
            com = com + "Placa: " + n.placa + "\n"+ "\n----------------------------------------------------------------------------------------\n";
            orden(n.der);
        }
        if (n != null && n.estatus == 'b') {
            orden(n.izq);
            orden(n.der);
        }
    }
    public void eliminar_De_manera_logica(EXAMEN_ORDI n, int mat) {

        if (n != null) {
            if (n.placa == mat) {
                n.estatus = 'b';
                contador_arbol--;
                return;
            }
            eliminar_De_manera_logica(n.izq, mat);
            //  com = com + "La matricula es: " + n.matricula + " Y su nombre es: " + n.nombre + "\n";
            eliminar_De_manera_logica(n.der, mat);
        }
    }
public void contar_numero_de_nodos_del_arbol(){
        JOptionPane.showMessageDialog(null, "Numero de nodos del arbol: "+contador_arbol);
}
public void pasar_de_arbol_a_cola(EXAMEN_ORDI n){
    if (n != null && n.estatus != 'b') {

        pasar_de_arbol_a_cola(n.izq);
        //aqui va donde pasa  a lista

        cola.add(Integer.toString(n.placa));
        pasar_de_arbol_a_cola(n.der);
    }
    if (n != null && n.estatus == 'b') {
        pasar_de_arbol_a_cola(n.izq);
        pasar_de_arbol_a_cola(n.der);
    }
}
public void imprimir_cola(){
        JOptionPane.showMessageDialog(null, cola);
}
public void imprimir_primero_y_ultimo_de_cola(){
        JOptionPane.showMessageDialog(null, "Primer numero de cola: "+cola.getFirst()+"\nUltimo elemento de cola: "+cola.getLast());
}
public void tamaño_De_pila(){
        JOptionPane.showMessageDialog(null, "Tamaño de la pila es: "+pila.size());
}
    public static void main(String[] args) {
        EXAMEN_ORDI a= new EXAMEN_ORDI();
        int op;
        do{
            op=Integer.parseInt(JOptionPane.showInputDialog(null,"\tBrayan Arias Sanchez\nMatricula:16586095\n" +
                    "0)\tSalir del programa\n" +
                    "2)\tLlegada de un auto a la clase Stack (PILA) con el objeto string.\n" +
                    "3)\tSacar un auto de la clase Stack (PILA) buscando la xplaca= placa  y en el caso que no sea la del tope pasar a la Lista Encadenada " +
                    "\nSimple en forma de COLA de forma temporal, una vez que se encuentre el elemento a sacar de la Lista Encadenada Simple en forma de PILA regresar todos los elementos de la Lista Encadenada Simple en forma de COLA a la PILA. \n" +
                    "4)\tImprimir la Pila clase Stack\n" +
                    "5)\tAlta de elemento al Arbol Binario de manera que los menores se carguen a la izquierda y los mayores a la derecha.\n" +
                    "6)\tRecorridos de Arbol Binario:\n" +
                    "a.\tPreorder\n" +
                    "b.\tInorder\n" +
                    "c.\tPostorder\n" +
                    "7)\tEliminar un nodo del Arbol Binario buscándolo por dato=X.\n" +
                    "8)\tContar el número de nodos activos del árbol binario.\n" +
                    "9)\tPasar el recorrido Inorder del Arbol Binario a una Lista Encadenada Simple en forma de COLA ( tomar en cuenta que el objeto del árbol es int y el de la Lista en forma de COLA es string)\n" +
                    "10)\tImprimir la Lista Encadenada Simple en forma de COLA.\n" +
                    "11)\tImprimir el primer y el último elemento insertado en la Lista Encadenada Simple en forma COLA.\n" +
                    "12)\tIndicar el tamaño de la clase Stack (PILA).\n"));
            switch (op) {
                case 2:
                    a.insertar_en_pila();
                    break;
                case 3:
                    a.sacar_de_pila(JOptionPane.showInputDialog(null, "PLACA"));
                    break;
                case 4:
                    a.imprimir_pila();
                    break;
                case 5:
                    a.insertar_en_arbol();
                    break;
                case 6:
                    com = "Pre-orden\n";
                    a.pre_orden(a.raiz);
            JOptionPane.showMessageDialog(null, com);


                    com="Orden\n";
                    a.orden(a.raiz);
                    JOptionPane.showMessageDialog(null, com);
                    com="Post-Orden\n";
                    a.post_orden(a.raiz);
                    JOptionPane.showMessageDialog(null, com);
                    com="";
                    break;
                case 7:
                    int num_de_art = Integer.parseInt(JOptionPane.showInputDialog(null, "Placa de carro que quiere eliminar:"));
                    a.eliminar_De_manera_logica(a.raiz, num_de_art);
                    break;
                case 8:
                    a.contar_numero_de_nodos_del_arbol();
                    break;
                case 9:
                    a.pasar_de_arbol_a_cola(a.raiz);
                    break;
                case 10:
                    a.imprimir_cola();
                    break;
                case 11:
                    a.imprimir_primero_y_ultimo_de_cola();
                    break;
                case 12:
                    a.tamaño_De_pila();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
        }while (op!=0);

    }
}
