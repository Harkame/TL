package model.tache;

import org.joda.time.DateTime;
import org.junit.*;
import org.junit.Test;

public class TachePonctuelleTest
{

	Tache tache_vide;
	Tache tache_avec_date;
	Tache tache_avec_nom;
	Tache tache_complete;

	@Before
	public void CreationTaches()
	{
		tache_vide      = new TachePonctuelle();
		tache_avec_date = new TachePonctuelle(new DateTime().minusDays(1));
		tache_avec_nom  = new TachePonctuelle("Coder");
		tache_complete  = new TachePonctuelle("Java", "TRAVAIL", new DateTime().minusDays(1));
	}

	@Test
	public void testEstEnRetard()
	{
		Assert.assertFalse(tache_vide.estEnRetard());
		Assert.assertTrue(tache_avec_date.estEnRetard());
		Assert.assertTrue(tache_complete.estEnRetard());
		Assert.assertFalse(tache_avec_nom.estEnRetard());
	}
}
