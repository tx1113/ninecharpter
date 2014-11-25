package week2;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test2();
	
	}
	
	 /** 
     *@param A : an integer rotated sorted array
     *@param target :  an integer to be searched
     *return : an integer
     *Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     *(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     *You are given a target value to search. 
     *If found in the array return its index, otherwise return -1.
     *You may assume no duplicate exists in the array.
     *Example
     *For [4, 5, 1, 2, 3] and target=1, return 2
     *For [4, 5,1, 2, 3] and target=0, return -1
     */
	
	/*
	 * Idea:
	 * if rotated, the A[start] > A[end]
	 * get the mid = (start + end)/2
	 * if A[start] > A[mid]  the left side is rotated
	 */
    public static int search(int[] A, int target) {
        // write your code here
    	int start = 0, end = A.length - 1;
    	while(start <=end){
    		int mid = (start + end)/2;
    		if(A[mid] == target){
    			return mid;
    		}
    		
    		if(A[start] <= A[mid]){
    			//left side is sorted
    			if(A[start] <= target && target < A[mid]){
    				//target in the left side
    				end = mid;
    			}else{
    				//target in the right side
    				start = mid + 1;
    			}
    		}else{
    			//the right side is sorted, since there is no duplicate
    			if(A[mid] < target && target <= A[end]){
    				//in the right side
    				start = mid + 1;
    			}else{
    				end = mid;
    			}
    		}
    	}
    	return -1;
    }
    
    
    //follow up
    /** 
     * param A : an integer rotated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     * 
     * Follow up for "Search in Rotated Sorted Array":
     * What if duplicates are allowed?
     * Would this affect the run-time complexity? How and why?
     * Write a function to determine if a given target is in the array.
     */
    public static boolean searchDup(int[] A, int target) {
        // write your code here
    	int start = 0, end = A.length - 1;
    	while(start <= end){
    		int mid = (start + end)/2;
    		if(A[mid] == target)
    			return true;
    		if(A[start] < A[mid]){
    			//the left side is sorted
    			if(A[start] <= target && target < A[mid]){
    				//target in the left side
    				end = mid;
    			}else{
    				start = mid + 1;
    			}
    		}else if(A[mid] < A[end]){
    			//right side is sorted
    			if(A[mid] < target && target <= A[end]){
    				//in the right side
    				start = mid + 1;
    			}else{
    				end = mid;
    			}
    		}else{
    			if (A[start] == target) {
					return true;
				}
    			start ++;
    		}
    	}
    	return false;
    }
    
    
    // using the binary search template
    public static int search_modify(int[] A, int target) {
    	int start = 0, end = A.length - 1;
    	while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			}
			
			if (A[start] < A[mid]) {
				// A[start..end] is sorted
				if (A[start] <= target && target < A[mid]) {
					//in the sorted part;
					end = mid;
				} else {
					//in the unsorted part
					start = mid;
				}
			} else {
				// A[mid..end] is sorted
				if (A[mid] < target && target <= A[end]) {
					//in the sorted part
					start = mid;
				} else {
					// in the unsorted part
					end = mid;
				}
			}
		}
    	if (A[start] == target) {
			return start;
		}
    	if (A[end] == target) {
			return end;
		}
    	return -1;
    }
    
    public static boolean searchDup_modify(int[] A, int target)  {
    	int start = 0, end = A.length - 1;
    	
    	while (start + 1 < end) {
			int mid = start + (end - start)/2;
			if (A[mid] == target) {
				return true;
			}
			
			if (A[start] < A[mid]) {
				//A[start..mid] is sorted
				if (A[start] <= target && target < A[mid]) {
					//in the sorted part
					end = mid;
				} else {
					// in the unsorted part, right part
					start = mid;
				}
			} else if (A[mid] < A[end]) {
				//A[mid..end] is sorted
				if (A[mid] < target && target <= A[end]) {
					//in the right part, also sorted part
					start = mid;
				} else {
					end = mid;
				}
			} else {
				if (A[start] == target) {
					return true;
				} 
				// !!!here, we must add the A[start] == target, since we haven't see this case
				// before start ++, we need to check whether A[start] == target
				// e.g {3,1,1} 3. In the above code, start = 0, end = 2, mid = 1
				//  		      A[start] < A[mid] false && A[mid] < A[end] false.
				// 				  directly go here. if we didn't check, it would directly increase
				// 				  and miss the A[start]
				start ++;
			}
		}
    	if (A[start] == target || A[end] == target) {
			return true;
		}
    	return false;
    }
    
    public static void test2() {
    	int[] A = {3,1,1}; 
		boolean exist = searchDup_modify(A, 3);
		System.out.println(exist);
	}
    
   
    
    
}
