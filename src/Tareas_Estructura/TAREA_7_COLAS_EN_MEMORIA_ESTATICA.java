package Tareas_Estructura;

import java.util.Scanner;

/*Desarrollar un programa en JAVA que defina una estructura COLA usando
 arreglos unidimensionales ejemplo: int cola[]; int inicio,fin,
 int maximo=100; para hacer un programa  con los METODOS:

Crear la COLA

De Vacia COLA true o false

De llena COLA true o false

De Inserta elemento en la COLA

De borrar elemento de la COLA

Imprimir los elementos de la COLA

Imprimir el  primer elemento de la COLA

Imprimir el último elemento de la COLA

Imprimir la cantidad de elementos que contiene la COLA

Menú principal que llame a los métodos anteriores,
 entendiendo que para insertar se
tiene que llamar al método de lleno antes de insertar y
 para borrar se tiene que validar
 el método de vacío antes de borrar. USAR OPERACION MODULO
 PARA MOVER LOS APUNTADORES inicio y fin. */
public class TAREA_7_COLAS_EN_MEMORIA_ESTATICA {
    static Scanner s = new Scanner(System.in);
    static int tamaño_de_la_cola = 100;
    static int[] cola;
    //static int frente = -1, fin = -1;
    static int inicio = 0, fin = 0;

    public static void crear_cola() {
        cola = new int[tamaño_de_la_cola];

    }

    public static boolean pregutar_si_vacia() {

        return inicio == fin;

    }

    public static boolean pregutar_si_llena() {

       return fin == (inicio);
    }

    public static void insertar() {

        /*if (fin < (tamaño_de_la_cola - 1)) {
            fin++;
            System.out.println("Elemento que quiera agregar a la cola");

            cola[fin] = s.nextInt();
            ;
            if (fin == 0) {
                frente = 0;
            }
        }*/
        int temp = fin;
        fin = (fin + 1) % tamaño_de_la_cola;
        System.out.println(fin);
     //   System.out.println(inicio+" valor dde inicio");
      //  System.out.println(fin+"valor final");
        if (!pregutar_si_llena()) {
            System.out.println("elemento que quiera insertar");
            cola[fin] = s.nextInt();
        } else {
            fin = temp;
            System.out.println("cola llena");
        }
    //    System.out.println(inicio+" valor de inicio");
     //   System.out.println(fin+"valor final");
    }
        public static void quitar () {
       /* if(frente!= -1){
          int n= cola[frente];
          if(frente==fin){
              frente=-1;
              fin=-1;
          }else {
          frente++;
          }


        }else{
            System.out.println("la cola esta vacia");
        }*/
            if (!pregutar_si_llena()) {
                inicio = (inicio + 1) % tamaño_de_la_cola;
            }

        }
        public static void imprimir(){
        int i = inicio;
        while ((i!=fin)){
            i=(i+1)%tamaño_de_la_cola;
            System.out.println("elemento :"+cola[i]);
        }

        }
        public static void ultimo(){
        if (!pregutar_si_vacia()){
            System.out.println(cola[fin]);
        }
        }
        public static void primero(){
        if(!pregutar_si_vacia()){
            System.out.println(cola[(inicio +1)%tamaño_de_la_cola]);
        }
        }
        public static void menu () {
            int opcion;
            do {
                System.out.println("Ingrese la opcion\n" +
                        "1.Insetar\n" +
                        "2.quitar\n" +
                        "3.Preguntar si esta llena\n" +
                        "4.Preguntar si esta vacia\n" +
                        "5.crear cola\n" +
                        "6.imprimir\n" +
                        "7.imprimir el primero elemento\n" +
                        "8.imprimir el ultimo\n" +
                        "9.cantidad de elementos que tiene la cola\n" +
                        "10.Salir del programa");
                opcion = s.nextInt();
                switch (opcion) {
                    case 1:

                        insertar();
                        break;
                    case 2:
                        quitar();
                        break;
                    case 3:
                        System.out.println(pregutar_si_llena());
                        break;
                    case 4:
                        System.out.println(pregutar_si_vacia());
                        break;
                    case 5:
                        crear_cola();
                        break;
                    case 6:
                        imprimir();
                        break;
                    case 7:
                        primero();
                        break;
                    case 8:
                        ultimo();
                        break;
                    case 9:
                        tamaño_De_la_cola();
                        break;
                    case 10:
                        System.out.println("saliendo del programa");
                        break;
                    default:
                        System.out.println("Inserte de nuevo");
                }

            }
            while (opcion != 10);
        }
        public static void tamaño_De_la_cola(){
            System.out.println("cantidad de elementos que tiene la cola : "+(fin-inicio));
        }


    public static void main(String[] args) {
menu();

    }
}
