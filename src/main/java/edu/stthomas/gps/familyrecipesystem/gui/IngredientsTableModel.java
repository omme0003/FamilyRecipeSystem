package edu.stthomas.gps.familyrecipesystem.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class IngredientsTableModel extends AbstractTableModel {
	
	private String[] columnNames = {"Quantity", "Unit", "Name"};
	private List<Object[]> data;
	private boolean canEdit;
	
	public IngredientsTableModel(boolean canEdit) {
		this.canEdit = canEdit;
		this.data = new ArrayList<Object[]>();
	}

	@Override
	public int getRowCount() {
		return data.size();
	}
	
	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int row, int col) {
		return data.get(row)[col];
	}
	
	@Override
	public boolean isCellEditable(int row, int col) {
		return canEdit;
	}
	
	@Override
	public void setValueAt(Object value, int row, int col) {
		Object[] newData = data.get(row);
		newData[col] = value;
		data.set(row, newData);
		fireTableCellUpdated(row, col);
	}
	
	public void addRow() {
		data.add(new Object[3]);
		fireTableRowsInserted(this.getRowCount(), this.getRowCount());
	}
	
	public void addRow(Object[] newData) {
		data.add(newData);
		fireTableRowsInserted(this.getRowCount(), this.getRowCount());
	}

}
