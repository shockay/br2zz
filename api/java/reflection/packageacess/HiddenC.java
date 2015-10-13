package reflection.packageacess;

import static util.Print.print;
import reflection.interfacea.A;

class C implements A {
	public void f(){ print("public C.f()"); }
	public void g(){ print("public C.g()");}
	void u(){print("package C.u()") ;}
	protected void v(){ print("protected C.v()") ;}
	private void w(){print("private C.w()");}
	private final String finalString ="final类型的域是不会被修改的";
}

public class HiddenC {
	public static A makeA(){
		return new C();
	};
}
