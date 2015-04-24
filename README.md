# Java Performance

Wir werden uns nun mit einigen grundlegenden Performance Fragestellungen beschäftigen. Vorweg sei gesagt, es gibt meist nicht den ultimativen PerformanceGUIDE für jede Anwendungsumgebung. Allerdings gibt es einiges im Bereich Java, das man beachten kann wenn es dem eigenen Ziel zuträglich ist. Wir werden hiermit Java7 beginnen, was soviel bedeutet, dass wir uns die Neuigkeiten aus dem Package concurrent nochmals kurz ansehen werden. 

## bis Java7 und das Package Concurrent

| Classname          | since| APIDoc (8) |
|:-------------      |:--:| -------------:|
| [Semaphore]()      | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Semaphore.html)|
| [CyclicBarrier]()  | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CyclicBarrier.html)|
| [CountDownLatch]()| 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CountDownLatch.html)|
| [Exchanger]()     | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Exchanger.html)|
| [DelayQueue]()    | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/DelayQueue.html)|
| [ExecutorCompletionService]()| 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ExecutorCompletionService.html)|
| [ThreadPoolExecutor]()       | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ThreadPoolExecutor.html)|
| [FutureTask]()               | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/FutureTask.html)|
| [ScheduledThreadPoolExecutor]()| 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ScheduledThreadPoolExecutor.html)|
| [ScheduledThreadPoolExecutor]()| 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ScheduledThreadPoolExecutor.html)|
| [CopyOnWriteArrayList]()       | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CopyOnWriteArrayList.html)|
| [CopyOnWriteArraySet]()        | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CopyOnWriteArraySet.html)|
| [LinkedBlockingQueue]()        | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/LinkedBlockingQueue.html)|
| [PriorityBlockingQueue]()      | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/PriorityBlockingQueue.html)|
| [SynchronousQueue]() | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/SynchronousQueue.html)|
| [TimeUnit]()         | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/TimeUnit.html)|
| [LockSupport]()      | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/LockSupport.html)|
| [ReentrantLock]()    | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ReentrantLock.html)|
| [ReentrantReadWriteLock]()   | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ReentrantReadWriteLock.html)|
| [AtomicIntegerFieldUpdater]()| 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/AtomicIntegerFieldUpdater.html)|
| [AtomicBoolean]()      | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/AtomicBoolean.html)|
| [AtomicIntegerArray]() | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/AtomicIntegerArray.html)|
| [AtomicMarkableReference]() | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/AtomicMarkableReference.html)|
| [AtomicReference]()         | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/AtomicReference.html)|
| [AtomicReferenceArray]()    | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/AtomicReferenceArray.html)|
| [AtomicReferenceFieldUpdater]() | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/AtomicReferenceFieldUpdater.html)|
| [AtomicStampedReference]()      | 1.5|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/AtomicStampedReference.html)|
| [LinkedBlockingDeque]()   | 1.6|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/LinkedBlockingDeque.html)|
| [ConcurrentSkipListMap]() | 1.6|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentSkipListMap.html)|
| [ConcurrentSkipListSet]() | 1.6|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentSkipListSet.html)|
| [Phaser]()               | 1.7|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Phaser.html)|
| [ForkJoinPool]()         | 1.7|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinPool.html) |
| [ForkJoinTask]()         | 1.7|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinTask.html)|
| [ForkJoinWorkerThread]() | 1.7|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ForkJoinWorkerThread.html)|
| [RecursiveAction]()      | 1.7|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/RecursiveAction.html)|
| [RecursiveTask]()        | 1.7|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/RecursiveTask.html)|
| [ConcurrentLinkedDeque]()| 1.7|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentLinkedDeque.html)|
| [LinkedTransferQueue]()  | 1.7|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/LinkedTransferQueue.html)|
| [ThreadLocalRandom]()    | 1.7|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ThreadLocalRandom.html)|
| [CountedCompleter]()   | 1.8|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CountedCompleter.html)|
| [CompletableFuture]()  | 1.8|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html)|
| [CompletionException]()| 1.8|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletionException.html)|
| [StampedLock]()        | 1.8|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/StampedLock.html)|
| [DoubleAccumulator]()  | 1.8|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/DoubleAccumulator.html)|
| [LongAccumulator]()    | 1.8|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/LongAccumulator.html)|
| [DoubleAdder]()        | 1.8|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/DoubleAdder.html)|
| [LongAdder]()          | 1.8|[API](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/LongAdder.html)|




### Semaphore
Esmaphore erlauben eine maximale Anzahl Threads einem Programmblock zu durchlaufen. Hierbei unterscheidet man zwischen binären Semaphoren und Allgemeinen Semaphoren. Die binären Semaphoren lassen höchstens einen Thread in einen definierten Programmblock hinein. Bei den allgemeinen Semaphoren ist das dann die definierte Zahl n die gleichzeitig in dem Programmblock aktiv sein darf. 

```java
public class ConnectionLimiter {
    private final Semaphore semaphore;

    private ConnectionLimiter(int maxConcurrentRequests) {
      semaphore = new Semaphore(maxConcurrentRequests);
    }

    public URLConnection acquire(URL url) throws InterruptedException,IOException {
      semaphore.acquire();
      return url.openConnection();
    }

    public void release(URLConnection conn) {
      try {/* ... clean up here */
      } finally { semaphore.release(); }
    }
}
```  
Eine Instanz der Semaphore kann mit einer Anzahl n versehen werden, die dann der Anzahl der zugelassenen Threads entspricht. Hier ist es ```semaphore = new Semaphore(maxConcurrentRequests)``` Immer dann wenn ein Thread den Block betreten möchte, deklariert es dieses mit dem blockierenden Methodenaufruf ```semaphore.acquire()```. Findet der Eintritt in den Programmblock statt, sollte nach Verlassen dessen die Semaphore wieder freigegeben werden. Das erfolgt mittels ```semaphore.release();``` Hier ist natürlich zu beachten, dass ein vorzeitiger Austritt aus dem Programmblock durch das Auftreten einer Exception nicht dazu führen darf, dass die freigabe nicht mehr erfolgt.

#### Übung Semaphore
Gegeben ist die Klasse ```DoubleRessourceGrabber```

```java
  private static class DoubleResourceGrabber implements Runnable {
    private Semaphore first;
    private Semaphore second;

    public DoubleResourceGrabber(Semaphore s1, Semaphore s2) {
      first = s1;
      second = s2;
    }

    public void run() {
      try {
        Thread t = Thread.currentThread();
        first.acquire();
        System.out.println(t + " acquired " + first);
        Thread.sleep(200);
        second.acquire();
        System.out.println(t + " acquired " + second);
        second.release();
        System.out.println(t + " released " + second);
        first.release();
        System.out.println(t + " released " + first);
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    }
  }
``` 
Diese Klasse wird nun wie folgt verwendent und läuft in eine Blockade..  Warum?

```java
public class Uebung {
  public static void main(String[] args) throws Exception {
    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(1);

    Thread t = new Thread(new DoubleResourceGrabber(s1, s2));
    Thread t2 = new Thread(new DoubleResourceGrabber(s2, s1));

    t.start();
    t2.start();

    t.join();
    t2.join();
    System.out.println("We got lucky!");
  }
```
#### Übung Semaphore - Lösung
Die Anforderung der Ressourcen erfolgt hier leider über Kreuz. Dieses führt zu einem gegenseitigen Warten. Die Lösung besteht in der richtigen Reihenfolge der Ressourcenbelegung.
Aus ```Thread t2 = new Thread(new DoubleResourceGrabber(s2, s1));```wird ```Thread t2 = new Thread(new DoubleResourceGrabber(s1, s2));```

```java
public class Loesung {
  public static void main(String[] args) throws Exception {
    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(1);

    Thread t = new Thread(new DoubleResourceGrabber(s1, s2));
    Thread t2 = new Thread(new DoubleResourceGrabber(s1, s2));

    t.start();
    t2.start();

    t.join();
    t2.join();
    System.out.println("We got lucky!");
  }}

```
## CyclicBarrier
Eine Barrier ist der Punkt an dem verschiedene Threads zusammenlaufen. Alle Threads warten bis auch der letzte dort angekommen ist. Sie terminieren nicht, sondern signalisieren mit ```await()``` das sie angekommen sind. Das Ergebnis aller Threads kann dann in Summe verarbeitet werden. Die Klasse ```CyclicBarrier``` selbst gibt es in Java seit Java5. Die Verwendung einer Instanz der Klasse ```CyclicBarrier``` ist besser als das Warten mittels ```join()```.

```java
public class CyclicBarrierExample {
  //Runnable task for each thread
  private static class Task implements Runnable {
    private CyclicBarrier barrier;
    public Task(CyclicBarrier barrier) {
      this.barrier = barrier;
    }

    @Override
    public void run() {
      try {
        System.out.println(Thread.currentThread().getName() + " is waiting on barrier");
        barrier.await();
        System.out.println(Thread.currentThread().getName() + " has crossed the barrier");
      } catch (InterruptedException | BrokenBarrierException ex) {
        System.out.println("ex = " + ex);
      }
    }
  }

  public static void main(String args[]) {
    //creating CyclicBarrier with 3 parties i.e. 3 Threads needs to call await()
    final CyclicBarrier cb = new CyclicBarrier(3, () -> System.out.println("All parties are arrived at barrier, lets play"));
    //starting each of thread
    Thread t1 = new Thread(new Task(cb), "Thread 1");
    Thread t2 = new Thread(new Task(cb), "Thread 2");
    Thread t3 = new Thread(new Task(cb), "Thread 3");

    t1.start();
    t2.start();
    t3.start();
  }

}
```


## CountDownLatch
Ein ```CountDownLatch``` beginnt mit einem zu definierenden Startwert. Dieser wird dann nach und nach decrementiert. Mittels der Methode ```await()```kann man darauf warten, das der Wert null ereicht worden ist. Wichtig ist an dieser Stelle zu wissen, das eine Instanz der Klasse ```CountDownLatch```nur einmal verwendet werden kann.  

Hier ein Beispiel einer Eigenimplementierung, die allerdings fast immer fehlschlagen wird...

```java
  private final static int MAX_COUNT = 4;
  private static int counter = 0;

  public static synchronized void addToCounter(final int number) {
    counter = counter + number;
    System.out.println("counter value: " + counter);
  }
  public static synchronized int getCounter() {
    return counter;
  }

  public static void main(String[] args) {
    System.out.println("starting counter: " + getCounter());

    for (int i = 0; i < MAX_COUNT; i++) {
      new Thread(() -> addToCounter(1)).start();
    }

    // This will return an inaccurate value most of the time.
    // To get an accurate result use a countdown latch
    System.out.println("=====> final counter: " + getCounter());

  }

```
Die Verwendung von ```CountDownLatch```´es sieht dann wie folgt aus.

```java
  private final static int MAX_COUNT = 4;

  public static void main(String[] args) throws InterruptedException {

    CountDownLatch start = new CountDownLatch(1);
    CountDownLatch finished = new CountDownLatch(MAX_COUNT);

    for (int i = 0; i < MAX_COUNT; ++i) {
      new Thread(new Runner(start, finished)).start();
    }
    System.out.println("Starting the countdown...");
    start.countDown(); // Starting all threads... way cool!
    finished.await();  // Waiting for all threads to finish
    System.out.println("=====> final count on Runner: " + Runner.count);
  }

  public static class Runner implements Runnable {

    public static int count;
    private final CountDownLatch finished;
    private final CountDownLatch start;

    public Runner(CountDownLatch start, CountDownLatch finished) {
      this.start = start;
      this.finished = finished;
    }

    @Override
    public void run() {
      try {
        start.await(); //GO!
        add(1);
        finished.countDown();
      } catch (InterruptedException ignored) { } // return;
    }

    public static synchronized void add(int value) {
      count = count + value;
      System.out.println("runner count: " + count);
    }
  }
```
Hier in diesem Beispiel wird gezeigt, das man nicht nur am Ende auf die Threads warten kann. Der ```CountDownLatch```mit dem Namen ```start``` wird verwendet um alle Threads gleichzeitig starten zu lassen. Wir übergeben also diese Instanz dem Thread selbst und lassen ihn an der Schranke warten bis man von aussen den Startschuss gibt. 

### Übung CountDownLatch
### Lösung CountDownLatch

## Exchanger
Die Aufgabe der Klasse Exchange ist recht schnell erklärt. Es soll einem die Möglichkeit gegeben werden einen Wert zwischen zwei Threads auszutauschen.

```java
public class ExchangerExample {
  public static void main(String[] args) {
    Exchanger<String> exchanger = new Exchanger<>();
    Thread t1 = new MyThread(exchanger, "I like coffee.");
    Thread t2 = new MyThread(exchanger, "I like tea");
    t1.start();
    t2.start();
  }
}

class MyThread extends Thread {
  Exchanger<String> exchanger;
  String message;

  MyThread(Exchanger<String> exchanger, String message) {
    this.exchanger = exchanger;
    this.message = message;
  }

  public void run() {
    try {
      System.out.println(this.getName() + " message 01: " + message);
      // exchange messages
      message = exchanger.exchange(message);
      System.out.println(this.getName() + " message 02: " + message);
    } catch (Exception ignored) {
    }
  }
}
```


## Im JDK7 hinzugekommene Klassen

## Phaser
Bei einem ```Phaser``` handelt es sich in etwa um einen ```CountDownLatch``` der dekrementiert aber auch inkrementiert werden kann. Damit kann man die Instanz mehrfach verwenden. Aber es gibt auch noch einige weitere interessante Einsatzgebiete im Vergleich zu einem ```CountDownLatch``` 

Um einen ```Phaser``` zu inkrementieren verwendet man die Methode ```register()``` und das Gegenstück dazu ist die Methode ```arriveAndAwaitAdvance()```.  

```java
public class PhaserExample {
  public static void main(String[] args) {
    Phaser phaser = new Phaser();

    Thread t1 = new MyThread(phaser, 1000);
    Thread t2 = new MyThread(phaser, 2000);
    Thread t3 = new MyThread(phaser, 3000);
    t1.start();
    t2.start();
    t3.start();

  }
}
public class MyThread extends Thread {
  Phaser phaser;
  int sleep;

  MyThread(Phaser phaser, int sleep) {
    this.phaser = phaser;
    this.sleep = sleep;
  }

  public void run() {
    phaser.register(); //counter up
    System.out.println(this.getName() + " begin");
    try {
      Thread.sleep(sleep);
    } catch (Exception ignored) { }

    phaser.arriveAndAwaitAdvance(); //counter down
    //counter = 0
    System.out.println(this.getName() + " middle");
    try {
      Thread.sleep(sleep);
    } catch (Exception ignored) { }
    System.out.println(this.getName() + " end");
  }
}
```   
### Übung Phaser
### Lösung Phaser

## ForkJoinPool 
Der ForkAndJoin Pool wurde mit dem JDK7 eingeführt. Hierbei handelt es sich um einen Pool in dem 
eine Menge von Threads verwaltet werden. Die Arbeit wird in Form von Arbeitspaketen 
diesem Pool zur Abarbeitung übergeben. Die Anzahl der Arbeitspakete 
kann die Zahl der arbeitenden Threads bei weitem übersteigen ohne das eine Sättigung des Systems
eintreten wird. Der Name ForkAndJoin kommt von dem Verhalten der hier grundlegend verwendet wird. 
Die Stufe Fork ist diejenige, die entscheidet ob die noch anstehende Arbeit in mehrere Teilschritte 
zerlegt werden soll. Die Stufe Join ist das Gegenteil und merged das Ergebnis zweier unterliegender
Arbeitspakete zu einem Gesamtergebnis.

```java
 public static void main(String[] args) {
    final ForkJoinPool forkJoinPool = new ForkJoinPool(4);
    MyRecursiveAction myRecursiveAction = new MyRecursiveAction(240);
    forkJoinPool.invoke(myRecursiveAction);
    try {
      forkJoinPool.awaitTermination(10, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }


  public static class MyRecursiveAction extends RecursiveAction {
    private long workLoad = 0;

    public MyRecursiveAction(long workLoad) {
      this.workLoad = workLoad;
    }

    @Override
    protected void compute() {
      //if work is above threshold, break tasks up into smaller tasks
      if (this.workLoad > 16) {
        System.out.println("Splitting workLoad : " + this.workLoad);
        List<MyRecursiveAction> subtasks = new ArrayList<>();
        subtasks.addAll(createSubtasks());
        for (final RecursiveAction subtask : subtasks) {
          subtask.fork();
        }
      } else {
        System.out.println("Doing workLoad myself: " + this.workLoad);
      }
    }

    private List<MyRecursiveAction> createSubtasks() {
      List<MyRecursiveAction> subtasks = new ArrayList<>();
      MyRecursiveAction subtask1 = new MyRecursiveAction(this.workLoad / 2);
      MyRecursiveAction subtask2 = new MyRecursiveAction(this.workLoad / 2);
      subtasks.add(subtask1);
      subtasks.add(subtask2);
      return subtasks;
    }
  }
```

Hier werden weitere Instanzen der Klasse ```MyRecursiveAction``` erzeugt, wenn die Zahl **workload**
über 16 liegt. Die Instanz die diese Entscheidung trifft muss selber dafür sorgen dass die Aufteilung 
der Daten richtig erfolgt. 

### Übung ForkJoinPool


### Lösung ForkJoinPool

## ForkJoinTask 
### Übung ForkJoinTask
### Lösung ForkJoinTask

## ForkJoinWorkerThread 
### Übung ForkJoinWorkerThread
### Lösung ForkJoinWorkerThread

## RecursiveAction
### Übung RecursiveAction
### Lösung RecursiveAction

## RecursiveTask
### Übung RecursiveTask
### Lösung RecursiveTask

## ConcurrentLinkedDeque
### Übung ConcurrentLinkedDeque
### Lösung ConcurrentLinkedDeque

## LinkedTransferQueue 
### Übung LinkedTransferQueue
### Lösung LinkedTransferQueue

## ThreadLocalRandom
### Übung ThreadLocalRandom
### Lösung ThreadLocalRandom


## neu in Java 8
Seit Java8 gibt es ein paar Verbesserungen im Bereich der Packages concurrent.* 
Allerdings sind diese Verbesserungen bis auf wenige Ausnahmen eher etwas für sehr spezielle Anwendungsfälle. 


##LongAccumulator & DoubleAccumulator
Die Akkumulatoren in Java8 sind entwickelt worden um in den 
Bereichen in denen Atomic-Strukturen zu langsam sind, verwendet zu werden. 
Demnach lohnt ein Umbau von bestehendem Code nur in Ausnahmefällen. Die gesteigerte Performance 
wurde durch eine Implementierung erreicht, die mehr Speicher verwendet als die Atomic-Strukturen.
Die Verwendung aus der Sicht eines Entwicklers ist recht einfach. Hier werden z.B. zwei Long Werte 
miteinander addiert. Akkumulatoren sind nur die Hülle für eine beliebige atomare Funktion die realisiert
werden soll. Der Aufruf der Methode ```accumulate(3)``` führt diese Operation aus. 
Das Gesamtergebnis aller Operationen ist an der Stelle allerdings nicht final berechnet worden. 
Das passiert erst wenn man die Methode ```get()``` oder z.B. ```longValue()``` aufruft. 
In dem Fall werden alles erzeugten Zwischenergebnisse aufeinander angewendet 
und das finale Ergebnis zur Verfügung gestellt.

```java
LongAccumulator longAccumulator = new LongAccumulator((left, right) -> {
  System.out.println("left = " + left);
  System.out.println("right = " + right);
  return left + right;
},0L);

longAccumulator.accumulate(3);
System.out.println("longAccumulator = " + longAccumulator.longValue());
```

Für alle Akkumulatoren und auch Adder, gilt das nachfolgende Verhalten.
Wenn die Methode zum berechnen des Wertes aufgerufen wird, 
werden alle bis dahin erfolgten Operationen ausgewertet. Operationen die bei der 
Durchführung der Berechnung erfolgen können, müssen aber nicht berücksichtigt werden.
In der JavaDoc selbst steht.
>
>Returns the current value.  The returned value is <em>NOT</em>
>an atomic snapshot; invocation in the absence of concurrent
>updates returns an accurate result, but concurrent updates that
>occur while the value is being calculated might not be
>incorporated.
>
>@return the current value
>

### Übung LongAccumulator
### Lösung LongAccumulator


##LongAdder & DoubleAdder
Die Akkumulatoren sebst sind eine generische Operation, 
die Spezialafälle Addition und Subtraktion wurden schon als eigenständige Klasse 
in dem JDK zur Verfügung gestellt. Das Verhalten ist aber gleich dem der Akkumulatoren.

```java
LongAdder longAdder = new LongAdder();
longAdder.add(5);
longAdder.add(-5);
longAdder.increment();
longAdder.decrement();
longAdder.increment();
System.out.println("longAdder.intValue() = " + longAdder.intValue());
final long sum = longAdder.sum();
System.out.println("sum = " + sum);
System.out.println("longAdder.intValue() = " + longAdder.intValue());

final long sumThenReset = longAdder.sumThenReset();
System.out.println("sumThenReset = " + sumThenReset);
System.out.println("longAdder.intValue() = " + longAdder.intValue());
```
### Übung LongAdder & DoubleAdder
### Lösung LongAdder & DoubleAdder

 
## CountedCompleter
### Übung CountedCompleter
### Lösung CountedCompleter

##CompletableFuture
Die Klasse ```CompletableFuture``` gibt einem die Möglichkeit asynchrone Methodenaufrufe zu implementieren.
Die Ressourcen zur Abarbeitung werden aus dem CommonPool zur Verfügung gestellt, wenn nicht anders angegeben.
Ebenfalls kann man angeben was passieren soll, wenn das Ergebnis eintrifft.

Wenn man einen Blick in die Api-Doc wirft, wird man zuerst ein wenig verwundert sein über die Anzahl der Methoden die
einem angeboten werden. Wir werden uns hier die grundlegenden Mechanismen von der Klasse ```CompletableFuture```ansehen.

Es gibt hier zwei Ausprägungen. Die erste basiert auf der Übergabe einer Instanz von ```Runnable```. 
Dieses wird verwendet wenn es keinen Rückgabewert gibt. Wird ein Rückgabewert geliefert,
dann wird das FunctionalInterface ```Suplier``` oder ```Function``` implementiert.

```java
static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier);
static <U> CompletableFuture<U> supplyAsync(Supplier<U> supplier, Executor executor);
static CompletableFuture<Void> runAsync(Runnable runnable);
static CompletableFuture<Void> runAsync(Runnable runnable, Executor executor);
```

Mittels der Methoden ```thenApply```kann man unter anderem mehrere Verarbeitungsstufenkombinieren. Das hat den
Vorteil, dass man ein Zwischenergebnis nicht berechnen muss um den nachfolgenden Schritt anzustoßen.

```java
<U> CompletableFuture<U> thenApply(Function<? super T,? extends U> fn);
<U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn);
<U> CompletableFuture<U> thenApplyAsync(Function<? super T,? extends U> fn, Executor executor);

//Beispiel
CompletableFuture<String> f1 = //...
CompletableFuture<Integer> f2 = f1.thenApply(Integer::parseInt);
CompletableFuture<Double> f3 = f2.thenApply(r -> r * r * Math.PI);

```

Um auf Ergebnisse zu warten, oder besser gesagt, reagieren zu können, stehen unter anderem folgende Methoden 
zur Verfügung.

```java
CompletableFuture<Void> thenAccept(Consumer<? super T> block);
CompletableFuture<Void> thenRun(Runnable action);
```
Hier gibt es auch wieder die Async - Versionen. Es wird angegeben was passieren soll wenn das Ergebnis angekommen ist. Hier muss man nun 
nicht warten. Aber wie kann man mit Exceptions umgehen? Hierfür gibt es die Methode ```exceptionally()```  

```java
CompletableFuture<String> safe = future.exceptionally(ex -> "OK, somthing went wrong: " + ex.getMessage());
```




### Übung CompletableFuture
Als Übung werden wir nun versuchen das folgende Feature zu realisieren.
Gehen wir davon aus das die nachfolgende Implementierung existiert.
```java
private String pattern;
private SimpleDateFormat sdf;

//beispielhaft für eine init
public void createSDF(){
    this.sdf = new SimpleDateFormat(this.pattern);
}

//beispielhaft für eine init
public void newPattern(final String pattern) {
    this.pattern = pattern;
}

public String format(final Date date){
    return sdf.fomat(date);
}
```
Hier wird ein SimpleDateFormatter verwendet. Um diesen zu verwenden muss man erst ein Pattern 
angeben nachdem man die Instanz der Klasse erzeugt hat. Hieraus ergibt sich der implezit vorgegebene 
Ablauf in der Verwednung der Methoden.

```java
newPattern("yyyy.MM.dd");
createSDF();
final String s = versionAB.format(new Date());
System.out.println("s = " + s);
```

Implementiere eine Lösung bei der die nachfolgend gezeigte Reihenfolge der Methodenaufrufe 
zu einem gültigen Ablauf führt.

```java
createSDF();
newPattern("yyyy.MM.dd");

final String s = versionAB.format(new Date());
System.out.println("s = " + s);
```



### Lösung CompletableFuture

##CompletionException 1.8 Alle anderen Exceptions seit JDK1.5


##StampedLock
### Coarse Grained Locking
Wie also geht man nun mit der Problematik des Locking um? Eine einfache Methode ist das harte / grobe Locking. 
Hierbei hat man sicherlich eine Menge Probleme umgegangen, jedoch stellt sich auch nicht der gewünschte Erfolg ein. 
Es wird mehr oder weniger alles seriell abgearbeitet, was zur Folge hat, dass nur ein Core der 
verfügbaren CPU´s mit der Lösung der Aufgabe beschäftigt werden kann.

Ziel ist es also eine möglichst ausgeglichene Lockingstrategie, die es ermöglicht möglichst viele Cores gleichzeitig zu verwenden.

### „Good“ and „Bad“ Context Switches
Gehen wir also im folgendem davon aus, dass wir eine erhöhte Auslastung der Cores erreichen. Das bedeutet allerdings auch, 
dass der jeweilige Context für den Thread gewechselt werden muss. Man spricht in diesem Zusammenhang vom ContextSwitch. 
Nun hat es die Natur der Dinge so an sich, dass es gute und schlechte ContextSwitches gibt. 
Was ist nun der „Gute“ und was ist der „Schlechte“ ContextSwitch?

### Der Gute – ContextSwitch:
Hier sprechen wir von einem Thread, der seine zur Verfügung stehende Rechenzeit voll ausnutzen konnte. 
Solch ein Thread Context kann normalerweise innerhalb von einem clock cycle ein „swap out“ erfahren 
und ist offiziell unter dem Begriff „Involuntary Context Switch“ bekannt.

### Der Schlechte – ContextSwitch:
Wir sprechen von einem schlechten ContextSwitch wenn der Thread stoppen muss, da eine benötigte 
Ressource nicht zur Verfügung steht, die von einem anderen suspendierten Thread blockiert wird. 
Man spricht auch von einem „Voluntary Context Switch“. Solch ein Wechsel 
kostet von 1000 bis hin zu n*10.000 clock cycles.

### Independent Tasks With No Locking
Die Verwendung von ausschließlich lokalem Speicher pro Thread! Hier gibt es keine Kollisionen, 
was zu einer 100% Auslastung aller vorhandenen Cores führt. Dieses kann als idealer Zustand angenommen werden. 
Nur leider ist das eher selten zu erreichen in einem größeren System.

### Nonblocking Lock-free Algorithms
Alle Algorithmen die auf Locking basieren sind beeinträchtigt in ihrer Skalierbarkeit. Das wurde durch 
Amdahl´s und Little´s Laws dargestellt. Es stellt sich nun die Frage, wie man Algorithmen ohne Locking konstruiert. 
Hier gibt es zwei Ausrichtungen.

Die erste ist die Gruppe der „Nonblocking“ Algorithmen. Das sind Algorithmen, 
bei denen ein Fehler innerhalb des Ablaufs oder das suspendieren eines Threads 
nicht dazu führen kann, dass andere Threads blockiert werden.

Die zweite Gruppe ist die Gruppe der „Lock-Free“ Algorithmen. Hierbei kann bei 
jedem Schritt ein Thread bei der Durchführung der Aufgabe einen Fortschritt erzielen.

### back to StampedLock
Die Motivation hinter der Klasse ```StampedLock``` ist es, die Locks zu trennen nach lesenden und schreibenden Zugriffen. 
Damit kann man Teile der Anwendung entkoppeln. Es gibt im JDK noch die Klasse ```ReentrantReadWriteLock```. 
Der Nachteil dieser Implementierung ist die Entscheidung, dass immer pessimistisches Locking verwendet wird. 
Damit ist ein Teil der möglichen Geschwindigkeitsoptimierung schon per Definition nicht mehr erreichbar.

Ein weiterer Nachteil der Implementierung der Klasse ```ReentrantReadWriteLock``` ist, dass sie zu starvation neigt, 
wenn gemischt Reader und Writer Threads auf den Lock zugreifen.

Bei Java5 gab es von der Priorität her keinen Unterschied zwischen lesenden und schreibenden Zugriffen. 
Da aber viele Leser zur selben Zeit das ReadLock besitzen konnten, passierte es, dass ein neuer Leser 
das ```ReadLock``` bekam bevor ein zuerst wartendes ```WriteLock``` bedient wurde. So mussten die ```WriteLocks```, 
die ja einen exklusiven Lock benötigten, in manchen Fällen unendlich warten.

Seit Java6 hat man versucht das zu lösen indem man Leser warten lässt wenn vor ihnen ein Schreiber einen 
Antrag auf das Lock gestellt hat. Hier ist das Problem nicht so offensichtlich, aber in unseren 
Experimenten haben wir entdeckt, dass es zu starvation führen kann wenn wir einen Leser 
haben und viele Schreiber. Der Leser bekommt dann fast nie den Lock.

Die Nachteile sind zum Teil die Vorteile von ```StampedLock```. Diese Implementierung bietet ein optimistisches 
Locking für lesende Zugriffe an, das allerdings einfach in pessimistisches Locking überführt werden kann.

Schreibende Zugriffe sind immer pessimistisch, arbeiten also mit exclusive locks und nicht zu vergessen ist, 
dass ein StampedLock non-reentrant (eintritts- bzw ablaufinvariant) ist.

```StampedLock``` ermöglicht uns „Optimistic Locking“, wodurch wir uns den „Bad Context Switch“ bei den 
Lesenvorgängen sparen können. 
Dadurch bekommen wir eine viel bessere Performanz bei Lesevorgängen als mit dem älteren ```ReentrantReadWriteLock```.
Performanter ist der Einsatz von StampedLock sicherlich, aber die Idiome sind leider noch schwieriger zu verstehen.

```java
    private double x, y;
    private final StampedLock sl = new StampedLock();

    // method is modifying x and y, needs exclusive lock
    public void move(double deltaX, double deltaY) {
        long stamp = sl.writeLock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            sl.unlockWrite(stamp);
        }
    }
```
Die Methode ```optimisticRead()``` hingegen versucht zuerst ein optimistisches Lesen, 
indem ein optimistic Read angefordert wird (```tryOptimisticRead()```) um dann nachfolgend die 
benötigten Variablen in lokale Variablen (double currentX = x, currentY =y;) zu kopieren.

Nach dem Kopiervorgang wird überprüft, ob es in der Zwischenzeit einen Schreibzugriff gegeben hat 
(```sl.validate(stamp)```). Dabei ist es immer zu empfehlen, so wenige Anweisungen wie möglich 
innerhalb des optimistic Read durchzuführen. 
Dadurch wird die Wahrscheinlichkeit erhöht, dass es erfolgreich verlaufen wird.

Wenn es einen Schreibzugriff gegeben hat, wird ein pessimistic Read angefordert (```sl.readLock()```) 
und die Variablen werden erneut in lokalen Variablen gespeichert.
Nun kann man davon ausgehen, dass die lokalen Variablen einen in sich geschlossenen Zustand haben. 
Die nachfolgende Verarbeitung kann beginnen.

Dieses Verhalten ist selbst dann noch sinnvoll, wenn eine hohe Anzahl Writer involviert sind. 
Die Performance ist dann immer noch höher im Vergleich zu der Verwendung von ```ReentranReadWriteLocks```. 
Sind die optimistic Reads meist erfolgreich lohnt sich der Mehraufwand eines hin und wieder auftretenden 
pessimistic Read incl der zusätzlichen Kopieraktionen in Summe dennoch. In Summe ist eine Reduktion 
der gesamt notwendigen clock cycles erfolgt.

```java
  private double x, y;
  private final StampedLock sl = new StampedLock();

  // method is modifying x and y, needs exclusive lock
  public void move(double deltaX, double deltaY) {
    long stamp = sl.writeLock();
    try {
      x += deltaX;
      y += deltaY;
    } finally {
      sl.unlockWrite(stamp);
    }
  }

  //…
  public double distanceFromOrigin() {
    long stamp = sl.tryOptimisticRead();
    double currentX = x, currentY = y;
    if (!sl.validate(stamp)) {
      stamp = sl.readLock();
      try {
        currentX = x;
        currentY = y;
      } finally {
        sl.unlockRead(stamp);
      }
    }
    return Math.hypot(currentX, currentY);
  }

  public boolean moveIfAt(double oldX, double oldY,
                          double newX, double newY) {
    long stamp = sl.readLock();
    try {
      while (x == oldX && y == oldY) {
        long writeStamp = sl.tryConvertToWriteLock(stamp);
        if (writeStamp != 0L) {
          stamp = writeStamp;
          x = newX;
          y = newY;
          return true;
        } else {
          sl.unlockRead(stamp);
          stamp = sl.writeLock();
        }
      }
      return false;
    } finally {
      sl.unlock(stamp);
    }
  }

```

Die Verwendung von StampedLock ist fast immer vorteilhaft. Tests haben gezeigt, 
dass der Schreibzugriff sich ähnlich schnell verhält wie bei einem ```ReadWriteLock```. 
Zu wesentlich mehr Perfomancegewinnen kommt es bei der Verwendung des ```ReadLocks```. 
Hier werden teilweise beachtliche SpeedUps von 10 bis 100 erreicht. Grund dessen ist 
die Möglichkeit das optimistic Read verwenden zu können. Wird das allerdings in der 
Verwendung nicht beachtet, fallen die Leistungswerte stark ab.

### Übung StampedLock
### Lösung StampedLock


