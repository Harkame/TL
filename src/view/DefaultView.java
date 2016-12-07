package view;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DefaultView extends JFrame
{
	private JButton button;
	private JPanel menu;
	private JPanel contenu;
	
	public DefaultView()
	{
	    setSize(800, 600);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    
	    menu = new MenuView();
	    add(menu, "East");
	    
	    contenu = new TachesView();
	    add(contenu, "West");
	    
	    setVisible(true);
	}
	
	public JButton getButton()
	{
		return button;
	}
	
	public void setContenu(JPanel p_fenetre)
	{
		getContentPane().remove(contenu);
		contenu = p_fenetre;
		add(contenu, "West");
	}
	
	public static void main(String[] args)
	{
		DefaultView hv = new DefaultView();
	}  
	
	
}