package EducativeIO.ManipulationOfLinkedList;

class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class PrintList {
    public static void printListWithForwardArrow(LinkedListNode head) {
        LinkedListNode temp = head;

        while (temp != null) {
            System.out.print(temp.data); // print node value
            temp = temp.next;
            if (temp != null) {
                System.out.print(" → ");
            } else {
                // if this is the last node, print null at the end
                System.out.print(" → null \n ");
            }

        }

    }
}

class LinkedList<T> {
    public LinkedListNode head;

    // constructor will be used to make a LinkedList type object
    public LinkedList() {
        this.head = null;
    }

    // insertNodeAtHead method will insert a LinkedListNode at head
    // of a linked list.
    public void insertNodeAtHead(LinkedListNode node) {
        if (this.head == null) {
            this.head = node;
        } else {
            node.next = this.head;
            this.head = node;
        }
    }

    // createLinkedList method will create the linked list using the
    // given integer array with the help of InsertAthead method.
    public void createLinkedList(int[] lst) {
        for (int i = lst.length - 1; i >= 0; i--) {
            LinkedListNode newNode = new LinkedListNode(lst[i]);
            insertNodeAtHead(newNode);
        }
    }

}

public class ReverseLinkedList {
    // Extra
    // Simple Reverse
    public static LinkedListNode SimpleReverse(LinkedListNode head) {
        if (head.next == null) {
            return head;
        }
        LinkedListNode prev = head;
        LinkedListNode curr = head.next;
        LinkedListNode nextNode = head.next.next;
        prev.next = null;
        while (nextNode != null) {
            curr.next = prev;
            prev = curr;
            curr = nextNode;
            nextNode = nextNode.next;
        }
        curr.next = prev;
        return curr;
    }

    // Solution
    // Function to reverse the sublist within the linked list
    public static LinkedListNode reverseBetween(LinkedListNode head, int left, int right) {
        // If the list is empty or left position is the same as right, return the
        // original list
        if (head == null || left == right) {
            return head;
        }

        // Create a dummy node to handle edge case when left = 1
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;
        LinkedListNode prev = dummy;

        // Move prev to the node just before the left position
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        System.out.println("prev " + prev.data);

        // Current node is the node at left position
        LinkedListNode curr = prev.next;

        // Reverse the portion of the linked list between left and right positions
        for (int i = 0; i < right - left; i++) {
            LinkedListNode nextNode = curr.next;
            curr.next = nextNode.next;
            nextNode.next = prev.next;
            prev.next = nextNode;

        }

        return dummy.next;

    }

    public static void main(String[] args) {
        int[][] input = {
                { 1, 2, 3, 4, 5, 6, 7 },
                { 6, 9, 3, 10, 7, 4, 6 },
                { 6, 9, 3, 4 },
                { 6, 2, 3, 6, 9 },
                { 6, 2 }
        };
        int[] left = { 1, 3, 2, 1, 1 };
        int[] right = { 5, 6, 4, 3, 2 };
        for (int i = 0; i < input.length; i++) {
            System.out.print(i + 1);
            LinkedList<Integer> list = new LinkedList<Integer>();
            LinkedList<Integer> list2 = new LinkedList<Integer>();
            list.createLinkedList(input[i]);

            System.out.print(".\tOriginal linked list: ");
            PrintList.printListWithForwardArrow(list.head);
            System.out.print("\tLeft: " + left[i] + ", Right: " + right[i] + "\n\n");
            System.out.println("\tReversed linked list: ");
            PrintList.printListWithForwardArrow(reverseBetween(list.head, left[i],
                    right[i]));

            System.out.println();
            System.out.println();
            System.out.println("\tReversed Entire linked list:  ");
            list2.createLinkedList(input[i]);
            PrintList.printListWithForwardArrow(SimpleReverse(list2.head));
            System.out.println("-------------------------------------------------------");

        }
    }
}
