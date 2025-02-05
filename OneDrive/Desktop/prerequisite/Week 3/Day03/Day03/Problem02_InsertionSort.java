import java.util.Arrays;

public class Problem02_InsertionSort {
    public static void main(String[] args) {
        int []employeeId ={5,2,1,3,7,4,9,20};

        for (int i=1;i<employeeId.length;i++){
               int curr = employeeId[i] ;
               int prev= i-1;

                while(prev >=0 && employeeId[prev] > curr){
                    employeeId[prev+1]= employeeId[prev];
                    prev--;
                }
                employeeId[prev+1]=curr;
        }
        System.out.println(Arrays.toString(employeeId));
    }
}