package main.test.buaa;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import main.java.buaa.park.ParkPlace;
import main.java.buaa.park.ParkingBoy;

import org.junit.Before;
import org.junit.Test;

/**
 * ͣ��ͯ������
 * @author ��ǿ
 */
public class ParkingBoyTest {
 
	//ͣ����1
	private ParkingBoy parkBoy;
	//ͣ����2
	private ParkingBoy parkBoy1;
	
	@Before
	public void init(){
		List<ParkPlace> list=new ArrayList<ParkPlace>();
		list.add(new ParkPlace(6,"�߳���1"));
		parkBoy=new ParkingBoy(list,"��ǿ");
		
		List<ParkPlace> list1=new ArrayList<ParkPlace>();
		list1.add(new ParkPlace(4,"�쳵��1"));
		parkBoy1=new ParkingBoy(list1,"��ɷ�");
	}
	
	@Test
	public void testBoyAndPark(){
		Assert.assertEquals("��ǿ",parkBoy.getParkingBoyName());
		Assert.assertEquals("��ɷ�",parkBoy1.getParkingBoyName());
	}
	
	@Test
	public void pringParkInfo(){
		Assert.assertNotNull(parkBoy.reportInfo());
		System.out.println(parkBoy.reportInfo());
		
		Assert.assertNotNull(parkBoy1.reportInfo());
		System.out.println(parkBoy1.reportInfo());
	}
}
