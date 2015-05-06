package edu.stthomas.gps.familyrecipesystem.gui;

import java.awt.Component;

import javax.swing.AbstractCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableModel;

import edu.stthomas.gps.familyrecipesystem.entity.Unit;

public class UnitTableCellEditor extends AbstractCellEditor implements TableCellEditor {
	private final JComboBox<Unit> editor;

	public UnitTableCellEditor() {
		this.editor = new JComboBox<Unit>(Unit.values());
	}

	@Override
	public Component getTableCellEditorComponent(final JTable table, final Object value, final boolean isSelected,
			final int rowIndex, final int colIndex) {

		// Set the model data of the table
		if (isSelected) {
			this.editor.setSelectedItem(value);
			final TableModel model = table.getModel();
			model.setValueAt(value, rowIndex, colIndex);
		}

		return this.editor;
	}

	@Override
	public Object getCellEditorValue() {
		return this.editor.getSelectedItem();
	}

}
