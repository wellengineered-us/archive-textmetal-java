/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.xmldialect;

/**
 * Specifies the allowed child element types for an XML object properties
 * (applicable only to those which are well-known via properties with mapping annotations).
 */
public enum ChildElementType
{
	UNKNOWN(0),

	/**
	 * The element is a text element using it's local name and namespace. This is the default.
	 */
	TEXT_VALUE(1),

	/**
	 * The element will be rendered as a non-text element using it's local name and namespace.
	 */
	UNQUALIFIED(2),

	/**
	 * The element will be rendered as a non-text element using it's local name dot prefixed with the local name of it's parent node, and namespace. This resembles XAML markup.
	 */
	PARENT_QUALIFIED(3);

	ChildElementType(final Integer value)
	{
		this.value = value;
	}

	private final Integer value;
}
