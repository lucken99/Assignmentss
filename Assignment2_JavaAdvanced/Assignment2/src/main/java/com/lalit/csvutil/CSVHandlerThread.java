package com.lalit.csvutil;

import com.lalit.TShirt;
import com.lalit.dao.TShirtDAOHibernate;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CSVHandlerThread implements Runnable{
    private static final String dirPath = "src\\main\\resources\\csv_files";
    private static final char delimiter = '|';
    private Map<String, FileTime> csvListWithTime;

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
                Thread.sleep( 15 * 1000 );
            } catch ( InterruptedException e ) {
                System.out.println("Sleep Interrupted!");
            } catch ( Exception e ) {
                System.out.println("Exception Occurred!");
            }
        }
    }

    private void searchCSVFiles() throws Exception {
        try {
            File file = new File( dirPath );
            List<String> updatedFiles = new ArrayList<>();
            String[] filenames = file.list();

            assert filenames != null;
            for ( String currFile : filenames ) {
                    if ( currFile.endsWith(".csv") ) {
                        if ( ! ( csvListWithTime.containsKey(currFile) ) ) {
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
            if ( updatedFiles.size() > 0 ) {
                addUpdatedFilesData( updatedFiles );
            }
        } catch (IOException e ) {
            System.out.println("Problem in IO operations of file.. reading file attributes");
        } catch ( Exception e ) {
            System.out.println("Unexpected error occurred!");
        }
    }

    public void addUpdatedFilesData( List<String> updatedFiles ) {
        TShirtDAOHibernate tShirtDAOHibernate = null;
        for ( String csvFile : updatedFiles ) {
            try {
                List<TShirt> tShirtData = readCSVAddData(csvFile);
                tShirtDAOHibernate = new TShirtDAOHibernate();
                for (TShirt tshirtRow : tShirtData) {
                    System.out.println(tshirtRow);
                    tShirtDAOHibernate.insertTShirtDataInDB(tshirtRow);
                }
            } catch ( Exception e ) {
                System.out.println("Error");
            }
        }
    }

    public List<TShirt> readCSVAddData( String csvFile ) throws Exception {
        List<TShirt> tshirtData = new ArrayList<>();
        csvFile = dirPath + "\\" + csvFile;

        try (FileReader fr = new FileReader(csvFile)) {
            tshirtData = new CsvToBeanBuilder<TShirt>(fr)
                    .withSeparator(delimiter)
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
