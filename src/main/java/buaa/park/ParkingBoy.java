package main.java.buaa.park;

import java.util.List;

/**
 *  ͣ������
 * @author ��ǿ
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
		StringBuilder sb=new StringBuilder("\nͣ����������"+getParkingBoyName()+"\n\t");
		sb.append(super.reportInfo());
		sb.append("\n\tTotal��λ����"+getMaxParkPlaceNum()+
				"\n\tTotal��λ����"+getAvailableParkNum());
		return sb.toString();
	}
}
