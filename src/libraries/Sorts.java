package libraries;

public class Sorts{
    static char[] abecedario = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
            't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8',
            '9', 'á', 'é', 'í', 'ó', 'ú', 'ä', 'ë', 'ï', 'ö', 'ü', 'ñ', 'Ñ', 'ç', 'à', 'è', 'ì', 'ò', 'ù', 'ã', 'ê' };

    public static void mergeSort(String a[]) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(String a[], int min, int max) {
        String[] temp;
        int izq, der;
        if (min >= max - 1)
            return;
        int tam = max - min + 1, mitad = (max + min) / 2;
        temp = new String[tam];
        mergeSort(a, min, mitad);
        mergeSort(a, mitad + 1, max);

        izq = min;
        der = mitad + 1;
        for (int i = 0; i < tam; i++) {
            if (izq <= mitad && der <= max) {
                if (a[izq].compareTo(a[der]) < 0)
                    temp[i] = a[izq++];
                else
                    temp[i] = a[der++];
            } else {
                if (izq <= mitad)
                    temp[i] = a[izq++];
                else
                    temp[i] = a[der++];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            a[min + i] = temp[i];
        }
    }

    public static String trieSort(String palabras[]){
        String res = null;
        Trie<String> aux = new Trie<String>(abecedario);
        for(int i = 0; i < palabras.length; i++){
            aux.add(palabras[i]);
        }
        res = aux.toString();
        return res;
    }

    public static String[] heapSort(String[] palabras){
        String[] res = new String[palabras.length];
        MinHeap<String> aux = new MinHeap<String>(20);
        for(int i = 0; i < palabras.length; i++)
            aux.add(palabras[i]);
        for (int i = 0; i < palabras.length; i++)
            res[i] = aux.deleteMin();
        return res;
    }
}
