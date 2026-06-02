
package javaX;

import java.util.Scanner;

public class Prueba {

    public void count(int numberThreads, int number){
        int porcion = number / numberThreads;
        int inicial = 0;
        int fin = porcion; 
        long inicio = System.nanoTime();
        for(int i=0; i < numberThreads; i ++){
            HelloThread thread = new HelloThread(inicial,fin);
            thread.start();
            inicial = (i+1)*porcion;
            fin = fin + porcion; 
        } 
        long fina = System.nanoTime();
        System.out.println("Tiempo: " + (fina - inicio) + " ns");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Crear scanner
        System.out.print("Ingresa el número total: ");
        int total = sc.nextInt();
        System.out.print("Ingresa la cantidad de threads: ");
        int threads = sc.nextInt();
        
        Prueba p = new Prueba();
        p.count(threads, total);
        sc.close();
    }
}