package com.imooc;

import java.util.*;

public class Test {
public void isNeed(){
	System.out.println("是否使用哒哒租车：1是，0否");
	Scanner kb=new Scanner(System.in);
	int select=kb.nextInt();
	if(select==0){
		System.out.println("退出系统...");
	}else{
		System.out.println("欢迎使用哒哒租车系统");
		System.out.println("您可租车的类型及其价目表");
		Car[] carForRentList={new PassengerCar(1,"奥迪A4",500,4),new PassengerCar(2,"马自达6",400,4),new Pickup(3,"皮卡",450,4,2),new PassengerCar(4,"金龙",800,20),new Trunk(5,"松花江",400,4),new Trunk(6,"依维柯",1000,20)};
		System.out.println("编号："+"\t"+"车名："+"\t"+"价格："+"\t"+"\t"+"载客量："+"\t"+"载货量：");
		for(Car car:carForRentList){
			System.out.println(car.getCarNum()+"\t"+car.getCarName()+"\t"+car.getRentMoney()+"/天"+"\t"+"\t"+car.getCarCapacity()+"\t"+car.getCarCarryCargo()+"/吨");
		}
		System.out.println("请输入租车数量：");
		int totalNum=kb.nextInt();
		while(totalNum<1||totalNum>6){
			System.out.println("输入错误！请输入一个1到6之间的整数");
			System.out.println("请输入租车数量：");
			totalNum=kb.nextInt();
		}
		List<String> rentPassengercar=new ArrayList<String>();
		List<String> rentTrunk=new ArrayList<String>();
		List<String> rentPickup=new ArrayList<String>();
		int totalPassenger=0;
		int totalCarry=0;
		int totalMoney=0;
		int[] repeat=new int[totalNum];
		for(int i=1;i<=totalNum;i++){
			System.out.println("请输入第"+i+"辆车");
			int num=kb.nextInt();
			while(num<1||num>6){
				System.out.println("输入错误！请输入一个1到6之间的整数");
				System.out.println("请输入第"+i+"辆车");
				num=kb.nextInt();
			}
			repeat[i-1]=num;
			while(repeatOrNot(i,num,repeat)){
				System.out.println("输入重复车辆！请重新输入：");
				num=kb.nextInt();
			}
			if(carForRentList[num-1] instanceof PassengerCar){
				rentPassengercar.add(carForRentList[num-1].getCarName());
			}else if(carForRentList[num-1] instanceof Trunk){
				rentTrunk.add(carForRentList[num-1].getCarName());
			}else{
				rentPickup.add(carForRentList[num-1].getCarName());
				
			}
			System.out.println("成功添加"+carForRentList[num-1].getCarName());
			System.out.println("请输入第"+i+"辆车的租车天数");
			int day=kb.nextInt();
			totalPassenger+=carForRentList[num-1].getCarCapacity();
			totalCarry+=carForRentList[num-1].getCarCarryCargo();
			totalMoney+=carForRentList[num-1].getRentMoney()*day;
			}
			System.out.println("********可载人的车有********");
			for(String pList:rentPassengercar){
				System.out.println(pList+"");
				
			}
			System.out.println("********可载货的车有********");
			for(String TList:rentTrunk){
				System.out.println(TList+"");
			}
			System.out.println("********既可载货又可载人的车有********");
			for(String PickList:rentPickup){
				System.out.println(PickList+"");
			}
			System.out.printf("总载客人数：%4d人",totalPassenger);
			System.out.printf("\t"+"总载货数：%4d吨",totalCarry);
			System.out.printf("\n"+"应付金额：%4d元",totalMoney);
			System.out.println("\n"+"欢迎再次光临！");
		}
		
		
	}
	
public boolean repeatOrNot(int i,int num,int []repeat){
	for(int j=0;j<i-2;j++){
		if(repeat[j]==num){
			return true;
		}
	}return false;
}
public static void main(String[] args) {
	Test demo=new Test();
	demo.isNeed();
}
}
