package tournament.data;

public class AdditionalParameterData {
	private String name;
	private String value;
	
	public AdditionalParameterData(String name, String value) {
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return this.name;
	}
	
	public String getValue() {
		return this.value;
	}
}
