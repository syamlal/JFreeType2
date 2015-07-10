package com.tinytimrob.jfreetype2;

/** A list of bit flags returned by {@link FreeTypeFace#getFaceFlags()}. They inform client applications of properties of the corresponding face. */
public class FreeTypeFaceFlags
{
	/** Indicates that the face contains outline glyphs. This doesn't prevent bitmap strikes, i.e., a face can have both this and and {@link FreeTypeFaceFlags#FIXED_SIZES} set. */
	public static final long SCALABLE = (1L << 0);

	/** Indicates that the face contains bitmap strikes. See also {@link FreeTypeFace#getNumFixedSizes()} and {@link FreeTypeFace#getAvailableSizes()}. */
	public static final long FIXED_SIZES = (1L << 1);

	/** Indicates that the face contains fixed-width characters (like Courier, Lucido, MonoType, etc.). */
	public static final long FIXED_WIDTH = (1L << 2);

	/** Indicates that the face uses the ‘sfnt’ storage scheme. For now, this means TrueType and OpenType. */
	public static final long SFNT = (1L << 3);

	/** Indicates that the face contains horizontal glyph metrics. This should be set for all common formats. */
	public static final long HORIZONTAL = (1L << 4);

	/** Indicates that the face contains vertical glyph metrics. This is only available in some formats, not all of them. */
	public static final long VERTICAL = (1L << 5);

	/** Indicates that the face contains kerning information. If set, the kerning distance can be retrieved through the function FT_Get_Kerning.
	 * Otherwise the function always return the vector (0,0). Note that FreeType doesn't handle kerning data from the ‘GPOS’ table (as present in some OpenType fonts). */
	public static final long KERNING = (1L << 6);

	/** THIS FLAG IS DEPRECATED. DO NOT USE OR TEST IT. */
	public static final long FAST_GLYPHS = (1L << 7);

	/** Indicates that the font contains multiple masters and is capable of interpolating between them. See the multiple-masters specific API for details. */
	public static final long MULTIPLE_MASTERS = (1L << 8);

	/** Indicates that the font contains glyph names that can be retrieved through FT_Get_Glyph_Name. Note that some TrueType fonts contain broken glyph name tables.
	 * Use the function FT_Has_PS_Glyph_Names when needed. */
	public static final long GLYPH_NAMES = (1L << 9);

	/** Used internally by FreeType to indicate that a face's stream was provided by the client application and should not be destroyed when
	 * {@link FreeTypeLibrary#doneFace(FreeTypeFace)} is called. Don't read or test this flag. */
	public static final long EXTERNAL_STREAM = (1L << 10);

	/** Set if the font driver has a hinting machine of its own. For example, with TrueType fonts, it makes sense to use data from the SFNT ‘gasp’ table only if the
	 * native TrueType hinting engine (with the bytecode interpreter) is available and active. */
	public static final long HINTER = (1L << 11);

	/** Set if the font is CID-keyed. In that case, the font is not accessed by glyph indices but by CID values. For subsetted CID-keyed fonts this has the consequence
	 * that not all index values are a valid argument to FT_Load_Glyph. Only the CID values for which corresponding glyphs in the subsetted font exist make FT_Load_Glyph
	 * return successfully; in all other cases you get an ‘FT_Err_Invalid_Argument’ error. <br/><br/>
	 * 
	 * Note that CID-keyed fonts that are in an SFNT wrapper don't have this flag set since the glyphs are accessed in the normal way (using contiguous indices); the
	 * ‘CID-ness’ isn't visible to the application. */
	public static final long CID_KEYED = (1L << 12);

	/** Set if the font is ‘tricky’, this is, it always needs the font format's native hinting engine to get a reasonable result. A typical example is the Chinese font
	 * ‘mingli.ttf’ that uses TrueType bytecode instructions to move and scale all of its subglyphs. <br/><br/>
	 * 
	 * It is not possible to auto-hint such fonts using {@link FreeTypeLoadFlags#FORCE_AUTOHINT}; it will also ignore {@link FreeTypeLoadFlags#NO_HINTING}. You have to set
	 * both {@link FreeTypeLoadFlags#NO_HINTING} and {@link FreeTypeLoadFlags#NO_AUTOHINT} to really disable hinting; however, you probably never want this except for
	 * demonstration purposes. <br/><br/>
	 * 
	 * Currently, there are about a dozen TrueType fonts in the list of tricky fonts; they are hard-coded in file ‘ttobjs.c’.*/
	public static final long TRICKY = (1L << 13);

	/** Set if the font has color glyph tables. To access color glyphs use FT_LOAD_COLOR. */
	public static final long COLOR = (1L << 14);
}
