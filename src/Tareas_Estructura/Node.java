package Tareas_Estructura;

public class Node {
    int dato,dato2;
    char dato3;
    Node siguiente,anterior;
    public Node(int d, int d2, char d3){
        dato=d;
        dato2= d2;
        dato3=d3;
        siguiente=null;
        anterior=null;
    }

    public Node(int d, int d2, char d3, Node a, Node n) {
        dato = d;
        dato2 = d2;
        dato3 = d3;
        siguiente = n;
    }


}
