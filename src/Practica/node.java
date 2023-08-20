package Practica;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class node {
    int contador = 0;
    node siguinete=null, ultimo=null,inicio=null;
    Scanner s = new Scanner(System.in);
    Stack<Integer> pila = new Stack<>();
    int numero;
    LinkedList<Integer> cola = new LinkedList<>();

    public node() {

    }

    public node(int numero) {

        this.numero = numero;
    }

    public void insertar_cola() {
        System.out.println("cliente que llegara a cola");
        cola.add(s.nextInt());
    }

    public void eliminar_de_cola_y_insertar_en_pila() {
        pila.push(cola.poll());
    }

    public void elimina_de_pila() {
        System.out.println("numero que quieres borrar: ");
        int dato = s.nextInt();
        if (pila.peek() == dato) {
            System.out.println(pila.pop());

        }else {
            int tamaño = pila.size();


            for (int i = 0; i < tamaño; i++) {


                int datoo=pila.pop();

                node nodo_de_info = new node(datoo);

                if (dato != nodo_de_info.numero) {



                    if (inicio == null) {
                        inicio = nodo_de_info;
                        ultimo = nodo_de_info;
                        contador++;
                    }

                    ultimo.siguinete = nodo_de_info;
                    ultimo = nodo_de_info;
                    contador++;
                }else{

                  break;

                }



                }
            node auxiliar = inicio;//si es tipo pila cambair a ultimo ya que inicio no existe en pila
            while (auxiliar != null) {
                pila.push(auxiliar.numero);
                auxiliar = auxiliar.siguinete;
              
contador--;
            }
        }
    }
public void imprimir_pila(){
    System.out.println(pila);
}
public void imprimir_cola(){
    System.out.println(cola);
}
public void tamaño_De_todo(){
    System.out.println("tamaño de cola "+cola.size());
    System.out.println("tamaño de pila "+pila.size());
    System.out.println("tamaño del nodo "+contador);
}
public void primer_elemtno_de_cola(){
    System.out.println(cola.getFirst());
}
public void ultimo_pila(){
    System.out.println("ultimo de pila "+pila.peek());
}
public void ultimo_de_cola(){
    System.out.println("cola ultimo"+cola.getLast());
}
    public void imprimir() {
        node lista = new node();
        lista = inicio;
        while (inicio != null) {
            System.out.println(inicio.numero);
        inicio = inicio.siguinete;
        }
        inicio =lista;
    }
    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        node n = new node();
        int op;

        do {
            System.out.println("2.\tMétodo que permita la llegada de CLIENTES a la  COLA EN LINKEDLIST para que sea atendido en ese orden.\n" +
                    "3.\tMétodo que borre de la LINKEDLIST COLA e inserte ese cliente en una PILA con clase STACK de tipo de datos igual.\n" +
                    "4.\tMétodo que borre un elemento de la PILA, con la premisa que si es el del tope(último elemento insertado) simplemente se borra y se manda imprimir, si no es el del tope, sacar elemento de la PILA y pasarlo a LA CLASE NODE COLA  hasta eliminar el elemento indicado, después regresar TODOS LOS ELEMENTOS DE LA NODE  COLA  a la PILA.\n" +
                    "5.\tMétodo para imprimir la PILA.\n" +
                    "6.\tMétodo para imprimir la  COLA EN LINKEDLIST\n" +
                    "7.\tMétodo para imprimir la NODE COLA LINKEDLIST.\n" +
                    "8.\tMétodo para imprimir el tamaño de la PILA, la COLA LINKEDLIST  y de la NODE COLA.\n" +
                    "9.\tMétodo para imprimir el primer elemento insertado de la  COLA LINKEDLIST.\n" +
                    "10.\tMétodo para imprimir el último elemento insertado de la PILA.\n" +
                    "11.\tMétodo para imprimir el último elemento insertado en la COLA LINKEDLIST.\n");
            op=s.nextInt();
            switch (op){
                case 0:
                    System.out.println("saliendo del programa ");
                    break;
                case 2:
                    n.insertar_cola();
                    break;
                case 3:
                    n.eliminar_de_cola_y_insertar_en_pila();
                    break;
                case 4:
                    n.elimina_de_pila();
                    break;
                case 5:
                  n.imprimir_pila();
                  break;
                case 6:
                    n.imprimir_cola();
                    break;
                case 7:
                n.imprimir();
                    break;
                case 8:
                   n.tamaño_De_todo();
                    break;
                case 9:
             n.primer_elemtno_de_cola();
                    break;
                case 10:
                n.ultimo_pila();
                    break;
                case 11:
                n.ultimo_de_cola();
                    break;
            }
        }while(op!=0);
    }
}
