package com.tinytimrob.jfreetype2;

/** A list of bit-flags used to indicate the style of a given face. These are returned by {@link FreeTypeFace#getStyleFlags()}. */
public class FreeTypeStyleFlags
{
	/** Indicates that a given face style is italic or oblique. */
	public static final long ITALIC = (1L << 0);

	/** Indicates that a given face is bold. */
	public static final long BOLD = (1L << 1);
}
