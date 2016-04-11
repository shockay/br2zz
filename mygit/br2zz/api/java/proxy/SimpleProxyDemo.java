package proxy;
public class SimpleProxyDemo {
	public static void consumer(Interface iface) {
		iface.doSomething();
		iface.somethingElse("测试");
	}
	public static void main(String[] args) {
		//consumer(new RealObject());
		consumer(new SimpleProxy(new RealObject()));
	}
}
