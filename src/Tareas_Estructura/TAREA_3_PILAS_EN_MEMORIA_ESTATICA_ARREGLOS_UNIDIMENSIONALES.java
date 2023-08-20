package Tareas_Estructura;

import java.util.Scanner;

/*Crear una estructura pila usando arreglos unidimensionales ejemplo: int pila[]; int top, int maximo=100; para hacer un programa en java con los METODOS:

Crea PILA

De Vacía PILA true o false

De llena PILA true o false

De Inserta elemento en la PILA

De borrar elemento de la PILA

Imprimir los elementos de la PILA

Imprimir el elemento del tope de la PILA

Imprimir la cantidad de elementos que contiene la PILA

Menú principal que llame a los métodos anteriores, entendiendo que para insertar se tiene que llamar al método de lleno antes de insertar
y para borrar se tiene que validar el método de vacío antes de borrar. */
public class TAREA_3_PILAS_EN_MEMORIA_ESTATICA_ARREGLOS_UNIDIMENSIONALES {


     static int []pila;
     static Scanner s= new Scanner(System.in);

   static   int tamaño;
    static int top=-1;
    public static void Crear_Pila(){

        System.out.println("Tamaño de la pila");
       tamaño=s.nextInt();
       pila= new int[tamaño];


    }
    public  static boolean  llena(){
        if(top==(tamaño-1)){
            return true;
        }else {
            return false;
        }

    }
    public static String insertar(){
        String resultado ="esta llena";
if(!llena()){
    top++;
    System.out.println("Numero que quieres agregar");
    pila[top]=s.nextInt();
    resultado=String.valueOf(pila[top]);

}
        return resultado;
    }
    public static boolean vacia(){
        if(top==-1){
            return true;
        }else {
            return false;
        }
    }
    public static String  elimina(){
        String resultado="No ahi espacio";
           if(!vacia()){

                       top--;

        }
         return resultado;
    }
    public static int tope(){

        return pila[top];
    }
    public static void imprimir(){
if(!vacia()){
    for (int i = 0; i <= top; i++) {
        System.out.println(pila[i]);
    }
}
    }
    public static String elementos_de_la_pila(){

        if(!vacia()){
            return "La pila contiene "+(top+1)+" elementos";
        }else return "La pila esta vacia";

    }
    public static void menu(){
        Scanner s = new Scanner(System.in);

        System.out.println("Elige una opcion\n" +
                "1.Crear una PILA \n" +
                "2.Preguntar si la PILA esta vacia\n" +
                "3.Pregunatar si Esta llena la PILA\n" +
                "4.Insertar un elemento en la PILA\n" +
                "5.Borrar elemento de la PILA\n" +
                "6.Imprimir los elementos de la PILA\n" +
                "7.Imprimir el tope de la PILA\n" +
                "8.Imprimir la cantidad de elementos que contiene la PILA\n" +
                "Si ninguna de estas opciones es la que necesitas escribe otro numero");
        int opcion=s.nextInt();
        if(opcion==1 ){
            Crear_Pila();
menu();
        }
        else if(opcion== 2 ){
            System.out.println(vacia());
            menu();
        }
        else if(opcion== 3 ){
            System.out.println(llena());
            menu();
        }
        else if(opcion== 4 ){
            System.out.println(insertar());
            menu();
        }
        else if(opcion== 5 ){
            System.out.println(elimina());
            menu();

        }
        else if(opcion== 6 ){
            imprimir();
            menu();
        }  else if(opcion== 7 ){
            System.out.println(tope());
            menu();
        }
        else if(opcion== 8 ) {
            System.out.println(elementos_de_la_pila());
            menu();
        }
       else {
            System.out.println("Saliendo del programa");
        }
    }
    public static void main(String[] args) {
menu();


    }
}
