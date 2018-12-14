package structure;

import java.util.Iterator;

/**
 * Created by dh on 2018/12/13.
 */
public class QueueList<Item> implements Iterable{
    private Node first ;
    private Node last ;
    private int N ;

    public boolean isEmpty(){ return N == 0 ;}

    public int size(){ return N ;}

    public void enqueue(Item item) {
        Node oldLast = last ;
        last = new Node() ;
        last.setItem(item);
        last.setNext(null);
        if(isEmpty()){
            first = last ;
        }else{
            oldLast.setNext(last);
        }
        N ++ ;
    }

    public Item dequeue(){
        Node<Item> node = first ;
        first = first.getNext() ;
        if(isEmpty()){
            last = null ;
        }
        N -- ;
        return node.getItem() ;
    }


    @Override
    public Iterator iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        private Node<Item> current = first ;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            Item item = current.getItem() ;
            current = current.getNext() ;
            return item;
        }

        @Override
        public void remove() {

        }
    }

}
