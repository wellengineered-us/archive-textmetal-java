/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.core;

/**
 * The exception thrown when a TextMetal runtime error occurs.
 */
public final class TextMetalException extends RuntimeException
{
	/**
	 * Initializes a new instance of the TextMetalException class.
	 */
	public TextMetalException()
	{
		super();
	}

	/**
	 * Initializes a new instance of the TextMetalException class.
	 * @param message
	 */
	public TextMetalException(String message)
	{
		super(message);
	}

	/**
	 * Initializes a new instance of the TextMetalException class.
	 * @param message
	 * @param cause
	 */
	public TextMetalException(String message, Throwable cause)
	{
		super(message, cause);
	}

	/**
	 * Initializes a new instance of the TextMetalException class.
	 * @param cause
	 */
	public TextMetalException(Throwable cause)
	{
		super(cause);
	}

	private static final long serialVersionUID = -5365630128856068164L;
}
