/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo3;


import java.io.BufferedReader;
import java.io.FileReader;

/**
 * @author Paul Belches
 * @author Andres Urizar
 */
public class LectorMain {
    
    public static void main(String[] args){
    System.out.println("Prueba");
      /** Método para leer archivo **/
 Comparable[] valores = new Comparable[3000];
try{
    String ruta = System.getProperty("user.dir")+System.getProperty("file.separator")+"archivo.txt";
    BufferedReader bf = new BufferedReader(new FileReader(ruta));
    String linea="";
    int cont = 0;
    while((linea = bf.readLine())!= null){
    	valores[cont] = linea;
        System.out.println(valores[cont]);
        cont++;
    }
    bf.close();
   }
catch(Exception e){
    System.out.print("Hubo un error");
}
   
    }
}
