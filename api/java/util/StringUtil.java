package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {

	private final static Logger log = LoggerFactory.getLogger(StringUtil.class);
	
	public static  int CompareString (String string, String anotherString){
		  return string.compareTo(anotherString);
	}
	
	
	
	public static void main(String[] args) {
		log.error("123=============");
		String str1 = "0012";
		String str2 = "0013";
		log.debug(str1.concat(str2));
		log.warn("--str1,[{}],--str2,[{}]" , str1, str2);
		
	}
}
