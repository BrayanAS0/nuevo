package Practica;

import java.util.LinkedList;
import java.util.Scanner;

public class practica_cola_linkedlist {
    Scanner s= new Scanner(System.in);
    int numero ;
    String nombre;
   public LinkedList<practica_cola_linkedlist> cola= new LinkedList<>();
    public practica_cola_linkedlist(int numero,String nombre){
        this.nombre=nombre;
        this.numero=numero;
    }
public  void agregar(){

    System.out.println(" nombre que vas a agrear");
    String nombre=s.next();
    System.out.println("numero");
    int numero=s.nextInt();
    practica_cola_linkedlist p= new practica_cola_linkedlist(numero,nombre );
    cola.add(p);
}
public void imprimir(){
    for (int i = 0; i < cola.size(); i++) {
        System.out.println("\nNombre: "+cola.get(i).nombre+"\nNumero: "+cola.get(i).numero);
    }
}
public  void eliminar(){
        cola.poll();
}
    public static void main(String[] args) {
        practica_cola_linkedlist cola = new practica_cola_linkedlist(0, "");
        cola.agregar();
        cola.agregar();
        cola.imprimir();
        cola.eliminar();
        cola.imprimir();
    }
}
