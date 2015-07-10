package com.tinytimrob.jfreetype2.test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.tinytimrob.jfreetype2.ByteDataPointer;
import com.tinytimrob.jfreetype2.FreeType2;
import com.tinytimrob.jfreetype2.FreeTypeError;
import com.tinytimrob.jfreetype2.FreeTypeFace;
import com.tinytimrob.jfreetype2.FreeTypeLibrary;

public class TestMain
{
	static String ttfFile = "testfile.ttf";

	//============================================================

	static <T> boolean compare(T a, T b)
	{
		if (a == null && b == null)
			return true;
		else if (a == null || b == null)
			return false;
		else
			return a.equals(b);
	}

	static <T> boolean runTest(String test, T expectedResult, T actualResult)
	{
		System.out.println(test + ": " + actualResult + (compare(expectedResult, actualResult) ? " [PASS]" : " [FAIL; expected " + expectedResult + "]"));
		if (!compare(expectedResult, actualResult))
		{
			new RuntimeException("test failure").printStackTrace();
			minisleep();
			return false;
		}
		return true;
	}

	public static void main(String[] args)
	{
		//============================================================
		// storage arrays
		//============================================================
		FreeTypeLibrary library0[] = new FreeTypeLibrary[1];
		FreeTypeFace face0[] = new FreeTypeFace[1];
		//============================================================

		if (runTest("FT_Init_FreeType", FreeTypeError.OK, FreeType2.initFreeType(library0)))
		{
			if (runTest("FT_New_Face", FreeTypeError.OK, library0[0].newFace(new File(ttfFile).getAbsolutePath(), 0, face0)))
			{
				runTest("FT_Done_Face", FreeTypeError.OK, library0[0].doneFace(face0[0]));
			}

			try
			{
				Path path = Paths.get(ttfFile);
				byte[] data = Files.readAllBytes(path);
				ByteDataPointer byteDataPointer = ByteDataPointer.allocate(data);
				if (runTest("FT_New_Memory_Face", FreeTypeError.OK, library0[0].newMemoryFace(byteDataPointer, data.length, 0, face0)))
				{
					runTest("FT_Done_Face", FreeTypeError.OK, library0[0].doneFace(face0[0]));
				}
				byteDataPointer.release();
			}
			catch (Throwable t)
			{
				t.printStackTrace();
				minisleep();
			}

			runTest("FT_Done_FreeType", FreeTypeError.OK, FreeType2.doneFreeType(library0[0]));
		}
	}

	public static void minisleep()
	{
		try
		{
			Thread.sleep(200);
		}
		catch (InterruptedException e)
		{
			// ignore it
		}
	}
}
