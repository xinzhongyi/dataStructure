package algorithms.symbolTable;

/**
 * Created by dh on 2018/12/28.
 */
public interface ST<Key extends Comparable<Key>,Value> {

    void put(Key key,Value val) ;

    Value get(Key key) ;

    void delete(Key key) ;

    boolean contains(Key key) ;

    boolean isEmpty() ;

    int size() ;

    Key min() ;

    Key Max() ;

    Key floor(Key key) ;

    Key ceiling(Key key) ;

    int rank(Key key) ;

    Key select(int k) ;

    void deleteMin() ;

    void deleteMax() ;

    int size(Key lo,Key hi) ;

    Iterable<Key> keys(Key lo,Key hi) ;

    Iterable<Key> keys() ;
}
