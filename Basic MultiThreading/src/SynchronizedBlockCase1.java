

public class SynchronizedBlockCase1 {

	int washbasin1=0;
	
	public static void main(String[] args)
	{
		SynchronizedBlockCase1 s=new SynchronizedBlockCase1();
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
	}
	
	
	class Person implements Runnable{

		private String name;
		
		public Person(String name)
		{
			this.name=name;
		}
		
		@Override
		public void run() {
			use();
		}
		
		public void use()
		{
			
			for(int i=0;i<1000;i++)
			{
				synchronized(SynchronizedBlockCase1.this)    ///comment out synchronized keyword and see total usage will be less than 2000 which is absurd
				{
				System.out.println(name+" "+washbasin1);
				washbasin1++;
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

