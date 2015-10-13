package reflect;

import java.lang.reflect.Field;
/**
 * 一个Car对象，它组合了一个Wheel对象，虽然这个Wheel对象声明成了private final 的，
 * 但是这个Wheel对象内部的状态可以改变， 那么就不能很好的保证Car对象不可变。
 * @author shockay
 * 2015年10月13日
 * 下午5:19:02
 */
public class CarTest {

	public static void main(String[] args) {
		
		String na = "first";
		Wheel w = new Wheel(na);
		Car car = new Car(w);
		String name = car.getWheel().getName();
		System.out.println("before modify:" + name);
		System.out.println("car.hashCode():" + car.hashCode());
		Field valueFieldOfCar ;
		try {
			//利用反射获取Car对象是wheel属性字段变量
			valueFieldOfCar = Car.class.getDeclaredField("wheel");
			//改变访问权限
			valueFieldOfCar.setAccessible(true); 
			//获取Car的对象引用car的属性wheel的值
			w = (Wheel)valueFieldOfCar.get(car);
			w.setName("second");
			System.out.println("------------------");
			System.out.println("after modify:" + car.getWheel().getName());	//car对象的内部值改变
			System.out.println("car.hashCode():" + car.hashCode());			//car对象引用不变	
			
		} catch (NoSuchFieldException | SecurityException e1) {
			e1.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}

}

class Car{
	private final Wheel wheel;

	public Wheel getWheel() {
		return wheel;
	}

	public Car(Wheel wheel) {
		this.wheel = wheel;
	}

	/*public void setWheel(Wheel wheel) {
		this.wheel = wheel;
	}*/
	
}

class Wheel{
	String name;
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Wheel(String name) {
		this.name = name;
	}
	
}
