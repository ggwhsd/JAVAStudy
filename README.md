# JAVAStudy
JAVA 1.8

* 新增Log4j的使用示例。[示例](./src/logStudy/useLog4J.java) ，[log4j的详细介绍](http://blog.51cto.com/ggwhsd/2340510)
* 关于java中时间的使用。[示例](./src/baseAPI/useDate.java)   
* 国际化ResourceBundle的使用。 [示例](./src/baseAPI/useResourceBundle.java) ,  [ResourceBundle的详细介绍](http://blog.51cto.com/ggwhsd/2340539)
* Math库的使用。  [示例](./src/baseAPI/useMath) 
* 运行时操作Runtime类的使用，读取内存使用情况，垃圾回收，调用外部进程(更详细的可以参考NetworkStudy目录下的示例)，获取可用的cpu个数。 [示例](./src/baseAPI/useRuntime)
* StringBuffer类，相比较String，提升代码性能。StringBuffer是线程安全的。 StringBuffer清空，可以用setLength(0)或者delete(0, strBuff.length())，两者差不多，不建议new StringBuffer("")。[示例](./src/baseAPI/useStringBuffer.java)
* TCP socket的client简单使用[示例客户端](./src/NetworkStudy/TcpTest.java)
* TCP socket的server简单使用[示例服务端](./src/NetworkStudy/Server.java)
* java调用其他程序或者命令并获取返回值。[示例](./src/NetworkStudy/NetStat.java)
* IO流，（不包括NIO的库使用），包括文件字符流和字节流、缓冲字符输入输出、内存字节流、管道字节流、Scan输入、文件和目录的操作、Path。 [示例](./src/baseAPI/useIO.java)
* NIO [示例](./src/baseAPI/useNIO.java):
  * Buffer类帮助方便管理缓存和高效使用缓存；
  * Selector帮助同时监听读写多个Channel,比如SocketChannel，就相当于C++里面的select socket;
  * FileChannel读写文件的一种channel，为了配合Select读写文件，就得用这个，如果只是想读写文件，就直接用File相关的Stream；[详细介绍](http://blog.51cto.com/ggwhsd/2341370)

* NIO客户端和服务器端示例
* NIO的回调示例
* NIO的Reactor方式编程

* NumberFormat类，用于转换各种数字到字符串，内置了很多转换格式，用于满足字符串显示需求。包括整数、小数、百分比，以及不同语言下的显示。
* sigar库 获取系统信息包括内存、操作系统、网卡、磁盘和CPU信息，以及CPU运行情况等系统性能指标。 [示例](./src/baseAPI/useSigar.java) 
* json 库 使用了gson库。 [示例](./src/baseAPI/gsonBase.java)
* System.gc，以及finalize方法 [示例](./src/baseAPI/useSystem.java)
* 自定义注解，以及使用。[示例](./src/AnnotationStudy/AnnotationTest.java)




* 线程库
   * 线程的创建和使用。 [示例1](./concurrent/Thread_01/RunnableTest.java) -- [示例2](./concurrent/Thread_01/ThreadCreateTest.java)
   * 线程的yield和interrupt。 [示例](./concurrent/Thread_02/yieldAndInterruptTest.java)
   * 线程的volatile关键字的使用。volatile可以保证编译的顺序性，以避免编译器对其优化重排序。 [示例](./concurrent/Thread_03/violateStudy.java)
   * 线程的synchronized使用。 [示例](./concurrent/synchronizedStudy/toy.java)
   * 线程的通信notify和wait。 [示例](./concurrent/Thread_03/notifyWaitStudy.java)
   * 线程组的概念,主要用于组织线程，并不用来管理线程。 [示例](./concurrent/Thread_03/ThreadGroupStudy.java)
   * 线程池，简单的使用方式ThreadPoolExecutor的方式newCachedThreadPool，线程池中的线程超过60s会自动释放。  [示例](./concurrent/ThreadPoolTest/Run1.java)
   * 线程池，创建固定线程池newFixedThreadPool,线程池中的线程不会自动释放，除非调用shutdown。 [示例](./concurrent/ThreadPoolTest/Run2.java)
   * 线程池，创建可调度的线程池newScheduledThreadPool,可以延迟多久之后以某个频率执行任务。 [示例](./concurrent/ThreadPoolTest/Run3.java)
   * 线程池，创建单一线程池，实际上就是一个不阻塞当前执行线程的fifo的队列，例如消息总线的实现方式，GUI单线程等。newSingleThreadExecutor,以及Executors.newSingleThreadExecutor()。 [示例](./concurrent/ThreadPoolTest/Run4.java)
   * 线程池，重定义创建线程的方法，实现ThreadFactory接口 [示例](./concurrent/ThreadPoolTest2/test.java)
   * 线程池，继承ThreadPoolExecutor，实现自定义的线程池,并且重写了afterExecute和beginExecute。 [示例](./concurrent/ThreadPoolTest3/)
   
* 并发容器库
   * ConcurrentHashMap
   * ConcurrentLinkedQueue
   * ConcurrentSkipListMap
   * ConcurrentSkipset
   * ExchangerTest
   

* ClassLoader类加载
   * 每个类在jvm中只有首次被主动调用才会进行初始化，6种主动调用。[示例](./src/classLoaderStudy/ClassInit1.java)
   * JVM中内置的三个ClassLoader [示例](./src/ClassLoaderStudy/classLoaderTest.java)
   * 自定义加载类方式1[示例](./src/ClassLoaderStudy/MyClassLoader.java)
   * 自定义加载类方式2，和示例1本质一样，只是代码示例更多一些，通过循环导入class文件进行热部署效果示例。[示例](./src/OtherPorjects/NIO/src/classLoader/LoaderTest.java)

* 单例模式的几种方式
   * 饿汉模式,可以保证多个线程下的唯一实例。[示例](./src/DesignPattern/Sigleton/Singleton01.java)
   * 懒汉模式：在初始化时不会创建instance，只有在getinstance使用时才会创建。不支持多线程安全。[示例](./src/DesignPattern/Sigleton/Singleton02.java)
   * 懒汉 + 同步 模式：懒汉 + 同步 模式: 多线程安全，唯一的不好就是在于每次只能一个线程访问getinstance，因此不适合高并发的场景下频繁使用。 [示例](./src/DesignPattern/Sigleton/Singleton03.java)
   * double check : 原理跟懒汉+同步模式差不多，只是synchronized不放在方法上，而是放在具体代码块中，使得可以多个线程同时访问。如果需要再初始化类的代码里面，有包含其他初始化操作的变量，可以对这些变量使用volatile关键字，保证顺序编译。[示例](./src/DesignPattern/Sigleton/Singleton04.java)
   * 内部类 模式：这是单例模式好的设计之一，也是经常使用的一种方式。利用静态内部类中的静态成员，即达到了延迟初始化，又保证了同步，还使得多线程可以高并发访问。[示例](./src/DesignPattern/Sigleton/Singleton05.java)

* 设计模式and线程编程模式
   * 所有的模式，都不要生搬硬套，引入模式一般会引入系统复杂度，能更搞笑简单的处理问题时，就不要急着引入设计模式。
   * 观察者模式，应用在监控任务状态。[示例](./src/DesignPattern/ObservePattern/TestObservableThread.java)
   * 策略模式 [示例](./src/DesignPattern/Strategy/StrategyTest.java)
   * 迭代器模式 [示例](./src/DesignPattern/IteratorPattern/MyIterator.java)
   * 责任链模式 [示例](./src/DesignPattern/HandlerChain/HandleChainTest.java)
   * 命令模式 [示例](./src/DesignPattern/Command/CommandTest.java)
   * 状态模式 [示例](./src/DesignPattern/StatePattern/StateTest.java)
   * 访问者模式 [示例](./src/DesignPattern/VisitorPattern/VisitorTest.java)
   * 中介者模式 [示例](./src/DesignPattern/MediatorPattern/MediatorTest.java)
   * --上述为行为模式，以下为创建型模式
   * 抽象工厂方法 [示例](./src/DesignPattern/AbstractFactory/usePattern.java)
   * 普通工厂方法， [示例](./src/DesignPattern/FactoryPattern/uesPattern.java)
   * -- 多个工厂方法模式 [示例](./src/DesignPattern/FactoryPattern/ShapeFactory_MultiMedod.java)
   * -- 静态工厂方法模式 [示例](./src/DesignPattern/FactoryPattern/ShapeFactory_staticMedod.java)
   * 建造者模式 [示例](./src/DesignPattern/Builder/BuilderTest.java)
   * 原型模式 [示例](./src/DesignPattern/Prototype/PrototypeTest.java)
   * --上述为创建型模式，以下为结构性模式
   * 类适配器 [示例](./src/DesignPattern/Adapter/AdapterTestOne.java)
   * 对象适配器 [示例](./src/DesignPattern/Adapter/AdapterTwoOne.java)
   * 接口适配器 [示例](./src/DesignPattern/AdapterInterfaces/AdapterTest.java)
   * 外观模式 [示例](./src/DesignPattern/Facade/FacadeTest.java)
   * 装饰者模式，一种横向扩展方式，和对象适配器模式很像，但是是相同接口，而适配器都是针对不同接口。 [示例](./src/DesignPattern/Decorator/DecoratorTest.java)
   * 代理模式，与装饰不同，内部对象由自己创建，这样才是代理。 [示例](./src/DesignPattern/Proxy/ProxyTest.java)
   * 桥接模式，强调两个模块可以自由变化，但是又通过接口和继承组合在一起。 [示例](./src/DesignPattern/Bridge/BridgeTest.java)
   * 享元模式，实际上就是线程池的实现模式。 [示例](./src/DesignPattern/Flyweight/FlyweightTest.java)
   
   
   