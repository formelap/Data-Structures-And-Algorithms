package quickSort;

import java.util.Arrays;

public class Runner {

    public static void main(String[] args) {

        int[] data = {6,9,2,5,8,1,4,3,7};
        quickSort(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));

    }

    private static void quickSort(int[] data, int startIdx, int endIdx) {

        if (startIdx >= endIdx)
            return;

        int pivotIdx = partition(data, startIdx, endIdx);

        quickSort(data, startIdx, (pivotIdx - 1));
        quickSort(data, pivotIdx + 1, endIdx);

    }

    private static int partition(int[] data, int startIdx, int endIdx) {

        int pivot = data[endIdx];
        int i = (startIdx - 1);

        for(int j = startIdx; j < endIdx; j++) {
            if(data[j] < pivot) {
                i++;
                swap(data, i, j);
            }
        }

        swap(data, i + 1, endIdx);
        return i + 1;
    }

    private static void swap(int[] data, int i, int j) {
        if(i == j)
            return;

        data[i] = data[i] ^ data[j];
        data[j] = data[i] ^ data[j];
        data[i] = data[i] ^ data[j];
    }
}
