package com.tinytimrob.jfreetype2;

/** A list of values that are used to select a specific hinting algorithm to use by the hinter. You should OR one of these values to your ‘load_flags’ when calling FT_Load_Glyph. <br/><br/>
 * 
 * Note that font's native hinters may ignore the hinting algorithm you have specified (e.g., the TrueType bytecode interpreter). You can set {@link FreeTypeLoadFlags#FORCE_AUTOHINT} to ensure that the auto-hinter is used. <br/><br/>
 * 
 * Also note that {@link FreeTypeLoadTargetFlags#LIGHT} is an exception, in that it always implies {@link FreeTypeLoadFlags#FORCE_AUTOHINT}. <br/><br/>
 * 
 * You should use only one of the FreeTypeLoadTargetFlags values in your ‘load_flags’. They can't be ORed. <br/><br/>
 * 
 * If {@link FreeTypeLoadFlags#RENDER} is also set, the glyph is rendered in the corresponding mode (i.e., the mode that matches the used algorithm best). An exeption is {@link FreeTypeLoadTargetFlags#MONO} since it implies {@link FreeTypeLoadFlags#MONOCHROME}. <br/><br/>
 * 
 * You can use a hinting algorithm that doesn't correspond to the same rendering mode. As an example, it is possible to use the ‘light’ hinting algorithm and have the results rendered in horizontal LCD pixel mode, with code like: <br/><br/>
 * 
 * <code>
 * FT_Load_Glyph( face, glyph_index, load_flags | FT_LOAD_TARGET_LIGHT );
 * FT_Render_Glyph( face->glyph, FT_RENDER_MODE_LCD );
 * </code>
 */
public class FreeTypeLoadTargetFlags
{
	/** This corresponds to the default hinting algorithm, optimized for standard gray-level rendering. For monochrome output, use {@link FreeTypeLoadTargetFlags#MONO} instead. */
	public static final long NORMAL = (((0L) & 15) << 16);

	/** A lighter hinting algorithm for non-monochrome modes. Many generated glyphs are more fuzzy but better resemble its original shape. A bit like rendering on Mac OS X. <br/><br/>
	 * As a special exception, this target implies {@link FreeTypeLoadFlags#FORCE_AUTOHINT}. */
	public static final long LIGHT = (((1L) & 15) << 16);

	/** Strong hinting algorithm that should only be used for monochrome output. The result is probably unpleasant if the glyph is rendered in non-monochrome modes. */
	public static final long MONO = (((2L) & 15) << 16);

	/** A variant of {@link FreeTypeLoadTargetFlags#NORMAL} optimized for horizontally decimated LCD displays. */
	public static final long LCD = (((3L) & 15) << 16);

	/** A variant of {@link FreeTypeLoadTargetFlags#NORMAL} optimized for vertically decimated LCD displays. */
	public static final long LCD_V = (((4L) & 15) << 16);
}
