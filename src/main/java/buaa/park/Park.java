package main.java.buaa.park;

import java.util.HashSet;
import java.util.List;

import main.java.buaa.exception.NoCarException;
import main.java.buaa.exception.NoPlaceException;


/**
 * 
 * @author ����
 */
public class Park {
	
	
	private HashSet<ParkPlace> parkPlaceSet=new HashSet<ParkPlace>();
	
	/**
	 * @return ��ȡ�ܵĵ�ǰ����ʹ�õ�ͣ��λ������
	 */
	public Integer getAvailableParkNum() {
		int count = 0;
		for (ParkPlace parkPlace : parkPlaceSet) {
			count += parkPlace.getAvailableNum();
		}
		return count;
	}
	
	/**
	 * ��ȡ�ܵĵ�ǰ�Ѿ�ʹ�õ�ͣ��λ������
	 * @return
	 */
	public Integer getUsedParkPlaceCount() {
		int count = 0;
		for (ParkPlace pp : parkPlaceSet) {
			count += pp.getParkedCarList().size();
		}
		return count;
	}
	
	public Car getParkedCar(Ticket pp) throws NoCarException {
		for (ParkPlace parkPlace : parkPlaceSet) {
			if (parkPlace.getParkedCarList().containsKey(pp)) {
				return parkPlace.getParkedCarList().remove(pp);
			}
		}
		throw new NoCarException("û�д˳� �벦��110��");
	}
	public String reportInfo(){
		/*
		StringBuilder sb=new StringBuilder("\t------reportInfo beg---------------\n");
		for (ParkPlace parkPlace : parkPlaceSet) {
			sb.append("\t\t++ͣ������ţ�"+parkPlace.getParkNO()+"\t��λ������"+parkPlace.getMaxParkingNum()+"\t��λ����"+parkPlace.getAvailableNum()+"\n");
		}
		sb.append("\t------reportInfo end---------------\n\n");
		*/
		StringBuilder sb=new StringBuilder();
		for (ParkPlace parkPlace : parkPlaceSet) {
			sb.append(parkPlace.toString()+"\n");
		}
		return sb.toString();
	}
	/**
	 * @return ��ȡ�ܵ�ͣ��λ������
	 */
	public Integer getMaxParkingNum(){
		int count = 0;
		for (ParkPlace pp : parkPlaceSet) {
			count += pp.getMaxParkingNum();
		}
		return count;
	}

	public void print(){
		int i=0;
		System.out.println("======= begin =============");
		for (ParkPlace parkPlace : parkPlaceSet) {
			System.out.println((i++)+" GetAvailableNum:"+parkPlace.getAvailableNum());
		}
		System.out.println("======= end =============");
	}
	
	/**
	 * ��ȡ�ճ�λ����ͣ������Ϣ
	 * @return
	 */
	public ParkPlace getMaxAvailableParkPlace(){
		int index=0;
		ParkPlace maxPP=null;
		for (ParkPlace parkPlace : parkPlaceSet) {
			if(maxPP==null){
				maxPP=parkPlace;
			}else{
				if(maxPP.getAvailableNum()<parkPlace.getAvailableNum()){
					maxPP=parkPlace;
				}
			}
		}
		return maxPP;
	}
	
	/**
	 * ���������ճ�λ����ͣ������������е�ͣ������û�п�λ�ӣ������׳�NoPlaceException�쳣��Ϣ
	 * @param c
	 * @return
	 * @throws NoCarException
	 * @throws NoPlaceException
	 */
	 public Ticket parking(Car c)throws NoCarException,NoPlaceException{
	    	if(c==null){
	    		 throw new NoCarException("������Ϊ��");
	    	}
	    	ParkPlace maxPP=getMaxAvailableParkPlace();
	    	return maxPP.parking(c);
	  }
	 
	public  HashSet<ParkPlace> getParkPlaceSet(){
			return this.parkPlaceSet;
	}
	
	public Park(List<ParkPlace> parkPlaceList) {
		if(parkPlaceList!=null){
			for(ParkPlace pp:parkPlaceList){
				parkPlaceSet.add(pp);
			}
		}
	}
}

