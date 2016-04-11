package reflection;

import java.lang.reflect.Field;
/**
 * 在不改变String类的引用地址情况下，利用反射机制，修改String类的值
 * @author shockay
 * 2015年10月13日
 * 下午4:11:13
 */
public class StringTest {
	
		public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
			
			//创建字符串"Hello World"， 并赋给引用s
			String s = "Hello World"; 
			
			System.out.println("s = " + s);	//Hello World
			System.out.println("s.hashCode() : " + s.hashCode());
			
			//获取String类中的value字段
			Field valueFieldOfString = String.class.getDeclaredField("value");
			
			//改变value属性的访问权限
			valueFieldOfString.setAccessible(true);
			
			//获取s对象上的value属性的值
			char[] value = (char[]) valueFieldOfString.get(s);
			
			//改变value所引用的数组中的第5个字符
			value[5] = '_';
			
			System.out.println("s = " + s);  //Hello_World
			System.out.println("s.hashCode() : " + s.hashCode());
		}
			
}




















