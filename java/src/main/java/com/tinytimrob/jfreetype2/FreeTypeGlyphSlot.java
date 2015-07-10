package com.tinytimrob.jfreetype2;

/** FreeType root glyph slot class structure. A glyph slot is a container where individual glyphs can be loaded, be they in outline or bitmap format. <br/><br/>
 * 
 * If FT_Load_Glyph is called with default flags (see {@link FreeTypeLoadFlags#DEFAULT}) the glyph image is loaded in the glyph slot in its native format (e.g., an
 * outline glyph for TrueType and Type 1 formats). <br/><br/>
 * 
 * This image can later be converted into a bitmap by calling FT_Render_Glyph. This function finds the current renderer for the native image's format, then invokes it. <br/><br/>
 * 
 * The renderer is in charge of transforming the native image through the slot's face transformation fields, then converting it into a bitmap that is returned in ‘slot->bitmap’. <br/><br/>
 * 
 * Note that ‘slot->bitmap_left’ and ‘slot->bitmap_top’ are also used to specify the position of the bitmap relative to the current pen position (e.g., coordinates (0,0) on the baseline).
 * Of course, ‘slot->format’ is also changed to FT_GLYPH_FORMAT_BITMAP.
 */
public class FreeTypeGlyphSlot extends CNativeFreeTypeObject
{
	FreeTypeGlyphSlot(long pointer)
	{
		super(pointer);
	}
}
