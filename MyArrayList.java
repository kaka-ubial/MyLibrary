import java.lang.reflect.Array;

public class MyArrayList<E> {
    private E[] elements;
    private int size;
    private int capacity;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList(Class<E> clazz, int capacity) {
        this.capacity = capacity;
        this.elements = (E[]) Array.newInstance(clazz, capacity);
        this.size = 0;
    }

    public MyArrayList(Class<E> clazz) {
        this(clazz, DEFAULT_CAPACITY);
    }

    public void add(E element) {
        if (size == capacity) {
            grow();
        }
        elements[size++] = element;
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Índice fora do intervalo válido");
        }
        if (size == capacity) {
            grow();
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora do intervalo válido");
        }
        E removedElement = elements[index];
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null; 
        return removedElement;
    }

    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    public E set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora do intervalo válido");
        }
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fora do intervalo válido");
        }
        return elements[index];
    }

    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public Object[] toArray() {
        Object[] array = new Object[size];
        for (int i = 0; i < size; i++) {
            array[i] = elements[i];
        }
        return array;
    }

    private void grow() {
        int newCapacity = capacity * 2;
        E[] newElements = (E[]) Array.newInstance(elements.getClass().getComponentType(), newCapacity);
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
        capacity = newCapacity;
    }

    public int size() {
        return size;
    }


}
