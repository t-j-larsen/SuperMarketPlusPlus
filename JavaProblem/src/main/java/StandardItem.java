


public class StandardItem extends Item {

	public static final int DEFAUL_MAX_QUALITY = 50;
	
	private int maxQuality = DEFAUL_MAX_QUALITY;
	
	public StandardItem(String name, int sellIn, int quality) {
		this(name, sellIn, quality, DEFAUL_MAX_QUALITY);
	}

	public StandardItem(String name, int sellIn, int quality, int maxQuality) {
		super(name, sellIn, quality);
		this.maxQuality = maxQuality;
		setQuality(quality); // check quality less than maxQuality
	}
	
	public void updateQuality() {
		sellIn = sellIn - 1;
		if (quality > 0) {
			// TODO: confirm exactly the behaviour when sellIn = 0
			if (sellIn > 0) {
				setQuality(quality - 1);	
			}
			else {
				if (quality > 1) {
					setQuality(quality = quality - 2);
				}
			}
		}
		
	}
	
	@Override
	public void setQuality(int quality) {
		if (quality <= maxQuality) {
			this.quality = quality;				
		}
		else {
			this.quality = maxQuality; // TODO: confirm requirements
		}
	}
}
