package JHKJ;

import java.util.*;

/*2013��7��23��16:31:39
 * ѧϰList
 * List:���ظ� ������
 * Add(��ʼ��Ԫ��)����ѡ��λ��
 * Remove()����ɾ��Ԫ��
 * Set()�����滻��Ԫ��
 * get()��ȡԪ��
 * */
public class ListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List li=new ArrayList();
		
		li.add("abc");
		li.add("abc1");
		li.add("abc2");
		li.add("abc3");
		
		System.out.println(li);
		
		//���ָ��λ��:
;		li.add(2,"abc0.5");
		System.out.println(li);
		
		//ɾ��Ԫ��
		System.out.println("ɾ����Ԫ��:"+li.remove(2));
		
		//����Ԫ��
		System.out.println("���ҵ�Ԫ��:"+li.get(2));
		
		//�޸�Ԫ��
		System.out.println("�޸ĵ�Ԫ��:"+li.set(0,"abc0" ));
		
		//��ȡԪ��:
		System.out.println("��ȡ��Ԫ��:"+li.subList(1, 2));
	}

}
