/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hojatrabajo3;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;



/**
 *
 * @author Paul Belches
 * @author Andres Urizar
 * 
 */
public class HojaTrabajo3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la cantidad de numeros para el archivo");
        int numeros = sc.nextInt();
        String ruta = System.getProperty("user.dir")+System.getProperty("file.separator")+"archivo.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        BufferedReader fr;
        try{
            bw = new BufferedWriter(new FileWriter(archivo));
            for (int i=0;i<numeros;i++){
                int numero = (int)(Math.random() * 10000) + 1;
             //   System.out.println(numero);
                bw.write(numero+"\n");
            }
             bw.close();
        }catch(Exception e){
            System.out.print("Hubo un error");
        } 
    }      
 }
    

