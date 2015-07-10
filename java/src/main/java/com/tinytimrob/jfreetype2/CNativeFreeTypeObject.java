package com.tinytimrob.jfreetype2;

/** Base class representing a native object in the FreeType library */
public class CNativeFreeTypeObject
{
	CNativeFreeTypeObject(long pointer)
	{
		this.pointer = pointer;
	}

	long pointer;

	/** For internal use only. Returns the pointer for passing directly to native from object. Throws if invalid
	 * @return The pointer
	 * @throws PointerAlreadyFreedException If the pointer is already freed
	 */
	long getPointer() throws PointerAlreadyFreedException
	{
		if (this.pointer == 0)
		{
			throw new PointerAlreadyFreedException();
		}
		return this.pointer;
	}

	/** Returns whether or not this native FreeType object is still allocated
	 * 
	 * @return Whether or not the object is still allocated
	 */
	public boolean isAllocated()
	{
		return this.pointer != 0;
	}

	/** Returns whether this object's pointer matches with another object's pointer
	 * 
	 * @param other The other object
	 * @return Whether or not the pointers match
	 */
	public boolean hasMatchingPointerWith(CNativeFreeTypeObject other)
	{
		return other != null && this.pointer == other.pointer;
	}
}
