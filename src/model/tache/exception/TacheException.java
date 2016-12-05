package model.tache.exception;

@SuppressWarnings("serial")
public class TacheException extends Exception
{
	public TacheException(String p_message)
	{
		System.err.println(p_message);
	}
}
