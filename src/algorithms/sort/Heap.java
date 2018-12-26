package algorithms.sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;
import structure.StackList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 * Created by dh on 2018/12/26.
 */
public class Heap extends SortAbstract {

    public static void sort(Comparable[] a){
        int N = a.length - 1;
        for(int k = N / 2; k >= 1 ; k --){
            //从二分之一处下沉创建堆
            sink(a,k,N) ;
        }

        while(N > 1){
            exch(a,1,N--);
            sink(a,1,N) ;
        }
    }

    protected static void exch(Comparable[] a,int i, int j){
        Comparable t = a[i] ;
        a[i] = a[j] ;
        a[j] = t ;
    }

    private static boolean less(Comparable[] a, int i, int j){
        return a[i].compareTo(a[j]) < 0 ;
    }

    private static void sink(Comparable[] a,int k,int N){
        while(k * 2 <= N){
            int j = k * 2 ;
            if(j < N && less(a,j,j + 1)) j ++ ;
            if(!less(a,k,j)) break;
            exch(a,k,j);
            k = j ;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("F:\\ideaWorkspace\\dataStructure\\resource\\numbers.txt");
        System.setIn(input);
        int[] a = In.readInts() ;
        Integer[] b = new Integer[a.length + 1] ;
        for(int i = 0 ; i < a.length ; i ++){
            b[i + 1] = a[i] ;
        }
        sort(b);
        assert isSorted(b) ;
        show(b) ;
    }
}
