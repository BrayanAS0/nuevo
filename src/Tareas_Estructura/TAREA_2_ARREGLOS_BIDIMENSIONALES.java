package Tareas_Estructura;

import java.util.Scanner;



/*Desarrollar un programa en JAVA que defina tres objetos de arreglos bidimensionales de tipo INT, de M renglones y N columnas

(todos de la misma dimensión), debe contener los siguientes métodos :

Leer/cargos valores para dos arreglos bidimensionales (A y B), cada uno con sus propios valores.

Realizar la SUMA de los dos arreglos Bidimensionales A y B y depositar el resultado en el arreglo C. Imprimir los tres arreglos.

Realizar la RESTA de los dos arreglos Bidimensionales A y B y depositar el resultado en el arreglo C. Imprimir los tres arreglos.

Realizar la MULTIPLICACION de los dos arreglos Bidimensionales A y B y depositar el resultado en el arreglo C. Imprimir los tres arreglos.

Obtener el promedio de cada renglón del arreglo A. Imprimir el arreglo incluyendo el promedio.

Obtener el promedio de cada renglón del arreglo B. Imprimir el arreglo incluyendo el promedio.

Clonar el arreglo A al arreglo C. iMPRIMIR AMBOS ARREGLOS. */

public class TAREA_2_ARREGLOS_BIDIMENSIONALES {
    public static void imprimir_arreglo_bidimensional(int arreglo[][]){
        for (int i = 0; i <arreglo.length ; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                System.out.println("Posicion["+i+"]["+j+"] = "+arreglo[i][j]);
            }
            System.out.println();

            }
    }

public static void clonar(int arreglo1[][], int arreglo3[][]){
arreglo3=arreglo1.clone();
    System.out.println("---------------           Arreglo 1        ------------------------------");
    imprimir_arreglo_bidimensional(arreglo1);
    System.out.println("---------------           Arreglo 3        ------------------------------");
    imprimir_arreglo_bidimensional(arreglo3);
    }

    public static void suma(int arreglo1[][],int arreglo2[][],int arreglo3[][]){
        for (int i = 0; i <arreglo1.length ; i++) {
            for (int j = 0; j < arreglo1.length; j++) {
            arreglo3[i][j]=arreglo1[i][j]+arreglo2[i][j];


            }

        }
        System.out.println();
        System.out.println("---------------           Arreglo 1        ------------------------------");
        imprimir_arreglo_bidimensional(arreglo1);
        System.out.println("---------------           Arreglo 2        ------------------------------");
        imprimir_arreglo_bidimensional(arreglo2);
        System.out.println("---------------           Arreglo 3        ------------------------------");
        imprimir_arreglo_bidimensional(arreglo3);

    }
    public static void promedio(int arreglo1[][]){
        int promedio=0;
        for (int i = 0; i <arreglo1.length ; i++) {
            promedio=0;
            for (int j = 0; j < arreglo1.length; j++) {
          promedio=promedio+arreglo1[i][j];

                System.out.println("Arreglo ["+i+"] "+"["+j+"]= "+arreglo1[i][j]);
            }

            System.out.println();
            System.out.println("Promedio  de la fila "+i+" ="+(promedio/arreglo1.length));
            System.out.println();
        }


    }
    public static void resta(int arreglo1[][],int arreglo2[][],int arreglo3[][]){
        for (int i = 0; i <arreglo1.length ; i++) {
            for (int j = 0; j < arreglo1.length; j++) {
                arreglo3[i][j]=arreglo1[i][j]-arreglo2[i][j];


            }

        }

        System.out.println();
        System.out.println("---------------           Arreglo 1        ------------------------------");
        imprimir_arreglo_bidimensional(arreglo1);
        System.out.println("---------------           Arreglo 2        ------------------------------");
        imprimir_arreglo_bidimensional(arreglo2);
        System.out.println("---------------           Arreglo 3        ------------------------------");
        imprimir_arreglo_bidimensional(arreglo3);
    }
    public static void multiplicacion(int arreglo1[][],int arreglo2[][],int arreglo3[][]){
        for (int i = 0; i <arreglo1.length ; i++) {
            for (int j = 0; j < arreglo1.length; j++) {
                arreglo3[i][j]=arreglo1[i][j]*arreglo2[i][j];


            }

        }
        System.out.println();
        System.out.println("---------------           Arreglo 1        ------------------------------");
        imprimir_arreglo_bidimensional(arreglo1);
        System.out.println("---------------           Arreglo 2        ------------------------------");
        imprimir_arreglo_bidimensional(arreglo2);
        System.out.println("---------------           Arreglo 3        ------------------------------");
        imprimir_arreglo_bidimensional(arreglo3);

    }
    public static  void llenarArreglo(int arreglo1[][],int arreglo2[][]){

        for (int i = 0; i < arreglo1.length ; i++) {
            for (int j = 0; j < arreglo1.length; j++) {
                arreglo1[i][j]= (int) (Math.random()*10);
                arreglo2[i][j]= (int) (Math.random()*10);
            }
        }

    }

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Numero de Comulmnas");
        int columnas=s.nextInt();
        System.out.println("Numero de Filas");
        int filas=s.nextInt();
        System.out.println("Numero de Columnas");

          int[][] arreglo1=new int[filas][columnas];
          int[][] arreglo2=new int[filas][columnas];
         int[][] arreglo3=new int[filas][columnas];
int largo= arreglo1.length;
llenarArreglo(arreglo1,arreglo2);
        System.out.println("Suma de arreglo 1 + arreglos 2\n\n");
suma(arreglo1,arreglo2,arreglo3);
        System.out.println("Resta de arreglo 1 - arreglos 2\n\n");
        resta(arreglo1,arreglo2,arreglo3);
        System.out.println("Multiplicacion  de arreglo 1 * arreglos 2\n\n");
        multiplicacion(arreglo1,arreglo2,arreglo3);
        System.out.println("-----------------------------Obtener el promedio del arreglo 1----------------------------------------");
promedio(arreglo1);
        System.out.println("-----------------------------Obtener el promedio del arreglo 2----------------------------------------");
        promedio(arreglo2);
        System.out.println("------------------------------Clonar el arreglo 1 en arreglo 3-----------------------------------------");
        clonar(arreglo1, arreglo3);
    }
}
