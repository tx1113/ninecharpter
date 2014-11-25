package week2;

import java.lang.annotation.Target;
import java.util.ArrayList;


public class SearchForARange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
	/** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     *Time: O(log n) 
     */
    public static ArrayList<Integer> searchRange(ArrayList<Integer> A, int target) {
        // write your code here
    	//binary search for the target
    	ArrayList<Integer> range = new ArrayList<Integer>();
    	int start = 0, end = A.size() - 1;
    	int targetIndex = -1, targetStart = -1, targetEnd = -1;
    	while(start <= end){
    		int mid = (start + end) / 2;
    		if(target == A.get(mid)){
    			//found the target
    			targetIndex = mid; 
    			break;
    		}else if(target < A.get(mid)){
    			//the target should in the left side
    			end = mid - 1;
    		}else{
    			//target > A.get(mid)
    			//target should in the right side
    			start = mid + 1;
    		}
    	}
    	
    	//find the range
    	if(targetIndex != -1){
    		//get the start and end of target
    		targetStart = targetIndex;
    		//!!! here, we need to make sure targetStart in bound
    		while(targetStart >=0 && targetStart <A.size() &&A.get(targetStart) == target){
    			targetStart --;
    		}
    		targetStart ++;
    		targetEnd = targetIndex;
    		//!!! Also, make sure the targetEnd in bound
    		while(targetEnd >=0 && targetEnd < A.size() && A.get(targetEnd) == target){
    			targetEnd ++;
    		}
    		targetEnd--;
    	}
    	range.add(targetStart);
    	range.add(targetEnd);
    	return range;
    }
    
    public static void test(){
    	ArrayList<Integer> A = new ArrayList<Integer>();
    	A.add(1);
    	ArrayList<Integer> range = searchRange(A, 1);
    	System.out.println(range);
    }
    
    
    //a more general way
    // binary search twice
    public static ArrayList<Integer> searchRangeM(ArrayList<Integer> A, int target){
    	
    	ArrayList<Integer> bound = new ArrayList<Integer>();
    	int start = 0, end = A.size() - 1;
    	//first binary search, find left bound
    	while( start + 1 < end){
    		int mid = start + (end - start) / 2;
    		if (target == A.get(mid)) {
    			end = mid;
    		}else if (target < A.get(mid)) {
    			end = mid;
    		}else {
    			start = mid;
    		}
    	}
    	if (A.get(start) == target) {
    		bound.add(start);
    	} else if (A.get(end) == target) {
    		bound.add(end);
    	}else {
			bound.add(-1);
			bound.add(-1);
			return bound;
		}
    	
    	start = 0;
    	end = A.size() - 1;
    	while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			if (A.get(mid) == target) {
				start = mid;
			} else if (target < A.get(mid)) {
				end = mid;
			} else {
				start = mid;
			}
		}
    	if (A.get(end) == target) {
			bound.add(end);
		} else if (A.get(start) == target){
			bound.add(start);
		} else {
			bound.add(-1);
			bound.add(-1);
			return bound;
		}
    	return bound;
    }
	

}
