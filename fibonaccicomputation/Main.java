package problemstatements.fibonaccicomputation;

public class Main {
    public static void main(String[] args) {
        fibonacciRecursiveAndIterative test = new fibonacciRecursiveAndIterative();
        int inputs [] = {10,30,50};
        for (int n : inputs){
            System.out.println("Fibonacci Number : " + n);

            //Recursive Approach
            long start = System.nanoTime();
            int recursiveResult = test.fibonacciRecursive(n);
            long recursiveTime = System.nanoTime() - start;
            System.out.println("Time Taken by Recursive Approach is :" + recursiveTime/1000000);

            //Iterative Approach
            start = System.nanoTime();
            int iterativeResult = test.fibonacciIterative(n);
            long iterativeTime = System.nanoTime() - start;
            System.out.println("Time Taken by Iterative Approach is :" + iterativeTime );
            System.out.println("------------------------------------");
        }
    }
}
