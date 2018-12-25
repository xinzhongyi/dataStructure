package algorithms.sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by dh on 2018/12/25.
 */
public class Quick extends SortAbstract {

    public static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a,0,a.length - 1);
    }

    private static void sort(Comparable[] a,int lo,int hi){
        if(hi <= lo) return;
        int j = partition(a,lo,hi) ;
        sort(a,lo,j - 1) ;
        sort(a,j + 1, hi) ;
    }

    private static int partition(Comparable[] a,int lo,int hi){
        int i = lo ;
        int j = hi + 1;
        Comparable v = a[lo] ;
        while(true){
            while(less(a[++i],v)) if(i == hi) break ;
            while(less(v,a[--j])) if(j == lo) break ;
            if(i >= j) break ;
            exch(a,i,j);
        }
        exch(a,lo,j);
        return j ;
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
