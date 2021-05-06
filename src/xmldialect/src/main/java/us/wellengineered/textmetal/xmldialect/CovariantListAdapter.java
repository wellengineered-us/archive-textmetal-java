/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.xmldialect;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class CovariantListAdapter<TToBase extends XmlObject, TFromDerived extends TToBase> implements XmlObjectCollection<TToBase>
{
	public CovariantListAdapter(XmlObjectCollection<TFromDerived> inner)
	{
		this.inner = inner;
	}

	private final XmlObjectCollection<TFromDerived> inner;

	public XmlObjectCollection<TFromDerived> getInner()
	{
		return this.inner;
	}

	@Override
	public XmlObject getSite()
	{
		return null;
	}

	@Override
	public void setSite(XmlObject site)
	{

	}

	@Override
	public int size()
	{
		return 0;
	}

	@Override
	public boolean isEmpty()
	{
		return false;
	}

	@Override
	public boolean contains(Object o)
	{
		return false;
	}

	@Override
	public Iterator<TToBase> iterator()
	{
		return null;
	}

	@Override
	public Object[] toArray()
	{
		return new Object[0];
	}

	@Override
	public <T> T[] toArray(T[] a)
	{
		return null;
	}

	@Override
	public boolean add(TToBase tToBase)
	{
		return false;
	}

	@Override
	public boolean remove(Object o)
	{
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends TToBase> c)
	{
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends TToBase> c)
	{
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		return false;
	}

	@Override
	public void clear()
	{

	}

	@Override
	public TToBase get(int index)
	{
		return null;
	}

	@Override
	public TToBase set(int index, TToBase element)
	{
		return null;
	}

	@Override
	public void add(int index, TToBase element)
	{

	}

	@Override
	public TToBase remove(int index)
	{
		return null;
	}

	@Override
	public int indexOf(Object o)
	{
		return 0;
	}

	@Override
	public int lastIndexOf(Object o)
	{
		return 0;
	}

	@Override
	public ListIterator<TToBase> listIterator()
	{
		return null;
	}

	@Override
	public ListIterator<TToBase> listIterator(int index)
	{
		return null;
	}

	@Override
	public List<TToBase> subList(int fromIndex, int toIndex)
	{
		return null;
	}
}
