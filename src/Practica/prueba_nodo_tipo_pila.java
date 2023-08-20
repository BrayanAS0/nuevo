package Practica;

import java.util.Scanner;

public class prueba_nodo_tipo_pila {

    Scanner s = new Scanner(System.in);
  public   prueba_nodo_tipo_pila top=null,siguiente=null;
int i;
    String n;
    public prueba_nodo_tipo_pila(int i, String s) {
      this.i=i;
      n=s;
    }
public void agregar(){
    Scanner s = new Scanner(System.in);
    System.out.println("numero");
    int p=s.nextInt();
    System.out.println("name");
    String name=s.next();
    prueba_nodo_tipo_pila dato=new prueba_nodo_tipo_pila(p,name);
    if(top==null){
        top=dato;
    }else{
        dato.siguiente=top;
        top=dato;
    }

}
public void impirmir(){
    prueba_nodo_tipo_pila dato=top;
        while (top!=null){
            System.out.println(top.n+top.i);
            top=top.siguiente;
        }
        top=dato;
}
public void eliminar(){
        top=top.siguiente;
}
    public static void main(String[] args) {
        prueba_nodo_tipo_pila dato = new prueba_nodo_tipo_pila(0, "") ;
        dato.agregar();
        dato.agregar();
        dato.agregar();
        dato.impirmir();
        dato.eliminar();
        dato.impirmir();
    }
}

