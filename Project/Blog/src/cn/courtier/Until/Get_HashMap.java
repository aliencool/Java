package cn.courtier.Until;

import java.util.HashMap;

/**
 * @类功能说明：全局hash,用于保存用户的各种值
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：Administrator
 * @创建时间：2014-6-11 下午11:47:30
 * @版本：V1.0
 */
public class Get_HashMap {
	private Get_HashMap(){}
	private static HashMap<String, String> hashMap=new HashMap<String, String>();
	public static HashMap<String, String> getHashMap() {
		return hashMap;
	}
	public static void setHashMap(HashMap<String, String> hashMap) {
		Get_HashMap.hashMap = hashMap;
	}
	
	
}
