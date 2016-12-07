package view;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuView extends JPanel
{
	private JButton bouton_bilan;
	private JButton bouton_categorie;
	private JButton bouton_taches;
	
	private MenuController menu_controller;
	
	public MenuView()
	{
		setPreferredSize(new Dimension(100, 600));
		setLayout(null);

		bouton_bilan       = new JButton("Bilan");
		bouton_categorie      = new JButton("Categories");
		bouton_taches     = new JButton("Taches");
		
		add(bouton_bilan);
		add(bouton_categorie);
		add(bouton_taches);
		
		bouton_bilan.setPreferredSize(new Dimension(80, 50));
		bouton_categorie.setPreferredSize(new Dimension(80, 50));
		bouton_taches.setPreferredSize(new Dimension(80, 50));
		
		Insets insets = getInsets();
	    Dimension size;
	    size = bouton_bilan.getPreferredSize();
	    bouton_bilan.setBounds(10 + insets.left, 250 + insets.top,
	             size.width, size.height);
	    
	    size = bouton_categorie.getPreferredSize();
	    bouton_categorie.setBounds(10 + insets.left, 75 + insets.top,
	             size.width, size.height);
	    
	    size = bouton_taches.getPreferredSize();
	    bouton_taches.setBounds(10 + insets.left, 425 + insets.top,
	             size.width, size.height);
	    
	    menu_controller = new MenuController();
	    menu_controller.controle();
	}
	
	public JButton getBoutonTaches()
	{
		return bouton_taches;
	}
	
	public JButton getBoutonMenu()
	{
		return bouton_taches;
	}
	
	public JButton getBoutonBilan()
	{
		return bouton_bilan;
	}
	
	public class MenuController
	{
		public void controle()
		{
			bouton_taches.addActionListener(new ActionListener()
			{
				  public void actionPerformed(ActionEvent e)
				  {
					  DefaultView v = (DefaultView) getParent();
					  v.setContenu(new TachesView());
				  }
			});
		}
	}

	
	public static void main(String [] Args)
	{
	
	}
}
