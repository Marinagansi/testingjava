package class1;
import java.util.Scanner;
public class Demo {

	public static void main(String[] args) {
		int a, b;
		Scanner s= new Scanner(System.in);
		System.out.print("enter integer:");
		a=s.nextInt();
		System.out.print("enter second inetger:");
		b=s.nextInt();
		System.out.println(a+b+" is addition of two integer");
		System.out.println(a*b+" is multiplication");
		System.out.println(a/b+" is division");
	}

}