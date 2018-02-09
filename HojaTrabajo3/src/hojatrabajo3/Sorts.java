/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo3;

/**
 *
 * @author alber    
 */
public class Sorts {
    
    /**
     * Método de Radixsort, ordena los números verificando por unidad, decena y demás dependiendo del tamaño del valor
     * @param x  Array donde se almacenaran los datos
     */
   public static void Radixsort(Comparable[] x)
{
	Comparable inicio = x[0];
	int exp = 1;
	int largo = x.length;
	Comparable [] digitos = new Comparable[10];
	for(int i=1;i<largo;i++){
		if(x[i].compareTo(inicio)>0)//if(x[i]>inicio){
			inicio = x[i];
		}
	while((int)inicio/exp >0){
		int[] temporal = new int[10];
		for(int i=0;i<largo;i++)
			temporal[((int)x[i]/exp)%10]++;
		for(int i=1;i<10;i++)
			temporal[i] += temporal[i-1];
		for(int i=largo-1;i>=0;i--)
			digitos[--temporal[((int)x[i]/exp)%10]] = x[i];
		for(int i=0; i<largo; i++)
			x[i] = digitos[i];
		exp *=10;
	}
}
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
     
     
     
     
    public static void swap(Comparable data[], int i, int j)
        // pre: 0 <= i,j < data.length
        // post: data[i] and data[j] are exchanged
        {
        Comparable temp;
        temp = data[i];
        data[i] = data[j];
        data[j] = temp;
        }
    
    
    
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
    public static void quickSort(Comparable data[])
        // post: the values in data[0..n-1] are in ascending order
        {
        quickSortRecursive(data,0,data.length-1);
        }
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
    public static void mergeSort(Comparable data[])
        // pre: 0 <= n <= data.length
        // post: values in data[0..n-1] are in ascending order
        {
        mergeSortRecursive(data,new Comparable[data.length],0,data.length-1);
        }

}
   
