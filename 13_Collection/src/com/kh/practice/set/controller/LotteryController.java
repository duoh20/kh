package com.kh.practice.set.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

import com.kh.practice.set.model.compare.SortedLottery;
import com.kh.practice.set.model.vo.Lottery;

public class LotteryController {
	private HashSet lottery = new HashSet (); //추첨 대상을 담음
	private HashSet  win = new HashSet (); //당첨 대상을 담음
	
	public boolean insertObject(Lottery l) {
		boolean result = lottery.add(l);
		return result;
	}
	
	public boolean deletObject(Lottery l) {
		boolean result = lottery.remove(l);
		if (win != null && result) {
				win.remove(l);
		}
		return result;
	}
	
	public HashSet winObject() {
		ArrayList list = new ArrayList(lottery);
		
		while(win.size() != 4) {
			int pickWinner = (int)(Math.random() * list.size());
			win.add(list.get(pickWinner));
		}
		return win;
	}
	
	public TreeSet sortedWinObject(){
		TreeSet ts = new TreeSet(new SortedLottery());
		ts.addAll(win);
		return ts;
	}
	
	public boolean searchWinner(Lottery l) {
		boolean result = win.contains(l);
		return result;
	}
}
