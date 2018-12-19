package algorithms.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by dh on 2018/12/19.
 */
public class UFWeightedQuickUnion {
    private int[] id ;
    private int count ;
    private int[] size ;

    public UFWeightedQuickUnion(int N) {
        count = N ;

        id = new int[N] ;
        for(int i = 0 ; i < N ; i ++) id[i] = i ;

        size = new int[N] ;
        for(int i = 0 ; i < N ;i ++) size[i] = 1 ;
    }

    //找到p的根节点
    public int find(int p){
        while(p != id[p]) p = id[p] ;
        return p ;
    }

    public void union(int p, int q){
        int pRoot = find(p) ;
        int qRoot = find(q) ;
        if(pRoot == qRoot) return;

        if(size[pRoot] < size[qRoot]){
            id[pRoot] = qRoot ;
            size[qRoot] += size[pRoot] ;
        }else{
            id[qRoot] = pRoot ;
            size[pRoot] += size[qRoot] ;
        }
        count -- ;
    }

    public boolean connected(int p,int q){
        return find(p) == find(q) ;
    }

    public int count(){
        return count ;
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("F:\\ideaWorkspace\\dataStructure\\resource\\tinyUF.txt");
        System.setIn(input);
        int N = StdIn.readInt() ;
        UFWeightedQuickUnion ufWeightedQuickUnion = new UFWeightedQuickUnion(N) ;
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt() ;
            int q = StdIn.readInt() ;
            if(ufWeightedQuickUnion.connected(p,q)) continue;
            ufWeightedQuickUnion.union(p, q);
            StdOut.println(p + " " + q) ;
        }
        StdOut.println(ufWeightedQuickUnion.count() +" components") ;
    }
}
