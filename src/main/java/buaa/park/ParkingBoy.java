package main.java.buaa.park;

import java.util.List;

/**
 *  停车仔类
 * @author 高强
 */
public class ParkingBoy extends Park {
	
	public String ParkingBoy;
	
	public ParkingBoy(List<ParkPlace> parkPlaceList,String ParkingBoy) {
		super(parkPlaceList);
		this.ParkingBoy=ParkingBoy;
	}
	public String getParkingBoyName() {
		return ParkingBoy;
	}
	public String reportInfo(){
		StringBuilder sb=new StringBuilder("\n停车仔姓名："+getParkingBoyName()+"\n\t");
		sb.append(super.reportInfo());
		sb.append("\n\tTotal车位数："+getMaxParkPlaceNum()+
				"\n\tTotal空位数："+getAvailableParkNum());
		return sb.toString();
	}
}
