


public class StandardItem extends Item {

	public StandardItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public void updateQuality() {
		sellIn = sellIn - 1;
		quality = quality - 1;		
	}
}
