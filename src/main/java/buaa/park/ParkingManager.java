package main.java.buaa.park;

import java.util.HashSet;
import java.util.List;

import main.java.buaa.exception.NoParkingBoyInControle;
import main.java.buaa.exception.NoPlaceException;


/**
 * 停车经理类
 *@author 徐飞飞
 */
public class ParkingManager extends Park{
	
	private HashSet<ParkingBoy> parkingBoys;
	
	private String pmName;
	
	public ParkingManager(List<ParkPlace> parkPlaceList,HashSet<ParkingBoy> parkingBoys,String pmName) {
		super(parkPlaceList);
		this.parkingBoys=parkingBoys;
		this.pmName=pmName;
	}
	
	/**
	 *  项目经理制定停车仔去停车
	 * @author kangwei
	 */
	public Ticket parking(ParkingBoy parkBoy,Car c) throws NoPlaceException,NoParkingBoyInControle {
		if(parkingBoys.contains(parkBoy)){
			return parkBoy.parking(c);
		}else{
			throw new NoParkingBoyInControle("项目经理没有管理该停车仔。");
		}
	}
	
	public String getParkingManagerName() {
		return pmName;
	}
	
	public HashSet<ParkingBoy> getParkingBoys(){
		return this.parkingBoys;
	}
	
	public String reportInfo(){
		StringBuilder sb=new StringBuilder("");
		sb.append("停车经理姓名:"+getParkingManagerName()+"\n");
		sb.append("\t"+super.reportInfo()+"\n");
		sb.append("\tTotal车位数："+getMaxParkPlaceNum()+"\n\tTotal空位数："+getAvailableParkNum()+"\n");
		for(ParkingBoy parkBoy:parkingBoys){
			sb.append(parkBoy.reportInfo());
		}

		return sb.toString();
	}
}
