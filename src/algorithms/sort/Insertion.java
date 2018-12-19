package algorithms.sort;

import edu.princeton.cs.algs4.In;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by dh on 2018/12/19.
 */
public class Insertion extends SortAbstract {

    public static void sort(Comparable[] a){
        int N = a.length ;
        for(int i = 1 ; i < N ; i ++){
            for(int j = i ; j > 0 && less(a[j],a[j - 1]); j --){
                exch(a,j,j - 1);
            }
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
