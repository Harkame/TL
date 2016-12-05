package model.tache.comparator;

import java.io.Serializable;
import java.util.Comparator;

import model.tache.Tache;

public abstract class TacheComparator implements Comparator<Tache>, Serializable
{
	@Override
	public abstract int compare(Tache p_tache_a, Tache p_tache_b);
}
