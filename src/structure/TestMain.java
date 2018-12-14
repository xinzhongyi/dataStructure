package structure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

/**
 * Created by dh on 2018/12/13.
 */
public class TestMain {

    public String[] ary = {
            "test1",
            "test2",
            "test3"
    };

    @Test
    public void testStackList(){
        StackList<String> stack = new StackList<>() ;
        for(String item : ary){
            stack.push(item);
        }
        Iterator it = stack.iterator() ;
        int i = ary.length - 1 ;
        while(it.hasNext()){
            Assertions.assertEquals(ary[i--],it.next()) ;
        }
    }

    @Test
    public void testQueue(){
        QueueList<String> queue = new QueueList<String>();
        for(String item : ary){
            queue.enqueue(item);
        }

        Iterator it = queue.iterator() ;
        int i = 0 ;
        while(it.hasNext()){
            Assertions.assertEquals(ary[i++],it.next()) ;
        }
    }
}
