package view.popup;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;

import org.joda.time.DateTime;

import model.tache.Tache;
import model.tache.TacheAuLong;
import model.tache.TachePonctuelle;
import model.tache.liste_tache.ListeTache;
import model.tache.liste_tache.ListeTacheComplex;
import model.tache.liste_tache.ListeTacheSimple;

public class CategorieView extends JFrame
{
	private JButton button_tache_simple;
	private JButton button_tache_complex;
	
	private JList<String> jlist_categories;
	
	
	public CategorieView()
	{
		setSize(new Dimension(700, 600));
		setBackground(Color.red);
	
		button_tache_simple = new JButton("Tache simple");
		button_tache_complex = new JButton("Tache complex");
		
		add(button_tache_simple);
		add(button_tache_complex);
		
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
		
		ListeTache liste_tache_simple = new ListeTacheSimple();
		
		liste_tache_simple.add(tache_ponctuelle_2);
		liste_tache_simple.add(tache_ponctuelle_1);
		liste_tache_simple.add(tache_au_long_3);
		liste_tache_simple.add(tache_au_long_1);
		liste_tache_simple.add(tache_ponctuelle_2);
		liste_tache_simple.add(tache_au_long_2);
		
		ListeTache liste_tache_complex = new ListeTacheComplex();
		liste_tache_complex.addAll(liste_tache_simple);
	
		
		jlist_taches = new JList(liste_tache_simple.toArray());

		jlist_taches.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent evt) {
		    	int index = 0;
		        JList list = (JList)evt.getSource();
		        if (evt.getClickCount() == 2) {

		            // Double-click detected
		            index = list.locationToIndex(evt.getPoint());
		        } else if (evt.getClickCount() == 3) {

		            // Triple-click detected
		            index = list.locationToIndex(evt.getPoint());
		        }
		        System.out.println(index);
		    }
		});
		add(jlist_taches);
	}
}
