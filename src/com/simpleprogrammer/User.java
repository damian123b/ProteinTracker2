package com.simpleprogrammer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class User { //na razie nie ma konstruktororw!
	
	private int id;
	private String name;
	private ProteinData proteinData;// = new ProteinData();
	private List<UserHistory> history = new ArrayList<>();
	
	public User() {
		this.proteinData = new ProteinData();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProteinData getProteinData() {
		return proteinData;
	}
	public void setProteinData(ProteinData proteinData) {
		this.proteinData = proteinData;
		proteinData.setUser(this);
	}
	public Collection<UserHistory> getHistory() {
		return history;
	}
	public void setHistory(List<UserHistory> history) {
		this.history = history;
	}
	@Override
	public String toString() {
		return "I am "+name+", id = "+id;
	}
	
	public void addHistory(UserHistory historyItem) {
		historyItem.setUser(this);
		this.history.add(historyItem);
	}
}
