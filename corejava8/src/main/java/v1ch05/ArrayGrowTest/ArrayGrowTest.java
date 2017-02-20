package v1ch05.ArrayGrowTest;

import java.lang.reflect.Array;

public class ArrayGrowTest {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3 };
		ArrayGrowTest.arrayPrint(a);
	}

	/**
	 * A convenience method to print all elements in an array
	 * 
	 * @param a
	 */
	static void arrayPrint(Object a) {
		Class cl = a.getClass();
		if (!cl.isArray())
			return;

		Class componentType = cl.getComponentType();
		int length = Array.getLength(a);
		System.out.print(componentType.getName() + "[" + length + "] = {");

		for (int i = 0; i < Array.getLength(a); i++) {
			System.out.print(Array.get(a, i) + " ");
		}
		System.out.println("}");
	}
}
