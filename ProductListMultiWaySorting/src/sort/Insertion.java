/** 
 * @author Shivam Taneja, Lab 02
 **/
package sort;
	
public class Insertion {
	
    /** 
     * This class should not be instantiated.
     **/
	private Insertion() { }

	/**
	 * regular insertion sort
	 * @param x - the input array containing products that need to be sorted.
	 */
	public static void sortInsert( Product[] x ) {
		int n = x.length;
		for (int i = 1;  i < n; i++) {
			for (int j = i; j > 0 && less(x[j],x[j-1]);j--) {
				exch(x,j, j-1);
			}
		}
	}
	
	
	/**
	 * insertion sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortComparable ( Comparable[] x, int n ) {
		for (int i = 1;  i < n; i++) {
			for (int j = i; j > 0 && less(x[j],x[j-1]);j--) {
				exch(x,j, j-1);
			}
		}
	}
	
	/**
	 * optimized insertion sort
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortBinary ( Comparable[] x, int n ) {
        for (int i = 1; i < n; i++) {
            Comparable v = x[i];
            int lo = 0, hi = i;
            while (lo < hi) {
                int mid = lo + (hi - lo) / 2; 
                if (less(v, x[mid])) {
                	hi = mid;
                }
                else {
                	lo = mid + 1;
                }
            }
            for (int j = i; j > lo; --j) {
                x[j] = x[j-1];
            }
            x[lo] = v;
        }
	}
	
	/**
	 * Helper Functions
	 */
	
	
	/**
	 * Functions for comparisons 
	 * @param v - first element to be compared
	 * @param w - second element to be compared
	 * @return true/false is 'v' is bigger than 'w'
	 */
	private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
	
	/**
	 * Functions for swaps 
	 * @param a - the input array containing elements that needs swaping.
	 * @param i - First element's index
	 * @param j - Second element's index
	 */
    private static void exch(Comparable[] a, int i, int j){
    	Comparable t = a[i]; a[i] = a[j]; a[j] = t;  
    }
    
	/**
	 * Print array to standard output
	 * @param a - Array that needs to be printed.
	 */
    private static void show(Comparable[] a) {
       for (int i = 0; i < a.length; i++)
           System.out.println(a[i]);
    }
}