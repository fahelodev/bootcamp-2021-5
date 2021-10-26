package katas.acabrera;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArchivoCsv {

    public static String sortCsvColumns( String csvFileContent ) {

        Map<Integer, String> columns = new HashMap<>();
        getColumnNames( csvFileContent, columns );

        int[] sortedColumns = sortMapByValue( columns );


        return sortColumns( sortedColumns, csvFileContent );
    }

    private static void getColumnNames( String csvFileContent, Map<Integer, String> columns ) {
        Pattern pattern = Pattern.compile( "([^;\\n]+)([;\\n])" );
        Matcher matcher = pattern.matcher( csvFileContent );

        int i = 0;
        while ( matcher.find() && !matcher.group( 2 ).equals( "\n" ) ) {
            columns.put( i, matcher.group( 1 ) );
            i++;
        }
        columns.put( i, matcher.group( 1 ) );



    }



    private static int[] sortMapByValue( Map<Integer, String> unsortedMap ) {
        LinkedList<Map.Entry<Integer, String>> list;
        list = new LinkedList<>(
                unsortedMap.entrySet());
        list.sort(Comparator.comparing(o -> o.getValue().toLowerCase()));

        int[] sortedColumns = new int[unsortedMap.size()];
        int i = 0;
        for ( Map.Entry<Integer, String> entry : list ) {
            sortedColumns[i] = entry.getKey();
            i++;
        }

        return sortedColumns;

    }

    private static String sortColumns( int[] sortedColumns, String csvFileContent ) {

        StringBuilder resultString = new StringBuilder();

        ArrayList<String> csvElements;
        csvElements = new ArrayList<>(Arrays.asList(csvFileContent.split("[;\\n]")));



        for ( int j = 0; j < csvElements.size() / sortedColumns.length; j++ ) {
            for ( int i = 0; i < sortedColumns.length; i++ ) {

                resultString.append( csvElements.get( j * sortedColumns.length + sortedColumns[i] ) );
                if ( i < sortedColumns.length - 1 ) {

                    resultString.append( ";" );
                }
            }
            if ( j < csvElements.size() / sortedColumns.length - 1 ) {
                resultString.append( "\n" );
            }
        }
        return resultString.toString();
    }
}
