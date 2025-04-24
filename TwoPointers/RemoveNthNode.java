
import java.util.Arrays;
import java.util.List;

class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class RemoveNthNode {
    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        LinkedListNode right = head;
        LinkedListNode left = head;

        // Move right pointer n elements away from left pointer
        for (int i = 0; i < n; i++) {
            right = right.next;
            System.out.println("DATA: " + right.data);
        }

        // If after moving the right node n spaces and its null then that means
        // the nth node from the end is the head node
        // Removal of the head node
        if (right == null) {
            return head.next;
        }

        // Move pointers until right piointer reaches last node.
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }

        // At this point, the left pointer points to (n-1)th element.
        // So link it to nect to next element of the left
        System.out.println("LEFT: " + left.data);
        System.out.println("RIGHT: " + right.data);
        left.next = left.next.next;

        return head;
    }

    public static void main(String[] args) {
        LinkedListNode linkedList = new LinkedListNode(23);
        List<Integer> list = Arrays.asList(28, 10, 5, 67, 39, 70, 28);
        LinkedListNode head = linkedList;
        for (Integer l : list) {
            linkedList.next = new LinkedListNode(l);
            linkedList = linkedList.next;
        }
        // System.out.println("HEAD " + head.data);
        LinkedListNode resultHead = RemoveNthNode.removeNthLastNode(head, 2);
        while (resultHead != null) {
            System.out.println(resultHead.data);
            resultHead = resultHead.next;
        }
        System.out.println(resultHead);

    }
}
