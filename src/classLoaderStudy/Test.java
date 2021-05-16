
package classLoaderStudy;
//放到g:\\盘根目录下，编译成class文件 ：javac -encoding utf8 Test.java
//然后启动MyClassLoader程序，在运行期间，可以改动Test代码，重新编译，可以看到MyClassLoader中会更新会最新的代码。
public class Test {

    public void test() {
        System.out.println("Test类已成功加载运行！");
        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println("加载我的classLoader：" + classLoader);
        System.out.println("classLoader.parent：" + classLoader.getParent());
        
        System.out.println("********************热部署***********************");
        
    }
}
