package class1;

public class Employe {
	int id;
	String name;
	String add;
	public Employe(int id, String name, String add) {
		
		this.id = id;
		this.name = name;
		this.add = add;
	}
	public void Display() {
		System.out.println("id:"+ id);
		System.out.println("name:"+name);
		System.out.println("add:"+add);
		
	}
	public static void main(String[] args) {
		Employe a=new Employe(1,"marina","bhaktpur");
		a.Display();
	}

}
