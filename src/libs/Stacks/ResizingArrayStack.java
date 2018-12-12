package libs.Stacks;

import java.util.Iterator;

/**
 * Created by dh on 2018/12/12.
 */
public class ResizingArrayStack<Item> implements Iterable<Item> {

    private Item[] a = (Item[]) new Object[1];
    private int N ;

    public void push(Item s){
        // 动态增加 容量大小，以避免出现溢出
        if(N == a.length){
            resize(2 * a.length) ;
        }
        a[N++] = s ;
    }

    public Item pop(){
        Item item = a[--N] ;
        a[N] = null ; //让内存可以回收，避免对象成游离状态
        // 动态减少容量大小，以节省内存空间使用
        if(N > 0 && N < a.length /4){
            resize(a.length / 2) ;
        }
        return item ;
    }

    public boolean isEmpty(){
        return N == 0;
    }

    public int size(){
        return N ;
    }

    public void resize(int max){
        Item[] temp = (Item[]) new Object[max];
        for(int i = 0 ; i < N ; i ++){
            temp[i] = a[i];
        }
        a = temp ;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<Item>{

        private int i = N ;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Item next() {
            return a[--i];
        }

        @Override
        public void remove() {
        }
    }

}
