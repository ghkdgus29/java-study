package week4;

public class LinkedList {

    public ListNode add(ListNode head, ListNode nodeToAdd, int position) {
        ListNode currentNode = head;

        while ((position > 0) && (currentNode.next != null)) {
            currentNode = currentNode.next;
            position--;
        }

        nodeToAdd.next = currentNode.next;
        currentNode.next = nodeToAdd;

        return nodeToAdd;
    }

    public ListNode remove(ListNode head, int positionToRemove) {
        ListNode currentNode = head;

        while ((positionToRemove > 0) && (currentNode.next != null)) {
            currentNode = currentNode.next;
            positionToRemove--;
        }

        if (positionToRemove > 0 || head.next == null) {
            throw new IllegalArgumentException("해당 인덱스엔 노드가 존재하지 않습니다.");
        }

        ListNode removeNode = currentNode.next;
        currentNode.next = currentNode.next.next;

        return removeNode;
    }

    public boolean contains(ListNode head, ListNode nodeToCheck) {
        for (ListNode currentNode = head.next; currentNode != null; currentNode = currentNode.next) {
            if (nodeToCheck.equals(currentNode))
                return true;
        }
        return false;
    }
}
