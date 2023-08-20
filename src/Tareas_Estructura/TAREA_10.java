package Tareas_Estructura;


/*
Efectuar un programa en JAVA que maneje una LISTA ENCADENADA SIMPLE (LES) usando memoria dinámica CON OBJETOS PUNTERO  con la clase NODO
CON LOS DATOS DE INT NUMEMP, STRING NOMBRE, INT DEPTO; FLOAT SUELDO; NODO  NEXT;
USAR LOS APUNTADORES FIRST,ANT,TEMP,NVONODO
    Y los métodos de:
	1. Crear la LES
	2. Verificar si esta vacia
	3. Insertar un elemento ORDENADO DE MENOR  MAYOR POR DEPTO Y DENTRO EL POR NUEMP
	4. Borrar un elemento BUSCANDODOLO POR EL CAMPO DE NUMEP
	5. Imprimir todos los elementos de LES
	6. Imprimir los nodos con el DEPTO igual a X
	7. Imprimir el primer elemento de la  LES
	8. Imprimir el tamaño (cantidad de nodos)  de la LES
	9. Imprimir los nodos con SUELDO >=XSAL
	10. Método de invertir la LES
 */
/*
public class TAREA_10 {
    TAREA_10 first;

    public TAREA_10(){
        first = null;
    }

    public boolean estaVacia(){
        return first == null;
    }

    public void insertarOrden(int numemp, String nombre, int depto, float sueldo){
        TAREA_10 nvonodo = new TAREA_10(numemp,nombre,depto,sueldo);
        if (estaVacia()){
            first = nvonodo;
        }else if (depto < first.depto || (depto == first.depto && numemp < first.numemp)){
            nvonodo.next = first;
            first = nvonodo;
        }else{
            NodoEmpleados ant = null;
            NodoEmpleados temp = first;
            while (temp != null && temp.depto < depto) {
                ant = temp;
                temp = temp.next;
            }
            while (temp != null && temp.depto == depto && temp.numemp < numemp) {
                ant = temp;
                temp = temp.next;
            }
            nvonodo.next = temp;
            ant.next = nvonodo;
        }
    }

    public NodoEmpleados buscar(int numemp) {
        NodoEmpleados temp = first;
        while (temp != null && temp.numemp != numemp) {
            temp = temp.next;
        }
        return temp;
    }

    public void borrar(int numemp) {
        if (estaVacia()) {
            return;
        }
        NodoEmpleados temp = first;
        NodoEmpleados ant = null;
        while (temp != null && temp.numemp != numemp) {
            ant = temp;
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        if (ant == null) {
            first = temp.next;
        } else {
            ant.next = temp.next;
        }
    }

    public void imprimir() {
        NodoEmpleados temp = first;
        while (temp != null) {
            System.out.println("Numero de empleado :"+temp.numemp + ", " + "Nombre :" +temp.nombre + ", " + "Numero de departamento :" +temp.depto + ", " + "Sueldo :" +temp.sueldo);
            temp = temp.next;
        }
    }

    public void imprimirPorDepto(int depto) {
        NodoEmpleados temp = first;
        while (temp != null) {
            if (temp.depto == depto) {
                System.out.println(temp.numemp + ", " + temp.nombre + ", " + temp.depto + ", " + temp.sueldo);
            }
            temp = temp.next;
        }
    }

    public void imprimirPrimerElemento() {
        if (estaVacia()) {
            return;
        }
        System.out.println(first.numemp + ", " + first.nombre + ", " + first.depto + ", " + first.sueldo);
    }

    public int tamaño() {
        NodoEmpleados temp = first;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    }
*/