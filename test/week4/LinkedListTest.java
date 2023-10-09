package week4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import week4.LinkedList;
import week4.ListNode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LinkedListTest {

    @DisplayName("첫 번째 인덱스에 노드를 추가한다.")
    @Test
    void addNodeToFirst() {
        // given
        ListNode head = new ListNode();
        LinkedList linkedList = new LinkedList();
        ListNode nodeToAdd = new ListNode(1);

        // when
        linkedList.add(head, nodeToAdd, 0);

        // then
        assertThat(head.next).isEqualTo(nodeToAdd);
    }

    @DisplayName("중간에 노드를 추가한다.")
    @Test
    void addNodeBetween() {
        // given
        ListNode head = new ListNode();
        head.next = new ListNode(1, new ListNode(2, new ListNode(3)));
        LinkedList linkedList = new LinkedList();
        ListNode nodeToAdd = new ListNode(100);

        // when
        linkedList.add(head, nodeToAdd, 2);

        // then
        assertThat(head.next.next.next).isEqualTo(nodeToAdd);
    }

    @DisplayName("개수를 초과하는 인덱스를 지정한 경우, 맨 뒤에 노드를 추가한다.")
    @Test
    void addNodeIndexOver() {
        // given
        ListNode head = new ListNode();
        head.next = new ListNode(1, new ListNode(2, new ListNode(3)));
        LinkedList linkedList = new LinkedList();
        ListNode nodeToAdd = new ListNode(100);

        // when
        linkedList.add(head, nodeToAdd, 100);

        // then
        assertThat(head.next.next.next.next).isEqualTo(nodeToAdd);
    }

    @DisplayName("첫 번째 노드를 제거한다.")
    @Test
    void removeFirstNode() {
        // given
        ListNode head = new ListNode();
        head.next = new ListNode(1, new ListNode(2, new ListNode(3)));
        LinkedList linkedList = new LinkedList();

        // when
        ListNode removedNode = linkedList.remove(head, 0);

        // then
        assertThat(removedNode.value).isEqualTo(1);
        assertThat(head.next.value).isEqualTo(2);
    }

    @DisplayName("마지막 노드를 제거한다.")
    @Test
    void removeEndNode() {
        // given
        ListNode head = new ListNode();
        head.next = new ListNode(1, new ListNode(2, new ListNode(3)));
        LinkedList linkedList = new LinkedList();

        // when
        ListNode removedNode = linkedList.remove(head, 2);

        // then
        assertThat(removedNode.value).isEqualTo(3);
        assertThat(head.next.next.next).isNull();
    }

    @DisplayName("중간 노드를 제거한다.")
    @Test
    void removeMiddleNode() {
        // given
        ListNode head = new ListNode();
        head.next = new ListNode(1, new ListNode(2, new ListNode(3)));
        LinkedList linkedList = new LinkedList();

        // when
        ListNode removedNode = linkedList.remove(head, 1);

        // then
        assertThat(removedNode.value).isEqualTo(2);
        assertThat(head.next.value).isEqualTo(1);
        assertThat(head.next.next.value).isEqualTo(3);
    }

    @DisplayName("전체 길이를 초과하는 인덱스의 노드 삭제 시 예외 발생")
    @Test
    void removeNodeIndexOver() {
        // given
        ListNode head = new ListNode();
        head.next = new ListNode(1, new ListNode(2, new ListNode(3)));
        LinkedList linkedList = new LinkedList();

        // when // then
        assertThatThrownBy(() -> linkedList.remove(head, 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 인덱스엔 노드가 존재하지 않습니다.");
    }

    @DisplayName("해당 노드가 존재하는지 검사")
    @Test
    void containsNode() {
        // given
        ListNode head = new ListNode();
        head.next = new ListNode(1, new ListNode(2, new ListNode(3)));
        LinkedList linkedList = new LinkedList();

        ListNode existNode = new ListNode(2);
        ListNode notExistNode = new ListNode(100);

        // when
        boolean result1 = linkedList.contains(head, existNode);
        boolean result2 = linkedList.contains(head, notExistNode);

        // then
        assertThat(result1).isTrue();
        assertThat(result2).isFalse();
    }

}