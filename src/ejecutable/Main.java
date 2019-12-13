package ejecutable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import libraries.Sorts;

public class Main {
    public static void main(String[] args) throws Exception {
        String completo;
        String[] palabras = new String[50000];

        try {
            Scanner lee = new Scanner(new File(System.getProperty("user.dir") + "/Trie/palabras.txt"));
            completo = lee.nextLine();
            palabras = completo.split(" ");
            lee.close();
        } catch (FileNotFoundException fnfe) {
            System.out.println("Error:" + fnfe.toString());
            System.exit(-1);
        }

        String[] palabras1000Merge = new String[1000];
        String[] palabras1000Trie = new String[1000];
        String[] palabras1000Heap = new String[1000];
        String[] palabras10000Merge = new String[10000];
        String[] palabras10000Trie = new String[10000];
        String[] palabras10000Heap = new String[10000];
        String[] palabras20000Merge = new String[20000];
        String[] palabras20000Trie = new String[20000];
        String[] palabras20000Heap = new String[20000];
        String[] palabras25000Merge = new String[25000];
        String[] palabras25000Trie = new String[25000];
        String[] palabras25000Heap = new String[25000];
        String[] palabras50000Merge = new String[50000];
        String[] palabras50000Trie = new String[50000];
        String[] palabras50000Heap = new String[50000];

        long start, end;

        // ! Usamos 1000 palabras
        for (int i = 0; i < 1000; i++) {
            palabras1000Merge[i] = palabras[i];
            palabras1000Trie[i] = palabras[i];
            palabras1000Heap[i] = palabras[i];
        }

        start = System.nanoTime();
        String[] ordenado1000Heap = Sorts.heapSort(palabras1000Heap);
        end = System.nanoTime();
        System.out.println("Tiempo en Heap1000 nano: " + (end - start));

        start = System.nanoTime();
        String ordenado1000 = Sorts.trieSort(palabras1000Trie);
        end = System.nanoTime();
        System.out.println("Tiempo en Trie1000 nano: " + (end - start));

        start = System.nanoTime();
        Sorts.mergeSort(palabras1000Merge);
        end = System.nanoTime();
        System.out.println("Tiempo en Merge1000 nano: " + (end - start));


        // ! Usamos 10000 palabras
        for (int i = 0; i < 10000; i++) {
            palabras10000Merge[i] = palabras[i];
            palabras10000Trie[i] = palabras[i];
            palabras10000Heap[i] = palabras[i];
        }

        start = System.nanoTime();
        String[] ordenado10000Heap = Sorts.heapSort(palabras10000Heap);
        end = System.nanoTime();
        System.out.println("Tiempo en Heap10000 nano: " + (end - start));

        start = System.nanoTime();
        String ordenado10000 = Sorts.trieSort(palabras10000Trie);
        end = System.nanoTime();
        System.out.println("Tiempo en Trie10000 nano: " + (end - start));

        start = System.nanoTime();
        Sorts.mergeSort(palabras10000Merge);
        end = System.nanoTime();
        System.out.println("Tiempo en Merge10000 nano: " + (end - start));


        // ! Usamos 20000 palabras
        for (int i = 0; i < 20000; i++) {
            palabras20000Merge[i] = palabras[i];
            palabras20000Trie[i] = palabras[i];
            palabras20000Heap[i] = palabras[i];
        }

        start = System.nanoTime();
        String[] ordenado20000Heap = Sorts.heapSort(palabras20000Heap);
        end = System.nanoTime();
        System.out.println("Tiempo en Heap20000 nano: " + (end - start));

        start = System.nanoTime();
        String ordenado20000 = Sorts.trieSort(palabras20000Trie);
        end = System.nanoTime();
        System.out.println("Tiempo en Trie20000 nano: " + (end - start));

        start = System.nanoTime();
        Sorts.mergeSort(palabras20000Merge);
        end = System.nanoTime();
        System.out.println("Tiempo en Merge20000 nano: " + (end - start));


        // ! Usamos 25000 palabras
        for (int i = 0; i < 25000; i++) {
            palabras25000Merge[i] = palabras[i];
            palabras25000Trie[i] = palabras[i];
            palabras25000Heap[i] = palabras[i];
        }

        start = System.nanoTime();
        String[] ordenado25000Heap = Sorts.heapSort(palabras25000Heap);
        end = System.nanoTime();
        System.out.println("Tiempo en Heap25000 nano: " + (end - start));

        start = System.nanoTime();
        String ordenado25000 = Sorts.trieSort(palabras25000Trie);
        end = System.nanoTime();
        System.out.println("Tiempo en Trie25000 nano: " + (end - start));

        start = System.nanoTime();
        Sorts.mergeSort(palabras25000Merge);
        end = System.nanoTime();
        System.out.println("Tiempo en Merge25000 nano: " + (end - start));


        // ! Usamos 50000 palabras
        for (int i = 0; i < 50000; i++) {
            palabras50000Merge[i] = palabras[i];
            palabras50000Trie[i] = palabras[i];
            palabras50000Heap[i] = palabras[i];
        }

        start = System.nanoTime();
        String[] ordenado50000Heap = Sorts.heapSort(palabras50000Heap);
        end = System.nanoTime();
        System.out.println("Tiempo en Heap50000 nano: " + (end - start));

        start = System.nanoTime();
        String ordenado50000 = Sorts.trieSort(palabras50000Trie);
        end = System.nanoTime();
        System.out.println("Tiempo en Trie50000 nano: " + (end - start));

        start = System.nanoTime();
        Sorts.mergeSort(palabras50000Merge);
        end = System.nanoTime();
        System.out.println("Tiempo en Merge50000 nano: " + (end - start));
    }
}