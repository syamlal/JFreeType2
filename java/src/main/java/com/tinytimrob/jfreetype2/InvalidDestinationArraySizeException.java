package com.tinytimrob.jfreetype2;

/** An exception that will be thrown if the user calls an FMOD function with incorrect array size. */
public final class InvalidDestinationArraySizeException extends RuntimeException
{
	private static final long serialVersionUID = -552531105917021192L;

	InvalidDestinationArraySizeException(String name, int target, int actual)
	{
		super("Invalid destination array size for " + name + ": Target size must be " + target + ", actual size was " + actual);
	}
}
