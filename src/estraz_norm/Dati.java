package estraz_norm;

/**
 * Insieme di informazioni su un'App o un gruppo di App, estratte dall'AppStore e normalizzate 
 */
public class Dati {
    
    private DatiElement installsOverview;
    private DatiElement installsByAppVersion;
    private DatiElement installsByCountry;
    
    private DatiElement ratingsOverview;
    private DatiElement ratingsByCountry;
    private DatiElement ratingsByOsVersion;
    
    public Dati() {
    	installsOverview = new DatiList("installs_overview");
    	installsByAppVersion = new DatiList("installs_appversion");
    	installsByCountry = new DatiList("installs_country");
        
        ratingsOverview = new DatiList("ratings_overview");
        ratingsByCountry = new DatiList("ratings_country");
        ratingsByOsVersion = new DatiList("ratings_country");
    }

    public DatiElement getRatingsOverview() {
		return ratingsOverview;
	}
    
    public DatiElement getInstallsByAppVersion() {
    	return installsByAppVersion;
    }
    
    public DatiElement getRatingsByCountry() {
    	return ratingsByCountry;
    }
    public DatiElement getInstallsOverview() {
		return installsOverview;
	}

	public DatiElement getInstallsByCountry() {
		return installsByCountry;
	}

	public DatiElement getRatingsByOsVersion() {
		return ratingsByOsVersion;
	}
	
}
