/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.xmldialect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/**
 * Marks a property of an XML object as being mapped to/from a well-known XML element.
 */
@Target(ElementType.METHOD)
@Inherited
public @interface XmlChildElementMapping
{
	/**
	 * Gets or sets the child element type (applicable only to those child elements which are well-known via properties with mapping annotations).
	 * @return
	 */
	ChildElementType childElementType();

	/**
	 * Gets or sets the local name of the XML element.
	 * @return
	 */
	String localName();

	/**
	 * Gets or sets the namespace URI of the XML element.
	 * @return
	 */
	String namespaceUri();

	/**
	 * Gets or sets the order of rendering of the element to the XML stream.
	 * Order is only applicable to XML output and is ignored during XML input.
	 * @return
	 */
	int order();
}
