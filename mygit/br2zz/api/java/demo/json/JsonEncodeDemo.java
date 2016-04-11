package demo.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 * JSON是数据存储及传输的一种协议。与XML相比，它更易于使用。
 * 由于它非常轻量级以及自身的一些特性，现在JSON在网络上已经是越来越流行了。
 * 常见的数据结构都可以编码成JSON然后在各个网页间自由地传输。
 * @author 董槟瑞
 * 2015年10月16日
 * 下午4:05:39
 */
public class JsonEncodeDemo {
	
	 @SuppressWarnings("unchecked")
	public static void main(String[] args) {

	        JSONObject obj = new JSONObject();
	        obj.put("Novel Name", "Godaan");
	        obj.put("Author", "Munshi Premchand");

	        JSONArray novelDetails = new JSONArray();
	        novelDetails.add("Language: Hindi");
	        novelDetails.add("Year of Publication: 1936");
	        novelDetails.add("Publisher: Lokmanya Press");

	        obj.put("Novel Details", novelDetails);

	        System.out.print(obj);
	    }
}
