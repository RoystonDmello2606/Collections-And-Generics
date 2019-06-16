import java.util.Arrays;

public class CharacterFrequency {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] counts = FrequencyCounter.count("Hello from the other side");
		
		PatternPrinter.print(counts);
	}
}

class FrequencyCounter{
	public static int[] count(String input) {
		String newInput = input.toLowerCase();
		int[] counts = new int[26];
		
		for(char c : newInput.toCharArray()) {
			int index = (int)c - 97;
			if (index >= 0 && index <= 25) {
				counts[index] = counts[index] + 1;
			}
		}
	
		return counts;
	}
}

class PatternPrinter{
	public static void print(int[] counts) {
		for(int i = 0; i < 26; ++i) {
			System.out.print((char)(i + 97) + "\t");
			for(int j = 0; j < counts[i]; ++j) {
				System.out.print("#");
			}
			System.out.println();
		}
	}
}
