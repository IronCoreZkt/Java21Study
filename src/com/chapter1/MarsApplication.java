package com.chapter1;

public class MarsApplication {
	public static void main(String[] arguments){
		MarsRobot spirit = new MarsRobot();
		MarsRobot opportunity = new MarsRobot();
		spirit.status = "exploring";
		spirit.speed = 2;
		spirit.temperature = -60;
		
		spirit.showAttributes();
		System.out.println("Increasing speed to 3.");
		
		spirit.speed = 3;
		spirit.showAttributes();
		System.out.println("Changing temperature to -90.");
		spirit.temperature = -90;
		spirit.showAttributes();
		System.out.println("Checking the temperature.");
		spirit.checkTemperature();
		spirit.showAttributes();
		
		System.out.println("---另外一位靓仔机器人---");
		opportunity.speed = 5;
		opportunity.status = "Running like a dog";
		opportunity.temperature = -76;
		opportunity.showAttributes();
		
	}
}
