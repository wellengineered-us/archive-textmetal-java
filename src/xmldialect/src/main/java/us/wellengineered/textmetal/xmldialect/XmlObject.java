/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.xmldialect;

/**
 * Represents an XML object and it's "schema".
 */
public interface XmlObject
{
	/**
	 * Gets an array of allowed child XML object classes.
	 * @return
	 */
	Class<? extends XmlObject>[] getAllowedChildClasses();

	/**
	 * Gets a list of XML object items.
	 * @return
	 */
	XmlObjectCollection<?> getItems();

	/**
	 * Gets the optional single XML object content.
	 * @return
	 */
	XmlObject getContent();

	/**
	 * Sets the optional single XML object content.
	 * @param content
	 */
	void setContent(XmlObject content);

	/**
	 * Gets the parent XML object or null if this is the document root.
	 * @return
	 */
	XmlObject getParent();

	/**
	 * Sets the parent XML object or null if this is the document root.
	 * @param parent
	 */
	void setParent(XmlObject parent);

	/**
	 * Gets the surround XML object or null if this is not surrounded (in a collection).
	 * @return
	 */
	XmlObjectCollection<?> getSurround();

	/**
	 * Sets the surround XML object or null if this is not surrounded (in a collection).
	 * @param surround
	 */
	void setSurround(XmlObjectCollection<?> surround);
}
