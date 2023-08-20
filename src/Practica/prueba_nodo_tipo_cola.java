package Practica;

import java.util.Scanner;

public class prueba_nodo_tipo_cola {

    Scanner s = new Scanner(System.in);
  public prueba_nodo_tipo_cola top=null,siguiente=null,inicio=null;
int i;
    String n;
    public prueba_nodo_tipo_cola(int i, String s) {
      this.i=i;
      n=s;
    }
public void agregar(){
    Scanner s = new Scanner(System.in);
    System.out.println("numero");
    int p=s.nextInt();
    System.out.println("name");
    String name=s.next();
    prueba_nodo_tipo_cola dato=new prueba_nodo_tipo_cola(p,name);
   dato.siguiente=null;
    if(inicio==null && top==null){
        inicio=dato;
        top=dato;
    }else{
        top.siguiente=dato;
        top=dato;
    }

}
public void impirmir(){
    prueba_nodo_tipo_cola dato=inicio;
        while (inicio!=null){
            System.out.println(inicio.n+inicio.i);
            inicio=inicio.siguiente;
        }
    inicio=dato;
}
public void eliminar(){

inicio=inicio.siguiente;
}
    public static void main(String[] args) {
        prueba_nodo_tipo_cola dato = new prueba_nodo_tipo_cola(0, "") ;
        dato.agregar();
        dato.agregar();
        dato.agregar();
        dato.impirmir();
        System.out.println("elimando");
        dato.eliminar();
        dato.impirmir();
    }
}

