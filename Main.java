public class Main {
    public static void main(String[] args) {

        // ArrayList
        MyArrayList<Integer> list = new MyArrayList<>(Integer.class);

        System.out.println("Adicionando elementos:");
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        printList(list);

        list.add(2, 25);
        printList(list);

        list.remove(4);
        printList(list);

        list.remove((Integer) 50);
        printList(list);

        list.set(1, 33);
        printList(list);

        System.out.println("Elemento: " + list.get(2));

        System.out.println("Contém 33? " + list.contains(33));

        System.out.println("Índice de 30: " + list.indexOf(3));

        Object[] array = list.toArray();
        for (Object obj : array) {
            System.out.print(obj + " ");
        }
        System.out.println("\n");

        System.out.println("Tamanho final da lista: " + list.size());
    }

    private static <E> void printList(MyArrayList<E> list) {
        System.out.print("Lista: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();

        // Pilha
        MyStack<Integer> stack = new MyStack<>();
        System.out.println("Testando a Pilha");
        stack.push(5);
        stack.push(10);
        stack.push(15);
        System.out.println("Topo da pilha: " + stack.top());
        System.out.println("Removendo: " + stack.pop());
        System.out.println("Topo após remoção: " + stack.top());
        System.out.println("Tamanho da pilha: " + stack.size());

        // Fila
        MyQueue<String> queue = new MyQueue<>();
        System.out.println("\nTestando a Fila");
        queue.enqueue("A");
        queue.enqueue("B");
        queue.enqueue("C");
        System.out.println("Frente da fila: " + queue.start());
        System.out.println("Removendo: " + queue.dequeue());
        System.out.println("Frente após remoção: " + queue.start());
        System.out.println("Tamanho da fila: " + queue.size());
    }
}
