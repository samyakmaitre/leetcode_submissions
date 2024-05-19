class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    // Constructor
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    // Push element x onto stack
    public void push(int x) {
        // Enqueue x to q2
        q2.add(x);
        
        // Transfer all elements from q1 to q2
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        
        // Swap the queues
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }
    
    // Removes the element on top of the stack and returns that element
    public int pop() {
        if (!q1.isEmpty()) {
            return q1.remove();
        }
        return -1; // Return -1 or throw exception if stack is empty
    }
    
    // Get the top element
    public int top() {
        if (!q1.isEmpty()) {
            return q1.peek();
        }
        return -1; // Return -1 or throw exception if stack is empty
    }
    
    // Returns whether the stack is empty
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */