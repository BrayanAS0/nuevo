package Tareas_Estructura;

import java.util.Scanner;

public class factorial {
  static   int resultado =1;
  static int fac;
    public static void no_recursivo(int i){
        int r=1;

        for (int j = i; j >=1 ; j--) {
            r=r*j;

        }
        System.out.println(r+"  No recursivo");
    }
    public static int recursivo(int i){

        int factorial=i;

        if(factorial==0){
            System.out.println(resultado+" Recursivo");
            return 1;
        }else {
            resultado = resultado *factorial;
            recursivo(i-1);
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        int  n =6;
        no_recursivo(n);
        recursivo(n);
    }
}
