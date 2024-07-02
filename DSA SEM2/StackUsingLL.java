
class Stack
{
    class Node
{
    int data;       
    Node next;      
}
 
    Node top=null;
 
    Stack() {
        this.top = null;
    }
 
    public void push(int x){
        Node node = new Node();  

        System.out.println("Inserting " + x);
        node.data = x;
        node.next = top;
        top = node;
    }
    public boolean isEmpty() {
        return top == null;
    }
 
    public int peek()
    {
        if (!isEmpty()) {
            return top.data;
        }
        else {
            System.out.println("The stack is empty");
            return -1;
        }
    }

    public void pop()        
    {
        if (top == null)
        {
            System.out.print("\nStack Underflow");
            return;
        } 
        System.out.println("Removing " + peek());
        top = (top).next;
    }
}
 
class StackUsingLL
{
    public static void main(String[] args)
    {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3); 
        System.out.println("The top element is " + stack.peek()); 
        stack.pop();
        stack.pop();
        stack.pop();
 
        if (stack.isEmpty()) {
            System.out.print("The stack is empty");
        }
        else {
            System.out.print("The stack is not empty");
        }
    }
}