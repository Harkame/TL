package model.tache.categorie;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import model.tache.liste_tache.ListeTache;

public class TreeMapCategorie implements SortedMap <String, ListeTache>
{
	
	private static SortedMap<String, ListeTache> valeurs;

	public TreeMapCategorie()
	{
		valeurs = new TreeMap<String, ListeTache>();
	}
	
@Override
    public Comparator<? super String> comparator()
    {
        return valeurs.comparator();
    }
	
	@Override
	public void clear()
	{
		valeurs.clear();
	}

	@Override
	public boolean containsKey(Object key)
	{
		return valeurs.containsKey(((String) key).toUpperCase());
	}

	@Override
	public boolean containsValue(Object value)
	{
		return valeurs.containsValue(value);
	}

	@Override
	public ListeTache get(Object key)
	{
		return valeurs.get(((String) key).toUpperCase());
	}

	@Override
	public boolean isEmpty()
	{
		return valeurs.isEmpty();
	}

	@Override
	public ListeTache put(String key, ListeTache value)
	{
		return valeurs.put(key.toUpperCase(), value);
	}

	@Override
	public void putAll(Map<? extends String, ? extends ListeTache> m)
	{
		valeurs.putAll(m);
	}

	@Override
	public ListeTache remove(Object key)
	{
		return valeurs.remove(((String) key).toUpperCase());
	}

	@Override
	public int size()
	{
		return valeurs.size();
	}

	@Override
	public Set<java.util.Map.Entry<String, ListeTache>> entrySet()
	{
		return valeurs.entrySet();
	}

	@Override
	public String firstKey()
	{
		return valeurs.firstKey();
	}

	@Override
	public SortedMap<String, ListeTache> headMap(String toKey)
	{
		return valeurs.headMap(toKey.toUpperCase());
	}

	@Override
	public Set<String> keySet()
	{
		return valeurs.keySet();
	}

	@Override
	public String lastKey()
	{
		return valeurs.lastKey();
	}

	@Override
	public SortedMap<String, ListeTache> subMap(String fromKey, String toKey)
	{
		return valeurs.subMap(fromKey.toUpperCase(), toKey.toUpperCase());
	}

	@Override
	public SortedMap<String, ListeTache> tailMap(String fromKey)
	{
		return valeurs.tailMap(fromKey.toUpperCase());
	}

	@Override
	public Collection<ListeTache> values()
	{
		return valeurs.values();
	}
	
	@Override
	public String toString()
	{
		return valeurs.toString();
	}
}
