package cn.courtier.Until;

import java.util.HashMap;

/**
 * @�๦��˵����ȫ��hash,���ڱ����û��ĸ���ֵ
 * @���޸��ߣ�
 * @�޸����ڣ�
 * @�޸�˵����
 * @��˾���ƣ�
 * @���ߣ�Administrator
 * @����ʱ�䣺2014-6-11 ����11:47:30
 * @�汾��V1.0
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
