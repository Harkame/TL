package model.tache;

import org.joda.time.DateTime;

import annotation.TLTest;
import annotation.TLTest.STATUS_TEST;

@SuppressWarnings("serial")
public final class TachePonctuelle extends Tache
{

	public TachePonctuelle()
	{
		super();
	}
	
	public TachePonctuelle(String p_titre)
	{
		super(p_titre);
	}
	
	public TachePonctuelle(DateTime p_date_limite)
	{
		super(p_date_limite);
	}
	
	public TachePonctuelle(String p_titre, DateTime p_date_limite)
	{
		super(p_titre, p_date_limite);
	}
	
	public TachePonctuelle(String p_titre, String p_categorie, DateTime p_date_limite)
	{
		super(p_titre, p_categorie, p_date_limite);
	}
	
	@TLTest(status = STATUS_TEST.TESTED)
	public boolean estEnRetard()
	{
		return DateTime.now().isAfter(getDateLimite().plusDays(1));
	}
	
	@Override
	public DateTime nextDate()
	{
		return getDateLimite();
	}

	@Override
	public void incrementeAvencement()
	{
		setAvencement((byte)100);
	}
}
