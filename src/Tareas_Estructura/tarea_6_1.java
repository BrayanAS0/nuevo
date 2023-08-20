package Tareas_Estructura;

import java.util.Scanner;
import java.util.Stack;

public class tarea_6_1 {
    public static String convertir(String int_la_expresion) {
        String posExpresion = "";
        Stack<Character> pila = new Stack<>();
        Stack<Character> pila2 = new Stack<>();

        for (int i = 0; i < int_la_expresion.length(); i++) {
            pila2.push(int_la_expresion.charAt(i));
            Character caracter_de_la_expresion = int_la_expresion.charAt(i);
            if (!Character.isLetterOrDigit(caracter_de_la_expresion)) {//si es cararcter va seguir todo el procedimieto

                if (pila.isEmpty()) {//si esta vacia va depositar el caracter
                    pila.push(caracter_de_la_expresion);
                } else {//si no esta vacia va comparaar con el operador de la expresion que tiene con el ultimo si es asi lo
                    if (isp(caracter_de_la_expresion) > isp(pila.peek())) {
                        pila.push(caracter_de_la_expresion);
                    } else {
                        while ((!pila.isEmpty() && !(isp(caracter_de_la_expresion) > isp(pila.peek())))) {
                            posExpresion = posExpresion + pila.pop();
                        }
                        pila.push(caracter_de_la_expresion);
                    }
                }
            } else {
                posExpresion = posExpresion + caracter_de_la_expresion;
            }
        }
        while (!pila.isEmpty()) {
            posExpresion = posExpresion + pila.pop();
        }
        return posExpresion;
    }


    public static int getpriorety(Character caracter) {
        if (caracter == '+' || caracter == '-') {
            return 1;
        } else if (caracter == '/' || caracter == '*') {
            return 2;
        } else if (caracter == '^') {
            return 4;
        } else {
            return -1;
        }
    }
    public static int isp(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;


            case '*':
            case '/':

                return 2;

            case  '(':
                return 4;
            case '^':
                return 3;
            case ')':
                return 0;
        }
        return -1;
    }
    public static int icp(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;


            case '*':
            case '/':

                return 2;

            case '&':
                return 0;
            case '^':
                return 4;
            case '(':
                return 4;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String expresion = s.next();
        System.out.println(convertir(expresion));
    }
}
