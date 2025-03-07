package problemstatements.fibonaccicomputation;

public class fibonacciRecursiveAndIterative {
    public  int fibonacciRecursive(int n){
        if (n<=1) return n;
        return fibonacciRecursive(n-1) + fibonacciRecursive(n-2);
    }
    public int fibonacciIterative(int n){
        int a =0,b=1,sum;
        for (int i=2;i<=n;i++){
            sum = a +b;
            a=b;
            b=sum;
        }
        return b;
    }
}
