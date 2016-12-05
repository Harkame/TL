package model.tache.comparator;

import model.tache.Tache;

public class SimpleTacheComparator extends TacheComparator
{
	@Override
	public int compare(Tache p_tache_a, Tache p_tache_b)
	{
		return p_tache_a.getDateLimite().compareTo(p_tache_b.getDateLimite());
	}
}
