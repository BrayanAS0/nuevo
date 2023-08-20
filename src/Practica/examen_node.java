//Brayan Arias Sanchez
//matricula :16586095
//materia Estructura de Datos
package Practica;



import javax.swing.*;
import java.util.LinkedList;
import java.util.Stack;

public class examen_node {
    int tamaño;
    Stack<Integer> pila = new Stack<>();
    LinkedList<Integer> cola1 = new LinkedList<>();
    LinkedList<Integer> cola2 = new LinkedList<>();
    examen_node siguiente, top;
    int numero;

    public examen_node() {

    }

    public examen_node(int n) {
        this.numero = n;
    }

    public void llegada_a_cola() {
        cola1.add(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el numero de cliente","Brayan Arias Sanchez",1)));

    }

    public void elimine_de_cola_inserte_a_pila() {
        if (!cola1.isEmpty()) {
            pila.push(cola1.poll());

        } else JOptionPane.showMessageDialog(null, "cola 1 esta vacia");
    }
    public void elimina_de_pila() {
        int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Dato que borra de pila\n" + pila,"Brayan Arias Sanchez",1));
        if (pila.contains(dato)) {
            if (pila.peek() == dato) {
                cola2.add(pila.pop());

            }else {
                int size=pila.size();
                for (int i = 0; i < size; i++) {
                    if(pila.peek()==dato){
                     cola2.add(pila.peek());
                     pila.pop();
                        break;
                    }else{
                        examen_node nuevo_nodo = new examen_node(pila.pop());

                    nuevo_nodo.    siguiente = top;

                        top=nuevo_nodo;
                        tamaño++;
                    }
                }
                while (top!=null){
                    pila.push(top.numero);
                    top = top.siguiente;
                    tamaño--;
                }
            }

        } else {
JOptionPane.showMessageDialog(null, "Ese dato no esta en la pila","Brayan Arias Sanchez",1);
        }//contains
    }
    public void elimina_de_cola2(){
        if(!cola2.isEmpty()){
        cola2.poll();}
        else JOptionPane.showMessageDialog(null, "La cola esta vacia");
    }
    public void imprimir_pila(){
        JOptionPane.showMessageDialog(null, pila);
    }
    public void imprimir_cola1(){
        JOptionPane.showMessageDialog(null, cola1);
    }
    public void imprimir_cola2(){
        JOptionPane.showMessageDialog(null, cola2);
    }
    public void imprimir_tamaño(){
        JOptionPane.showMessageDialog(null, "Tamaño de cola1: "+cola1.size()+
                "\nTamaño de cola 2: "+cola2.size()+"\nTamaño de pila :"+pila.size()
        +"\nTamaño de nodo: "+tamaño);
    }
    public void imprimir_el_primer_elemento_de_cola(){
        JOptionPane.showMessageDialog(null,"Primer elemeto de cola 1: " +cola1.getFirst(),"Brayan Arias Sanchez",1);
    }
    public void ultimo_elemeto_de_cola1(){
        JOptionPane.showMessageDialog(null, "Ultimo elemento de cola:  "+cola1.getLast(),"Brayan Arias Sanchez",1);
    }
    public void ultimo_elemeto_de_pila(){
        JOptionPane.showMessageDialog(null, "Ultimo elemento de pila :"+pila.peek(),"Brayan Arias Sanchez",1);
    }
    public static void main(String[] args) {
        int op;
        examen_node n= new examen_node();
        do{op=Integer.parseInt(JOptionPane.showInputDialog(null, "Opciones" +
                "0.Salir del programa\n" +
                "2.\tMétodo que permita la llegada de CLIENTES a la  COLA EN LINKEDLIST para que sea atendido en ese orden.\n" +
                "3.\tMétodo que borre de la LINKEDLIST COLA e inserte ese cliente en una PILA con clase STACK de tipo de datos igual.\n" +
                "4.\tMétodo que borre un elemento de la PILA\n" +
                "5.\tMétodo para borrar un elemento de COLA2.\n" +
                "6.\tMétodo para imprimir la PILA.\n" +
                "7.\tMétodo para imprimir la  COLA1 LINKEDLIST.\n" +
                "8.\tMétodo para imprimir la  COLA2 LINKEDLIST.\n" +
                "9.\tMétodo para imprimir el tamaño de la PILA, la COLA1 y COLA 2 en LINKEDLIST  y\n" +
                "10.\tMétodo para imprimir el primer elemento insertado de la  COLA1 LINKEDLIST.\n" +
                "11.\tMétodo para imprimir el último elemento insertado de la PILA.\n" +
                "12.\tMétodo para imprimir el último elemento insertado en la COLA1 LINKEDLIST.\n","Brayan Arias Sanchez",1));
            switch (op){
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa","Brayan Arias Sanchez",1);
                    break;
                case 2:
                  n.llegada_a_cola();
                  break;
                case 3:
                    n.elimine_de_cola_inserte_a_pila();
                    break;
                case 4:

                        n.elimina_de_pila();


                    break;
                case 5:
                    n.elimina_de_cola2();
                    break;
                case 6:
                    n.imprimir_pila();
                    break;
                case 7:
                    n.imprimir_cola1();
                    break;
                case 8:
                    n.imprimir_cola2();
                    break;
                case 9:
                    n.imprimir_tamaño();
                    break;
                case 10:
                    n.imprimir_el_primer_elemento_de_cola();
                    break;
                case 11:
n.ultimo_elemeto_de_pila();
break;
                case 12:
n.ultimo_elemeto_de_cola1();
break;
                default:
                    JOptionPane.showMessageDialog(null, "Intente de nuevo porfavor");
            }

        }while (op!=0);
    }
}