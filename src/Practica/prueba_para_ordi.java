package Practica;



import javax.swing.JOptionPane;
import java.util.LinkedList;

public class prueba_para_ordi {

    //atributos para arbol

    static String com = "";

    prueba_para_ordi izq, raiz = null, der;
    static int contador_De_arbol = 0;


    //atributos para lista


    prueba_para_ordi siguiente;
    prueba_para_ordi nc=null, anterior, temp;
    static int contador_De_lista = 0;

    //lista cola


    LinkedList<Integer> cola = new LinkedList<>();


    //atributos

    int numero_de_articulo, existencia;
    char estatus;
    String nombre_del_articulo = "";
    ///costructor


    public prueba_para_ordi() {
    }

    public prueba_para_ordi(char estatus, int numero_de_articulo, int existencia, String nombre_del_articulo) {
        this.numero_de_articulo = numero_de_articulo;
        this.existencia = existencia;
        this.estatus = estatus;
        this.nombre_del_articulo = nombre_del_articulo;
    }

    public void insertar_en_arbol() {
        contador_De_arbol++;
        String nombre_de_Articulo_pero_en_nodo = JOptionPane.showInputDialog(null, "Inserte el nombre");
        int numero_Del_articulo = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de empleado:"));
        int existencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Sueldo:"));
        prueba_para_ordi nodo_nuevo = new prueba_para_ordi('a', numero_Del_articulo, existencia, nombre_de_Articulo_pero_en_nodo);
        if (raiz == null) {
            raiz = nodo_nuevo;
        } else {
            prueba_para_ordi aux = raiz;
            prueba_para_ordi padre;
            while (true) {
                padre = aux;
                if (numero_Del_articulo < aux.numero_de_articulo) {
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


    public void orden(prueba_para_ordi n) {
        if (n != null && n.estatus != 'b') {

            orden(n.izq);
            com = com + "Numero del articulo: " + n.numero_de_articulo + "\nExistencia: " + n.existencia + "\nNombre: " + n.nombre_del_articulo + "\n----------------------------------------------------------------------------------------\n";

            orden(n.der);
        }
        if (n != null && n.estatus == 'b') {
            orden(n.izq);
            orden(n.der);
        }
    }

    public void eliminar_de_manera_logica(prueba_para_ordi n, int numero_de_articulo) {
        if (n != null && n.estatus != 'b') {
            if (numero_de_articulo == n.numero_de_articulo) {
                n.estatus = 'b';
              //si encotro
                contador_De_arbol--;
            }
            eliminar_de_manera_logica(n.izq,numero_de_articulo);
            eliminar_de_manera_logica(n.der,numero_de_articulo);
        }
        if (n != null && n.estatus == 'b') {
            eliminar_de_manera_logica(n.izq,numero_de_articulo);
            eliminar_de_manera_logica(n.der,numero_de_articulo);
        }
    }
    public void pasar_de_arbol_a_lista_parte_1(prueba_para_ordi n) {
        if (n != null && n.estatus != 'b') {
//para saber que nula n y que el estatus es diefrenete de b
            pasar_de_arbol_a_lista_parte_1(n.izq);
pasar_de_arbol_a_lista_parte_2( n);
            pasar_de_arbol_a_lista_parte_1(n.der);
        }
        if (n != null && n.estatus == 'b') {
            pasar_de_arbol_a_lista_parte_1(n.izq);
            pasar_de_arbol_a_lista_parte_1(n.der);
        }
    }
    public void pasar_de_arbol_a_lista_parte_2(prueba_para_ordi nuevo_nodo) {

      //  prueba_para_ordi nuevo_nodo = new prueba_para_ordi(numero_de_empleado, departamento, sueldo, nombre);
        if (nc == null) {
            nc = new prueba_para_ordi();
            nc.siguiente = nc;


        }
        temp = nc.siguiente;
        anterior = nc;
        while ((temp != nc) && (temp.numero_de_articulo < nuevo_nodo.numero_de_articulo)) {
            anterior = temp;
            temp = temp.siguiente;

        }
 contador_De_lista++;
        nuevo_nodo.siguiente = anterior.siguiente;
        anterior.siguiente = nuevo_nodo;


    }
    public void imprimir_lista() {
        prueba_para_ordi temp = nc.siguiente;
        String datos = "";
        while (temp != nc) {
            datos = datos +"Numero del articulo: " + temp.numero_de_articulo + "\nExistencia: " + temp.existencia + "\nNombre: " + temp.nombre_del_articulo + "\n----------------------------------------------------------------------------------------\n";
            temp = temp.siguiente;
        }
        JOptionPane.showMessageDialog(null, datos);
    }
    public void consultar(prueba_para_ordi n,int numero_de_articulo) {
        if (n != null && n.estatus != 'b') {

            consultar(n.izq,numero_de_articulo);
           if(numero_de_articulo==n.numero_de_articulo){
               com = com + "Numero del articulo: " + n.numero_de_articulo + "\nExistencia: " + n.existencia + "\nNombre: " + n.nombre_del_articulo + "\n----------------------------------------------------------------------------------------\n";
JOptionPane.showMessageDialog(null, com);
               return;
           }


            consultar(n.der,numero_de_articulo);
        }
        if (n != null && n.estatus == 'b') {
            consultar(n.izq,numero_de_articulo);
            consultar(n.der,numero_de_articulo);
        }
    }
    public static void main(String[] args) {
        prueba_para_ordi a= new prueba_para_ordi();
        int op;
        do {

            op = Integer.parseInt(JOptionPane.showInputDialog(null, "1.insertar alrbol\n" +
                    "2.eliminar de logoca\n" +
                    "3.ORDER\n" +

                    "4. pasar de arbol a lista\n" +
                    "5.LSIta imprimir\n" +
                    "6.consultar"));


            switch (op) {
                case 1:
                    a.insertar_en_arbol();
                    break;
                case 2:
                    int ma=Integer.parseInt(JOptionPane.showInputDialog(null, "numero que quieres borrar"));

                    a.eliminar_de_manera_logica(a.raiz,ma);
                    break;
                case 3:
                    com="";
                    a.orden(a.raiz);
                    JOptionPane.showMessageDialog(null, com);
                    break;
                case 4:
                    a.pasar_de_arbol_a_lista_parte_1(a.raiz);
                    break;
                case 5:
                    a.imprimir_lista();
                    break;
                case 6:
                    com="";
                    int nn=Integer.parseInt(JOptionPane.showInputDialog(null, "numero que quieres buscar"));
                    a.consultar(a.raiz, nn);
            }
        } while (op != 0);
    }

}

