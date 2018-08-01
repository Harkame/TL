package model.tache.categorie;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map.Entry;

import model.tache.Tache;
import model.tache.liste_tache.ListeTache;
import model.tache.liste_tache.ListeTacheSimple;

public abstract class Categories
{
	private static final String	TITRE_CATEGORIE_SANS_CATEGORIE	= "SANS_CATEGORIE";
	private static final String	TITRE_CATEGORIE_TRAVAIL			= "TRAVAIL";
	private static final String	TITRE_CATEGORIE_PERSONNEL		= "PERSONNEL";

	private static final String CHEMIN_SERIALIZATION = "/home/harkame/test/toto.data"; // Repertoire
																		// courant

	public static TreeMapCategorie categories;

	static
	{
		categories = new TreeMapCategorie();
		categories.put(TITRE_CATEGORIE_SANS_CATEGORIE, new ListeTacheSimple());
		categories.put(TITRE_CATEGORIE_TRAVAIL, new ListeTacheSimple());
		categories.put(TITRE_CATEGORIE_PERSONNEL, new ListeTacheSimple());
	}

	public Categories()
	{
		categories = new TreeMapCategorie();
	}

	public static void ajouterCategorie(String p_nouvelle_categorie) throws Exception
	{
		if(!autoriser(p_nouvelle_categorie))
			throw new Exception();

		if(categories.containsKey(p_nouvelle_categorie))
			throw new Exception();

		categories.put(p_nouvelle_categorie, new ListeTacheSimple());
	}

	public static void supprimerCategorie(String p_categorie) throws Exception
	{
		if(!autoriser(p_categorie))
			throw new Exception();

		if(!categories.containsKey(p_categorie))
			throw new Exception();

		System.out.println(p_categorie);

		ListeTache t_liste_tache_simple = categories.get(p_categorie);
		if(t_liste_tache_simple == null)
			return;
		categories.remove(p_categorie);

		categories.get(TITRE_CATEGORIE_SANS_CATEGORIE).addAll(t_liste_tache_simple);
	}

	public static void renommerCategorie(String p_ancienne_categorie, String p_nouvelle_categorie) throws Exception
	{
		if(!autoriser(p_ancienne_categorie) || !autoriser(p_nouvelle_categorie))
			throw new Exception();

		if(!categories.containsKey(p_ancienne_categorie))
			throw new Exception();

		if(categories.containsKey(p_nouvelle_categorie))
			throw new Exception();

		ListeTache t_liste_tache_simple = new ListeTacheSimple();

		t_liste_tache_simple.addAll(categories.get(p_ancienne_categorie));

		categories.put(p_nouvelle_categorie, t_liste_tache_simple);

		categories.remove(p_ancienne_categorie);
	}

	public static CharSequence getCategorie(Tache p_tache)
	{
		for(Entry<String, ListeTache> e : categories.entrySet())
			if(e.getValue().contains(p_tache))
				return e.getKey();

		return null;
	}

	public static boolean autoriser(String p_categorie)
	{
		return(!p_categorie.equals(TITRE_CATEGORIE_SANS_CATEGORIE) && !p_categorie.equals(TITRE_CATEGORIE_TRAVAIL)
			&& !p_categorie.equals(TITRE_CATEGORIE_PERSONNEL));
	}

	public static void ajouterTaches(String p_categorie, ListeTache p_liste_tache)
	{
		categories.put(p_categorie, p_liste_tache);
	}

	public static void ajouterTache(String p_categorie, Tache p_tache)
	{
		categories.get(p_categorie).add(p_tache);
	}

	public static Collection<String> getCategories()
	{
		Collection<String> resultat = new ArrayList<String>();

		for(Entry<String, ListeTache> e : categories.entrySet())
			resultat.add(e.getKey());

		return resultat;
	}

	public static void serialize()
	{
		FileOutputStream fichier_sortie = null;
		ObjectOutputStream objet_sortie = null;

		try
		{
			fichier_sortie = new FileOutputStream(CHEMIN_SERIALIZATION);
			objet_sortie = new ObjectOutputStream(fichier_sortie);

			objet_sortie.writeObject(categories);
		}
		catch(IOException io_exception)
		{
			io_exception.printStackTrace();
		}
		finally
		{
			try
			{
				fichier_sortie.close();
				objet_sortie.close();
			}
			catch(IOException io_exception)
			{
				io_exception.printStackTrace();
			}
		}
	}

	public static void unserialize()
	{
		FileInputStream fichier_entre = null;
		ObjectInputStream objet_entre = null;

		try
		{
			fichier_entre = new FileInputStream(CHEMIN_SERIALIZATION);
			objet_entre = new ObjectInputStream(fichier_entre);

			TreeMapCategorie t = (TreeMapCategorie) objet_entre.readObject();

			System.out.println(t.toString());
		}
		catch(IOException io_exception)
		{
			io_exception.printStackTrace();
		}
		catch(ClassNotFoundException class_not_found_exception)
		{
			class_not_found_exception.printStackTrace();
		}
		finally
		{
			try
			{
				fichier_entre.close();
				objet_entre.close();
			}
			catch(IOException io_exception)
			{
				io_exception.printStackTrace();
			}
		}
	}

	public static void main(String[] Args) throws Exception
	{
		/*
		 * DateTime date1 = new DateTime().plusDays(1); DateTime date2 = new
		 * DateTime().plusDays(2); DateTime date3 = new
		 * DateTime().plusDays(3); DateTime date4 = new
		 * DateTime().plusDays(4);
		 * 
		 * Tache c1 = new TachePonctuelle(date1); Tache c2 = new
		 * TachePonctuelle(date2); Tache c3 = new TachePonctuelle(date3);
		 * Tache c4 = new TachePonctuelle(date4);
		 * 
		 * ListeTache lt1 = new ListeTacheSimple(); ListeTache lt2 = new
		 * ListeTacheSimple();
		 * 
		 * lt1.add(c1); lt1.add(c2); lt1.add(c3);
		 * 
		 * lt2.add(c4);
		 * 
		 * categories.put("Important", lt1); categories.put("Osef", lt2);
		 * 
		 * System.out.println(getCategorie(c1));
		 * System.out.println(getCategorie(c2));
		 * System.out.println(getCategorie(c3));
		 * System.out.println(getCategorie(c4));
		 * 
		 * supprimerCategorie("Important");
		 * 
		 * System.out.println("-----------------------------");
		 * 
		 * System.out.println(getCategorie(c1));
		 * 
		 * renommerCategorie("Osef", "Yolo");
		 * System.out.println(getCategorie(c4));
		 * 
		 * System.out.println("-----------------------------");
		 * 
		 * System.out.println(categories.toString());
		 * 
		 * categories.put("Test", new ListeTacheSimple());
		 * 
		 * System.out.println("-----------------------------");
		 * 
		 * System.out.println(categories.toString());
		 * 
		 * serialize();
		 */

		System.out.println("-----------------------------");

		System.out.println(categories.toString());

		unserialize();

		System.out.println(categories.toString());
	}
}
