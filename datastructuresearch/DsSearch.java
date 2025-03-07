package problemstatements.datastructuresearch;
import java.util.*;
public class DsSearch {
    public static int arraySearch(int arr[], int target) {
        for (int i = 0; i <= arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void comparison(int sizes) {
        Random random = new Random();
        int[] array = new int[sizes];
        HashSet<Integer> hashSet = new HashSet<>();
        TreeSet<Integer> treeSet = new TreeSet<>();

        //Fill data Structures
        for (int i = 0; i < sizes; i++) {
            int num = random.nextInt(sizes * 10);
            array[i] = num;
            hashSet.add(num);
            treeSet.add(num);
        }
            int target = array[sizes/2]; //Pick the Middle Element

            //Measure Array Search (O(N))
            long start1 = System.nanoTime();
            arraySearch(array,target);
            long arrayTime = System.nanoTime() -start1;

            //Measure HashSet Search (O(1))
            long start2 = System.nanoTime();
            hashSet.contains(target);
            long hashSetTime = System.nanoTime() - start2;

            //Measure TreeSet Search (O(log N))
            long start3 = System.nanoTime();
            treeSet.contains(target);
            long treeSetTime = System.nanoTime() - start3;

            System.out.printf("Dataset Size: %,d | Array Search: %,dns | HashSet Search: %,dns | TreeSet Search: %,dns\n",
                    sizes, arrayTime, hashSetTime, treeSetTime);
        }

    public static void main(String[] args) {
        int [] datasize = {1000,100000,1000000};
        for (int sizes : datasize){
            comparison(sizes);
        }
    }
    }


