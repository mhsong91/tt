package tt;

public class Execute {
	static Object p;
	
	public static Object getP() {
		p = new Student();
		return p;
	}
	public static void main(String[] args) {
		Person p = (Person)getP();
		System.out.println(p);
		Person p1 = (Person)getP();
		System.out.println(p1);
		Person p2 = (Person)getP();
		System.out.println(p2);
	}
}
