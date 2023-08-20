package Tareas_Estructura;

import java.util.Scanner;
/*Efectuar un programa en JAVA que maneje una LISTA ENCADENADA SIMPLE (LES) usando memoria dinámica CON OBJETOS PUNTERO  con la clase NODO

CON LOS DATOS DE INT NUMEMP, STRING NOMBRE, INT DEPTO; FLOAT SUELDO; NODO  NEXT;

USAR LOS APUNTADORES INICIO,FIN,TEMP,ANT;

    Y los métodos de:

Crear la LES

Verificar si esta vacía.

Insertar un elemento.

Borrar un elemento.

Imprimir todos los elementos de COLA-LES

Imprimir los nodos con el DEPTO igual a X

Imprimir el ÚLTIMO elemento de la  COLA-LES

Imprimir el PRIMER elemento de la COLA-LES

Imprimir el tamaño (cantidad de nodos)  de la LES

Imprimir los nodos con SUELDO >=XSAL

Método de invertir la COLA-LES */
public class TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO {
  int numero_de_empleado,departamento;
  String nombre;
   float suledo;
   static Scanner s = new Scanner(System.in);
   static  int tamaño;
   public TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO inicio =null;
    public TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO siguiente=null,fin=null;
    public TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO temporal,ant;
public TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO(int numero_de_empleado, String nombre , float sueldo, int departamento){
this.departamento=departamento;
this.numero_de_empleado=numero_de_empleado;
this.suledo=sueldo;
this.nombre=nombre;


}

public  boolean esta_vacia(){
    return inicio ==null;
}

public  void agregar () {

    System.out.println("Numero de empleado");
    numero_de_empleado = s.nextInt();
    System.out.println("Nombre");
    nombre = s.next();
    System.out.println("Sueldo");
    suledo = s.nextFloat();
    System.out.println("Departamento");
    departamento = s.nextInt();
    TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO nuevo_nodo = new TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO(numero_de_empleado, nombre, suledo, departamento);
    System.out.println("El empleado: " + nuevo_nodo.numero_de_empleado + "\nNombre :" + nuevo_nodo.nombre + "\nSueldo: "
            + nuevo_nodo.suledo + "\nDepartamneto: " + nuevo_nodo.departamento + "\n----------------------------------------------------------------------------------------");
    nuevo_nodo.siguiente=null;
    if(esta_vacia()){
        inicio=nuevo_nodo;
        fin=nuevo_nodo;
    }
    fin.siguiente=nuevo_nodo;
    fin=nuevo_nodo;
    tamaño++;
}
    public  void invertir(){
        TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO anterior, first_temporal, valor_para_temporal_extra;
        first_temporal = inicio;

        anterior = inicio;

        valor_para_temporal_extra = inicio.siguiente;
        while (first_temporal != null) {
            first_temporal = valor_para_temporal_extra.siguiente;
            valor_para_temporal_extra.siguiente = anterior;
            if (anterior == inicio) {
                anterior.siguiente = null;
            }
            anterior = valor_para_temporal_extra;
            valor_para_temporal_extra = first_temporal;


        }
        inicio = anterior;

    }
public   void eliminar(){

   if(fin==inicio){
       inicio=null;
               fin=null;
   }else{
       inicio=inicio.siguiente;
   }
   tamaño--;
}

public  void  primer_ingresado(){
    TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO p= new TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO(0, "", 0, 0);
    System.out.println("El empleado: " + inicio.numero_de_empleado + "\nNombre :" + inicio.nombre + "\nSueldo: "
            + inicio.suledo + "\nDepartamneto: " + inicio.departamento + "\n----------------------------------------------------------------------------------------");

}
public void imprimir() {
    TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO lista = new TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO(0, "", 0, 0);
    lista = inicio;
    while (inicio != null) {
        System.out.println("El empleado: " + inicio.numero_de_empleado + "\nNombre :" + inicio.nombre + "\nSueldo: "
                + inicio.suledo + "\nDepartamneto: " + inicio.departamento + "\n----------------------------------------------------------------------------------------");
        inicio = inicio.siguiente;
    }
    inicio =lista;
}
    public void imprimir_por_departamento() {
        TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO lista = new TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO(0, "", 0, 0);
        lista = inicio;
        System.out.println("en que departamneto buscas los empelados");
        boolean si_ahi=false;
        int departamento_que_pide=s.nextInt();
        while (inicio != null) {
            if (inicio.departamento==departamento_que_pide  ){
            System.out.println("El empleado: " + inicio.numero_de_empleado + "\nNombre :" + inicio.nombre + "\nSueldo: "
                    + inicio.suledo + "\nDepartamneto: " + inicio.departamento + "\n----------------------------------------------------------------------------------------");
      si_ahi=true;
            }

            inicio = inicio.siguiente;
        }
        if(si_ahi){

        }else {
            System.out.println("no empleados en ese departamento");
        }
        inicio =lista;
    }
    public void imprimir_por_sueldo() {
        TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO lista = new TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO(0, "", 0, 0);
        lista = inicio;
        System.out.println("apartir de que sueldo igual o mayor buscas a los empleados");
        boolean si_ahi=false;
        int sueldo_que_buscas=s.nextInt();
        while (inicio != null) {
            if (inicio.suledo>=sueldo_que_buscas  ){
                System.out.println("El empleado: " + inicio.numero_de_empleado + "\nNombre :" + inicio.nombre + "\nSueldo: "
                        + inicio.suledo + "\nDepartamneto: " + inicio.departamento + "\n----------------------------------------------------------------------------------------");
                si_ahi=true;
            }else{

            }

            inicio = inicio.siguiente;
        }
        if(si_ahi){

        }else {
            System.out.println("no empleados que tengan ese sueldo mayor o igual");
        }
        inicio =lista;
    }
    public int tamaño(){
    return tamaño;
    }

    public static void main(String[] args) {
        TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO lista= new TAREA_12_COLA_EN_FORMA_DE_LISTA_ENCADENADA_SIMPLE_CON_OBJETOS_PUNTERO(0, "", 0, 0);

        Scanner s= new Scanner(System.in);
        int opcion;
        do {

            System.out.println("Eliga una opcion " +
                    "\n1.salir del programa" +
                    "\n2.Alta de empelado" +
                    "\n3.eliminar el primer el elemeto de la cola" +
                    "\n4.Impirmir lista simple tipo cola" +
                    "\n5.Imprimir tamaño de  la lista tipo cola " +
                    "\n6.Imprimir sueldo que sea mayor a tal sueldo " +
                    "\n7.Invertir" +
                    "\n8.Imprimir de un departamento en especifico" +
                    "\n9.Esta vacia " +
                    "\n10.Imprimir el primero");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("saliendo del programa");

                    break;
                case 2:
lista.agregar();

                    break;
                case 3:
                lista.eliminar();

                    break;
                case 4:
                   lista.imprimir();
                    break;
                case 5:
                    System.out.println(lista.tamaño());
                    break;
                case 6:
lista.imprimir_por_sueldo();
                    break;
                case 7:
lista.invertir();
                    break;
                case 8:
lista.imprimir_por_departamento();
                    break;
                case 9:
                    System.out.println(lista.esta_vacia());
                    break;
                case 10:
lista.primer_ingresado();
                    break;
                default:
                    System.out.println("opcion incorrecta");
            }
        }while (opcion!=1);
    }
    }


