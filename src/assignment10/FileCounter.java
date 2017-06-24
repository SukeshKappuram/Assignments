package assignment10;

import java.util.Scanner;
import java.util.StringTokenizer;

public class FileCounter
{
	int wordCount=0,lineCount=0,characterCount=0;
	public FileCounter()
	{
	}

	public void read(Scanner in)
	{
		while(in.hasNextLine())  {
	        lineCount++;
	        String line = in.nextLine();
	        characterCount += line.length();
	        wordCount += new StringTokenizer(line, " ").countTokens();
	    }
	}
	
	public int getWordCount()
	{
		return wordCount;
	}

	public int getLineCount()
	{
		return lineCount;
	}

	public int getCharacterCount()
	{
		return characterCount;
	}

}
