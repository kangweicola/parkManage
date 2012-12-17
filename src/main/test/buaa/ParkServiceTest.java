package main.test.buaa;

import java.util.ArrayList;
import java.util.List;

import main.java.buaa.exception.NoCarException;
import main.java.buaa.exception.NoPlaceException;
import main.java.buaa.park.Car;
import main.java.buaa.park.Park;
import main.java.buaa.park.ParkPlace;
import main.java.buaa.park.Ticket;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



/**
 * @author kangwei
 */
public class ParkServiceTest {

	private Park parkPlaceListManager;
	
	@Before
	public void init(){
		List<ParkPlace> parkPlaceList=new ArrayList<ParkPlace>();
		parkPlaceList.add(new ParkPlace(10));
		parkPlaceList.add(new ParkPlace(11));
		parkPlaceList.add(new ParkPlace(12));
		parkPlaceList.add(new ParkPlace(13));
		parkPlaceListManager=new Park(parkPlaceList);
	}
	
    @Test
    public void GetCar(){
        Car car = new Car();
        Ticket proof =  parkPlaceListManager.parking(car) ;
        Assert.assertSame(car,parkPlaceListManager.getParkedCar(proof));
    }
    
    @Test    ( expected = NoCarException.class)
    public void GetCar_NoThisCar() {
        Ticket proof =  parkPlaceListManager.parking( new Car()) ;
        parkPlaceListManager.getParkedCar(proof);
        parkPlaceListManager.getParkedCar(proof);
    }
    @Test
    public void getAvailableNum_after_park()  {
        parkPlaceListManager.parking( new Car()) ;
        parkPlaceListManager.parking( new Car()) ;
        Assert.assertEquals(Integer.valueOf(44),parkPlaceListManager.getAvailableParkNum());
    }
    @Test
    public void getAvailableNum_after_park_full()  {
    	for(int i=0;i<46;i++){
    		 parkPlaceListManager.parking( new Car()) ;
    	}
        Assert.assertEquals(Integer.valueOf(0),parkPlaceListManager.getAvailableParkNum());
    }
    @Test
    public void getAvailableNum(){
    	Assert.assertEquals(Integer.valueOf(46),parkPlaceListManager.getAvailableParkNum());
    }
    @Test
    public void getMaxParkingNum(){
    	Assert.assertEquals(Integer.valueOf(46),parkPlaceListManager.getMaxParkingNum());
    }
    @Test
    public void getMaxParkingNum_after_park(){
    	parkPlaceListManager.parking( new Car()) ;
        parkPlaceListManager.parking( new Car()) ;
    	Assert.assertEquals(Integer.valueOf(46),parkPlaceListManager.getMaxParkingNum());
    }
    
    @Test
    public void getUsedParkPlaceCount(){
    	Assert.assertEquals(Integer.valueOf(0),parkPlaceListManager.getUsedParkPlaceCount());
    }
    @Test
    public void getUsedParkPlaceCount_after_park(){
    	parkPlaceListManager.parking( new Car()) ;
        parkPlaceListManager.parking( new Car()) ;
        parkPlaceListManager.parking( new Car()) ;
        parkPlaceListManager.parking( new Car()) ;
    	Assert.assertEquals(Integer.valueOf(4),parkPlaceListManager.getUsedParkPlaceCount());
    }
    
    @Test
    public void getMaxAvailableParkPlace(){
    	Assert.assertEquals(Integer.valueOf(13),parkPlaceListManager.getMaxAvailableParkPlace().getAvailableNum());
    }
    @Test
    public void getMaxAvailableParkPlace_after_park_1(){
    	parkPlaceListManager.parking( new Car()) ;
    	Assert.assertEquals(Integer.valueOf(12),parkPlaceListManager.getMaxAvailableParkPlace().getAvailableNum());
    }
    @Test
    public void getMaxAvailableParkPlace_after_park_2(){
    	parkPlaceListManager.parking( new Car()) ;
    	parkPlaceListManager.parking( new Car()) ;
    	Assert.assertEquals(Integer.valueOf(12),parkPlaceListManager.getMaxAvailableParkPlace().getAvailableNum());
    }
    @Test
    public void getMaxAvailableParkPlace_after_park_3(){
    	parkPlaceListManager.parking( new Car()) ;
    	parkPlaceListManager.parking( new Car()) ;
    	parkPlaceListManager.parking( new Car()) ;
    	Assert.assertEquals(Integer.valueOf(11),parkPlaceListManager.getMaxAvailableParkPlace().getAvailableNum());
    }
    @Test
    public void getMaxAvailableParkPlace_after_park_4(){
    	parkPlaceListManager.parking( new Car()) ;
    	parkPlaceListManager.parking( new Car()) ;
    	parkPlaceListManager.parking( new Car()) ;
    	parkPlaceListManager.parking( new Car()) ;
    	Assert.assertEquals(Integer.valueOf(11),parkPlaceListManager.getMaxAvailableParkPlace().getAvailableNum());
    }
    
    @Test
	public void Parking_HavePlace() {
		Car car = new Car();
		Ticket proof = parkPlaceListManager.parking(car);
		Assert.assertNotNull(proof);
	}

	@Test(expected = NoPlaceException.class)
	public void Parking_NoPlace() {
		for(int i=0;i<=46;i++){
			parkPlaceListManager.parking(new Car());
		}
	}

	
}
