package Practica;

public class pra {
public static class nodo{
    int suelod,numero;
    nodo siguiente,ultimo;
    public nodo(int n,int sue){
 suelod=sue;
 numero=n;
    }
public void agregar(){
   nodo nuevo_nodo=new nodo(((int) (Math.random() * 100)), ((int) (Math.random() * 100)));

        nuevo_nodo.siguiente=ultimo;
        ultimo=nuevo_nodo;
}
public void imprimir(){
        nodo auxiliar=ultimo;
        while (ultimo!=null){
            System.out.println(ultimo.numero+"  "+ultimo.suelod);
            ultimo=ultimo.siguiente;

        }
        ultimo=auxiliar;
}
public void eliminar(){
        ultimo=ultimo.siguiente;
}
}

    public static void main(String[] args) {
nodo n=new nodo(1,0);
n.agregar();
n.agregar();
        n.agregar();
        n.agregar();
n.imprimir();
        System.out.println("//////////");
n.eliminar();
n.imprimir();
        }
    }

