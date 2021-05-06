/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.xmldialect;

/**
 * Represents an XML text object and it's text value.
 */
public interface XmlTextObject extends XmlObject
{
	/**
	 * Gets the XML name (local name and namespace URI).
	 * @return
	 */
	XmlName getName();

	/**
	 * Sets the XML name (local name and namespace URI).
	 * @param name
	 */
	void setName(XmlName name);

	/**
	 * Gets the text value.
	 * @return
	 */
	String getText();

	/**
	 * Sets the text value.
	 * @param text
	 */
	void setText(String text);
}
