package edu.stthomas.gps.familyrecipesystem.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class IngredientsTableModel extends AbstractTableModel {

	private final String[] columnNames = { "Quantity", "Unit", "Name" };
	private final List<Object[]> data;
	private final boolean canEdit;

	public IngredientsTableModel(final boolean canEdit) {
		this.canEdit = canEdit;
		this.data = new ArrayList<Object[]>();
	}

	@Override
	public int getRowCount() {
		return this.data.size();
	}

	@Override
	public String getColumnName(final int col) {
		return this.columnNames[col];
	}

	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}

	@Override
	public Object getValueAt(final int row, final int col) {
		return this.data.get(row)[col];
	}

	@Override
	public boolean isCellEditable(final int row, final int col) {
		return this.canEdit;
	}

	@Override
	public void setValueAt(final Object value, final int row, final int col) {
		final Object[] newData = this.data.get(row);
		newData[col] = value.toString();
		this.data.set(row, newData);
		this.fireTableCellUpdated(row, col);
	}

	public void addRow() {
		final String[] str = { "", "", "", "-1" };
		this.data.add(str);
		this.fireTableRowsInserted(this.getRowCount(), this.getRowCount());
	}

	public void addRow(final String[] newData) {
		this.data.add(newData);
		this.fireTableRowsInserted(this.getRowCount(), this.getRowCount());
	}

}
