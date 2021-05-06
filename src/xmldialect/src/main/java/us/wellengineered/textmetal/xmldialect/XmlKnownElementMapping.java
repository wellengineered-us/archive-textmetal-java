/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.xmldialect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

/**
 * Marks an interface as an XML object which is mapped to/from an XML element.
 */
@Target(ElementType.TYPE)
@Inherited
public @interface XmlKnownElementMapping
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
}
