
package classLoaderStudy;
//�ŵ�g:\\�̸�Ŀ¼�£������class�ļ� ��javac -encoding utf8 Test.java
//Ȼ������MyClassLoader�����������ڼ䣬���ԸĶ�Test���룬���±��룬���Կ���MyClassLoader�л���»����µĴ��롣
public class Test {

    public void test() {
        System.out.println("Test���ѳɹ��������У�");
        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println("�����ҵ�classLoader��" + classLoader);
        System.out.println("classLoader.parent��" + classLoader.getParent());
        
        System.out.println("********************�Ȳ���***********************");
        
    }
}
