package algorithms.sort;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;
import org.junit.jupiter.api.Assertions;
import structure.StackList;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

/**
 * Created by dh on 2018/12/25.
 */
public class MaxPQ<Key extends Comparable<Key>> {
    private Key[] pq ;
    private int N = 0 ;

    public MaxPQ(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty(){
        return N == 0 ;
    }

    public int size(){
        return N ;
    }

    public void insert(Key v){
        pq[++N] = v ;
        swim(N) ;
    }

    public Key delMax(){
        Key max = pq[1] ;
        exch(1,N--);
        pq[N + 1] = null ;
        sink(1);
        return max ;
    }

    private boolean less(int i, int j){
        return pq[i].compareTo(pq[j]) < 0 ;
    }

    private void exch(int i, int j){
        Key t = pq[i] ;
        pq[i] = pq[j] ;
        pq[j] = t ;
    }

    private void swim(int k){
        while(k > 1 && less(k/2,k)){
            exch(k/2,k);
            k = k / 2 ;
        }
    }

    private void sink(int k){
        while(k * 2 <= N){
            int j = k * 2 ;
            if(j < N && less(j,j + 1)) j ++ ;
            if(!less(k,j)) break;
            exch(k,j);
            k = j ;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream input = new FileInputStream("F:\\ideaWorkspace\\dataStructure\\resource\\tinyBatch.txt");
        System.setIn(input);
        int M = 10 ;
        MaxPQ<Transaction> pq = new MaxPQ<Transaction>(M + 1) ;
        while(StdIn.hasNextLine()){
            pq.insert(new Transaction(StdIn.readLine()));
            if(pq.size() > M){
                pq.delMax() ;
            }
        }

        StackList<Transaction> stack = new StackList<Transaction>();
        while(!pq.isEmpty()){
            stack.push(pq.delMax());
        }
        Iterator it = stack.iterator() ;
        while(it.hasNext()){
            StdOut.println(it.next());
        }
    }
}
