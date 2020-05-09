package test;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;

public class Test2 {

	public static void main(String[] args) throws Exception {
		long j = 1;
		for(int i=0; i<50; i++) {
			j*=2;
			System.out.println(i+", "+j);
		}
			
		System.out.println(Integer.MAX_VALUE);

	    ScriptEngineManager mgr = new ScriptEngineManager();
	    ScriptEngine engine = mgr.getEngineByName("JavaScript");

		Long a = 100000000L;
		Long b = 300000L;
		char c = '*';
		String ex = ""+a+c+b;
		Object o = engine.eval(ex);
		System.out.println(o.getClass());
		System.out.println(engine.eval(ex));
		
		
	}

}
