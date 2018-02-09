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
    public static void Radixsort(int[] x)
    {
	int inicio = x[0];
	int exp = 1;
	int largo = x.length;
	int [] digitos = new int[10];
	for(int i=1;i<largo;i++){
		if(x[i]>inicio){
			inicio = x[i];
		}
	}
	while(inicio/exp >0){
		int[] temporal = new int[10];
		for(int i=0;i<largo;i++)
			temporal[(x[i]/exp)%10]++;
		for(int i=1;i<10;i++)
			temporal[i] += temporal[i-1];
		for(int i=largo-1;i>=0;i--)
			digitos[--temporal[(x[i]/exp)%10]] = x[i];
		for(int i=0; i<largo; i++)
			x[i] = digitos[i];
		exp *=10;
	}
}

      public void Bubblesort(int[] x){
	boolean estado = true;
	int j = 0;
	int temporal;
	while(estado){
		estado = false;
		j++;
		for(int i = 0; i < x.length - j; i++){
			if(x[i] > x[i+1]){
				temporal = x[i];
				x[i] = x[i+1];
				x[i+1] = temporal;
				estado = true;
			}
		}
	}

}
    
}
