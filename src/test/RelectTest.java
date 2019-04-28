package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;


public class RelectTest {

	public static void main(String[] args) throws Exception{
//		Class clazz = Test7.class;
//		Method m = clazz.getDeclaredMethod("print", Integer[].class);
////		Test7 test = new Test7();
////		Integer[] o = new Integer[] {1,2};
////		Object[] obs = new Object[] {o};
////		
////		m.invoke(test,obs);
//		
//		
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "sqx");
//		map.put("age", 18);
//		System.out.println(map.get("name"));
//		BeanUtils.setProperty(map, "name", "yyy");
//		System.out.println(map.get("name"));
//		
//		List<Object> i = new ArrayList<Object>();
		
		//printCollection(i);
		Object obj = new Object();
		autoConversion(String.class,obj);
		
	}
	
	public static void printCollection(Collection<? extends Comparable> collection){}
	
	private static <T> T autoConversion(Class<T> t,Object i) {
		System.out.println(t.getClass());
		return (T) i;
	}


}

class Test7{
	public void print(Integer[] args) {
		for(Integer s : args) {
			System.out.println(s);
		}
	}
}
