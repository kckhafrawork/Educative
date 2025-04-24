package ManipulationOfLinkedList;

import java.util.Arrays;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    // Constructor
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class SwappingNodes {
    public static ListNode swapNodes(ListNode head, int k) {
        // Replace this placeholder return statement with your code
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode secondSwap = dummy;
        ListNode firstSwap = dummy;
        ListNode prevFirst = null;
        ListNode prevSecond = null;

        for (int i = 0; i < k; i++) {
            prevFirst = firstSwap;
            firstSwap = firstSwap.next;
        }
        ListNode end = firstSwap;
        while (end != null) {
            end = end.next;
            prevSecond = secondSwap;
            secondSwap = secondSwap.next;
        }
        if (firstSwap == secondSwap) {
            return head;
        }
        if (prevFirst != null) {
            prevFirst.next = secondSwap;
        }
        if (prevSecond != null) {
            prevSecond.next = firstSwap;
        }

        ListNode tempNext = firstSwap.next;
        firstSwap.next = secondSwap.next;
        secondSwap.next = tempNext;

        return dummy.next;
    }

    public static void main(String[] args) {

        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                Arrays.asList(6, 9, 3, 10, 7, 4, 6),
                Arrays.asList(6, 9, 3, 4),
                Arrays.asList(6, 2, 3, 6, 9),
                Arrays.asList(6, 2));
        int[] k = {
                2, 3, 2, 3, 1
        };

        for (int i = 0; i < input.size(); i++) {
            System.out.print(i + 1);
            LinkedList list = new LinkedList(input.get(i));
            System.out.print(".\tOriginal linked list is: ");
            PrintList.display(list.head);
            System.out.println("\tk: " + k[i]);
            System.out.print("\tLinked list with swapped values: ");
            PrintList.display(swapNodes(list.head, k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
