package main.test.buaa;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import main.java.buaa.park.ParkPlace;
import main.java.buaa.park.ParkingBoy;

import org.junit.Before;
import org.junit.Test;

/**
 * 停车童测试类
 * @author 高强
 */
public class ParkingBoyTest {
 
	//停车仔1
	private ParkingBoy parkBoy;
	//停车仔2
	private ParkingBoy parkBoy1;
	
	@Before
	public void init(){
		List<ParkPlace> list=new ArrayList<ParkPlace>();
		list.add(new ParkPlace(6,"高车场1"));
		parkBoy=new ParkingBoy(list,"高强");
		
		List<ParkPlace> list1=new ArrayList<ParkPlace>();
		list1.add(new ParkPlace(4,"徐车场1"));
		parkBoy1=new ParkingBoy(list1,"徐飞飞");
	}
	
	@Test
	public void testBoyAndPark(){
		Assert.assertEquals("高强",parkBoy.getParkingBoyName());
		Assert.assertEquals("徐飞飞",parkBoy1.getParkingBoyName());
	}
	
	@Test
	public void pringParkInfo(){
		Assert.assertNotNull(parkBoy.reportInfo());
		System.out.println(parkBoy.reportInfo());
		
		Assert.assertNotNull(parkBoy1.reportInfo());
		System.out.println(parkBoy1.reportInfo());
	}
}
