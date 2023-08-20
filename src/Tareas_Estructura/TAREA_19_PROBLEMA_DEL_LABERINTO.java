package Tareas_Estructura;
import java.util.*;


public class TAREA_19_PROBLEMA_DEL_LABERINTO {
    private int[][] laberinto;
    private int filas;
    private int columnas;
    private int inicioX;
    private int inicioY;
    private int finX;
    private int finY;

    public TAREA_19_PROBLEMA_DEL_LABERINTO(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        laberinto = new int[filas + 2][columnas + 2];
    }

    public void crearLaberinto() {
        // Rellenar el laberinto con ceros
        for (int i = 0; i < filas + 2; i++) {
            for (int j = 0; j < columnas + 2; j++) {
                laberinto[i][j] = 0;
            }
        }

        // Establecer la posición de salida y adicionar los bordes del laberinto
        inicioX = 1;
        inicioY = 1;
        finX = filas;
        finY = columnas;
        laberinto[inicioX][inicioY] = 1;
        laberinto[finX][finY] = 1;

        // Mostrar la matriz del laberinto
        mostrarLaberinto();
    }

    public void mostrarLaberinto() {
        System.out.println("Laberinto:");
        for (int i = 0; i < filas + 2; i++) {
            for (int j = 0; j < columnas + 2; j++) {
                System.out.print(laberinto[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void resolverLaberinto() {
        int[][] matrizAdyacencia = construirMatrizAdyacencia();
        List<Integer> recorrido = buscarCamino(matrizAdyacencia, inicioX * (columnas + 2) + inicioY,
                finX * (columnas + 2) + finY);

        if (recorrido.isEmpty()) {
            System.out.println("No se encontró un camino válido.");
        } else {
            System.out.println("Camino encontrado:");
            for (int posicion : recorrido) {
                int x = posicion / (columnas + 2);
                int y = posicion % (columnas + 2);
                System.out.println("Renglon: " + x + ", Columna: " + y);
            }
        }
    }

    private int[][] construirMatrizAdyacencia() {
        int totalNodos = (filas + 2) * (columnas + 2);
        int[][] matrizAdyacencia = new int[totalNodos][totalNodos];

        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= columnas; j++) {
                int posicionActual = i * (columnas + 2) + j;

                if (laberinto[i][j] == 1) {
                    // Si hay un camino en la posición actual, se establecen las conexiones con las celdas adyacentes
                    int izquierda = i * (columnas + 2) + (j - 1);
                    int derecha = i * (columnas + 2) + (j + 1);
                    int arriba = (i - 1) * (columnas + 2) + j;
                    int abajo = (i + 1) * (columnas + 2) + j;

                    matrizAdyacencia[posicionActual][arriba] = 1;
                    matrizAdyacencia[posicionActual][abajo] = 1;
                    matrizAdyacencia[posicionActual][izquierda] = 1;
                    matrizAdyacencia[posicionActual][derecha] = 1;
                }
            }
        }

        return matrizAdyacencia;
    }

    private List<Integer> buscarCamino(int[][] matrizAdyacencia, int inicio, int fin) {
        List<Integer> recorrido = new ArrayList<>();
        boolean[] visitado = new boolean[(filas + 2) * (columnas + 2)];
        int[] padre = new int[(filas + 2) * (columnas + 2)];

        // Inicializar los arreglos de visitado y padre
        Arrays.fill(visitado, false);
        Arrays.fill(padre, -1);

        // Realizar el recorrido usando el algoritmo de búsqueda en profundidad (DFS)
        dfs(matrizAdyacencia, inicio, visitado, padre);

        // Reconstruir el camino desde el nodo final hasta el inicio
        int actual = fin;
        while (actual != -1) {
            recorrido.add(actual);
            actual = padre[actual];
        }

        // Invertir el orden del recorrido
        Collections.reverse(recorrido);

        return recorrido;
    }

    private void dfs(int[][] matrizAdyacencia, int nodo, boolean[] visitado, int[] padre) {
        visitado[nodo] = true;

        for (int i = 0; i < matrizAdyacencia.length; i++) {
            if (matrizAdyacencia[nodo][i] == 1 && !visitado[i]) {
                padre[i] = nodo;
                dfs(matrizAdyacencia, i, visitado, padre);
            }
        }
    }

    public void recorrerLaberinto() {
        int[][] matrizLaberinto = Arrays.copyOf(laberinto, laberinto.length);

        int inicio = (inicioX * (columnas + 2)) + inicioY;
        int fin = (finX * (columnas + 2)) + finY;
        List<Integer> recorrido = buscarCamino(construirMatrizAdyacencia(), inicio, fin);

        marcarRecorrido(matrizLaberinto, recorrido);
        mostrarLaberintoConRecorrido(matrizLaberinto);
    }

    private void marcarRecorrido(int[][] matrizLaberinto, List<Integer> recorrido) {
        for (int posicion : recorrido) {
            int x = posicion / (columnas + 2);
            int y = posicion % (columnas + 2);
            matrizLaberinto[x][y] = 2;
        }
    }

    private void mostrarLaberintoConRecorrido(int[][] matrizLaberinto) {
        System.out.println("Laberinto con el recorrido marcado:");
        for (int i = 1; i <= filas; i++) {
            for (int j = 1; j <= columnas; j++) {
                System.out.print(matrizLaberinto[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner s= new Scanner(System.in);
        System.out.println("Numero de filas:");
        int filas=s.nextInt();
        System.out.println("Numero de columnas:");
        int columnas=s.nextInt();
        TAREA_19_PROBLEMA_DEL_LABERINTO laberinto = new TAREA_19_PROBLEMA_DEL_LABERINTO(filas, columnas);
        laberinto.crearLaberinto();
        laberinto.resolverLaberinto();
         laberinto.recorrerLaberinto();

    }
}

