package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxyHandler implements InvocationHandler {
	private Object proxied;

	public DynamicProxyHandler(Object proxied) {
		this.proxied = proxied;
	}
	public Object invoke(Object proxy , Method method , Object[] args) throws Throwable {
		System.out.println("*** proxy:" + proxy.getClass() + ", method: " + method + 
				", args: " + args);
		if(args != null)
			for(Object arg : args)
				System.out.println(" " + arg);
		return method.invoke(proxied, args); //将请求转发给被代理对象
	}
	
}

public class SimpleDynamicProxy {
	public static void consumer(Interface iface) { 
		iface.doSomething();
		System.out.println("---------------------------------");
		iface.somethingElse("bonobo");
	}
	public static void main(String[] args) {
		RealObject real = new RealObject();
		//consumer(real);
		//insert a proxy and call again:
		Interface proxy = (Interface)Proxy.newProxyInstance( //创建动态代理
				Interface.class.getClassLoader(), 
				new Class[]{ Interface.class }, //代理实现的接口列表
				new DynamicProxyHandler(real));
		consumer(proxy);
	}
}

