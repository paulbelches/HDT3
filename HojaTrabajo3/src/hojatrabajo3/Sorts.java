/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo3;
import java.util.*;
/**
 *
 * @author Paul Belches
 * @author Andres Urizar
 */
public class Sorts {
    
    
/**
 * Método de Bubblesort, ordena los valores intercambiando de posición los valores dependiendo quien es mayor
 * @param x Array donde se almacenan los datos
 */
public static void Bubblesort(Comparable[] x){
    for (int i= x.length; i>1; i--){
        for (int j = 1; j<i; j++){
            if (x[j-1].compareTo(x[j]) > 0){
                swap(x,j-1,j);
            }
        }
    }
    }

/**
 * Método de gnomeSort, ordena los valores comparando valor si son mayores
 * @param data array tipo Comparable
 */
        public static void gnomeSort(Comparable[] data) {
        int x = 1;
        int y = 2;
        while (x<(data.length)){
            if (data[x-1].compareTo(data[x]) < 0){
                x=y;
                y++;
            } else {
                swap(data,x,x-1);
                x--;
                if (x == 0){
                  x=y;
                  y++;  
                }
            }
        }
    }
     
     
     
/**
 * Método de swap, es para poder cambiar valores de posición por medio de una temporal
 * @param data
 * @param i
 * @param j 
 */     
    public static void swap(Comparable data[], int i, int j)
        // pre: 0 <= i,j < data.length
        // post: data[i] and data[j] are exchanged
        {
        Comparable temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        }
    
 /**
  * Método para utilizar en sorts, para dividirlo al momento de ordenarlo
  * @param data
  * @param left
  * @param right
  * @return posición
  */   
    
    private static int partition(Comparable data[], int left, int right)
       // pre: left <= right
       // post: data[left] placed in the correct (returned) location
       {
       while (true)
       {
       // move right "pointer" toward left
       while (left < right && data[left].compareTo(data[right]) < 0) right--;
       if (left < right) swap(data,left++,right);
       else return left;
       // move left pointer toward right
       while (left < right && data[left].compareTo(data[right]) < 0) left++;
       if (left < right) swap(data,left,right--);
       else return right;
       }
       }
    /**
     * Método de quicksort, el cual ordena los dividiendo el array en varias mitades.
     * @param data 
     */
    public static void quickSort(Comparable data[])
        // post: the values in data[0..n-1] are in ascending order
        {
        quickSortRecursive(data,0,data.length-1);
        }
    /**
     * Método para utilizar recursión dentro del quicksort
     * @param data
     * @param left
     * @param right 
     */
    private static void quickSortRecursive(Comparable data[],int left,int right)
    // pre: left <= right
    // post: data[left..right] in ascending order
        {
        int pivot; // the final location of the leftmost value
        if (left >= right) return;
        pivot = partition(data,left,right); /* 1 - place pivot */
        quickSortRecursive(data,left,pivot-1); /* 2 - sort small */
        quickSortRecursive(data,pivot+1,right);/* 3 - sort large */
        /* done! */
        }
    
    
    
    /**
     * Método para poder intercalar dos arrays
     * @param data
     * @param temp
     * @param low
     * @param middle
     * @param high 
     */
    private static void merge(Comparable data[], Comparable temp[],int low, int middle, int high)
        // pre: data[middle..high] are ascending
        // temp[low..middle-1] are ascending
        // post: data[low..high] contains all values in ascending order
        {
        int ri = low; // result index
        int ti = low; // temp index
        int di = middle; // destination index
        // while two lists are not empty merge smaller value
        while (ti < middle && di <= high)
        {
        if (data[di].compareTo(temp[ti])<0) {
        data[ri++] = data[di++]; // smaller is in high data
        } else {
        data[ri++] = temp[ti++]; // smaller is in temp
        }
        }
        // possibly some values left in temp array
        while (ti < middle)
        {
        data[ri++] = temp[ti++];
        }
        // ...or some values left (in correct place) in data array
        }
    /**
     * Método para utilizar recursión dentro del metodo del mergesort
     * @param data
     * @param temp
     * @param low
     * @param high 
     */
    private static void mergeSortRecursive(Comparable data[],Comparable temp[], int low, int high)
        // pre: 0 <= low <= high < data.length
        // post: values in data[low..high] are in ascending order
        {
        int n = high-low+1;
        int middle = low + n/2;
        int i;
        if (n < 2) return;
        // move lower half of data into temporary storage
        for (i = low; i < middle; i++)
        {
        temp[i] = data[i];
        }
        // sort lower half of array
        mergeSortRecursive(temp,data,low,middle-1);
        // sort upper half of array
        mergeSortRecursive(data,temp,middle,high);
        // merge halves together
        merge(data,temp,low,middle,high);
        }
    /**
     * Método mergesort, que divide el array para poder intercalarlos
     * @param data 
     */
    public static void mergeSort(Comparable data[])
        // pre: 0 <= n <= data.length
        // post: values in data[0..n-1] are in ascending order
        {
        mergeSortRecursive(data,new Comparable[data.length],0,data.length-1);
        }
    /**
     * Método Radixsort, para ordenar por medio de digitos, en donde va clasificando dependiendo el digito.
     * @param arr 
     */
    public static void Radixsort(Comparable arr[]){
        // Find the maximum number to know number of digits
        int n = arr.length;
        Comparable m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; (int)m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
    /**
     * Método de conteo para utilizar en el Radixsort
     * @param arr
     * @param n
     * @param exp 
     */
    private static void countSort(Comparable arr[], int n, int exp){
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
       
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ ((int)arr[i]/exp)%10 ]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ ((int)arr[i]/exp)%10 ] - 1] = (int)arr[i];
            
            count[ ((int)arr[i]/exp)%10 ]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
    /**
     * Método para poder obtener el mayor valor del array, para el Radixsort 
     * @param arr
     * @param n
     * @return 
     */
    private static Comparable getMax(Comparable arr[], int n){
        Comparable mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i].compareTo(mx) > 0)
                mx = arr[i];
        return mx;
    }

}
   
