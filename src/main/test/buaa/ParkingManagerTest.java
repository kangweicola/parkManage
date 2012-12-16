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
 * @author kangwei
 */
public class ParkingManagerTest {
	private ParkingManager parkManager;
	@Before
	public void init(){
		List<ParkPlace> managerParkList=new ArrayList<ParkPlace>();
		managerParkList.add(new ParkPlace(12));
		managerParkList.add(new ParkPlace(12));
		
		HashSet<ParkingBoy> parkingBoys=new HashSet<ParkingBoy>();
		List<ParkPlace> parkPlaceListA=new ArrayList<ParkPlace>();
		parkPlaceListA.add(new ParkPlace(12));
		parkPlaceListA.add(new ParkPlace(12));
		parkingBoys.add(new ParkingBoy(parkPlaceListA));
		
		List<ParkPlace> parkPlaceListB=new ArrayList<ParkPlace>();
		parkPlaceListB.add(new ParkPlace(12));
		parkPlaceListB.add(new ParkPlace(12));
		parkingBoys.add(new ParkingBoy(parkPlaceListB));
		
		this.parkManager=new ParkingManager(managerParkList, parkingBoys);
	}
	@Test
	public void test_report(){
		Assert.assertNotNull(parkManager.reportInfo());
		System.out.println(parkManager.reportInfo());
	}
	
	@Test
	public void test_getParkingBoys(){
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
	@Test(expected= NoCarException.class)
	public void parking_boy_exception(){
		HashSet<ParkingBoy> parkingBoys=parkManager.getParkingBoys();
		ParkingBoy parkBoy=parkingBoys.iterator().next();
		Car car=new Car();
		Ticket proof=parkManager.parking(parkBoy, car);
		Assert.assertEquals(car, parkManager.getParkedCar(proof));
	}
	
	@Test(expected= NoCarException.class)
	public void parking_boy_noteq(){
		HashSet<ParkingBoy> parkingBoys=parkManager.getParkingBoys();
		ParkingBoy[] parkBoy=new ParkingBoy[1];
		parkBoy=parkingBoys.toArray(parkBoy);
		Car car=new Car();
		Ticket proof=parkManager.parking(parkBoy[0], car);
		Assert.assertEquals(car, parkBoy[1].getParkedCar(proof));
	}
}
