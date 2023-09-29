public class Stack {

    private final int[] stack;
    private int top = -1;

    public Stack(int stackSize) {
        this.stack = new int[stackSize];
    }

    public void push(int data) {
        if (top + 1 >= stack.length) {
            throw new IllegalArgumentException("스택 오버플로우");
        }

        stack[++top] = data;
    }

    public int pop() {
        if (top <= -1) {
            throw new IllegalArgumentException("스택 언더플로우");
        }

        return stack[top--];
    }
}
