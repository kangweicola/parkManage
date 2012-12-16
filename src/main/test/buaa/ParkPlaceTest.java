package main.test.buaa;

import main.java.buaa.exception.NoCarException;
import main.java.buaa.exception.NoPlaceException;
import main.java.buaa.park.Car;
import main.java.buaa.park.ParkPlace;
import main.java.buaa.park.Ticket;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author kangwei
 */
public class ParkPlaceTest {

	@Test
	public void parkPlace_Parking_HavePlace() {
		ParkPlace pp = new ParkPlace(20);
		Car car = new Car();
		Ticket proof = pp.parking(car);
		Assert.assertNotNull(proof);
	}

	@Test(expected = NoPlaceException.class)
	public void parkPlace_Parking_NoPlace() {
		ParkPlace pp = new ParkPlace(2);
		pp.parking(new Car());
		pp.parking(new Car());
		Ticket proof = pp.parking(new Car());
	}

	@Test
	public void parkPlace_GetCar() {
		ParkPlace pp = new ParkPlace(20);
		Car car = new Car();
		Ticket proof = pp.parking(car);
		Assert.assertSame(car, pp.getParkedCar(proof));
	}

	@Test(expected = NoCarException.class)
	public void parkPlace_GetCar_NoThisCar() {
		ParkPlace pp = new ParkPlace(20);
		Ticket proof = pp.parking(new Car());
		pp.getParkedCar(proof);
		pp.getParkedCar(proof);
	}

	@Test
	public void parkPlace_ShowAvailableNum() {
		int maxParkingNum = 20;
		ParkPlace pp = new ParkPlace(maxParkingNum);
		pp.parking(new Car());
		pp.parking(new Car());
		Assert.assertEquals(Integer.valueOf(maxParkingNum - 2), pp
				.getAvailableNum());
	}
	
	@Test
	public void parkPlace_ShowMinParkingNum() {
		int maxParkingNum = -20;
		ParkPlace pp = new ParkPlace(maxParkingNum);
		Assert.assertEquals(new Integer(2), pp
				.getMaxParkingNum());
	}

}
