package com.chapter5;

public class MarsRobotRevision {
	String status;
	int speed;
	float temperature;

	MarsRobotRevision() {
		this.speed = 5;
		this.status = "normal";
		this.temperature = 25.0f;
	}

	MarsRobotRevision(String str, int sp, float temp) {
		this.speed = sp;
		this.status = str;
		this.temperature = temp;
	}

	void checkTemperature() {
		if (temperature < -80) {
			status = "returning home";
			speed = 5;
		}
	}

	public void showAttributes() {
		System.out.println("Status:" + status);
		System.out.println("Speed:" + speed);
		System.out.println("Temperature:" + temperature);
	}
}