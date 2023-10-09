package week4;

public class ListNodeQueue {

    private final ListNode head = new ListNode();

    private ListNode endNode = head;

    public void offer(int data) {
        endNode.next = new ListNode(data);
        endNode = endNode.next;
    }

    public int poll() {
        if (head.next == null) {
            throw new IllegalArgumentException("큐 언더플로우");
        }

        int pollValue = head.next.value;
        head.next = head.next.next;

        return pollValue;
    }
}
