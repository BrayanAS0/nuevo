package Tareas_Estructura;

import java.util.Stack;

public class prueba {
    public static void main(String[] args) {
        Stack <Integer> pila= new Stack<>();
        pila.push(9);
        pila.push(1);
        System.out.println(pila.pop());
        System.out.println(pila.pop());
        pila.push(11111);
        System.out.println(pila);
    }
}
