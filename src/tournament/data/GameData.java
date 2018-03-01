package tournament.data;

import java.util.ArrayList;

public class GameData {
	private String name;
	private ArrayList<AdditionalParameterData> additionalParameters;
	
	public GameData(String name, ArrayList<AdditionalParameterData> additionalParameters) {
		this.name = name;
		this.additionalParameters = additionalParameters;
	}

	public String getName() {
		return this.name;
	}
	
	public ArrayList<AdditionalParameterData> getAdditionalParameters() {
		return this.additionalParameters;
	}
}
