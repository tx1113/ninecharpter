package week2;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Sorted Array
	 * Find the first index of this number in O(log n) time
	 * if didn't found, return -1
	 */
	public static int binarySearch(int[] nums, int target) {
		if(nums == null || nums.length == 0)
			return -1;
		int start = 0, end = nums.length - 1;
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if( target == nums[mid]){
				end = mid;
			}else if( target < nums[mid] ){
				end = mid;
			}else {
				start = mid;
			}
		}
		if(nums[start] == target)
			return start;
		if(nums[end] == target)
			return end;
		return -1;
	}

}
