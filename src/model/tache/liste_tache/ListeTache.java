package model.tache.liste_tache;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

import model.tache.Tache;
import model.tache.TachePonctuelle;
import model.tache.categorie.TreeMapCategorie;

public abstract class ListeTache implements SortedSet<Tache>, Serializable
{
	private static final long serialVersionUID       = 1L;
	
	private static final String CHEMIN_SERIALIZATION = "/home/harkame/test/toto.data"; //Repertoire courant
	
	private SortedSet<Tache> liste_taches;

    public final Set<Tache> getListe_taches()
    {
        return liste_taches;
    }

    public ListeTache()
    {
        liste_taches = new TreeSet<Tache>();
    }
    
    @SuppressWarnings({"rawtypes", "unchecked"})
	public ListeTache(Comparator p_comparator)
    {
        liste_taches = new TreeSet<Tache>(p_comparator);
    }

    @Override
    public final Comparator<? super Tache> comparator()
    {
    	return liste_taches.comparator();
    }

    @Override
    public final SortedSet<Tache> subSet(Tache tache, Tache e1)
    {
        return liste_taches.subSet(tache, e1);
    }

    @Override
    public final SortedSet<Tache> headSet(Tache tache)
    {
        return liste_taches.headSet(tache);
    }

    @Override
    public final SortedSet<Tache> tailSet(Tache tache)
    {
        return liste_taches.tailSet(tache);
    }

    @Override
    public final Tache first()
    {
        return liste_taches.first();
    }

    @Override
    public final Tache last()
    {
        return liste_taches.last();
    }

    @Override
    public final int size()
    {
        return liste_taches.size();
    }

    @Override
    public final boolean isEmpty()
    {
        return liste_taches.isEmpty();
    }

    @Override
    public final boolean contains(Object o)
    {
        return liste_taches.contains(o);
    }

    @Override
    public final Iterator<Tache> iterator()
    {
        return liste_taches.iterator();
    }

    @Override
    public final Object [] toArray()
    {
        return liste_taches.toArray();
    }

    @Override
    public final <T> T[] toArray(T[] ts)
    {
        return liste_taches.toArray(ts);
    }

    @Override
    public final boolean add(Tache tache)
    {
        return liste_taches.add(tache);
    }

    @Override
    public final boolean remove(Object o)
    {
        return liste_taches.remove(o);
    }

    @Override
    public final boolean containsAll(Collection<?> collection)
    {
        return liste_taches.containsAll(collection);
    }

    @Override
    public final boolean addAll(Collection<? extends Tache> collection)
    {
        return liste_taches.addAll(collection);
    }

    @Override
    public final boolean retainAll(Collection<?> p_collection)
    {
        return liste_taches.retainAll(p_collection);
    }

    @Override
    public final boolean removeAll(Collection<?> p_collection)
    {
        return liste_taches.removeAll(p_collection);
    }

    @Override
    public final void clear()
    {
        liste_taches.clear();
    }

    @Override
    public String toString()
    {
    	StringBuilder string_builder = new StringBuilder();
    	
    	Iterator<Tache> iterator = liste_taches.iterator();
    	while(iterator.hasNext())
    		string_builder.append(iterator.next().toString() + System.getProperty("line.separator"));
    	
    	return string_builder.toString();
    }
}
