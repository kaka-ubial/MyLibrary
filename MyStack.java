public class MyStack<E> {
    private static class Node<E> {
        E data;
        Node<E> previous;

        Node(E data) {
            this.data = data;
            this.previous = null;
        }
    }

    private Node<E> top;
    private int size;

    public MyStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(E element) {
        Node<E> node = new Node<>(element);
        node.previous = top;
        top = node;
        size++;
    }

    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        E item = top.data;
        top = top.previous;
        size--;
        return item;
    }

    public E top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}