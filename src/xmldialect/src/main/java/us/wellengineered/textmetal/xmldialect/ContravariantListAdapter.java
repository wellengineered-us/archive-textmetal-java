/*
	Copyright ©2020 WellEngineered.us, all rights reserved.
	Distributed under the MIT license: https://opensource.org/licenses/MIT
*/

package us.wellengineered.textmetal.xmldialect;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ContravariantListAdapter<TToDerived extends TFromBase, TFromBase extends XmlObject> implements XmlObjectCollection<TToDerived>
{
	public ContravariantListAdapter(XmlObjectCollection<TFromBase> inner)
	{
		this.inner = inner;
	}

	private final XmlObjectCollection<TFromBase> inner;

	public XmlObjectCollection<TFromBase> getInner()
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
	public Iterator<TToDerived> iterator()
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
	public boolean add(TToDerived tToDerived)
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
	public boolean addAll(Collection<? extends TToDerived> c)
	{
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends TToDerived> c)
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
	public TToDerived get(int index)
	{
		return null;
	}

	@Override
	public TToDerived set(int index, TToDerived element)
	{
		return null;
	}

	@Override
	public void add(int index, TToDerived element)
	{

	}

	@Override
	public TToDerived remove(int index)
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
	public ListIterator<TToDerived> listIterator()
	{
		return null;
	}

	@Override
	public ListIterator<TToDerived> listIterator(int index)
	{
		return null;
	}

	@Override
	public List<TToDerived> subList(int fromIndex, int toIndex)
	{
		return null;
	}
}
