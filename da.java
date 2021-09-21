import java.util.*;



class Main {

   static class Ascending {
        public static int[] sort(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    int tmp = 0;
                    if (arr[i] > arr[j]) {
                        tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                    }
                }
    
            }
            return arr;
        }
    
        public static String[] sort(String[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
    
                    if (arr[i].compareTo(arr[j]) > 0) {
    
                        String temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
            return arr;
        }
    
        public static double[] sort(double[] arr) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    double tmp = 0;
                    if (arr[i] > arr[j]) {
                        tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
            return arr;
        }
    }

   static class Test_Sort extends Ascending{
    
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner (System.in);
        int n = scn.nextInt();
        Test_Sort sort = new Test_Sort();

        
        int[] arr = new int[n];

        for(int i = 0; i<arr.length; i++){
            arr[i] = scn.nextInt();
        }

        sort.sort(arr);
        

    }
}