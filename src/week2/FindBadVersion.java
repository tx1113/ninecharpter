package week2;

public class FindBadVersion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	
	
	public static boolean isBadVersion(int k, int[] input){
		if(input[k] == 1){
			return true;
		}else{
			return false;
		}
	}
	
	public static int findFirstBadVersion(int n, int[] input){
		int start = 1, end = n;
		while(start <end){
			int mid = (start + end)/2;
			if(isBadVersion(mid, input) == false){
				//the mid is OK. the left side is OK.
				start = mid + 1;
			}else {
				//the mid is bad. the right side is all Bad
				end = mid;
			}
		}
		System.out.println("start = " + start);
		System.out.println("end = " + end);
		return start;
	}
	public static void test(){
		int[] input = {-1, 0,0,0,0,0,0,1,1,1,1};
		int rev = findFirstBadVersion(input.length - 1, input);
		System.out.println("rev = " + rev);
	}
	
	
	/**
	 * public class VersionControl {
	 *     public static boolean isBadVersion(int k);
	 * }
	 * you can use VersionControl.isBadVersion(k) to judge wether 
	 * the kth code version is bad or not.
	*/
	/*
	 * The following is the code in LintCode. Works OK
	 */
//	class Solution {
//	    /**
//	     * @param n: An integers.
//	     * @return: An integer which is the first bad version.
//	     */
//	    public int findFirstBadVersion(int n) {
//	        // write your code here
//	        int start = 1, end =n;
//	        while(start < end){
//	            int mid = (start + end) /2;
//	            if(VersionControl.isBadVersion(mid)){
//	                //the mid is a bad version, the right side are all bad
//	                end = mid;
//	            }else{
//	                start = mid + 1;
//	            }
//	        }
//	        return start;
//	    }
//	}
}

/**
 * public class VersionControl {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use VersionControl.isBadVersion(k) to judge wether 
 * the kth code version is bad or not.
*/
