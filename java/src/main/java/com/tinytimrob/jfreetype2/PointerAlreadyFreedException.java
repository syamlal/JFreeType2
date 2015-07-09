package com.tinytimrob.jfreetype2;

/** An exception that will be thrown if the user tries to call a native function on an object that has already been freed. */
public final class PointerAlreadyFreedException extends NullPointerException
{
	private static final long serialVersionUID = -2692947949487634426L;

	PointerAlreadyFreedException()
	{
		super();
	}

	PointerAlreadyFreedException(String s)
	{
		super(s);
	}
}
