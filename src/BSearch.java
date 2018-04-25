import java.math.BigDecimal;
import java.util.Random;

public class BSearch {
    //    Generic Recursive & "First Entry" & "Log Time" finding implementation of Binary Search.
    public static <T extends Comparable> int bSearch(T[] a, T x){
        return recSearch(a, 0, a.length, x);
    }

    private static <T extends Comparable> int recSearch(T[] a, int lo, int hi, T x){
        if (lo > hi){return -1;}
        int searchIndex = lo + (hi - lo) / 2;
        if (a[searchIndex].compareTo(x) < 0){
            return recSearch(a, searchIndex + 1, hi, x);
        }
        if (a[searchIndex].compareTo(x) > 0){
            return recSearch(a, lo, searchIndex - 1, x);
        }
        int lowerOccurrence = recSearch(a, lo, searchIndex - 1, x);
        return (lowerOccurrence == -1) ? searchIndex : lowerOccurrence;
    }

    public static void main(String[] args){
        System.out.printf("Input: a = [0,1,2,3,4,4,5], x = 4\nResult: %d\n\n",bSearch(new Integer[] {0,1,2,3,4,4,5}, 4));

        System.out.println("Random Testing of type a = [0,1,2,3,4...n]");
        int N = 10;
        for (int pow = 1; pow < 8; pow++){
            int size = (int)Math.pow(10,pow); //int range goes up to 2*10^9
            double meantime = 0;
            Integer[] a = new Integer[size];
            for (Integer i = 0; i < size; i++){
                a[i] = i;
            }
            for (int j = 0; j < N; j++){
                Integer x = new Random().nextInt(size);
                double start = java.lang.System.nanoTime();
                bSearch(a,x);
                meantime += (java.lang.System.nanoTime() - start)/ N;
            }
            System.out.printf("Size: %d \nTime: %d ns\n\n", size, Math.round(meantime));
        }

        System.out.println("----------------------------------------------------------");

        System.out.println("Random Testing of type a = [1,1,1,1,1,...,1]");
        for (int pow = 1; pow < 8; pow++){
            int s = (int)Math.pow(10,pow); //int range goes up to 2*10^9
            double meantime = 0;
            Integer[] a = new Integer[s];
            Integer x = new Random().nextInt(s);
            for (Integer i = 0; i < s; i++){
                a[i] = x;
            }

            for (int j = 0; j < N; j++){
                double start = java.lang.System.nanoTime();
                bSearch(a,x);
                meantime += (java.lang.System.nanoTime() - start)/ N;
            }
            System.out.printf("Size: %d \nTime: %d ns\n\n", s, Math.round(meantime));
        }
    }
}
