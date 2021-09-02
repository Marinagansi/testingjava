
public class Bicycle {
	int gear;
	String name="marina";
	int a;
	int b;
	
	
	public void braking() {
		System.out.println("working of braking");
	}
	public static void main(String[] args) {
		Bicycle sport=new Bicycle();
		sport.gear=4;
		sport.a=5;
		sport.b=4;
		int sum=sport.a+sport.b;
		System.out.println(sport.name);
		System.out.println(sport.gear);
		System.out.println(sum);
		sport.braking();
	}
		
}
