package javaX;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Prueba {

    public void count(int numberThreads, int number) throws InterruptedException {

        int base = number / numberThreads;
        int restante = number % numberThreads;

        int inicial = 0;

        List<HelloThread> threads = new ArrayList<>();

        long inicio = System.nanoTime();

        for (int i = 0; i < numberThreads; i++) {

            int fin = inicial + base;

            if (i < restante) {
                fin++;
            }

            HelloThread thread = new HelloThread(inicial, fin);
            threads.add(thread);
            thread.start();

            inicial = fin;
        }

        for (HelloThread thread : threads) {
            thread.join();
        }

        long fina = System.nanoTime();

        System.out.println("\nTiempo total: " + (fina - inicio) + " ns");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            System.out.print("Ingresa el número total: ");
            int total = sc.nextInt();

            System.out.print("Ingresa la cantidad de threads: ");
            int threads = sc.nextInt();
            
            Prueba p = new Prueba();
            p.count(threads, total);

        } catch (InterruptedException e) {
            System.out.println("Error al esperar los hilos: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}