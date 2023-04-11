package bubbleSort;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {
        int[] dataIterative = {6,9,2,5,8,1,4,3,7};
        int[] dataRecursive = {6,9,2,5,8,1,4,3,7};

        bubbleSortIterative(dataIterative);
        System.out.println(Arrays.toString(dataIterative));

        bubbleSortRecursive(dataRecursive, dataRecursive.length - 1);
        System.out.println(Arrays.toString(dataRecursive));

    }

    private static void bubbleSortIterative(int[] data) {
        for(int i = 0; i < data.length; i++){
            for(int j = 0; j < data.length - 1; j++){
                if(data[j] > data[j + 1]) {
                    swap(data, j, j+1);
                }
            }
        }
    }

    private static void bubbleSortRecursive(int[] data, int endIdx) {
        if(endIdx == 0)
            return;

        for(int i = 0; i < endIdx; i++) {
            if(data[i] > data[i + 1]) {
                swap(data, i, i + 1);
            }
        }

        bubbleSortRecursive(data, endIdx - 1);
    }

    private static void swap(int[] data, int i, int j) {
        if(i == j)
            return;

        data[i] = data[i] ^ data[j];
        data[j] = data[i] ^ data[j];
        data[i] = data[i] ^ data[j];
    }
}
