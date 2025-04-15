public class MyDoublyLinkedList<E> {
    private static class Node<E> {
        E data;
        Node<E> previous;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    private Node<E> base;
    private Node<E> top;
    private int size;

    public MyDoublyLinkedList() {
        this.base = this.top = null;
        this.size = 0;
    }

    public void add(int pos, E item) {
        Node<E> node = new Node<>(item);

        if (pos == 0) {
            node.next = base;
            if (base != null) {
                base.previous = node;
            }
            base = node;
            if (top == null) {
                top = node;
            }
        } else if (pos == size) {
            node.previous = top;
            if (top != null) {
                top.next = node;
            }
            top = node;
        } else {
            if (pos <= size / 2) {
                Node<E> current = base;
                for (int i = 0; i < pos; i++) {
                    current = current.next;
                }
                node.previous = current.previous;
                node.next = current;
                if (current.previous != null) {
                    current.previous.next = node;
                }
                current.previous = node;
            } else {
                Node<E> current = top;
                for (int i = 0; i < pos; i++) {
                    current = current.next;
                }
                node.previous = current.previous;
                node.next = current;
                if (current.previous != null) {
                    current.previous.next = node;
                }
                current.previous = node;
            }
            size++;
        }
    }

    public Node<E> remove() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}