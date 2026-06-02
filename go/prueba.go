package main

import (
	"fmt"
	"sync"
	"time"
)

func helloThread(initialNumber, finalNumber int, wg *sync.WaitGroup) {
	defer wg.Done()

	for i := initialNumber; i < finalNumber; i++ {
		fmt.Printf("%d-\n", i)
	}
}

func count(numberThreads, number int) {
	base := number / numberThreads
	restante := number % numberThreads

	inicial := 0

	var wg sync.WaitGroup

	start := time.Now()

	for i := 0; i < numberThreads; i++ {

		fin := inicial + base

		if i < restante {
			fin++
		}

		wg.Add(1)

		go helloThread(inicial, fin, &wg)

		inicial = fin
	}

	// Esperar a que todas las goroutines terminen
	wg.Wait()

	elapsed := time.Since(start)

	fmt.Printf("\nTiempo total: %d ns\n", elapsed.Nanoseconds())
}

func main() {

	var total int
	var threads int

	fmt.Print("Ingresa el número total: ")
	fmt.Scan(&total)

	fmt.Print("Ingresa la cantidad de threads: ")
	fmt.Scan(&threads)

	if threads <= 0 {
		fmt.Println("La cantidad de threads debe ser mayor que 0.")
		return
	}

	if total < 0 {
		fmt.Println("El número total debe ser positivo.")
		return
	}

	count(threads, total)
}
