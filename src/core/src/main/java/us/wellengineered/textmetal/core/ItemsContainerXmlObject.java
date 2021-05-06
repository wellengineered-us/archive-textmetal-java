/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.core;

import us.wellengineered.textmetal.xmldialect.XmlObject;

public interface ItemsContainerXmlObject<TItemsRestriction extends XmlObject> extends ContainerXmlObject
{
	TItemsRestriction getItems();
}
