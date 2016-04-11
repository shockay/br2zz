package demo;
/**
 * 判断奇数时考虑正负数的情况
 * 这么写不光是负奇数的问题解决了，并且还是经过充分优化过的。
 * 因为算术运算和逻辑运行要比乘除运算更高效，计算的结果也会更快。
 * @author 董槟瑞
 * 2015年10月16日
 * 下午2:13:12
 */
public class CheckOdd {

	public static void main(String[] args) {
		
		for(int i = -4 ; i < 4 ; i++ ){
			System.out.println(i +"是否是奇数："+ oddOrNotForAll(i));
		}
		//System.out.println(-3 % 2);
	}
	
	public static boolean oddOrNotForAll(int num){
		return (num & 1) != 0;   //通过二进制与运算结果来判断原数是否为奇数（包括正负数）
	}
	
	public static boolean oddOrNotOnlyInPositiveNumber(int num){
		return num % 2 == 1 ;  //若这里num为负数，则不能判断是否是负奇数
	}
}

