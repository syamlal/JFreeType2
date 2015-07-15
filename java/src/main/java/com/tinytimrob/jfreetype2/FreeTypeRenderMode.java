package com.tinytimrob.jfreetype2;

/** An enumeration type that lists the render modes supported by FreeType 2. Each mode corresponds to a specific type of scanline conversion performed on the outline. <br/><br/>
 * 
 * For bitmap fonts and embedded bitmaps the 'bitmap->pixel_mode' field in the FT_GlyphSlotRec structure gives the format of the returned bitmap. <br/><br/>
 * 
 * All modes except {@link FreeTypeRenderMode#MONO} use 256 levels of opacity. <br/><br/>
 * 
 * The LCD-optimized glyph bitmaps produced by {@link FreeTypeGlyphSlot#render} can be filtered to reduce color-fringes by using FT_Library_SetLcdFilter (not active in the default builds).
 * It is up to the caller to either call FT_Library_SetLcdFilter (if available) or do the filtering itself. <br/><br/>
 *  
 * The selected render mode only affects vector glyphs of a font. Embedded bitmaps often have a different pixel mode like FT_PIXEL_MODE_MONO. You can use FT_Bitmap_Convert
 * to transform them into 8-bit pixmaps.*/
public enum FreeTypeRenderMode
{
	/** This is the default render mode; it corresponds to 8-bit anti-aliased bitmaps. */
	NORMAL,

	/** This is equivalent to {@link FreeTypeRenderMode#NORMAL}. It is only defined as a separate value because render modes are also used indirectly
	 * to define hinting algorithm selectors. See {@link FreeTypeLoadTargetFlags} for details. */
	LIGHT,

	/** This mode corresponds to 1-bit bitmaps (with 2 levels of opacity). */
	MONO,

	/** This mode corresponds to horizontal RGB and BGR sub-pixel displays like LCD screens. It produces 8-bit bitmaps that are 3 times the width of
	 * the original glyph outline in pixels, and which use the FT_PIXEL_MODE_LCD mode. */
	LCD,

	/** This mode corresponds to vertical RGB and BGR sub-pixel displays (like PDA screens, rotated LCD displays, etc.). It produces 8-bit bitmaps that
	 * are 3 times the height of the original glyph outline in pixels and use the FT_PIXEL_MODE_LCD_V mode. */
	LCD_V;
}
