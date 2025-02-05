import java.util.Stack;

public class Problem01_QueueUsingStack {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enQueue(int a){
           stack1.push(a);
    }
    public int deQueue(){
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                System.out.println("Queue is empty");
            }

            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        System.out.println(stack2.peek());
        return stack2.pop();
    }

    public int peek(){
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                System.out.println("Queue is empty");
            }
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }


    public static void main(String[] args) {
            Problem01_QueueUsingStack stack = new Problem01_QueueUsingStack();

            stack.enQueue(45);
            stack.enQueue(34);
            stack.enQueue(23);
//            stack.deQueue();
        System.out.println(stack.peek());
//        System.out.println("top element "+stack.peek());
    }

}