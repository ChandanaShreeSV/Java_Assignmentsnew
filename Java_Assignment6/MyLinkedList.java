class Node<E> {
    E data;
    Node<E> next;

    Node(E data) {
        this.data = data;
        this.next = null;
    }
}
class MyLinkedList<E> {
    private Node<E> head;
    private int size = 0;
 public void add(E element) {
        Node<E> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            Node<E> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        size++;
    }
     public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.data;
    }
    public E remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<E> temp = head;
        if (index == 0) {
            head = head.next;
            size--;
            return temp.data;
        }
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        E removed = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return removed;
    }
     public int size() {
        return size;
    }
     public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");

        System.out.println("Element at 1: " + list.get(1));
        System.out.println("Removed: " + list.remove(0));
        System.out.println("New size: " + list.size());
    }
}
