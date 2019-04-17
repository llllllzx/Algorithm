package Leetcode._1_50;

public class _035_SearchInsertPosition {
	public static void main(String[] args) {
		int [] arr = new int[] {1,3,5,6};
		int  t = 5;
		int res = searchInsert(arr, t);
		System.out.println(res);
	}
	public static int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }
           int l = 0;
           int r = nums.length-1;
           while(l<=r){
               int mid = (l+r)/2;
               if(nums[mid] == target){
                   return mid;
               }
               if(nums[mid] > target){
                   r = mid - 1;
               }else{
                   l = mid + 1;
               }
           }
           return l;
    }
}
