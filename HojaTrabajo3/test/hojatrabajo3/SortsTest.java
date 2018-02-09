/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo3;

import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author paulb
 */
public class SortsTest {
    
    /**
     * Test of Radixsort method, of class Sorts.
     */
    @Test
    public void testRadixsort() {
        System.out.println("Radixsort");
        Comparable[] x = new Integer[] {2,5,6,3,4};
        Comparable[] resul = new Integer[] {2,3,4,5,6};
        Sorts.Radixsort(x);
        assertArrayEquals( resul, x );
    }

    /**
     * Test of Bubblesort method, of class Sorts.
     */
    @Test
    public void testBubblesort() {
        System.out.println("Bubblesort");
        Comparable[] x = new Integer[] {2,5,6,3,4};
        Comparable[] resul = new Integer[] {2,3,4,5,6};
        Sorts.Bubblesort(x);
        assertArrayEquals( resul, x );
    }

    /**
     * Test of gnomeSort method, of class Sorts.
     */
    @Test
    public void testGnomeSort() {
        System.out.println("gnomeSort");
        Comparable[] x = new Integer[] {2,5,6,3,4};
        Comparable[] resul = new Integer[] {2,3,4,5,6};
        Sorts.gnomeSort(x);
        assertArrayEquals( resul, x );
    }


    /**
     * Test of quickSort method, of class Sorts.
     */
    @Test
    public void testQuickSort() {
        System.out.println("quickSort");
        Comparable[] x = new Integer[] {2,5,6,3,4};
        Comparable[] resul = new Integer[] {2,3,4,5,6};
        Sorts.quickSort(x);
        assertArrayEquals( resul, x );
    }

    /**
     * Test of mergeSort method, of class Sorts.
     */
    @Test
    public void testMergeSort() {
        System.out.println("mergeSort");
        Comparable[] x = new Integer[] {2,5,6,3,4};
        Comparable[] resul = new Integer[] {2,3,4,5,6};
        Sorts.mergeSort(x);
        assertArrayEquals( resul, x );
    }
}
