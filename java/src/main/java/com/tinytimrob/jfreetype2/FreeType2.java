package com.tinytimrob.jfreetype2;

import com.tinytimrob.jlibraryloader.JLibraryLoader;

public class FreeType2
{
	private FreeType2() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException(); // you, sir, are an imbecile
	}

	static
	{
		if (!System.getProperty("os.name").toLowerCase().contains("win"))
		{
			JLibraryLoader.load("freetype");
		}
		JLibraryLoader.load("freetype2jni");
	}

	/** Initialize a new FreeType library object. The set of modules that are registered by this function is determined at build time. <br/><br/>
	 * 
	 * In case you want to provide your own memory allocating routines, use FT_New_Library instead, followed by a call to FT_Add_Default_Modules (or a series of calls to FT_Add_Module). <br/><br/>
	 * 
	 * See the documentation of {@link FreeTypeLibrary} and {@link FreeTypeFace} for multi-threading issues. <br/><br/>
	 * 
	 * If you need reference-counting (cf. FT_Reference_Library), use FT_New_Library and FT_Done_Library. <br/><br/>
	 * 
	 * @param alibrary A single-length destination array that will receive a handle to a new library object.
	 * @return FreeType error code. {@link FreeTypeError#OK} means success.
	 * @throws InvalidDestinationArraySizeException If the destination array length is not 1
	 */
	public static FreeTypeError initFreeType(FreeTypeLibrary[] alibrary)
	{
		if (alibrary.length != 1)
		{
			throw new InvalidDestinationArraySizeException("library", 1, alibrary.length);
		}

		long[] wrapper = new long[1];
		FreeTypeError result = FreeTypeError.convert(JNIFreeType.INSTANCE.FT_Init_FreeType(wrapper));
		alibrary[0] = new FreeTypeLibrary(wrapper[0]);
		return result;
	}
}
