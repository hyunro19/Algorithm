package test;

public class Parent {
	String string = "Parent";
	public void sayName() {
		System.out.println(string);
	}
	
	protected void makeChild() {
		System.out.println("makeChildfromParent");
	}
	
}


class Child extends Parent {
	String string = "Child";
	public void sayName() {
		System.out.println(string);
	}
	
	protected void makeChild() {
		System.out.println("makeChildfromChild");
	}
}