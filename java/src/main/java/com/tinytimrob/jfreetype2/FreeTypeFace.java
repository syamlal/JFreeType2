package com.tinytimrob.jfreetype2;

/** A handle to a given typographic face object. A face object models a given typeface, in a given style. */
public class FreeTypeFace extends CNativeFreeTypeObject
{
	FreeTypeFace(long pointer)
	{
		super(pointer);
	}
}
