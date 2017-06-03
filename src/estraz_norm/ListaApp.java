package estraz_norm;
/**
 * Visita un ElementAppStore e recupera la lista delle App 
 * 		presenti in quello Store
 */
public class ListaApp implements Visitor { 
	/**
     * Visita di un GoogleStore
     *
     * @param google AppStore specifico
     */
	@Override
    public Object visit(GoogleStore google) {
		return null;
    }
    
    
    /**
     * Visita di un AppleStore
     *
     * @param apple AppStore specifico
     */
	@Override
    public Object visit(AppleStore apple) {
		return null;
    }
    
    
    /**
     * Visita di un WinStore
     *
     * @param win AppStore specifico
     */
	@Override
    public Object visit(WinStore win) {
		return null;
    }

}