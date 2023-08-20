package Practica;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class EXAM_ORDI {


        Pila pila;
        ListaEncadenada lista;
        ArbolBinario arbol;
        ListaEncadenada listaEncadenada;

        static class NodoArbol {

            int dato;
            NodoArbol izquierdo;
            NodoArbol derecho;

            public NodoArbol(int dato) {
                this.dato = dato;
                izquierdo = derecho = null;
            }
        }

        static class Pila {

            Stack<String> pila;

            public Pila() {
                pila = new Stack<>();
            }

            public void push(String placa) {
                pila.push(placa);
            }

            public String pop() {
                return pila.pop();
            }

            public boolean isEmpty() {
                return pila.isEmpty();
            }

            public void imprimirPila() {
                System.out.println("Contenido de la pila: " + pila);
            }

            public int tamaño() {
                return pila.size();
            }
        }

        static class ListaEncadenada {

            Queue<String> cola;

            public ListaEncadenada() {
                cola = new LinkedList<>();
            }

            public void agregar(String placa) {
                cola.add(placa);
            }

            public String remover() {
                return cola.remove();
            }

            public boolean isEmpty() {
                return cola.isEmpty();
            }

            public void imprimirListaEncadenada() {
                System.out.println("Contenido de la lista encadenada: " + cola);
            }

            public String primerElemento() {
                return cola.peek();
            }

            public String ultimoElemento() {
                String ultimoElemento = null;
                for (String elemento : cola) {
                    ultimoElemento = elemento;
                }
                return ultimoElemento;
            }
        }

        static class ArbolBinario {

            NodoArbol raiz;

            public ArbolBinario() {
                raiz = null;
            }

            public void insertar(int dato) {
                raiz = insertarNodo(raiz, dato);
            }

            private NodoArbol insertarNodo(NodoArbol nodo, int dato) {
                if (nodo == null) {
                    nodo = new NodoArbol(dato);
                    return nodo;
                }

                if (dato < nodo.dato) {
                    nodo.izquierdo = insertarNodo(nodo.izquierdo, dato);
                } else if (dato > nodo.dato) {
                    nodo.derecho = insertarNodo(nodo.derecho, dato);
                }

                return nodo;
            }

            public void preOrder() {
                System.out.print("Recorrido Preorder: ");
                preOrderRecursivo(raiz);
                System.out.println();
            }

            private void preOrderRecursivo(NodoArbol nodo) {
                if (nodo != null) {
                    System.out.print(nodo.dato + " ");
                    preOrderRecursivo(nodo.izquierdo);
                    preOrderRecursivo(nodo.derecho);
                }
            }

            public void inOrder() {
                System.out.print("Recorrido Inorder: ");
                inOrderRecursivo(raiz);
                System.out.println();
            }

            private void inOrderRecursivo(NodoArbol nodo) {
                if (nodo != null) {
                    inOrderRecursivo(nodo.izquierdo);
                    System.out.print(nodo.dato + " ");
                    inOrderRecursivo(nodo.derecho);
                }
            }

            public void postOrder() {
                System.out.print("Recorrido Postorder: ");
                postOrderRecursivo(raiz);
            }

            private void postOrderRecursivo(NodoArbol nodo) {
                if (nodo != null) {
                    postOrderRecursivo(nodo.izquierdo);
                    postOrderRecursivo(nodo.derecho);
                    System.out.print(nodo.dato + " ");
                }
            }

            public void borrar(int dato) {
                raiz = borrarNodo(raiz, dato);
            }

            private NodoArbol borrarNodo(NodoArbol nodo, int dato) {
                if (nodo == null) {
                    return nodo;
                }

                if (dato < nodo.dato) {
                    nodo.izquierdo = borrarNodo(nodo.izquierdo, dato);
                } else if (dato > nodo.dato) {
                    nodo.derecho = borrarNodo(nodo.derecho, dato);
                } else {
                    if (nodo.izquierdo == null) {
                        return nodo.derecho;
                    } else if (nodo.derecho == null) {
                        return nodo.izquierdo;
                    }

                    nodo.dato = encontrarMenor(nodo.derecho);
                    nodo.derecho = borrarNodo(nodo.derecho, nodo.dato);
                }

                return nodo;
            }

            private int encontrarMenor(NodoArbol nodo) {
                int minimo = nodo.dato;
                while (nodo.izquierdo != null) {
                    minimo = nodo.izquierdo.dato;
                    nodo = nodo.izquierdo;
                }
                return minimo;
            }

            public int contarNodos() {
                return contarNodosRecursivo(raiz);
            }

            private int contarNodosRecursivo(NodoArbol nodo) {
                if (nodo == null) {
                    return 0;
                } else {
                    int contador = 1;
                    contador += contarNodosRecursivo(nodo.izquierdo);
                    contador += contarNodosRecursivo(nodo.derecho);
                    return contador;
                }
            }

            public ListaEncadenada convertirInOrderALista() {
                ListaEncadenada lista = new ListaEncadenada();
                convertirInOrderRecursivo(raiz, lista);
                return lista;
            }

            private void convertirInOrderRecursivo(NodoArbol nodo, ListaEncadenada lista) {
                if (nodo != null) {
                    convertirInOrderRecursivo(nodo.izquierdo, lista);
                    lista.agregar(String.valueOf(nodo.dato));
                    convertirInOrderRecursivo(nodo.derecho, lista);
                }
            }
        }

        private void pila_listas(){
            Pila pila = new Pila();
            ListaEncadenada lista = new ListaEncadenada();
            ArbolBinario arbol = new ArbolBinario();

            // 1) Crear una lista encadenada simple nula en forma de COLA con el objeto string.
            // (No se requiere código adicional ya que la implementación ya crea una lista vacía)
            // 2) Llegada de un auto a la clase Stack (PILA) con el objeto string.
            pila.push("ABC123");
            pila.push("DEF456");
            pila.push("GHI789");
            String placaBuscada = "DEF456";
            Stack<String> tempStack = new Stack<>();
            boolean encontrado = false;

            while (!pila.isEmpty()) {
                String placa = pila.pop();
                if (placa.equals(placaBuscada)) {
                    encontrado = true;
                    break;
                } else {
                    lista.agregar(placa);
                    tempStack.push(placa);
                }
            }

            while (!tempStack.isEmpty()) {
                pila.push(tempStack.pop());
            }

            if (encontrado) {
                System.out.println("Se encontró el auto con la placa " + placaBuscada);
            } else {
                System.out.println("No se encontró el auto con la placa " + placaBuscada);
            }

            // 4) Imprimir la Pila clase Stack
            pila.imprimirPila();

            // 5) Alta de elemento al Arbol Binario de manera que los menores se carguen a la izquierda y los mayores a la derecha.
            arbol.insertar(50);
            arbol.insertar(30);
            arbol.insertar(70);
            arbol.insertar(20);
            arbol.insertar(40);
            arbol.insertar(60);
            arbol.insertar(80);

            // 6) Recorridos de Arbol Binario
            arbol.preOrder();   // a. Preorder
            arbol.inOrder();    // b. Inorder
            arbol.postOrder();  // c. Postorder

            // 7) Eliminar un nodo del Arbol Binario buscándolo por dato=X.
            int datoEliminar = 30;
            arbol.borrar(datoEliminar);
            System.out.println("Se eliminó el nodo con dato " + datoEliminar);

            // 8) Contar el número de nodos activos del árbol binario.
            int cantidadNodos = arbol.contarNodos();
            System.out.println("Cantidad de nodos activos en el árbol: " + cantidadNodos);

            // 9 Pasar el recorrido Inorder del Arbol Binario a una Lista Encadenada Simple en forma de COLA
            ListaEncadenada listaEncadenada = arbol.convertirInOrderALista();
            listaEncadenada.imprimirListaEncadenada();

            // 10) Imprimir la Lista Encadenada Simple en forma de COLA
            lista.imprimirListaEncadenada();

            // 11 Imprimir el primer y el último elemento insertado en la Lista Encadenada Simple en forma COLA
            String primerElemento = lista.primerElemento();
            String ultimoElemento = lista.ultimoElemento();
            System.out.println("Primer elemento insertado en la lista: " + primerElemento);
            System.out.println("Último elemento insertado en la lista: " + ultimoElemento);

            // 12 Indicar el tamaño de la clase Stack (PILA)
            int tamañoPila = pila.tamaño();
            System.out.println("Tamaño de la pila: " + tamañoPila);

        }
        public EXAM_ORDI() {
            pila = new Pila();
            lista = new ListaEncadenada();
            arbol = new ArbolBinario();
            listaEncadenada = new ListaEncadenada();
        }

        public void buscarPlaca(String placaBuscada) {
            Stack<String> tempStack = new Stack<>();
            boolean encontrado = false;

            while (!pila.isEmpty()) {
                String placa = pila.pop();
                if (placa.equals(placaBuscada)) {
                    encontrado = true;
                    break;
                } else {
                    lista.agregar(placa);
                    tempStack.push(placa);
                }
            }

            while (!tempStack.isEmpty()) {
                pila.push(tempStack.pop());
            }

            if (encontrado) {
                System.out.println("Se encontró el auto con la placa " + placaBuscada);
            } else {
                System.out.println("No se encontró el auto con la placa " + placaBuscada);
            }
        }
public void insertarEnPila(){
    Scanner scanner = new Scanner(System.in);
    System.out.println("DATO QUE QUIERES INGRESAR EN  PILA");
    String ss=scanner.next();
            pila.push(ss);
    }

        public static void main(String[] args){
            Scanner scanner = new Scanner(System.in);
            EXAM_ORDI programa = new EXAM_ORDI();

            int opcion = 0;
            while (opcion != 13) {
                mostrarMenu();
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        programa.pila.push("ABC123");
                        programa.pila.push("DEF456");
                        programa.pila.push("GHI789");
                        break;
                    case 2:
                        System.out.print("Ingrese la placa a buscar: ");
                        String placaBuscada = scanner.nextLine();
                        programa.buscarPlaca(placaBuscada);
                        break;
                    case 3:
                        programa.pila.imprimirPila();
                        break;
                    case 4:
                        System.out.print("Ingrese el dato a insertar en el árbol: ");
                        int datoInsertar = scanner.nextInt();
                        programa.arbol.insertar(datoInsertar);
                        break;
                    case 5:
                        programa.arbol.preOrder();
                        break;
                    case 6:
                        programa.arbol.inOrder();
                        break;
                    case 7:
                        programa.arbol.postOrder();
                        break;
                    case 8:
                        System.out.print("Ingrese el dato a eliminar del árbol: ");
                        int datoEliminar = scanner.nextInt();
                        programa.arbol.borrar(datoEliminar);
                        break;
                    case 9:
                        int cantidadNodos = programa.arbol.contarNodos();
                        System.out.println("Cantidad de nodos activos en el árbol: " + cantidadNodos);
                        break;
                    case 10:
                        programa.listaEncadenada = programa.arbol.convertirInOrderALista();
                        programa.listaEncadenada.imprimirListaEncadenada();
                        break;
                    case 11:
                        programa.lista.imprimirListaEncadenada();
                        break;
                    case 12:
                        String primerElemento = programa.lista.primerElemento();
                        String ultimoElemento = programa.lista.ultimoElemento();
                        System.out.println("Primer elemento insertado en la lista: " + primerElemento);
                        System.out.println("Último elemento insertado en la lista: " + ultimoElemento);
                        break;
                    case 13:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                }

                System.out.println();
            }

            scanner.close();
        }

        public static void mostrarMenu() {
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
            System.out.println("11. Imprimir");
            System.out.println("12. Imprimir la lista encadenada");
            System.out.println("13. Salir del programa");
            System.out.print("Ingrese el número de opción: ");

        }}



