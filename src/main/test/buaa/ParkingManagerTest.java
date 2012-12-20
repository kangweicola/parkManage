package main.test.buaa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import junit.framework.Assert;

import main.java.buaa.exception.NoCarException;
import main.java.buaa.park.Car;
import main.java.buaa.park.ParkPlace;
import main.java.buaa.park.ParkingBoy;
import main.java.buaa.park.ParkingManager;
import main.java.buaa.park.Ticket;

import org.junit.Before;
import org.junit.Test;


/**
 * 
 * 停车经理类
 * @author 徐飞飞
 */
public class ParkingManagerTest {
	
	private ParkingManager parkManager; 
	
	@Before
	public void init(){
		List<ParkPlace> mpl=new ArrayList<ParkPlace>();
		mpl.add(new ParkPlace(4,"康车场1"));
	
		HashSet<ParkingBoy> parkingBoys=new HashSet<ParkingBoy>();
		List<ParkPlace> ppl1=new ArrayList<ParkPlace>();
		ppl1.add(new ParkPlace(5,"高车场1"));
		parkingBoys.add(new ParkingBoy(ppl1,"高强"));
	
		List<ParkPlace> ppl2=new ArrayList<ParkPlace>();
		ppl2.add(new ParkPlace(6,"徐车场1"));
		parkingBoys.add(new ParkingBoy(ppl2,"徐飞飞"));
		
		this.parkManager=new ParkingManager(mpl, parkingBoys,"康威");
	}
	
	@Test
	public void pringInfo(){
		Assert.assertNotNull(parkManager.reportInfo());
		System.out.println(parkManager.reportInfo());
	}
	
	@Test
	public void getParkingBoys(){
		Assert.assertEquals(Integer.valueOf(2), Integer.valueOf(parkManager.getParkingBoys().size()));
	}
	
	@Test
	public void parking_boy(){
		HashSet<ParkingBoy> parkingBoys=parkManager.getParkingBoys();
		ParkingBoy parkBoy=parkingBoys.iterator().next();
		Car car=new Car();
		Ticket proof=parkManager.parking(parkBoy, car);
		Assert.assertEquals(car, parkBoy.getParkedCar(proof));
	}
	
	@Test	(expected= NoCarException.class)
	public void parking_boy_exception(){
		HashSet<ParkingBoy> parkingBoys=parkManager.getParkingBoys();
		ParkingBoy parkBoy=parkingBoys.iterator().next();
		Car car=new Car();
		Ticket proof=parkManager.parking(parkBoy, car);
		Assert.assertEquals(car, parkManager.getParkedCar(proof));
	}
	
	@Test	(expected= NoCarException.class)
	public void parking_boy_noteq(){
		HashSet<ParkingBoy> parkingBoys=parkManager.getParkingBoys();
		ParkingBoy[] parkBoy=new ParkingBoy[1];
		parkBoy=parkingBoys.toArray(parkBoy);
		Car car=new Car();
		Ticket proof=parkManager.parking(parkBoy[0], car);
		Assert.assertEquals(car, parkBoy[1].getParkedCar(proof));
	}
}
