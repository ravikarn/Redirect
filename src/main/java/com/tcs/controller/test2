package java8Examples;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class CopyMapIfValueDoesNotExist
{    public static void main(String s[])
{





	Map<String,String> inputMap1 = new LinkedHashMap<>();
	inputMap1.put("key4", "Hello");
	inputMap1.put("key3", "are");
	inputMap1.put("key7", ".");
	Map<String,String> inputMap2 = new LinkedHashMap<>();
	inputMap2.put("key5", "how");
	inputMap2.put("key6", "are");
	inputMap2.put("key2", "you");

	System.out.println("The resultant map is : " + copyMap(inputMap1, inputMap2));

}


public static Map<String, String> copyMap(Map<String, String> inputMap1, Map<String, String> inputMap2) {

	Map<String,String> mergedMap = new LinkedHashMap<>();

	Map<String,String> outputMap = new LinkedHashMap<>();

	mergedMap.putAll(inputMap1);
	mergedMap.putAll(inputMap2);
	Set<String> valueSet=new HashSet<String>();

	for (Map.Entry<String, String> entry : mergedMap.entrySet()){


		if(!valueSet.contains(entry.getValue())) {
			outputMap.put(entry.getKey(), entry.getValue());
		}


		valueSet.add(entry.getValue());

	}



	System.out.println(mergedMap);

	return outputMap; 
	//Write code here to copy details from one hash map to another, only if the first map does not have that value 
} 
}
