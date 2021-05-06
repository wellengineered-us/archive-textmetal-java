/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.xmldialect;

import us.wellengineered.solder.polyfills.exceptions.ArgumentNullException;

import java.util.ArrayList;

public abstract class AbstractXmlObjectCollection<TXmlObject extends XmlObject> extends ArrayList<TXmlObject> implements XmlObjectCollection<TXmlObject>
{
	protected AbstractXmlObjectCollection(XmlObject site)
	{
		if (site == null)
			throw new ArgumentNullException("site");

		this.site = site;
	}

	private final XmlObject site;

	@Override
	public XmlObject getSite()
	{
		return this.site;
	}

	@Override
	public TXmlObject set(int index, TXmlObject element)
	{
		if (element == null)
			throw new ArgumentNullException("element");

		element.setSurround(this);
		element.setParent(this.getSite());

		return super.set(index, element);
	}

	@Override
	public boolean add(TXmlObject element)
	{
		if (element == null)
			throw new ArgumentNullException("element");

		element.setSurround(this);
		element.setParent(this.getSite());

		return super.add(element);
	}

	@Override
	public void add(int index, TXmlObject element)
	{
		if (element == null)
			throw new ArgumentNullException("element");

		element.setSurround(this);
		element.setParent(this.getSite());
		
		super.add(index, element);
	}

	@Override
	public TXmlObject remove(int index)
	{
		TXmlObject item;

		item = super.get(index);

		if (item != null)
		{
			item.setSurround(null);
			item.setParent(null);
		}

		return super.remove(index);
	}

	@Override
	public boolean remove(Object o)
	{
		TXmlObject item;

		item = (TXmlObject)o;

		if (item != null)
		{
			item.setSurround(null);
			item.setParent(null);
		}

		return super.remove(o);
	}

	@Override
	public void clear()
	{
		for (TXmlObject item : this)
		{
			if (item != null)
			{
				item.setSurround(null);
				item.setParent(null);
			}
		}

		super.clear();
	}
}
