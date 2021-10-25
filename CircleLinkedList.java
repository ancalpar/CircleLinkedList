public class CircleLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size = 0;

    public void insert (E data) {
        Node<E> node = new Node<>(data);

        if (head == null){
            head = node;
        }
        else{
            tail.next = node;
        }
        tail = node;
        node.next = head;
        size++;
    }

    public void insert (E data, int index) {
        if (index<0)
            throw new RuntimeException();
        index%=size;

        Node<E> node = head;
        // Step to find node in previous index
        for (int i = 0; i < index-1; i++) {
            node=node.next;
        }
        if (index == 0) {
            node.next = head;
            head = node;
        }
        else if (index == size-1) {
            Node<E> newNode = new Node<>(data);
            node.next = head;
            newNode.next = null;
        }
        else {
            Node<E> newNode = new Node<>(data);
            newNode.next = node.next;
            node.next = newNode;
        }
        size++;
    }

    public void delete(int index) {
        if (index<0)
            throw new RuntimeException();
        index %= size;

        Node<E> node = head;

        if (index == 0) {
            head = node.next;
            node.next = null;
        }
        else {
            // Step to find node in previous index
            for (int i = 0; i < index-1; i++) {
                node = node.next;
            }

            Node<E> deletedNode = node.next;
            if (size-1 == index) {
                deletedNode.next = null;
                node.next = head;
                tail = node;
            }
            else {
                node.next = deletedNode.next;
                deletedNode.next = null;
            }
        }
        size--;
    }
    public String toString() {
        if (head == null)
            return "[]";
        Node<E> node = head;

        StringBuilder elements = new StringBuilder("[");
        elements.append(node.data).append(node.next != null ? "," : "");
        for (int i = 1; i < size; i++) {
            node = node.next;
            assert node != null;
            elements.append(node.data).append(i+1 != size ? "," : "");
        }
        elements.append("]");

        return elements.toString();
    }
}
