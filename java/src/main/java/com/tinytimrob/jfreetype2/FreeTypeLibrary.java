package com.tinytimrob.jfreetype2;

/** A handle to a FreeType library instance. Each ‘library’ is completely independent from the others; it is the ‘root’ of a set of objects like fonts, faces, sizes, etc. */
public class FreeTypeLibrary extends CNativeFreeTypeObject
{
	FreeTypeLibrary(long pointer)
	{
		super(pointer);
	}

	/** This function opens a font by its pathname.
	 * 
	 * @param filepathname A path to the font file.
	 * @param face_index The index of the face within the font. The first face has index 0.
	 * @param face A single-length destination array that will receive a handle to a new face object.
	 * @return FreeType error code. {@link FreeTypeError#OK} means success.
	 * @throws InvalidDestinationArraySizeException If the destination array length is not 1
	 */
	public FreeTypeError newFace(String filepathname, long face_index, FreeTypeFace[] face) throws InvalidDestinationArraySizeException
	{
		if (face.length != 1)
		{
			throw new InvalidDestinationArraySizeException("face", 1, face.length);
		}

		long p = this.getPointer();
		long[] wrapper = new long[1];
		FreeTypeError result = FreeTypeError.convert(JNIFreeType.INSTANCE.FT_New_Face(p, filepathname, face_index, wrapper));
		face[0] = new FreeTypeFace(wrapper[0]);
		return result;
	}

	/** This function opens a font that has been loaded into memory.
	 * 
	 * @param file_base A pointer to the beginning of the font data.
	 * @param file_size The size of the memory chunk used by the font data.
	 * @param face_index The index of the face within the font. The first face has index 0.
	 * @param face A single-length destination array that will receive a handle to a new face object.
	 * @return FreeType error code. {@link FreeTypeError#OK} means success.
	 * @throws InvalidDestinationArraySizeException If the destination array length is not 1
	 */
	public FreeTypeError newMemoryFace(ByteDataPointer file_base, long file_size, long face_index, FreeTypeFace[] face) throws InvalidDestinationArraySizeException
	{
		if (face.length != 1)
		{
			throw new InvalidDestinationArraySizeException("face", 1, face.length);
		}

		long p = this.getPointer();
		long file_base_pointer = file_base == null ? 0 : file_base.getPointer();
		long[] wrapper = new long[1];
		FreeTypeError result = FreeTypeError.convert(JNIFreeType.INSTANCE.FT_New_Memory_Face(p, file_base_pointer, file_size, face_index, wrapper));
		face[0] = new FreeTypeFace(wrapper[0]);
		return result;
	}

	/** Discard a given face object, as well as all of its child slots and sizes.
	 * 
	 * @param face A handle to a target face object.
	 * @return FreeType error code. {@link FreeTypeError#OK} means success.
	 */
	public FreeTypeError doneFace(FreeTypeFace face)
	{
		if (face == null)
		{
			throw new NullPointerException("You can't free a null face");
		}

		long p = face.getPointer();
		FreeTypeError result = FreeTypeError.convert(JNIFreeType.INSTANCE.FT_Done_Face(p));
		face.pointer = 0;
		return result;
	}
}
