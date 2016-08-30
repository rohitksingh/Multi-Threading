public class SynchronizedBlockCase2 {

int washbasin1=0;
int washbasin2=0;
	
	Object lock1=new Object();
	Object lock2=new Object();
	
	public static void main(String[] args)
	{
		
		SynchronizedBlockCase2 s=new SynchronizedBlockCase2();
		s.useBasin1();
	}
	
	public void useBasin1()
	{
		
		Thread t1=new Thread(new Person("P1"));
		Thread t2=new Thread(new Person("P2"));
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Total Usage of washbasin 1 is "+washbasin1+" litres");
		System.out.println("Total Usage of washbasin 2 is "+washbasin2+" litres");
	}
	
	
	
	
	class Person implements Runnable{

		private String name;
		
		public Person(String name)
		{
			this.name=name;
		}
		
		@Override
		public void run() {
			useWashroom();
		}
		
		public void useWashroom()
		{
			useB1();
			useB2();
		}
		
		public void useB1()
		{
			for(int i=0;i<1000;i++)
			{
				synchronized(lock1)    ///comment out synchronized keyword and see total usage will be less than 2000 which is absurd
				{
				    washbasin1++;
				   // System.out.println(name +" "+washbasin2);
				}
			 try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		}
		
		public void useB2()
		{
			for(int i=0;i<1000;i++)
			{
				
				synchronized(lock2)    ///comment out synchronized keyword and see total usage will be less than 2000 which is absurd
				{
				   washbasin2++;
				   //System.out.println(name +" "+washbasin2);
				}
			 try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		}
		
	}
}