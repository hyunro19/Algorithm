package test;

public class Test {
	static int len = 5;
	
	public static void recursion() {
		recursion();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		for(int i=0; i<len; i++) {
//			System.out.println("½ÇÇà");
//			length();
//		}
		
//		recursion();
		
		Parent p = new Parent();
		Child c = new Child();
		Parent pc = new Child();
		p.makeChild();
		c.makeChild();
		pc.makeChild();
//		p.sayName();
//		c.sayName();
//		pc.sayName();
//		System.out.println(p.string);
//		System.out.println(c.string);
//		System.out.println(pc.string);
		
		Unit unit = new Unit();
		Attackable attack = new Unit();
		Detectable detect = new Unit();

		attack.attack();
		detect.detect();
		unit.attack();
		unit.detect();
		unit.walk();
		
		
	}
	
	public static int length() {
		System.out.println("length");
		len++;
		System.out.println(len);
		return len;
	}
	
	public static int overriding(int k, String a) {
		System.out.println("int+String");
		return 0;
	}
	
	public static int overriding(String a, int k) {
		System.out.println("String+int");
		return 0;
	}
	

	
	

}

class Unit implements Attackable, Detectable {

	@Override
	public void detect() {
		System.out.println("detect");
	}

	@Override
	public void attack() {
		System.out.println("attack");
	}
	
	public void walk() {
		System.out.println("walk");
	}
	
}

interface Attackable {
	void attack();
}

interface Detectable {
	void detect();
}
