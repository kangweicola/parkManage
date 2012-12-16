package main.java.buaa.park;

import java.util.HashSet;
import java.util.List;

import main.java.buaa.exception.NoParkingBoyInControle;
import main.java.buaa.exception.NoPlaceException;


/**
 *  
 *@author 徐飞飞
 */
public class ParkingManager extends Park{
	
	private static int ManagerID=0;
	
	private int id;
	
	private HashSet<ParkingBoy> parkingBoys;
	
	public ParkingManager(List<ParkPlace> parkPlaceList,HashSet<ParkingBoy> parkingBoys) {
		super(parkPlaceList);
		this.parkingBoys=parkingBoys;
		id=(++ManagerID);
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
	
	public String getParkingRoleName() {
		return "ParkingManager_"+this.id;
	}
	
	public HashSet<ParkingBoy> getParkingBoys(){
		return this.parkingBoys;
	}
	
	public String reportInfo(){
		StringBuilder sb=new StringBuilder("");
		sb.append("项目经理编号:"+getParkingRoleName()+"\t车位总数："+getMaxParkingNum()+"\t空位数："+getAvailableParkNum()+"\n");
		sb.append(super.reportInfo()+"\n");
//		sb.append("\n+++++\n");
		for(ParkingBoy parkBoy:parkingBoys){
			sb.append(parkBoy.reportInfo());
		}
//		sb.append("\n+++++\n");
//		sb.append("------ParkingManager报表 end---------------\n");
		return sb.toString();
	}
}
