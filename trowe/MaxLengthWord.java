import org.junit.Assert;
import org.junit.jupiter.api.Test;

class MaxLengthWord {
	
	public static void main(String[] args) {
		String sentence = "The quick brown. fox jumped over the lazy dog.";
		System.out.println(maxLength(sentence));
	}
	
	/*
	 * Write a function that returns the longest word in a sentence and its length
	 * (I'm a bit confused how we can return a String and an int, so considering 
	 * that Java's String class has a .length() method, I'll be using that in test asserts
	 */
	public static String maxLength(String sentence) {
		//remove all punctuation using regex, then split words based on spaces.
		
		sentence = sentence.replaceAll("\\p{P}", "");
		String[] words = sentence.split(" ");
		int maxLength = 0;
		String maxLengthWord = "";
		for(String word: words) {
			if(word.length() > maxLength) {
				maxLengthWord = word;
			}
			maxLength = Math.max(word.length(), maxLength);
			
		}
		System.out.println("The max length word is: " + maxLengthWord);
		System.out.println("Max Length word length is: "+ maxLength);
		return maxLengthWord;
	}
	
	@Test
	public void testEmptySentence() {
		String testWord = "";
		String result = maxLength(testWord);
		Assert.assertEquals(result, "");
	}
	
	@Test
	public void testPeriod() {
		String testWord = "The quick brown. fox jumped over the lazy dog.";
		String result = maxLength(testWord);
		Assert.assertEquals(result, "jumped");
		Assert.assertEquals(result.length(), 6);
	}
	
	@Test
	public void testMultipleSpaces() {
		String testWord = "Many     spaces! between these words.";
		String result = maxLength(testWord);
		Assert.assertEquals(result, "between");
		Assert.assertEquals(result.length(), 7);
	}
	
	@Test
	public void testOneWord() {
		String testWord = "Pneumonoultramicroscopicsilicovolcanoconiosis";
		Assert.assertEquals(maxLength(testWord), "Pneumonoultramicroscopicsilicovolcanoconiosis");
		Assert.assertEquals(maxLength(testWord).length(), 45);
	}
}