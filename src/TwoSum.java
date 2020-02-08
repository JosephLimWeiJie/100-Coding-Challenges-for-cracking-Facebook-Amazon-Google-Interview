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
       
       for (Pair p : numsList) {
           int first = (int) p.getFirstVal();
           int sec = (int) p.getSecondVal();
           System.out.println(first + ", " + sec);
       }
       
       while (frontIndex <= backIndex) {
           
           int total = numsList.get(frontIndex).getFirstVal() + numsList.get(backIndex).getFirstVal();
           //System.out.println(numsList.get(frontIndex).getFirstVal());
           //System.out.println(numsList.get(frontIndex + 1).getFirstVal());
           System.out.println(total);
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
    
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] ansArr = (twoSum(arr, 9));
        System.out.println("" + ansArr[0] + "," + ansArr[1]);
    }
}
