import java.util.*;

public class Problem1_PairSum {
    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 7, 1, 5};
        int target = 9;
        System.out.println(hasPairWithSum(arr, target)); // true
    }
}
