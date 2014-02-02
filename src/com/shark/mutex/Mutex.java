package com.shark.mutex;

public class Mutex extends Thread {
	private boolean interested[] = new boolean[2];
	private int turn;
	 
	void enterRegion(int threadId)
	{
	    int other = 1 - threadId;                    
	    interested[threadId] = true;                 
	    turn = other;                                
	 
	    while (turn == other && interested[other]);
	}
	 
	void leaveRegion(int threadId)
	{
	    interested[threadId] = false;
	}
}
