package task2;

public class Sort {
    private static final int LOW_INDEX = 0;

    public static void main(String[] args) {
        int[] arr = new int[]{5, 6, 3, 2, 5, 1, 4, 9};
        printArr(arr);
        sortArr(arr);
        printArr(arr);
    }

    private static void sortArr(int[] arr) {
        sortArr(arr, LOW_INDEX, arr.length - 1);
    }

    private static void sortArr(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = arr[high];
        int leftMarker = low;
        int rightMarker = high;

        while (leftMarker < rightMarker) {
            while (arr[leftMarker] <= pivot && leftMarker < rightMarker) {
                leftMarker++;
            }
            while (arr[rightMarker] >= pivot && leftMarker < rightMarker) {
                rightMarker--;
            }
            swap(arr, leftMarker, rightMarker);
        }
        swap(arr, leftMarker, high);
        sortArr(arr, low, leftMarker - 1);
        sortArr(arr, leftMarker, high);
    }

    private static void swap(int[] arr, int leftMarker, int rightMarker) {
        assert (leftMarker < arr.length && rightMarker > -1);

        int tmp = arr[leftMarker];
        arr[leftMarker] = arr[rightMarker];
        arr[rightMarker] = tmp;
    }

    private static void printArr(int[] arr) {
        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();
    }
}
