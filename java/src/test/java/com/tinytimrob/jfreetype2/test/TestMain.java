package com.tinytimrob.jfreetype2.test;

import com.tinytimrob.jfreetype2.FreeType2;
import com.tinytimrob.jfreetype2.FreeTypeError;
import com.tinytimrob.jfreetype2.FreeTypeLibrary;

public class TestMain
{
	static <T> boolean compare(T a, T b)
	{
		if (a == null && b == null)
			return true;
		else if (a == null || b == null)
			return false;
		else
			return a.equals(b);
	}

	static <T> void runTest(String test, T expectedResult, T actualResult)
	{
		System.out.println(test + ": " + actualResult + (compare(expectedResult, actualResult) ? " [PASS]" : " [FAIL; expected " + expectedResult + "]"));
		if (!compare(expectedResult, actualResult))
		{
			new RuntimeException("test failure").printStackTrace();
		}
	}

	public static void main(String[] args)
	{
		FreeTypeLibrary[] library = new FreeTypeLibrary[1];
		runTest("initFreeType", FreeTypeError.OK, FreeType2.initFreeType(library));
		runTest("doneFreeType", FreeTypeError.OK, FreeType2.doneFreeType(library[0]));
	}
}
