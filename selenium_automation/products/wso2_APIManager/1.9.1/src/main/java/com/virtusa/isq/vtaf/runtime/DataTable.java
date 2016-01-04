package com.virtusa.isq.vtaf.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A test data table allows a table of test data to be maintained and
 * referenced.
 * 
 * @author cmendis.
 * 
 */
public class DataTable {

    /** The table. */
    private ArrayList<HashMap<String, String>> table =
            new ArrayList<HashMap<String, String>>();

    /** The columns. */
    private ArrayList<String> columns = new ArrayList<String>();

    /** Data types of the columns. */
    private ArrayList<String> dataTypes = new ArrayList<String>();

    /**
     * Adds the column data type.
     * 
     * @param type
     *            the column data type
     */
    public final void addDataTypes(final String type) {
        this.dataTypes.add(type);
    }

    /**
     * Gets the column data type.
     * 
     * @param index
     *            the index of column data type
     * @return the data type
     */
    public final String getDataType(final int index) {
        return this.dataTypes.get(index);
    }

    /**
     * Adds the column.
     * 
     * @param column
     *            the column
     */
    public final void addColumn(final String column) {
        this.columns.add(column);
    }

    /**
     * Adds the column.
     * 
     * @param index
     *            the index
     * @param column
     *            the column
     */
    public final void addColumn(final int index, final String column) {
        this.columns.add(index, column);
    }

    /**
     * Adds the row at.
     * 
     * @param rowIndex
     *            the row index
     */
    public final void addRowAt(final int rowIndex) {
        this.table.add(rowIndex, new HashMap<String, String>());
    }

    /**
     * Gets the.
     * 
     * @param row
     *            the row
     * @param column
     *            the column
     * @return the string
     */
    public final String get(final int row, final String column) {
        return table.get(row).get(column);
    }

    /**
     * Gets the.
     * 
     * @param row
     *            the row
     * @param col
     *            the col
     * @return the string
     */
    public final String get(final int row, final int col) {
        String column = columns.get(col);
        return get(row, column);
    }

    /**
     * Sets the value.
     * 
     * @param row
     *            the row
     * @param column
     *            the column
     * @param value
     *            the value
     */
    public final void setValue(final int row, final int column,
            final String value) {
        this.setValue(row, columns.get(column), value);
    }

    // Note: Assumes that sequential addition row-wise. row is 0-indexed
    /**
     * Sets the value.
     * 
     * @param row
     *            the row
     * @param column
     *            the column
     * @param value
     *            the value
     */
    public final void setValue(final int row, final String column,
            final String value) {
        HashMap<String, String> map;
        if (table.size() < row + 1) { // need to add a row
            map = new HashMap<String, String>();
            table.add(map);
        } else {
            map = table.get(row);
        }
        map.put(column, value);
    }

    /**
     * Gets the row count.
     * 
     * @return the row count
     */
    public final int getRowCount() {
        return table.size();
    }

    /**
     * Gets the col count.
     * 
     * @return the col count
     */
    public final int getcolCount() {
        return this.columns.size();
    }

    /**
     * Gets the rows.
     * 
     * @return the rows
     */
    public final ArrayList<HashMap<String, String>> getRows() {
        return table;
    }

    /**
     * Gets the columns.
     * 
     * @return the columns
     */
    public final List<String> getColumns() {
        return this.columns;
    }

    /**
     * Int value.
     * 
     * @param row
     *            the row
     * @param column
     *            the column
     * @return the int
     */
    public final int intValue(final int row, final String column) {
        return Integer.parseInt(this.get(row, column));
    }

    /**
     * String value.
     * 
     * @param row
     *            the row
     * @param column
     *            the column
     * @return the string
     */
    public final String stringValue(final int row, final String column) {
        return (this.get(row, column));
    }

    /**
     * Integer value.
     * 
     * @param row
     *            the row
     * @param column
     *            the column
     * @return the string
     */
    public final Integer intValue(final int row, final int column) {
        try {
            return Integer.valueOf(this.get(row, column));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    /**
     * Boolean value.
     * 
     * @param row
     *            the row
     * @param column
     *            the column
     * @return the string
     */
    public final boolean booleanValue(final int row, final int column) {
        return Boolean.parseBoolean(this.get(row, column));
    }
    
    /**
     * Double value.
     * 
     * @param row
     *            the row
     * @param column
     *            the column
     * @return the string
     */
    public final Double doubleValue(final int row, final int column) {
        try {
            return Double.valueOf(this.get(row, column));
        } catch (NumberFormatException e) {
            return null;
        }
    }


}
