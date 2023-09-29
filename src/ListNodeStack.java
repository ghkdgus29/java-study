public class ListNodeStack {

    private final ListNode head = new ListNode();
    private ListNode top = head;

    public void push(int data) {
        top.next = new ListNode(data);
        top = top.next;
    }

    public int pop() {
        if (top == head) {
            throw new IllegalArgumentException("스택 언더플로우");
        }

        int popValue = top.value;

        ListNode current = head;
        while (current.next != top) {
            current = current.next;
        }
        current.next = null;
        top = current;

        return popValue;
    }
}
