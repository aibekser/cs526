package cs526.week1.problem2;

class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

public class Problem2 {
    public static void doIt(Node node) {
        if (node == null) return;
        doIt(node.next);
        System.out.println(node.value);
    }

    public static void main(String[] args) {
        Node head = new Node(12);
        head.next = new Node(3);
        head.next.next = new Node(5);
        head.next.next.next = new Node(2);

        doIt(head);
    }
}
