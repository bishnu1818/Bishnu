package in.ashok.beans;

public class car {
	
	public car() {
		System.out.println("car class constructor exicuted");
	}
	
	private IEngine eng;
	
	

	public void setEng(IEngine eng) {
		this.eng=eng;
	}
	public void drive() {
		
		int engstatus=eng.start();
		if(engstatus==1) {
			System.out.println("Engine Started");
		}
		else {
			System.out.println("Engine not Started");
		}
		
	}

}
