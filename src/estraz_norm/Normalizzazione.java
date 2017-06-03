package estraz_norm;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;

public class Normalizzazione implements Visitor {

	private App app;
	private ArrayList<File> files;
    
    public Normalizzazione(App app, ArrayList<File> files) {
		this.app = app;
		this.files = files;
	}

    @Override
    public Object visit(AppleStore apple) {
    	return null;
    }
	
	@Override
	public Object visit(GoogleStore google) {
		Scanner fileScan = null;
		Scanner lineScan = null;
		Dati dati = app.getDati();
		dati = new Dati();
		
		//################# INSTALLS - OVERVIEW
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(files.get(0)), "UTF-16");
			fileScan = new Scanner(isr);
						
			ArrayList<String> listTitoli = getTitoli(fileScan);
			
			//Installazioni per versione app
			DatiElement installsOverview = dati.getInstallsOverview();			
			while(fileScan.hasNextLine()) {	//Fino alla fine del file
				//Leggo riga dal file
				lineScan = new Scanner(fileScan.nextLine());
				lineScan.useDelimiter(",");
				
				int i = 0;
				String data = null;
				String readValue = null;
				while(lineScan.hasNext()) {		//Per ogni valore della riga
					readValue = lineScan.next();
					
					switch(listTitoli.get(i)) {
					case "Date":
						data = readValue;
						installsOverview.add(data);
						break;
					case "Total User Installs":
						installsOverview.get(data).addInt(listTitoli.get(i), Integer.parseInt(readValue));
						break;
					case "Daily User Installs":
						installsOverview.get(data).addInt(listTitoli.get(i), Integer.parseInt(readValue));
						break;
					case "Daily User Uninstalls":
						installsOverview.get(data).addInt(listTitoli.get(i), Integer.parseInt(readValue));
						break;
					case "Active Device Installs":
						installsOverview.get(data).addInt(listTitoli.get(i), Integer.parseInt(readValue));
						break;
					}
					
					i++;
				}
			}
			
			installsOverview.printRecursive();
			
			//Riempimento Dati
			//dati.setNumeroDownloadTotali(listDownload);
			
			lineScan.close();
			fileScan.close();
			
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		//########## INSTALL - per VERSIONE APP
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(files.get(1)), "UTF-16");
			fileScan = new Scanner(isr);
						
			ArrayList<String> listTitoli = getTitoli(fileScan);
			
			//Installazioni per versione app
			DatiElement installsByAppVersion = dati.getInstallsByAppVersion();			
			while(fileScan.hasNextLine()) {	//Fino alla fine del file
				//Leggo riga dal file
				lineScan = new Scanner(fileScan.nextLine());
				lineScan.useDelimiter(",");
				
				int i = 0;
				String data = null;
				String appVersion = null;
				String readValue = null;
				while(lineScan.hasNext()) {		//Per ogni valore della riga
					readValue = lineScan.next();
					
					switch(listTitoli.get(i)) {
					case "Date":
						data = readValue;
						installsByAppVersion.add(data);
						break;
					case "App Version Code":
						appVersion = readValue;
						installsByAppVersion.get(data).add(appVersion);
						break;
					case "Total User Installs":
						installsByAppVersion.get(data).get(appVersion).addInt(listTitoli.get(i), Integer.parseInt(readValue));
						break;
					case "Daily User Installs":
						installsByAppVersion.get(data).get(appVersion).addInt(listTitoli.get(i), Integer.parseInt(readValue));
						break;
					case "Daily User Uninstalls":
						installsByAppVersion.get(data).get(appVersion).addInt(listTitoli.get(i), Integer.parseInt(readValue));
						break;
					case "Active Device Installs":
						installsByAppVersion.get(data).get(appVersion).addInt(listTitoli.get(i), Integer.parseInt(readValue));
						break;
					}
					
					i++;
				}
			}
			
			installsByAppVersion.printRecursive();
			
			//Riempimento Dati
//			dati.setNumeroDownloadTotali(listDownload);
			
			lineScan.close();
			fileScan.close();
			
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		
		//########## INSTALL - per PAESE
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(files.get(2)), "UTF-16");
			fileScan = new Scanner(isr);
						
			ArrayList<String> listTitoli = getTitoli(fileScan);
			
			//Installazioni per versione app
			DatiElement installsByCountry = dati.getInstallsByCountry();			
			while(fileScan.hasNextLine()) {	//Fino alla fine del file
				//Leggo riga dal file
				lineScan = new Scanner(fileScan.nextLine());
				lineScan.useDelimiter(",");
				
				int i = 0;
				String data = null;
				String country = null;
				String readValue = null;
				while(lineScan.hasNext()) {		//Per ogni valore della riga
					readValue = lineScan.next();
					
					switch(listTitoli.get(i)) {
					case "Date":
						data = readValue;
						installsByCountry.add(data);
						break;
					case "Country":
						country = readValue;
						installsByCountry.get(data).add(country);
						break;
					case "Total User Installs":
						installsByCountry.get(data).get(country).addInt(listTitoli.get(i), Integer.parseInt(readValue));
						break;
					case "Daily User Installs":
						installsByCountry.get(data).get(country).addInt(listTitoli.get(i), Integer.parseInt(readValue));
						break;
					case "Daily User Uninstalls":
						installsByCountry.get(data).get(country).addInt(listTitoli.get(i), Integer.parseInt(readValue));
						break;
					case "Active Device Installs":
						installsByCountry.get(data).get(country).addInt(listTitoli.get(i), Integer.parseInt(readValue));
						break;
					}
					
					i++;
				}
			}
			
			installsByCountry.printRecursive();
			
			//Riempimento Dati
//			dati.setNumeroDownloadTotali(listDownload);
			
			lineScan.close();
			fileScan.close();
			
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		//########## RATINGS - OVERVIEW
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(files.get(3)), "UTF-16");
			fileScan = new Scanner(isr);
						
			ArrayList<String> listTitoli = getTitoli(fileScan);
			
			//Installazioni per versione app
			DatiElement ratingsOverview = dati.getRatingsOverview();			
			while(fileScan.hasNextLine()) {	//Fino alla fine del file
				//Leggo riga dal file
				lineScan = new Scanner(fileScan.nextLine());
				lineScan.useDelimiter(",");
				
				int i = 0;
				String data = null;
				String packageName = null;
				String readValue = null;
				while(lineScan.hasNext()) {		//Per ogni valore della riga
					readValue = lineScan.next();
					
					switch(listTitoli.get(i)) {
					case "Date":
						data = readValue;
						ratingsOverview.add(data);
						break;
					case "Package Name":
						packageName = readValue;
						ratingsOverview.get(data).add(packageName);
						break;
					case "Daily Average Rating":
						if(!readValue.equals("NA")) {
							ratingsOverview.get(data)
										   .get(packageName)
										   .addDouble(listTitoli.get(i), Double.parseDouble(readValue));
						} else {
							ratingsOverview.get(data)
							   .get(packageName)
							   .addDouble(listTitoli.get(i), -1.0);
						}
						break;
					case "Total Average Rating":
						ratingsOverview.get(data).get(packageName).addDouble(listTitoli.get(i), Double.parseDouble(readValue));
						break;
					}
					
					i++;
				}
			}
			
			ratingsOverview.printRecursive();
			
			//Riempimento Dati
//			dati.setNumeroDownloadTotali(listDownload);
			
			lineScan.close();
			fileScan.close();
			
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		
		//########## RATINGS - PAESE
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(files.get(4)), "UTF-16");
			fileScan = new Scanner(isr);
						
			ArrayList<String> listTitoli = getTitoli(fileScan);
			
			//Installazioni per versione app
			DatiElement ratingsByCountry = dati.getRatingsByCountry();			
			while(fileScan.hasNextLine()) {	//Fino alla fine del file
				//Leggo riga dal file
				lineScan = new Scanner(fileScan.nextLine());
				lineScan.useDelimiter(",");
				
				int i = 0;
				String data = null;
				String country = null;
				String readValue = null;
				while(lineScan.hasNext()) {		//Per ogni valore della riga
					readValue = lineScan.next();
					
					switch(listTitoli.get(i)) {
					case "Date":
						data = readValue;
						ratingsByCountry.add(data);
						break;
					case "Country":
						country = readValue;
						ratingsByCountry.get(data).add(country);
						break;
					case "Daily Average Rating":
						if(!readValue.equals("NA")) {
							ratingsByCountry.get(data)
										   .get(country)
										   .addDouble(listTitoli.get(i), Double.parseDouble(readValue));
						} else {
							ratingsByCountry.get(data)
							   .get(country)
							   .addDouble(listTitoli.get(i), -1.0);
						}
						break;
					case "Total Average Rating":
						ratingsByCountry.get(data).get(country).addDouble(listTitoli.get(i), Double.parseDouble(readValue));
						break;
					}
					
					i++;
				}
			}
			
			ratingsByCountry.printRecursive();
			
			//Riempimento Dati
//			dati.setNumeroDownloadTotali(listDownload);
			
			lineScan.close();
			fileScan.close();
			
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
				
		
		//########## RATINGS - VERSIONE OS
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(files.get(5)), "UTF-16");
			fileScan = new Scanner(isr);
						
			ArrayList<String> listTitoli = getTitoli(fileScan);
			
			//Installazioni per versione app
			DatiElement ratingsByOsVersion = dati.getRatingsByOsVersion();			
			while(fileScan.hasNextLine()) {	//Fino alla fine del file
				//Leggo riga dal file
				lineScan = new Scanner(fileScan.nextLine());
				lineScan.useDelimiter(",");
				
				int i = 0;
				String data = null;
				String osVersion = null;
				String readValue = null;
				while(lineScan.hasNext()) {		//Per ogni valore della riga
					readValue = lineScan.next();
					
					switch(listTitoli.get(i)) {
					case "Date":
						data = readValue;
						ratingsByOsVersion.add(data);
						break;
					case "Android OS Version":
						osVersion = readValue;
						ratingsByOsVersion.get(data).add(osVersion);
						break;
					case "Daily Average Rating":
						if(!readValue.equals("NA")) {
							ratingsByOsVersion.get(data)
										   .get(osVersion)
										   .addDouble(listTitoli.get(i), Double.parseDouble(readValue));
						} else {
							ratingsByOsVersion.get(data)
							   .get(osVersion)
							   .addDouble(listTitoli.get(i), -1.0);
						}
						break;
					case "Total Average Rating":
						ratingsByOsVersion.get(data).get(osVersion).addDouble(listTitoli.get(i), Double.parseDouble(readValue));
						break;
					}
					
					i++;
				}
			}
			
			ratingsByOsVersion.printRecursive();
			
			//Riempimento Dati
//			dati.setNumeroDownloadTotali(listDownload);
			
			lineScan.close();
			fileScan.close();
			
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		return dati;
	}


	@Override
	public Object visit(WinStore win) {
		return null;
	}
	
	/**
	 * Legge la prima riga di un CSV a cui è stato applicato fileScan
	 * 		e inserisce i nomi delle colonne nell'ArrayList restituito
	 * @param fileScan scanner applicato al file CSV
	 * @return ArrayList con nomi delle colonne del CSV 
	 */
	public ArrayList<String> getTitoli(Scanner fileScan) {
		//Titoli
		//HashMap<String, String> listDownload = new HashMap<>();
		ArrayList<String> listTitoli = new ArrayList<>();
		String titoli = fileScan.nextLine();
	
		Scanner lineScan = new Scanner(titoli);
		lineScan.useDelimiter(",");
		while(lineScan.hasNext()) {	//Per ogni nome di colonna
			listTitoli.add(lineScan.next());
		}
		lineScan.close();
		return listTitoli;
	}

}
