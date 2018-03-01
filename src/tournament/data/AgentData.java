package tournament.data;

public class AgentData {
	private StrategyData strategy;
	private int amount;
	
	public AgentData(StrategyData strategy, int amount) {
		this.strategy = strategy;
		this.amount = amount;
	}
	
	public StrategyData getStrategyData() {
		return this.strategy;
	}

	public int getAmount() {
		return this.amount;
	}
}
