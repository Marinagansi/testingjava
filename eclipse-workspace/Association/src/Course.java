
public class Course {
	int code;
	String name;
	Student a;
	public Course(int code, String name, Student a) {
		super();
		this.code = code;
		this.name = name;
		this.a = a;
	}
	

	public int getCode() {
		return code;
	}


	public void setCode(int code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Student getA() {
		return a;
	}


	public void setA(Student a) {
		this.a = a;
	}


	public static void main(String[]args) {
		Student a=new Student(1,5);
		Course b= new Course(001,"ram",a);
	
		System.out.println(b.code);
		System.out.println(b.name);
		System.out.println(b.getA().getAdd());//course chai student class vitra xa
//		so paila student le adress ko
		//obj lai call garxa ani obj bata k chaine tyo call garne
		System.out.println(b.getA().getRoll());
		
	}
}
