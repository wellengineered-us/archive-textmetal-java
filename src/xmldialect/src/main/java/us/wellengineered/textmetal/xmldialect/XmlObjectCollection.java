/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.xmldialect;

import java.util.List;

/**
 * Represents an XML object collection.
 * @param <TXmlObject>
 */
public interface XmlObjectCollection<TXmlObject extends XmlObject> extends List<TXmlObject>
{
	/**
	 * Gets the site XML object or null if this is unattached.
	 * @return
	 */
	XmlObject getSite();

	/**
	 * Sets the site XML object or null if this is unattached.
	 * @param site
	 */
	void setSite(XmlObject site);
}
