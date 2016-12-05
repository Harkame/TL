package model.tache;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TacheAuLongTest
{

	TachePonctuelle tacheVide;
	TachePonctuelle tacheAvecDate;
	TachePonctuelle tacheAvecNom;
	TachePonctuelle tacheAvecCategorie;
	TachePonctuelle tacheComplete;

	@Before
	public void CreationTaches()
	{
		tacheVide = new TachePonctuelle();
		tacheAvecDate = new TachePonctuelle(new DateTime().minus(1));
		tacheAvecNom = new TachePonctuelle("Coder");
		tacheComplete = new TachePonctuelle("Java", "TRAVAIL", new DateTime().minus(1));
	}

	@Test
	public void testEstEnRetard()
	{
		Assert.assertFalse(tacheVide.estEnRetard());
		Assert.assertTrue(tacheAvecDate.estEnRetard());
		Assert.assertTrue(tacheComplete.estEnRetard());
		Assert.assertFalse(tacheAvecNom.estEnRetard());
	}

}
