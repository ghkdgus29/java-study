package week5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BinaryTreeTest {

    @DisplayName("이진 트리를 입력으로 넣어주면 bfs 방문 순서 리스트를 반환한다.")
    @Test
    void bfs() {
        // given
        BinaryTree binaryTree = new BinaryTree();

        Node root = new Node(1,
                            new Node(2,
                                        new Node(4),
                                        new Node(5,
                                                new Node(8),
                                                new Node(9))),
                            new Node(3,
                                        new Node(6),
                                        new Node(7)));
        // when
        List<Integer> visitOrder = binaryTree.bfs(root);

        // then
        assertThat(visitOrder).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @DisplayName("이진 트리를 입력으로 넣어주면 dfs 방문 순서 리스트를 반환한다.")
    @Test
    void dfs() {
        // given
        BinaryTree binaryTree = new BinaryTree();

        Node root = new Node(1,
                new Node(2,
                        new Node(4),
                        new Node(5,
                                new Node(8),
                                new Node(9))),
                new Node(3,
                        new Node(6),
                        new Node(7)));

        // when
        List<Integer> visitOrder = binaryTree.dfs(root);

        // then
        assertThat(visitOrder).containsExactly(4, 2, 8, 5, 9, 1, 6, 3, 7);
    }
}