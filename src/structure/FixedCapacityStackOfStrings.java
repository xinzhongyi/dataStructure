package structure;

/**
 * Created by dh on 2018/12/12.
 */
public class FixedCapacityStackOfStrings {

    private String[] a ;
    private int N ;

    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap] ;
    }

    public void push(String s){
        // 动态增加 容量大小，以避免出现溢出
        if(N == a.length){
            resize(2 * a.length) ;
        }
        a[N++] = s ;
    }

    public String pop(){
        String item = a[--N] ;
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
        String[] temp = new String[max];
        for(int i = 0 ; i < N ; i ++){
            temp[i] = a[i];
        }
        a = temp ;
    }
}
