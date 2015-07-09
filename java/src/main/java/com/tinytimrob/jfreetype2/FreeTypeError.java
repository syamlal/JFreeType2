package com.tinytimrob.jfreetype2;

public enum FreeTypeError
{
	/** no error */
	OK(0x00, "no error"),

	/** cannot open resource */
	CANNOT_OPEN_RESOURCE(0x01, "cannot open resource"),

	/** unknown file format */
	UNKNOWN_FILE_FORMAT(0x02, "unknown file format"),

	/** broken file */
	INVALID_FILE_FORMAT(0x03, "broken file"),

	/** invalid FreeType version */
	INVALID_VERSION(0x04, "invalid FreeType version"),

	/** module version is too low */
	LOWER_MODULE_VERSION(0x05, "module version is too low"),

	/** invalid argument */
	INVALID_ARGUMENT(0x06, "invalid argument"),

	/** unimplemented feature */
	UNIMPLEMENTED_FEATURE(0x07, "unimplemented feature"),

	/** broken table */
	INVALID_TABLE(0x08, "broken table"),

	/** broken offset within table */
	INVALID_OFFSET(0x09, "broken offset within table"),

	/** array allocation size too large */
	ARRAY_TOO_LARGE(0x0A, "array allocation size too large"),

	/** missing module */
	MISSING_MODULE(0x0B, "missing module"),

	/** missing property */
	MISSING_PROPERTY(0x0C, "missing property"),

	/** invalid glyph index */
	INVALID_GLYPH_INDEX(0x10, "invalid glyph index"),

	/** invalid character code */
	INVALID_CHARACTER_CODE(0x11, "invalid character code"),

	/** unsupported glyph image format */
	INVALID_GLYPH_FORMAT(0x12, "unsupported glyph image format"),

	/** cannot render this glyph format */
	CANNOT_RENDER_GLYPH(0x13, "cannot render this glyph format"),

	/** invalid outline */
	INVALID_OUTLINE(0x14, "invalid outline"),

	/** invalid composite glyph */
	INVALID_COMPOSITE(0x15, "invalid composite glyph"),

	/** too many hints */
	TOO_MANY_HINTS(0x16, "too many hints"),

	/** invalid pixel size */
	INVALID_PIXEL_SIZE(0x17, "invalid pixel size"),

	/** invalid object handle */
	INVALID_HANDLE(0x20, "invalid object handle"),

	/** invalid library handle */
	INVALID_LIBRARY_HANDLE(0x21, "invalid library handle"),

	/** invalid module handle */
	INVALID_DRIVER_HANDLE(0x22, "invalid module handle"),

	/** invalid face handle */
	INVALID_FACE_HANDLE(0x23, "invalid face handle"),

	/** invalid size handle */
	INVALID_SIZE_HANDLE(0x24, "invalid size handle"),

	/** invalid glyph slot handle */
	INVALID_SLOT_HANDLE(0x25, "invalid glyph slot handle"),

	/** invalid charmap handle */
	INVALID_CHARMAP_HANDLE(0x26, "invalid charmap handle"),

	/** invalid cache manager handle */
	INVALID_CACHE_HANDLE(0x27, "invalid cache manager handle"),

	/** invalid stream handle */
	INVALID_STREAM_HANDLE(0x28, "invalid stream handle"),

	/** too many modules */
	TOO_MANY_DRIVERS(0x30, "too many modules"),

	/** too many extensions */
	TOO_MANY_EXTENSIONS(0x31, "too many extensions"),

	/** out of memory */
	OUT_OF_MEMORY(0x40, "out of memory"),

	/** unlisted object */
	UNLISTED_OBJECT(0x41, "unlisted object"),

	/** cannot open stream */
	CANNOT_OPEN_STREAM(0x51, "cannot open stream"),

	/** invalid stream seek */
	INVALID_STREAM_SEEK(0x52, "invalid stream seek"),

	/** invalid stream skip */
	INVALID_STREAM_SKIP(0x53, "invalid stream skip"),

	/** invalid stream read */
	INVALID_STREAM_READ(0x54, "invalid stream read"),

	/** invalid stream operation */
	INVALID_STREAM_OPERATION(0x55, "invalid stream operation"),

	/** invalid frame operation */
	INVALID_FRAME_OPERATION(0x56, "invalid frame operation"),

	/** nested frame access */
	NESTED_FRAME_ACCESS(0x57, "nested frame access"),

	/** invalid frame read */
	INVALID_FRAME_READ(0x58, "invalid frame read"),

	/** raster uninitialized */
	RASTER_UNINITIALIZED(0x60, "raster uninitialized"),

	/** raster corrupted */
	RASTER_CORRUPTED(0x61, "raster corrupted"),

	/** raster overflow */
	RASTER_OVERFLOW(0x62, "raster overflow"),

	/** negative height while rastering */
	RASTER_NEGATIVE_HEIGHT(0x63, "negative height while rastering"),

	/** too many registered caches */
	TOO_MANY_CACHES(0x70, "too many registered caches"),

	/** invalid opcode */
	INVALID_OPCODE(0x80, "invalid opcode"),

	/** too few arguments */
	TOO_FEW_ARGUMENTS(0x81, "too few arguments"),

	/** stack overflow */
	STACK_OVERFLOW(0x82, "stack overflow"),

	/** code overflow */
	CODE_OVERFLOW(0x83, "code overflow"),

	/** bad argument */
	BAD_ARGUMENT(0x84, "bad argument"),

	/** division by zero */
	DIVIDE_BY_ZERO(0x85, "division by zero"),

	/** invalid reference */
	INVALID_REFERENCE(0x86, "invalid reference"),

	/** found debug opcode */
	DEBUG_OPCODE(0x87, "found debug opcode"),

	/** found ENDF opcode in execution stream */
	ENDF_IN_EXEC_STREAM(0x88, "found ENDF opcode in execution stream"),

	/** nested DEFS */
	NESTED_DEFS(0x89, "nested DEFS"),

	/** invalid code range */
	INVALID_CODERANGE(0x8A, "invalid code range"),

	/** execution context too long */
	EXECUTION_TOO_LONG(0x8B, "execution context too long"),

	/** too many function definitions */
	TOO_MANY_FUNCTION_DEFS(0x8C, "too many function definitions"),

	/** too many instruction definitions */
	TOO_MANY_INSTRUCTION_DEFS(0x8D, "too many instruction definitions"),

	/** SFNT font table missing */
	TABLE_MISSING(0x8E, "SFNT font table missing"),

	/** horizontal header (hhea) table missing */
	HORIZ_HEADER_MISSING(0x8F, "horizontal header (hhea) table missing"),

	/** locations (loca) table missing */
	LOCATIONS_MISSING(0x90, "locations (loca) table missing"),

	/** name table missing */
	NAME_TABLE_MISSING(0x91, "name table missing"),

	/** character map (cmap) table missing */
	CMAP_TABLE_MISSING(0x92, "character map (cmap) table missing"),

	/** horizontal metrics (hmtx) table missing */
	HMTX_TABLE_MISSING(0x93, "horizontal metrics (hmtx) table missing"),

	/** PostScript (post) table missing */
	POST_TABLE_MISSING(0x94, "PostScript (post) table missing"),

	/** invalid horizontal metrics */
	INVALID_HORIZ_METRICS(0x95, "invalid horizontal metrics"),

	/** invalid character map (cmap) format */
	INVALID_CHARMAP_FORMAT(0x96, "invalid character map (cmap) format"),

	/** invalid ppem value */
	INVALID_PPEM(0x97, "invalid ppem value"),

	/** invalid vertical metrics */
	INVALID_VERT_METRICS(0x98, "invalid vertical metrics"),

	/** could not find context */
	COULD_NOT_FIND_CONTEXT(0x99, "could not find context"),

	/** invalid PostScript (post) table format */
	INVALID_POST_TABLE_FORMAT(0x9A, "invalid PostScript (post) table format"),

	/** invalid PostScript (post) table */
	INVALID_POST_TABLE(0x9B, "invalid PostScript (post) table"),

	/** opcode syntax error */
	SYNTAX_ERROR(0xA0, "opcode syntax error"),

	/** argument stack underflow */
	STACK_UNDERFLOW(0xA1, "argument stack underflow"),

	/** ignore */
	IGNORE(0xA2, "ignore"),

	/** no Unicode glyph name found */
	NO_UNICODE_GLYPH_NAME(0xA3, "no Unicode glyph name found"),

	/** glyph to big for hinting */
	GLYPH_TOO_BIG(0xA4, "glyph to big for hinting"),

	/** 'STARTFONT' field missing */
	MISSING_STARTFONT_FIELD(0xB0, "'STARTFONT' field missing"),

	/** 'FONT' field missing */
	MISSING_FONT_FIELD(0xB1, "'FONT' field missing"),

	/** 'SIZE' field missing */
	MISSING_SIZE_FIELD(0xB2, "'SIZE' field missing"),

	/** 'FONTBOUNDINGBOX' field missing */
	MISSING_FONTBOUNDINGBOX_FIELD(0xB3, "'FONTBOUNDINGBOX' field missing"),

	/** 'CHARS' field missing */
	MISSING_CHARS_FIELD(0xB4, "'CHARS' field missing"),

	/** 'STARTCHAR' field missing */
	MISSING_STARTCHAR_FIELD(0xB5, "'STARTCHAR' field missing"),

	/** 'ENCODING' field missing */
	MISSING_ENCODING_FIELD(0xB6, "'ENCODING' field missing"),

	/** 'BBX' field missing */
	MISSING_BBX_FIELD(0xB7, "'BBX' field missing"),

	/** 'BBX' too big */
	BBX_TOO_BIG(0xB8, "'BBX' too big"),

	/** Font header corrupted or missing fields */
	CORRUPTED_FONT_HEADER(0xB9, "Font header corrupted or missing fields"),

	/** Font glyphs corrupted or missing fields */
	CORRUPTED_FONT_GLYPHS(0xBA, "Font glyphs corrupted or missing fields");

	final int hexValue;
	final String description;

	FreeTypeError(int hexValue, String description)
	{
		this.hexValue = hexValue;
		this.description = description;
	}

	/** Converts integer to enum
	 *
	 * @param i The integer to convert
	 * @return Either the correct enum, or null if there is no such enum for that value
	 */
	static FreeTypeError convert(int i)
	{
		try
		{
			for(FreeTypeError e : values())
			{
				if(e.hexValue == i)
				{
					return e;
				}
			}
			return null;
		}
		catch (Throwable t)
		{
			return null;
		}
	}
}
