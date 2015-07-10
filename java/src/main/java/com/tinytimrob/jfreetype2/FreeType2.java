package com.tinytimrob.jfreetype2;

public class FreeType2
{
	private FreeType2() throws UnsupportedOperationException
	{
		throw new UnsupportedOperationException(); // you, sir, are an imbecile
	}

	static
	{
		if (System.getProperty("os.arch").contains("64") && System.getProperty("os.name").toLowerCase().contains("win"))
		{
			System.loadLibrary("freetype2jni64");
		}
		else
		{
			System.loadLibrary("freetype2jni");
		}
	}

	/** Initialize a new FreeType library object. The set of modules that are registered by this function is determined at build time.
	 * 
	 * @param alibrary A single-length destination array that will receive a handle to a new library object.
	 * @return FreeType error code. {@link FreeTypeError#OK} means success.
	 * @throws InvalidDestinationArraySizeException If the destination array length is not 1
	 */
	// In case you want to provide your own memory allocating routines, use FT_New_Library instead, followed by a call to FT_Add_Default_Modules (or a series of calls to FT_Add_Module).
	// See the documentation of FT_Library and FT_Face for multi-threading issues.
	// If you need reference-counting (cf. FT_Reference_Library), use FT_New_Library and FT_Done_Library.
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

	/** Destroy a given FreeType library object and all of its children, including resources, drivers, faces, sizes, etc.
	 * 
	 * @param library A handle to the target library object.
	 * @return FreeType error code. {@link FreeTypeError#OK} means success.
	 */
	public static FreeTypeError doneFreeType(FreeTypeLibrary library)
	{
		if (library == null)
		{
			throw new NullPointerException("You can't free a null library");
		}

		long p = library.getPointer();
		FreeTypeError result = FreeTypeError.convert(JNIFreeType.INSTANCE.FT_Done_FreeType(p));
		library.pointer = 0;
		return result;
	}
}
