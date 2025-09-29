import java.lang.Math;

class Main {
    public static void main(String[] args) {
        int arrsize = 100000;
        boolean ascending = true;
        int[] arr = RandomizedArray(arrsize, -1000000, 1000000);

        int[] bubarr = arr.clone();
        int[] selarr = arr.clone();
        int[] insarr = arr.clone();

        long selstart = System.currentTimeMillis();
        Sort.Selection(selarr,ascending);
        long selfin = System.currentTimeMillis();

        long seltime = selfin-selstart;
        System.out.println("Sorting a random array size of "+arrsize+" took Selection Sort "+seltime+"ms to complete.");
        System.out.println("the array was sorted correctly: "+checkSort(selarr,ascending));

        long bubstart = System.currentTimeMillis();
        Sort.Bubble(bubarr,ascending);
        long bubfin = System.currentTimeMillis();

        long bubtime = bubfin-bubstart;
        System.out.println("Sorting a random array size of "+arrsize+" took Bubble Sort "+bubtime+"ms to complete.");
        System.out.println("the array was sorted correctly: "+checkSort(bubarr, ascending));

        long insstart = System.currentTimeMillis();
        Sort.Insertion(insarr, ascending);
        long insfin = System.currentTimeMillis();

        long instime = insfin-insstart;
        System.out.println("Sorting a random array size of "+arrsize+" took Insertion Sort "+instime+"ms to complete.");
        System.out.println("the array was sorted correctly: "+checkSort(insarr, ascending));
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
        System.out.println();
    }

    private static boolean checkSort(int[] arr, boolean ascending) {
        if (ascending) {
            for (int i=1; i<arr.length; i++)
                if (arr[i-1] > arr[i]) return false;
        }
        else{
            for (int i=1; i<arr.length; i++)
                if (arr[i-1] < arr[i]) return false;
        }
        return true;
    }
}

class Sort {
    public static int[] Selection(int[] arr, boolean ascending) {
        int mindex, tmp;
        if (ascending) {
            for (int pos=0; pos<arr.length-1; pos++) {
                mindex=pos;
                for (int i=pos+1; i<arr.length; i++) {
                    if (arr[i]<arr[mindex]) mindex=i;
                }
                tmp = arr[mindex];
                arr[mindex]=arr[pos];
                arr[pos]=tmp;
            }
        }
        else{
            //descending order
            for (int pos=0; pos<arr.length-1; pos++) {
                mindex=pos;
                for (int i=pos+1; i<arr.length; i++) {
                    if (arr[i]>arr[mindex])  mindex=i;
                }
                tmp = arr[mindex];
                arr[mindex]=arr[pos];
                arr[pos]=tmp;
            }
        }
        return arr;
    }

    public static int[] Bubble(int[] arr, boolean ascending) {
        int tmp;
        if (ascending) {
            for (int i=0; i<arr.length-1; i++) {
                for (int j=0; j<arr.length-1-i; j++) {
                    if (arr[j]>arr[j+1]) {
                        tmp = arr[j+1];
                        arr[j+1]=arr[j];
                        arr[j]=tmp;
                    }
                }
            }
        }
        else {
            //descending order
            for (int i=0; i<arr.length-1; i++) {
                for (int j=0; j<arr.length-1-i; j++) {
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

    public static int[] Insertion(int[] arr, boolean ascending) {
        // rewrite so it shifts. don't swap every time. save the key 
        // and insert once the correct position is found
        int key, tpos;
        if (ascending) {
            for (int i=1; i<arr.length; i++) {
                key = arr[i];
                for (tpos=i-1; tpos>=0; tpos--) {
                    if (arr[tpos]>key) {
                        arr[tpos+1]=arr[tpos];
                    }
                    else break;
                }
                arr[tpos+1] = key;
            }
        }
        else{
            for (int i=1; i<arr.length; i++) {
                key = arr[i];
                for (tpos=i-1; tpos>=0; tpos--) {
                    if (arr[tpos]<key) {
                        arr[tpos+1]=arr[tpos];
                    }
                    else break;
                }
                arr[tpos+1] = key;
            }
        }
        return arr;
    }
}
