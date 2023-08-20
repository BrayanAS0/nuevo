package Practica;

import Tareas_Estructura.TAREA_17_ARBOLES_BINARIO;

import javax.swing.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class exmane_sandra {
    static int nodosDeArbol=0;
    static Scanner s = new Scanner(System.in);
    Stack<String> pila = new Stack<>();
    LinkedList<String> cola = new LinkedList<>();

    exmane_sandra izq, raiz = null, der;
    int contador_arbol = 0;

    public exmane_sandra(int placa) {
        this.placa = placa;
    }

    int placa;

    public void insertarEnPila() {
        System.out.println("numero que quuires meter a la pila");
        pila.push(s.next());
    }

    public void sacar_de_pila(String placa) {
        Stack<String> auxPila = new Stack<>();
        LinkedList<String> auxCola = new LinkedList<>();

        while (!pila.isEmpty()) {
            String elemento = pila.pop();
            if (elemento.equalsIgnoreCase(placa)) {
                // Se encontró la placa a sacar, no se agrega a ninguna estructura auxiliar.
                break;
            } else {
                auxCola.add(elemento);
            }
        }

        while (!auxCola.isEmpty()) {
            auxPila.push(auxCola.poll());
        }

        while (!auxPila.isEmpty()) {
            pila.push(auxPila.pop());
        }
    }
    public void imprimirPila(){
        System.out.println("Placas:\n"+pila);
    }
    public void pasarArbolDato() {
        contador_arbol++;

        int placa =s.nextInt();
        exmane_sandra nodo_nuevo = new exmane_sandra( placa);

        if (raiz == null) {
            raiz = nodo_nuevo;
            return;
        }

        exmane_sandra aux = raiz;
        exmane_sandra padre;

        while (true) {
            padre = aux;
            if (placa < aux.placa) {
                aux = aux.izq;
                if (aux == null) {
                    padre.izq = nodo_nuevo;
                    return;
                }
            } else {
                aux = aux.der;
                if (aux == null) {
                    padre.der = nodo_nuevo;
                    return;
                }
            }
        }
    }
    public void post_orden(exmane_sandra n) {
        if (n != null) {
            post_orden(n.izq);
            post_orden(n.der);

                System.out.println("Placa: "+n.placa);
            }
        }


    public void pre_orden(exmane_sandra n) {
        if (n != null) {
            System.out.println("Placa: "+n.placa);

            pre_orden(n.izq);
            pre_orden(n.der);
        }
    }

    public void orden(exmane_sandra n) {
        if (n != null) {
            orden(n.izq);

            System.out.println("Placa: "+n.placa);
            }
            orden(n.der);
        }

    public exmane_sandra() {
    }

    public boolean eliminar_manera_fisica() {

        System.out.println("Placa quq quiero eleiminar");
        int matricula_que_quiere_eliminar =s.nextInt();
        exmane_sandra aux = raiz, padre = raiz;
        var es_izq = true;
        while (aux.placa != matricula_que_quiere_eliminar) {
            padre = aux;
            if (matricula_que_quiere_eliminar < aux.placa) {
                es_izq = true;
                aux = aux.izq;

            } else {
                es_izq = false;
                aux = aux.der;

            }
            if (aux == null) {
                return false;
            }
        }
        if (aux.izq == null && aux.der == null) {
            if (aux == raiz) {
                raiz = null;

            } else if (es_izq == true) {
                padre.izq = null;
            } else {
                padre.der = null;

            }
        } else if (aux.der == null) {
            if (aux == raiz) {
                raiz = aux.izq;

            } else if (es_izq) {
                padre.izq = aux.izq;

            } else {
                padre.der = aux.izq;

            }
        } else if (aux.izq == null) {
            if (aux == raiz) {
                raiz = aux.der;

            } else if (es_izq) {
                padre.izq = aux.der;

            } else {
                padre.der = aux.der;

            }
        } else {
            exmane_sandra reemplazo = obtenerNodoReemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (es_izq) {
                padre.izq = reemplazo;
            } else {
                padre.der = reemplazo;
            }
            reemplazo.izq = aux.izq;
        }

        return true;
    }
    public exmane_sandra obtenerNodoReemplazo(exmane_sandra nodoReemplazo) {
        exmane_sandra reemplazarPadre = nodoReemplazo;
        exmane_sandra reemplazo = nodoReemplazo;
        exmane_sandra aux = nodoReemplazo.der;

        while (aux != null) {
            reemplazarPadre = reemplazo;
            reemplazo = aux;
            aux = aux.izq;
        }
        if (reemplazo != nodoReemplazo.der) {
            reemplazarPadre.izq = reemplazo.der;
            reemplazo.der = nodoReemplazo.der;
        }
        return reemplazo;
    }
    public void contar(exmane_sandra n) {
        if (n != null) {
            orden(n.izq);
nodosDeArbol++;

        }
        orden(n.der);
    }
    public void pasar_de_arbol_a_cola(exmane_sandra n) {
        if (n != null) {

                pasar_de_arbol_a_cola(n.izq);
                cola.add(Integer.toString(n.placa));
                pasar_de_arbol_a_cola(n.der);

        }
    }
    public void buscar(exmane_sandra n,int placa) {
        if (n != null) {
            buscar(n.izq,placa);
            if (n.placa==placa)
                System.out.println("Plca:"+n.placa);

        }
        buscar(n.der,placa);
    }
    public void imprimirCola(){
        System.out.println("Contenido de la cola\n:"+cola);
    }
    public void imprimirColaUltimoYprimero(){
        System.out.println("Primero de la cola\n:"+cola.getFirst()+"\nUltimo de la cola:"+cola.getLast());
    }
    public void imprimirTamañoLaCola() {
        System.out.println("Tamaño de la pila"+pila.size());
    }

    public static void main(String[] args) {
        exmane_sandra sa= new exmane_sandra();
        int opcio;
        do{
            System.out.println("======== Sandra Alexia Lugo Cepeda 21281988 ========");

            System.out.println("1. Llegada de un auto a la pila");
            System.out.println("2. Buscar auto por placa");
            System.out.println("3. Imprimir la pila");
            System.out.println("4. Insertar dato en el árbol");
            System.out.println("5. Recorrido Preorder del árbol");
            System.out.println("6. Recorrido Inorder del árbol");
            System.out.println("7. Recorrido Postorder del árbol");
            System.out.println("8. Eliminar nodo del árbol");
            System.out.println("9. Contar nodos activos en el árbol");
            System.out.println("10. Convertir recorrido Inorder a lista");
            System.out.println("11. Imprimir cola");
            System.out.println("12. Imprimir primero y ultimo");
            System.out.println("13. Salir del programa" +
                    "14.sacar de pila");
            System.out.print("Ingrese el número de opción: ");
            opcio=s.nextInt();
            switch (opcio){
                case 1:
                    sa.insertarEnPila();
                    break;
                case 2:
                    System.out.println("Inserte plca que quieres buscar");
                    int placa=s.nextInt();
                    sa.buscar(sa.raiz,placa);
                    break;
                case 3:
                    sa.imprimirPila();
                    break;
                case 4:
                    sa.pasarArbolDato();
                    break;
                case 5:
                    sa.pre_orden(sa.raiz);
                    sa.orden(sa.raiz);
                    sa.post_orden(sa.raiz);
                    break;
                case 8:
                    sa.eliminar_manera_fisica();
                    break;
                case 9:
                    sa.contar(sa.raiz);
                    break;
                case 10:
                    sa.pasar_de_arbol_a_cola(sa.raiz);
                    break;
                case 11:
                    sa.imprimirCola();
                    break;
                case 12:
                    sa.imprimirColaUltimoYprimero();
                    break;
                case 13:
                    System.out.println("saliendo del rpograa");
                    break;
                case 14:
                    System.out.println("numeor que quieres scasar");
                    String as=s.next();
                    sa.sacar_de_pila(as);
            }
        }while (opcio!=0);
    }
}



