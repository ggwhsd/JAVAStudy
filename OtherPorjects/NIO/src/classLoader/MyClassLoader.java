package classLoader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader{
	@Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 加载D盘根目录下指定类名的class
        String clzDir = "G:\\" + File.separatorChar
                + name.replace('.', File.separatorChar) + ".class";
        System.out.println(clzDir);
        byte[] classData = getClassData(clzDir);

        if (classData == null) {
            throw new ClassNotFoundException();
        } else {
            return defineClass(name, classData, 0, classData.length);
        }
    }
	
	//从文件流读取到字节流中
	private byte[] getClassData(String path) {
        try (InputStream ins = new FileInputStream(path);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()
        ) {

            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
