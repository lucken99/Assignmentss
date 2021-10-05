package csvservices;

import com.opencsv.bean.CsvToBeanBuilder;
import datastructures.TShirtData;
import entities.TShirt;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.*;
import java.util.stream.Collectors;

public class CSVHandlerThread implements Runnable {
	private static final String dirPath = "src\\main\\resources\\csv_files";
	private static final char csvSeparator = '|';
	private Map<String, FileTime> csvListWithTime;
	private List<String> updatedFiles;

	@Override
	public void run() {
		csvListWithTime = new HashMap<>();
		while ( true ) {
			try {
				/*
				Search the configured directory
				after the period of 1 minute to check newly
				or updated csv files.
				*/
				searchCSVFiles();
				Thread.sleep(15 * 1000);
			} catch (InterruptedException e) {
				System.out.println("Interruption while sleeping!");
			} catch ( Exception e ) {
				System.out.println( "Exception thrown from searchCSVFiles !");
			}
		}
	}

	private void searchCSVFiles() throws Exception {
		try {
			File file = new File( dirPath );
			List<String> updatedFiles = new ArrayList<>();
			String[] filenames = file.list();

			if (filenames != null)
			for ( String currFile : filenames ) {
				if ( currFile.endsWith(".csv") ) {
					if ( !csvListWithTime.containsKey(currFile) )  {
						csvListWithTime.put( currFile, null );
					}

					Path path = Paths.get( dirPath, currFile);
					BasicFileAttributes fileAttributes = Files.readAttributes(path, BasicFileAttributes.class);

					if ( csvListWithTime.get( currFile ) == null
							|| !csvListWithTime.get( currFile ).equals( fileAttributes.lastModifiedTime() ) ) {
						updatedFiles.add(currFile);
						csvListWithTime.put(currFile, fileAttributes.lastModifiedTime());
					}
				}
			}
			this.updatedFiles = updatedFiles;
			if ( updatedFiles.size() > 0 ) {
				addUpdatedFilesData( );
			}
		} catch (IOException e ) {
			System.out.println("Problem in IO operations of file.. reading file attributes");
		} catch ( Exception e ) {
			e.printStackTrace();
			System.out.println("Unexpected error occurred!");
		}
	}

	public void addUpdatedFilesData() {
		/*
		 * If the CSV file in the List is a newly added file than it creates a
		 * new entry in the Hash map assigning filename as Key and initializes a
		 * new sub map - Hash map as Value
		 */
		for (int i = 0; i < updatedFiles.size(); i++) {
			try {
				List<TShirt> tshirtData = readCSVAddData(updatedFiles.get(i));
				TShirtData.getInstance().insertCSVFileData(tshirtData);
			} catch (Exception exception) {
				exception.printStackTrace();
			}

		}
	}

	public List<TShirt> readCSVAddData(String csvFile ) throws Exception {
		List<TShirt> tshirtData = new ArrayList<>();
		csvFile = dirPath + "\\" + csvFile;

		try (FileReader fr = new FileReader(csvFile)) {

			 tshirtData = new CsvToBeanBuilder<TShirt>(fr)
					.withSeparator(csvSeparator)
					.withSkipLines(1)
					.withType(TShirt.class)
					.build()
					.stream()
					.collect(Collectors.toList());
		} catch (IOException e) {
			System.out.println("Error While Reading!");
			e.printStackTrace();
		}
		return tshirtData;
	}


	
}