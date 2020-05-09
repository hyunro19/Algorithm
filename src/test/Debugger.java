package test;

public class Debugger {

	public static void main(String[] args) {
		int k = 0;
		int o = 0;
		for(int i=0, j=100; i<100; i++, j+=2) {
			if (++k == o++) System.out.println("hellooooo");
			j++;
//			System.out.println(++i+", "+j++);
			System.out.println("hello");
			System.out.println("hell2");
			System.out.println("hell3");
		}

	}

}
