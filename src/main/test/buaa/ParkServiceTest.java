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
 * 停车服务类
 * @author kangwei
 */
public class ParkServiceTest {

	private Park park;
	
	@Before
	public void init(){
		List<ParkPlace> ppl=new ArrayList<ParkPlace>();
		ppl.add(new ParkPlace(10,"康车场"));
		ppl.add(new ParkPlace(11,"康车场"));
		park=new Park(ppl);
	}
	
    @Test
    public void GetCar(){
        Car car = new Car();
        Ticket proof =  park.parking(car) ;
        Assert.assertSame(car,park.getParkedCar(proof));
    }
    
    @Test    ( expected = NoCarException.class)
    public void GetCar_NoThisCar() {
        Ticket proof =  park.parking( new Car()) ;
        park.getParkedCar(proof);
        park.getParkedCar(proof);
    }
    @Test
    public void getAvailableNum_after_park()  {
        park.parking( new Car()) ;
        park.parking( new Car()) ;
        Assert.assertEquals(Integer.valueOf(19),park.getAvailableParkNum());
    }
    @Test
    public void getAvailableNum_after_park_full()  {
    	for(int i=0;i<21;i++){
    		 park.parking( new Car()) ;
    	}
        Assert.assertEquals(Integer.valueOf(0),park.getAvailableParkNum());
    }
    @Test
    public void getAvailableNum(){
    	Assert.assertEquals(Integer.valueOf(21),park.getAvailableParkNum());
    }
    @Test
    public void getMaxParkingNum(){
    	Assert.assertEquals(Integer.valueOf(21),park.getMaxParkPlaceNum());
    }
    @Test
    public void getMaxParkingNum_after_park(){
    	park.parking( new Car()) ;
        park.parking( new Car()) ;
    	Assert.assertEquals(Integer.valueOf(21),park.getMaxParkPlaceNum());
    }
    
    @Test
    public void getUsedParkPlaceCount(){
    	Assert.assertEquals(Integer.valueOf(0),park.getUsedParkPlaceCount());
    }
    @Test
    public void getUsedParkPlaceCount_after_park(){
    	park.parking( new Car()) ;
        park.parking( new Car()) ;
        park.parking( new Car()) ;
        park.parking( new Car()) ;
    	Assert.assertEquals(Integer.valueOf(4),park.getUsedParkPlaceCount());
    }
    
    @Test
    public void getMaxAvailableParkPlace(){
    	Assert.assertEquals(Integer.valueOf(11),park.getMaxAvailableParkPlace().getAvailableNum());
    }
    
    @Test
    public void getMaxAvailableParkPlace_after_park_1(){
    	park.parking( new Car()) ;
    	Assert.assertEquals(Integer.valueOf(10),park.getMaxAvailableParkPlace().getAvailableNum());
    }
    
    @Test
    public void getMaxAvailableParkPlace_after_park_2(){
    	park.parking( new Car()) ;
    	park.parking( new Car()) ;
    	Assert.assertEquals(Integer.valueOf(10),park.getMaxAvailableParkPlace().getAvailableNum());
    }
    
    @Test
	public void Parking_HavePlace() {
		Car car = new Car();
		Ticket proof = park.parking(car);
		Assert.assertNotNull(proof);
	}

	@Test(expected = NoPlaceException.class)
	public void Parking_NoPlace() {
		for(int i=0;i<=21;i++){
			park.parking(new Car());
		}
	}
}
