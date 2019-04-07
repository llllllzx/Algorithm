package ZCY._01Chapter_StackAndQueue;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。
 * Created by zhaoxinliu on 2019/3/30
 */
public class _02ImplementQueueUsingStacks {
    public static void main(String[] args) {
        TwoStacksQueue twoStacksQueue = new TwoStacksQueue();
        twoStacksQueue.add(1);
        twoStacksQueue.add(2);
        twoStacksQueue.add(3);
        twoStacksQueue.add(4);
        twoStacksQueue.add(5);
        int a = twoStacksQueue.poll();
        int b = twoStacksQueue.poll();
        twoStacksQueue.add(10);
        System.out.println(a + "==>" + b);

    }
}
class TwoStacksQueue{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public TwoStacksQueue(){
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void add(int newNum){
        this.stack1.add(newNum);
    }

    public int poll(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }else if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    public int peek(){
        if(stack1.isEmpty() && stack2.isEmpty()){
            throw new RuntimeException();
        }else if(stack2.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }
}
