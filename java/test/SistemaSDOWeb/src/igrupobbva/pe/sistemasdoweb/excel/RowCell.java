package igrupobbva.pe.sistemasdoweb.excel;

public class RowCell {
	private int rowIndex;
	private int colIndex;
	private String colKey;

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}

	public String getColKey() {
		return colKey;
	}

	public void setColKey(String colKey) {
		this.colKey = colKey;
	}

	public int getColIndex() {
		return colIndex;
	}

	public void setColIndex(int colIndex) {
		this.colIndex = colIndex;
	}
}
