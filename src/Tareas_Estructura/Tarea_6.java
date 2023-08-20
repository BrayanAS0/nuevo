package Tareas_Estructura;

import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Stack;

public class Tarea_6 {

    static Scanner s = new Scanner(System.in);

    public static int isp(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '&' || ch == '(') {
            return 0;
        } else if (ch == '^') {
            return 3;
        }
        return -1;
    }

    public static int icp(char ch) {
        if (ch == '+' || ch == '-') {
            return 1;
        } else if (ch == '*' || ch == '/') {
            return 2;
        } else if (ch == '&') {
            return 0;
        } else if (ch == '^') {
            return 4;
        } else if (ch == '(') {
            return 4;
        }
        return -100;
    }


    public static String infijoPostfijo(String expresion_que_se_envio) {//llego de la  expresion es el primer lugar donde llega
        String resultado = "";//creop un string donde se depositaran el resultado de la expresion postfija
        Stack<Character> pila_donde_se_guarnda_caracteres = new Stack<>();
        pila_donde_se_guarnda_caracteres.push('&');//pone un caracter para que tenga algo y no este vacio
        for (int i = 0; i < expresion_que_se_envio.length(); i++) {



            if (Character.isLetterOrDigit(expresion_que_se_envio.charAt(i))){

                resultado = resultado + expresion_que_se_envio.charAt(i);

            }

            else if (expresion_que_se_envio.charAt(i) == ')') {
                while (!pila_donde_se_guarnda_caracteres.isEmpty() && pila_donde_se_guarnda_caracteres.peek() != '(')
                    resultado = resultado + pila_donde_se_guarnda_caracteres.pop();


                if (!pila_donde_se_guarnda_caracteres.isEmpty() && pila_donde_se_guarnda_caracteres.peek() != '(')
                    return "expresion invalida";


                else
                    pila_donde_se_guarnda_caracteres.pop();
            } else //un operador enconctrado
            {
                //encontar un operador
                while (!pila_donde_se_guarnda_caracteres.isEmpty() && icp(expresion_que_se_envio.charAt(i)) <= isp(pila_donde_se_guarnda_caracteres.peek())) {
                    if (pila_donde_se_guarnda_caracteres.peek() == '(')
                        return "expresion erronea";

                    resultado = resultado + pila_donde_se_guarnda_caracteres.pop();
                }

                pila_donde_se_guarnda_caracteres.push(expresion_que_se_envio.charAt(i));
            }
            System.out.println(resultado);
        }

        //saxar todos los opersadores de la pila
        while (pila_donde_se_guarnda_caracteres.peek() != '&') {
            if (pila_donde_se_guarnda_caracteres.peek() == '(') {
                return "expresion invalida";

            }
            resultado = resultado + pila_donde_se_guarnda_caracteres.pop();
        }

        return resultado;

    }

    public static float evaluaposfijo(String expresion_completa) {
        
        int temp1, temp2, resultado = 0, si_en_la_expresion_tiene_una_letra;
        Stack<Integer> pila2 = new Stack<>();
        for (int i = 0; i < expresion_completa.length(); i++) {
            char expresion_que_se_envio = expresion_completa.charAt(i);
            if (Character.isLetterOrDigit(expresion_que_se_envio)) {
                if (Character.isLetter(expresion_que_se_envio)) {
                    System.out.println("dame el valor de " + expresion_que_se_envio);
                    si_en_la_expresion_tiene_una_letra = s.nextInt();
                    pila2.push(si_en_la_expresion_tiene_una_letra);

                } else {
                    pila2.push(java.lang.Integer.parseInt(String.valueOf(expresion_que_se_envio)));
                }
                // System.out.println("dame el valor de " + expresion_que_se_envio);
                // si_en_la_expresion_tiene_una_letra = s.nextInt();
                // pila2.push(si_en_la_expresion_tiene_una_letra);

            } else {
                temp2 = pila2.pop();
                temp1 = pila2.pop();
                if (expresion_que_se_envio == '+') {
                    resultado = temp1 + temp2;
                } else if (expresion_que_se_envio == '-') {
                    resultado = temp1 - temp2;
                } else if (expresion_que_se_envio == '*') {
                    resultado = temp1 * temp2;
                } else if (expresion_que_se_envio == '/') {
                    resultado = temp1 / temp2;
                } else if (expresion_que_se_envio == '^') {
                    resultado = (int) Math.pow(temp1, temp2);
                }
                pila2.push(resultado);
            }
        }
        if (pila2.size() == 1)
            return (pila2.peek());
        else return -1;
    }
//A=4 B=2 C=2 D=1 N=4 K=1 M=3 F=4            ( A /B *C )- (D+N/k) ^( M+D*F)

    public static void main(String[] args) {
        System.out.println("Inserte la operacion");
        String exp = s.nextLine();//aqui es donde se escribe la expresion
exp=exp.replace(" ", "");
        System.out.println(exp);

        System.out.println("expresion en postfijo " + infijoPostfijo(exp));//mando la expresion que anteriormente hice al clase infijo
        System.out.println("el resultado es es " + evaluaposfijo(infijoPostfijo(exp)));
    }
}
