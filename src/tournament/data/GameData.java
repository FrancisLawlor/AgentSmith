package tournament.data;

import java.util.ArrayList;

public class GameData {
	private String name;
	private ArrayList<AdditionalParameterData> additionalParameters;
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<AdditionalParameterData> getAdditionalParameters() {
		return this.additionalParameters;
	}
}
