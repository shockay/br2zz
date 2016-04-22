package util.pay;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jumbo.brandstore.activity.util.StringUtil;

import util.encrypt.Md5Encrypt;


public class AlipayUtil {

	private static final Logger log = LoggerFactory.getLogger(AlipayUtil.class);
	
	private static final String INPUT_CHARSET = "utf-8";
	
	public static void main(String[] args) {
		
		String url = "http://10.88.92.163:82/test";
		String result = URLGetByHttpClient(url);
		
		log.debug(result);
	}
	
	/**
	 * parse xml , return Map
	 * @param xml
	 * @return
	 */
	public static Map<String, String> parserXml(String xml) {
		Map<String, String> responseMap = new HashMap<String, String>();
		SAXReader saxReader = new SAXReader();
		try {
			Document document = saxReader.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
			Element employees = document.getRootElement();
			for (Iterator<Element> i = employees.elementIterator(); i.hasNext();) {
				Element employee = (Element) i.next();
				Iterator<Element> j = employee.elementIterator();
				if(j.hasNext()){
					for (; j.hasNext();) {
						Element node = (Element) j.next();
						responseMap.put(employee.getName(), employee.getText());
					}
				}else{
					responseMap.put(employee.getName(), employee.getText());
				}
			}
		} catch (DocumentException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e){
			e.printStackTrace();
		}
		return responseMap;
	}
	
	public static String getXmlInfo(Map<String, String> params) {
		StringBuilder sb = new StringBuilder();
		sb.append("<xml>");
		for (Map.Entry entry : params.entrySet()) {
			sb.append("<").append((String) entry.getKey()).append("><![CDATA[")
					.append((String) entry.getValue()).append("]]></")
					.append((String) entry.getKey()).append(">");
		}
		sb.append("</xml>");
		if (log.isDebugEnabled()) {
			log.debug("xml is [{}]", sb.toString());
		}
		return sb.toString();
	}

	public static String makeSign(Map<String, String> srcMap,
			Collection<String> excludes, String partnerKey) {
		Map<String, String> tmpMap = new TreeMap<String, String>();
		tmpMap.putAll(srcMap);
		if (null != excludes) {
			for (String exclude : excludes) {
				tmpMap.remove(exclude);
			}
		}
		StringBuilder sb = new StringBuilder();
		String value = "";
		for (String key : tmpMap.keySet()) {
			value = (String) tmpMap.get(key);
			if (StringUtil.isNullStr(value)) {
				continue;
			}
			sb.append(key).append("=").append(value).append("&");
		}

		String stringSignTemp = sb.append("key=").append(partnerKey).toString();
		log.debug("## stringSignTemp:{}", stringSignTemp);
		String sign = Md5Encrypt.md5(stringSignTemp,"").toUpperCase();
		return sign;
	}
	
	
	
	
	
	private static String URLGetByHttpClient(String url) {
		HttpClient client = new HttpClient();
		GetMethod get = new GetMethod(url);
		String resultMsg = "";// 返回值
		try {
			client.executeMethod(get);
			if ((resultMsg = get.getResponseBodyAsString()).trim().length() > 0) {
				return resultMsg;
			}
		} catch (HttpException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void TestEncrypt(){
		Map<String,String> map = new HashMap<String,String>();
		map.put("post_service", "service");
		map.put("post_partner", "partner");
		map.put("post_charset", INPUT_CHARSET);
		map.put("post_out_order_no", "orderNo");
		map.put("post_trade_role", "tradeRole");

		String key = "321234";
		String sign = getSignStr(map,key);
		
		String encryptSign = Md5Encrypt.md5(sign, INPUT_CHARSET);
		
		log.debug("sign: {}",sign);
		log.debug("encryptSign: {},size: {}",encryptSign,encryptSign.length());
	}
	
	
	/**
	 * 生成加密字符串
	 * 
	 * @param params
	 *            需要加密的参数
	 * @param privateKey
	 * @return
	 */
	private static String getSignStr(Map<String, String> params,
			String privateKey) {
		List<String> keys = new ArrayList<String>(params.keySet());
		Collections.sort(keys);
		String prestr = "";
		for (int i = 0; i < keys.size(); i++) {
			String key = (String) keys.get(i);
			String value = params.get(key).toString();
			if (i == keys.size() - 1) {
				prestr = prestr + key + "=" + value;
			} else {
				prestr = prestr + key + "=" + value + "&";
			}
		}
		return prestr + privateKey;
	}
	
	
}
