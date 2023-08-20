package Practica;

import javax.swing.*;
import java.util.Comparator;
import java.util.LinkedList;

public class Practica_Linked {
    static LinkedList<Object> objetos = new LinkedList<>();
public Practica_Linked (int t){

}
    public static void main(String[] args) {
        objetos.add(1);
objetos.push(1000);
        objetos.add(2);
        objetos.add(3);
        objetos.add(4);

        System.out.println(objetos);
    }
}
