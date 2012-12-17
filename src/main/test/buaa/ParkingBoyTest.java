package main.test.buaa;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import main.java.buaa.park.ParkPlace;
import main.java.buaa.park.ParkingBoy;

import org.junit.Before;
import org.junit.Test;

/**
 * Õ£≥µÕØ≤‚ ‘¿‡
 * @author kangwei
 */
public class ParkingBoyTest {

	private ParkingBoy parkBoy;
	@Before
	public void init(){
		List<ParkPlace> list=new ArrayList<ParkPlace>();
		list.add(new ParkPlace(3));
		list.add(new ParkPlace(3));
		list.add(new ParkPlace(3));
		parkBoy=new ParkingBoy(list);
	}
	@Test
	public void getParkingRoleName(){
		Assert.assertEquals(ParkingBoy.PARKING_BOY_FLAG+parkBoy.getID(),parkBoy.getParkingRoleName());
	}
	
	@Test
	public void report(){
		Assert.assertNotNull(parkBoy.reportInfo());
		System.out.println(parkBoy.reportInfo());
	}
}
