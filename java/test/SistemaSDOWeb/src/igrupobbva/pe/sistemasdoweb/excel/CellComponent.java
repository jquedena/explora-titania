package igrupobbva.pe.sistemasdoweb.excel;

public class CellComponent {
	private int row;
	private int col;
	private String caption;
	private int rowspan;
	private int colspan;
	private String fontWeight;
	private String color;
	private String backgroundColor;
	private String type;
	private String pattern;

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public int getRowspan() {
		return rowspan;
	}

	public void setRowspan(int rowspan) {
		this.rowspan = rowspan;
	}

	public int getColspan() {
		return colspan;
	}

	public void setColspan(int colspan) {
		this.colspan = colspan;
	}	
	
	public String getFontWeight() {
		return fontWeight;
	}

	public void setFontWeight(String fontWeight) {
		this.fontWeight = fontWeight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPattern() {
		return pattern;
	}

	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	public String toString() {
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append("{row:");
		stringBuilder.append(row);
		stringBuilder.append(",col:");
		stringBuilder.append(col);
		stringBuilder.append(",caption:");
		stringBuilder.append(caption);
		stringBuilder.append(",rowspan:");
		stringBuilder.append(rowspan);
		stringBuilder.append(",colspan:");
		stringBuilder.append(colspan);
		stringBuilder.append(",fontWeight:");
		stringBuilder.append(fontWeight);
		stringBuilder.append(",color:");
		stringBuilder.append(color);
		stringBuilder.append(",backgroundColor:");
		stringBuilder.append(backgroundColor);
		stringBuilder.append(",type:");
		stringBuilder.append(type);
		stringBuilder.append(",pattern:");
		stringBuilder.append(pattern);
		stringBuilder.append("}");
		return  stringBuilder.toString();
	}
}