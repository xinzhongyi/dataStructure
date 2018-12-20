package algorithms.sort;

import edu.princeton.cs.algs4.In;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by dh on 2018/12/20.
 */
public class Merge extends SortAbstract {

    private static Comparable[] aux ;

    public static void sort(Comparable[] a){
        aux = new Comparable[a.length] ;
        sort(a,0,a.length - 1);
    }

    public static void sort(Comparable[] a,int lo,int hi){
        if(hi <= lo) return;
        int mid = lo + (hi - lo) / 2 ;
        sort(a,lo,mid);
        sort(a,mid + 1,hi) ;
        merge(a,lo,mid,hi);
    }

    public static void merge(Comparable[] a, int lo, int mid, int hi){
        int i = lo ;
        int j = mid + 1 ;

        for(int k = lo ; k <= hi; k ++){
            aux[k] = a[k] ;
        }

        for(int k = lo ; k <= hi ; k ++){
            if(i > mid)  a[k] = aux[j++] ;
            else if(j > hi) a[k] = aux[i++] ;
            else if(less(aux[j],aux[i])) a[k] = aux[j++] ;
            else a[k] = aux[i++] ;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("F:\\ideaWorkspace\\dataStructure\\resource\\numbers.txt");
        System.setIn(input);
        int[] a = In.readInts() ;
        Integer[] b = new Integer[a.length] ;
        for(int i = 0 ; i < a.length ; i ++){
            b[i] = a[i] ;
        }
        sort(b);
        assert isSorted(b) ;
        show(b) ;
    }
}
