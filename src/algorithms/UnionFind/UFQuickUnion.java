package algorithms.UnionFind;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Created by dh on 2018/12/19.
 */
public class UFQuickUnion {

    private int[] id ;
    private int count ;

    public UFQuickUnion(int N) {
        id = new int[N] ;
        for(int i = 0 ; i < N ; i ++){
            id[i] = i ;
        }
        count = N ;
    }

    //查找根节点
    public int find(int p){
        while(p != id[p]) p = id[p] ;
        return p ;
    }

    // 连接两个节点，将P根节点指向q根节点
    public void union(int p,int q){
        int pRoot = find(p) ;
        int qRoot = find(q) ;
        if(pRoot == qRoot) return;

        id[pRoot] = qRoot ;
        count -- ;
    }

    public boolean connected(int p ,int q){
        return find(p) == find(q) ;
    }

    public int count(){
        return count ;
    }


    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("F:\\ideaWorkspace\\dataStructure\\resource\\tinyUF.txt");
        System.setIn(input);
        int N = StdIn.readInt() ;
        UFQuickUnion ufQuickUnion = new UFQuickUnion(N) ;
        while(!StdIn.isEmpty()){
            int p = StdIn.readInt() ;
            int q = StdIn.readInt() ;
            if(ufQuickUnion.connected(p,q)) continue;
            ufQuickUnion.union(p, q);
            StdOut.println(p + " " + q) ;
        }
        StdOut.println(ufQuickUnion.count() +" components") ;
    }
}
