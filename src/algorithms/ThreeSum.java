package algorithms;

import edu.princeton.cs.algs4.StdOut;

/**
 * Created by dh on 2018/12/14.
 */
public class ThreeSum {

    public static int count(int[] a){
        int N = a.length ;
        int cnt = 0 ;
        for(int i = 0 ; i < N ; i ++){
            for(int j = i + 1 ; j < N ; j ++){
                for(int k = j + 1 ;k < N ; k ++){
                    if(a[i] + a[j] + a[k] == 0){
                        cnt ++ ;
                    }
                }
            }
        }
        return cnt ;
    }
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,-6,7,8,-3} ;
        StdOut.println(count(a));
    }
}
