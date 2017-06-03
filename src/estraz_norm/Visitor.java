package estraz_norm;

/**
 * Interfaccia da implementare per Visitor in grado
 * 		di visitare oggetti di tipo ElementAppStore
 */
public interface Visitor { 
	/**
	 * Visita di un GoogleStore
	 *
	 * @param apple AppStore specifico
	 */
	public Object visit(AppleStore apple);

	
	/**
     * Visita di un GoogleStore
     *
     * @param google AppStore specifico
     */
    public Object visit(GoogleStore google);
     
    
    /**
     * Visita di un GoogleStore
     *
     * @param win AppStore specifico
     */
    public Object visit(WinStore win);
}