#include "jni_freetype.h"
#include <ft2build.h>
#include FT_FREETYPE_H
#include FT_IMAGE_H

JNIEXPORT jint JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1Init_1FreeType(JNIEnv * _env, jobject _obj, jlongArray _alibrary)
{
	FT_Library library = NULL;
	FT_Error result = FT_Init_FreeType(&library);
	jlong jl = (jlong)library;
	_env->SetLongArrayRegion(_alibrary, 0, 1, &jl);
	return (jint)result;
}

JNIEXPORT jint JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1Done_1FreeType(JNIEnv * _env, jobject _obj, jlong _library)
{
	return (jint)FT_Done_FreeType((FT_Library)_library);
}

JNIEXPORT jint JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1New_1Face(JNIEnv * _env, jobject _obj, jlong _library, jstring _filepathname, jlong _face_index, jlongArray _aface)
{
	const char* filepathname = _env->GetStringUTFChars(_filepathname, 0);
	FT_Face face = NULL;
	jint result = (jint)FT_New_Face((FT_Library)_library, filepathname, (FT_Long)_face_index, &face);
	jlong jl = (jlong)face;
	_env->SetLongArrayRegion(_aface, 0, 1, &jl);
	_env->ReleaseStringUTFChars(_filepathname, filepathname);
	return result;
}

JNIEXPORT jint JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1New_1Memory_1Face(JNIEnv * _env, jobject _obj, jlong _library, jlong _file_base, jlong _file_size, jlong _face_index, jlongArray _aface)
{
	FT_Face face = NULL;
	jint result = (jint)FT_New_Memory_Face((FT_Library)_library, (FT_Byte*)_file_base, (FT_Long)_file_size, (FT_Long)_face_index, &face);
	jlong jl = (jlong)face;
	_env->SetLongArrayRegion(_aface, 0, 1, &jl);
	return result;
}

JNIEXPORT jint JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1Done_1Face(JNIEnv * _env, jobject _obj, jlong _face)
{
	return (jint)FT_Done_Face((FT_Face)_face);
}

JNIEXPORT jlong JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_HelperFunc_1ByteDataPointer_1Allocate(JNIEnv * _env, jobject _object, jbyteArray _arr)
{
	int len = _env->GetArrayLength(_arr);
	char* buffer = new char[len];
	_env->GetByteArrayRegion(_arr, 0, len, reinterpret_cast<jbyte*>(buffer));
	return (jlong)buffer;
}

JNIEXPORT void JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_HelperFunc_1ByteDataPointer_1Release(JNIEnv * _env, jobject _object, jlong _pointer)
{
	char* ptr = (char*)_pointer;
	delete[] ptr;
}

JNIEXPORT jint JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1Set_1Char_1Size(JNIEnv * _env, jobject _object, jlong _face, jlong _char_width, jlong _char_height, jlong _horz_resolution, jlong _vert_resolution)
{
	return (jint)FT_Set_Char_Size((FT_Face)_face, (FT_F26Dot6)_char_width, (FT_F26Dot6)_char_height, (FT_UInt)_horz_resolution, (FT_UInt)_vert_resolution);
}

JNIEXPORT jlong JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1Get_1Char_1Index(JNIEnv * _env, jobject _object, jlong _face, jlong _charcode)
{
	return (jlong)FT_Get_Char_Index((FT_Face)_face, (FT_ULong)_charcode);
}

JNIEXPORT jint JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1Load_1Glyph(JNIEnv * _env, jobject _object, jlong _face, jlong _glyph_index, jlong _load_flags)
{
	return (jint)FT_Load_Glyph((FT_Face)_face, (FT_UInt)_glyph_index, (FT_Int32)_load_flags);
}

JNIEXPORT jint JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1Get_1Kerning(JNIEnv * _env, jobject _object, jlong _face, jlong _left_glyph, jlong _right_glyph, jint _kern_mode, jlongArray _akerning)
{
	FT_Vector vec;
	jint ret = (jint)FT_Get_Kerning((FT_Face)_face, (FT_UInt)_left_glyph, (FT_UInt)_right_glyph, (FT_UInt)_kern_mode, &vec);
	jlong a = vec.x;
	jlong b = vec.y;
	_env->SetLongArrayRegion(_akerning, 0, 1, &a);
	_env->SetLongArrayRegion(_akerning, 1, 1, &b);
	return ret;
}

JNIEXPORT jlong JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1FaceRec_1num_1faces(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_Face face = (FT_Face)_pointer;
	return (jlong)face->num_faces;
}

JNIEXPORT jlong JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1FaceRec_1face_1index(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_Face face = (FT_Face)_pointer;
	return (jlong)face->face_index;
}

JNIEXPORT jlong JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1FaceRec_1face_1flags(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_Face face = (FT_Face)_pointer;
	return (jlong)face->face_flags;
}

JNIEXPORT jlong JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1FaceRec_1style_1flags(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_Face face = (FT_Face)_pointer;
	return (jlong)face->style_flags;
}

JNIEXPORT jlong JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1FaceRec_1num_1glyphs(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_Face face = (FT_Face)_pointer;
	return (jlong)face->num_glyphs;
}

JNIEXPORT jstring JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1FaceRec_1family_1name(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_Face face = (FT_Face)_pointer;
	FT_String* f = face->family_name;
	return f == NULL ? NULL : _env->NewStringUTF(f);
}

JNIEXPORT jstring JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1FaceRec_1style_1name(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_Face face = (FT_Face)_pointer;
	FT_String* f = face->style_name;
	return f == NULL ? NULL : _env->NewStringUTF(f);
}

JNIEXPORT jlong JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1FaceRec_1glyph(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_Face face = (FT_Face)_pointer;
	return (jlong)face->glyph;
}

JNIEXPORT jint JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1Render_1Glyph(JNIEnv * _env, jobject _object, jlong _slot, jint _render_mode)
{
	return (jint)FT_Render_Glyph((FT_GlyphSlot)_slot, (FT_Render_Mode)_render_mode);
}

JNIEXPORT jlong JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1GlyphSlotRec_1bitmap(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_GlyphSlot glyph = (FT_GlyphSlot)_pointer;
	return (jlong)&glyph->bitmap;
}

JNIEXPORT jint JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1GlyphSlotRec_1bitmap_1left(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_GlyphSlot glyph = (FT_GlyphSlot)_pointer;
	return (jint)glyph->bitmap_left;
}

JNIEXPORT jint JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1GlyphSlotRec_1bitmap_1top(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_GlyphSlot glyph = (FT_GlyphSlot)_pointer;
	return (jint)glyph->bitmap_top;
}

JNIEXPORT jint JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1GlyphSlotRec_1advance_1x(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_GlyphSlot glyph = (FT_GlyphSlot)_pointer;
	return (jint)glyph->advance.x;
}

JNIEXPORT jint JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1GlyphSlotRec_1advance_1y(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_GlyphSlot glyph = (FT_GlyphSlot)_pointer;
	return (jint)glyph->advance.y;
}

JNIEXPORT jlong JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1Bitmap_1rows(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_Bitmap* bitmap = (FT_Bitmap*)_pointer;
	return (jlong)bitmap->rows;
}

JNIEXPORT jlong JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1Bitmap_1width(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_Bitmap* bitmap = (FT_Bitmap*)_pointer;
	return (jlong)bitmap->width;
}

JNIEXPORT jint JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1Bitmap_1pitch(JNIEnv * _env, jobject _object, jlong _pointer)
{
	FT_Bitmap* bitmap = (FT_Bitmap*)_pointer;
	return (jint)bitmap->pitch;
}

JNIEXPORT void JNICALL Java_com_tinytimrob_jfreetype2_JNIFreeType_FT_1Bitmap_1buffer(JNIEnv * _env, jobject _object, jlong _pointer, jbyteArray _array)
{
	FT_Bitmap* bitmap = (FT_Bitmap*)_pointer;
	int len = _env->GetArrayLength(_array);
	unsigned char* c = bitmap->buffer;
	_env->SetByteArrayRegion(_array, 0, len, reinterpret_cast<jbyte*>(c));
}