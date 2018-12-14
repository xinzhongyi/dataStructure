package algorithms;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by dh on 2018/12/14.
 */
public class TwoSumFast {

    public static int count(int[] a){
        Arrays.sort(a);
        int N = a.length ;
        int cnt = 0 ;
        for(int i = 0 ; i < N ; i ++){
            if(BinarySearch.rank(-a[i],a) > i){
                cnt ++ ;
            }
        }
        return cnt ;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,2,5,-3,-5,-1,6,-8} ;
        StdOut.println(count(a));
    }
}
