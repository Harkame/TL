package model.bilan;

import java.util.Iterator;

import org.joda.time.DateTime;

import model.tache.Tache;
import model.tache.Tache.STATUS_TACHE;
import model.tache.liste_tache.ListeTache;
import model.tache.liste_tache.ListeTacheSimple;

public final class Bilan
{
	private byte pourcentage_realise_periode;
	private byte pourcentage_realise_periode_retard;
	private byte pourcentage_non_realise_periode;
	
	private DateTime   debut_periode;
	private DateTime   fin_periode;
	
	private ListeTache liste_taches_periode;
	
	public void Bilan(DateTime p_debut_periode, DateTime p_fin_periode)
	{
		debut_periode       = debut_periode;
		fin_periode         = p_fin_periode;
		liste_taches_periode = new ListeTacheSimple();
	}
	
	public void generer(ListeTache p_liste_taches)
	{
		genererListeTachePeriode(p_liste_taches);
		pourcentage_realise_periode = (byte) ((p_liste_taches.size() * liste_taches_periode.size()) / 100);
	}
	
	private void genererListeTachePeriode(ListeTache p_liste_taches)
	{
		Tache t_tache;
		Iterator<Tache> iterator = p_liste_taches.iterator();
		while(iterator.hasNext())
		{
			t_tache = iterator.next();
			if(t_tache.getDateLimite().isAfter(debut_periode) &&
					t_tache.getDateLimite().isBefore(fin_periode))
				liste_taches_periode.add(t_tache);
		}
	}
	
	private void calculePourcentages()
	{
		int compteur_tache_realise_retard     = 0;
		int compteur_tache_non_realise_retard = 0;
		Tache t_tache;
		Iterator<Tache> iterator = liste_taches_periode.iterator();
		while(iterator.hasNext())
		{
			t_tache = iterator.next();
			
			if(t_tache.getStatus() == STATUS_TACHE.REALISE_RETARD)
				compteur_tache_realise_retard++;
			else if(t_tache.getStatus() == STATUS_TACHE.NON_REALISE_RETARD)
				compteur_tache_non_realise_retard++;
		}
		
		pourcentage_realise_periode_retard = (byte) ((liste_taches_periode.size() * compteur_tache_realise_retard)     / 100);
		pourcentage_non_realise_periode    = (byte) ((liste_taches_periode.size() * compteur_tache_non_realise_retard) / 100);
	}
}
