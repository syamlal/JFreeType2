package com.tinytimrob.jfreetype2;

/** A handle to a given typographic face object. A face object models a given typeface, in a given style. */
public class FreeTypeFace extends CNativeFreeTypeObject
{
	FreeTypeGlyphSlot glyph = null; // cached glyph slot object

	FreeTypeFace(long pointer)
	{
		super(pointer);
	}

	/** Discard this face object, as well as all of its child slots and sizes.
	 * 
	 * @return FreeType error code. {@link FreeTypeError#OK} means success.
	 */
	public FreeTypeError done()
	{
		long p = this.getPointer();
		FreeTypeError result = FreeTypeError.convert(JNIFreeType.INSTANCE.FT_Done_Face(p));
		this.pointer = 0;
		return result;
	}

	/** This function requests the nominal size (in points). <br/><br/>
	 * 
	 * If either the character width or height is zero, it is set equal to the other value. <br/>
	 * If either the horizontal or vertical resolution is zero, it is set equal to the other value. <br/>
	 * A character width or height smaller than 1pt is set to 1pt; if both resolution values are zero, they are set to 72dpi. <br/>
	 * Don't use this function if you are using the FreeType cache API.
	 * 
	 * @param char_width The nominal width, in 26.6 fractional points.
	 * @param char_height The nominal height, in 26.6 fractional points.
	 * @param horz_resolution The horizontal resolution in dpi.
	 * @param vert_resolution The vertical resolution in dpi.
	 * @return FreeType error code. {@link FreeTypeError#OK} means success.
	 */
	public FreeTypeError setCharSize(long char_width, long char_height, long horz_resolution, long vert_resolution)
	{
		long pointer = this.getPointer();
		return FreeTypeError.convert(JNIFreeType.INSTANCE.FT_Set_Char_Size(pointer, char_width, char_height, horz_resolution, vert_resolution));
	}

	/** Return the glyph index of a given character code. This function uses a charmap object to do the mapping. <br/><br/>
	 * 
	 *  If you use FreeType to manipulate the contents of font files directly, be aware that the glyph index returned by this function
	 *  doesn't always correspond to the internal indices used within the file. This is done to ensure that value 0 always corresponds to the
	 *  'missing glyph'. If the first glyph is not named '.notdef', then for Type 1 and Type 42 fonts, '.notdef' will be moved into the glyph
	 *  ID 0 position, and whatever was there will be moved to the position '.notdef' had. For Type 1 fonts, if there is no '.notdef' glyph at
	 *  all, then one will be created at index 0 and whatever was there will be moved to the last index -- Type 42 fonts are considered invalid
	 *  under this condition.
	 * 
	 * @param charcode The character code.
	 * @return The glyph index. 0 means 'undefined character code'.
	 */
	public long getCharIndex(long charcode)
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_Get_Char_Index(pointer, charcode);
	}

	/** The number of faces in the font file. Some font formats can have multiple faces in a font file.
	 * 
	 * @return The number of faces in the font file
	 */
	public long getNumFaces()
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_FaceRec_num_faces(pointer);
	}

	/** A function used to load a single glyph into the glyph slot of a face object. <br/><br/>
	 * 
	 * The loaded glyph may be transformed. See FT_Set_Transform for the details. <br/><br/>
	 * 
	 * For subsetted CID-keyed fonts, 'FT_Err_Invalid_Argument' is returned for invalid CID values (this is, for CID values that don't have a corresponding
	 * glyph in the font). See the discussion of the {@link FreeTypeFaceFlags#CID_KEYED} flag for more details.
	 * 
	 * @param glyph_index The index of the glyph in the font file. For CID-keyed fonts (either in PS or in CFF format) this argument specifies the CID value.
	 * @param load_flags A flag indicating what to load for this glyph. The {@link FreeTypeLoadFlags} constants can be used to control the glyph loading process
	 *   (e.g., whether the outline should be scaled, whether to load bitmaps or not, whether to hint the outline, etc).
	 *   
	 * @return FreeType error code. {@link FreeTypeError#OK} means success.
	 */
	public FreeTypeError loadGlyph(long glyph_index, long load_flags)
	{
		long pointer = this.getPointer();
		return FreeTypeError.convert(JNIFreeType.INSTANCE.FT_Load_Glyph(pointer, glyph_index, load_flags));
	}

	/** The face's associated glyph slot(s).
	 * 
	 * @return The face's associated glyph slot(s)
	 */
	public FreeTypeGlyphSlot getGlyph()
	{
		if (this.glyph == null || !this.glyph.isAllocated())
		{
			long pointer = this.getPointer();
			long slotPointer = JNIFreeType.INSTANCE.FT_FaceRec_glyph(pointer);
			this.glyph = slotPointer == 0 ? null : new FreeTypeGlyphSlot(slotPointer);
		}

		return this.glyph;
	}

	/** Return the kerning vector between two glyphs of a same face.
	 * 
	 * @param left_glyph The index of the left glyph in the kern pair.
	 * @param right_glyph The index of the right glyph in the kern pair.
	 * @param kern_mode See {@link FreeTypeKerningMode} for more information. Determines the scale and dimension of the returned kerning vector.
	 * @param akerning A double-length destination array that will receive the kerning vector. This is either in font units or in pixels (26.6 format) for scalable formats, and in pixels for fixed-sizes formats.
	 * @return FreeType error code. {@link FreeTypeError#OK} means success.
	 * @throws InvalidDestinationArraySizeException If the destination array length is not 2
	 */
	public FreeTypeError getKerning(long left_glyph, long right_glyph, FreeTypeKerningMode kern_mode, long[] akerning)
	{
		if (akerning.length != 2)
		{
			throw new InvalidDestinationArraySizeException("akerning", 2, akerning.length);
		}

		long pointer = this.getPointer();
		return FreeTypeError.convert(JNIFreeType.INSTANCE.FT_Get_Kerning(pointer, left_glyph, right_glyph, kern_mode.ordinal(), akerning));
	}

	/** The index of the face in the font file. It is set to 0 if there is only one face in the font file.
	 * 
	 * @return The index of the face in the font file
	 */
	public long getFaceIndex()
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_FaceRec_face_index(pointer);
	}

	/** A set of bit flags that give important information about the face; see {@link FreeTypeFaceFlags} for the details.
	 * 
	 * @return A set of bit flags that give important information about the face
	 */
	public long getFaceFlags()
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_FaceRec_face_flags(pointer);
	}

	/** A set of bit flags indicating the style of the face; see {@link FreeTypeStyleFlags} for the details.
	 * 
	 * @return A set of bit flags indicating the style of the face
	 */
	public long getStyleFlags()
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_FaceRec_style_flags(pointer);
	}

	/** The number of glyphs in the face. If the face is scalable and has sbits (see 'num_fixed_sizes'), it is set to the number of outline glyphs. <br/><br/>
	 * 
	 * For CID-keyed fonts, this value gives the highest CID used in the font.
	 * 
	 * @return The number of glyphs in the face
	 */
	public long getNumGlyphs()
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_FaceRec_num_glyphs(pointer);
	}

	/** The face's family name. This is an ASCII string, usually in English, that describes the typeface's family (like 'Times New Roman', 'Bodoni', 'Garamond', etc).
	 * This is a least common denominator used to list fonts. Some formats (TrueType & OpenType) provide localized and Unicode versions of this string. Applications
	 * should use the format specific interface to access them. Can be NULL (e.g., in fonts embedded in a PDF file). <br/><br/>
	 * 
	 * In case the font doesn't provide a specific family name entry, FreeType tries to synthesize one, deriving it from other name entries.
	 * 
	 * @return The face's family name
	 */
	public String getFamilyName()
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_FaceRec_family_name(pointer);
	}

	/** The face's style name. This is an ASCII string, usually in English, that describes the typeface's style (like 'Italic', 'Bold', 'Condensed', etc).
	 * Not all font formats provide a style name, so this field is optional, and can be set to NULL. As for 'family_name', some formats provide localized
	 * and Unicode versions of this string. Applications should use the format specific interface to access them.
	 * 
	 * @return The face's style name
	 */
	public String getStyleName()
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_FaceRec_style_name(pointer);
	}

	/*
	public int getNumFixedSizes()
	{
		
	}
	
	public FreeTypeBitmapSize[] getAvailableSizes()
	{
		
	}
	*/

	/*
	public int getNumCharmaps()
	{
		
	}
	
	public FreetypeCharMap[] getCharmaps()
	{
		
	}
	*/
}
