package Leetcode._1_50;

/**
		0　　1　　2　　 4　　5　　6　　7
		
		7　　0　　1　　 2　　4　　5　　6
		
		6　　7　　0　　 1　　2　　4　　5
		
		5　　6　　7　　 0　　1　　2　　4
		
		4　　5　　6　　7　　0　　1　　2
		
		2　　4　　5　　6　　7　　0　　1
		
		1　　2　　4　　5　　6　　7　　0
*
*/
// 只在有序的一半使用二分查找。
// 由此我们可以观察出规律，如果中间的数小于最右边的数，则右半段是有序的，
// 若中间数大于最右边数，则左半段是有序的，
// 我们只要在有序的半段里用首尾两个数组来判断目标值是否在这一区域内，这样就可以确定保留哪半边了

// 根据题意，数组中不含重复元素！！！！！！！！！！！！！！！！！！！！！！！如果有重复元素，则算法失效。例如nums={3,1,1} target =
// 3,则查找不出来。
public class _033_SearchInRotatedSortedArray {
	public static void main(String[] args) {
		// int[] nums = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		// int target = 2;
		int[] nums = { 3, 1, 1 };
		int target = 3;
		int res = search(nums, target);
		System.out.println(res);
	}

	public static int search(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] < nums[right]) {
				if (nums[mid] < target && nums[right] >= target) {
					left = mid + 1;
				} else {
					right = mid - 1;
				}
			} else {
				if (nums[left] <= target && nums[mid] > target) {
					right = mid - 1;
				} else {
					left = mid + 1;
				}
			}
		}
		return -1;
	}
}
