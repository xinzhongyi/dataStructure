package structure;

import java.util.Iterator;

/**
 * Created by dh on 2018/12/13.
 */
public class StackList<Item> implements Iterable{
    private Node<Item> first ;
    private int N ;

    public void push(Item item){
        Node oldFirst = first ;
        first = new Node() ;
        first.setItem(item);
        first.setNext(oldFirst);
        N ++ ;
    }

    public Item pop(){
        Node<Item> node = first ;
        first = first.getNext() ;
        N -- ;
        return node.getItem() ;
    }

    public int size(){
        return N ;
    }

    public boolean isEmpty(){
        return N == 0;
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
