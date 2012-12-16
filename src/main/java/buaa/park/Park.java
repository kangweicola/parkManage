package main.java.buaa.park;

import java.util.HashSet;
import java.util.List;

import main.java.buaa.exception.NoCarException;
import main.java.buaa.exception.NoPlaceException;


/**
 * 
 * @author 康威
 */
public class Park {
	
	
	private HashSet<ParkPlace> parkPlaceSet=new HashSet<ParkPlace>();
	
	/**
	 * @return 获取总的当前可以使用的停车位的总数
	 */
	public Integer getAvailableParkNum() {
		int count = 0;
		for (ParkPlace parkPlace : parkPlaceSet) {
			count += parkPlace.getAvailableNum();
		}
		return count;
	}
	
	/**
	 * 获取总的当前已经使用的停车位的总数
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
		throw new NoCarException("没有此车 请拨打110！");
	}
	public String reportInfo(){
		/*
		StringBuilder sb=new StringBuilder("\t------reportInfo beg---------------\n");
		for (ParkPlace parkPlace : parkPlaceSet) {
			sb.append("\t\t++停车场编号："+parkPlace.getParkNO()+"\t车位总数："+parkPlace.getMaxParkingNum()+"\t空位数："+parkPlace.getAvailableNum()+"\n");
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
	 * @return 获取总的停车位的总数
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
	 * 获取空车位最多的停车场信息
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
	 * 将车听到空车位最多的停车场，如果所有的停车场都没有空位子，将会抛出NoPlaceException异常信息
	 * @param c
	 * @return
	 * @throws NoCarException
	 * @throws NoPlaceException
	 */
	 public Ticket parking(Car c)throws NoCarException,NoPlaceException{
	    	if(c==null){
	    		 throw new NoCarException("车不能为空");
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

