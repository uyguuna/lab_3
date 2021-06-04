class Node2{

    public int value;
    public Node2 next;

    Node2(int value, Node2 next) {
        this.value = value;
        this.next = next;
    }
}

public class prog33 {

    public static void main(String[] args){
        int k = 10;
        Node2 head = createHead(k);
        toString(head);

        head = createTail(k);
        toString(head);

        Node2 node = new Node2(5, null);
        head = addFirst(node, head);
        toString(head);

        node = new Node2(5, null);
        head = addFirst(node, head);
        toString(head);

        node = new Node2(9, null);
        head = insert(node, head, 4);
        toString(head);

        head = removeFirst(head);
        toString(head);

        head = removeLast(head);
        toString(head);

        head = remove(head, 4);
        toString(head);

        head = createHeadRec(10);
        toString(head);

        head = createTailRec(10, null);
        toString(head);

        System.out.println(toStringRec(head));
    }

    private static Node2 createHead(int k) {
        Node2 head = new Node2(0, null);
        Node2 tail = head;

        for (int i = 0; i<(k-1); i++) {
            tail.next = new Node2(i+1, null);
            tail = tail.next;

        }
        return head;
    }

    private static Node2 createTail(int k) {
        Node2 head = null;
        for (int i = (k-1); i>=0; i--) {
            head = new Node2(i, head);
        }

        return head;
    }

    private static void toString(Node2 head) {
        Node2 ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
        System.out.print("\n");
    }

    private static Node2 addFirst(Node2 node, Node2 head) {
        node.next = head;
        return node;
    }

    private static Node2 addLast(Node2 node, Node2 head){
        Node2 ref = head;
        while (ref.next != null) {
            ref = ref.next;
        }
        ref.next = node;
        return head;
    }

    private static Node2 insert(Node2 node, Node2 head, int n) {
        Node2 ref = head;
        int k=1;
        while (ref.next != null && k<n){
            ref = ref.next;
            k++;
        }
        node.next = ref.next;
        ref.next = node;
        return head;
    }

    private static Node2 removeFirst(Node2 head) {
        head = head.next;
        return head;
    }

    private static Node2 removeLast(Node2 head) {
        Node2 ref = head;
        while (ref.next.next !=null) {
            ref = ref.next;
        }
        ref.next = null;
        return head;
    }

    private static Node2 remove(Node2 head, int n) {
        Node2 ref = head;
        int k = 1;
        while (ref.next != null && k < (n-1)) {
            ref = ref.next;
            k++;
        }
        ref.next = ref.next.next;
        return head;
    }

    private static Node2 createHeadRec(int k) {
        if (k>0) {
            return new Node2(k, createHeadRec(k-1));
        }
        return new Node2(k, null);
    }

    private static Node2 createTailRec(int k, Node2 node) {
        if (k>0) {
            k--;
            Node2 head;
            if (node == null) {
                head = new Node2(k, null);

            } else {
                head = new Node2(k, node);
            }
            return createTailRec(k, head);
        }
        return node;
    }

    private static String toStringRec(Node2 head) {
        if (head.next != null) {
            return Integer.toString(head.value) + " " + toStringRec(head.next);
        }
        return Integer.toString(head.value);
    }
}
