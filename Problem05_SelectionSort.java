public class Problem05_SelectionSort {
    public static void main(String[] args) {
        int [] scores = {74,45,36,85,65,92,44};

        for(int i=0;i<scores.length;i++){
            int index = i;
            for(int j=i;j<scores.length;j++){
                if(scores[j]< scores[index]){
                    index=j;
                }
            }
            System.out.println("smallest number is : "+ scores[index]);
            int temp = scores[index];
            scores[index]=scores[i];
            scores[i]=temp;
        }

        //displaying marks
        for(int marks : scores){
            System.out.println(marks);
        }
    }
}
