package com.tinytimrob.jfreetype2;

final class JNIFreeType
{
	static final JNIFreeType INSTANCE = new JNIFreeType();

	private JNIFreeType()
	{
		// Zing!
	}

	//=====================================================================================

	public native int FT_Init_FreeType(long[] wrapper);

	public native int FT_Done_FreeType(long pointer);

	//=====================================================================================
}
