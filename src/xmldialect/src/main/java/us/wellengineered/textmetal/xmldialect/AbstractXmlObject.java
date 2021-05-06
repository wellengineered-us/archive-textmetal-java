/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.xmldialect;

import us.wellengineered.solder.polyfills.exceptions.ArgumentNullException;

public abstract class AbstractXmlObject implements XmlObject
{
	protected AbstractXmlObject(XmlObjectCollection<?> items)
	{
		if (items == null)
			throw new ArgumentNullException("items");

		this.items = items;
	}

	private final XmlObjectCollection<?> items;
	private XmlObject content;
	private XmlObject parent;
	private XmlObjectCollection surround;

	@Override
	public Class<? extends XmlObject>[] getAllowedChildClasses()
	{
		return null;
	}

	@Override
	public XmlObjectCollection<?> getItems()
	{
		return this.items;
	}

	@Override
	public XmlObject getContent()
	{
		return this.content;
	}

	@Override
	public void setContent(XmlObject content)
	{
		this.ensureParentOnPropertySet(this.content, content);
		this.content = content;
	}

	@Override
	public XmlObject getParent()
	{
		return this.parent;
	}

	@Override
	public void setParent(XmlObject parent)
	{
		this.parent = parent;
	}

	@Override
	public XmlObjectCollection<?> getSurround()
	{
		return this.surround;
	}

	@Override
	public void setSurround(XmlObjectCollection<?> surround)
	{
		this.surround = surround;
	}

	protected void ensureParentOnPropertySet(XmlObject oldValueObj, XmlObject newValueObj)
	{
		if (oldValueObj != null)
		{
			oldValueObj.setSurround(null);
			oldValueObj.setParent(null);
		}

		if (newValueObj != null)
		{
			newValueObj.setSurround(null);
			newValueObj.setParent(this);
		}
	}
}
