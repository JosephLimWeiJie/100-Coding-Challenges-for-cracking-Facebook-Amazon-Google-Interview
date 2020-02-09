import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TwoSum {
    
    public static class Pair<T, U> {
        private final T firstVal;
        private final U secondVal;
        
        private Pair(T firstVal, U secondVal) {
            this.firstVal = firstVal;
            this.secondVal = secondVal;
        }        

        public static <T, U> Pair<T, U> of(T firstVal, U secondVal) {
            return new Pair<T, U>(firstVal, secondVal);
        }
        
        public T getFirstVal() {
            return this.firstVal;
        }
        
        public U getSecondVal() {
            return this.secondVal;
        }
    } 
    
    public static int[] twoSum(int[] nums, int target) {
       int[] ans = new int[2];
       
       // First value -> nums[i] value
       // Second value -> nums[i] index
       List<Pair<Integer, Integer>> numsList = new ArrayList<>();
       
       for (int i = 0; i < nums.length; i++) {
           numsList.add(Pair.of(nums[i], i));
       }
            
       // Sort by first value
       Collections.sort(numsList, new Comparator<Pair<Integer, Integer>>() {
           @Override
           public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
               if (p1.getFirstVal() <=  p2.getFirstVal()) {
                   return -1;
               }
               return 1;
           }
       });
       
       int frontIndex = 0;
       int backIndex = numsList.size() - 1;
       
       while (frontIndex <= backIndex) {
           
           int total = numsList.get(frontIndex).getFirstVal() + numsList.get(backIndex).getFirstVal();

           if (total == target) {
               ans[0] = numsList.get(frontIndex).getSecondVal();
               ans[1] = numsList.get(backIndex).getSecondVal();
               break;
           }
           
           if (total >= target) {
               backIndex--;
           } else {
               frontIndex++;
           }
       }
       return ans;
    }
    
    // For debugging purposes
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] ansArr = (twoSum(arr, 9));
        System.out.println("" + ansArr[0] + "," + ansArr[1]);
    }
    
    /*
     * Learning points:
     * 
     * Sort method in Collections notes under Javadocs:
     * This implementation is a stable, adaptive, iterative mergesort that requires far 
     * fewer than n lg(n) comparisons when the input array is partially sorted, while 
     * offering the performance of a traditional mergesort when the input array is 
     * randomly ordered. If the input array is nearly sorted, the implementation 
     * requires approximately n comparisons. Temporary storage requirements vary 
     * from a small constant for nearly sorted input arrays to n/2 object references 
     * for randomly ordered input arrays.
     * 
     * The implementation takes equal advantage of ascending and descending order 
     * in its input array, and can take advantage of ascending and descending order 
     * in different parts of the same input array. It is well-suited to merging two 
     * or more sorted arrays: simply concatenate the arrays and sort the resulting array.
     * 
     * The implementation was adapted from Tim Peters's list sort for Python ( TimSort). 
     * It uses techniques from Peter McIlroy's "Optimistic Sorting and Information 
     * Theoretic Complexity", in Proceedings of the Fourth Annual ACM-SIAM Symposium 
     * on Discrete Algorithms, pp 467-474, January 1993.
     */
}
