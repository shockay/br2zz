package demo;
/**
 * 编程中的细节，良好的风格
 * 
 * @author 董槟瑞
 * 2015年10月16日
 * 上午10:34:50
 */
public class GetLocationName {
	
	private String cityName;
	public GetLocationName(String cityName) {
		this.cityName = cityName;
	}
	
	//对get方法稍做处理，即可省去后期大量工作
	public String getCityName(){
		//return cityName;  	 //若cityName 为null，在后面的编程中需要判空操作，需要大量的“if else”检查。
		return (null == cityName ? "" : cityName);   //省去大量的“if else”检查。
	}

	public static void main(String[] args) {
		
		String city = null ;
		GetLocationName getLocationName = new GetLocationName(city);
		System.out.println("getLocationName.getCityName():" + getLocationName.getCityName());
		
		System.out.println(getLocationName.getCityName().length());    //这里null.length()会出现指针，"".length() = 0 , 不会报错
	}
	
}