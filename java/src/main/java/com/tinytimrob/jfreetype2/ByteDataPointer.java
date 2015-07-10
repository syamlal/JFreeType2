package com.tinytimrob.jfreetype2;

/** ByteDataPointer is a helper class which converts Java byte[] arrays into natively stored char* arrays. */
public class ByteDataPointer extends CNativeFreeTypeObject
{
	ByteDataPointer(long pointer)
	{
		super(pointer);
	}

	/** Allocates a new char* array and copies byte[] data into it. The char* array is stored inside a ByteDataPointer.<br/>
	 * <b><font color=crimson>When you have finished with the ByteDataPointer, you must release it, or you will cause a memory leak!</font></b>
	 *
	 * @param arr The byte[] array you want a ByteDataPointer for
	 * @return A new ByteDataPointer
	 */
	public static ByteDataPointer allocate(byte[] arr)
	{
		return new ByteDataPointer(JNIFreeType.INSTANCE.HelperFunc_ByteDataPointer_Allocate(arr));
	}

	/** Releases a ByteDataPointer that was previously allocated. */
	public void release()
	{
		if (this.pointer == 0)
		{
			throw new PointerAlreadyFreedException();
		}

		JNIFreeType.INSTANCE.HelperFunc_ByteDataPointer_Release(pointer);
		this.pointer = 0;
	}
}
