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
		
		String[] words = splitUpSentence(sentence);
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
	//remove all punctuation using regex, then split words based on spaces.
	
	private static String[] splitUpSentence(String sentence) {
		return sentence.replaceAll("\\p{P}", "").split("\\s+");
		
	}
	public static String minLength(String sentence) {
		String[] words = splitUpSentence(sentence);
		String minLengthWord = "";
		int minLength = Integer.MAX_VALUE;
		for(String word : words) {
			if(word.length() < minLength) {
				minLengthWord = word;
				minLength = word.length();
			}
		}
		System.out.println("The min length word is: " + minLengthWord);
		System.out.println("Min Length word length is: "+ minLength);
		return minLengthWord;
	}
	
	@Test
	public void testMaxEmptySentence() {
		String testWord = "";
		String result = maxLength(testWord);
		Assert.assertEquals(result, "");
	}
	
	@Test
	public void testMaxPeriod() {
		String testWord = "The quick brown. fox jumped over the lazy dog.";
		String result = maxLength(testWord);
		Assert.assertEquals(result, "jumped");
		Assert.assertEquals(result.length(), 6);
	}
	
	@Test
	public void testMaxMultipleSpaces() {
		String testWord = "Many     spaces! between these words.";
		String result = maxLength(testWord);
		Assert.assertEquals(result, "between");
		Assert.assertEquals(result.length(), 7);
	}
	
	@Test
	public void testMaxOneWord() {
		String testWord = "Pneumonoultramicroscopicsilicovolcanoconiosis";
		String result = maxLength(testWord);
		Assert.assertEquals(result, "Pneumonoultramicroscopicsilicovolcanoconiosis");
		Assert.assertEquals(result.length(), 45);
	}
	@Test
	public void testMinEmptySentence() {
		String testWord = "";
		String result = minLength(testWord);
		Assert.assertEquals(result, "");
		Assert.assertEquals(result.length(), 0);
	}
	
	@Test
	public void testMinPeriod() {
		String testWord = "The quick brown. fox jumped over the lazy dog.";
		String result = minLength(testWord);
		Assert.assertEquals(result, "The");
		Assert.assertEquals(result.length(), 3);
	}
	
	@Test
	public void testMinMultipleSpaces() {
		String testWord = "Many    spaces   between  these words.";
		String result = minLength(testWord);
		Assert.assertEquals(result, "Many");
		Assert.assertEquals(result.length(), 4);
	}
	
	@Test
	public void testMinMultiplePunct() {
		String testWord = "Why% is the sky! blue?. Not!@#$%^&*() sure about that.";
		String result = minLength(testWord);
		Assert.assertEquals(result, "is");
		Assert.assertEquals(result.length(), 2);
	}
	
	@Test
	public void testMinOneWord() {
		String testWord = "Pneumonoultramicroscopicsilicovolcanoconiosis";
		String result = minLength(testWord);
		Assert.assertEquals(result, "Pneumonoultramicroscopicsilicovolcanoconiosis");
		Assert.assertEquals(result.length(), 45);
	}

}