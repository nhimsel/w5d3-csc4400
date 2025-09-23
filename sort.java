import java.lang.Math;

class Main {
    public static void main(String[] args) {
    }

    //gen random arr with unique values
    //implemented fisher-yates
    private static int[] generate_random_unique(int start, int end, int total) {
        int[] arr = new int[end-start];

        for (int i=0; i<arr.length; i++) {
            arr[i] = start+i;
        }

        for (int i=0; i<arr.length-1; i++) {
            int tval = arr[i];
            int tindex = (int) (Math.random() * (arr.length));
            arr[i] = arr[tindex];
            arr[tindex] = tval;
        }
        int[] result = new int[total];
        for (int i=0; i<total; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}
