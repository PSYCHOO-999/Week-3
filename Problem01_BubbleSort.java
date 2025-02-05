public class Problem01_BubbleSort {
    public static void main(String[] args) {
        int [] marks = {45,63,82,74,65,52,49,32};

        for(int i=0;i<marks.length;i++){
            boolean swap=false;
            for(int j=0;j<marks.length-i-1;j++){
                if(marks[j]>marks[j+1]){
                    int temp=marks[j];
                    marks[j]=marks[j+1];
                    marks[j+1]=temp;
                    swap=true;
                }

            }
            if(!swap){
                break;
            }
        }

        //displaying marks
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
    }
}
