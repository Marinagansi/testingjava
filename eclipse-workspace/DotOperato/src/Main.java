
public class Main {

	public static void main(String[] args) {
		Bicycle a1=new Bicycle();
		a1.gear=4;
		a1.a=5;
		a1.b=4;
		int sum=a1.a+a1.b;
		System.out.println(a1.gear);
		System.out.println(a1.name);
		System.out.println(sum);
		a1.braking();
		
		
		
	}
}
