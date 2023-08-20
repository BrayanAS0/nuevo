package Tareas_Estructura;

import javax.swing.*;

public class TAREA_17_ARBOLES_BINARIO {

    public TAREA_17_ARBOLES_BINARIO() {
    }

    public TAREA_17_ARBOLES_BINARIO(int matricula, String nombre, char estatus) {
        this.izq = null;
        this.estatus = estatus;
        this.matricula = matricula;
        this.nombre = nombre;
        this.der = null;
    }

    TAREA_17_ARBOLES_BINARIO izq, raiz = null, der;
    static int contador = 0;

    char estatus = 'a';
    static String com = "";

    int matricula;

    String nombre;

    public void insertar() {
        contador++;
    String nombre = JOptionPane.showInputDialog(null, "Inserte el nombre");
        int mat = Integer.parseInt(JOptionPane.showInputDialog(null, "Matricula:"));
        TAREA_17_ARBOLES_BINARIO nodo_nuevo = new TAREA_17_ARBOLES_BINARIO(mat, nombre, 'a');
        if (raiz == null) {
            raiz = nodo_nuevo;
        } else {
            TAREA_17_ARBOLES_BINARIO aux = raiz;
            TAREA_17_ARBOLES_BINARIO padre;
            while (true) {
                padre = aux;
                if (mat < aux.matricula) {
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
    }

    public void orden(TAREA_17_ARBOLES_BINARIO n) {
        if (n != null && n.estatus != 'b') {

            orden(n.izq);

            com = com + "La matricula es: " + n.matricula + " Y su nombre es: " + n.nombre + "\n";
            orden(n.der);
        }
        if (n != null && n.estatus == 'b') {
            orden(n.izq);
            orden(n.der);
        }
    }

    public void eliminar_De_manera_logica(TAREA_17_ARBOLES_BINARIO n, int mat) {

        if (n != null) {
            if (n.matricula == mat) {
                n.estatus = 'b';
                contador--;
                return;
            }
            eliminar_De_manera_logica(n.izq, mat);
            com = com + "La matricula es: " + n.matricula + " Y su nombre es: " + n.nombre + "la que eliminamos de manera logica\n+";
            eliminar_De_manera_logica(n.der, mat);
        }
    }

    public void post_orden(TAREA_17_ARBOLES_BINARIO n) {
        if (n != null && n.estatus != 'b') {
            post_orden(n.izq);
            post_orden(n.der);
            com = com + "La matricula es: " + n.matricula + " Y su nombre es: " + n.nombre + "\n";

        }
        if (n != null && n.estatus == 'b') {
            post_orden(n.izq);
            post_orden(n.der);
        }
    }

    public void pre_orden(TAREA_17_ARBOLES_BINARIO n) {
        if (n != null && n.estatus != 'b') {
            com = com + "La matricula es: " + n.matricula + " Y su nombre es: " + n.nombre + "\n";
            pre_orden(n.izq);
            pre_orden(n.der);

        }
        if (n != null && n.estatus == 'b') {
            pre_orden(n.izq);
            pre_orden(n.der);
        }

    }

    public boolean eliminar_manera_fisica() {

        //va conectado al nodo remplazo
        int matricula_que_quiere_eliminar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la matricula que quieres eliminar"));
        TAREA_17_ARBOLES_BINARIO aux = raiz, padre = raiz;
        var es_izq = true;
        while (aux.matricula != matricula_que_quiere_eliminar) {
            padre = aux;
            if (matricula_que_quiere_eliminar < aux.matricula) {
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
            TAREA_17_ARBOLES_BINARIO reemplazo = obtenerNodoReemplazo(aux);
            if (aux == raiz) {
                raiz = reemplazo;
            } else if (es_izq) {
                padre.izq = reemplazo;
            } else {
                padre.der = reemplazo;
            }
            reemplazo.izq = aux.izq;
        }
        contador--;
        return true;
    }

    public TAREA_17_ARBOLES_BINARIO obtenerNodoReemplazo(TAREA_17_ARBOLES_BINARIO nodoReemplazo) {
        TAREA_17_ARBOLES_BINARIO reemplazarPadre = nodoReemplazo;
        TAREA_17_ARBOLES_BINARIO reemplazo = nodoReemplazo;
        TAREA_17_ARBOLES_BINARIO aux = nodoReemplazo.der;

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

    public void nodo_raiz() {
        JOptionPane.showMessageDialog(null, "Matricula es: " + raiz.matricula + " Y su nombre es: " + raiz.nombre + "\n");
    }

    public void cantidad_de_nodos() {
        JOptionPane.showMessageDialog(null, "Cantidad de nodos que ahi: " + contador);
    }

    public int profundidad(TAREA_17_ARBOLES_BINARIO nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int profundidadIzquierda = profundidad(nodo.izq);
            int profundidadDerecha = profundidad(nodo.der);
            return 1 + Math.max(profundidadIzquierda, profundidadDerecha);
        }
    }

    public static void main(String[] args) {
        TAREA_17_ARBOLES_BINARIO a = new TAREA_17_ARBOLES_BINARIO();
        int op;
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(null, "Inserte una opcion:\n" +
                    "0.Salir del programa\n" +
                    "1.Insertar dato\n" +
                    "2.Nodo raiz con sus datos\n" +
                    "3.Cantidad de nodos dela arbol \n" +
                    "4.In-order\n" +
                    "5.Post-Orden\n" +
                    "6.Pre-Orden\n" +
                    "7.Dar de baja de manera logica\n" +
                    "8.Borrar de manera fisica\n" +
                    "9.Profundidad del arbol"));
            switch (op) {
                case 0:
                    JOptionPane.showMessageDialog(null, "Saliendo del programa");
                    break;
                case 1:
                    a.insertar();
                    break;
                case 2:
                    a.nodo_raiz();
                    break;
                case 3:
                    a.cantidad_de_nodos();
                    break;
                case 4:
                    com = "";
                    a.orden(a.raiz);
                    JOptionPane.showMessageDialog(null, com);
                    break;
                case 5:
                    com = "";
                    a.post_orden(a.raiz);
                    JOptionPane.showMessageDialog(null, com);
                    break;
                case 6:
                    com = "";
                    a.pre_orden(a.raiz);
                    JOptionPane.showMessageDialog(null, com);
                    break;
                case 7:
                    int mat = Integer.parseInt(JOptionPane.showInputDialog(null, "Matricula que quieres dar de baja"));
                    a.eliminar_De_manera_logica(a.raiz, mat);
                    break;
                case 8:
                    a.eliminar_manera_fisica();
                    break;
                case 9:
                  JOptionPane.showMessageDialog(null, "La profundidad del arbol es: "+a.profundidad(a.raiz));
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Inserte una opcion valida");


            }

        } while (op != 0);

    }
}
