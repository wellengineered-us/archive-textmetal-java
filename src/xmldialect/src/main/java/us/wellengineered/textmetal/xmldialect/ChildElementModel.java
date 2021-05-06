/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.xmldialect;

/**
 * Specifies the child element model of an XML object (applicable only to those which are not well-known via properties with mapping annotations).
 */
public enum ChildElementModel
{
	UNKNOWN(0),

	/**
	 * This XML object is not allowed to have any child elements. This is the default.
	 */
	STERILE(1),

	/**
	 * This XML object can have ONE non-well-known child element. Use the Content property to access the possibly null value
	 */
	CONTENT(2),

	/**
	 * This XML object can have MANY non-well-known child element. Use the Items property to access the possibly empty list of values.
	 */
	ITEMS(3);

	ChildElementModel(final Integer value)
	{
		this.value = value;
	}

	private final Integer value;
}
