package com.tinytimrob.jfreetype2;

/** A list of bit-field constants used with {@link FreeTypeFace#loadGlyph} to indicate what kind of operations to perform during glyph loading. <br/><br/>
 * 
 * By default, hinting is enabled and the font's native hinter (see {@link FreeTypeFaceFlags#HINTER}) is preferred over the auto-hinter. You can disable hinting by setting
 * {@link FreeTypeLoadFlags#NO_HINTING} or change the precedence by setting {@link FreeTypeLoadFlags#FORCE_AUTOHINT}. You can also set
 * {@link FreeTypeLoadFlags#NO_AUTOHINT} in case you don't want the auto-hinter to be used at all. <br/><br/>
 * 
 * See the description of {@link FreeTypeFaceFlags#TRICKY} for a special exception (affecting only a handful of Asian fonts). <br/><br/>
 * 
 * Besides deciding which hinter to use, you can also decide which hinting algorithm to use. See {@link FreeTypeLoadTargetFlags} for details. <br/><br/>
 * 
 * Note that the auto-hinter needs a valid Unicode cmap (either a native one or synthesized by FreeType) for producing correct results. If a font provides an
 * incorrect mapping (for example, assigning the character code U+005A, LATIN CAPITAL LETTER Z, to a glyph depicting a mathematical integral sign), the auto-hinter
 * might produce useless results. */
public class FreeTypeLoadFlags
{
	/** Corresponding to 0, this value is used as the default glyph load operation. In this case, the following happens: <br/><br/>
	 * 
	 * 1. FreeType looks for a bitmap for the glyph corresponding to the face's current size. If one is found, the function returns.
	 * The bitmap data can be accessed from the glyph slot (see note below). <br/><br/>
	 * 
	 * 2. If no embedded bitmap is searched or found, FreeType looks for a scalable outline. If one is found, it is loaded from the
	 * font file, scaled to device pixels, then 'hinted' to the pixel grid in order to optimize it. The outline data can be accessed
	 * from the glyph slot (see note below). <br/><br/>
	 * 
	 * Note that by default, the glyph loader doesn't render outlines into bitmaps. The following flags are used to modify this default
	 * behaviour to more specific and useful cases. */
	public static final long DEFAULT = 0;

	/** Don't scale the loaded outline glyph but keep it in font units. <br/><br/>
	 * 
	 * This flag implies {@link FreeTypeLoadFlags#NO_HINTING} and {@link FreeTypeLoadFlags#NO_BITMAP}, and unsets
	 * {@link FreeTypeLoadFlags#RENDER}. <br/><br/>
	 * 
	 * If the font is 'tricky' (see {@link FreeTypeFaceFlags#TRICKY} for more), using {@link FreeTypeLoadFlags#NO_SCALE} usually yields
	 * meaningless outlines because the subglyphs must be scaled and positioned with hinting instructions. This can be solved by loading
	 * the font without {@link FreeTypeLoadFlags#NO_SCALE} and setting the character size to 'font->units_per_EM'. */
	public static final long NO_SCALE = (1L << 0);

	/** Disable hinting. This generally generates 'blurrier' bitmap glyphs when the glyph are rendered in any of the anti-aliased modes.
	 * See also the note below. <br/><br/>
	 * 
	 * This flag is implied by {@link FreeTypeLoadFlags#NO_SCALE}. */
	public static final long NO_HINTING = (1L << 1);

	/** Call {@link FreeTypeGlyphSlot#render} after the glyph is loaded. By default, the glyph is rendered in {@link FreeTypeRenderMode#NORMAL} mode. This can be overridden
	 * by {@link FreeTypeLoadTargetFlags} or {@link FreeTypeLoadFlags#MONOCHROME}. <br/><br/>
	 * 
	 * This flag is unset by {@link FreeTypeLoadFlags#NO_SCALE}. */
	public static final long RENDER = (1L << 2);

	/** Ignore bitmap strikes when loading. Bitmap-only fonts ignore this flag. <br/><br/>
	 * {@link FreeTypeLoadFlags#NO_SCALE} always sets this flag. */
	public static final long NO_BITMAP = (1L << 3);

	/** Load the glyph for vertical text layout. In particular, the 'advance' value in the FT_GlyphSlotRec structure is set to the 'vertAdvance'
	 * value of the 'metrics' field. <br/><br/>
	 * 
	 * In case FT_HAS_VERTICAL doesn't return true, you shouldn't use this flag currently. Reason is that in this case vertical metrics get synthesized,
	 * and those values are not always consistent across various font formats. */
	public static final long VERTICAL_LAYOUT = (1L << 4);

	/** Indicates that the auto-hinter is preferred over the font's native hinter. See also the note below. */
	public static final long FORCE_AUTOHINT = (1L << 5);

	/** Ignored. Deprecated. */
	public static final long CROP_BITMAP = (1L << 6);

	/** Indicates that the font driver should perform pedantic verifications during glyph loading. This is mostly used to detect broken glyphs in fonts.
	 * By default, FreeType tries to handle broken fonts also. <br/><br/>
	 * 
	 * In particular, errors from the TrueType bytecode engine are not passed to the application if this flag is not set; this might result in partially
	 * hinted or distorted glyphs in case a glyph's bytecode is buggy. */
	public static final long PEDANTIC = (1L << 7);

	/** Ignored. Deprecated. */
	public static final long IGNORE_GLOBAL_ADVANCE_WIDTH = (1L << 9);

	/** Indicate that the font driver should not load composite glyphs recursively. Instead, it should set the 'num_subglyph' and 'subglyphs' values of
	 * the glyph slot accordingly, and set 'glyph->format' to FT_GLYPH_FORMAT_COMPOSITE. The description of subglyphs can then be accessed with
	 * FT_Get_SubGlyph_Info. <br/><br/>
	 * 
	 * This flag implies {@link FreeTypeLoadFlags#NO_SCALE} and {@link FreeTypeLoadFlags#IGNORE_TRANSFORM}. */
	public static final long NO_RECURSE = (1L << 10);

	/** Indicates that the transform matrix set by FT_Set_Transform should be ignored. */
	public static final long IGNORE_TRANSFORM = (1L << 11);

	/** This flag is used with {@link FreeTypeLoadFlags#RENDER} to indicate that you want to render an outline glyph to a 1-bit monochrome bitmap glyph, with 8 pixels packed
	 * into each byte of the bitmap data. <br/><br/>
	 * 
	 * Note that this has no effect on the hinting algorithm used. You should rather use {@link FreeTypeLoadTargetFlags#MONO} so that the monochrome-optimized hinting algorithm
	 * is used.*/
	public static final long MONOCHROME = (1L << 12);

	/** Indicates that the 'linearHoriAdvance' and 'linearVertAdvance' fields of FT_GlyphSlotRec should be kept in font units. See FT_GlyphSlotRec for details. */
	public static final long LINEAR_DESIGN = (1L << 13);

	/** Disable auto-hinter. See also the note below. */
	public static final long NO_AUTOHINT = (1L << 15);

	// Bits 16..19 are used by FreeTypeLoadTargetFlags

	/** This flag is used to request loading of color embedded-bitmap images. The resulting color bitmaps, if available, will have the FT_PIXEL_MODE_BGRA format.
	 * When the flag is not used and color bitmaps are found, they will be converted to 256-level gray bitmaps transparently. Those bitmaps will be in the
	 * FT_PIXEL_MODE_GRAY format. */
	public static final long COLOR = (1L << 20);
}
