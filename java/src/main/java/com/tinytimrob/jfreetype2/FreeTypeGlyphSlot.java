package com.tinytimrob.jfreetype2;

/** FreeType root glyph slot class structure. A glyph slot is a container where individual glyphs can be loaded, be they in outline or bitmap format. <br/><br/>
 * 
 * If {@link FreeTypeFace#loadGlyph} is called with default flags (see {@link FreeTypeLoadFlags#DEFAULT}) the glyph image is loaded in the glyph slot in its native format (e.g., an
 * outline glyph for TrueType and Type 1 formats). <br/><br/>
 * 
 * This image can later be converted into a bitmap by calling {@link FreeTypeGlyphSlot#render}. This function finds the current renderer for the native image's format, then invokes it. <br/><br/>
 * 
 * The renderer is in charge of transforming the native image through the slot's face transformation fields, then converting it into a bitmap that is returned in 'slot->bitmap'. <br/><br/>
 * 
 * Note that 'slot->bitmap_left' and 'slot->bitmap_top' are also used to specify the position of the bitmap relative to the current pen position (e.g., coordinates (0,0) on the baseline).
 * Of course, 'slot->format' is also changed to FT_GLYPH_FORMAT_BITMAP.
 */
public class FreeTypeGlyphSlot extends CNativeFreeTypeObject
{
	FreeTypeGlyphSlot(long pointer)
	{
		super(pointer);
	}

	/** Convert a given glyph image to a bitmap. It does so by inspecting the glyph image format, finding the relevant renderer, and invoking it. 
	 * 
	 * @param render_mode This is the render mode used to render the glyph image into a bitmap. See {@link FreeTypeRenderMode} for a list of possible values.
	 * @return FreeType error code. {@link FreeTypeError#OK} means success.
	 */
	public FreeTypeError render(FreeTypeRenderMode render_mode)
	{
		long pointer = this.getPointer();
		return FreeTypeError.convert(JNIFreeType.INSTANCE.FT_Render_Glyph(pointer, render_mode.ordinal()));
	}

	/** This field is used as a bitmap descriptor when the slot format is FT_GLYPH_FORMAT_BITMAP. Note that the address and content of the bitmap buffer can
	 * change between calls of {@link FreeTypeFace#loadGlyph} and a few other functions.
	 * 
	 * @return The current bitmap descriptor
	 */
	public FreeTypeBitmap getBitmap()
	{
		long pointer = this.getPointer();
		long bitmapPointer = JNIFreeType.INSTANCE.FT_GlyphSlotRec_bitmap(pointer);
		return bitmapPointer == 0 ? null : new FreeTypeBitmap(bitmapPointer);
	}

	/** The bitmap's left bearing expressed in integer pixels. Only valid if the format is FT_GLYPH_FORMAT_BITMAP, this is, if the glyph slot contains a bitmap.
	 * 
	 * @return The bitmap's left bearing expressed in integer pixels
	 */
	public int getBitmapLeft()
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_GlyphSlotRec_bitmap_left(pointer);
	}

	/** The bitmap's top bearing expressed in integer pixels. Remember that this is the distance from the baseline to the top-most glyph scanline, upwards y coordinates being positive.
	 * 
	 * @return The bitmap's top bearing expressed in integer pixels
	 */
	public int getBitmapTop()
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_GlyphSlotRec_bitmap_top(pointer);
	}

	/** This shorthand is, depending on {@link FreeTypeLoadFlags#IGNORE_TRANSFORM}, the transformed (hinted) advance width for the glyph, in 26.6 fractional pixel format. As specified with
	 * {@link FreeTypeLoadFlags#VERTICAL_LAYOUT}, it uses either the 'horiAdvance' or the 'vertAdvance' value of 'metrics' field.
	 * 
	 * @return The horizontal x value
	 */
	public int getAdvanceX()
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_GlyphSlotRec_advance_x(pointer);
	}

	/** This shorthand is, depending on {@link FreeTypeLoadFlags#IGNORE_TRANSFORM}, the transformed (hinted) advance height for the glyph, in 26.6 fractional pixel format. As specified with
	 * {@link FreeTypeLoadFlags#VERTICAL_LAYOUT}, it uses either the 'horiAdvance' or the 'vertAdvance' value of 'metrics' field.
	 * 
	 * @return The vertical y value
	 */
	public int getAdvanceY()
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_GlyphSlotRec_advance_y(pointer);
	}
}
