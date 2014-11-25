package week2;

import java.util.ArrayList;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test();
		test2();
	}
	
	/**
	 * Given a sorted array and a target value, 
	 * return the index if the target is found. 
	 * If not, return the index where it would be if it were inserted in order.
	 * You may assume no duplicates in the array
	 * 
	 * [1,3,5,6], 5 → 2
	 * [1,3,5,6], 2 → 1
	 * [1,3,5,6], 7 → 4
	 * [1,3,5,6], 0 → 0
	 *  
     * param A : an integer sorted array
     * param target :  an integer to be inserted
     * return : an integer
     * 
     * 
     */
	/*
	 *basic idea: binary search
	 *if found, return the index.
	 *if not, 
	 */
    public int searchInsert(ArrayList<Integer> A, int target) {
        // write your code here
    	int targetIndex = -1;
    	int start = 0, end = A.size() - 1;
    	while(start <= end){  
    		//here, the "=" cannot be omitted must be "<="
    		int mid  = (start + end)/2;
    		if(A.get(mid) == target){
    			targetIndex = mid;
    			break;
    		}else if(target < A.get(mid)){
    			//left side
    			end = mid - 1;
    		}else{
    			start = mid + 1; 
    		}
    	}
    	
    	//in this way, if we didn't find, 
    	//the start would stop at the position which the element is next larger than
    	//the target
    	
    	//and after analysis, 
    	//if found, the start < end
    	//if not, start = end + 1
    	
    	if(targetIndex != -1){
    		return targetIndex;
    	}else{
    		return start;
    	}
    }
    
    public static int bst(int[] a, int t){
    	int start = 0, end = a.length - 1;
    	int targetIndex = -1;
    	while(start <= end){
    		int mid = (start + end) /2;
    		if(t == a[mid]){
    			targetIndex = mid;
    			break;
    		}else if( t < a[mid]){
    			end = mid - 1;
    		}else{
    			start = mid + 1;
    		}
    	}
    	System.out.println("targetIndex = " + targetIndex);
    	System.out.println("start = " + start);
    	System.out.println("end = " + end);
    	return -1;
    }
    
    public static void test(){
    	int[] a1 = {1,3,5,6};
    	int rev1 = bst(a1, 5);
    	System.out.println("----------------");
    	int rev2 = bst(a1, 2);
    	System.out.println("----------------");
    	int rev3 = bst(a1, 7);
    	System.out.println("----------------");
    	int rev4 = bst(a1, 0);
    	System.out.println("----------------");
    	int rev5 = bst(a1, 4);
    	
    }
    
    
    //using the binary search insert position
    // find the last number less than the target
    public static int searchInsert_modify(int[] A, int target) {
    	int start = 0, end = A.length - 1;
    	if (target < A[0]) {
			return 0;
		}
    	if (target > A[end]) {
			return end + 1;
		}
    	while (start + 1 < end) {
			int mid = start + (end - start)/2;
			if (A[mid] == target) {
				return mid;
			} else if (target < A[mid]) {
				//in the left side
				end = mid;
			} else {
				start = mid;
			}
		}
//    	System.out.println("start = " + start);
//    	System.out.println("end = " + end);
    	if (A[end] == target) {
			return end;
		}
    	if (A[end] < target) {
			return end + 1;
		}
    	if (A[start] == target) {
			return start;
		}
    	return start + 1;
    }
    
    public static void  test2() {
		int[] A = {1,3,5,5,5,7,9,10};
		int rev1 = searchInsert_modify(A, 6);
		System.out.println("rev1 = " + rev1);
	}
    
    
    

}
