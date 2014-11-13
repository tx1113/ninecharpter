package week2;
import java.util.*;
public class Search2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		test2();
		test3();
	}
	
	 /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     * 
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * This matrix has the following properties:
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * Example
     * Consider the following matrix:
     * [
     *  [1,  3,  5,  7],
     *  [10, 11, 16, 20],
     *  [23, 30, 34, 50]
     *  ]
     *  Given target = 3, return true.
     */
    public static boolean searchMatrix(ArrayList<ArrayList<Integer>> matrix, int target) {
        // write your code
    	if(matrix == null || matrix.size() == 0)
    		return false;
    	
    	int rowL = matrix.size();
    	int colL = matrix.get(0).size();
    	int start = 0, end = rowL*colL;
    	while(start <= end){  
    		int mid = (start + end)/2;
    		
    		int rowIndex = mid/colL;
    		int colIndex = mid%colL;
    		
    		int val = Integer.MAX_VALUE;
    		
    		//!!!here we need to pay much attention. 
    		// the rowIndex or colIndex might out of bound if the target is larger than the 
    		// largest element in the matrix
    		// so here, make sure rowIndex and colIndex are in bound
    		if(rowIndex >=0 && rowIndex < rowL && colIndex >=0 && colIndex < colL){
    			val = matrix.get(rowIndex).get(colIndex);
    		}
    		if(target == val)
    			return true;
    		else if(target < val){
    			//
    			end = mid-1 ;
    		}else{
    			start = mid+1 ;
    		}
    	}
    	return false;
    }
   
    
    public static void test2(){
    	int[][] arr = 
    	{
    		{1,5,8,12,13,15,18,20,25,26,28,33,38,40,43,49,52,53,59},
    		{84,100,110,129,141,156,177,198,220,242,254,266,284,297,316,326,343,358,373},
    		{388,398,419,439,449,460,472,495,516,539,560,582,600,610,624,643,668,691,710},
    		{720,733,751,765,787,804,814,832,856,880,905,930,950,974,999,1012,1022,1039,1061},
    		{1081,1091,1102,1126,1151,1175,1194,1219,1239,1253,1263,1274,1287,1298,1308,1318,1337,1361,1382},
    		{1404,1417,1437,1452,1466,1487,1503,1518,1537,1555,1578,1590,1601,1613,1636,1659,1669,1688,1712}
    	};
    	ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
    	for(int i = 0; i<arr.length; i++){
    		ArrayList<Integer> row = new ArrayList<Integer>();
    		for(int j= 0; j<arr[i].length; j++){
    			row.add(arr[i][j]);
    		}
    		matrix.add(row);
    	}
//    	System.out.println(matrix);
    	for(ArrayList<Integer> line: matrix){
    		System.out.println(line);
    	}
    	System.out.println();
    	int target = 2000;
    	boolean rev = searchMatrix(matrix, target);
    	System.out.println(rev);
    }
    
    
    /*
     * Write an efficient algorithm that searches for a value in an m x n matrix, 
     * return the occurrence of it.
     * This matrix has the following properties:
     * Integers in each row are sorted from left to right.
     * Integers in each column are sorted from up to bottom.
     * No duplicate integers in each row or column.
     * Example
     * Consider the following matrix:
     * [
     * [1, 3, 5, 7],
     * [2, 4, 7, 8],
     * [3, 5, 9, 10]
     * ]
     * Given target = 3, return 2.
     */
    
    
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public static int searchMatrix2(ArrayList<ArrayList<Integer>> matrix, int target) {
        // write your code
    	if(matrix == null || matrix.size() == 0)
    		return 0;
    	int rowL = matrix.size();
    	int colL = matrix.get(0).size();
    	int row = 0, col = colL - 1;
    	int count = 0;
    	while(row >=0 && row < rowL && col >=0 && col < colL){
    		if(matrix.get(row).get(col) == target){
    			count ++;
    			col --;
    		}else if(matrix.get(row).get(col) > target){
    			//go left
    			col --;
    		}else{
    			//matrix[row][col] < target
    			//go down
    			row++;
    		}
    	}
    	return count;
    }
    
    public static void test3(){
    	int[][] input = {
    			{1, 3, 5, 7},
    		    {2, 4, 7, 8},
    		    {3, 5, 9, 10}
    	};
    	int target = 3;
    	ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();
    	for(int i=0; i<input.length; i++){
    		ArrayList<Integer> line = new ArrayList<Integer>();
    		for(int j = 0; j<input[i].length; j++){
    			line.add(input[i][j]);
    		}
    		matrix.add(line);
    	}
    	int rev = searchMatrix2(matrix, target);
    	System.out.println("rev = " + rev);
    }
    
    
    
    
    
}
