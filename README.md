# JAVAStudy
JAVA 1.8

* 新增Log4j的使用示例。[示例](./src/logStudy/useLog4J.java) ，[log4j的详细介绍](http://blog.51cto.com/ggwhsd/2340510)

* 关于java中时间的使用。[示例](./src/baseAPI/useDate.java)   

* 国际化ResourceBundle的使用。 [示例](./src/baseAPI/useResourceBundle.java) ,  [ResourceBundle的详细介绍](http://blog.51cto.com/ggwhsd/2340539)

* Math库的使用。  [示例](./src/baseAPI/useMath) 

* 运行时操作Runtime类的使用，读取内存使用情况，垃圾回收，调用外部进程，获取可用的cpu个数。 [示例](./src/baseAPI/useRuntime)

* StringBuffer类，相比较String，提升代码性能。StringBuffer是线程安全的。 StringBuffer清空，可以用setLength(0)或者delete(0, strBuff.length())，两者差不多，不建议new StringBuffer("")。[示例](./src/baseAPI/useStringBuffer.java)

* TCP socket使用
[示例客户端](./src/NetworkStudy/TcpTest.java)||[示例服务端](./src/NetworkStudy/Server.java)

* JAVA 的IO流，（不包括NIO的库使用），包括字符流和字节流。 [示例](./src/baseAPI/useIO.java)

* JAVA 的NIO库 [示例](./src/baseAPI/useNIO.java):Buffer,Selector,FileChannel,Path等。[详细介绍](http://blog.51cto.com/ggwhsd/2341370)

* sigar库 获取系统信息包括内存、操作系统、网卡、磁盘和CPU信息，以及CPU运行情况等系统性能指标。 [示例](./src/baseAPI/useSigar.java) 

* json 库 使用了gson库。 [示例](./src/baseAPI/gsonBase.java)

* 线程库
   * 线程的创建和使用。 [示例1](./concurrent/Thread_01/RunnableTest.java) -- [示例2](./concurrent/Thread_01/ThreadCreateTest.java)
   * 线程的yield和interrupt。 [示例](./concurrent/Thread_02/yieldAndInterruptTest.java)
   * 线程的volatile关键字的使用。volatile可以保证编译的顺序性，以避免编译器对其优化重排序。 [示例](./concurrent/Thread_03/violateStudy.java)
   * 线程的synchronized使用。 [示例](./concurrent/synchronizedStudy/toy.java)
   * 线程的通信notify和wait。 [示例](./concurrent/Thread_03/notifyWaitStudy.java)
   * 线程组的概念,主要用于组织线程，并不用来管理线程。[示例](./concurrent/Thread_03/ThreadGroupStudy.java)
   * 线程池
* ClassLoader类加载
   * 每个类在jvm中只有首次被主动调用才会进行初始化，6种主动调用。[示例](./src/classLoaderStudy/ClassInit1.java)
   * JVM中内置的三个ClassLoader [示例](./src/ClassLoaderStudy/classLoaderTest.java)
   * 自定义加载类[示例](./src/ClassLoaderStudy/MyClassLoader.java)

* 单例模式的几种方式
   * 饿汉模式,可以保证多个线程下的唯一实例。[示例](./src/DesignPattern/Sigleton/Singleton01.java)
   * 懒汉模式：在初始化时不会创建instance，只有在getinstance使用时才会创建。不支持多线程安全。[示例](./src/DesignPattern/Sigleton/Singleton02.java)
   * 懒汉 + 同步 模式：懒汉 + 同步 模式: 多线程安全，唯一的不好就是在于每次只能一个线程访问getinstance，因此不适合高并发的场景下频繁使用。 [示例](./src/DesignPattern/Sigleton/Singleton03.java)
   * double check : 原理跟懒汉+同步模式差不多，只是synchronized不放在方法上，而是放在具体代码块中，使得可以多个线程同时访问。如果需要再初始化类的代码里面，有包含其他初始化操作的变量，可以对这些变量使用volatile关键字，保证顺序编译。[示例](./src/DesignPattern/Sigleton/Singleton04.java)
   * 内部类 模式：这是单例模式好的设计之一，也是经常使用的一种方式。利用静态内部类中的静态成员，即达到了延迟初始化，又保证了同步，还使得多线程可以高并发访问。[示例](./src/DesignPattern/Sigleton/Singleton05.java)

* 设计模式and线程编程模式
   * 观察者模式，应用在监控任务状态。[示例](./src/DesignPattern/ObservePattern/TestObservableThread.java)
   * 

