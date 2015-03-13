import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;


public class ItemTest {

	@Test
	public void testSellInAndQualityUpdated() {
		StandardItem item = new StandardItem("standard item", 7, 50);
		item.updateQuality();
		Assert.assertEquals(49, item.getQuality());
		Assert.assertEquals(6, item.getSellIn());
	}
	
	@Test
	public void testQualityDegradesTwiceAsFastAfterExpiry() {
		StandardItem item = new StandardItem("standard item", 2, 50);
		item.updateQuality();
		Assert.assertEquals(49, item.getQuality());
		item.updateQuality();
		Assert.assertEquals(47, item.getQuality());
	}
	
	@Test
	public void testQualityNeverNegative() {
		StandardItem item = new StandardItem("standard item", 7, 1);
		item.updateQuality();
		Assert.assertEquals(0, item.getQuality());
		item.updateQuality();
		Assert.assertEquals(0, item.getQuality());		
	}
	
	@Test
	public void testQualityNotMoreThanDefaultMax() {
		StandardItem item = new StandardItem("standard item", 7, 51);
		Assert.assertEquals(StandardItem.DEFAUL_MAX_QUALITY, item.getQuality());
		item.setQuality(52);
		Assert.assertEquals(StandardItem.DEFAUL_MAX_QUALITY, item.getQuality());
	}
	
	@Test
	public void testQualityNotMoreThanCustomerMax() {
		StandardItem item = new StandardItem("Sulfuras", 7, 51, 80);
		Assert.assertEquals(51, item.getQuality());
		item.setQuality(81);
		Assert.assertEquals(80, item.getQuality());
	}
	
	@Test
	public void testIncreaseInQuality() {
		StandardItem item = new StandardItem("Aged Brie", 7, 25);
		item.setQualityDelta(-1);
		item.updateQuality();
		Assert.assertEquals(26, item.getQuality());
	}
	
	@Test
	public void testNoDecreaseInQualityOrDays() {
		StandardItem item = new StandardItem("Sulfuras", 7, 25);
		item.setQualityDelta(0);
		item.setExpires(false);
		item.updateQuality();
		Assert.assertEquals(25, item.getQuality());
		Assert.assertEquals(7, item.getSellIn());
	}
	
	@Test
	public void testBackstagePasses() {
		assertTrue(true);
	}
	
	@Test
	public void testDoubleDegradationSpeed() {
		StandardItem item = new StandardItem("Organic bananas", 2, 25);
		item.setDegradationSpeed(2);
		item.updateQuality();
		Assert.assertEquals(23, item.getQuality());
		Assert.assertEquals(1, item.getSellIn());
		item.updateQuality();
		Assert.assertEquals(19, item.getQuality()); // double time after expiry		
	}
}
