package view.popup;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public final class ErrorPopup extends JPanel
{
	public static String ERROR_MESSAGE_CATEGORIE_EXISTANTE    = "Cette categorie existe deja";
	public static String ERROR_MESSAGE_CATEGORIE_INEXISTANTE  = "Cette categorie n'existe pas";
	public static String ERROR_MESSAGE_CATEGORIE_NON_AUTORISE = "Cette categorie n'est pas modifiable";
	
	private String message;
	
	public ErrorPopup()
	{
		JOptionPane.showMessageDialog(this, "Could not open file", null, JOptionPane.ERROR_MESSAGE);
	}
	
	public ErrorPopup(String p_message)
	{
		message = p_message;
	}
	
	public void show()
	{
		JOptionPane.showMessageDialog(this, message, null, JOptionPane.ERROR_MESSAGE);
	}

	public static void main(String[] args)
	{
		ErrorPopup error_popup = new ErrorPopup(ERROR_MESSAGE_CATEGORIE_EXISTANTE);
		error_popup.show();
	}
}