package Tareas_Estructura;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
public  class Grafo {

    private final int numVertices;
    private final List<List<Arista>> adyacencia;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        adyacencia = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, int peso) {
        adyacencia.get(origen).add(new Arista(destino, peso));
    }

    public void imprimirGrafo() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vértice " + i + ": ");
            for (Arista arista : adyacencia.get(i)) {
                System.out.print("(" + arista.destino + ", " + arista.peso + ") ");
            }
            System.out.println();
        }
    }

    // Implementación del algoritmo de Dijkstra
    public void dijkstra(int origen, int destino) {
        int[] distancia = new int[numVertices];
        boolean[] visitado = new boolean[numVertices];
        int[] padre = new int[numVertices];

        Arrays.fill(distancia, Integer.MAX_VALUE);
        Arrays.fill(visitado, false);
        Arrays.fill(padre, -1);

        distancia[origen] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int u = obtenerVerticeMenorDistancia(distancia, visitado);
            visitado[u] = true;

            for (Arista arista : adyacencia.get(u)) {
                int v = arista.destino;
                int peso = arista.peso;
                if (!visitado[v] && distancia[u] != Integer.MAX_VALUE && distancia[u] + peso < distancia[v]) {
                    distancia[v] = distancia[u] + peso;
                    padre[v] = u;
                }
            }
        }

        imprimirRecorrido(origen, destino, distancia, padre);
    }

    // Método auxiliar para Dijkstra: obtiene el vértice con la menor distancia no visitado
    private int obtenerVerticeMenorDistancia(int[] distancia, boolean[] visitado) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!visitado[v] && distancia[v] <= min) {
                min = distancia[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    // Implementación del algoritmo de Kruskal
    public void kruskal() {
        List<Arista> aristas = obtenerListaAristas();

        Collections.sort(aristas);

        int[] padre = new int[numVertices];
        for (int i = 0; i < numVertices; i++) {
            padre[i] = i;
        }

        List<Arista> arbol = new ArrayList<>();

        for (Arista arista : aristas) {
            int u = arista.origen;
            int v = arista.destino;
            int peso = arista.peso;

            int padreU = encontrarPadre(padre, u);
            int padreV = encontrarPadre(padre, v);

            if (padreU != padreV) {
                arbol.add(arista);
                unirComponentes(padre, padreU, padreV);
            }
        }

        imprimirArbolMinimo(arbol);
    }

    // Método auxiliar para Kruskal: obtiene la lista de aristas del grafo
    private List<Arista> obtenerListaAristas() {
        List<Arista> aristas = new ArrayList<>();

        for (int u = 0; u < numVertices; u++) {
            for (Arista arista : adyacencia.get(u)) {
                int v = arista.destino;
                int peso = arista.peso;
                aristas.add(new Arista(u, v, peso));
            }
        }

        return aristas;
    }

    // Método auxiliar para Kruskal: encuentra el padre de un vértice en el conjunto de componentes
    private int encontrarPadre(int[] padre, int vertice) {
        if (padre[vertice] != vertice) {
            padre[vertice] = encontrarPadre(padre, padre[vertice]);
        }
        return padre[vertice];
    }

    // Método auxiliar para Kruskal: une dos componentes en el conjunto de componentes
    private void unirComponentes(int[] padre, int u, int v) {
        padre[v] = u;
    }

    // Implementación del algoritmo de Floyd
    public void floyd(int origen, int destino) {
        int[][] distancia = new int[numVertices][numVertices];
        int[][] camino = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                distancia[i][j] = Integer.MAX_VALUE;
                camino[i][j] = -1;
            }
        }

        for (int u = 0; u < numVertices; u++) {
            distancia[u][u] = 0;

            for (Arista arista : adyacencia.get(u)) {
                int v = arista.destino;
                int peso = arista.peso;
                distancia[u][v] = peso;
                camino[u][v] = u;
            }
        }

        for (int k = 0; k < numVertices; k++) {
            for (int i = 0; i < numVertices; i++) {
                for (int j = 0; j < numVertices; j++) {
                    if (distancia[i][k] != Integer.MAX_VALUE && distancia[k][j] != Integer.MAX_VALUE
                            && distancia[i][k] + distancia[k][j] < distancia[i][j]) {
                        distancia[i][j] = distancia[i][k] + distancia[k][j];
                        camino[i][j] = camino[k][j];
                    }
                }
            }
        }

        imprimirRecorridoFloyd(origen, destino, distancia, camino);
    }

    // Método auxiliar para imprimir el recorrido obtenido con Dijkstra o Floyd
    private void imprimirRecorrido(int origen, int destino, int[] distancia, int[] padre) {
        System.out.println("Recorrido más corto desde el vértice " + origen + " al vértice " + destino);
        System.out.println("Distancia: " + distancia[destino]);

        List<Integer> recorrido = new ArrayList<>();
        int actual = destino;
        recorrido.add(actual);
        while (padre[actual] != -1) {
            actual = padre[actual];
            recorrido.add(actual);
        }
        Collections.reverse(recorrido);
        System.out.println("Recorrido: " + recorrido);
    }

    // Método auxiliar para imprimir el recorrido obtenido con Floyd
    private void imprimirRecorridoFloyd(int origen, int destino, int[][] distancia, int[][] camino) {
        System.out.println("Recorrido más corto desde el vértice " + origen + " al vértice " + destino);
        System.out.println("Distancia: " + distancia[origen][destino]);



    }

    // Método auxiliar para imprimir el árbol mínimo obtenido con Kruskal
    private void imprimirArbolMinimo(List<Arista> arbol) {
        System.out.println("Árbol mínimo:");
        for (Arista arista : arbol) {
            System.out.println("(" + arista.origen + ", " + arista.destino + ", " + arista.peso + ")");
        }
    }

    // Clase Arista para representar las aristas del grafo
    private static class Arista implements Comparable<Arista> {
        private int origen;
        private final int destino;
        private int peso;

        public Arista(int origen, int destino, int peso) {
            this.origen = origen;
            this.destino = destino;
            this.peso = peso;
        }

        public Arista(int destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }


        public int compareTo(Arista otra) {
            return Integer.compare(this.peso, otra.peso);
        }
    }


    public static void main(String[] args) {
        Grafo grafo = new Grafo(6);

        grafo.agregarArista(0, 1, 4);
        grafo.agregarArista(0, 2, 2);
        grafo.agregarArista(1, 2, 1);
        grafo.agregarArista(1, 3, 5);
        grafo.agregarArista(2, 3, 8);
        grafo.agregarArista(2, 4, 10);
        grafo.agregarArista(3, 4, 2);
        grafo.agregarArista(3, 5, 6);
        grafo.agregarArista(4, 5, 3);

        System.out.println("Grafo:");
        grafo.imprimirGrafo();

        int origen = 0;
        int destino = 5;

        System.out.println("Algoritmo de Dijkstra:");
        grafo.dijkstra(origen, destino);

        System.out.println("Algoritmo de Kruskal:");
        grafo.kruskal();

        System.out.println("Algoritmo de Floyd:");
        grafo.floyd(origen, destino);

    }
}


