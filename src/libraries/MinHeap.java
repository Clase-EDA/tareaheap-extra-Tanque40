package libraries;

public class MinHeap<T extends Comparable<T>> {
    private int cont;
    private int[] roots;
    private T[] elements;
    private int actualMaxElements;
    private int floors = 5;

    public MinHeap() {
        cont = 0;
        actualMaxElements = (int) Math.pow(2, floors);
        roots = new int[actualMaxElements];
        elements = (T[]) (new Comparable[actualMaxElements]);
    }

    public MinHeap(int floors) {
        this();
        this.floors = floors;
        actualMaxElements = (int) Math.pow(2, floors);
        roots = new int[actualMaxElements];
        elements = (T[]) (new Comparable[actualMaxElements]);
    }

    private void expandCapacity(){
        actualMaxElements *= 2;
        floors++;
        T[] auxE = (T[]) (new Comparable[actualMaxElements]);
        int[] auxR = new int[actualMaxElements];
        for(int i = 0; i < cont - 1; i++){
            auxE[i] = elements[i];
            auxR[i] = roots[i];
        }
        elements = auxE;
        roots = auxR;
    }

    public void add(T element) {
        int aux, temp, tempAnt;
        T auxE;
        cont++;
        if (cont == actualMaxElements)
            expandCapacity();
        if (cont == 1) {
            roots[cont - 1] = 0;
            elements[cont - 1] = element;
        } else {
            aux = ((cont - 1) % 2 == 0) ? ((cont - 1) / 2) - 1 : (cont - 1) / 2;
            if (elements[aux].compareTo(element) > 0) {
                auxE = elements[aux];
                elements[aux] = element;
                elements[cont - 1] = auxE;
                temp = (aux % 2 == 0) ? (aux / 2) - 1 : aux / 2;
                tempAnt = aux;
                while (temp >= 0 && elements[temp].compareTo(elements[tempAnt]) > 0) {
                    auxE = elements[tempAnt];
                    elements[tempAnt] = elements[temp];
                    elements[temp] = auxE;
                    tempAnt = temp;
                    temp = (tempAnt % 2 == 0) ? (tempAnt / 2) - 1 : tempAnt / 2;
                }
            } else {
                elements[cont - 1] = element;
            }
            roots[cont - 1] = aux;
        }
    }

    public T getMin() {
        return elements[0];
    }

    public T deleteMin() {
        T res = elements[0];
        T temp;
        int father, sonDer, sonIzq;

        father = 0;
        sonIzq = 1;
        sonDer = 2;
        if (elements[sonIzq].compareTo(elements[sonDer]) <= 0) {
            elements[0] = elements[sonIzq];
            father = sonIzq;
        } else {
            elements[0] = elements[sonDer];
            father = sonDer;
        }

        sonIzq = (father * 2) + 1;
        sonDer = (father * 2) + 2;

        while (roots[sonDer] > 0 || roots[sonIzq] > 0) {
            if (roots[sonDer] == 0) {
                elements[father] = elements[sonIzq];
                roots[sonIzq] = 0;
                sonIzq = 0;
            } else if (roots[sonIzq] == 0) {
                elements[father] = elements[sonDer];
                roots[sonDer] = 0;
                sonDer = 0;
            } else {
                if (elements[sonIzq].compareTo(elements[sonDer]) <= 0) {
                    elements[father] = elements[sonIzq];
                    father = sonIzq;
                } else {
                    elements[father] = elements[sonDer];
                    father = sonDer;
                }
                sonIzq = (father * 2) + 1;
                sonDer = (father * 2) + 2;
            }
        }

        return res;
    }
}