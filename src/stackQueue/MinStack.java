package stackQueue;

import java.util.Stack;

class MinStack {
    int min = Integer.MAX_VALUE;
    Stack<Integer> minStack = new Stack<Integer>();  // holding mins
    Stack<Integer> s2 = new Stack<Integer>();   // original stack
    public void push(int x) {
        // only push the old minimum value when the current 
        // minimum value changes after pushing the new value x
        if(x <= min){          
            minStack.push(min);
            min=x;
        }
        s2.push(x);
    }

    public int pop() {
        // if pop operation could result in the changing of the current minimum value, 
        // pop twice and change the current minimum value to the last minimum value.
        int val = s2.pop();
        if(val == min) {
        		minStack.pop();
        }
        return val;
    }

    public int getMin() {
        return minStack.peek();
    }
}