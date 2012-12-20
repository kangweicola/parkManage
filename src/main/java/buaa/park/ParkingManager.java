package main.java.buaa.park;

import java.util.HashSet;
import java.util.List;

import main.java.buaa.exception.NoParkingBoyInControle;
import main.java.buaa.exception.NoPlaceException;


/**
 * ͣ��������
 *@author ��ɷ�
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
	
	public String getParkingManagerName() {
		return pmName;
	}
	
	public HashSet<ParkingBoy> getParkingBoys(){
		return this.parkingBoys;
	}
	
	public String reportInfo(){
		StringBuilder sb=new StringBuilder("");
		sb.append("ͣ����������:"+getParkingManagerName()+"\n");
		sb.append("\t"+super.reportInfo()+"\n");
		sb.append("\tTotal��λ����"+getMaxParkPlaceNum()+"\n\tTotal��λ����"+getAvailableParkNum()+"\n");
		for(ParkingBoy parkBoy:parkingBoys){
			sb.append(parkBoy.reportInfo());
		}

		return sb.toString();
	}
}
