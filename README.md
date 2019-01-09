# JAVAStudy
JAVA 1.8

* 新增Log4j的使用示例。[示例](./src/logStudy/useLog4J.java) ，[log4j的详细介绍](http://blog.51cto.com/ggwhsd/2340510)

* 关于java中时间的使用。[示例](./src/baseAPI/useDate.java)   

* 国际化ResourceBundle的使用。 [示例](./src/baseAPI/useResourceBundle.java) ,  [ResourceBundle的详细介绍](http://blog.51cto.com/ggwhsd/2340539)

* Math库的使用。  [示例](./src/baseAPI/useMath) 

* 运行时操作Runtime类的使用，读取内存使用情况，垃圾回收，调用外部进程，获取可用的cpu个数。 [示例](./src/baseAPI/useRuntime)

* StringBuffer类，相比较String，提升代码性能。StringBuffer是线程安全的。 StringBuffer清空，可以用setLength(0)或者delete(0, strBuff.length())，两者差不多，不建议new StringBuffer("")。[示例](./src/baseAPI/useStringBuffer.java)

* TCP socket使用
[示例客户端](./src/NetworkStudy/TcpTest.java)
[示例服务端](./src/NetworkStudy/Server.java)