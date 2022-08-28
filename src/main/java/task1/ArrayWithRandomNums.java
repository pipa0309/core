package task1;

public class ArrayWithRandomNums {
    private static final int LIMIT_OF_NUM = 100;
    private static final int CONST_NUM = 3;
    private static final int PRIME_NUM = 31;
    private static final int SIZE_X = 5;
    private static final int SIZE_Y = 5;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int[][] arrWithRandNums = getArrWithRandNums();
            printArr(arrWithRandNums);
            System.out.printf("max = %d\n", max(arrWithRandNums));
            System.out.printf("min = %d\n", min(arrWithRandNums));
            System.out.printf("avg = %f\n\n", avg(arrWithRandNums));
        }
    }

    private static int[][] getArrWithRandNums() {
        int[][] arr = new int[SIZE_Y][SIZE_X];
        for (int i = 0; i < SIZE_Y; i++) {
            for (int j = 0; j < SIZE_X; j++) {
                arr[i][j] = getRandNum();
            }
        }
        return arr;
    }

    private static int getRandNum() {
        int[] arr = new int[LIMIT_OF_NUM];
        long time = getDifferentTime();
        int result = getLinearCongruentialGenerator(arr, time);
        return arr[result % LIMIT_OF_NUM];
    }

    private static int getLinearCongruentialGenerator(int[] arr, long time) {
        long accum = 0;
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            accum += i;
            long num = (accum * PRIME_NUM + (CONST_NUM % LIMIT_OF_NUM));
            res = (int) (time / num) % LIMIT_OF_NUM;
            if (res < 0) {
                res *= -1;
            }
            arr[i] = res;
        }
        return res;
    }

    private static long getDifferentTime() {
        long time = 0L;
        for (int i = 0; i < LIMIT_OF_NUM; i += (System.nanoTime() % LIMIT_OF_NUM)) {
            time = i * System.nanoTime();
        }
        return time;
    }

    public static void printArr(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int min(int[][] arr) {
        int min = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (min > arr[i][j]) {
                    min = arr[i][j];
                }
            }
        }
        return min;
    }

    private static int max(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    private static double avg(int[][] arr) {
        double sum = 0.0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        return sum / (arr.length * arr.length);
    }
}
