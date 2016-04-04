package adapter;

public class Adapter extends Target{
	
	// 建立一个私有的Adeptee对象
    private Adaptee adaptee = new Adaptee();

  /// 通过重写，表面上调用Request()方法，变成了实际调用SpecificRequest()
	@Override
	public void Request() {
		adaptee.SpecificRequest();
	}
	
	
	
}
