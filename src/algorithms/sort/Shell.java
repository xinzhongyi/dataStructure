package algorithms.sort;

import edu.princeton.cs.algs4.In;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by dh on 2018/12/20.
 */
public class Shell extends SortAbstract {

    public static void sort(Comparable[] a){
        int N = a.length ;
        int h = 1 ;
        while(h < N/3) h = h * 3 + 1 ;

        while(h >= 1){
            for(int i = h ; i < N; i ++){
                for(int j = i ; j >= h && less(a[j],a[j - h]); j -= h){
                    exch(a,j,j - h) ;
                }
            }
            h = h / 3 ;
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
