/** 
 * @author Shivam Taneja, Lab 02
 **/
package sort;

public class Heap {
	
    /** 
     * This class should not be instantiated.
     **/
	private Heap() { }

	/**
	 * heap sort using Comparable
	 * @param x - the input array containing jobs that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortHeap ( Comparable[] x, int n ) {
	    for (int k = n/2; k >= 1; k--) {
	        sink(x, k, n);
	    }
	    while (n > 1) {
	        exch(x, 1, n--);
	        sink(x, 1, n);
	    }
	}
	
	
	/**
	 * Helper Functions
	 */
	
	/**
	 * Function to restore heap 
	 * @param pq - the input array containing elements that needs to be restored.
	 * @param k - Starting index in the pq
	 * @param n - Ending index in the pq
	 */
	private static void sink(Comparable[] pq, int k, int n) {
	    while (2*k <= n) {
	        int j = 2*k;
	        if (j < n && less(pq, j, j+1)) {
	        	j++;
	        }
	        if (!less(pq, k, j)) {
	        	break;
	        }
	        exch(pq, k, j);
	        k = j;
	    }
	}
	
	/**
	 * Functions for comparisons 
	 * @param pq - the input array containing elements that needs to be compared.
	 * @param i - First element's index
	 * @param j - Second element's index
	 * @return true/false is 'i' is bigger than 'j'
	 */
	private static boolean less(Comparable[] pq, int i, int j) {
	    return pq[i-1].compareTo(pq[j-1]) < 0;
	}
	
	/**
	 * Functions for swaps 
	 * @param pq - the input array containing elements that needs swaping.
	 * @param i - First element's index
	 * @param j - Second element's index
	 */
	private static void exch(Object[] pq, int i, int j) {
	    Object swap = pq[i-1];
	    pq[i-1] = pq[j-1];
	    pq[j-1] = swap;
	}
	
	/**
	 * Print array to standard output
	 * @param a - Array that needs to be printed.
	 */
    private static void show(Product[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }	
}