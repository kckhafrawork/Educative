package ManipulationOfLinkedList;

import java.util.Arrays;
import java.util.List;

class LinkedList {
    ListNode head;

    // Default constructor
    public LinkedList() {
        head = null;
    }

    // Constructor to initialize from a list of values
    public LinkedList(List<Integer> values) {
        head = null;
        createLinkedList(values);
    }

    // Function to create a linked list from a list of values
    private void createLinkedList(List<Integer> values) {
        if (values.isEmpty()) {
            head = null;
            return;
        }

        head = new ListNode(values.get(0));
        ListNode current = head;
        for (int i = 1; i < values.size(); i++) {
            current.next = new ListNode(values.get(i));
            current = current.next;
        }
    }

}

class PrintList {
    // Function to display the linked list
    public static void display(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("None");
    }
}

class ListNode {
    int val;
    ListNode next;

    // Constructor
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

// Solution
public class Reorder {
    public static ListNode reorderList(ListNode head) {

        // Replace this placeholder return statement with your code
        ListNode current = head;
        ListNode slow = current;
        ListNode fast = current;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = null;
        ListNode curr = slow;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode first = head;
        ListNode second = prev;
        ListNode temp = head;

        while (second.next != null) {
            temp = temp.next;
            first.next = second;
            second = second.next;
            first.next.next = temp;
            first = first.next.next;
        }

        return head;
    }

    public static void main(String[] args) {
        List<List<Integer>> inputLists = Arrays.asList(
                Arrays.asList(1, 1, 2, 2, 3, -1, 10, 12),
                Arrays.asList(10, 20, -22, 21, -12),
                Arrays.asList(1, 1, 1),
                Arrays.asList(-2, -5, -6, 0, -1, -4),
                Arrays.asList(3, 1, 5, 7, -4, -2, -1, -6));

        for (int i = 0; i < inputLists.size(); i++) {
            LinkedList obj = new LinkedList(inputLists.get(i));

            System.out.print((i + 1) + ".\tOriginal list: ");
            PrintList.display(obj.head);

            reorderList(obj.head);

            System.out.print("\tAfter folding: ");
            PrintList.display(obj.head);

            System.out.println("--------------------------------------------------------------------------");
        }
    }
}
