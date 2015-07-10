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

	native int FT_Set_Char_Size(long face, long char_width, long char_height, long horz_resolution, long vert_resolution);

	native long FT_Get_Char_Index(long face, long charcode);

	//=====================================================================================

	native long FT_FaceRec_num_faces(long pointer);

	native long FT_FaceRec_face_index(long pointer);

	native long FT_FaceRec_face_flags(long pointer);

	native long FT_FaceRec_style_flags(long pointer);

	native long FT_FaceRec_num_glyphs(long pointer);

	native String FT_FaceRec_family_name(long pointer);

	native String FT_FaceRec_style_name(long pointer);

	//=====================================================================================
}
