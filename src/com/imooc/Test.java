package com.imooc;

import java.util.*;

public class Test {
public void isNeed(){
	System.out.println("�Ƿ�ʹ�������⳵��1�ǣ�0��");
	Scanner kb=new Scanner(System.in);
	int select=kb.nextInt();
	if(select==0){
		System.out.println("�˳�ϵͳ...");
	}else{
		System.out.println("��ӭʹ�������⳵ϵͳ");
		System.out.println("�����⳵�����ͼ����Ŀ��");
		Car[] carForRentList={new PassengerCar(1,"�µ�A4",500,4),new PassengerCar(2,"���Դ�6",400,4),new Pickup(3,"Ƥ��",450,4,2),new PassengerCar(4,"����",800,20),new Trunk(5,"�ɻ���",400,4),new Trunk(6,"��ά��",1000,20)};
		System.out.println("��ţ�"+"\t"+"������"+"\t"+"�۸�"+"\t"+"\t"+"�ؿ�����"+"\t"+"�ػ�����");
		for(Car car:carForRentList){
			System.out.println(car.getCarNum()+"\t"+car.getCarName()+"\t"+car.getRentMoney()+"/��"+"\t"+"\t"+car.getCarCapacity()+"\t"+car.getCarCarryCargo()+"/��");
		}
		System.out.println("�������⳵������");
		int totalNum=kb.nextInt();
		while(totalNum<1||totalNum>6){
			System.out.println("�������������һ��1��6֮�������");
			System.out.println("�������⳵������");
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
			System.out.println("�������"+i+"����");
			int num=kb.nextInt();
			while(num<1||num>6){
				System.out.println("�������������һ��1��6֮�������");
				System.out.println("�������"+i+"����");
				num=kb.nextInt();
			}
			repeat[i-1]=num;
			while(repeatOrNot(i,num,repeat)){
				System.out.println("�����ظ����������������룺");
				num=kb.nextInt();
			}
			if(carForRentList[num-1] instanceof PassengerCar){
				rentPassengercar.add(carForRentList[num-1].getCarName());
			}else if(carForRentList[num-1] instanceof Trunk){
				rentTrunk.add(carForRentList[num-1].getCarName());
			}else{
				rentPickup.add(carForRentList[num-1].getCarName());
				
			}
			System.out.println("�ɹ����"+carForRentList[num-1].getCarName());
			System.out.println("�������"+i+"�������⳵����");
			int day=kb.nextInt();
			totalPassenger+=carForRentList[num-1].getCarCapacity();
			totalCarry+=carForRentList[num-1].getCarCarryCargo();
			totalMoney+=carForRentList[num-1].getRentMoney()*day;
			}
			System.out.println("********�����˵ĳ���********");
			for(String pList:rentPassengercar){
				System.out.println(pList+"");
				
			}
			System.out.println("********���ػ��ĳ���********");
			for(String TList:rentTrunk){
				System.out.println(TList+"");
			}
			System.out.println("********�ȿ��ػ��ֿ����˵ĳ���********");
			for(String PickList:rentPickup){
				System.out.println(PickList+"");
			}
			System.out.printf("���ؿ�������%4d��",totalPassenger);
			System.out.printf("\t"+"���ػ�����%4d��",totalCarry);
			System.out.printf("\n"+"Ӧ����%4dԪ",totalMoney);
			System.out.println("\n"+"��ӭ�ٴι��٣�");
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
