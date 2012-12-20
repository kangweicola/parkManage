package main.java.buaa.park;

import java.util.HashMap;
import java.util.Map;

import main.java.buaa.exception.NoCarException;
import main.java.buaa.exception.NoPlaceException;


/**
 *   ͣ������
 * @author kangwei
 */
public class ParkPlace {
	
	private static int PARK_ID=0;
	
    private Map<Ticket, Car> parkedCarList = new HashMap<Ticket, Car>();
    
    private Integer maxParkingNum;
    
    private String parkName;
    
    
    public String toString(){
    	return "ͣ�������:"+this.parkName+"\n\t\t��λ��:"+this.maxParkingNum+"\n\t\t��λ��:"+this.getAvailableNum();
    }
    
    /**
     *   ��ȡͣ������ǰ���õ�ͣ��λ������
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
     * ����ͣ��λ
     * @param maxParkingNum
     */
    public ParkPlace(int maxParkingNum,String parkName) {
    	if(maxParkingNum<=1){//����С��1
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
    		 throw new NoCarException("������Ϊ��");
    	}
    	if(getAvailableNum()<=0){
    		 throw new NoPlaceException("û��ͣ��λ��");
    	}
    	Ticket t=new Ticket();
    	parkedCarList.put(t, c);
    	return t;
    }
    
    public Car getParkedCar(Ticket pp) throws NoCarException {
        if (parkedCarList.containsKey(pp)) {
            return parkedCarList.remove(pp);
        }
        throw new NoCarException("û�д˳� ��");
    }
    
    /**
     * ��ȡͣ��֤��ͣ������Ϣ�Ķ�Ӧ��ϵ ����
     * @return
     */
    public Map<Ticket, Car> getParkedCarList(){
    	return this.parkedCarList;
    }
}
