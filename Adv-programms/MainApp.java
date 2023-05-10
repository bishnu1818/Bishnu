import com.nit.fundas.WishMessageGenerator;
public class MainApp 
{
	public static void main(String[] args) 
	{
		WishMessageGenerator generator=new WishMessageGenerator();
		String result =generator.generator("Rani");
		System.out.println(result);
	}
}
