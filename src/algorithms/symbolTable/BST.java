package algorithms.symbolTable;

/**
 * Created by dh on 2018/12/28.
 */
public class BST<Key extends Comparable<Key>,Value> implements ST<Key,Value> {

    private Node root ;

    private class Node{
        private Key key ;
        private Value val ;
        private Node left, right ;
        private int N ;
        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
    }

    @Override
    public void put(Key key, Value val) {
        root = put(root,key,val) ;
    }

    private Node put(Node x,Key key,Value value){
        if(x == null) return new Node(key,value,1) ;
        int cmp = key.compareTo(x.key) ;
        if(cmp < 0) x.left = put(x.left,key,value) ;
        else if(cmp > 0) x.right = put(x.right,key,value) ;
        else x.val = value ;
        x.N = size(x.left) + size(x.right) + 1 ;
        return x ;
    }

    @Override
    public Value get(Key key) {
        return get(root,key);
    }

    private Value get(Node x,Key key){
        if(x == null) return null ;
        int cmp = key.compareTo(x.key) ;
        if(cmp < 0) return get(x.left,key) ;
        else if(cmp > 0) return get(x.right,key) ;
        else return x.val ;
    }

    @Override
    public void delete(Key key) {

    }

    private void delete(Node x,Key key){}

    @Override
    public boolean contains(Key key) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x){
        if(x == null) return 0 ;
        else return x.N ;
    }

    @Override
    public Key min() {
        return min(root).key;
    }

    private Node min(Node x){
        if(x.left == null) return x ;
        return min(x.left) ;
    }

    @Override
    public Key Max() {
        return max(root).key;
    }

    private Node max(Node x){
        if(x.right == null) return x ;
        return max(x.right) ;
    }

    @Override
    public Key floor(Key key) {
        Node x = floor(root,key) ;
        if(x == null) return null ;
        return x.key;
    }

    private Node floor(Node x,Key key){
        if(x == null) return null ;
        int cmp = key.compareTo(x.key) ;
        if(cmp == 0) return x ;
        if(cmp < 0) return floor(x.left,key) ;
        Node t = floor(x.right,key) ;
        if(t != null) return t ;
        else return x ;
    }

    @Override
    public Key ceiling(Key key) {
        return null;
    }

    @Override
    public int rank(Key key) {
        return 0;
    }

    @Override
    public Key select(int k) {
        return select(root,k).key;
    }

    private Node select(Node x,int k){
        if(x == null) return null ;
        int t = size(x.left) ;
        if(t > k) return select(x.left,k) ;
        //如果k在x的右字数中，需要比较右子树的N与k-t-1是否一致
        else if(t < k) return select(x.right,k - t - 1) ;
        else return x ;
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root) ;
    }

    private Node deleteMin(Node x){
        if(x.left == null) return x.right ;
        x.left = deleteMin(x.left) ;
        x.N = size(x.left) + size(x.right) + 1 ;
        return x ;
    }

    @Override
    public void deleteMax() {
        root = deleteMax(root) ;
    }

    private Node deleteMax(Node x){
        if(x.right == null) return x.left ;
        x.right = deleteMin(x.right) ;
        x.N = size(x.left) + size(x.right) + 1 ;
        return x ;
    }

    @Override
    public int size(Key lo, Key hi) {
        return 0;
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi) {
        return null;
    }

    @Override
    public Iterable<Key> keys() {
        return null;
    }
}
