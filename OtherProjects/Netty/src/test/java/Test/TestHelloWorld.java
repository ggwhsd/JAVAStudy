package Test;

import org.junit.Test;

import Demo.HelloWorld;

import org.junit.Assert;
public class TestHelloWorld {
	@Test
	public void testSayHello() {
		HelloWorld helloWorld = new HelloWorld();
		Assert.assertEquals(helloWorld.sayHello(), "hello maven");
	}
}
