package funciones;

import java.util.ArrayList;

import nodos.Nodo;

public class Operadores {
    public Integer[] entrada;

    public Operadores(Integer[] entradaA) {
        this.entrada = entradaA;
    }

    private Double productoPunto(Nodo nodo) {

        if (this.entrada.length == nodo.pesos.length) {
            ArrayList<Double> resultados = new ArrayList<Double>();
            for (int i = 0; i < entrada.length; i++) {
                resultados.add(this.entrada[i]* nodo.pesos[i]);
            }

            double doubleSum = resultados.stream()
                .mapToDouble(Double::doubleValue)
                .sum();

            return doubleSum;
        } else {
            System.out.println("Datos insuficientes");
        }

        return null;
    }

    public Integer Trigger(Nodo nodo) {
        Double productoPunto = productoPunto(nodo);
        System.out.println("El producto punto es:"+productoPunto);
        if(nodo.limite < productoPunto){
            return 1;
        }else{
            return 0;
        }
    }

}
