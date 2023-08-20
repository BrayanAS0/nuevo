package Tareas_Estructura;

import javax.swing.*;


public class TAREA_15_RECURSIVIDAD {
    static int resultado_factorial = 1;


    static boolean con = false;

    public static void no_recursivo(int i) {
        int r = 1;

        for (int j = i; j >= 1; j--) {
            r = r * j;

        }
        JOptionPane.showMessageDialog(null, "Resultado en forma no recursiva en forma de factorial : " + r);
    }

    public static int recursivo(int i) {


        int factorial = i;

        if (factorial == 0) {
            JOptionPane.showMessageDialog(null, "Resultado en forma de recursivdidad en forma de factorial : " + resultado_factorial);
            con = false;
            return 0;
        } else {
            if (con == false) {
                resultado_factorial = 1;
                con = true;
            }

            resultado_factorial = resultado_factorial * factorial;
            recursivo(i - 1);
            return 1;
        }
    }
    ////////////////////////////////////////////////////////


    public static int recursividad_fibonacci(int valor, int top, int anterior, int resultado, int contador) {


        if (valor == contador) {
            JOptionPane.showMessageDialog(null, "La respuesta en forma de fibonacci en forma recursiva es : " + anterior);
            return 0;
        } else {
            contador++;
            resultado = anterior + top;
            anterior = top;
            top = resultado;
            recursividad_fibonacci(valor, top, anterior, resultado, contador);
        }


        return 0;
    }

    public static void no_recursividad_fibonacci() {
        int resultado = 0;
        int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite un numero para que saque el fibonacci de forma no recursiva"));
        int anterior = 0, top = 1;
        for (int i = 0; i < valor; i++) {
            resultado = anterior + top;
            anterior = top;
            top = resultado;
        }
        JOptionPane.showMessageDialog(null, "La respuesta en forma de fibonacci en forma no recursiva es :" + anterior);
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static void suma_no_recursiva() {
        int resultado = 0;
        String numero = JOptionPane.showInputDialog("Inserte el numero");
        for (int i = 0; i < numero.length(); i++) {
            resultado = resultado + Integer.parseInt(String.valueOf(numero.charAt(i)));
        }
        JOptionPane.showMessageDialog(null, "Resultado de la suma: " + resultado);
    }

    public static void suma_recursiva(String numero, int contador, int resultado, String palabra) {


        if (numero.equalsIgnoreCase(palabra)) {
            JOptionPane.showMessageDialog(null, "Resultado de la suma de forma recursiva es : " + resultado);
            return;
        } else {
            palabra = palabra + numero.charAt(contador);
            resultado = resultado + Integer.parseInt(String.valueOf(numero.charAt(contador)));
            contador++;
            suma_recursiva(numero, contador, resultado, palabra);
        }

    }


    ////////////////////////////////////////////////////////////////////////////////////////////


    public static void main(String[] args) {
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese una opcion\n" +
                    "0.Salir del programa\n" +
                    "1.Factorial recursividad\n" +
                    "2.Factorial no recursivo\n" +
                    "3.Fibonacci recursivo\n" +
                    "4.Fibonacci no recursivo\n" +
                    "5.Suma recursiva\n" +
                    "6.Suma no recursiva\n"));
            switch (op) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
                case 1:
                    int dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero que quiera sacar el factorial"));
                    recursivo(dato);
                    break;
                case 2:
                    dato = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero que quiera sacar el factorial"));
                    no_recursivo(dato);
                    break;
                case 3:
                    ///
                    int valor = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite un numero para que saque el fibonacci  de forma recursiva"));
                    recursividad_fibonacci(valor, 1, 0, 0, 0);
                    break;
                case 4:
                    no_recursividad_fibonacci();
                    break;

                case 5:
                    String numero = JOptionPane.showInputDialog("Inserte el numero");
                    suma_recursiva(numero, 0, 0, "");
                    break;
                case 6:
                    suma_no_recursiva();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion erronea");
            }
        } while (op != 0);

    }

}

