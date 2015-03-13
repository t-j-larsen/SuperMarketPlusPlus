// TODO: Move to a separate package

import java.util.ArrayList;
import java.util.List;


public class SuperMarketPlusPlus {

	private List<StandardItem> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
        System.out.println("Starting Supermarket Plus Plus");
		
        SuperMarketPlusPlus market = new SuperMarketPlusPlus();
        List<StandardItem>items = new ArrayList<StandardItem>();
        items.add(new StandardItem("Thermal Vest", 10, 20));
        items.add(new StandardItem("Chicken", 5, 7));       
        items.add(new StandardItem("Ginger Cake", 3, 6));
        
        StandardItem agedBrie = new StandardItem("Aged Brie", 2, 0);
        agedBrie.setQualityDelta(-1);
        items.add(agedBrie);
        
        items.add(new StandardItem("Sulfuras", 0, 80, 80));
        
        items.add(new StandardItem("Backstage Passes", 15, 20) {
			@Override 
			public void updateQuality() {
				sellIn = sellIn - 1;
				if (sellIn > 10) {
					setQuality(quality + 1);
				}
				else if (sellIn > 5) {
					setQuality(quality + 2);
				}
				else if (sellIn >= 0) {
					setQuality(quality + 3);;
				}
				else {
					quality = 0;
				}
			}
		});
        
        // new products
        
		StandardItem organicBananas = new StandardItem("Organic bananas", 2, 25);
		organicBananas.setDegradationSpeed(2);
		items.add(organicBananas);
        
        market.setItems(items);
        market.updateQuality();
	}

	public SuperMarketPlusPlus() 
	{
	
	}
	
    public void updateQuality()
    {
        for (StandardItem item : items) {
        	item.updateQuality();
        }
    }

	public List<StandardItem> getItems() {
		return items;
	}

	public void setItems(List<StandardItem> items) {
		this.items = items;
	}

}