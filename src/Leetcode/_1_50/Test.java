package Leetcode._1_50;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
		// Set<Integer> set = new HashSet<>();
		// int a = 2;
		// int b = 3;
		// int c = 2;
		// boolean A = set.add(a);
		// boolean B = set.add(b);
		// boolean C = set.add(c);
		// System.out.println(A + "\t" + B + "\t" + C);

		List<Person> list = new ArrayList<>();
		Person p1 = new Person("刘召信");
		Person p2 = new Person("张三");
		Person p3 = new Person("李四");
		list.add(p1);
		list.add(p2);
		list.add(p3);
		Iterator<Person> it = list.iterator();
		//Iterable<Person> it = (Iterable) list.iterator();
		testIt(it);
	}
	public static void testIt(Iterator<Person> it) {
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	public static void test(List<Person> list) {
		for(Person p : list) {
			System.out.println(p);
		}
	}

	// 判断一个字符串是否含有数字
	public static boolean HasDigit(String content) {
		boolean flag = false;
		Pattern p = Pattern.compile(".*\\d+.*");
		Matcher m = p.matcher(content);
		if (m.matches()) {
			flag = true;
		}
		return flag;
	}
}

class Person {
	private String name;

	public Person() {
	}

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}

}
