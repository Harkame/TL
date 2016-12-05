package model.tache;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import org.joda.time.DateTime;
import org.joda.time.Days;

import annotation.TLTest;
import annotation.TLTest.STATUS_TEST;
import model.tache.exception.TacheException;

@SuppressWarnings("serial")
public final class TacheAuLong extends Tache
{
	private long           duree;
	private DateTime       date_debut;
	private TreeMap<Integer, DateTime> etapes;
	
	public TacheAuLong()
	{
		super();
		
		date_debut = DateTime.now();
		etapes     = new TreeMap<Integer, DateTime>();
		
		duree      = getDateLimite().getMillis() - date_debut.getMillis();
		
		genererEtapes();
	}
	
	public TacheAuLong(String p_titre)
	{
		super(p_titre);
		
		date_debut = DateTime.now();
		etapes     = new TreeMap<Integer, DateTime>();
		
		duree      = getDateLimite().getMillis() - date_debut.getMillis();
		
		genererEtapes();
	}
	
	public TacheAuLong(DateTime p_date_limite)
	{
		super(p_date_limite);
		
		date_debut = DateTime.now();
		etapes     = new TreeMap<Integer, DateTime>();
		
		duree      = getDateLimite().getMillis() - date_debut.getMillis();
		
		genererEtapes();
	}
	
	public TacheAuLong(String p_titre, DateTime p_date_limite)
	{
		super(p_titre, p_date_limite);
		
		date_debut = DateTime.now();
		etapes     = new TreeMap<Integer, DateTime>();
		
		duree      = getDateLimite().getMillis() - date_debut.getMillis();
		
		genererEtapes();
	}
	
	
	public TacheAuLong(String p_titre, String p_categorie, DateTime p_date_limite) throws Exception
	{
		super(p_titre, p_categorie, p_date_limite);
		
		date_debut = DateTime.now();
		etapes     = new TreeMap<Integer, DateTime>();
		
		duree      = getDateLimite().getMillis() - date_debut.getMillis();
		
		genererEtapes();
	 }
	
	public TacheAuLong(DateTime p_date_debut, DateTime p_date_limite) throws TacheException
	{
		super(p_date_limite);
		
		if(p_date_debut.isAfter(getDateLimite()))
			throw new TacheException("Date debut > Date limite");
		
		date_debut = p_date_debut;
		etapes     = new TreeMap<Integer, DateTime>();
		
		duree      = getDateLimite().getMillis() - date_debut.getMillis();
		
		genererEtapes();
	}
	
	public TacheAuLong(String p_titre, String p_categorie, DateTime p_date_debut, DateTime p_date_limite) throws Exception
	{
		super(p_titre, p_categorie, p_date_limite);
		
		if(p_date_debut.isAfter(getDateLimite()))
			throw new TacheException("Date debut > Date limite");
		
		date_debut = p_date_debut;
		etapes     = new TreeMap<Integer, DateTime>();
		
		duree      = getDateLimite().getMillis() - date_debut.getMillis();
		
		genererEtapes();
	}
	
	/**
	 * 
	 */
	private void genererEtapes()
	{
		Days days = Days.daysBetween(date_debut, getDateLimite());
		
		etapes.put(0, date_debut);
		etapes.put(25, new DateTime(getDateLimite().minusDays((days.dividedBy(4).getDays()) * 3)));
		etapes.put(50, new DateTime(getDateLimite().minusDays(days.dividedBy(2).getDays())));
		etapes.put(75, new DateTime(getDateLimite().minusDays(days.dividedBy(4).getDays())));
		etapes.put(100, getDateLimite());
	}
		
	@TLTest(status = STATUS_TEST.TOTEST)
	public boolean estEnRetard()
	{
		return getDateLimite().isAfter(etapes.get(getAvencement()));
	}
	
	@Override
	public void incrementeAvencement()
	{
		if(getAvencement() == 100)
			return;
		else
			setAvencement((byte) (getAvencement() + 25));
	}
	
	@Override
	public DateTime nextDate()
	{
		if(getAvencement() < 100)
			return etapes.get(getAvencement() + 25);
		
		return null;
	}
	
	@Override
	public String toString()
	{
		StringBuilder resultat = new StringBuilder();
		
		resultat.append("Etapes : " + System.getProperty("line.separator"));
		
		for (Map.Entry<Integer, DateTime> e : etapes.entrySet())
		    resultat.append(e.getValue().toString() + System.getProperty("line.separator"));
		
		return super.toString() + resultat.toString();
	}
	
	public void test()
	{
		for (Map.Entry<Integer, DateTime> e : etapes.entrySet())
		    System.out.println(e.getKey() + " : " + e.getValue().toString());
	}
	
	public static void main(String [] Args)
	{
		DateTime date_time_1 = DateTime.now().plusDays(30);
		DateTime date_time_2 = DateTime.now().plusDays(10);
		
		TacheAuLong tache_au_long_1 = new TacheAuLong(date_time_1);
		//Tache tache_au_long_2 = new TacheAuLong(date_time_2);
		
		tache_au_long_1.test();
		
		System.out.println(tache_au_long_1.estEnRetard());
	}
}
