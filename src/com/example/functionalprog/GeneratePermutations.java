package com.example.functionalprog;

import java.util.HashSet;
import java.util.Set;

public class GeneratePermutations {

	public static void main(String args[]){

		//System.out.println(new GeneratePermutations().permWithRecursion("ABCD"));

		System.out.println(new GeneratePermutations().permWithoutRec("ABCD"));
	}
	
	Set<String> permWithRecursion(String s){
		Set<String> result = new HashSet<>();
		if(s.length() == 1){
			result.add(s);
			return result;
		}
		char c = s.charAt(0);
		// Rest of the string
		String excludeStr = s.substring(1);
		Set<String> words = permWithRecursion(excludeStr);
		
		// merge with the last character
		result = merge(words, c);

		return result;
	}


	Set<String> permWithoutRec(String s){
		Set<String> result = new HashSet<>();
		result.add(s.charAt(s.length()-1)+"");

		for( int i= s.length()-2; i>=0; i--){
			char c = s.charAt(i);
		    // merge with the last but one character
			result = merge(result,c);
		}

		return result;
	}

	/**
	 * @param set a result of permutation, e.g. {"ab", "ba"}
	 * @param c    the last character
	 * @return     a merged new set, e.g. {"cab", "acb" ... }
	 */
	public  Set<String> merge(Set<String> list, char c) {
		Set<String> res = new HashSet<>();
		// Loop through all the string in the list
		for (String s : list) {
			// For each string, insert the last character to all possible positions
			// and add them to the new list
			for (int i = 0; i <= s.length(); ++i) {
				String ps = new StringBuffer(s).insert(i, c).toString();
				res.add(ps);
			}       
		}
		return res;   
	}
}
