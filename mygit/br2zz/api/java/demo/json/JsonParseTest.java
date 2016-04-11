package demo.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * 解析JSON
 * @author 董槟瑞
 * 2015年10月16日
 * 下午4:24:08
 */
public class JsonParseTest {
	 private static final String filePath = "E:\\GitHub\\eclipse\\br2zz\\api\\java\\demo\\json\\jsonDemoFile.json";

	    public static void main(String[] args) {

	        try {
	            // read the json file
	            FileReader reader = new FileReader(filePath);
	            JSONParser jsonParser = new JSONParser();
	            JSONObject jsonObject = (JSONObject)jsonParser.parse(reader);

	            // get a number from the JSON object
	            Long id =  (Long) jsonObject.get("id");
	            System.out.println("The id is: " + id);           

	            // get a String from the JSON object
	            String   type = (String) jsonObject.get("type");
	            System.out.println("The type is: " + type);

	            // get a String from the JSON object
	            String   name = (String) jsonObject.get("name");
	            System.out.println("The name is: " + name);

	            // get a number from the JSON object
	            Double ppu =  (Double) jsonObject.get("ppu");
	            System.out.println("The PPU is: " + ppu);

	            // get an array from the JSON object
	            System.out.println("Batters:");
	            JSONArray batterArray= (JSONArray) jsonObject.get("batters");
	            Iterator i = batterArray.iterator();
	            // take each value from the json array separately
	            while (i.hasNext()) {
	                JSONObject innerObj = (JSONObject) i.next();
	                System.out.println("ID "+ innerObj.get("id") + 
	                        " type " + innerObj.get("type"));
	            }

	            // get an array from the JSON object
	            System.out.println("Topping:");
	            JSONArray toppingArray= (JSONArray) jsonObject.get("topping");
	            Iterator j = toppingArray.iterator();
	            // take each value from the json array separately
	            while (j.hasNext()) {
	                JSONObject innerObj = (JSONObject) j.next();
	                System.out.println("ID "+ innerObj.get("id") + 
	                        " type " + innerObj.get("type"));
	            }

	        } catch (FileNotFoundException ex) {
	            ex.printStackTrace();
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } catch (ParseException ex) {
	            ex.printStackTrace();
	        } catch (NullPointerException ex) {
	            ex.printStackTrace();
	        }

	    }
}
