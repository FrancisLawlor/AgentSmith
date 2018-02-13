package agents.info;

public class AgentInfo {
	private String id;
	private String strategy;
	
	public AgentInfo(String id, String type) {
		this.id = id;
		this.strategy = type;
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getStrategy() {
		return this.strategy;
	}
}
