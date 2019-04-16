/** 
 * @author Shivam Taneja, Lab 02
 **/
package sort;

public class Quick {
	
    /** 
     * This class should not be instantiated.
     **/
	private Quick() { }

	/**
	 * basic quick sort
	 * @param x - the input array containing products that need to be sorted.
	 */
	public static void sortBasicQuick (  Product[] x ) {
		QuickSort(x, 0, x.length - 1 );

	}
	
	/**
	 * three partition quick sort using Comparable
	 * @param x - the input array containing products that need to be sorted.
	 * @param n - the size of the input array
	 */
	public static void sortThreePartition (Comparable[] x, int n ) {
		sort3way(x, 0, n - 1);
	}
	
	/**
	 * Recursive Functions
	 */
	
	
	/**
	 * Recursive quick sort function
	 * @param x - unsorted Product array that needs to be sorted 
	 * @param l - lower index of partitioned array (x)
	 * @param h - upper index of partitioned array (x)
	 */
	private static void QuickSort(Product[] x, int l, int h) {
		if (h <= l) {
			return;
		}
		int j = part(x,l,h);
		QuickSort(x,l,j-1);
		QuickSort(x,j+1,h);
		
	}
	
	/**
	 * Partitioning of the sub-arrays
	 * @param a - Sub-array that needs partitioning index
	 * @param l - lower index of the sub-array
	 * @param h - upper index of the sub-array
	 * @return partitioning index in the given sub-array
	 */
	private static int part(Comparable[] a, int l, int h) {
		int i = l, j = h+1;
		Comparable v = a[l];
		while(true) {
			while (lessb(a[++i],v)) {
				if(i == h) {
					break;
				}
			} while (lessb(v,a[--j])) {
				if (j == h) {
					break;
				}
			} if (i >= j) {
				break;
			}
			exch(a,i,j);
		}
		exch(a,l,j);
		return j;
	}
	
	/**
	 * Recursive call for 3 way quick sort function
	 * @param x - unsorted array 
	 * @param low - lower index of the array
	 * @param hi - upper index of the array
	 */
	private static void sort3way(Comparable[] x, int low, int hi) {
		if (hi <= low) {
			return; }
		int tempL = low, tempH = hi;
		Comparable aux = x[low];
		int i = low +1;
		while (i <= tempH) {
			if (less(x[i],aux ) < 0) {
				exch(x, tempL++, i++);
			} else if (less(aux,x[i]) > 0)  {
				exch(x,i,tempH--);
			} else {
				i++;
			}
		}
		sort3way(x,low,tempL-1);
		sort3way(x,tempH+1,hi);
	}
	
	/**
	 * Helper Functions
	 */
		
	/**
	 * Functions for comparisons 
	 * @param v - first element to be compared
	 * @param w - second element to be compared
	 * @return -1/0/1 if 'v' is smaller than 'w', 'v' is equal to 'w', or 'v' is bigger than 'w', respectively
	 */
    private static int less(Comparable v, Comparable w) {    	
        return v.compareTo(w) ;
    }
	
	/**
	 * Functions for comparisons 
	 * @param v - first element to be compared
	 * @param w - second element to be compared
	 * @return true/false is 'w' is bigger than 'w'
	 */
    private static boolean lessb(Comparable v, Comparable w) {    	
        return v.compareTo(w) < 0 ;
    }  
    
	/**
	 * Functions for swaps 
	 * @param a - the input array containing elements that needs swaping.
	 * @param i - First element's index
	 * @param j - Second element's index
	 */
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
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