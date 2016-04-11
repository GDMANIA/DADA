package com.imooc;

public abstract class Car {
	private int carNum;
	private String carName;
	private int rentMoney;
	private int carCapacity;
	private int carCarrycargo;
	
	public int getCarNum(){
		return carNum;
	}
	public void setCarNum(int carNum){
		this.carNum=carNum;
	}
	public String getCarName(){
		return carName;
	}
	public void setCarName(String carName){
		this.carName=carName;
	}
	public int getRentMoney(){
		return rentMoney;
	}
	public void setRentMoney(int rentMoney){
		this.rentMoney=rentMoney;
	}
	public int getCarCapacity(){
		return carCapacity;
	}
	public void setCarCapacity(int carCapacity){
		this.carCapacity = carCapacity;
	}
	public int getCarCarryCargo(){
		return carCarrycargo;
	}
	public void setCarCarryCargo(int carCarrycargo){
		this.carCarrycargo=carCarrycargo;
	}
}











