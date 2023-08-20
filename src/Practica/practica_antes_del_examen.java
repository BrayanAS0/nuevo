package Practica;

import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class practica_antes_del_examen {
    Stack<practica_antes_del_examen> pila= new Stack<>();
    Scanner s= new Scanner(System.in);
      int numero,saldo;
       practica_antes_del_examen siguiente=null,ultimo_ingresado=null;
    public practica_antes_del_examen(int numero,int saldo){
        this.numero=numero;
        this.saldo=saldo;
    }
    public void  agregar(){
      System.out.println("numero");
        int n=s.nextInt();
        System.out.println("saldo");
        int sa=s.nextInt();

        practica_antes_del_examen nuevo_nodo=new practica_antes_del_examen(n,sa);
  nuevo_nodo.siguiente= ultimo_ingresado;
  ultimo_ingresado=nuevo_nodo;
pila.push(nuevo_nodo);



    }
    public void imprimir(){
        practica_antes_del_examen auxiliar;
        auxiliar=ultimo_ingresado;
        while (ultimo_ingresado!=null){

            System.out.println("( "+ultimo_ingresado.numero+","+ultimo_ingresado.saldo+" )");
        ultimo_ingresado=ultimo_ingresado.siguiente;
        }
        for (int i = 0; i <pila.size() ; i++) {
            System.out.println(pila.get(i).numero+" es en stack");
        }//en clase objecto
        ultimo_ingresado=auxiliar;
    }
public void eliminar(){
        ultimo_ingresado=ultimo_ingresado.siguiente;
}
    public static void main(String[] args) {
        practica_antes_del_examen a= new practica_antes_del_examen(0, 0);
        a.agregar();
        a.agregar();
        a.agregar();
        a.imprimir();
        System.out.println("/////////////////////////////////////////////");
        a.eliminar();
        a.imprimir();
    }
}
