import java.util.Objects;

public class ListNode {

    int value;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return value == listNode.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, next);
    }
}
