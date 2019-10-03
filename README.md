# READ ME
Some methods to return longest and shortest words in a sentence.

**Assumptions:**

I assumed that punctuation would not be a part of words. I used a regex filter and removed all punctuation, and then I split the words by a greedy space regex. I originally used a single space " " but decided to make it more robust when I tested multiple spaces as a test case. 

I didn't really understand how a method could return both a String and an integer, so I made the methods return just a String. Because java has a .length() operation, I figured that would work well enough to call on each result. I could have also created a simple class with a String and an int but that seems to be overkill. 

I figured it makes most sense to keep all methods and tests in one file because this is such a simple project. But I could have broken it out into individual classes with test classes. 

**How to run**
Clone locally into a folder and then open the folder as a Java Project through an IDE such as Eclipse. Right click and Run as JUnit Test. All 9 tests should run and pass. There will be some output in the Console as well. 

