import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by qiqi on 2016/10/6.
 */
public class Stack {
    private Queue<Integer> queue;

    public Stack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        if (queue.size() >= 10) {
            System.out.println("Overflow, could not add new item");
            return;
        }
        queue.add(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() {
        if (queue.isEmpty()) {
            System.out.println("underflow, could not remove items");
            return 0;
        }
        return queue.poll();
    }

    private boolean isEmpty() {
        return queue.size() == 0;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());//Output: 3
        System.out.println(stack.pop());//Output: 2
        System.out.println(stack.pop());//Output: 1
        System.out.println(stack.pop());
        //Output: underflow, could not remove items
        //0
    }
}
