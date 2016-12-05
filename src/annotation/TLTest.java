package annotation;

public @interface TLTest
{
	public enum STATUS_TEST {NOTEST, TOTEST, TESTED};

	public abstract STATUS_TEST status(); 
}
