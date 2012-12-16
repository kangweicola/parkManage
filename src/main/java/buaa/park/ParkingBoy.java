package main.java.buaa.park;

import java.util.List;

/**
 *  
 * @author ��ǿ
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
		StringBuilder sb=new StringBuilder("------ParkingBoy���� beg---------------\n");
		sb.append("ParkingBoyName:"+getParkingRoleName()+"\t��λ������"+getMaxParkingNum()+"\t��λ����"+getAvailableNum()+"\n");
		sb.append(super.reportInfo());
		sb.append("------ParkingBoy���� end---------------\n");
		*/
		StringBuilder sb=new StringBuilder("ͣ���б�ţ�"+getParkingRoleName()+"\t��λ������"+getMaxParkingNum()+"\t��λ����"+getAvailableParkNum()+"\n");
		sb.append(super.reportInfo());
		return sb.toString();
	}
}
