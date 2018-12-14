package structure;

/**
 * Created by dh on 2018/12/13.
 */
public class Node<Item> {
    private Item item ;
    private Node next ;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
