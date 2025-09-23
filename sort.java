import java.lang.Math;

class Main {
    public static void main(String[] args) {
        int[] arr = RandomizedArray(-300000, 300000, 600001);
        printArr(arr);
    }

    //gen random arr with unique values
    //implemented fisher-yates
    private static int[] RandomizedArray(int size, int start, int end) {
        if (size > end-start+1) {
            System.out.println("there are enough unique values between "+start+
                    " and "+end+" to get "+size+" unique vlaues.");
            int[] nullarr = {};
            return nullarr;
        }

        int[] arr = new int[end-start+1];

        for (int i=0; i<arr.length; i++) {
            arr[i] = start+i;
        }

        for (int i=0; i<arr.length-1; i++) {
            int tval = arr[i];
            int tindex = (int) (Math.random() * (arr.length));
            arr[i] = arr[tindex];
            arr[tindex] = tval;
        }
        int[] result = new int[size];
        for (int i=0; i<size; i++) {
            result[i] = arr[i];
        }
        return result;
    }

    private static void printArr(int[] arr) {
        for (int i:arr) {
            System.out.print(i+"//");
        }
    }
}

class SelSort {
}

class BubSort {
}
