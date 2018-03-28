package gui.utils;

import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import games.score.RoundScoreRecorder;

public class PhaseDataFormatter {
	public static String formatPhaseDataDisplayString(String phaseDataJSON) {
		Gson gsonUtility = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
				.create();
		
		java.lang.reflect.Type type = new TypeToken<Map<Integer, RoundScoreRecorder>>(){}.getType();
		Map<Integer, RoundScoreRecorder> displayData = gsonUtility.fromJson(phaseDataJSON, type);
		
		StringBuilder displayDataStringBuilder = new StringBuilder();
		for (Integer key: displayData.keySet()) {
			displayDataStringBuilder.append("\n\tRound " + key + ":\n\n");
			displayDataStringBuilder.append("\t\t" + "ID\t\tBid\t\tPayoff\n\n");
			
			for (int i = 0; i < displayData.get(key).getPlayerBids().size(); i++) {
				displayDataStringBuilder.append("\t\t" + i + "\t\t" + displayData.get(key).getPlayerBids().get(i + "") + "\t\t" + displayData.get(key).getPlayerPayoffs().get(i + "") + "\n");
			}
		}
		
		return displayDataStringBuilder.toString();
	}
}
