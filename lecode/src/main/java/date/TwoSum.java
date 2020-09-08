package date;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mazhenxing
 */
public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i<nums.length; i++){
            int first = nums[i];
            int sec = getI(nums, target - first);
            if(sec != -1 && sec < i){
                return new int[]{i, sec};
            }
        }
        return null;
    }

    public static int[] twoSumMap(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i<nums.length; i++){
            int first = nums[i];
            int sec = target - first;
            if(map.containsKey(sec)){
                return new int[]{i, map.get(sec)};
            }
            map.put(nums[i], i);
        }
        return null;
    }

    private static int getI(int[] nums, int result){
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == result){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3, 2, 4}, 6);
    }
}
