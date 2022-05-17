/*
 * Activity 1.1.6
 * 
 * Author: Kelly Woldseth
 * Date: 11/19/21
 * Course: AP CSA - Tri 2 2021-2022
 * 
 * Description: Create a program that allows the user to choose any integer, double it, add size, divide it in half, and subtract the number you started with. The answer is always three!
 */

public class NumbersRiddle
{
    public static void main(String[] args)
    {
        //int num = -1; //4, 0, 1, -1
        double num = 1.5; //1.5, -1.5
        System.out.println("You chose " + num);
        
        int original=(int)num; //the answer key casted the doubles to an int, I'm not sure if I like that? We could just use double variables the whole time?
        int x=original;
        x*=2;
        System.out.println("Doubling that value gives " + x);

        x+=6;
        System.out.println("Subtracting 6 from that value gives " + x);

        x/=2;
        System.out.println("Doubling that value by 2 gives " + x);

        x-=original;
        System.out.println("Subtracting the original number gives " + x);

    }

}