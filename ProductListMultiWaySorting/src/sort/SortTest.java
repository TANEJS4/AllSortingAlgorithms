package sort;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SortTest {
	

	private Product[] input1;
	private Product[] input2;
	private Product[] input3;
	private Product[] input4;
	private Product[] input5;


    private long start;

	 private static boolean isSorted(Comparable[] a) {
	        return isSorted(a, 0, a.length - 1);
	    }
	        
	    private static boolean isSorted(Comparable[] a, int lo, int hi) {
	        for (int i = lo + 1; i <= hi; i++)
	            if (less(a[i], a[i-1])) {
	            	return false;
	            }
	        return true;
	    }
	    private static boolean less(Comparable v, Comparable w) {
	        return v.compareTo(w) < 0;
	    }
	    
	@Before
	public void setUp() throws Exception {
		try {
    		File f = new File("data/a1_in.txt");
    		BufferedReader br = new BufferedReader(new FileReader(f));
    		
    		String st1 = br.readLine();
    		String st2 = br.readLine();
    		String st3 = br.readLine();
    		String st4 = br.readLine();
    		String st5 = br.readLine();

    		String[] tempA;
    		String[] tempB;
    		String[] tempC; 
    		String[] tempD;
    		String[] tempE;


    		st1 = st1.replace("{","").replace("}","");
    		st2 = st2.replace("{","").replace("}","");
    		st3 = st3.replace("{","").replace("}","");
    		st4 = st4.replace("{","").replace("}","");
    		st5 = st5.replace("{","").replace("}","");


    		tempA = st1.split(",");
    		tempB = st2.split(",");
    		tempC = st3.split(",");
    		tempD = st4.split(",");
    		tempE = st5.split(",");


    		input1 = new Product[(tempA.length)/2];
    		input2 = new Product[(tempB.length)/2];
    		input3 = new Product[(tempC.length)/2];
    		input4 = new Product[(tempD.length)/2];
    		input5 = new Product[(tempE.length)/2];


    		int c = 0;
    		for(int i = 0; i < tempA.length;i=i+2) {
    			
    			input1[c] = new Product(tempA[i],Integer.parseInt(tempA[i+1]));
    			c++;
    		}
            c = 0 ;
    		for(int i = 0; i < tempB.length;i=i+2) {
    			
    			input2[c] = new Product(tempB[i],Integer.parseInt(tempB[i+1]));
    			c++;
    		}
            c =0 ;

    		for(int i = 0; i < tempC.length;i=i+2) {
    			
    			input3[c] = new Product(tempC[i],Integer.parseInt(tempC[i+1]));
    			c++;
    		}
            c =0 ;

    		for(int i = 0; i < tempD.length;i=i+2) {
    			
    			input4[c] = new Product(tempD[i],Integer.parseInt(tempD[i+1]));
    			c++;
    		}
            c =0 ;

    		for(int i = 0; i < tempE.length;i=i+2) {
    			
    			input5[c] = new Product(tempE[i],Integer.parseInt(tempE[i+1]));
    			c++;
    		}
            start = System.currentTimeMillis();
		}
    	catch (Exception e) {
    		System.out.println(e);
    	} 
	}

	@After
	public void tearDown() throws Exception {
    	double now = System.currentTimeMillis();
        now = (now - start);
        System.out.println(now);
	}

	@Test
	public void testMergeTD() {
		Merge.sortMergeTD(input1, input1.length);
		Merge.sortMergeTD(input2, input2.length);
		Merge.sortMergeTD(input3, input3.length);
		Merge.sortMergeTD(input4, input4.length);
		Merge.sortMergeTD(input5, input5.length);

		assertTrue(isSorted(input1));
		assertTrue(isSorted(input2));
		assertTrue(isSorted(input3));
		assertTrue(isSorted(input4));
		assertTrue(isSorted(input5));
	}
	@Test
	public void testMergeBU() {
		Merge.sortMergeBU(input1, input1.length);
		Merge.sortMergeBU(input2, input2.length);
		Merge.sortMergeBU(input3, input3.length);
		Merge.sortMergeBU(input4, input4.length);
		Merge.sortMergeBU(input5, input5.length);

		assertTrue(isSorted(input1));
		assertTrue(isSorted(input2));
		assertTrue(isSorted(input3));
		assertTrue(isSorted(input4));
		assertTrue(isSorted(input5));
	}
	@Test
	public void testSortInserted() {
		Insertion.sortInsert(input1);
		Insertion.sortInsert(input2);
		Insertion.sortInsert(input3);
		Insertion.sortInsert(input4);
		Insertion.sortInsert(input5);

		assertTrue(isSorted(input1));
		assertTrue(isSorted(input2));
		assertTrue(isSorted(input3));
		assertTrue(isSorted(input4));
		assertTrue(isSorted(input5));
		}
	@Test
	public void testInsertComparable() {
		Insertion.sortComparable(input1, input1.length);
		Insertion.sortComparable(input2, input2.length);
		Insertion.sortComparable(input3, input3.length);
		Insertion.sortComparable(input4, input4.length);
		Insertion.sortComparable(input5, input5.length);

		assertTrue(isSorted(input1));
		assertTrue(isSorted(input2));
		assertTrue(isSorted(input3));
		assertTrue(isSorted(input4));
		assertTrue(isSorted(input5));
		}
	
	@Test
	public void testInsertBinary() {
		Insertion.sortBinary(input1, input1.length);
		Insertion.sortBinary(input2, input2.length);
		Insertion.sortBinary(input3, input3.length);
		Insertion.sortBinary(input4, input4.length);
		Insertion.sortBinary(input5, input5.length);

		assertTrue(isSorted(input1));
		assertTrue(isSorted(input2));
		assertTrue(isSorted(input3));
		assertTrue(isSorted(input4));
		assertTrue(isSorted(input5));
		}
	
	@Test
	public void testHeap() {
		Heap.sortHeap(input1, input1.length);
		Heap.sortHeap(input2, input2.length);
		Heap.sortHeap(input3, input3.length);
		Heap.sortHeap(input4, input4.length);
		Heap.sortHeap(input5, input5.length);

		
		assertTrue(isSorted(input1));
		assertTrue(isSorted(input2));
		assertTrue(isSorted(input3));
		assertTrue(isSorted(input4));
		assertTrue(isSorted(input5));
		}
}
