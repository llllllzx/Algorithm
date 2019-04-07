package ZCY._01Chapter_StackAndQueue;

import java.util.Stack;

/**
 * 为什么选择使用两个栈？
 *
 * Created by zhaoxinliu on 2019/3/30
 *
 * 1.设计两个栈结构，第一个为stackData,第二个为stackMin。
 * 假设当前数据为newNum,先将其压入stackData.然后判断stackMin是否为空：
 * 2.如果为空，则newNum也压入stackMin
 * 3.如果不为空，则比较newNum和stackMin的栈顶元素中哪一个更小
 * 4.如果newNum更小或者两者相等的话，则newNum也压入stackMin中。
 * 5.如果stackMin中栈顶元素小，则stackMin不压入任何内容。
 */
public class _01StackCanGetMin {
    public static void main(String[] args) {
        Mystack1 mystack1 = new Mystack1();
        mystack1.push(23);
        mystack1.push(12);
        int min = mystack1.getMin();
        System.out.println(min);
    }
}

class Mystack1{
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;
    public Mystack1(){
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }
    public void push(int newNum){
        if(stackMin.isEmpty()){
            stackMin.push(newNum);
        }else if(newNum <= stackMin.peek()){
            stackMin.push(newNum);
        }

        stackData.push(newNum);
    }
    public int pop(){
        if(stackData.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        int value = this.stackData.pop();
        if(value == this.stackMin.peek()){
            this.stackMin.pop();
        }
        return value;
    }
    public int getMin(){
        if(stackMin.isEmpty()){
            throw new RuntimeException("your stack is empty");
        }
        return this.stackMin.peek();
    }
}