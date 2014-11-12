package week2;

public class SearchInRotatedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

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
     * param A : an integer ratated sorted array and duplicates are allowed
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
    			start ++;
    		}
    	}
    	return false;
    }
}
