package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static util.Print.*;

/**
 * 动态代理过滤不必要的方法
 * @author pearl
 *
 */
class MethodSelector implements InvocationHandler {
	private Object proxied;
	public MethodSelector(Object proxied) {
		this.proxied = proxied;
	}
	public Object invoke(Object proxy , Method method , Object[] args) throws Throwable {
		if(method.getName().equals("interesting"))
			print("Proxy detected the interesting method");   //代理对象选中的某一方法
		//构造器里传递过来的接口的方法一一调用
		return method.invoke(proxied, args);
	}
}

interface SomeMethods {
	void boring1();
	void boring2();
	void interesting(String arg);
	void boring3();
}

class Implementation implements SomeMethods {
	public void boring1(){print("boring1");}
	public void boring2(){print("boring2");}
	public void interesting(String arg){
		print("interesting " + arg);
	}
	public void boring3(){print("boring3");}
}
public class SelectingMethods {
	public static void main(String[] args) {
		SomeMethods proxy = (SomeMethods) Proxy.newProxyInstance(
				SomeMethods.class.getClassLoader(),
				new Class[]{ SomeMethods.class },
				new MethodSelector(new Implementation()));
		proxy.boring1();
		proxy.boring2();
		proxy.interesting("bonobo");  //执行该方法时，动态代理会监测出为target,则
										//先执行代理对象的任务
		proxy.boring3();
		System.exit(0); //关闭JVM
	}
}
