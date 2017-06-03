package estraz_norm;

/**
 * Visitor per estrarre da ognuno degli App Store supportati 
 * 		i dati riguardanti un'App 
 */
public class EstrazioneDati implements Visitor {
    /** Attributi */
    private App app;
    
    
    public EstrazioneDati(App app) {
		this.app = app;
	}
    
    
    /**
     * Visita di un GoogleStore
     *
     * @param google AppStore specifico
     */
    @Override
    public Object visit(GoogleStore google) {
    	return google.estrazioneDati(app);
    }
    
    
    /**
     * Visita di un AppleStore
     *
     * @param apple AppStore specifico
     */
    @Override
    public Object visit(AppleStore apple) {
         return apple.estrazioneDati(app);
    }
    
    
    /**
     * Visita di un  WinStore
     *
     * @param win AppStore specifico
     */
    @Override
    public Object visit(WinStore win) {
    	return win.estrazioneDati(app);
    }
    
}