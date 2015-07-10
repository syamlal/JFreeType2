package com.tinytimrob.jfreetype2;

/** A structure used to describe a bitmap or pixmap to the raster. Note that we now manage pixmaps of various depths through the ‘pixel_mode’ field. */
public class FreeTypeBitmap extends CNativeFreeTypeObject
{
	FreeTypeBitmap(long pointer)
	{
		super(pointer);
	}
}
