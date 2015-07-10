#include "jni_freetype.h"
#include <ft2build.h>
#include FT_FREETYPE_H

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