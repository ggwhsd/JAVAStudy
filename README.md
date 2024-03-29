# JAVAStudy
JAVA 1.8

* 关于java中时间的使用。[示例](./src/baseAPI/useDate.java)   
* 国际化ResourceBundle的使用。 [示例](./src/baseAPI/useResourceBundle.java) ,  [ResourceBundle的详细介绍](http://blog.51cto.com/ggwhsd/2340539)
* Math库的使用。  [示例](./src/baseAPI/useMath) 
* 运行时操作Runtime类的使用，读取内存使用情况，垃圾回收，调用外部进程(更详细的可以参考NetworkStudy目录下的示例)，获取可用的cpu个数。 [示例](./src/baseAPI/useRuntime)
* StringBuffer类，相比较String，提升代码性能。StringBuffer是线程安全的。 StringBuffer清空，可以用setLength(0)或者delete(0, strBuff.length())，两者差不多，不建议new StringBuffer("")。[示例](./src/baseAPI/useStringBuffer.java)
* String关于中文的使用，以及字节数组的胡转换。 [示例](./src/baseAPI/useString.java)
* TCP socket的client简单使用[示例客户端](./src/NetworkStudy/TcpTest.java)
* TCP socket的server简单使用[示例服务端](./src/NetworkStudy/Server.java)
* java调用其他程序或者命令并获取返回值。[示例](./src/NetworkStudy/NetStat.java)
* IO流，（不包括NIO的库使用），包括文件字符流和字节流、缓冲字符输入输出、内存字节流、管道字节流、Scan输入、文件和目录的操作、Path。 [示例](./src/baseAPI/useIO.java)
* NIO [示例](./src/baseAPI/useNIO.java):
  * Buffer类帮助方便管理缓存和高效使用缓存；
  * Selector帮助同时监听读写多个Channel,比如SocketChannel，就相当于C++里面的select socket;
  * FileChannel读写文件的一种channel，为了配合Select读写文件，就得用这个，如果只是想读写文件，就直接用File相关的Stream；[详细介绍](http://blog.51cto.com/ggwhsd/2341370)

* NIO 单独 客户端 [示例](./src/NIOStudy/Client.java)
* NIO 单独 服务器端，多路复用方式，也可以叫做Reactor模式之一，单线程单个select监听accept、read事件，以及单线程处理所有连接的read数据 [示例](./src/NIOStudy/Server.java)
* NIO 单独 服务器端，非多路复用方式，每个线程循环read一个socketchannel数据。  [示例](./src/NIOStudy/ServerThread.java)
* NIO 单独 线程中，future的使用.[示例](./src/NIOStudy/Future/FutureDemo.java)
* NIO 单独 Reactor模式，单线程select处理accept、read事件，另一个单线程select处理read数据。[示例](./src/NIOStudy/Rector/MainSubReactorThreadServer.java)
* 多路复用对于连接数多，并且数据量并不大的情况下，也就是高并发的情况特别有效。 连接数少但是单个连接数据量大的情况，复用方式处理时间上可能会稍长，可以考虑选择非多路复用方式。
* NIO 还可以通过多线程多个用于accept的select，这样就可以监听不同端口，多个用于read的select，将不同的channel进行分组，每个read的select处理一组channel的read事件。这样多线程之间就不会共用channel了。
* 自定义注解，以及使用。[示例](./src/AnnotationStudy/AnnotationTest.java)
* System.gc，以及finalize方法 [示例](./src/baseAPI/useSystem.java)
* 自定义Comparator类的compare实现，容器Map中的比较使用。[示例](./src/baseSyntax/SortCompare.java)
* NumberFormat类，用于转换各种数字到字符串，内置了很多转换格式，用于满足字符串显示需求。包括整数、小数、百分比，以及不同语言下的显示。
* sigar库 获取系统信息包括内存、操作系统、网卡、磁盘和CPU信息，以及CPU运行情况等系统性能指标。 [示例](./src/baseAPI/useSigar.java) 
* json 库 使用了gson库。 [示例](./src/baseAPI/gsonBase.java)

* 新增Log4j的使用示例。[示例](./src/logStudy/useLog4J.java) ，[log4j的详细介绍](http://blog.51cto.com/ggwhsd/2340510)

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
   * ThreadLocal。该变量在每个线程中都会生成一个本地线程的副本，所有操作都是针对该副本，这样对于一些非线程安全的类对象，就可以通过每个线程副本独立安全的提供功能。
   那么为什么不直接代码块内部创建一个局部变量？可以直接创建，每个线程在调用一次时候，都new一个对象没有问题，但是这样子开销会随着线程运行次数的增加而增加，如果我们用的线程池是8个，采用ThreadLocal只要创建8个副本，而不采用的话，则是按照线程执行次数计算。 [示例](./concurrent/ThreadLocalStudy/appTest.java)
  讲的很容易理解。 
   
* 并发容器库
   * ConcurrentHashMap
      * hashmap 非线程安全 [示例](./concurrent/ConcurrentHashMap/testhashmap.java)
      * hashtable 线程安全 [示例](./concurrent/ConcurrentHashMap/testhashtable.java)
      * concurrentHashMap 专为并发设计hashmap [示例](./concurrent/ConcurrentHashMap/testConcurrentHashMap.java)
      * hashtable 本身线程安全，但是其迭代器是不能多线程同时读和增删数据的。[示例](./concurrent/ConcurrentHashMap/testhashtable2.java)
      * concurrentHashMap，支持迭代器多线程安全更新。 [示例](./concurrent/ConcurrentHashMap/testConcurrentHashMap2.java)
      
   * ConcurrentLinkedQueue [示例](./concurrent/ConcurrentLinkedQueue/testConcurrentLinkedQueue.java)
   * ConcurrentSkipListMap，Skip list(跳表）是一种可以代替平衡树的数据结构。一般情况下，性能比concurrenthashMap慢几倍。[示例](./concurrent/ConcurrentLinkedQueue/TestConcurrentSkipListMap.java)
   * ConcurrentSkipset ，数据类实现了equals接口、comparable接口、hashcode接口。 集合不能有重复。[示例](./concurrent/TestConcurrentSkipListSet.java)
   * Exchanger, 两个线程之间同步安全的交换数据的一种方式。本质上与notify和wait相似。 [示例](./concurrent/ExchangerTest.java)
   

* ClassLoader类加载
   * 每个类在jvm中只有首次被主动调用才会进行初始化，6种主动调用。[示例](./src/classLoaderStudy/ClassInit1.java)
   * JVM中内置的三个ClassLoader [示例](./src/ClassLoaderStudy/classLoaderTest.java)
   * 自定义加载类方式1[示例](./src/ClassLoaderStudy/MyClassLoader.java)
   * 自定义加载类方式2，和示例1本质一样，只是代码示例更多一些，通过循环导入test.class文件进行热部署效果示例。[示例](./src/ClassLoaderStudy/LoadTest.java)

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
   
* 算法和数据结构
   * 二叉树 [示例](./src/algorithm/BTree.java)
   * 递归 [示例](./src/algorithm/DiGui.java)
   * 数字和人民币中文转换 [示例](./src/algorithm/RMB.java)
   * 小顶堆构建，堆使用数组。[示例](./src/algorithm/SmallHeap.java)
   * 利用堆构造优先队列。 [示例](./src/algorithm/PriorityQueue.java)
   * 冒泡排序，O(n*n) 以及优化版 [示例1](./src/algorithm/bubbleSort1.java) [示例2](./src/algorithm/bubbleSort2.java) [示例3](./src/algorithm/bubbleSort3.java) [示例4](./src/algorithm/bubbleSort4.java)
   * 快速排序，O(nlogn) 分治算法使用双循环[示例](./src/algorithm/QuickSort1.java)和单循环[示例](./src/algorithm/QuickSort2.java)
   * 堆排序，对无需数组进行堆构造。 然后 每次将对顶元素与最后一个未更换过位置的元素进行调换，再做一次下沉操作，重复以上调换和下沉，最后可以得到一个有序数组。大顶堆，排序之后是从小到大排序。[示例](./src/algorithm/HeapSort.java)
   
   
* Netty网络库的使用 *
   * Netty底层也用的NIO的那套机制，简化了使用者，只要传入几个参数，即可创建网络功能。创建一个server。 [示例](./OtherProjects/Netty/src/main/java/Demo/TestNetty.java)
   * NioEventLoopGroup可以理解为一个线程池，内部维护了一组线程，每个线程负责处理多个Channel上的事件，而一个Channel只对应于一个线程，这样可以回避多线程下的数据同步问题。
 
* Zookeeper的关于添加Watcher的使用 [示例](./OtherProjects/zookeeperDemo/src/main/java/com/gugw/demo/zookeeperDemo/App.java)

* Redis客户端*
   * 连接池的使用. [示例](./OtherProjects/zookeeperDemo/src/main/java/com/gugw/demo/redis/redisApp.java)
   * 常用数据结构的使用，字符串增删改查。列表增删改查。集合的增删改查。有序集合的增删改查。哈希的增删改查。常用管理接口。 [示例](./OtherProjects/zookeeperDemo/src/main/java/com/gugw/demo/redis/redisApp.java) 
   * 事务的开启、执行、取消。 [示例](./OtherProjects/zookeeperDemo/src/main/java/com/gugw/demo/redis/redisTransactionApp.java)

* ActiveMQ 客户端*
   * Queue队列方式,生产者 [示例](./OtherProjects/zookeeperDemo/src/main/java/com/gugw/demo/activeMQ/Producer.java)
   * Queue队列方式,消费者 [示例](./OtherProjects/zookeeperDemo/src/main/java/com/gugw/demo/activeMQ/Comsumer.java)
   * Queue的使用。 [示例](./OtherProjects/zookeeperDemo/src/main/java/com/gugw/demo/activeMQ/activeMQApp.java)
   * Topic的使用 
   https://www.cnblogs.com/jaycekon/p/6225058.html
   

* Spring包含很多子项目，比如
   * Spring Framework Core
   * Spring Boot
   * Spring Cloud
   * Spring Batch
   * Spring Data
   * Spring Security
   * Spring Web Flow
   * Spring AMQP
   * Spring .NET
   * Spring Web Service: SOAP
   * Spring LDAP
   * SPring Session

# Spring Cloud 

* Spring Cloud gateway：具备路由、负载均衡、权限控制等功能，隔离客户端和微服务，向客户端隐藏应用服务的划分和集成细节。
[示例](./OtherProjects/SpringBootRoute/HELP.md)

* Spring Cloud EurekaServer ，注册中心 。  [示例](./OtherProjects/SpringBootEurekaServer/HELP.md)

* SPring Cloud Zookeeper 也可以用于注册中心，具体示例可以网上查找。

* Spring Cloud EurekaClient，且为服务提供者。 [示例](./OtherProjects/SpringBootEurekaClient/HELP.md)

* Spring Cloud EurekaClient，且为服务消费者。此处演示利用服务中心提供的服务，服务消费者发起消费，进行负载均衡到多个相同服务的服务提供者。 [示例](./OtherProjects/SpingBootEurekaClientConsumer/HELP.md)

* Spring Cloud Security ,登录验证模块。 [实例](./OtherProjects/SpringBootSecurity/HELP.md)

* Spring Cloud Hystrix， 断路器，提供了熔断、隔离、回退、缓存、监控等功能。

* Spring Cloud Config，配置中心，Server和Client模式。  

* Spring Cloud Zookeeper也可以用作配置。 示例演示了快捷方式从zookeeper中加载数据到程序中。    [示例](./OtherProjects/SpringBootZookeeperConfig/HELP.md)

* Spring Cloud Sleuth 服务跟踪，利用日志库来记录，我觉得就是日志记录。

* SPring Cloud Zipkin 服务跟踪，server和client模式。  client所有接收请求都会记录日志到Server中，在CLient中无需显示调用相关Zipkin请求。

* Spring Cloud Bus 是消息，结合Kafka或者RabbitMQ等进行广播消息。 只用spring cloud config的时候，一旦config server上保存的配置数据变化，需要重启config client应用，但结合spring cloud config 和 bus，可以实现通过对 config server上发送一个bus-refresh，配置自动同步到所有 config client上。

* Spring Boot Admin 一个监控Springboot的项目，提供webui界面。[./OtherProjects/SpringBootAdminServer],接入该admin的client的示例[./OtherProjects/SpringBootAdminClient]

* Spring Boot: demo性质项目，包含了基本的mvc框架使用，controller请求参数的几种方式，restful风格的使用基础以及aop的使用方式。 [./OtherProjects/SpringBootDemo/demo1], 以及前后端分离的restful案例，[./OtherProjects/SpringBootDemo/Demo8web]

# web前端开发
* javascript [示例](./OtherProjects/SpringBootWebStudy/HELP.md)
* css [示例](./OtherProjects/SpringBootWebStudy/HELP.md)
* vue  [示例](./OtherProjects/SpringBootWebStudy/HELP.md) 
* bootstrapTable表格库 [示例](./OtherProjects/SpringBootWebStudy/HELP.md) 
* EChart柱状图和饼图 [示例](./OtherProjects/SpringBootWebStudy/src/main/resources/static/04Echart/EChartDemo1.html) 
* EChart 异步更新柱状图 [示例](./OtherProjects/SpringBootWebStudy/src/main/resources/static/04Echart/EChartDemo2.html) 
* EChart实时更新曲线图1 [示例](./OtherProjects/SpringBootWebStudy/src/main/resources/static/04Echart/EChartDemo3.html) 
* EChart实时更新曲线图2 [示例](./OtherProjects/SpringBootWebStudy/src/main/resources/static/04Echart/EChartDemo4.html) 
* EChart拖拽折线图 [示例](./OtherProjects/SpringBootWebStudy/src/main/resources/static/04Echart/EChartDemo5.html) 
* EChart画流程图。[示例](./OtherProjects/SpringBootWebStudy/src/main/resources/static/04Echart/EchartFlowChart.html)

# 工具

* 基于SpringBoot框架的web文件服务器，可以上传和下载特定目录文件。[示例](./OtherProjects/FileServerApp/HELP.md)                                                         