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
	public void testQualityDegradesTwiceAsFast() {
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
		StandardItem item = new StandardItem("standard item", 1, 51);
		Assert.assertEquals(StandardItem.DEFAUL_MAX_QUALITY, item.getQuality());
		item.setQuality(52);
		Assert.assertEquals(StandardItem.DEFAUL_MAX_QUALITY, item.getQuality());
	}
	
	@Test
	public void testQualityNotMoreThanCustomerMax() {
		StandardItem item = new StandardItem("standard item", 1, 51, 80);
		Assert.assertEquals(51, item.getQuality());
		item.setQuality(81);
		Assert.assertEquals(80, item.getQuality());
	}
	
	@Test
	public void testIncreaseInQuality() {
		assertTrue(true);
	}
	
	@Test
	public void testSulfuras() {
		assertTrue(true);
	}
	
	@Test
	public void testBackstagePasses() {
		assertTrue(true);
	}
	
	@Test
	public void testOrganicBananas() {
		assertTrue(true);
	}
}
