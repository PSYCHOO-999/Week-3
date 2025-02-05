import java.util.*;
public class Problem02_RecursiveSortStack {
    public static void stackPop(Stack<Integer> stack){
        if(stack.isEmpty()){
            return;
        }
        //poping the stack elements recursively
        int top = stack.pop();
        stackPop(stack);

        //now calling insertIntoSortedStack to store elements in sorted order
        insertInSortedStack(stack,top);
    }

    public static void insertInSortedStack(Stack<Integer> stack, int element){
        if(stack.isEmpty() || stack.peek()<element){
            stack.push(element);
            return;
        }
        //poping the top element since greater than element
        int top= stack.pop();

        //calling function recursively to check its correct location
        insertInSortedStack(stack,element);

        //pushing the pop element into the stack
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.add(3);
        stack.add(1);
        stack.add(4);
        stack.add(2);
        stack.add(5);
        System.out.println(stack);
        stackPop(stack);
        System.out.println(stack);
    }
}
