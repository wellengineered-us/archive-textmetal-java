/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.xmldialect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Target;

/**
 * Marks a property of an XML object as being mapped to/from an XML attribute.
 */
@Target(ElementType.METHOD)
@Inherited
public @interface XmlAttributeMapping
{
	/**
	 * Gets or sets the local name of the XML attribute.
	 * @return
	 */
	String localName();

	/**
	 * Gets or sets the namespace URI of the XML attribute.
	 * @return
	 */
	String namespaceUri();

	/**
	 * Gets or sets the order of rendering of the attribute to the XML stream.
	 * Order is only applicable to XML output and is ignored during XML input.
	 * @return
	 */
	int order();
}
