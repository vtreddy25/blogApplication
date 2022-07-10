package ashokit;

public class Car{
	
	public void drive() {
		Engine engine=new Engine();
		int status = engine.start();
		if(status >= 1 ) 
			System.out.println("you can drive now");
		else
				System.out.println("Something is fishy..u can't drive");
	}

}
