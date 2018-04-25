public class BSearchClassic{
//    Generic Recursive implementation of Binary Search.
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
        return searchIndex;
    }

    public static void main(String[] args){
        System.out.printf("Input: a = [0,1,2,3,4,4,5], x = 4\nResult: %d\n",bSearch(new Integer[] {0,1,2,3,4,4,5}, 4));
        System.out.println("Der erste Eintrag ist aber bei Index 4!");
    }

}
