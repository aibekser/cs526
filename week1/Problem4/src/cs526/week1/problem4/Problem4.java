package cs526.week1.problem4;

class Node {
    int value;
    Node next;
    Node prev;

    Node(int value) {
        this.value = value;
        this.next = null;
        this.prev = null;
    }
}

public class Problem4 {
    public static int sumOfThreeMiddles(Node head) {
        if (head == null) return 0;

        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        int mid = length / 2;
        temp = head;
        for (int i = 0; i < mid; i++) {
            temp = temp.next;
        }

        return temp.prev.value + temp.value + temp.next.value;
    }

    public static void main(String[] args) {
        Node head = new Node(3);
        Node n1 = new Node(7);
        Node n2 = new Node(9);
        Node n3 = new Node(12);
        Node n4 = new Node(18);
        Node n5 = new Node(30);
        Node n6 = new Node(44);

        head.next = n1;

        n1.prev = head;
        n1.next = n2;
        
        n2.prev = n1;
        n2.next = n3;
        
        n3.prev = n2;
        n3.next = n4;
        
        n4.prev = n3;
        n4.next = n5;
        
        n5.prev = n4;
        n5.next = n6;
        
        n6.prev = n5;

        System.out.println(sumOfThreeMiddles(head));
    }
}
