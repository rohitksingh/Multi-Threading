public class CreateThread {

	public static void main(String[] args)
	{
		Receiver rohit=new Receiver("Rohit");
		Receiver dooms=new Receiver("dooms");
		
		//Sequntial 
		/* Uncomment for running code sequentialy without threads
		rohit.sendMsg();
		dooms.sendMsg();
		*/
		
		//Parallel
		//1) uSING Threads
		
		rohit.start();
		dooms.start();
		
		//2) Using implements
		/*Uncomments it 
		Thread t1=new Thread(new Sender("Trumph"));
		Thread t2=new Thread(new Sender("Hilary"));
		
		t1.start();
		t2.start();
		*/
		
		
	}

}

/*First way
 * 
 */
class Receiver extends Thread {
	
	private String name;

	public Receiver(String name)
	{
		this.name=name;
	}
	
	public void run()
	{
		receiveMsg();
	}
	
	public void receiveMsg()
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(name+" Receiving msg.."+i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}


class Sender implements Runnable{
	
	private String name;
	
	public Sender(String name)
	{
	   this.name=name;
	}
	
	@Override
	public void run()
	{
		sendMsg();
	}
	
	public void sendMsg()
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(name+" Sending msg..."+i);
		}
	}
	
}