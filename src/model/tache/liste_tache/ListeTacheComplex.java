package model.tache.liste_tache;

import java.util.Iterator;
import java.util.NavigableSet;

import org.joda.time.DateTime;

import model.tache.Tache;
import model.tache.TacheAuLong;
import model.tache.TachePonctuelle;
import model.tache.comparator.ComplexTacheComparator;

@SuppressWarnings("serial")
public class ListeTacheComplex extends ListeTache
{
	public ListeTacheComplex()
	{
		super(new ComplexTacheComparator());
	}
	
	public static void main(String [] Args)
	{
		DateTime date_time_1 = DateTime.now().plusDays(1);
		DateTime date_time_2 = DateTime.now().plusDays(5);
		DateTime date_time_3 = DateTime.now().plusDays(10);
		DateTime date_time_4 = DateTime.now().plusDays(15);
		DateTime date_time_5 = DateTime.now().plusDays(20);
		
		Tache tache_ponctuelle_1 = new TachePonctuelle("Passer diamand", date_time_1);
		Tache tache_au_long_1    = new TacheAuLong("REKTq des gens", date_time_2);
		Tache tache_au_long_2    = new TacheAuLong("Reviser lel", date_time_3);
		Tache tache_ponctuelle_2 = new TachePonctuelle("** ***** ***", date_time_4);
		Tache tache_au_long_3    = new TacheAuLong("Yolo", date_time_5);
		
		ListeTache liste_tache_simple = new ListeTacheComplex();
		
		liste_tache_simple.add(tache_ponctuelle_2);
		liste_tache_simple.add(tache_ponctuelle_1);
		liste_tache_simple.add(tache_au_long_3);
		liste_tache_simple.add(tache_au_long_1);
		liste_tache_simple.add(tache_ponctuelle_2);
		liste_tache_simple.add(tache_au_long_2);
		
		System.out.println(liste_tache_simple.toString());
		System.out.println("Taille : " + liste_tache_simple.size());
	}
}
