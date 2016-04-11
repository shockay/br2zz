package demo;
/**
 * 创建对象是Java中最昂贵的操作之一。因此最好在有需要的时候再进行对象的创建/初始化。
 * @author 董槟瑞
 * 2015年10月16日
 * 下午1:49:13
 */
public class CreateObject {

	private Employee employee;
	
	public Employee getEmployees(){
		//initialize only when required
		if(null == employee){
			return new Employee();
		}
		return employee;
	}
	
	
}

class Employee{}
