package com.tinytimrob.jfreetype2;

/** An enumeration used to specify which kerning values to return in {@link FreeTypeFace#getKerning}. */
public enum FreeTypeKerningMode
{
	/** Return scaled and grid-fitted kerning distances (value is 0). */
	DEFAULT,
	
	/** Return scaled but un-grid-fitted kerning distances. */
	UNFITTED,
	
	/** Return the kerning vector in original font units. */
	UNSCALED
}
