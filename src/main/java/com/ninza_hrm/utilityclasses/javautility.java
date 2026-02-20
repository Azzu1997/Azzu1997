package com.ninza_hrm.utilityclasses;

import java.util.Random;

public class javautility
{
	//A non static method
		public int getRandomno()
		{
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
			}
}
