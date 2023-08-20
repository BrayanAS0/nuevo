package Tareas_Estructura;

import javax.swing.*;

/*Efectuar un programa en JAVA que maneje una LISTA ENCADENADA SIMPLE CIRCULAR
(LESC) usando memoria dinámica CON OBJETOS PUNTERO  con la clase NODO

CON LOS DATOS DE INT NUMEMP, STRING NOMBRE, INT DEPTO; FLOAT SUELDO; NODO  NEXT;

USAR LOS APUNTADORES NC,ANT,TEMP,NVONODO

Y los métodos de:

Crear la LESC, inicializando el NC sin datos.











 */
public class TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES {


    int numero_de_empleado, departamento, contador_de_tamaño;
    float sueldo;
    String nombre;
    TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES siguiente;
    TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES nc, anterior, temp;

    public TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES(int numero_de_empleado, int departamento, float sueldo, String nombre) {
        this.numero_de_empleado = numero_de_empleado;
        this.departamento = departamento;
        this.sueldo = sueldo;
        this.nombre = nombre;
    }

    public TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES() {

    }
    public  void tamaño_De_la_lisra(){
        JOptionPane.showMessageDialog(null, "La cantidad de nodos que contiene la lista son : "+contador_de_tamaño);
    }
    public void invertir_lista(){
        TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES dato_que_seguira_adelante=nc.siguiente,anterior=nc,p;
p=anterior.siguiente;
while (dato_que_seguira_adelante!=nc){
    dato_que_seguira_adelante=p.siguiente;
    p.siguiente=anterior;
    anterior=p;
    p=dato_que_seguira_adelante;

}
nc.siguiente=anterior;


    }
    public void imprimir_por_sueldo(){
        String lista="";
        boolean tiene=false;
        int sueldo=Integer.parseInt(JOptionPane.showInputDialog(null, "Cual es el sueldo que buscas en  los empleados para imprimir igual a mayor a sueldo que ingrese"));
        TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES temporal =nc.siguiente;
        while (temporal!=nc){
            if(temporal.sueldo>=sueldo){
                lista=lista+"Numero de empleado: " + temporal.numero_de_empleado + "\nSueldo: " + temporal.sueldo + "\nDepartamento: " + temporal.departamento + "\nNombre: " + temporal.nombre + "\n----------------------------------------------------------------------------------------\n";
tiene=true;
            }
            temporal=temporal.siguiente;
        }
        if(tiene){
            JOptionPane.showMessageDialog(null, lista);
        }else{
            JOptionPane.showMessageDialog(null, "No ahi empleados que tengan ese sueldo o mayor");
        }

    }
    public void imprimir_por_departamento(){
        String lista="";
        boolean tiene=false;
        int departamento=Integer.parseInt(JOptionPane.showInputDialog(null, "Cual es el departamento que buscara los empleados"));
        TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES temporal =nc.siguiente;
        while (temporal!=nc){
            if(temporal.departamento==departamento){
                lista=lista+"Numero de empleado: " + temporal.numero_de_empleado + "\nSueldo: " + temporal.sueldo + "\nDepartamento: " + temporal.departamento + "\nNombre: " + temporal.nombre + "\n----------------------------------------------------------------------------------------\n";
                tiene=true;
            }
            temporal=temporal.siguiente;
        }
        if(tiene){
            JOptionPane.showMessageDialog(null, lista);
        }else{
            JOptionPane.showMessageDialog(null, "No ahi empleados en ese departamento");
        }

    }
public void imprimir_el_primer_elemeto_de_la_lista(){
        JOptionPane.showMessageDialog(null, "EL primero empleado es :\n" +
                "Numero de empleado :"+nc.siguiente.numero_de_empleado+"\nSueldo: "+nc.siguiente.sueldo+"\nDepartamento: "+nc.siguiente.departamento+"\nNombre del empleado: "+nc.siguiente.nombre);
}
    public void insertar() {
        int numero_de_empleado = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de empleado"));
        float sueldo = Float.parseFloat(JOptionPane.showInputDialog(null, "Inserte el sueldo", "Brayan Arias Sanchez", 1));
        int departamento = Integer.parseInt(JOptionPane.showInputDialog(null, "Departamento"));
        String nombre = JOptionPane.showInputDialog(null, "Nombre del empleado");
        TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES nuevo_nodo = new TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES(numero_de_empleado, departamento, sueldo, nombre);
        if (nc == null) {
            nc = new TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES();
            nc.siguiente = nc;


        }
        temp = nc.siguiente;
        anterior = nc;
        while ((temp != nc) && (temp.numero_de_empleado < nuevo_nodo.numero_de_empleado)) {
            anterior = temp;
            temp = temp.siguiente;

        }
        contador_de_tamaño++;
        nuevo_nodo.siguiente = anterior.siguiente;
        anterior.siguiente = nuevo_nodo;


    }

    public void imprimir() {
        TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES temp = nc.siguiente;
        String datos = "";
        while (temp != nc) {
            datos = datos + "Numero de empleado: " + temp.numero_de_empleado + "\nSueldo: " + temp.sueldo + "\nDepartamento: " + temp.departamento + "\nNombre: " + temp.nombre + "\n----------------------------------------------------------------------------------------\n";
            temp = temp.siguiente;
        }
        JOptionPane.showMessageDialog(null, datos);
    }
public void borrar(){
        TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES temporal,siguiente;
        temporal=nc.siguiente;
        anterior=nc;
        int numero_de_empleado=Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de empleado que vas a borrar", "Borrar empleado", JOptionPane.WARNING_MESSAGE));
        if(temporal==null){
            JOptionPane.showMessageDialog(null, "la lista  esta vacia");
        }else {
            while ((temporal!=nc)&& (temporal.numero_de_empleado != numero_de_empleado)){
                anterior=temporal;
                temporal=temporal.siguiente;
            }
            if(temporal==nc){
                JOptionPane.showMessageDialog(null, "numero de empleado no existe");

            }else {
                anterior.siguiente = temporal.siguiente;
                JOptionPane.showMessageDialog(null, "Numero de empleado: " + numero_de_empleado + " fue eliminado");
                contador_de_tamaño--;
            }
        }

}
public void preguntar_si_esta_vacia(){
     if(nc!=null){
         JOptionPane.showMessageDialog(null, "La lista contiene datos");

     }else {
         JOptionPane.showMessageDialog(null, "la lista esta vacia");
     }
}
    public static void main(String[] args) {
        int op;
        TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES c = new TAREA_13_LISTASE_ENCADENADAS_SIMPLES_CIRCULARES();
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la opcion\n" +
                    "0.Salir del programa\n" +
                    "1.Insertar\n" +
                    "2.Imprimir\n" +
                    "3.Borrar\n" +
                    "4.Preguntar si esta vacia\n" +
                    "5.Primer elemto de la lista\n" +
                    "6.Imprimir el tamaño (cantidad de nodos)  de la LESC\n" +
                    "7.Imprimir por un sueldo mayor o igual\n" +
                    "8.Imprimir por departamento\n" +
                    "9.Invertit lista","Brayan Arias Sanchez",1));
            switch (op) {
                case 0:
                    JOptionPane.showMessageDialog(null, "saliendo del programa");
                    break;
                case 1:
                    c.insertar();
                    break;
                case 2:
                    c.imprimir();
                    break;
                case 3:
                    c.borrar();
                    break;
                case 4:
                    c.preguntar_si_esta_vacia();
                    break;
                case 5:
                    c.imprimir_el_primer_elemeto_de_la_lista();
                    break;
                case 6:
                    c.tamaño_De_la_lisra();
                    break;
                case 7:
                    c.imprimir_por_sueldo();
                    break;
             case 8:
                c.imprimir_por_departamento();
                break;
                case 9:
              c.invertir_lista();
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Intente de nuevo");
            }
        } while (op != 0);
    }
}
