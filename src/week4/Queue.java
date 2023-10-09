package week4;

import java.util.LinkedList;

public class Queue {

    private final int[] queue;
    private int head = 0;       // 빈 공간을 가리킨다.
    private int tail = 0;       // 값을 가리킨다.

    public Queue(int queueSize) {
        this.queue = new int[queueSize + 1];        // 한 칸이 더 필요하다. (빈 공간 1개 필요)
    }

    public void offer(int data) {
        if ((head + 1) % queue.length == tail) {
            throw new IllegalArgumentException("큐 오버플로우");
        }

        queue[head] = data;
        head = (head + 1) % queue.length;
    }

    public int poll() {
        if (tail == head) {
            throw new IllegalArgumentException("큐 언더플로우");
        }

        int pollValue = queue[tail];
        tail = (tail + 1) % queue.length;

        return pollValue;
    }
}
