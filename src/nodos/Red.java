package nodos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Red {

    private ArrayList<Nodo> nodoArray = new ArrayList<Nodo>();
    private Integer numNodos;
    public Red(Integer numNodos) {
        this.numNodos = numNodos;
        GenerateRed();
    }

    private  void GenerateRed(){
        Random random = new Random();
        float pesos;
        for (Integer i = 0; i< this.numNodos; i++){
            pesos = random.nextFloat();
            Nodo newNodo = new Nodo(pesos, null);
            this.nodoArray.add(newNodo);
        }
    }

}
