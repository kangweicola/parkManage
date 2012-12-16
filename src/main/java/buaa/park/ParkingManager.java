package main.java.buaa.park;

import java.util.HashSet;
import java.util.List;

import main.java.buaa.exception.NoParkingBoyInControle;
import main.java.buaa.exception.NoPlaceException;


/**
 *  
 *@author ��ɷ�
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
	 *  ��Ŀ�����ƶ�ͣ����ȥͣ��
	 * @author kangwei
	 */
	public Ticket parking(ParkingBoy parkBoy,Car c) throws NoPlaceException,NoParkingBoyInControle {
		if(parkingBoys.contains(parkBoy)){
			return parkBoy.parking(c);
		}else{
			throw new NoParkingBoyInControle("��Ŀ����û�й����ͣ���С�");
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
		sb.append("��Ŀ������:"+getParkingRoleName()+"\t��λ������"+getMaxParkingNum()+"\t��λ����"+getAvailableParkNum()+"\n");
		sb.append(super.reportInfo()+"\n");
//		sb.append("\n+++++\n");
		for(ParkingBoy parkBoy:parkingBoys){
			sb.append(parkBoy.reportInfo());
		}
//		sb.append("\n+++++\n");
//		sb.append("------ParkingManager���� end---------------\n");
		return sb.toString();
	}
}
