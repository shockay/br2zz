package reflection;

import static util.Print.print;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import reflection.interfacea.A;
import reflection.packageacess.HiddenC;

public class HiddenImplementation {
	public static void main(String[] args) throws Exception {
		A a = HiddenC.makeA();
		a.f();
		print(a.getClass().getName());
		
		//Compile error cannot find symbol "C"
		/*if(a instanceof C){
			C c = (C)a;
			c.g();
		}*/
		
		callHiddenMethod(a, "g");
		callHiddenMethod(a, "u");
		callHiddenMethod(a, "v");
		callHiddenMethod(a, "w");
		
		//尝试修改final域的值
		Field f = a.getClass().getDeclaredField("finalString");
		f.setAccessible(true);
		print("修改前finalString的值为" + f.get(a).toString());
		final String afterString = "修改后finalString";
		try {
			f.set("a", afterString); //修改不成功
			print("------------\n" + f.get(a).toString());
		} catch (Exception e) {
			print("修改不成功，finalString的值为： " + f.get(a));
			print("原因：" + e.getMessage());
		}
		
		System.exit(0);
	}
	
	/**
	 * 利用反射机制执行对象的方法，即使方法是private的，内部类的，匿名类的，都会被反射找到
	 * @param a
	 * @param methodName
	 * @throws Exception
	 */
	static void callHiddenMethod(Object a , String methodName) throws Exception {
		Method g = a.getClass().getDeclaredMethod(methodName);
		g.setAccessible(true);
		g.invoke(a);
	}
}
