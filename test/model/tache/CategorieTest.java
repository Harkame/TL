package model.tache;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import model.tache.categorie.Categories;

@RunWith(Parameterized.class)
public class CategorieTest
{
	private String		categorie1;
	private String		categorie2;
	private String		expected1;
	private String		expected2;
	private Categories	categories;

	public CategorieTest(String p_categorie1, String p_categorie2, String p_expected1, String p_expected2)
	{
		categorie1 = p_categorie1;
		categorie2 = p_categorie2;
		expected1 = p_expected1;
		expected2 = p_expected2;
	}

	@Parameters
	public static Collection<Object[]> setParameters()
	{
		Collection<Object[]> params = new ArrayList<>();
		params.add(new Object[] {"LECTURE", "REVISIONS", "LECTURE", "REVISIONS"});
		params.add(new Object[] {"LECTURE", "revisions", "LECtURE", "REVISIONS"});
		params.add(new Object[] {"lecture", "REVISIONS", "LECTURE", "REVISIONS"});
		params.add(new Object[] {"lecture", "revisions", "LECTURE", "REVISIONS"});

		return params;
	}

	@After
	public void removeCategorie() throws Exception
	{
		Categories.supprimerCategorie(expected1);
		Categories.supprimerCategorie(expected2);
	}

	@Test
	public void testAjouterNouvelleCategorie() throws Exception
	{
		Categories.ajouterCategorie(categorie1);
		// Assert.assertTrue(Categories.containsCategoriesDisponibles(expected1));
		// Assert.assertFalse(Categories.containsCategoriesDisponibles(expected2));
	}

	@Test
	public void testSupprimerExistant() throws Exception
	{
		Categories.ajouterCategorie(categorie1);
		Categories.supprimerCategorie(expected1);
		// Assert.assertFalse(Categories.containsCategoriesDisponibles(expected1));
	}

	@Test
	public void testSupprimerNonExistant() throws Exception
	{
		Categories.ajouterCategorie(categorie1);
		Categories.supprimerCategorie(expected1);
		// Assert.assertFalse(Categorie.removeCategorieDisponible(expected1));
		// Assert.assertFalse(Categorie.containsCategoriesDisponibles(expected1));
	}

	@Test
	public void testModifierExistant() throws Exception
	{
		Categories.ajouterCategorie(categorie1);
		Categories.renommerCategorie(categorie1, categorie2);
		// Assert.assertTrue(Categories.containsCategoriesDisponibles(expected2));
		// Assert.assertFalse(Categories.containsCategoriesDisponibles(expected1));
	}

	@Test
	public void testModifierNonExistant() throws Exception
	{
		Categories.ajouterCategorie(categorie1);
		Categories.supprimerCategorie(expected1);
		Categories.renommerCategorie(categorie1, categorie2);
		// Assert.assertFalse(Categories.containsCategoriesDisponibles(expected1));
		// Assert.assertFalse(Categories.containsCategoriesDisponibles(expected2));
	}
}
