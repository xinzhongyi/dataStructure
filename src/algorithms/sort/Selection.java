package algorithms.sort;

import algorithms.UnionFind.UFWeightedQuickUnion;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by dh on 2018/12/19.
 */
public class Selection extends SortAbstract {

    public static void sort(Comparable[] a) {
        int N = a.length ;
        for(int i = 0 ; i < N ; i ++){
            int min = i ;
            for(int j = i + 1; j < N ; j ++){
                if(less(a[j],a[min])) min = j ;
            }
            exch(a,i,min);
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
