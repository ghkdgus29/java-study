package week5;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    List<Integer> bfs(Node root) {
        List<Integer> visitOrder = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            visitOrder.add(currentNode.value);

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }

        return visitOrder;
    }

    List<Integer> dfs(Node node) {
        List<Integer> visitOrder = new ArrayList<>();

        if (node.left != null) {
            visitOrder.addAll(dfs(node.left));
        }

        visitOrder.add(node.value);

        if (node.right != null) {
            visitOrder.addAll(dfs(node.right));
        }

        return visitOrder;
    }
}
