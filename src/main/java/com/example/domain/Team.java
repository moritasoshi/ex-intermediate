package com.example.domain;

public class Team {

	private String id;
	private String leagueName;
	private String teamName;
	private String headuarters;
	private String inauguration;
	private String history;

	@Override
	public String toString() {
		return "Team [id=" + id + ", leagueName=" + leagueName + ", teamName=" + teamName + ", headuarters="
				+ headuarters + ", inauguration=" + inauguration + ", history=" + history + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getHeaduarters() {
		return headuarters;
	}

	public void setHeaduarters(String headuarters) {
		this.headuarters = headuarters;
	}

	public String getInauguration() {
		return inauguration;
	}

	public void setInauguration(String inauguration) {
		this.inauguration = inauguration;
	}

	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

}
