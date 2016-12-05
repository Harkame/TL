package model.tache.comparator;

import model.tache.Tache;

public class ComplexTacheComparator extends TacheComparator
{
	@Override
	public int compare(Tache p_tache_a, Tache p_tache_b)
	{
		return p_tache_a.nextDate().compareTo(p_tache_b.nextDate());
	}
}
