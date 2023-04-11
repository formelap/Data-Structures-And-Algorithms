package insertionSort;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {

        int[] data = {6,9,2,5,8,1,4,3,7};
        insertionSort(data);
        System.out.println(Arrays.toString(data));

    }

    private static void insertionSort(int[] data) {
        for(int i = 1; i < data.length; i++) {
            int current = data[i];
            int j = i - 1;
            while(j >= 0 && current < data[j]){
                data[j + 1] = data[j];
                j--;
            }

            data[j + 1] = current;
        }
    }
}
