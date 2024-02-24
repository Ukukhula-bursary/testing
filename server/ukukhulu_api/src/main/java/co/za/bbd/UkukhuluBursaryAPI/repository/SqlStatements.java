package co.za.bbd.UkukhuluBursaryAPI.repository;

import java.util.Iterator;
import java.util.List;

public class SqlStatements {
    
    public static String insertStatement(String tableName, List<String> tableColumns, List<Object> rowValues) {

        StringBuilder insertStatementSB = new StringBuilder();

        insertStatementSB.append("INSERT INTO " + tableName + " (");

        Iterator<String> tableColumnsIterator = tableColumns.listIterator();

        while (tableColumnsIterator.hasNext()) {
            insertStatementSB.append(tableColumnsIterator.next());

            if (tableColumnsIterator.hasNext()) {
                insertStatementSB.append(", ");
            }
        }

        insertStatementSB.append(") VALUES(");

        Iterator<Object> rowValuesIterator = rowValues.listIterator();

        while (rowValuesIterator.hasNext()) {
            insertStatementSB.append(rowValuesIterator.next());

            if (rowValuesIterator.hasNext()) {
                insertStatementSB.append(", ");
            }
        }

        insertStatementSB.append(")");

        return insertStatementSB.toString();
    }
    
    public static String selectStatement(String tableName, List<String> tableColumns) {

        StringBuilder selectStatementSB = new StringBuilder();

        selectStatementSB.append("SELECT ");

        Iterator<String> tableColumnsIterator = tableColumns.listIterator();

        while (tableColumnsIterator.hasNext()) {
            selectStatementSB.append(tableColumnsIterator.next());

            if (tableColumnsIterator.hasNext()) {
                selectStatementSB.append(", ");
            }
        }

        selectStatementSB.append(" FROM " + tableName);


        return selectStatementSB.toString();
    }
    
    // public static void main(String[] args) {
    //     insertStatement("Apps", Arrays.asList("one", "two", "three", "four"), Arrays.asList(1, 5.34343, "Happiess"));
    // }
}
