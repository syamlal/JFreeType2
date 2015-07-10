package com.tinytimrob.jfreetype2;

final class JNIFreeType
{
	static final JNIFreeType INSTANCE = new JNIFreeType();

	private JNIFreeType()
	{
		// Zing!
	}

	//=====================================================================================

	native int FT_Init_FreeType(long[] alibrary);

	native int FT_Done_FreeType(long library);

	//=====================================================================================

	native int FT_New_Face(long library, String filepathname, long face_index, long[] aface);

	native int FT_New_Memory_Face(long library, long file_base, long file_size, long face_index, long[] aface);

	native int FT_Done_Face(long face);

	//=====================================================================================

	native long HelperFunc_ByteDataPointer_Allocate(byte[] arr);

	native void HelperFunc_ByteDataPointer_Release(long pointer);

	//=====================================================================================
}
