public class MergeSort {

    public static void main(String[] args) {
        int[] arreglo = {16, 18, 15, 6, 4, 7};

        System.out.println("Arreglo antes de ordenar:");
        printArray(arreglo);

        mergeSort(arr, 0, arr.length - 1);

        System.out.println("\nArreglo después de ordenar:");
        printArray(arr);
    }

    public static void mergeSort(int[] arreglo, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSort(arreglo, inicio, medio);
            mergeSort(arreglo, medio + 1, fin);
            merge(arreglo, inicio, medio, fin);
        }
    }

    public static void merge(int[] arreglo, int inicio, int medio, int fin) {
        int n1 = medio - inicio + 1;
        int n2 = fin - medio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arreglo[inicio + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arreglo[medio + 1 + j];

        int i = 0, j = 0;

        int k = inicio;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arreglo[k] = L[i];
                i++;
            } else {
                arreglo[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arreglo[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arreglo[k] = R[j];
            j++;
            k++;
        }
    }

    public static void printArray(int[] arreglo) {
        for (int i : arreglo) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

