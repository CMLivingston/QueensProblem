/**
*
* Queen.java
*
* Author: Chris Livingston
*
* Description: A java class that solves the classic Queens Problem requiring 
* a solution where no Queen in able to capture another. The user supplies a number N
* to serve as the dimensions of an NxN chessboard. The solutions are printed to standard output. 
* I capped the input number at 20 but this algorithm can scale much higher. 
*
*/

public class Queen {

	/**
	* Helper method to check if a queen is attempting to be placed in an invalid position 
	* 
	*
	*/
	public static boolean isConsistent(int[] q, int n) {
        
        for (int i = 0; i < n; i++) {
            if (q[i] == q[n])             return false;   // same column
            if ((q[i] - q[n]) == (n - i)) return false;   // same major diagonal
            if ((q[n] - q[i]) == (n - i)) return false;   // same minor diagonal
        }
	    
	    return true;
	}

	/**
	* This method prints a queens problem solution 'q' on the console or stdout. 
	*
	*
	*/
    public static void printQueens(int[] q) { 
        int N = q.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (q[i] == j) System.out.print("Q ");
                else           System.out.print("* ");
            }
            System.out.println();
        }  
        System.out.println();
    }
    
    


    /**
    * Initial call to enumerate the input 
    *
    */ 
    public static void enumerate(int N) {
        int[] a = new int[N];
        enumerate(a, 0);
    }

    /**
    * Recursive backtracking function that calls itself as long as it
    * maintains a valid solution in q[] and 'backtracks' if isConsistent() finds that a 
    * proposed queen placement conflicts with an existing queen placement in q[].
    */
    public static void enumerate(int[] q, int n) {
        int N = q.length;
        if (n == N) printQueens(q);
        else {
            for (int i = 0; i < N; i++) {
                q[n] = i;
                if (isConsistent(q, n)) enumerate(q, n+1);
            }
        }
    }  


		

	public static void main(String [] args){
		
		int x = args.length;
		
		// args check
		if (x != 1) {
			System.err.println("Correct Usage: java Queen [N denoting NxN matrix to solve (MAX 20)]");
			System.exit(1);
		} 
			
        int n = Integer.parseInt(args[0]);

        // input size check
        if (n > 20) {
        	System.err.println("Size of board must be less than 20");
        }

        // call inital enumerate function to begin 
        enumerate(n);
    }

}
