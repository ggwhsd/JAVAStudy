package com.gugw.demo.zookeeperDemo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
    	
        super( testName );
        System.out.println("here show AppTest");
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
    	System.out.println("here show test");
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     * 每个测试方法，都会创建一个测试实例
     */
    public void testApp()
    {
    	System.out.println("here show testApp");
        assertTrue( true );
    }
    
    public void testApp02()
    {
    	System.out.println("here show testApp2");
        assertTrue( true );
    }
    
    public void testApp03()
    {
    	System.out.println("here show testApp3");
        assertTrue( true );
    }
}
