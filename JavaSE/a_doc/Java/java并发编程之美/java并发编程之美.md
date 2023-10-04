# 一.并发编程基础

## 1.并发、并行

**CPU与线程**：

在CPU眼里，没有进程的概念，一个CPU同一时刻只能执行一个线程，不管是哪个进程的，所以一个进程下的多个线程可以在不同CPU同时执行。真正要占用CPU运行的是线程，所所以也说线程是CPU分配的基本单位。

操作系统是为每个线程分配一个时间片来使用CPU，正常情况下当一个线程把分配给自己的时间片使用完后，线程调度器才会进行下一轮的线程调度。

所以在单 CPU 时代多线程编程是没有太大意义的，并且线程间频繁的上下文切换还会带来额外开销。

**并发**：当有多个线程在操作时，如果系统只有一个CPU，只能把CPU运行时间划分成若干个时间段，再将时间段分配给各个线程执行，在一个时间段的线程代码运行时，其它线程处于挂起状。这种方式我们称之为并发(Concurrent)。

**并行：**当系统有多个CPU时，则线程的操作有可能非并发。当一个CPU执行一个线程时，另一个CPU可以执行另一个线程，两个线程互不抢占CPU资源，可以同时进行，这种方式我们称之为并行(Parallel)。

## 2.进程、线程

在Java中，当我们启动main函数时其实就启动了一个口！M的进程，而main函数所 在的线程就是这个进程中的一个线程，也称主线程。

![QQ截图20230916173413](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ截图20230916173413.png)

一个进程中有多个线程，多个线程共享进程的堆和方法区资源， 但是每个线程有自己的程序计数器和栈区域。

- 堆：进程的一个资源区，被该进程的所有线程共享，存储对象实例。
- 方法区：存放JVM加载的类、常量及静态变量等信息，也是线程共享的。

- 程序计数器：用来记录线程当前要执行的指令地址。线程从挂起到运行态，cpu要知道从哪个位置开始执行。

  另外需要注意的是，如果执行的是native方法， 那么pc计数器记录的是undefined地址，只有执行的是Java代码时pc计数器记录的才是 下一条指令的地址。

- 栈：用于存储该线程的局部变量，还用来存放线程的调用栈帧。

## 3.线程的生命周期

![QQ20230813-120815@2x](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ20230813-120815@2x.png)

### 3.1 线程状态

- NEW：初始状态，线程被构建，但是还没有调用 start()方法。
- RUNNABLE：可运行状态，包括：**运行中状态**和**就绪状态**。
- BLOCKED：阻塞状态，处于这个状态的线程需要等待其他线程释放锁或者等待进入 synchronized。 
- WAITING：表示等待状态，处于该状态的线程需要等待其他线程对其进行通知或中断等操作，进而进入下一个状态。
- TIME_WAITING：超时等待状态。可以在一定的时间自行返回。
- TERMINATED：终止状态，当前线程执行完毕。

### 3.2 方法

**object方法**：

- **wait()**：当一个线程调用一个共享变量的wait()方法时，该调用线程会被阻塞挂起，进入等待队列，并释放该线程所拥有的锁，直到发生下面几件事之一才返回：

  1. 其他线程调用了该共享对象的notify()或者notifyAll()方法；
  2. 其他线程调用了该线程的interrupt()方法，该线程抛出InterruptedException异常返回。

  注意：

  1. 如果调用wait方法的线程没有事先获取该对象的**监视器锁**，则调用wait()方法时调用线程会抛出IllegalMonitorStateException异常。所以一般在同步代码块中使用。

     ```java
     # 使用该共享变量作为参数。
     synchronized（共享变量）｛
         // do something
     }
     
     # 调用该共享变量的方法，并且该方法使用了synchronized修饰。
     synchronized void add （工nta, int b) { 
     	//do something 
     }
     ```

  2. 一个线程可以从挂起状态变为可以运行状态（也就是被唤醒），即使该线程没有被其他线程调用notify()、notifyAll()方法进行通知，或者被中断，或者等待超时，这就是所谓的虚假唤醒。

     虽然虚假唤醒在应用实践中很少发生，但要防患于未然。

     ```java
     synchronized (obj) { 
     	if (条件) {
     		obj.wait();
         }
     }
     ```

- wait(long timeout）：多了一个超时参数。

  如果一个线程调用共享对象的该方法挂起后，没有在指定的timeoutms时间内被其他线程调用该共享变量的 notify（）或者notifyAll（）方法唤醒，那么该函数还是会因为超时而返回。

  timeout为0则和wait()方法一样，因为wait()方法内部就是调用了wait(0)；如果为负数，则抛Illega!ArgumentException异常。

- wait(long timeout, int nanos）：内部调用的是wait(long timeout），只有nanos>0时才使参数 timeout递增1。

- notify（）：一个线程调用共享对象的notify（）方法后，会**随机**唤醒一个**在该共享变量上**调用wait系列方法后被挂起的线程。

  被唤醒的线程不能马上从wait方法返回并继续执行，它**必须等获取了共享对象的监视器锁后才可以**；也就是说，被唤醒后要竞争到锁后才可以继续执行。

  注意：类似wait，只有当前线程获取到了共享变量的监视器锁后，才可以调用共享变量的notify（）方法，否则会抛出IllegalMonitorStateException异常。

- notifyAll（）：会唤醒**所有**在该共享变量上由于调用wait系列方法而被挂起的线程。

---

**Thread方法：**

- **start()**：开始一个线程。

  调用start方法后线程并没有马上执行而是处于**就绪状态**，这个就绪状态是指该线程已经获取了除CPU资源外的其他资源，等待获取CPU资源后才会真正处于**运行状态**。

- **join（）**：A线程执行了B线程调用join（）方法，A线程会等到B线程执行完毕才能执行。这时候，当其他线程调用了线程A的 interrupt（）方法中断了线程A时，线程A会抛出InterruptedException异常而返回。

- **sleep（）**：调用了Thread的sleep()方法的线程会暂时让出指定时间的执行权，但是该线程所拥有的监视器资源，比如锁还是持有不让出的。

  指定的睡眠时间到了后该函数会正常返回，线程就处于就绪状态，然后参与CPU的调度，获取到CPU资源后就可以继 续运行了。

  如果在睡眠期间其他线程调用了该线程的interrupt（）方法中断了该线程，则该线程会在调用sleep方法的地方抛出IntermptedException异常而返回。

- **yield（）**：当一个线程调用yield方法时，实际就是在暗示线程调度器，**请求让出自己的CPU使用**，可以进行下一轮线程调度了，但是线程调度器可以无条件忽略这个暗示。

  线程调用yield方法时，当前线程会让出CPU使用权，然后处于就绪状态，线程调度器会从线程就绪队列里面获取一个线程优先级最高的线程，当然也有可能会调度到 刚刚让出CPU的那个线程来获取CPU执行权。

Java中的线程中断是一种线程间的协作模式，通过设置线程的中断标志并不能直接终止该线程的执行，而是被中断的线程根据中断状态自行处理。

- **void interrupt（）**：中断线程。当线程A运行时，线程B可以调用线程A的interrupt()方法来**设置线程A的中断标志为true**并立即返回。

  设置标志仅仅时设置标志，实际上线程A并没有被中断，会继续执行。

  如果线程A因为调用了 wait系列函数、join方法或者sleep方法而被阻塞挂起，这时候若线程B调用线程A的interrupt（）方法，线程A会在调用这些方法的地方抛出InterruptedException异 常而返回。

- **boolean isinterrupted（）**：检测**当前线程**是否被中断，如果是返回true，否则返回false。

- **boolean interrupted**（）：检测**当前线程**是否被中断，如果是返回true，否则返回false。

  不同的是，该方法如果发现当前线程被中断，则会清除中断标志，并且**该方法是static方法**，可以通过Thread类直接调用。所以这个”当前线程“是指执行interrupted（）的线程。

## 4.线程上下文切换

一个CPU同一时刻只能被一个线程使用，CPU资源采用时间片轮转的策略给线程分配执行时间。

线程使用完后，就会处于就绪状态，并让出CPU让其他线程使用，这就是上下文切换。

上下文切换时机：

- 时间片用完。
- 当前线程被其他线程中断。

## 5.线程死锁

指两个或两个以上的线程在执行过程中，因争夺资源而造成的互相等待的现象， 在无外力作用的情况下，这些线程会一直相互等待而无法继续运行下去。

![QQ截图20230916230329](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ截图20230916230329.png)

死锁的产生必须具备以 下四个条件：

1. 互斥条件：线程已获得的资源同一时间只有一个线程占用。
2. 请求并持有条件：一个线程持有至少一个资源，但又请求新资源，而新资源被另一个线程占有，所以当前线程被阻塞，但阻塞的同时并不能释放自己已获取的资源。
3. 不可剥夺条件：线程获得的资源在使用完之前不能被其他线程抢占。
4. 环路等待条件：发生死锁时，必然存在一线程一资源的环形链。

## 6.守护线程与用户线程

java线程分为两类：daemon线程（守护线程）、user线程（用户线程）

在NM启动时会调用main函数，main函数所在的钱程就是一个用户线程，其实在JVM 内部同时还启动了好多守护线程，比如垃圾回收线程。

当最后一个非守护线程结束时，JVM会正常退出，而不管当前是否有守护线程。

## 7.Thread Local 

ThreadLocal内部维护了一个map，当要set值的时候，**以当前线程**作为key，所以每次get都是当前线程的资源。

**ThreadLocal 内存泄漏**：

![QQ20230731-154125@2x](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ20230731-154125@2x.png)

`ThreadLocal`是一个弱引用，当为`null`时，会被当成垃圾回收 。

**假如我们ThreadLocal是null了，也就是要被垃圾回收器回收了，但是此时我们的ThreadLocalMap（thread 的内部属性）生命周期和Thread的一样，它不会回收，这时候就出现了一个现象。那就是ThreadLocalMap的key没了，但是value还在，这就造成了内存泄漏。**

解决办法：使用完`ThreadLocal`后，执行`remove`操作，避免出现内存溢出情况。

**为什么key使用弱引用？**

如果使用强引用，当`ThreadLocal` 对象的引用（强引用）被回收了，`ThreadLocalMap`本身依然还持有`ThreadLocal`的强引用，如果没有手动删除这个key ,则`ThreadLocal`不会被回收，所以只要当前线程不消亡，`ThreadLocalMap`引用的那些对象就不会被回收， 可以认为这导致`Entry`内存泄漏。

**Threadlocal不支持继承性**

同一个ThreadLocal变量在父线程中被设置值后，在子线程中是获取不到的。

那么有没有办法让子线程能访问到父线程中的值？

**lnheritableThreadLocal类**

继承自ThreadLocal，其提供了一个特性，就是让子线程可以访问在父线程中设置的本地变量。

InheritableThreadLocal的世界里，变量inheritableThreadLocals替代了 threadLocals。

在Thread构造方法中：

```java
if (inheritThreadLocals && parent.inheritableThreadLocals != null)
            this.inheritableThreadLocals =
            ThreadLocal.createInheritedMap(parent.inheritableThreadLocals);
```

如果父线程的inheritableThreadLocals不为null，则以父线程的inheritableThreadLocals创建一个副本给子线程

# 二.java并发安全

## 1.Java 中共享变量的内存可见性问题

Java内存模型规定，当线程要使用共享变量时，会先从主内存中拷贝一份到自己的工作内存，进行读写，然后更新到主空间。

![微信截图_20230917202605](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\微信截图_20230917202605.png)

实际实现中线程的工作内存：

![QQ截图20230918172012](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ截图20230918172012.png)

这是一个双核CPU系统架构，每个核有自己的控制器、运算器。其中控制器包含一组寄存器和操作控制器，运算器执行算术逻辅运算。每个核都有自己的一级缓存，所有CPU共享的二级缓存。

假设线程A和线程B使用**不同CPU**同时处理一共享变量，并且当前两级Cache都为空，那么这时候由于Cache的存在，将导致内存不可见问题。

- 线程A首先获取共享变量X的值，由于两级Cache都没有命中，所以加载主内存的X的值，假如为0。然后把X=0缓存到两级Cache。

  线程A修改X的值为1，然后写入到两级Cache，并且刷新到主内存。

  线程A操作完后，两级Cache的X的值都是1。

- 线程B获取X的值，首先一级缓存没有命中，二级缓存命中了，返回X=1；

  线程B修改X的值为2，然后写入到两级Cache，并且刷新到主内存。

  线程B操作完后，两级Cache的X的值都是2。

- 线程A又要修改X的值，此时一级缓存命中，X=1。这就有问题了，因为主空间中X=2。

  这就是共享变量内存不可见问题，B写入的值，对A不可见。

解决办法：使用volatile关键字。

## 2.synchronized 关键字

### 2.1 介绍

synchronized块是java提供的一种原子性内置锁（监视器锁），是排它锁。每个对象都可以把他当作一个同步锁使用。

进入synchronized代码块前会自动获取内部锁，这时候其他线程访问该同步代码块就会被阻塞挂起。这种排他锁的方式保证了操作的**原子性**。

拿到内部锁的线程会在正常退出同步代码块、抛异常、同步块调用了该内置锁资源的wait系列方法时，释放该内置锁。

由于java的线程与操作系统的原生线程一一对应，所以当阻塞一个线程时，需用从用户态切换到内核态执行阻塞操作，这很耗时，而synchronized的使用就会导致上下文切换。

### 2.2 synchronized的内存语义

- 进入synchronized的内存语义是，把在synchronized块内使用到的变量从线程的工作内存中清除，这样在synchronized块内使用该变量就不会从工作空间的一级缓存中获取，而是直接从主内存中获取。
- 退出synchronized块的语义是，把在synchronized块内对共享变量的修改刷新到主内存。

这其实也是加锁和释放锁的语义。synchronized通过这种加锁的方式**解决可见性问题**。

## 3.volatile关键字

synchronized通过加锁方式解决内存可见性问题，但是使用锁太笨重，因为会带来线程上下文切换开销。

volatile关键字提供弱形式的同步，确保一个变量的更新对其他线程马上可见。采用非阻塞算法，不会带来上下文切换开销。

当一个变量被声明为volatile时，线程在写入变量时不会把值缓存在寄存器或其他地方，而是直接刷回主内存。当其他线程来读取时，回从主内存重新获取，而不是在自己的工作空间中。

volatile的内存语义是：

- 当线程读取volatile变量时，就相当于进入同步代码块（先清空本地内存变量值，再从主内存获取）
- 当线程写入volatile变量时，就相当于退出同步代码块（把写入工作内存的变量值同步到主内存）

volatile保证了可见性，但不保证原子性，那什么时候用volatile关键字呢：

- 写入的变量值不依赖当前值时。如果依赖当前值，将是`获取——计算——写入`三步操作。
- 读写变量值没有加锁。因为加锁本身就保证了可见性。

## 4.java中的CAS

锁会带来线程上下文切换开销，而volatile关键字只能保证可见性。

JDK提供的CAS非阻塞原子性操作，它通过硬件保证操作的原子性。

Unsafe的一系列compareAndSwapLong方法原理：比较再交换。如果比较后是预期值，则更新，否则重新读取主空间值重新处理，直到达到预期值。

但这会出现**ABA问题**，假如线程1拿到X=A，尝试CAS修改成X=B前，线程2拿到X=A，使用CAS修改为B，又使用CAS修改为A，此时线程1再去CAS修改为B肯定是成功的，但是这个A已经不是原来的哪个A了。

JDK AtomicStampedReference 类给每个变量状态值都配备了一个时间戳，避免了ABA问题。

## 5.java指令重排

java内存模型允许编译器和处理器对指令重排序以提高性能，只会对不存在数据依赖性的指令重排序。

```java
int a = 1;
int b = 2;
int c = a + b;
```

变量c依赖了a、b，所以重排序后能保证第3步在1、2之后执行，但是不能保证1、2谁先执行。

volatile可以避免指令重排序问题。

- 写volatile变量时，确保volatile写之前的操作不会被编译器重排序到volatile写之后。
- 读volatile变量时，可以确保volatile读之后的操作不会被编译器重排序到volatile读之前。

## 6.伪共享

### 6.1 介绍

为了解决主内存与CPU之间运行速度差，会再CPU与主内存之间添加一级或多级高速缓冲存储器(Cache)。

Cache内部是按行存储，每一行称为一个Cache行。是Cache与主内存进行数据交换的单位，Cache行大小是2的幂次数字节。

![QQ截图20230918173546](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ截图20230918173546.png)

当CPU访问某个变量时，会先去Cache内找，找不到再去主内存拿。然后把变量所在内存的`一个Cache行大小的内存`复制到Cache中。所以可能会把多个变量放在一个Cache行中。

而缓存是有容量限制的，缓存满了后会根据淘汰算法替换缓存行。

```java
# 操作1
for (int i = 0; i < LINE_NUM; i++) {
    for (int j = 0; j < COLUM_NUM; j++) {
        arr[i][j] = i*2+j;
    }
}

# 操作2
for (int i = 0; i < LINE_NUM; i++) {
    for (int j = 0; j < COLUM_NUM; j++) {
        arr[j][i] = i*2+j;
    }
}
```

> 很明显，方式1比方式2要快很多。
>
> - 方式1中每次操作的元素，内存地址是连续的，基本每次访问都可以在缓存中命中，就不需要去主内存中找。
> - 方式2中每次操作的元素是跳跃的，所以会经常从主内存复制缓存行，而很多缓存行的变量还没被读取，就又被替换了。

当多个线程同时修改一个缓存行里面的多个变量时，由于同时只能有一个线程操作缓存行，所以性能会下降，这就是**伪共享**。

![QQ截图20230918180704](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ截图20230918180704.png)

图中，变量x、y同时被放在了CPU一级和二级缓存。

当线程1对x进行更新时，首先会修改CPU1一级缓存中变量x所在缓存行，这时候再缓存一致协议下，CPU2变量x对应的缓存行失效。那么线程2再修改x时，只能去二级缓存中找。

这说明多个线程不能同时修改自己CPU中相同缓存行的变量。更坏的情况是，如果CPU只有一级缓存，则会导致频繁访问主内存。

### 6.2 如何避免伪共享

JDK8之前一般通过字节填充的方式。创建一个变量时，使用填充字段填充该变量所在缓存行，避免多个变量放在同一缓存行，如：

```java
public long value; // 变量
public long p1, p2, p3, p4, p5, p6; // 填充变量
```

> 假设缓存行为64字节，那么我们填充了6个long类型变量，每个占8字节，上面一共就是56字节。而类对象的字节码的对象头占8个，总共应该是64字节，正好放入一个缓存行。

JDK8提供了一个@sun.misc.Contended注解来解决伪共享问题，可以修饰类和变量。默认情况下只能用于java核心类，如rt包下的类。用户类需要添加JVM参数：-XX:-RestrictContended。默认填充宽度是128，可以使用-XX:ContendedPaddingWidth

## 7.锁概念

**乐观锁与悲观锁**：

- 悲观锁：值对数据被外界修改保持保守态度，认为数据很容易被其他线程修改，所以对数据处理前加锁，在处理过程中一直保持锁定状态。

- 乐观锁：相对于悲观锁说的，认为数据在一般情况下不会被其他线程修改，所以在访问前不会加排他锁，而是在进行数据提交更新时，才检测数据是否冲突。

---

根据获取锁的抢占机制，分为**公平锁与非公平锁**：

- 公平锁：表示线程获取锁的顺序是按照线程请求锁的时间早晚来决定的。
- 非公平锁：在运行时闯入，不一定先到先得。

在没有公平性需求时，尽量使用非公平锁，因为公平锁会带来性能开销。

---

根据线程持有情况，分为**独占锁与共享锁**：

- 独占锁：如何时候保证只有一个线程能得到锁。是一种悲观锁。
- 共享锁：可以被多个线程得到，是一种乐观锁，如ReadWriteLock读写锁的读锁。

**可重入锁**：一个线程获取其他线程持有的锁时，会被阻塞。那当一个线程再次获取自己的锁，如果不会被阻塞，就是可重入锁。一般都严格限制了可重入次数。

synchronized内部是可重入锁。

可重入锁的原理：

> 是锁内部维护一个线程标识，标识被哪个线程占用，如何关联了一个计数器。
>
> 一开始为0，表示没有被任何线程占用。当一个线程获取了该锁时，计数器变为1，这时其他线程再来获取该锁就会被阻塞。
>
> 但是当获取了该锁的线程再次获取锁，计数器会+1，当释放锁后计数器-1。
>
> 当计数器为0，锁的线程标识被重置为null，这时会唤醒被阻塞的线程来竞争

**自旋锁**：

由于Java中的线程与操作系统中的线程时一一对应的，所以当一个线程获取锁失败后，会被切换到内核态而被挂起。当线程获取到锁时又需要切换到内核态而唤醒该线程。从用户态切换到内核态是开销比较大的。

自旋锁则是，当线程获取锁时，如果发现锁被其他线程占有，它不会马上阻塞自己，在不放弃CPU使用权情况下，多尝试几次获取（默认10，也可以设置JVM参数），在这几次尝试期间，其他线程有可能就释放了。尝试指定次数后仍没有获取到锁，才会被阻塞挂起。

自旋锁使用CPU时间换取线程阻塞与调度开销，但是很有可能白白浪费CPU时间。

# 三.ThreadLocalRandom类

## 1.Random类及其局限性

java.util.Random会根据老种子生成新种子，多线程情况下可能就会拿到同一个老种子。

为了避免这种问题，Random每次生成的种子都保存在原子变量AtomicLong中，使用CAS进行原子更新。

由于只有一个线程更新成功，所以会造成大量线程进行自选重试，降低性能，因此ThreadLocalRandom应运而生。

## 2.ThreadLocalRandom

ThreadLocalRandom通过ThreadLocal让每个线程都有自己的一份变量，避免了对共享变量进行同步。

![QQ截图20230919114949](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ截图20230919114949.png)

ThreadLocalRandom继承了Random并重写了nextInt，但并没有继承Random的原子性种子变量。具体的种子存放在具体调用线程的threadLocalRandomSeed中。

ThreadLocalRandom类似于ThreadLocal类，是个工具类。当线程调用ThreadLocalRandom的current方法时，ThreadLocalRandom负责初始化调用线程的threadLocalRandomSeed变量，也就是初始化种子。

当调用ThreadLocalRandom的nextInt方法时，就是获取当前线程的threadLocalRandomSeed变量，来计算随机数。

seeder和probeGenerator是两个原子性变量，在初始化调用线程的种子和探针变量时会用到，每个线程只会使用一次。

变量instance是ThreadLocalRandom的一个实例，当多线程通过ThreadLocalRandom的current方法获取ThreadLocalRandom实例时，获取的是同一个实例。由于具体的种子是放在线程里面的，所以在ThreadLocalRandom的实例里面只包含与线程无关的通用算法，所以是线程安全的。

# 四.JUC包原子操作类原理

JUC包提供了一系列原子性操作类，这些类都是使用非阻塞算法CAS实现的。

## 1.AtomicLong剖析

```java
public class AtomicLong extends Number implements java.io.Serializable {
    // 获取Unsafe实例
    private static final jdk.internal.misc.Unsafe U = jdk.internal.misc.Unsafe.getUnsafe();
    
    // 存放变量value的偏移量
    private static final long VALUE = U.objectFieldOffset(AtomicLong.class, "value");
    
    // 判断JVM是否支持Long类型无锁CAS
    static final boolean VM_SUPPORTS_LONG_CAS = VMSupportsCS8();
    private static native boolean VMSupportsCS8();
    
    // 实际变量值
    private volatile long value;
}
```

方法：

```java
// 调用unsafe方法，原子性设置value加1，然后返回
public final long incrementAndGet() {
        return U.getAndAddLong(this, VALUE, 1L) + 1L;
}
```

Unsafe的getAndAddLong方法是原子性操作，param1是AtomicLong实例引用，param2是value变量在AtomicLong中的偏移量，param3是要偏移的量。

JDK7的AtomicLong使用的是循环CAS修改变量，JDK8中已经 将该操作 内置到Unsafe中了，因为考虑到其他函数也会用到。

虽然CAS阻塞算法性能比同步锁要性能好，但在高并发情况下CAS算法还会存在性能问题。

JDK8提供的LongAdder类，在高并发性能下更好。

## 2.JDK8新增原子类LongAdder

前面的AtomicLong通过CAS提供的非阻塞算法性能已经很好了，但是在高并发下大量线程会同时竞争更新同一个原子变量，但由于只有一个线程能CAS操作成功，这会造成大量线程竞争失败后，通过无限循环不断尝试CAS操作，这会白白浪费CPU资源。

因此JDK8新增LongAdder用来克服高并发下AtomicLong的缺点。

既然AtomicLong的性能瓶颈是由于过多线程同时去竞争一个变量的更新产生的，那么可以**把一个变量分解成多个变量**，让同样多的线程去竞争多个资源。

![QQ截图20230919124635](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ截图20230919124635.png)

LongAdder内部维护了多个Cell，每个Cell的初始值为0。相同并发量的情况下，变相地减少了并发量。另外，多个线程在争夺同一个Cell失败，线程并不是在当前Cell上一直自旋CAS重试，而是会尝试在其他Cell上自旋，这增加了线程自旋的成功性。

最后，在获取LongAdder当前值时，是把所有Cell变量的value累加在base上返回。

LongAdder内部维护了一个Cell数组，初始是null，因为Cell数组占内存比较大，使用懒加载初始化。

Cell数组为null且并发数比较少时，所有的累加操作都是对base变量操作。

Cell类型是对AtomicLong的改进，用来减少缓存的争用，解决伪共享问题。

对于大多数孤立的多个原子操作进行字节填充是浪费，因为原子操作都是无规律地分散在内存中，多个原子变量放在同一缓存行的可能性很小。

## 3.LongAdder剖析

问题：

1. LongAdder的结构时怎么样的？
2. 当前线程应该访问Cell数组的哪一个元素？
3. 如何初始化Cell数组？
4. Cell如何扩容？
5. 线程访问分配的Cell元素有冲突如何处理？
6. 如何保证线程操作被分配的Cell原子性？

![QQ截图20230919152347](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ截图20230919152347.png)

LongAdder继承自Striped64，Striped64内部维护着三个变量。

LongAdder的真实值时base的值与Cell数组所有元素 累加 的值。

base是个基础值，默认是0。

cellsBusy用来实现自旋锁，状态是0和1，当创建Cell、扩容cells、初始化cells时，使用CAS操作该变量，保证只有一个线程可以进行操作。

```java
public long sum() {
    Cell[] cs = cells;
    long sum = base;
    if (cs != null) {
        for (Cell c : cs)
            if (c != null)
                sum += c.value;
    }
    return sum;
}
```

> 返回当前值。累加所有的cell后累加base的值。
>
> 内部没有加锁，所以返回的值不精确

```java
public void reset() {
    Cell[] cs = cells;
    base = 0L;
    if (cs != null) {
        for (Cell c : cs)
            if (c != null)
                c.reset();
    }
}
```

> 将base和cell所有元素重置为0

```java
public void add(long x) {
    Cell[] cs; long b, v; int m; Cell c;
    if ((cs = cells) != null || !casBase(b = base, b + x)) { //（1）
        boolean uncontended = true;
        if (cs == null || (m = cs.length - 1) < 0 || //（2）
            (c = cs[getProbe() & m]) == null || //（3）
            !(uncontended = c.cas(v = c.value, v + x))) //（4）
            longAccumulate(x, null, uncontended); //（5）
    }
}
```

> 代码（1）判断cells是否为null，如果为null则在base上累加。如果不为null或者线程执行到代码（1）的CAS操作失败，则会执行代码（2）。
>
> 代码（2）（3）决定当前线程访问cells数组的哪个元素，如果当映射的元素存在，则执行代码（4），使用CAS操作更新该元素，如果映射的元素不存在或者CAS失败则执行代码（5）

longAccumulate很重要的一个方法，cells初始化和扩容的地方

```java
final void longAccumulate(long x, LongBinaryOperator fn,
                          boolean wasUncontended) {
	// （6）初始化当前线程的threadLocalRandomProbe
    int h;
    if ((h = getProbe()) == 0) {
        ThreadLocalRandom.current(); // force initialization
        h = getProbe();
        wasUncontended = true;
    }
    boolean collide = false;                // True if last slot nonempty
    done: for (;;) {
        Cell[] cs; Cell c; int n; long v;
        if ((cs = cells) != null && (n = cs.length) > 0) { // （7）
            if ((c = cs[(n - 1) & h]) == null) { //（8）
                if (cellsBusy == 0) {       // Try to attach new Cell
                    Cell r = new Cell(x);   // Optimistically create
                    if (cellsBusy == 0 && casCellsBusy()) {
                        try {               // Recheck under lock
                            Cell[] rs; int m, j;
                            if ((rs = cells) != null &&
                                (m = rs.length) > 0 &&
                                rs[j = (m - 1) & h] == null) {
                                rs[j] = r;
                                break done;
                            }
                        } finally {
                            cellsBusy = 0;
                        }
                        continue;           // Slot is now non-empty
                    }
                }
                collide = false;
            }
            else if (!wasUncontended)       // CAS already known to fail
                wasUncontended = true;      // Continue after rehash
            // （9）当前Cell存在，则执行CAS设置
            else if (c.cas(v = c.value,
                           (fn == null) ? v + x : fn.applyAsLong(v, x)))
                break;
            // （10）如果当前Cell数组元素个数大于CPU个数
            else if (n >= NCPU || cells != cs)
                collide = false;            // At max size or stale		
            // （11）是否有冲突
            else if (!collide)
                collide = true;
            // （12）如果元素个数没有达到CPU个数且有冲突则扩容
            else if (cellsBusy == 0 && casCellsBusy()) {
                try {
                    if (cells == cs)        // Expand table unless stale
                        // （12.1）
                        cells = Arrays.copyOf(cs, n << 1);
                } finally {
                    // （12.2）
                    cellsBusy = 0;
                }
                collide = false;
                continue;                   // Retry with expanded table
            }
            // （13）为了找到一个空闲的Cell，重新计算hash值，xorshift算法生成随机数
            h = advanceProbe(h);
        }
        // （14）初始化cell数组
        else if (cellsBusy == 0 && cells == cs && casCellsBusy()) {
            try {                           // Initialize table
                if (cells == cs) {
                    // （14.1）
                    Cell[] rs = new Cell[2];
                    // （14.2）
                    rs[h & 1] = new Cell(x);
                    cells = rs;
                    break done;
                }
            } finally {
                // （14.3）
                cellsBusy = 0;
            }
        }
        // Fall back on using base
        else if (casBase(v = base,
                         (fn == null) ? v + x : fn.applyAsLong(v, x)))
            break done;
    }
}
```

- 当每个线程第一次执行到代码（6）时，会初始化当前线程变量threadLocalRandomProbe，找个变量在计算当前线程应该被分配到哪个cell时会用到。

- cells数组初始化实在代码（14）中进行的，其中cellsBusy是一个标示。0说明cells没有被初始化或扩容，也没有心在cell元素。1说明cells被初始化或扩容，或者当前在创建新的cell元素，通过CAS操作的casCellsBusy方法来进行0、1状态切换。

- 假设当前线程通过CAS设置cellsBusy为1，则当前线程开始初始化操作，那么这时候其他线程就不能进行扩容了。

  如代码（14.1）初始化数组个数为2，然后`h & 1`计算当前线程应该访问cell哪一个位置，也就是使用当前线程的`threadLocalRandomProbe & (cells元素个数-1)`，然后标示cells已经被初始化。

  最后代码（14.3）重置了cellsBusy标记。虽然没有使用CAS操作，却是线程安全的，因为cellsBusy是volatile的，而且其他地方没有机会修改cellsBusy。

  这里初始化cells容量为2，但是两个元素都是null

- cells扩容在代码（12），对cell扩容是有条件的，就是代码（10）（11）的条件都不满足的时候。也就是当前cells元素个数小于CPU个数且当前多线程访问一个cell元素，从而导致冲突使其中一个线程CAS失败时才进行扩容。

  为什么要小于CPU个数呢，因为只有当每个CPU都运行一个线程的时候，才会使多线程效果最佳。也就是每个cell都使用一个CPU进行处理，这时的性能最佳的。

  代码（12）中的扩容操作也是先通过CAS设置cellsBusy为1，然后才进行扩容。假设CAS成功，则执行代码（12.1）将容量扩大2倍，并且复制Cell元素到扩容后的数组，这些元素目前还是null

- 代码（7）（8），计算出要访问的元素，如果为null，则新增一个Cell到cells，并且添加前要设置cellsBusy为1。

- 代码（13）对CAS失败的线程重新计算当前线程的随机值threadLocalRandomProbe，以减少访问cell元素时的冲突。

## 4.LongAccumulator类原理

LongAdder是LongAccumulator的一个特例，LongAccumulator比LongAdder更强大

```java
public class LongAccumulator extends Striped64 implements Serializable {

    private final LongBinaryOperator function;
    private final long identity;
    
    public LongAccumulator(LongBinaryOperator accumulatorFunction,
                           long identity) {
        this.function = accumulatorFunction;
        base = this.identity = identity;
    }
}
```

accumulatorFunction是一个双目运算接口，根据输入的两个参数返回一个计算值。

identity是LongAccumulator的累加值。

调用LongAdder相当于使用下面方式调用LongAccumulator：

```java
LongAdder adder = new LongAdder();

LongAccumulator accumulator = new LongAccumulator(new LongBinaryOperator() {
    @Override
    public long applyAsLong(long left, long right) {
        return left + right;
    }
}, 0);
```

LongAccumulator相比于LongAdder，可以为累加器提供非0的初始值。

另外，还可以指定累加规则。

# 五.JUC包List源码解析

JUC中并发List只有CopyOnWriteArrayList。是并发安全的，对其修改操作都是在底层的一个 数组快照 上进行的，也就是写时复制策略。

![QQ截图20230920234613](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ截图20230920234613.png)

- array数组用来存放具体元素，被volatile修饰
- lock独占锁用来保证只有一个线程进行修改array

问题：

1. 如何初始化list，初始元素个数多少，list有大小限制吗？
2. 如何保证线程安全？
3. 如何保证使用迭代器遍历list时的数据一致性？

```java
// 创建一个大小为0的Object数组
public CopyOnWriteArrayList() {
    setArray(new Object[0]);
}

// 将入参的数组元素拷贝到新创建的list
public CopyOnWriteArrayList(E[] toCopyIn) {
    setArray(Arrays.copyOf(toCopyIn, toCopyIn.length, Object[].class));
}

// 入参为集合，将集合中的元素复制到本地list
public CopyOnWriteArrayList(Collection<? extends E> c) {
    Object[] es;
    // 如果是同一个类型，直接将该集合的数组拿出来
    if (c.getClass() == CopyOnWriteArrayList.class)
        es = ((CopyOnWriteArrayList<?>)c).getArray();
    // 如果不是同一类型，将该集合数组元素拷贝到新数组
    else {
        es = c.toArray();
        if (c.getClass() != java.util.ArrayList.class)
            es = Arrays.copyOf(es, es.length, Object[].class);
    }
    setArray(es);
}
```

```java
public boolean add(E e) {
    // 同步锁
    synchronized (lock) {
        // 获取数组array快照
        Object[] es = getArray();
        int len = es.length;
        // 以array为副本复制新的数组，长度比原来大1
        es = Arrays.copyOf(es, len + 1);
        // 将元素保存到新数组末尾
        es[len] = e;
        // 新数组替换原来的数组
        setArray(es);
        return true;
    }
}

public void add(int index, E element) {
    // 同步锁
    synchronized (lock) {
        // 获取数组array快照
        Object[] es = getArray();
        int len = es.length;
        // 如果index大于数组长度，或者小于0，抛异常
        if (index > len || index < 0)
            throw new IndexOutOfBoundsException(outOfBounds(index, len));
        // 定义一个新数组
        Object[] newElements;
        // 计算要移动的个数
        int numMoved = len - index;
        // 说明是插入到末尾
        if (numMoved == 0)
            newElements = Arrays.copyOf(es, len + 1);
        // 说明不是插入到末尾，将旧数组元素，拷贝到新数组指定位置
        else {
            newElements = new Object[len + 1];
            System.arraycopy(es, 0, newElements, 0, index);
            System.arraycopy(es, index, newElements, index + 1,
                             numMoved);
        }
        // 插入到新数组
        newElements[index] = element;
        // 新数组替换原来的数组
        setArray(newElements);
    }
}
```

```java
public E get(int index) {
    return elementAt(getArray(), index);
}

static <E> E elementAt(Object[] a, int index) {
    return (E) a[index];
}
```

> 很明显，没有加锁，拿到的是快照元素，不管在拿到数组过程中是否有其他线程对数组进行修改。
>
> 这就是写时复制策略的弱一致性问题

```java
public E set(int index, E element) {
    // 同步锁
    synchronized (lock) {
        // 获取数组array快照
        Object[] es = getArray();
        // 拿出指定位置的元素快照
        E oldValue = elementAt(es, index);
		
        if (oldValue != element) {
            // 复制一副副本
            es = es.clone();
            // 替换指定位置的元素
            es[index] = element;
        }
        // 新数组替换旧数组，为了保证volatile语义
        setArray(es);
        return oldValue;
    }
}

static <E> E elementAt(Object[] a, int index) {
    return (E) a[index];
}
```

```java
public E remove(int index) {
    // 同步锁
    synchronized (lock) {
        // 获取数组array快照
        Object[] es = getArray();
        int len = es.length;
        // 拿出指定位置的元素快照
        E oldValue = elementAt(es, index);
        // 计算要移动的个数
        int numMoved = len - index - 1;
        Object[] newElements;
        // 说明是删除末尾元素
        if (numMoved == 0)
            newElements = Arrays.copyOf(es, len - 1);
        // 不是删除末尾元素，需要将要保留的元素拷贝到新数组去
        else {
            newElements = new Object[len - 1];
            System.arraycopy(es, 0, newElements, 0, index);
            System.arraycopy(es, index + 1, newElements, index,
                             numMoved);
        }
        // 新数组替换旧数组
        setArray(newElements);
        return oldValue;
    }
}
```

```java
public Iterator<E> iterator() {
    return new COWIterator<E>(getArray(), 0);
}

static final class COWIterator<E> implements ListIterator<E> {
        // array的快照
        private final Object[] snapshot;
		// 数组下标
        private int cursor;

        COWIterator(Object[] es, int initialCursor) {
            cursor = initialCursor;
            snapshot = es;
        }
		
        public boolean hasNext() {
            return cursor < snapshot.length;
        }

        public E next() {
            if (! hasNext())
                throw new NoSuchElementException();
            return (E) snapshot[cursor++];
        }
}
```

> 迭代器中保存了一个array数组快照，尽管是引用传递。
>
> - 如果在迭代过程中，没有其他线程对array进行修改，那保存的是同一个。
> - 如果在遍历期间，其他线程对array进行了增删改，由于每次的增删改都会用新数组替换旧数组，那么迭代器中的数组快照就是旧数组了。

# 六.JUC包中锁原理剖析

## 1.LockSupport工具类

LockSupport是一个工具类，用于挂起和唤醒线程，是创建锁和其他同步类的基础。

- void park()：如果调用park方法的线程拿到了LockSupport关联的许可证，则调用LockSupport.park()时会马上返回，否则调用线程会被禁止参与与线程的调度，也就是被阻塞挂起。默认情况下调用线程是不持有许可证的。

  其他线程调用unpark(Thread thread)，以该线程作为参数时，可以唤醒该线程。

  如果其他线程调用了该线程的interrupt()方法，该线程会返回，不会抛异常。

- void park(Object blocker)：和park()一样，只不过blocker会被记录到线程内部。

- void unpark(Thread thread)：当一个线程调用unpark时，如果入参thread线程没有持有thread与LockSupport关联的许可证，则让thread线程持有。

  如果之前thread因为调用park()而被挂起，则会被唤醒。

  如果之前thread没有被挂起，调用park()会立刻返回。

- void parkNanos(long nanos)：与park()类似，如果调用park方法的线程拿到了LockSupport关联的许可证，则调用LockSupport.parkNanos时会马上返回。

  不同的是，如果没有拿到许可证，则调用线程会被挂起nanos时间后自动返回。找个nanos是相对时间，相对现在时间的累加。

- void parkNanos(Object blocker, long nanos)：和void parkNanos(long nanos)一样，只不过blocker会被记录到线程内部。

- void parkUntil(Object blocker， long deadline)：和void parkNanos(Object blocker, long nanos)一样，只不过deadline是绝对时间。

## 2.抽象同步队列AQS

### 2.1 AQS——锁的底层支持

AbstractQueuedSynchronizer抽象同步队列，是实现同步器的基础组件，JUC包锁底层就是使用AQS。

![QQ截图20230921162511](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ截图20230921162511.png)

AQS是一个一个FIFO的双向队列，内部通过节点head和tail记录队首和队尾元素，队列元素类型是Node。

---

Node是AQS的内部类：

- Node中的thread变量用来存放进入AQS队列的线程；

- Node内部SHARED用来标记该线程是获取共享资源时被阻塞挂起后放入AQS的；

- Node内部EXCLUSIVE用来标记线程是获取独占资源时被挂起后放入AQS的；

- waitStatus记录当前线程等待状态：
  - CANCELLED=1：线程因超时或中断而被取消。节点永远不会离开此状态。特别是，具有已取消节点的线程永远不会再阻塞。
  - SIGNAL=-1：后继线程需要被唤醒；
  - CONDITION=-2：线程在条件队列里等待；
  - PROPAGATE=-3：释放共享资源时需要通知其他节点；

- prev：记录当前节点的前驱节点

- next：记录当前节点的后继节点；

---

AQS的state：单一状态信息，可以通过getState、setState、compareAndSetState方法修改其值；

- 对于ReentrantLock的实现，state可以用来标识当前线程获取锁的可重入次数；

- 对于ReentrantReadWriteLock。state的高位16位表示读状态，也就是获取读锁的次数；地位16表示获取到写锁的线程的可重入次数；

- 对于semaphore，state用来表示当前可用信号的个数；

- 对于CountDownlatch，state用来表示计数器当前的值；

---

ConditionObject是AQS内部类：

- 用来结合锁实现线程同步。ConditionObject可以直接访问AQS对象内部的变量，比如state状态值和AQS队列。

- ConditionObject是条件变量，每个条件变量对应一个条件队列（单向链表队列），其用来存放 调用条件变量的await方法被阻塞的线程。

---

对于AQS来说，线程同步的关键是对状态值state进程操作。根据state是否属于一个线程，操作state的方式分为独占方式和共享方式。

- 独占方式获取和释放资源方法：
  - void acquire(int arg)
  - void acquireInterruptibly(int arg)
  - boolean release(int arg)
- 共享方式获取和释放资源方法：
  - void acquireShared(int arg)
  - void acquireSharedInterruptibly(int arg)
  - boolean releaseShared(int arg)

使用独占方式获取的资源是与具体线程绑定的，就是说一个线程获取到了资源，就会标记是找个线程获取到了，其他线程再尝试操作state获取资源时发现该资源不是自己持有的，就会再获取失败后阻塞。

> 比如独占锁ReentrantLock实现，当一个线程获取到ReentrantLock锁后，再AQS内部会首先使用CAS把state从0变为1，如何设置当前锁的持有者是当前线程。
>
> 当该线程再次获取锁时发现自己时锁的持有者，状态会由1变为2，也就是计数器次数，而当另一个线程获取锁时，发现锁的持有者不是自己，就会被放入AQS阻塞队列后挂起。

使用共享方式的资源与具体线程是不相关的，当多个线程去请求资源时通过CAS方式竞争，当一个线程获取到资源后，另外一个线程再去获取时，如果当前资源还能满足它的需求，则当前线程只需要使用CAS方式进行获取即可。

> 比如Semaphore信号量，当一个线程通过acquire()方法获取到信号量时，会首先看当前信号量是否满足需要，不满足则把当前线程放入阻塞队列，如果满足会自旋CAS方式获取信号量。

**独占方式下，获取和释放资源流程**：

1. 当一个线程调用acquire(int arg)获取独占资源时，会首先使用tryAcquire方法测试获取资源，就是设置state的值，成功则直接返回，失败则将当前线程封装为Node.EXCLUSIVE的Node节点插入到AQS阻塞队列的尾部，并调用LockSupport.park(this)方法挂起自己。

   ```java
   public final void acquire(int arg) {
       if (!tryAcquire(arg) &&
           acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
           selfInterrupt();
   }
   
   private Node addWaiter(Node mode) {
       // 创建给定模式的节点
       Node node = new Node(mode);
   
       for (;;) {
           Node oldTail = tail;
           if (oldTail != null) { // 尾部节点存在则把新节点放在末端
               // 新节点的prev节点设置oldTail
               node.setPrevRelaxed(oldTail);
               // 用CAS操作把新节点设置为tail
               if (compareAndSetTail(oldTail, node)) {
                   // 设置oldTail的next节点为node
                   oldTail.next = node;
                   return node;
               }
           } else {
               initializeSyncQueue();
           }
       }
   }
   
   
   final boolean acquireQueued(final Node node, int arg) {
       boolean interrupted = false;
       try {
           for (;;) {
               // 获取node的prev节点
               final Node p = node.predecessor();
               // 如果p为阻塞队列头节点，尝试抢占锁
               if (p == head && tryAcquire(arg)) {
                   // 抢占成功，设置node为head
                   setHead(node);
                   p.next = null; // help GC
                   return interrupted;
               }
               // node不是阻塞队列头节点，抢锁失败
               if (shouldParkAfterFailedAcquire(p, node))
                   // 挂起当前线程
                   interrupted |= parkAndCheckInterrupt();
           }
       } catch (Throwable t) {
           cancelAcquire(node);
           if (interrupted)
               selfInterrupt();
           throw t;
       }
   }
   
   private static boolean shouldParkAfterFailedAcquire(Node pred, Node node) {
       int ws = pred.waitStatus;
       if (ws == Node.SIGNAL) // 如果前驱节点需要被唤醒，当前节点就要被挂起
           return true;
       // 前驱节点取消排队，让pred指向正常的的前驱节点，好让它唤醒自己
       if (ws > 0) {
           do {
               node.prev = pred = pred.prev;
           } while (pred.waitStatus > 0);
           pred.next = node;
       } else {
           // 此时的状态可能时0、-2、-3，但前面没有设置过waitStatus，所以此时状态应该和刚设置成tail一样，是0
           // 用CAS将pred的waitStatus设置为-1
           pred.compareAndSetWaitStatus(ws, Node.SIGNAL);
       }
       return false;
   }
   
   private final boolean parkAndCheckInterrupt() {
       LockSupport.park(this);
       return Thread.interrupted();
   }
   ```

2. 当一个线程调用release(int arg)方法尝试使用tryRelease操作释放资源，就是设置state的值，然后调用LockSupport.unpark(thread)方法激活AQS队列里被阻塞的一个线程thread。

   被激活的线程使用tryAcquire尝试，看当前state的值是否满足自己的需求，满足则该线程被激活，然后继续向下运行，否则被重新放入AQS队列被挂起。

   ```java
   public final boolean release(int arg) {
       if (tryRelease(arg)) {
           Node h = head;
           if (h != null && h.waitStatus != 0)
               unparkSuccessor(h);
           return true;
       }
       return false;
   }
   
   private void unparkSuccessor(Node node) {
       int ws = node.waitStatus;
       // 如果信号小于0，需要清除信号
       if (ws < 0)
           node.compareAndSetWaitStatus(ws, 0);
   
       // 如果后继节点为null或状态值大于0，则从尾部开始找，找到一个状态值<=0的节点
       Node s = node.next;
       if (s == null || s.waitStatus > 0) {
           s = null;
           for (Node p = tail; p != node && p != null; p = p.prev)
               if (p.waitStatus <= 0)
                   s = p;
       }
       // 如果不为null，唤醒这个节点的线程
       if (s != null)
           LockSupport.unpark(s.thread);
   }
   ```

   需要注意的是，AQS类并没有提供可用的tryAcquire和tryRelease方法，需要具体的子类实现。子类的实现要根据具体场景使用CAS算法尝试修改state状态值。成功则返回true，否则返回false。子类还需要定义调用acquire和release时state状态值的增减代表什么。
   
   > 比如继承自AQS实现的ReentrantLock，定义state为0表示锁空闲，1表示锁已经被占用。
   >
   > 再重写tryAcquire时，在内部需要使用CAS算法查看当前state是否为0，如果为0则使用CAS设置为1，并设置当前锁的持有者为当前线程，返回true，如果CAS失败则返回false
   >
   > 实现tryRelease时，在内部需要使用CAS算法把当前state从1修改为0，并设置当前锁的持有者为null，然后返回true，如果CAS失败则返回false。

**在共享方式下，获取与释放资源的流程**：

1. 当线程调用acquireShared(int arg)获取共享资源时，会首先使用tryAcquireShared尝试获取资源，就是设置state的值，成功则直接返回，失败则将当前线程封装为类型为Node.SHARED的Node节点后插入到AQS阻塞队列的尾部，并使用LockSupport.park(this)方法挂起自己。

   ```java
   public final void acquireShared(int arg) {
       if (tryAcquireShared(arg) < 0)
           doAcquireShared(arg);
   }
   
   private void doAcquireShared(int arg) {
       final Node node = addWaiter(Node.SHARED);
       boolean interrupted = false;
       try {
           for (;;) {
               final Node p = node.predecessor();
               if (p == head) {
                   int r = tryAcquireShared(arg);
                   if (r >= 0) {
                       setHeadAndPropagate(node, r);
                       p.next = null; // help GC
                       return;
                   }
               }
               if (shouldParkAfterFailedAcquire(p, node))
                   interrupted |= parkAndCheckInterrupt();
           }
       } catch (Throwable t) {
           cancelAcquire(node);
           throw t;
       } finally {
           if (interrupted)
               selfInterrupt();
       }
   }
   
   private final boolean parkAndCheckInterrupt() {
       LockSupport.park(this);
       return Thread.interrupted();
   }
   ```

2. 当一个线程调用releaseShared(int arg)时会尝试使用使用tryReleaseShared释放资源，就是设置state的值，然后使用LockSupport.unpark(thread)激活AQS队列里面被阻塞的一个线程。

   被激活的线程使用tryReleaseShared查看当前state是否满足自己的需求，满足则该线程被激活，然后继续运行，否则还是会被放入AQS队列被挂起。

   ```java
   public final boolean releaseShared(int arg) {
       if (tryReleaseShared(arg)) {
           doReleaseShared();
           return true;
       }
       return false;
   }
   
   private void doReleaseShared() {
       for (;;) {
           Node h = head;
           if (h != null && h != tail) {
               int ws = h.waitStatus;
               if (ws == Node.SIGNAL) {
                   if (!h.compareAndSetWaitStatus(Node.SIGNAL, 0))
                       continue;            // loop to recheck cases
                   unparkSuccessor(h);
               }
               else if (ws == 0 &&
                        !h.compareAndSetWaitStatus(0, Node.PROPAGATE))
                   continue;                // loop on failed CAS
           }
           if (h == head)                   // loop if head changed
               break;
       }
   }
   ```

   同样需要注意，AQS类并没有提供可用的tryAcquireShared和tryReleaseShared方法，需要具体的子类实现。

   子类的实现要根据具体场景使用CAS算法尝试修改state状态值。成功则返回true，否则返回false。子类还需要定义调用acquire和release时state状态值的增减代表什么。

   > 比如继承自AQS实现的读写锁ReentrantReadWriteLock，里面的读锁在重写tryAcquireShared时，首先查看写锁是否被其他线程持有，如果时则直接返回false，否则使用CAS递增state的高位16。

---

基于AQS实现的锁除了还需要重写isHeldExclusively方法，来判断锁时被当前线程独占还是被共享。

独占方式下的void acquire(int arg)、void acquireInterruptibly(int arg) 和 共享方式下的：

- 不带Interruptibly代表不对中断进行响应，也就是线程在调用不带Interruptibly的方法获取或释放资源失败被挂起时，其他线程中断了该线程，那该线程不会因为被中断而抛异常，它还是会继续获取资源或者被挂起，也就是忽略中断。
- 带Interruptibly代表获取资源或释放资源失败而被挂起时，其他线程中断了该线程，那么线程会抛InterruptedException异常而返回。

---

我们来看如何维护AQS提供的队列，主要看入队操作。

当一个线程获取锁失败后该线程会被转换为Node节点，然后使用enq(Node node)将该节点插入到AQS的阻塞队列。

```java
private Node enq(Node node) {
    for (;;) {
        Node oldTail = tail; // （1）
        if (oldTail != null) {
            // 新节点的prev节点设置为老节点
            node.setPrevRelaxed(oldTail);
            // 用CAS操作把node设置为tail
            if (compareAndSetTail(oldTail, node)) {
                oldTail.next = node;
                return oldTail;
            }
        } else {
            initializeSyncQueue();
        }
    }
}
```

### 2.2 AQS——条件变量的支持

notify和wait，是配合synchronized内置锁实现线程间同步，而条件变量signal和await方法也是用来配合锁(AQS实现锁)实现线程间同步的基础设施。

不同在于，synchronized同时只能与一个共享变量的notify或wait方法实现同步，而AQS的锁可以对应多个条件变量。

如ReentrantLock的条件变量：

```java
private Lock lock=new ReentrantLock();
private Condition condition=lock.newCondition();

while (i<20){
    lock.lock();
    try {
        if (i%2==0){
            System.out.println(Thread.currentThread().getName()+":"+i);
            i++;
            //偶数打印完，唤醒偶数打印
            condition.signal();
        }else {
            try {
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    } finally {
        lock.unlock();
    }
}
```

与notify和wait一样，在调用条件变量signal和await方法前，也必须获取条件变量对应的锁。

一个Lock可以创建多个条件变量，每个条件变量有自己的条件队列。

lock.newCondition();就是在AQS内部声明一个ConditionObject对象。ConditionObject是AQS的内部类，在每个条件变量**内部维护了一个条件队列**，用来存放 调用条件变量的await()方法时被阻塞的线程。

```java
public final void await() throws InterruptedException {
    // 当前锁没有被独占，抛异常
    if (Thread.interrupted())
        throw new InterruptedException();
    // 创建新的node，插入到条件队列末尾
    Node node = addConditionWaiter();
    // 释放当前线程获取的锁
    int savedState = fullyRelease(node);
    int interruptMode = 0;
    // 调用park方法阻塞挂起当前线程
    while (!isOnSyncQueue(node)) {
        LockSupport.park(this);
        if ((interruptMode = checkInterruptWhileWaiting(node)) != 0)
            break;
    }
    if (acquireQueued(node, savedState) && interruptMode != THROW_IE)
        interruptMode = REINTERRUPT;
    if (node.nextWaiter != null) // clean up if cancelled
        unlinkCancelledWaiters();
    if (interruptMode != 0)
        reportInterruptAfterWait(interruptMode);
}

private Node addConditionWaiter() {
    if (!isHeldExclusively())
        throw new IllegalMonitorStateException();
    // 获取条件队列最后一个元素
    Node t = lastWaiter;
    
    // 如果lastWaiter被取消了，则清除被取消的节点
    if (t != null && t.waitStatus != Node.CONDITION) {
        unlinkCancelledWaiters();
        t = lastWaiter;
    }
    
	// 创建一个Node.CONDITION的节点
    Node node = new Node(Node.CONDITION);
	
    // 设置新节点的位置
    if (t == null)
        firstWaiter = node;
    else
        t.nextWaiter = node;
    lastWaiter = node;
    return node;
}
```

> 当线程调用await()方法时（必须先获取锁），在内部会构造一个类型为Node.CONDITION的node节点，然后将该节点插入条件队列末尾，之后当前线程会释放锁，并被阻塞挂起。

```java
public final void signal() {
    // 当前锁没有被独占，抛异常
    if (!isHeldExclusively())
        throw new IllegalMonitorStateException();
    Node first = firstWaiter;
    if (first != null)
        // 将条件队列头元素移动到AQS阻塞队列，等待唤醒
        doSignal(first);
}

private void doSignal(Node first) {
    do {
        // 如果first.nextWaiter为null，则lastWaiter为null
        if ( (firstWaiter = first.nextWaiter) == null)
            lastWaiter = null;
        first.nextWaiter = null;
    } while (!transferForSignal(first) &&
             (first = firstWaiter) != null);
}

final boolean transferForSignal(Node node) {
	// 将node的waitStatus设置为0
    if (!node.compareAndSetWaitStatus(Node.CONDITION, 0))
        return false;
	// 将该节点加入到AQS阻塞队列
    Node p = enq(node);
    int ws = p.waitStatus;
    // 如果是阻塞状态 或 CAS失败，则唤醒改节点
    if (ws > 0 || !p.compareAndSetWaitStatus(ws, Node.SIGNAL))
        LockSupport.unpark(node.thread);
    return true;
}
```

需要注意，AQS值提供了ConditionObject的实现，没有提供newCondition函数。需要由AQS的子类来提供。

## 3.独占锁ReentrantLock原理

### 3.1 结构

![QQ截图20230923004132](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ截图20230923004132.png)

ReentrantLock最终还是使用AQS来实现的，并根据参数来决定内部是一个公平锁还是非公平锁，默认非公平锁。

```java
public ReentrantLock(boolean fair) {
    sync = fair ? new FairSync() : new NonfairSync();
}
```

Sync直接继承自AQS，他的子类NonfairSync核FairSync分别实现了获取锁的非公平与公平策略。

这里的AQS的state状态值表示线程获取该锁的可重入次数，在默认情况下，state的值为0，表示当前锁没有被任何线程持有。当第一个线程获取该锁时，会尝试使用CAS设置state为1，如果成功则当前线程获取到该锁，然后记录该锁的持有者为当前线程。在该线程没有释放锁的情况下第二次获取了该锁后，state被设置为2，这就是可重入次数。

在该线程释放该锁时，会尝试使用CAS让state减1，如果减1成功后状态值为0，则当前线程释放该锁。

### 3.2 获取锁

**void lock()**：

获取锁，如果获取成功则state加1，否则被阻塞。如果再次获取锁，发现锁的持有这已经是自己则state再加1。

- 非公平方式：

```java
// ReentrantLock方法
public void lock() {
    // 交给sync来做
    sync.acquire(1);
}

// AQS方法
public final void acquire(int arg) {
    if (!tryAcquire(arg) &&
        acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
        selfInterrupt();
}

// 非公平sync的tryAcquire
protected final boolean tryAcquire(int acquires) {
    return nonfairTryAcquire(acquires);
}

// 非公平获取资源
final boolean nonfairTryAcquire(int acquires) {
    final Thread current = Thread.currentThread();
    int c = getState();
    // 如果锁空闲
    if (c == 0) {
        // 使用CAS尝试获取锁，state设置为1
        if (compareAndSetState(0, acquires)) {
            // 设置当前锁的持有者
            setExclusiveOwnerThread(current);
            return true;
        }
    }
    // 如果锁被自己占用
    else if (current == getExclusiveOwnerThread()) {
        // 锁加1
        int nextc = c + acquires;
        if (nextc < 0) // 可重入次数溢出
            throw new Error("Maximum lock count exceeded");
        // 设置state值
        setState(nextc);
        return true;
    }
    // 该线程不是锁的持有者
    return false;
}
```

- 公平方式：

```java
// 公平获取资源
protected final boolean tryAcquire(int acquires) {
    final Thread current = Thread.currentThread();
    int c = getState();
    // 如果锁空闲
    if (c == 0) {
        // 公平性策略
        if (!hasQueuedPredecessors() &&
            compareAndSetState(0, acquires)) {
            setExclusiveOwnerThread(current);
            return true;
        }
    }
    // 锁是否当前线程拥有者
    else if (current == getExclusiveOwnerThread()) {
        int nextc = c + acquires;
        if (nextc < 0)
            throw new Error("Maximum lock count exceeded");
        setState(nextc);
        return true;
    }
    return false;
}

// 公平性核心，如果当前线程前面有排队的线程返回true，如果当前线程是head或队列为空，返回false
public final boolean hasQueuedPredecessors() {
    Node h, s;
    if ((h = head) != null) {
        // 如果h.next为null，或h.next是阻塞状态
        if ((s = h.next) == null || s.waitStatus > 0) {
            s = null; 
            // 从后往前找
            for (Node p = tail; p != h && p != null; p = p.prev) {
                // 找一个没有被阻塞的线程
                if (p.waitStatus <= 0)
                    s = p;
            }
        }
        // 找到了没有被阻塞的线程，且不是自己，返回true，不允许重入
        if (s != null && s.thread != Thread.currentThread())
            return true;
    }
    // 队列为空，允许重入
    return false;
}
```

**void locklnterruptibly ()**：

```java
// ReentrantLock方法
public void lockInterruptibly() throws InterruptedException {
    sync.acquireInterruptibly(1);
}

// AQS方法
public final void acquireInterruptibly(int arg)
    throws InterruptedException {
    // 如果当前线程被中断，抛异常
    if (Thread.interrupted())
        throw new InterruptedException();
    if (!tryAcquire(arg))
        doAcquireInterruptibly(arg);
}
```

**boolean tryLock()**：

尝试获取锁，如果当前锁没有被其他线程持有，则获取锁并返回true，否则返回false。

注意：该方法不会引起当前线程阻塞。

```java
public boolean tryLock() {
    // 使用的是非公平获取方式
    return sync.nonfairTryAcquire(1);
}

final boolean nonfairTryAcquire(int acquires) {
    final Thread current = Thread.currentThread();
    int c = getState();
    if (c == 0) {
        if (compareAndSetState(0, acquires)) {
            setExclusiveOwnerThread(current);
            return true;
        }
    }
    else if (current == getExclusiveOwnerThread()) {
        int nextc = c + acquires;
        if (nextc < 0) // overflow
            throw new Error("Maximum lock count exceeded");
        setState(nextc);
        return true;
    }
    return false;
}
```

**tryLock(long timeout, TimeUnit unit)**：

设置了超时时间的tryLock方法，时间到了还没有获取到锁，返回false

```java
public boolean tryLock(long timeout, TimeUnit unit)
    throws InterruptedException {
    // 使用AQS的tryAcquireNanos方法
    return sync.tryAcquireNanos(1, unit.toNanos(timeout));
}
```

### 3.3 释放锁

void unlock()：

释放锁，如果当前线程持有锁，则调用该方法让state减1，减去1后如果state为0则释放锁。

如果当前线程没有锁而要释放锁，则会抛异常。

```java
public void unlock() {
    sync.release(1);
}

public final boolean release(int arg) {
    if (tryRelease(arg)) {
        Node h = head;
        if (h != null && h.waitStatus != 0)
            unparkSuccessor(h);
        return true;
    }
    return false;
}

protected final boolean tryRelease(int releases) {
    // state减去1
    int c = getState() - releases;
    // 如果当前线程不是锁拥有者，抛异常
    if (Thread.currentThread() != getExclusiveOwnerThread())
        throw new IllegalMonitorStateException();
    boolean free = false;
    // 如果可重入次数为0，清空锁持有者
    if (c == 0) {
        free = true;
        setExclusiveOwnerThread(null);
    }
    // 设置state值
    setState(c);
    return free;
}
```

## 4.ReentrantReadWriteLock原理

读写锁，用来满足读多写少的的场景。

- 读-读共享
- 读-写互斥
- 写-写互斥

### 4.1 结构

![QQ截图20230925171306](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ截图20230925171306.png)

读写锁内部维护了ReadLock和WriteLock，他们依赖Sync实现具体功能。而Sync继承自AQS，并且实现了公平和非公平方式。

ReentrantReadWriteLock用state的高位16表示读状态，低位16表示写锁的**可重入次数**。

```java
abstract static class Sync extends AbstractQueuedSynchronizer {
	
    static final int SHARED_SHIFT   = 16;
    // 读锁65536
    static final int SHARED_UNIT    = (1 << SHARED_SHIFT);
    // 读锁最大线程数65535
    static final int MAX_COUNT      = (1 << SHARED_SHIFT) - 1;
    // 写锁掩码，二进制，15个1
    static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;
    
    // 第一个获取到读锁的线程
    private transient Thread firstReader;
    // 第一个获取到读锁的线程的重入次数
    private transient int firstReaderHoldCount;
    
    // 最后一个获取到读锁的线程的重入次数
    private transient HoldCounter cachedHoldCounter;
    
    // ThreadLocal变量，存放除第一个获取读锁线程外的其他线程获取读锁的重入次数
    private transient ThreadLocalHoldCounter readHolds;
}
```

### 4.2 写锁WriteLock

**void lock()**：

```java
// WriteLock的方法
public void lock() {
    sync.acquire(1);
}

// AQS方法
public final void acquire(int arg) {
    if (!tryAcquire(arg) &&
        acquireQueued(addWaiter(Node.EXCLUSIVE), arg))
        selfInterrupt();
}

// Sync的方法
protected final boolean tryAcquire(int acquires) {
    Thread current = Thread.currentThread();
    int c = getState();
    // 获取读锁重入数
    int w = exclusiveCount(c);
    // c != 0说明读锁或写锁已经被某线程获取
    if (c != 0) {
        // w == 0说明已经有线程获取了读锁，不能再获取写锁
        // w != 0 并且当前线程不是写锁拥有者，说明有其他线程获取了写锁，返回false
        if (w == 0 || current != getExclusiveOwnerThread())
            return false;
        // 说明当前线程获取了写锁，判断是否超过最大可重入次数
        if (w + exclusiveCount(acquires) > MAX_COUNT)
            throw new Error("Maximum lock count exceeded");
       // 设置可重入次数
        setState(c + acquires);
        return true;
    }
    // 到这，说明读锁或写锁都没有被占有
    // 第一个线程获取写锁
    if (writerShouldBlock() ||
        !compareAndSetState(c, c + acquires)) //（5）
        return false;
    setExclusiveOwnerThread(current);
    return true;
}

// NonfairSync实现
final boolean writerShouldBlock() {
    return false;
}

// FairSync实现
final boolean writerShouldBlock() {
    // 判断当前线程节点是否有前驱节点
    return hasQueuedPredecessors();
}
```

非公平方式：总是返回false，代码（5）抢占式执行CAS获取锁

公平方式：如果前面有线程在排队，则放弃获取锁。

**void lockInterruptibly()**：

与lock()类似，只不过它对中断响应。

```java
public void lockInterruptibly() throws InterruptedException {
    sync.acquireInterruptibly(1);
}
```

**tryLock()**：

尝试获取锁，如果其他线程获取到了读锁或写锁，直接返回false，不会阻塞。

```java
public boolean tryLock() {
    return sync.tryWriteLock();
}

final boolean tryWriteLock() {
    Thread current = Thread.currentThread();
    int c = getState();
    if (c != 0) {
        int w = exclusiveCount(c);
        // 其他线程获取到了读锁或写锁，直接返回false
        if (w == 0 || current != getExclusiveOwnerThread())
            return false;
        if (w == MAX_COUNT)
            throw new Error("Maximum lock count exceeded");
    }
    if (!compareAndSetState(c, c + 1))
        return false;
    setExclusiveOwnerThread(current);
    return true;
}
```

**tryLock(long timeout, TimeUnit unit)**：

尝试获取锁，如果失败了会把当前线程挂起指定时间，时间到了会被激活，与其他线程竞争，如果还是没有获取到锁，则返回false。

```java
public boolean tryLock(long timeout, TimeUnit unit)
    throws InterruptedException {
    return sync.tryAcquireNanos(1, unit.toNanos(timeout));
}

public final boolean tryAcquireNanos(int arg, long nanosTimeout)
    throws InterruptedException {
    // 对中断响应
    if (Thread.interrupted())
        throw new InterruptedException();
    return tryAcquire(arg) ||
        doAcquireNanos(arg, nanosTimeout);
}

private boolean doAcquireNanos(int arg, long nanosTimeout)
    throws InterruptedException {
    if (nanosTimeout <= 0L)
        return false;
    final long deadline = System.nanoTime() + nanosTimeout;
    // 创建一个独占模式的节点，并加入到队尾
    final Node node = addWaiter(Node.EXCLUSIVE);
    try {
        for (;;) {
            // 获取前驱节点
            final Node p = node.predecessor();
            // 如果是头节点，尝试获取锁
            if (p == head && tryAcquire(arg)) {
                setHead(node);
                p.next = null; // help GC
                return true;
            }
            nanosTimeout = deadline - System.nanoTime();
            // 如果时间到了，取消
            if (nanosTimeout <= 0L) {
                // 取消线程
                cancelAcquire(node);
                return false;
            }
            if (shouldParkAfterFailedAcquire(p, node) &&
                nanosTimeout > SPIN_FOR_TIMEOUT_THRESHOLD)
                // 挂起指定时间
                LockSupport.parkNanos(this, nanosTimeout);
            // 响应中断
            if (Thread.interrupted())
                throw new InterruptedException();
        }
    } catch (Throwable t) {
        cancelAcquire(node);
        throw t;
    }
}
```



```java
public void unlock() {
    sync.release(1);
}

// AQS中的方法
public final boolean release(int arg) {
    // 释放锁
    if (tryRelease(arg)) {
        // 激活阻塞队列中的一个线程
        Node h = head;
        if (h != null && h.waitStatus != 0)
            unparkSuccessor(h);
        return true;
    }
    return false;
}

protected final boolean tryRelease(int releases) {
    // 是否是写锁的拥有者调用的unlock
    if (!isHeldExclusively())
        throw new IllegalMonitorStateException();
    // 可重入数减1，不考虑高位16，因为写锁释放，高位16肯定是0
    int nextc = getState() - releases;
    boolean free = exclusiveCount(nextc) == 0;
    // 如果可重入数为0，清空锁拥有者
    if (free)
        setExclusiveOwnerThread(null);
    // 设置state
    setState(nextc);
    return free;
}
```

### 4.3 读锁ReadLock

**lock()**：

获取读锁，如果当前没有其他线程持有写锁，则当前线程可以获取读锁，state高位16的值加1。如果其他线程持有写锁，则当前线程被阻塞。

```java
// ReadLock方法
public void lock() {
    sync.acquireShared(1);
}

// AQS方法
public final void acquireShared(int arg) {
    // 尝试获取读锁
    if (tryAcquireShared(arg) < 0)
        // 获取失败，阻塞自己
        doAcquireShared(arg);
}

// ReentrantReadWriteLock中Sync方法
protected final int tryAcquireShared(int unused) {
    Thread current = Thread.currentThread();
    // 获取状态值
    int c = getState();
    // 判断写锁是否被占用
    if (exclusiveCount(c) != 0 &&
        getExclusiveOwnerThread() != current)
        return -1;
    // 获取读锁个数
    int r = sharedCount(c);
    // 尝试获取锁，多个线程只有一个会成功，不成功的进入fullTryAcquireShared
    // readerShouldBlock()如果为true，则说明有线程正在获取读锁
    if (!readerShouldBlock() &&
        r < MAX_COUNT &&
        compareAndSetState(c, c + SHARED_UNIT)) {
        // 读锁为0，设置当前线程为第一个获取读锁的线程
        if (r == 0) {
            firstReader = current;
            firstReaderHoldCount = 1;
        // 如果第一个获取锁的线程是自己
        } else if (firstReader == current) {
            firstReaderHoldCount++;
        // 当前线程既不是第一个获取锁的，而且锁也被其他线程占有
        } else {
            // 获取最后一个获取读锁的线程
            HoldCounter rh = cachedHoldCounter;
            if (rh == null ||
                rh.tid != LockSupport.getThreadId(current))
                // 设置最后一个获取到读锁的线程是自己
                cachedHoldCounter = rh = readHolds.get();
            // 如果最后一个获取到读锁的是自己，设置重入数加1
            else if (rh.count == 0)
                readHolds.set(rh);
            rh.count++;
        }
        return 1;
    }
    // 类似于tryAcquireShared，但是是自旋获取
    return fullTryAcquireShared(current);
}

// 公平方式
final boolean readerShouldBlock() {
    return hasQueuedPredecessors();
}

// 非公平方式
final boolean readerShouldBlock() {
    // 如果队列的头正在获取读锁，返回true
    return apparentlyFirstQueuedIsExclusive();
}
```

**unlock()**：

```java
// ReadLock方法
public void unlock() {
    sync.releaseShared(1);
}

// AQS方法
public final boolean releaseShared(int arg) {
    if (tryReleaseShared(arg)) {
        doReleaseShared();
        return true;
    }
    return false;
}

// Sync方法
protected final boolean tryReleaseShared(int unused) {
    Thread current = Thread.currentThread();
    if (firstReader == current) {
        // assert firstReaderHoldCount > 0;
        if (firstReaderHoldCount == 1)
            firstReader = null;
        else
            firstReaderHoldCount--;
    } else {
        HoldCounter rh = cachedHoldCounter;
        if (rh == null ||
            rh.tid != LockSupport.getThreadId(current))
            rh = readHolds.get();
        int count = rh.count;
        if (count <= 1) {
            readHolds.remove();
            if (count <= 0)
                throw unmatchedUnlockException();
        }
        --rh.count;
    }
    // 循环减少自己占用的读锁数，直到-1
    for (;;) {
        int c = getState();
        int nextc = c - SHARED_UNIT;
        if (compareAndSetState(c, nextc))
            return nextc == 0;
    }
}
```

## 5.StamedLock锁

### 5.1 概述

StamedLock是JDK8新增的锁，提供三种模式的读写控制。当调用获取锁的系列函数会返回一个long变量，称为戳记（stamp），代表锁的状态。

读-读共享、读-写互斥、写-写互斥

- **写锁writeLock**：排他锁，非重入锁。

  获取锁后会返回一个stamp变量表示锁的版本；

  释放锁调用unlockWrite，需要传递获取锁时的stamp参数；

- **悲观读锁readLock**：共享锁。非重入锁。悲观锁。

  悲观态度，这是一种读少写多的考虑。

  请求锁成功后返回一个stamp变量表示锁版本；

  释放锁调用unlockWrite，需要传递获取锁时的stamp参数；

- **乐观读锁tryOptimisticRead**：共享锁。非重入锁。乐观锁。

  在操作数据前没有通过CAS设置锁状态，仅仅通过位运算测试，如果当前没有线程持有写锁，则简单的返回一个非0的stamp版本信息。

  获取该stamp后，操作数据前还需要调用validate方法验证该stamp释放已经不可用，也就是看当调用tryOptimisticRead返回stamp后当前时间期间是否有其他线程持有了写锁，如果是则validate返回0，否则使用该stamp版本的锁对数据进行操作。

  由于没有使用CAS设置锁状态，所以不需要显式地释放该锁。所以操作的数据是一个快照。

  用于读多写少场景

StamedLock锁还支持三把锁相互转换。如`long tryConvertToWriteLock(long stamp) `尝试转化为一个写锁，转化成功会返回一个有效的stamp，这个函数以下几种情况返回一个有效stamp：

- 当前锁已经是写锁
- 当前锁是读锁模式，且没有其他线程占有
- 当前处于乐观读模式，且当前写锁可用

# 七.JUC并发队列原理剖析

## 1.ConcrrentLinkedQueue原理

![QQ截图20231004153920](D:\developmentProject\javaSE\JavaSE\a_doc\Java\java并发编程之美\assist\QQ截图20231004153920.png)

ConcrrentLinkedQueue内部队列使用单向链表方式实现，使用VarHandle工具类提供的CAS算法保证出入队时的原子性。

**无参构造**：

```java
public ConcurrentLinkedQueue() {
    head = tail = new Node<E>();
}
```

从代码可知，默认head、tail都指向一个item为null的哨兵节点。新元素被插入队列末尾，出队时从队列头部获取一个元素。

**offer(E e)：**

在队尾添加一个元素

```java
public boolean offer(E e) {
    // 创建一个Node，如果e为null，抛异常
    final Node<E> newNode = new Node<E>(Objects.requireNonNull(e));
	
    // 从尾节点进行插入
    for (Node<E> t = tail, p = t;;) {
        Node<E> q = p.next;
        // 为null说明p是尾节点，执行插入
        if (q == null) {
            // 使用CAS设置p节点的next节点
            if (NEXT.compareAndSet(p, null, newNode)) {
                // CAS成功，设置当前尾节点
                if (p != t)
                    TAIL.weakCompareAndSet(this, t, newNode);
                return true;
            }
        }
        else if (p == q)
			// 多线程操作时，由于poll操作移除元素后可能会把head变为自引用，
            // 所以这里需要重新找新的head
            p = (t != (t = tail)) ? t : head;
        else
            // 寻找尾节点
            p = (p != t && t != (t = tail)) ? t : q;
    }
}
```

**poll()：**

获取队头元素并移除，队列为空则返回null

```java
public E poll() {
    restartFromHead: for (;;) {
        for (Node<E> h = head, p = h, q;; p = q) {
            final E item;
            // 如果p.item不为null，且CAS设置p.item为null成功
            if ((item = p.item) != null && p.casItem(item, null)) {
         		// 当前节点从链表中移除
                if (p != h)
                    updateHead(h, ((q = p.next) != null) ? q : p);
                return item;
            }
            // 当前队列为空，返回null
            else if ((q = p.next) == null) {
                updateHead(h, p);
                return null;
            }
            // 如果当前节点被自引用了，重新寻找队列头节点
            else if (p == q)
                continue restartFromHead;
        }
    }
}

final void updateHead(Node<E> h, Node<E> p) {
    if (h != p && HEAD.compareAndSet(this, h, p))
        NEXT.setRelease(h, h);
}
```















