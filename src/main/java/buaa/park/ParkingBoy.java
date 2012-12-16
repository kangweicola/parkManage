package main.java.buaa.park;

import java.util.List;

/**
 *  
 * @author 高强
 */
public class ParkingBoy extends Park {
	private static int ManagerID=0;
	public static final String PARKING_BOY_FLAG="ParkingBoy_";
	private int id;
	public ParkingBoy(List<ParkPlace> parkPlaceList) {
		super(parkPlaceList);
		this.id=(++ManagerID);
	}
	public int getID(){
		return this.id;
	}
	public String getParkingRoleName() {
		return PARKING_BOY_FLAG+this.id;
	}
	public String reportInfo(){
		/*
		StringBuilder sb=new StringBuilder("------ParkingBoy报表 beg---------------\n");
		sb.append("ParkingBoyName:"+getParkingRoleName()+"\t车位总数："+getMaxParkingNum()+"\t空位数："+getAvailableNum()+"\n");
		sb.append(super.reportInfo());
		sb.append("------ParkingBoy报表 end---------------\n");
		*/
		StringBuilder sb=new StringBuilder("停车仔编号："+getParkingRoleName()+"\t车位总数："+getMaxParkingNum()+"\t空位数："+getAvailableParkNum()+"\n");
		sb.append(super.reportInfo());
		return sb.toString();
	}
}
