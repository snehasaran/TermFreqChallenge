PRROJECT TITLE:
Write a program that takes as input a set of documents and a list of words, and returns the document with the highest TF score for each word and the TF score for that word in that document.  To break the document into words, you can strip out punctuation, split by whitespace, and convert everything to lowercase.


GETTING STARTED:
1. Download the code to a specific folder and cd to that location using command line.
2. Compiling the java file to a .class file : To compile the code, write the following command on cmd line: 
		javac TermFrequency.java
3. Before executing the java file, make sure you've downloaded the input files from the git repo, in a local folder.
4. Execution of the java file: 
		java TermFrequency <Path to Input folder containing all files> <word(s) to search separated by spaces>

	Example 1): Valid Input
		java TermFrequency /Users/Sneha/Documents/WorkSpace_New/TermFreqChallenge/Input this sneha	
	Output: 
		this--> mobydick-chapter2.txt --> 0.008321775
		sneha--> null --> 0.0

	Example 2) Invalid input, path to input folder and words to search arguments missing.
		java TermFrequency
	Output:	
		Enter <path to folder> <atleast one word to find term Index,separate multiple words by spaces>
	


PREREQUISITES:
If the system cannot find javac, check if PATH environment variable isn't set correctly. If javac runs but you get errors, check your Java text. If the program compiles but you get an exception, check the spelling and capitalization in the file name and the class name.

INSTALLING:
1. Download a java version based on your OS: http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

2. Environment variable PATH should be set to point to where the Java binaries have been installed. 
Example, if you use bash as your shell, then you would add the following line to the end of your '.bashrc: export PATH = /path/to/java:$PATH'


DEPLOYMENT:
JRE : 1.7
IDE used to write and test code: Eclipse Kepler

OUTPUT for the given keywords: 
queequeg--> mobydick-chapter4.txt --> 0.006610577
whale--> mobydick-chapter1.txt --> 0.001345895
sea--> mobydick-chapter1.txt --> 0.004486317

The above output is of the format : 
<word> --> <name of the document with the highest TF score for the word>  --> <TF score for that word in that document>

Output is displayed on the command line. We can also write the output to a file, instead of just displaying on command line, based on the requirement.

AUTHOR:
Sneha Saran





