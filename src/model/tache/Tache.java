package model.tache;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.joda.time.DateTime;

import annotation.TLTest;
import annotation.TLTest.STATUS_TEST;

@SuppressWarnings("serial")
public abstract class Tache implements Serializable
{
	private final static String SANS_TITRE = "SANS_TITRE";

	public enum STATUS_TACHE {REALISE, REALISE_RETARD, NON_REALISE, NON_REALISE_RETARD};
	
	private String    titre;
	private byte      avencement;
	private DateTime  date_limite;
	private STATUS_TACHE status;
	
	@TLTest(status = STATUS_TEST.TESTED)
	public Tache()
	{
		titre       = SANS_TITRE;
		avencement  = 0;
		date_limite = DateTime.now().plusDays(1);
		status      = STATUS_TACHE.NON_REALISE;
	}
	
	@TLTest(status = STATUS_TEST.TESTED)
	public Tache(String p_titre)
	{
		titre       = p_titre;
		avencement  = 0;
		date_limite = DateTime.now().plusDays(1);
		status      = STATUS_TACHE.NON_REALISE;
	}
	
	@TLTest(status = STATUS_TEST.TESTED)
	public Tache(DateTime p_date_limite)
	{
		titre       = SANS_TITRE;
		avencement  = 0;
		date_limite = p_date_limite;
		status      = STATUS_TACHE.NON_REALISE;
	}
	
	@TLTest(status = STATUS_TEST.TESTED)
	public Tache(String p_titre, DateTime p_date_limite)
	{
		titre       = p_titre;
		avencement  = 0;
		date_limite = p_date_limite;
		status      = STATUS_TACHE.NON_REALISE;
	}
	
	@TLTest(status = STATUS_TEST.TESTED)
	public Tache(String p_titre, String p_categorie, DateTime p_date_limite)
	{
		titre       = p_titre;
		avencement  = 0;
		date_limite = p_date_limite;
		status      = STATUS_TACHE.NON_REALISE;
	}
	
	@TLTest(status = STATUS_TEST.NOTEST)
	public final void setTitre(String p_nouveau_titre)
	{
		titre = p_nouveau_titre;
	}
		
	@TLTest(status = STATUS_TEST.NOTEST)
	public final String getTitre()
	{
		return titre;
	}
	
	@TLTest(status = STATUS_TEST.NOTEST)
	public final int getAvencement()
	{
		return avencement;
	}
	
	protected final void setAvencement(byte p_avencement)
	{
		avencement = p_avencement;
		
		if(avencement == 100)
			if(estEnRetard())
				status = STATUS_TACHE.REALISE_RETARD;
			else
				status = STATUS_TACHE.REALISE;
		else
			if(estEnRetard())
				status = STATUS_TACHE.NON_REALISE_RETARD;
			else
				status = STATUS_TACHE.NON_REALISE;
	}
	
	public abstract void incrementeAvencement();
	
	@TLTest(status = STATUS_TEST.NOTEST)
	public final DateTime getDateLimite()
	{
		return date_limite;
	}
	
	@TLTest(status = STATUS_TEST.NOTEST)
	public boolean valide()
	{
		return true;
	}
	
	@Override
	@TLTest(status = STATUS_TEST.NOTEST)
	public boolean equals(Object o)
	{
		return false;
	}
	
	@Override
	@TLTest(status = STATUS_TEST.NOTEST)
	public String toString()
	{
		StringBuilder string_builder = new StringBuilder();
		string_builder.append("Titre       : " + titre                  + System.getProperty("line.separator"));
		string_builder.append("Avencement  : " + avencement             + System.getProperty("line.separator"));
		string_builder.append("Date limite : " + date_limite.toString() + System.getProperty("line.separator"));
		return string_builder.toString();
	}
	
	@TLTest(status = STATUS_TEST.TOTEST)
	public abstract boolean estEnRetard();
	
	public static void main(String [] Args)
	{
		try
		{
			Tache tache = new TacheAuLong(DateTime.now());
			tache.avencement = 42;
			FileOutputStream fileOut = new FileOutputStream("/home/harkame/tache.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(tache);
			out.close();
			fileOut.close();
			
			
			FileInputStream fileIn = new FileInputStream("/home/harkame/tache.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Tache tache2 = (Tache) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Tache2 : " + tache2.avencement);
		}
		catch(Exception exception)
		{
			
		}
	}
	
	public STATUS_TACHE getStatus()
	{
		return status;
	}
	
	public abstract DateTime nextDate();
}
