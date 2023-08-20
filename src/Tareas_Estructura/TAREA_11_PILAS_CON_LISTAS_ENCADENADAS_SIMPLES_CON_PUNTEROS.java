package Tareas_Estructura;

import java.util.Scanner;

public class TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS {
  int numero_de_empleado,departamento;
  String nombre;
   float suledo;
   static Scanner s = new Scanner(System.in);
   static  int tamaño;
   public  TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS top=null;
    public   TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS siguiente=null;
    public  TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS temporal,ant;
public     TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS(int numero_de_empleado,String nombre ,float sueldo,int departamento){
this.departamento=departamento;
this.numero_de_empleado=numero_de_empleado;
this.suledo=sueldo;
this.nombre=nombre;


}

public  boolean esta_vacia(){
    return top==null;
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
    TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS nuevo_nodo = new TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS(numero_de_empleado, nombre, suledo, departamento);
    System.out.println("El empleado: " + nuevo_nodo.numero_de_empleado + "\nNombre :" + nuevo_nodo.nombre + "\nSueldo: "
            + nuevo_nodo.suledo + "\nDepartamneto: " + nuevo_nodo.departamento + "\n----------------------------------------------------------------------------------------");

    nuevo_nodo.siguiente = top;

top=nuevo_nodo;
tamaño++;
}
    public  void invertir(){
        TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS anterior, first_temporal, valor_para_temporal_extra;
        first_temporal = top;

        anterior = top;

        valor_para_temporal_extra = top.siguiente;
        while (first_temporal != null) {
            first_temporal = valor_para_temporal_extra.siguiente;
            valor_para_temporal_extra.siguiente = anterior;
            if (anterior == top) {
                anterior.siguiente = null;
            }
            anterior = valor_para_temporal_extra;
            valor_para_temporal_extra = first_temporal;


        }
        top = anterior;

    }
public   void eliminar(){

    top=top.siguiente;
    tamaño--;
}

public  void  ultimo_ingresado(){
    TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS p= new TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS(0, "", 0, 0);
    System.out.println("El empleado: " + top.numero_de_empleado + "\nNombre :" + top.nombre + "\nSueldo: "
            + top.suledo + "\nDepartamneto: " + top.departamento + "\n----------------------------------------------------------------------------------------");

}
public void imprimir() {
    TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS lista = new TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS(0, "", 0, 0);
    lista = top;
    while (top != null) {
        System.out.println("El empleado: " + top.numero_de_empleado + "\nNombre :" + top.nombre + "\nSueldo: "
                + top.suledo + "\nDepartamneto: " + top.departamento + "\n----------------------------------------------------------------------------------------");
        top = top.siguiente;
    }
    top=lista;
}
    public void imprimir_por_departamento() {
        TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS lista = new TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS(0, "", 0, 0);
        lista = top;
        System.out.println("en que departamneto buscas los empelados");
        boolean si_ahi=false;
        int departamento_que_pide=s.nextInt();
        while (top != null) {
            if (top.departamento==departamento_que_pide  ){
            System.out.println("El empleado: " + top.numero_de_empleado + "\nNombre :" + top.nombre + "\nSueldo: "
                    + top.suledo + "\nDepartamneto: " + top.departamento + "\n----------------------------------------------------------------------------------------");
      si_ahi=true;
            }

            top = top.siguiente;
        }
        if(si_ahi){

        }else {
            System.out.println("no empleados en ese departamento");
        }
        top=lista;
    }
    public void imprimir_por_sueldo() {
        TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS lista = new TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS(0, "", 0, 0);
        lista = top;
        System.out.println("apartir de que sueldo igual o mayor buscas a los empleados");
        boolean si_ahi=false;
        int sueldo_que_buscas=s.nextInt();
        while (top != null) {
            if (top.suledo>=sueldo_que_buscas  ){
                System.out.println("El empleado: " + top.numero_de_empleado + "\nNombre :" + top.nombre + "\nSueldo: "
                        + top.suledo + "\nDepartamneto: " + top.departamento + "\n----------------------------------------------------------------------------------------");
                si_ahi=true;
            }else{

            }

            top = top.siguiente;
        }
        if(si_ahi){

        }else {
            System.out.println("no empleados que tengan ese sueldo mayor o igual");
        }
        top=lista;
    }
    public int tamaño(){
    return tamaño;
    }

    public static void main(String[] args) {
        TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS lista= new TAREA_11_PILAS_CON_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS(0, "", 0, 0);

        Scanner s= new Scanner(System.in);
        int opcion;
        do {

            System.out.println("Eliga una opcion " +
                    "\n1.salir del programa" +
                    "\n2.Alta de empelado" +
                    "\n3.eliminar empleado top (el que esta en top)" +
                    "\n4.Impirmir lista simple tipo pila" +
                    "\n5.Imprimir tamaño de  la lista tipo pila " +
                    "\n6.Imprimir sueldo que sea mayor a tal sueldo " +
                    "\n7.Invertir" +
                    "\n8.Imprimir de un departamento en especifico" +
                    "\n9.Esta vacia " +
                    "\n10.Imprimir el ultimo");
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
lista.ultimo_ingresado();
                    break;
                default:
                    System.out.println("opcion incorrecta");
            }
        }while (opcion!=1);
    }
    }


