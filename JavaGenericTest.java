package com.song.generic;

import java.util.ArrayList;
import java.util.List;

public class JavaGenericTest<V> {
	List<?> list = null;
	private <T> void hello(T...ts) {
		for(int i = 0; i < ts.length; i++) {
			System.out.print(ts[i]);
		}
	}
	public static void main(String[] args) {
		JavaGenericTest<String> test = new JavaGenericTest<String>();
		test.hello();
		test.hello(1,2,3,4);
		test.hello("a","b","c","d");
		test.list = new ArrayList<Integer>();
	}
}
