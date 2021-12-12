package model.data;

import java.util.HashMap;

public class Parameters {
	
	HashMap<Boolean[], Float> parametre;
	
	public Parameters(int number_parents, float[] values) {
		assert(values.length == number_parents);
		parametre = new HashMap<Boolean[], Float>();
		for (int i = 0; i < values.length; i++) {
			Boolean[] tmp = new Boolean[values.length];
			String binKey = Integer.toBinaryString(i);
			for (int j = 0; j < number_parents - binKey.length(); j++) {
				binKey = "0".concat(binKey);
			}
			for (int j = 0; j < binKey.length(); j++) {
				tmp[j] = (binKey.charAt(j) == '1') ? true : false;
			}
			parametre.put(tmp, values[i]);
		}
	}
	
	public Parameters(int number_parents) {
		parametre = new HashMap<Boolean[], Float>();
		for (int i = 0; i < number_parents; i++) {
			Boolean[] tmp = new Boolean[number_parents];
			String binKey = Integer.toBinaryString(i);
			for (int j = 0; j < number_parents - binKey.length(); j++) {
				binKey = "0".concat(binKey);
			}
			for (int j = 0; j < binKey.length(); j++) {
				tmp[j] = (binKey.charAt(j) == '1') ? true : false;
			}
			parametre.put(tmp, (float) (1.0/number_parents));
		}
	}

}
