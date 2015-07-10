package com.tinytimrob.jfreetype2;

/** A structure used to describe a bitmap or pixmap to the raster. Note that we now manage pixmaps of various depths through the ‘pixel_mode’ field. */
public class FreeTypeBitmap extends CNativeFreeTypeObject
{
	FreeTypeBitmap(long pointer)
	{
		super(pointer);
	}

	/** The number of bitmap rows.
	 * 
	 * @return The number of bitmap rows
	 */
	public long getRows()
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_Bitmap_rows(pointer);
	}

	/** The number of pixels in bitmap row.
	 * 
	 * @return The number of pixels in bitmap row
	 */
	public long getWidth()
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_Bitmap_width(pointer);
	}

	/** The pitch's absolute value is the number of bytes taken by one bitmap row, including padding. However, the pitch is positive when the bitmap
	 * has a ‘down’ flow, and negative when it has an ‘up’ flow. In all cases, the pitch is an offset to add to a bitmap pointer in order to go down
	 * one row. <br/><br/>
	 * 
	 * Note that ‘padding’ means the alignment of a bitmap to a byte border, and FreeType functions normally align to the smallest possible integer
	 * value. <br/><br/>
	 * 
	 * For the B/W rasterizer, ‘pitch’ is always an even number. <br/><br/>
	 * 
	 * To change the pitch of a bitmap (say, to make it a multiple of 4), use FT_Bitmap_Convert. Alternatively, you might use callback functions to
	 * directly render to the application's surface; see the file ‘example2.cpp’ in the tutorial for a demonstration.
	 * 
	 * @return The number of bytes taken by one bitmap row, including padding
	 */
	public int getPitch()
	{
		long pointer = this.getPointer();
		return JNIFreeType.INSTANCE.FT_Bitmap_pitch(pointer);
	}

	/** Returns a byte array containing the bitmap buffer. The size should be aligned on 32-bit boundaries in most cases.
	 * 
	 * @return A byte array containing the bitmap buffer
	 */
	public byte[] getBuffer()
	{
		long pointer = this.getPointer();
		long rows = this.getRows();
		int pitch = this.getPitch();
		if (pitch < 0)
		{
			pitch = -pitch;
		}
		byte[] array = new byte[(int) (rows * pitch)];
		JNIFreeType.INSTANCE.FT_Bitmap_buffer(pointer, array);
		return array;
	}

	//int getNumGrays()

	//short getPixelMode()
}
