package model.bilan;

import org.joda.time.DateTime;

public class Periode
{
	private DateTime debut_periode;
	private DateTime fin_periode;
	
	public Periode()
	{
		
	}
	
	public Periode(DateTime p_debut_periode, DateTime p_fin_periode)
	{
		debut_periode = p_debut_periode;
		fin_periode   = p_fin_periode;
	}
}
