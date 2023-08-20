package Tareas_Estructura;

import java.util.Scanner;
import java.util.Stack;

public class TAREA_16_TORRES_DE_HANOI {
    private static final int NUM_DISCOS = 5;

    private Stack<Integer> torre_a;
    private Stack<Integer> torre_b;
    private Stack<Integer> torre_c;

    public TAREA_16_TORRES_DE_HANOI() {
        torre_a = new Stack<>();
        torre_b = new Stack<>();
        torre_c = new Stack<>();

        for (int i = NUM_DISCOS; i >= 1; i--) {
            torre_a.push(i);
        }
    }

    public void jugar() {
        imprimir();

        moverDiscos(NUM_DISCOS, torre_a, torre_c, torre_b);

        System.out.println("¡Juego terminado!");
    }

    private void moverDiscos(int numDiscos, Stack<Integer> origen, Stack<Integer> destino, Stack<Integer> auxiliar) {
        if (numDiscos == 1) {
            moverDisco(origen, destino);
            imprimir();
        } else {
            moverDiscos(numDiscos - 1, origen, auxiliar, destino);
            moverDisco(origen, destino);
            imprimir();
            moverDiscos(numDiscos - 1, auxiliar, destino, origen);
        }
    }

    private void moverDisco(Stack<Integer> origen, Stack<Integer> destino) {
        int disco = origen.pop();
        destino.push(disco);
    }

    private void imprimir() {
        System.out.println("Torre 1: " + torre_a);
        System.out.println("Torre 2: " + torre_b);
        System.out.println("Torre 3: " + torre_c);
        System.out.println();
    }

    public static void main(String[] args) {
        TAREA_16_TORRES_DE_HANOI p= new TAREA_16_TORRES_DE_HANOI();
        p.jugar();
    }
}
