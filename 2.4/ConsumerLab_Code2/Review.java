import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.io.*;

/**
 * Class that contains helper methods for the Review Lab
 **/
public class Review {
  
  private static HashMap<String, Double> sentiment = new HashMap<String, Double>();
  private static ArrayList<String> posAdjectives = new ArrayList<String>();
  private static ArrayList<String> negAdjectives = new ArrayList<String>();
 
  
  private static final String SPACE = " ";
  
  
  static{
    try {
      Scanner input = new Scanner(new File("cleanSentiment.csv"));
      while(input.hasNextLine()){
        String[] temp = input.nextLine().split(",");
        sentiment.put(temp[0],Double.parseDouble(temp[1]));
        //System.out.println("added "+ temp[0]+", "+temp[1]);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing cleanSentiment.csv");
    }
  
  
  //read in the positive adjectives in postiveAdjectives.txt
     try {
      Scanner input = new Scanner(new File("positiveAdjectives.txt"));
      while(input.hasNextLine()){
        String temp = input.nextLine().trim();
        System.out.println(temp);
        posAdjectives.add(temp);
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
    }   
 
  //read in the negative adjectives in negativeAdjectives.txt
     try {
      Scanner input = new Scanner(new File("negativeAdjectives.txt"));
      while(input.hasNextLine()){
        negAdjectives.add(input.nextLine().trim());
      }
      input.close();
    }
    catch(Exception e){
      System.out.println("Error reading or parsing negativeAdjectives.txt");
    }   
  }
  
  /** 
   * returns a string containing all of the text in fileName (including punctuation), 
   * with words separated by a single space 
   */
  public static String textToString( String fileName )
  {  
    String temp = "";
    try {
      Scanner input = new Scanner(new File(fileName));
      
      //add 'words' in the file to the string, separated by a single space
      while(input.hasNext()){
        temp = temp + input.next() + " ";
      }
      input.close();
      
    }
    catch(Exception e){
      System.out.println("Unable to locate " + fileName);
    }
    //make sure to remove any additional space that may have been added at the end of the string.
    return temp.trim();
  }
  
  /**
   * @returns the sentiment value of word as a number between -1 (very negative) to 1 (very positive sentiment) 
   */
  public static double sentimentVal( String word )
  {
    try
    {
      return sentiment.get(word.toLowerCase());
    }
    catch(Exception e)
    {
      return 0;
    }
  }
  
  /**
   * Returns the ending punctuation of a string, or the empty string if there is none 
   */
  public static String getPunctuation( String word )
  { 
    String punc = "";
    for(int i=word.length()-1; i >= 0; i--){
      if(!Character.isLetterOrDigit(word.charAt(i))){
        punc = punc + word.charAt(i);
      } else {
        return punc;
      }
    }
    return punc;
  }

      /**
   * Returns the word after removing any beginning or ending punctuation
   */
  public static String removePunctuation( String word )
  {
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(0)))
    {
      word = word.substring(1);
    }
    while(word.length() > 0 && !Character.isAlphabetic(word.charAt(word.length()-1)))
    {
      word = word.substring(0, word.length()-1);
    }
    
    return word;
  }
 
  /** 
   * Randomly picks a positive adjective from the positiveAdjectives.txt file and returns it.
   */
  public static String randomPositiveAdj()
  {
    int index = (int)(Math.random() * posAdjectives.size());
    return posAdjectives.get(index);
  }
  
  /** 
   * Randomly picks a negative adjective from the negativeAdjectives.txt file and returns it.
   */
  public static String randomNegativeAdj()
  {
    int index = (int)(Math.random() * negAdjectives.size());
    return negAdjectives.get(index);
    
  }
  
  /** 
   * Randomly picks a positive or negative adjective and returns it.
   */
  public static String randomAdjective()
  {
    boolean positive = Math.random() < .5;
    if(positive){
      return randomPositiveAdj();
    } else {
      return randomNegativeAdj();
    }
  }


  /*ACTIVITY 1*/
  public static void main(String[] args)
  {
    //test sentimentVal method from Activity 1
    System.out.println("Sentiment val of \"happily\" is: " + sentimentVal("happily"));
    System.out.println("Sentiment val of \"sad\" is: " +sentimentVal("sad"));
    System.out.println("Sentiment val of \"great\" is: " +sentimentVal("great"));

    //test totalSentiment method from Activity 2
    System.out.println("Total sentiment of \"SimpleReview.txt\" is: " +totalSentiment("SimpleReview.txt"));

    //test starRating method from Activity 2
    System.out.println("Star Rating of \"SimpleReview.txt\" is: " +starRating("SimpleReview.txt"));


  }

  /*ACTIVITY 2 METHOD*/

  /** Method to determine a total Sentiment value based on the sentiment value of all the words 
   *  in a review found in a file.
   * 
   *  preconditions: txt file must exist
   *  postconditions: txt file remains intact and a total sentiment value is returned
   * 
   * @param fileName - the name of the txt file with the review
   * @return the total sentiment value as a double
   */
  public static double totalSentiment(String fileName)
  {
    double total = 0.0;
    //textToString method was provided. It turns a txt file into a String so we can use String methods.
    String review = textToString(fileName);
    int startIndex=0;
    int endIndex=review.indexOf(" "); //returns index of first space
    String word;
    int i=0;
    String tempWord="";

    while(i<review.length()) //iterate through entire review, parsing each word
    {
      word=review.substring(startIndex,endIndex); //get each individual word
      
      //remove punctuation
      for(int j=0; j<word.length(); j++)
      {
        if (Character.isAlphabetic(word.charAt(j)))
        {
          tempWord+=word.charAt(j);
        }
      }
      word=tempWord;
      tempWord=""; //reset tempWord

      total+=sentimentVal(word); //add to total
      //System.out.println(word);//FOR TESTING PURPOSES
      //System.out.println(total);//FOR TESTING PURPOSES

      startIndex=endIndex+1; //update startIndex
      endIndex=review.indexOf(" ", endIndex+1); //update endIndex

      if (endIndex!=-1 && startIndex!=-1)
      {
        i = endIndex;
      }
      else
      {
        i = review.length(); //break
      }
    }
    //get last word
    word=review.substring(startIndex); //get last word
    //remove punctuation
    for(int j=0; j<word.length(); j++)
    {
      if (Character.isAlphabetic(word.charAt(j)))
      {
        tempWord+=word.charAt(j);
      }
    }
    word=tempWord;
    total+=sentimentVal(word); //add to total

    return total;
  }

  /*ACTIVITY 2 METHOD*/

  /** Method to determine the star rating of a review.
   * 
   *  preconditions: txt file must exist
   *  postconditions: txt file remains intact and a star value is returned
   * 
   * @param fileName - the name of the txt file with the review
   * @return the star value
   */
  public static int starRating(String fileName)
  {
    int starRating=0;
    String review = textToString(fileName);
    double totalSentiment = totalSentiment(fileName);
    if (totalSentiment<0 && totalSentiment>-5)
    {
      starRating=1;
    }
    else if (totalSentiment<5)
    {
      starRating=2;
    }
    else if(totalSentiment<10)
    {
      starRating=3;

    }
    else //everything greater than 15
    {
      starRating=4;
    }
    return starRating;
  }

  /*ACTIVITY 3 METHOD*/

  /** Method to write a fake review.
   * 
   *  preconditions: txt file with reivew must exist, negative and positive adjective txt files must exist
   *  postconditions: a String with the fake review is returned
   * 
   * @param fileName - the name of the txt file with the review that has adjectives denoted by at *
   * @return the fake review as a String
   */
  public static String fakeReview(String fileName)
  {
    String fake = "";

    return fake;
  }
}

