package csvservices;

public class ProcessCSVFiles {

	/**
	 * Launches the Thread that read and add csv files to the data store
	*/
	public void initialteThreadClass() {

		CSVHandlerThread csvhandler = new CSVHandlerThread();
		Thread t1 = new Thread(csvhandler);
		t1.start();
	} 
}