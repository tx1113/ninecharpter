package week2;

public class FindPeak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test();
		test2();
	}
	
    /*
     * There is an integer array which has the following features:
     * The numbers in adjacent positions are different.
     * A[0] < A[1] && A[A.length - 2] > A[A.length - 1].
     * We define a position P is a peek if A[P] > A[P-1] && A[P] > A[P+1].
     * Find a peak in this array. Return the index of the peak.
     * Note
     * The array may contains multiple peeks, find any of them.
     * Example
     * [1, 2, 1, 3, 4, 5, 7, 6]
     * return index 1 (which is number 2)  or 6 (which is number 7)
     * 
     * O(log n)
     */
	
	 /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
	public static int findPeak(int[] A) {
        // write your code here
		int len = A.length;
		if(A.length < 3){
			return -1;
		}
		if(A[2] < A[1]){
			return 1;
		}
		if(A[len - 3] < A[len -2]){
			return len - 2;
		}
		//the none of the above cases are OK
		int start = 1, end = len - 2;
		while(start < end){
			int mid = start + (end - start)/2;
			if(A[mid - 1] < A[mid] && A[mid] > A[mid+1])
				return mid;
			if(A[mid] < A[mid - 1]){
				//there must a peak in the left side
				end = mid;
				continue; 
				//!!!without this continue, the following code might execute.
				// leading wrong answer. 
			}
			if(A[mid] < A[mid + 1]){
				//there must a peak in the right side
				start = mid;
			}
		}
		return -1;
    }
	
	public static void test(){
		int[] A = {100,102,104,7,9,11,4,3};
		int rev = findPeak(A);
		System.out.println("rev = " + rev);
	}
	
	//http://www.geeksforgeeks.org/find-a-peak-in-a-given-array/
	//follow up geeksforgeeks
	/*
	 * Given an array of integers. Find a peak element in it. 
	 * An array element is peak if it is NOT smaller than its neighbors. 
	 * For corner elements, we need to consider only one neighbor. 
	 * For example, for input array {5, 10, 20, 15}, 20 is the only peak element. 
	 * For input array {10, 20, 15, 2, 23, 90, 67}, there are two peak elements: 20 and 90. 
	 * Note that we need to return any one peak element.
	 * Following corner cases give better idea about the problem.
	 * 1) If input array is sorted in strictly increasing order, 
	 * the last element is always a peak element. 
	 * For example, 50 is peak element in {10, 20, 30, 40, 50}.
	 * 2) If input array is sorted in strictly decreasing order, 
	 * the first element is always a peak element. 
	 * 100 is the peak element in {100, 80, 60, 50, 20}.
	 * 3) If all elements of input array are same, every element is a peak element.
	 * It is clear from above examples 
	 * that there is always a peak element in input array in any input array.
	 */
	
	/*
	 * Idea:
	 * We can use Divide and Conquer to find a peak in O(Logn) time. 
	 * The idea is Binary Search based, we compare middle element with its neighbors. 
	 * If middle element is greater than both of its neighbors, then we return it. 
	 * If the middle element is smaller than the its left neighbor, 
	 * 	then there is always a peak in left half (Why? take few examples). 
	 * If the middle element is smaller than the its right neighbor, 
	 * 	then there is always a peak in right half (due to same reason as left half). 
	 */
	
	//in this code, return the element rather than the index
	//recursion version
	public static int findPeakHelper(int[] A, int start, int end){
		if (start > end) {
			return 0;
		}
		int len = A.length;
		int mid = start + (end - start)/2;
		System.out.println("start = " + start);
		System.out.println("end = " + end);
		System.out.println("mid = " + mid);
		if((mid == 0 || A[mid] > A[mid - 1])
				&& (mid ==len - 1 || A[mid] > A[mid + 1])){
			return mid;
		}else if( mid > 0 && A[mid] < A[mid - 1]){
			//there must exist a peak in the left side
			return findPeakHelper(A, start, mid - 1);
		}else
			return findPeakHelper(A, mid + 1, end);
	}
	
	public static int findPeak2(int[] A){
		return findPeakHelper(A, 0, A.length - 1);
	}
	
	public static void test2() {
		int[] A = {1,1,1,1,1,1,1};
		System.out.println(findPeak2(A));
		System.out.println("hello world");
	}	
	
    
	

}
