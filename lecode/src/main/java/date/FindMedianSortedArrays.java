package date;

public class FindMedianSortedArrays {

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        findMedianSortedArrays.findMedianSortedArrays(new int[]{1,3}, new int[]{2,7});
    }



    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int total = length1 + length2;

        if(total % 2 == 1){
            //奇数 获取需要拿的数的下标
            return getKth(nums1, nums2, total/2 + 1);
        }
        int midIndex1 = total / 2 - 1, midIndex2 = total / 2;
        double median = (getKth(nums1, nums2, midIndex1 + 1) + getKth(nums1, nums2, midIndex2 + 1)) / 2.0;
        System.out.println(median);
        return median;
    }

    private double getKth(int[] nums1, int[] nums2, int k) {
        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        for ( ; ; ){
            if(index1 == length1){
                //删到边界了 补充数组2删除的下标
                return nums2[index2 + k -1];
            }
            if(index2 == length2){
                //删到数组2的边界了
                return nums1[index1 + k -1];
            }

            if(k == 1){
                //最后一次删除 返回较小者
                return Math.min(nums1[index1], nums2[index2]);
            }
            //需要删除的数量
            int i = k / 2;
            //对应数组的下标 这里有可能数组不足 索引新建一个索引
            int newIndex1 = Math.min(index1 + i, length1) - 1, newIndex2 = Math.min(index2 + i, length2) - 1;
            int res1 = nums1[newIndex1], res2 =  nums2[newIndex2];
            if(res1 <= res2){
                //删除数组1的k个元素
                k = k - (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            }
            if(res1 > res2){
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
