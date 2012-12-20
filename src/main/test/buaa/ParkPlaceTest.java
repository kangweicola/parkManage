package main.test.buaa;

import main.java.buaa.exception.NoCarException;
import main.java.buaa.exception.NoPlaceException;
import main.java.buaa.park.Car;
import main.java.buaa.park.ParkPlace;
import main.java.buaa.park.Ticket;

import org.junit.Assert;
import org.junit.Test;


/**
 * 停车场测试类
 * @author kangwei
 */
public class ParkPlaceTest {

	@Test
	public void havePlace() {
		ParkPlace pp = new ParkPlace(20,"康车场");
		Car car = new Car();
		Ticket proof = pp.parking(car);
		Assert.assertNotNull(proof);
	}

	@Test(expected = NoPlaceException.class)
	public void haveNoPlace() {
		ParkPlace pp = new ParkPlace(2,"康车场");
		pp.parking(new Car());
		pp.parking(new Car());
		Ticket proof = pp.parking(new Car());
	}

	@Test
	public void getCar() {
		ParkPlace pp = new ParkPlace(20,"康车场");
		Car car = new Car();
		Ticket proof = pp.parking(car);
		Assert.assertSame(car, pp.getParkedCar(proof));
	}

	@Test(expected = NoCarException.class)
	public void getCar_NoThisCar() {
		ParkPlace pp = new ParkPlace(20,"康车场");
		Ticket proof = pp.parking(new Car());
		pp.getParkedCar(proof);
		pp.getParkedCar(proof);
	}

	@Test
	public void ShowAvailableNum() {
		int maxParkingNum = 20;
		ParkPlace pp = new ParkPlace(maxParkingNum,"康车场");
		pp.parking(new Car());
		pp.parking(new Car());
		Assert.assertEquals(Integer.valueOf(maxParkingNum - 2), pp.getAvailableNum());
	}
	
}
