package main.java.buaa.park;

import java.util.HashMap;
import java.util.Map;

import main.java.buaa.exception.NoCarException;
import main.java.buaa.exception.NoPlaceException;


/**
 *   停车场类
 * @author kangwei
 */
public class ParkPlace {
	
	private static int PARK_ID=0;
	
    private Map<Ticket, Car> parkedCarList = new HashMap<Ticket, Car>();
    
    private Integer maxParkingNum;
    
    private String parkName;
    
    
    public String toString(){
    	return "停车场编号:"+this.parkName+"\n\t\t车位数:"+this.maxParkingNum+"\n\t\t空位数:"+this.getAvailableNum();
    }
    
    /**
     *   获取停车场当前可用的停车位的总数
     * @author kangwei
     */
    public Integer getAvailableNum() {
        return maxParkingNum - parkedCarList.size();
    }
    
    /**
     * 
     * @author kangwei
     */
    public Integer getMaxParkingNum(){
    	return this.maxParkingNum;
    }
    
    /**
     * 设置停车位
     * @param maxParkingNum
     */
    public ParkPlace(int maxParkingNum,String parkName) {
    	if(maxParkingNum<=1){//不能小于1
    		 this.maxParkingNum = 1;
    	}else{
    		 this.maxParkingNum = maxParkingNum;
    	}
        this.parkName=parkName;
    }
    
    public String getParkName(){
    	return this.parkName;
    }
 
    public Ticket parking(Car c)throws NoCarException,NoPlaceException{
    	if(c==null){
    		 throw new NoCarException("车不能为空");
    	}
    	if(getAvailableNum()<=0){
    		 throw new NoPlaceException("没有停车位子");
    	}
    	Ticket t=new Ticket();
    	parkedCarList.put(t, c);
    	return t;
    }
    
    public Car getParkedCar(Ticket pp) throws NoCarException {
        if (parkedCarList.containsKey(pp)) {
            return parkedCarList.remove(pp);
        }
        throw new NoCarException("没有此车 ！");
    }
    
    /**
     * 获取停车证和停车的信息的对应关系 集合
     * @return
     */
    public Map<Ticket, Car> getParkedCarList(){
    	return this.parkedCarList;
    }
}
