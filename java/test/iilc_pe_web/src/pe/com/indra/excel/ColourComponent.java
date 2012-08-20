package pe.com.indra.excel;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import jxl.format.Colour;
import jxl.write.WritableWorkbook;

public class ColourComponent {

	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(ColourComponent.class);
	private Map<String, Colour> colour;
	private int indexPalette = 0;
	
	private Colour[] palette = {
		Colour.DARK_RED,
		Colour.DARK_BLUE,
		Colour.DARK_YELLOW,
		Colour.VIOLET,
		Colour.TEAL,
		Colour.PERIWINKLE,
		Colour.PLUM2,
		Colour.IVORY,
		Colour.LIGHT_TURQUOISE2,
		Colour.DARK_PURPLE,
		Colour.CORAL,
		Colour.OCEAN_BLUE,
		Colour.ICE_BLUE,
		Colour.DARK_BLUE2,
		Colour.VIOLET2,
		Colour.DARK_RED2,
		Colour.TEAL2,
		Colour.BLUE2,
		Colour.SKY_BLUE,
		Colour.LIGHT_TURQUOISE,
		Colour.LIGHT_GREEN,
		Colour.VERY_LIGHT_YELLOW,
		Colour.PALE_BLUE,
		Colour.ROSE,
		Colour.LAVENDER,
		Colour.TAN,
		Colour.LIGHT_BLUE,
		Colour.AQUA,
		Colour.LIME,
		Colour.GOLD,
		Colour.LIGHT_ORANGE,
		Colour.ORANGE,
		Colour.BLUE_GREY,
		Colour.DARK_TEAL,
		Colour.SEA_GREEN,
		Colour.DARK_GREEN,
		Colour.OLIVE_GREEN,
		Colour.BROWN,
		Colour.PLUM,
		Colour.INDIGO
	};
	
	public ColourComponent() {
		indexPalette = 0;
		colour = new HashMap<String, Colour>();
		colour.put("255,255,255", Colour.WHITE);
		colour.put("0,0,0", Colour.BLACK);
		colour.put("255,0,0", Colour.RED);
		colour.put("0,255,0", Colour.GREEN);
		colour.put("0,0,255", Colour.BLUE);
		colour.put("0,255,255", Colour.TURQUOISE);
		colour.put("255,255,0", Colour.YELLOW);
		colour.put("255,0,255", Colour.PINK);
	}
	
	public Colour getColour(String rgbColor, WritableWorkbook wb) {
		Colour selectColour = null;
		String rgb[] = rgbColor.split("\\,");
		int red;
		int green;
		int blue;
		
		try {
			red = Integer.parseInt(rgb[0].trim());
			green = Integer.parseInt(rgb[1].trim());
			blue = Integer.parseInt(rgb[2].trim());
		} catch(NumberFormatException ex) {
			red = 255;
			green = 255;
			blue = 255;
			log.info(rgbColor);
			rgbColor = "255,255,255";
		}
		
		if(!colour.containsKey(rgbColor)) {
			wb.setColourRGB(palette[indexPalette], red, green, blue);
			colour.put(rgbColor, palette[indexPalette]);
			indexPalette++;
		}
		selectColour = colour.get(rgbColor);
		
		return selectColour;
	}
}
