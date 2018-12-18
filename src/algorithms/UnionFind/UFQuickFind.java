package algorithms.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by dh on 2018/12/18.
 */
public class UFQuickFind {

    private int[] id ;
    private int count ;

    public UFQuickFind(int N) {
        count = N ;
        id = new int[N] ;
        for(int i = 0 ; i < N ; i ++) id[i] = i ;
    }

    public void union(int p, int q){
        int pId = find(p) ;
        int qId = find(q) ;
        if(pId == qId) return;

        for(int i = 0 ; i < id.length ; i ++){
            if(id[i] == pId) id[i] = q ;
        }
        count -- ;
    }

    public int find(int p){
        return  id[p] ;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q) ;
    }

    public int count(){
        return  count ;
    }


    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("F:\\ideaWorkspace\\dataStructure\\resource\\tinyUF.txt");
        System.setIn(input);
        int N = StdIn.readInt() ;
        UFQuickFind ufQuickFind = new UFQuickFind(N) ;
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt() ;
            int q = StdIn.readInt() ;
            if(ufQuickFind.connected(p,q)) continue;
            ufQuickFind.union(p, q);
            StdOut.println(p + " " + q) ;
        }
        StdOut.println(ufQuickFind.count() +" components") ;
    }
}
