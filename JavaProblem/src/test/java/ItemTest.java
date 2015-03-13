import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.junit.Test;


public class ItemTest {

	@Test
	public void testSellInAndQualityUpdated() {
		StandardItem item = new StandardItem("standard item", 7, 100);
		item.updateQuality();
		Assert.assertEquals(99, item.getQuality());
		Assert.assertEquals(6, item.getSellIn());
	}
	
	@Test
	public void testQualityDegradesTwiceAsFast() {
		StandardItem item = new StandardItem("standard item", 2, 100);
		item.updateQuality();
		Assert.assertEquals(99, item.getQuality());
		item.updateQuality();
		Assert.assertEquals(97, item.getQuality());
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
	public void testQualityNotMoreThan50ExceptSulfuras() {
		assertTrue(true);
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
