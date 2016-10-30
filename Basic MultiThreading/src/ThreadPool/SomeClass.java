package ThreadPool;

public class SomeClass implements Runnable{

	private int id;
	
	public SomeClass(int id){
		this.id=id;
	}
	
	public void someProcess()
	{
		System.out.println("Starting Thread "+id);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Ending Thread "+id);
	}

	@Override
	public void run() {
		someProcess();
	}
	
	
}
