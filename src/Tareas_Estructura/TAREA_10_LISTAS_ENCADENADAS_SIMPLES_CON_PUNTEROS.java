package Tareas_Estructura;

import java.util.Scanner;

/*Efectuar un programa en JAVA que maneje una LISTA ENCADENADA SIMPLE (LES)
 usando memoria dinámica CON OBJETOS PUNTERO  con la clase NODO

CON LOS DATOS DE INT NUMEMP, STRING NOMBRE, INT DEPTO; FLOAT SUELDO; NODO  NEXT;

USAR LOS APUNTADORES FIRST,ANT,TEMP,NVONODO

    Y los métodos de:

Crear la LES

Verificar si esta vacia

Insertar un elemento ORDENADO DE MENOR  MAYOR POR DEPTO Y DENTRO EL POR NUEMP

Borrar un elemento BUSCANDODOLO POR EL CAMPO DE NUMEP

Imprimir todos los elementos de LES

Imprimir los nodos con el DEPTO igual a X

Imprimir el primer elemento de la  LES

Imprimir el tamaño (cantidad de nodos)  de la LES

Imprimir los nodos con SUELDO >=XSAL

Método de invertir la LES */
public class TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS {
    public TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS derecha_primer = null, izquierda_siguiente = null, temporal_derecha_primer =null, anterior=null;//objectos en los que se les vaciara
    int numero_de_empleado, departamento, contador_de_la_lista;
    String nombre;
    float sueldo;

    //constructor
    public TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS(int numero_de_empleado_p, String nombre_del_empleado, float sueldo_de_empleado, int departamento_del_empleado) {
        numero_de_empleado = numero_de_empleado_p;
        nombre = nombre_del_empleado;
        sueldo = sueldo_de_empleado;
        departamento = departamento_del_empleado;

    }

    public void agregar(int numero_de_empleado, String nombre, float sueldo, int departamento) {
        TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS dato = new TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS(numero_de_empleado, nombre, sueldo, departamento);//obcteto de la clase nodo

        if (derecha_primer == null) {// si es el primer nodo no ahi mas nodos entoces enlzar
            derecha_primer = dato;
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("El empleado: " + derecha_primer.numero_de_empleado + "\nNombre :" + derecha_primer.nombre + "\nSueldo: "
                    + derecha_primer.sueldo + "\nDepartamneto: " + derecha_primer.departamento + "\n----------------------------------------------------------------------------------------");
            contador_de_la_lista++;


        } else {
          temporal_derecha_primer = derecha_primer;
                   anterior= derecha_primer;//inservible
         while ((temporal_derecha_primer != null) && (temporal_derecha_primer.sueldo < dato.sueldo)) {
                anterior = temporal_derecha_primer;
                temporal_derecha_primer = temporal_derecha_primer.izquierda_siguiente;
            }
            while ((temporal_derecha_primer != null) && (temporal_derecha_primer.departamento == dato.departamento) && (temporal_derecha_primer.numero_de_empleado < dato.numero_de_empleado)) {
                anterior = temporal_derecha_primer;
                temporal_derecha_primer = temporal_derecha_primer.izquierda_siguiente;
            }

            if (temporal_derecha_primer == derecha_primer) {
                dato.izquierda_siguiente = temporal_derecha_primer;
                derecha_primer = dato;

            } else {
                dato.izquierda_siguiente = anterior.izquierda_siguiente;//apuntador
                anterior.izquierda_siguiente = dato;//dato
            }
            contador_de_la_lista++;
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("El empleado: " + dato.numero_de_empleado + "\nNombre :" + dato.nombre + "\nSueldo: "
                    + dato.sueldo + "\nDepartamneto: " + dato.departamento + "\n----------------------------------------------------------------------------------------");
        }

    }

    public void eliminar_empleado_igual_a_del(int numero_de_empleado_que_se_eliminara) {
        TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS temp = derecha_primer;
        TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS ant = temp;
        if (derecha_primer == null) {
            System.out.println("La lista esta vacia");

            return;
        }
        if (derecha_primer.numero_de_empleado == numero_de_empleado_que_se_eliminara) {//si fuera el primer nodo de la lista
            derecha_primer = derecha_primer.izquierda_siguiente;
            contador_de_la_lista--;
            System.out.println("primer nodo  de la lista eliminado");
        } else {
            while ((temp != null) && (temp.numero_de_empleado != numero_de_empleado_que_se_eliminara)) {
                ant = temp;
                temp = temp.izquierda_siguiente;
            }
            if (temp == null) {
                System.out.println("el numero de empleado no esta" + numero_de_empleado_que_se_eliminara);
                return;//inservible

            }
            ant.izquierda_siguiente = temp.izquierda_siguiente;
            System.out.println("nodo con el numero de empleado" + numero_de_empleado_que_se_eliminara + "elimado");
            contador_de_la_lista--;

        }

    }

    public void imprimir() {
        TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS tempora_de_first = derecha_primer;
        if (derecha_primer == null) {
            System.out.println("no ahi nodos ");

            return;
        }
        while (tempora_de_first != null) {
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("\nNumero de empleado :" + tempora_de_first.numero_de_empleado + "\n" + "Nombre :" + tempora_de_first.nombre + "\nSueldo: " + tempora_de_first.sueldo + "\nDepartamento:" + tempora_de_first.departamento + "\n----------------------------------------------------------------------------------------");
            tempora_de_first = tempora_de_first.izquierda_siguiente;
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }

    public void imprimir_de_uno_departamento_especifico(int departamento) {
        TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS tempora_de_first = derecha_primer;
        if (derecha_primer == null) {
            System.out.println("no ahi nodos ");

            return;
        }


        while (tempora_de_first != null) {
            if (departamento == tempora_de_first.departamento) {
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("\nNumero de empleado :" + tempora_de_first.numero_de_empleado + "\n" + "Nombre :" + tempora_de_first.nombre + "\nSueldo: " + tempora_de_first.sueldo + "\nDepartamento:" + tempora_de_first.departamento + "\n----------------------------------------------------------------------------------------");
                System.out.println("----------------------------------------------------------------------------------------");

            }
            tempora_de_first = tempora_de_first.izquierda_siguiente;
        }
    }

    public void tamaño() {
        System.out.println("la cantidad de elemento es " + contador_de_la_lista);

    }

    public void esta_vacia() {
        TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS temp = derecha_primer;
        if (derecha_primer == null) {
            System.out.println("la lista esta vacia");


        } else {
            System.out.println("tiene nodos");
        }
    }

    public void imprimir_el_primero() {
        TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS temp = derecha_primer;
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("\nNumero de empleado :" + temp.numero_de_empleado + "\n" + "Nombre :" + temp.nombre + "\nSueldo: " + temp.sueldo + "\nDepartamento:" + temp.departamento + "\n----------------------------------------------------------------------------------------");

    }

    public void Buscar_sueldos_mayores_a() {
        Scanner s = new Scanner(System.in);
        TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS temp = derecha_primer;
        System.out.println("sueldo");
        float valor_que_quiero_que_sea_mayor_a_este = s.nextFloat();
        if (derecha_primer == null) {
            System.out.println("no tiene nodos ");


        } else {
            System.out.println("Los empleado con el sueldo mayor o iguales a  " + valor_que_quiero_que_sea_mayor_a_este + " son");

            while (temp != null) {

                if ((temp.sueldo >= valor_que_quiero_que_sea_mayor_a_este)) {
                    System.out.println("----------------------------------------------------------------------------------------");
                    System.out.println("\nNumero de empleado :" + temp.numero_de_empleado + "\n" + "Nombre :" + temp.nombre + "\nSueldo: " + temp.sueldo + "\nDepartamento:" + temp.departamento + "\n----------------------------------------------------------------------------------------");

                }
                temp = temp.izquierda_siguiente;
            }
            System.out.println("----------------------------------------------------------------------------------------");
        }
    }

    public void invertir() {
        TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS anterior, first_temporal, valor_para_temporal_extra;
        first_temporal = derecha_primer;

        anterior = derecha_primer;

        valor_para_temporal_extra = derecha_primer.izquierda_siguiente;
        while (first_temporal != null) {
            first_temporal = valor_para_temporal_extra.izquierda_siguiente;
            valor_para_temporal_extra.izquierda_siguiente = anterior;
            if (anterior == derecha_primer) {
                anterior.izquierda_siguiente = null;
            }
            anterior = valor_para_temporal_extra;
            valor_para_temporal_extra = first_temporal;


        }
        derecha_primer = anterior;


    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS lista = new TAREA_10_LISTAS_ENCADENADAS_SIMPLES_CON_PUNTEROS(0, "", 0, 0);


        int opcion;
        do {

            System.out.println("Eliga una opcion " +
                    "\n1.salida" +
                    "\n2.Alta de empelado" +
                    "\n3.eliminar empleado" +
                    "\n4.Impirmir lista simple" +
                    "\n5.Imprimir tamaño " +
                    "\n6.Imprimir sueldo que sea mayor a tal sueldo " +
                    "\n7.Invertir" +
                    "\n8.Imprimir de un departamento en especifico" +
                    "\n9.Esta vacia " +
                    "\n10.Imprimir el primer elemento");
            opcion = s.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("saliendo del programa");

                    break;
                case 2:
                    System.out.println("Numero de empleado");
                    int numero_de_empleado = s.nextInt();
                    System.out.println("Nombre del empleado");
                    String nombre_del_empleado = s.next();
                    System.out.println("Sueldo");
                    float sueldo = s.nextFloat();
                    System.out.println("Departamento del empleado");
                    int departamento = s.nextInt();
                    lista.agregar(numero_de_empleado, nombre_del_empleado, sueldo, departamento);
                    break;
                case 3:
                    System.out.println("Numero de emepleado a eliminar");
                    int numero = s.nextInt();
                    lista.eliminar_empleado_igual_a_del(numero);
                    break;
                case 4:
                    lista.imprimir();
                    break;
                case 5:
                    lista.tamaño();
                    break;
                case 6:
                    lista.Buscar_sueldos_mayores_a();
                    break;
                case 7:
                    lista.invertir();
                    break;
                case 8:
                    System.out.println("Departamento que requiera la impresion");
                    lista.imprimir_de_uno_departamento_especifico(s.nextInt());
                    break;
                case 9:
                    lista.esta_vacia();
                    break;
                case 10:
                    lista.imprimir_el_primero();
                    break;
                default:
                    System.out.println("opcion incorrecta");
            }
        }while (opcion!=1);
    }

}/*Crear la LES



Insertar un elemento ORDENADO DE MENOR  MAYOR POR DEPTO Y DENTRO EL POR NUEMP


*/









