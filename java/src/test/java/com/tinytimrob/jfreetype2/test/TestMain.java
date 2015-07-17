package com.tinytimrob.jfreetype2.test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.tinytimrob.jfreetype2.ByteDataPointer;
import com.tinytimrob.jfreetype2.FreeType2;
import com.tinytimrob.jfreetype2.FreeTypeBitmap;
import com.tinytimrob.jfreetype2.FreeTypeError;
import com.tinytimrob.jfreetype2.FreeTypeFace;
import com.tinytimrob.jfreetype2.FreeTypeGlyphSlot;
import com.tinytimrob.jfreetype2.FreeTypeLibrary;
import com.tinytimrob.jfreetype2.FreeTypeLoadFlags;
import com.tinytimrob.jfreetype2.FreeTypeRenderMode;

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
				printFaceInfo(face0[0]);
				runTest("FT_Set_Char_Size", FreeTypeError.OK, face0[0].setCharSize(0, 16 * 64, 72, 72));
				long charIndex = face0[0].getCharIndex('j');
				System.out.println(" --> the index of 'j' is " + charIndex);
				runTest("FT_Load_Glyph", FreeTypeError.OK, face0[0].loadGlyph(charIndex, FreeTypeLoadFlags.DEFAULT));
				FreeTypeGlyphSlot glyph = face0[0].getGlyph();
				runTest("glyph.isAllocated()", true, glyph.isAllocated());
				runTest("FT_Render_Glyph", FreeTypeError.OK, glyph.render(FreeTypeRenderMode.NORMAL));
				FreeTypeBitmap bitmap = glyph.getBitmap();
				runTest("bitmap.isAllocated()", true, bitmap.isAllocated());

				// bitmap info
				printBitmapInfo(bitmap);

				runTest("FT_Done_Face", FreeTypeError.OK, face0[0].done());
			}

			try
			{
				Path path = Paths.get(ttfFile);
				byte[] data = Files.readAllBytes(path);
				ByteDataPointer byteDataPointer = ByteDataPointer.allocate(data);
				if (runTest("FT_New_Memory_Face", FreeTypeError.OK, library0[0].newMemoryFace(byteDataPointer, data.length, 0, face0)))
				{
					printFaceInfo(face0[0]);
					runTest("FT_Done_Face", FreeTypeError.OK, face0[0].done());
				}
				byteDataPointer.release();
			}
			catch (Throwable t)
			{
				t.printStackTrace();
				minisleep();
			}

			runTest("FT_Done_FreeType", FreeTypeError.OK, library0[0].done());
		}
	}

	private static void printBitmapInfo(FreeTypeBitmap bitmap)
	{
		System.out.println("*--------------------------------*");
		long rows = 0, width = 0;
		System.out.println("  Rows: " + (rows = bitmap.getRows()));
		System.out.println("  Width: " + (width = bitmap.getWidth()));
		System.out.println("  Pitch: " + bitmap.getPitch());
		byte[] buffer = bitmap.getBuffer();
		System.out.println("");
		for (int i = 0; i < rows; i++)
		{
			String m = "";
			for (int j = 0; j < width; j++)
			{
				m = m + (buffer[(int) ((i * width) + j)] != 0 ? "*" : " ");
			}
			System.out.println("   " + m);
		}
		System.out.println("");
		System.out.println("*--------------------------------*");
	}

	public static void printFaceInfo(FreeTypeFace face)
	{
		System.out.println("------------------------------------------------------");
		System.out.println("  This font is '" + face.getFamilyName() + "'");
		System.out.println("  It is style '" + face.getStyleName() + "' with style flags: " + face.getStyleFlags());
		System.out.println("  It is face #" + face.getFaceIndex() + " with face flags: " + face.getFaceFlags());
		System.out.println("  In total there are " + face.getNumFaces() + " faces and " + face.getNumGlyphs() + " glyphs");
		System.out.println("------------------------------------------------------");
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
