package ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args)
	{
		SomeClass s1,s2,s3,s4,s5;
		
		s1=new SomeClass(1);
		s2=new SomeClass(2);
		s3=new SomeClass(3);
		s4=new SomeClass(4);
		s5=new SomeClass(5);
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		executor.submit(s1);
		executor.submit(s2);
		executor.submit(s3);
		executor.submit(s4);
		executor.submit(s5);
		
	}
	
}
