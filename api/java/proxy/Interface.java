package proxy;
import static util.Print.*;
/**
 * 代理
 * @author pearl
 *
 */
interface Interface {
	void doSomething();
	void somethingElse(String arg);
}

class RealObject implements Interface {
	public void doSomething() {
		print("实际对象 doSomething");
	}
	public void somethingElse(String arg) {
		print("实际对象 somethingElse " + arg);
	}
}

class SimpleProxy implements Interface{
	private Interface proxied;
	public SimpleProxy(Interface proxied){
		this.proxied = proxied;	
	}
	public void doSomething() {
		print("代理对象 SimpleProxy doSomething");
		proxied.doSomething();
	}
	public void somethingElse(String arg) {
		print("代理对象 SimpleProxy somethingElse " + arg);
		proxied.somethingElse(arg);
	}
	
	
}


