/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.xmldialect;

/**
 * Represents a local name and namespace URI of an XML element.
 */
public interface XmlName
{
	/**
	 * Gets the local name of the XML element.
	 * @return
	 */
	String getLocalName();

	/**
	 * Sets the local name of the XML element.
	 * @param localName
	 */
	void setLocalName(String localName);

	/**
	 *  Gets the namespace URI of the XML element.
	 * @return
	 */
	String getNamespaceUri();

	/**
	 *  Sets the namespace URI of the XML element.
	 * @param namespaceUri
	 */
	void setNamespaceUri(String namespaceUri);
}
