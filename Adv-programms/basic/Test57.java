interface Test55
{
	void m1();
	void m2();
}

abstract class Test56 implements Test55
{
  public void m1(){
	}
	
}
class Test57 extends Test56
{
  public	void m2(){
	}
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
