import funciones.Operadores;
import nodos.Nodo;

public class Main {

    public static final String yellow = "\u001B[33m";
    public static final String green = "\u001B[32m";
    public static final String reset = "\u001B[0m";
    public static final String red = "\u001B[31m";

    // Entradas el operador and
    static Double[] andPesos = new Double[] { 1.0, 1.0 };
    public static Integer[] andEntrada = new Integer[] { 1, 0 };
    public static Operadores operadores = new Operadores(andEntrada);

    // Creamos un nodo
    public static Nodo nodo = new Nodo(1.5, andPesos);

    // Entradas para or
    public static Integer[] orEntrada = new Integer[] { 0, 1 };

    public static void main(String[] args) {

        Integer andSalida = operadores.Trigger(nodo);
        System.out.println(yellow + "La salida de and es:" + andSalida + reset);

        nodo.limite = 0.9;
        operadores.entrada = orEntrada;
        Integer orSalida = operadores.Trigger(nodo);
        System.out.println(green + "La salida de or es:" + orSalida + reset);

        // XOR
        Integer[] xorEntrada = new Integer[] { 1, 0 };

        Double[] pesosNodo1 = new Double[] { 1.0, 1.0 };
        final Operadores nodo1Operador = new Operadores(xorEntrada);
        final Nodo nodo1 = new Nodo(1.5, pesosNodo1);
        int salidaNodo1 = nodo1Operador.Trigger(nodo1);

        final Operadores nodo2Operadores = new Operadores(xorEntrada);
        final Nodo nodo2 = new Nodo(0.5, pesosNodo1);
        int salidaNodo2 = nodo2Operadores.Trigger(nodo2);

        xorEntrada[0] = salidaNodo1;
        xorEntrada[1] = salidaNodo2;

        Double[] pesosXor = new Double[] { -1.0, 1.0 };
        final Nodo nodoXor = new Nodo(0.5, pesosXor);
        final Operadores xorOperador = new Operadores(xorEntrada);
        int xorSalida = xorOperador.Trigger(nodoXor);

        System.out.print(red+"Salida de Xor es:"+xorSalida + reset);

    }
}