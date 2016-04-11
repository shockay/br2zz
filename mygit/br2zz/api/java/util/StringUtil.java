package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {

	private final static Logger log = LoggerFactory.getLogger(StringUtil.class);
	
	private final char value[];
	
	public StringUtil() {
        this.value = new char[0];
    }

	
	
	public static  int CompareString (String string, String anotherString){
		  return string.compareTo(anotherString);
	}
	
	
	
	public static void main(String[] args) {
		log.error("123=============");
		String str1 = "0012";
		String str2 = "0013";
		log.debug(str1.concat(str2));
	}
}
