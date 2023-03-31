import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de datos a capturar:");
        int cantidad = sc.nextInt();

        Nodo raiz = null;
        for (int i = 0; i < cantidad; i++) {
            System.out.println("Ingrese el valor del nodo:");
            int valor = sc.nextInt();
            raiz = insertar(raiz, valor);
        }

        System.out.println("Cantidad de nodos del árbol: " + contarNodos(raiz));
        System.out.println("Cantidad de nodos hoja del árbol: " + contarHojas(raiz));
        System.out.println("Mayor valor del árbol: " + encontrarMaximo(raiz));
        System.out.println("Árbol en Pre-order:");
        preOrden(raiz);
    }

    public static Nodo insertar(Nodo raiz, int valor) {
        if (raiz == null) {
            return new Nodo(valor);
        }
        if (valor < raiz.valor) {
            raiz.izquierda = insertar(raiz.izquierda, valor);
        } else if (valor > raiz.valor) {
            raiz.derecha = insertar(raiz.derecha, valor);
        }
        return raiz;
    }

    public static int contarNodos(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        return 1 + contarNodos(raiz.izquierda) + contarNodos(raiz.derecha);
    }

    public static int contarHojas(Nodo raiz) {
        if (raiz == null) {
            return 0;
        }
        if (raiz.izquierda == null && raiz.derecha == null) {
            return 1;
        }
        return contarHojas(raiz.izquierda) + contarHojas(raiz.derecha);
    }

    public static int encontrarMaximo(Nodo raiz) {
        if (raiz == null) {
            return Integer.MIN_VALUE;
        }
        int max = raiz.valor;
        int maxIzquierda = encontrarMaximo(raiz.izquierda);
        int maxDerecha = encontrarMaximo(raiz.derecha);
        if (maxIzquierda > max) {
            max = maxIzquierda;
        }
        if (maxDerecha > max) {
            max = maxDerecha;
        }
        return max;
    }

    public static void preOrden(Nodo raiz) {
        if (raiz == null) {
            return;
        }
        System.out.print(raiz.valor + " ");
        preOrden(raiz.izquierda);
        preOrden(raiz.derecha);
    }
}
