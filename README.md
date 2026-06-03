# Thread Count — Java & Go

Programa que divide el conteo de números entre múltiples hilos (threads) y mide el tiempo total de ejecución. Implementado en dos lenguajes para comparar su modelo de concurrencia: **Java** con `Thread` y **Go** con goroutines.

Ambas versiones piden al usuario un número total y una cantidad de hilos, reparten el rango equitativamente entre ellos (manejando el residuo), los ejecutan en paralelo y reportan el tiempo transcurrido en nanosegundos.

---


## Go — `main.go`

Implementación con goroutines y `sync.WaitGroup`.

- **`helloThread(initialNumber, finalNumber int, wg *sync.WaitGroup)`** — goroutine que imprime los números en su rango asignado. Llama a `wg.Done()` al terminar via `defer`.
- **`count(numberThreads, number int)`** — calcula el rango de cada goroutine distribuyendo el residuo entre las primeras, lanza todas con `go`, espera con `wg.Wait()` y mide el tiempo con `time.Since`.
- **`main()`** — lee los inputs del usuario y valida que sean positivos antes de llamar a `count`.

### Ejecución

```bash
go run main.go
```

---

## Java — `HelloThread.java` y `Prueba.java`

Implementación con la clase `Thread` de Java extendida directamente.

### `HelloThread.java`

Extiende `Thread`. Recibe el rango `[initialNumber, finalNumber)` en el constructor y lo imprime en `run()`.

### `Prueba.java`

Contiene la lógica principal:

- **`count(int numberThreads, int number)`** — distribuye el rango entre instancias de `HelloThread`, las inicia con `start()`, espera a todas con `join()` y mide el tiempo con `System.nanoTime()`.
- **`main(String[] args)`** — lee los inputs con `Scanner` y llama a `count`, manejando `InterruptedException`.

### Ejecución

```bash
javac javaX/*.java
java javaX.Prueba
```

---

## Ejemplo de salida

Ingresa el número total: 10
Ingresa la cantidad de threads: 3

0-
1-
2-
3-
4-
5-
6-
7-
8-
9-

Tiempo total: 63224700 ns
