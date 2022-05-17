/* 
 * Activity 1.1.5
 */
public class FivePlanetTravel
{
  public static void main(String[] args)
  {
    // theplanets.org average distance from earth to the planets
    int mercury = 56974146;
    int venus = 25724767;
    int mars = 48678219;
    int jupiter = 390674710;
    int saturn = 792248270;

    // number of planets to visit
    int numPlanets = 5;

    // speed of light and our speed
    int lightSpeed =  670616629;
    lightSpeed /= 10;

    // widening
    double total = mercury + venus + mars + jupiter + saturn;
    System.out.println(total);
    System.out.println(venus);
    total/=lightSpeed;
    System.out.println("Travel time to planets: " + total);
    
    //casting
    System.out.println("Travel time to planets: " + (mercury/(double)lightSpeed + venus/(double)lightSpeed + mars/(double)lightSpeed + jupiter/(double)lightSpeed + saturn/(double)lightSpeed));
    
    //average
    int average = (int)(total/numPlanets+.5); //.5 rounds it up
    System.out.println(" ,.Average time to planets: " + average);
  }
}
