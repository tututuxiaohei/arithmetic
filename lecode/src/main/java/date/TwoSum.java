package date;

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
