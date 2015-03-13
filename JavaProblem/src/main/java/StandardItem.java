


public class StandardItem extends Item {

	public StandardItem(String name, int sellIn, int quality) {
		super(name, sellIn, quality);
	}

	public void updateQuality() {
		sellIn = sellIn - 1;
		if (quality > 0) {
			// TODO: confirm exactly the behaviour when sellIn = 0
			if (sellIn > 0) {
				quality = quality - 1;	
			}
			else {
				if (quality > 1) {
					quality = quality - 2;
				}
			}
		}
		
	}
}
