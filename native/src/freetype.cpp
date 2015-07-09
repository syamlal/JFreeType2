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