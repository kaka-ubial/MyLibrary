public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>(Integer.class);

        System.out.println("Adicionando elementos:");
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        printList(list);

        System.out.println("\nAdicionando 25 na posição 2:");
        list.add(2, 25);
        printList(list);

        System.out.println("\nRemovendo elemento no índice 3:");
        list.remove(3);
        printList(list);

        System.out.println("\nRemovendo o elemento 50:");
        list.remove((Integer) 50);
        printList(list);

        System.out.println("\nAlterando o elemento no índice 1 para 99:");
        list.set(1, 99);
        printList(list);

        System.out.println("\nObtendo o elemento no índice 2:");
        System.out.println("Elemento: " + list.get(2));

        System.out.println("\nVerificando se a lista contém o número 99:");
        System.out.println("Contém 99? " + list.contains(99));

        System.out.println("\nObtendo o índice do número 30:");
        System.out.println("Índice de 30: " + list.indexOf(30));

        System.out.println("\nConvertendo a lista para um array:");
        Object[] array = list.toArray();
        for (Object obj : array) {
            System.out.print(obj + " ");
        }
        System.out.println("\n");

        System.out.println("Tamanho final da lista: " + list.size());
    }

    // Método auxiliar para imprimir a lista
    private static <E> void printList(MyArrayList<E> list) {
        System.out.print("Lista: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
