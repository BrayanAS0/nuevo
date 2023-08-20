package Tareas_Estructura;

import java.util.Arrays;
import java.util.Scanner;

public class Tarea_1_Arreglos_Unidimensionales {
    /*Desarrollar un programa en JAVA que contenga los siguientes métodos.



Definir un arreglo unidimensional de N valores .

Leer/cargar N valores en el arreglo.

Ordenar el arreglo de menor a mayor.

Obtener el promedio de los valores del arreglo. Suma de valores entre el total de números del arreglo.

Moda. El número que mas se repite en el arreglo.

Mediana. El número que se encuentra en la posición media del arreglo ordenado de menor  mayor.  N/2 división entera.

El número de la posición 0

El número de la posición n

Valor máximo del arreglo

Valor mínimo del arreglo */
    public static void main(String[] args) {

        Scanner s= new Scanner(System.in);
        System.out.println("Escribe el tamaño del arreglo");
        int n= s.nextInt();
        double promedio=0;
        int contador=0,auxiliar=0;
int []arreglo1= new int[n];
        int []arreglo2= new int[n];
        for (int i = 0; i < arreglo1.length; i++) {
            arreglo1[i]= (int) (Math.random()*10);
            promedio= promedio+arreglo1[i];
            System.out.println("Arreglo ["+i+"] = "+arreglo1[i]);

        }
Arrays.sort(arreglo1);
        for (int i = 0; i < arreglo1.length; i++) {
            for (int j = 0; j <arreglo2.length ; j++) {
                if(arreglo1[i]== arreglo1[j]) {
                    contador++;
                }



            }

            arreglo2[i]=contador;
            contador=0;
        }
        System.out.println("Arreglo acomodado ");
        for (int i = 0; i < arreglo1.length; i++) {
         if(arreglo2[i]>=arreglo2[auxiliar]){
             auxiliar=i;



            }
            System.out.println("Arreglo ["+i+"] = "+arreglo1[i]);

        }

        System.out.println("promedio = " + promedio/arreglo1.length);
        System.out.println("Moda= "+arreglo1[auxiliar]);
        System.out.println("La mediana ="+arreglo1[Math.floorDiv(arreglo1.length, 2)]);
        System.out.println("El numero que se encuentra en la posicion 0 = "+arreglo1[0]);
        System.out.println("El nuemro de la posicion n=  "+arreglo1[arreglo1.length-1]);
        System.out.println(  "Valor max del arreglo"+ Arrays.stream(arreglo1).max());
        System.out.println(  "Valor min del arreglo"+ Arrays.stream(arreglo1).min());

    }
}