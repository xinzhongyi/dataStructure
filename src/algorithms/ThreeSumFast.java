package algorithms;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Created by dh on 2018/12/14.
 */
public class ThreeSumFast {

    public static int count(int[] a){
        Arrays.sort(a);
        int N = a.length ;
        int cnt = 0 ;
        for(int i = 0 ; i < N ; i ++){
            for(int j = i + 1; j < N ; j ++){
                if(BinarySearch.rank(-a[i]-a[j],a) > j){
                    cnt ++;
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
