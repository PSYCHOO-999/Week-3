import java.util.Arrays;

public class Problem07_CountingSort {
    public static void main(String[] args) {

        int []ages ={12,11,18,10,11,15,16,17,16,13};
        //to find max element
        int max=-1; int min=Integer.MAX_VALUE;
        for (int age : ages) {
            if (age > max) {
                max = age;
            }
            if(age < min){
                min = age;
            }
        }
        int [] count= new int[max+1];

        for(int i=0;i<ages.length;i++){
            count[ages[i]]+=1;
        }

        //sorting the array
        int index=0;
        for(int i=min;i<count.length;i++){
            while(count[i]!=0) {
                ages[index] = i;
                count[i]--;
                index++;
            }
        }

        //diplaying the ages in ascending order
        for (int age: ages){
            System.out.print(age+" ");
        }
    }
}
