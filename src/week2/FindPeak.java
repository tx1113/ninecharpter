package week2;

public class FindPeak {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
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
    
	

}
