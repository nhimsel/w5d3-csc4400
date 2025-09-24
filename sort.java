import java.lang.Math;

class Main {
    public static void main(String[] args) {
        //int[] arr = RandomizedArray(-300000, 300000, 600001);
        int[] arr = RandomizedArray(7,3,12);
        printArr(arr);
        System.out.println();
        Bubble.Sort(arr,true);
        printArr(arr);
        System.out.println();
        Bubble.Sort(arr,false);
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

class Selection {
    public static int[] Sort(int[] arr, boolean ascending) {
        int cur, tpos, tmp;
        if (ascending) {
            for (int pos=0; pos<arr.length-1; pos++) {
                cur = arr[pos]; 
                tpos=pos;
                for (int i=pos+1; i<arr.length; i++) {
                    if (arr[i]<cur) {
                        cur = arr[i];
                        tpos=i;
                    }
                }
                tmp = arr[tpos];
                arr[tpos]=arr[pos];
                arr[pos]=tmp;
            }
        }
        else{
            //decending order
            for (int pos=0; pos<arr.length-1; pos++) {
                cur = arr[pos]; 
                tpos=pos;
                for (int i=pos+1; i<arr.length; i++) {
                    if (arr[i]>cur) {
                        cur = arr[i];
                        tpos=i;
                    }
                }
                tmp = arr[tpos];
                arr[tpos]=arr[pos];
                arr[pos]=tmp;
            }
        }
        return arr;
    }
}

class Bubble {
    public static int[] Sort(int[] arr, boolean ascending) {
        if (ascending) {
            int tpos, tval, tmp;
            for (int i=0; i<arr.length-1; i++) {
                for (int j=0; j<arr.length-1; j++) {
                    if (arr[j]>arr[j+1]) {
                        tmp = arr[j+1];
                        arr[j+1]=arr[j];
                        arr[j]=tmp;
                    }
                }
            }
        }
        else {
            //decending order
            int tpos, tval, tmp;
            for (int i=0; i<arr.length-1; i++) {
                for (int j=0; j<arr.length-1; j++) {
                    if (arr[j]<arr[j+1]) {
                        tmp = arr[j+1];
                        arr[j+1]=arr[j];
                        arr[j]=tmp;
                    }
                }
            }
        }
        return arr;
    }
}
