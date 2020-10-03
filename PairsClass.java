import java.util.HashMap;
import java.util.HashSet;

public class PairsClass {
	public static void main(String[] args)
	{
		int[] arr = new int[]{1,1,1}; // creating object of array 
		System.out.println("Number of pairs: "+ getPairs(arr, 2)); // calling the function getpair(arr,2) where arr and 2 are passed arguments
	}

	public static int getPairs(int[] a, int k)  //function definition
	{
	 int numPairs = 0; // variable that stores the pair
	    HashMap<Integer, Integer> hs = new HashMap<Integer, Integer>();
	    HashSet<Integer> seen = new HashSet<Integer>();
	    hs.put(a[0],1);
	    for(int i=1; i<a.length; i++)
	        {	        
	     		  
	     		if(!hs.containsKey(a[i]))
	               {
	                hs.put(a[i],1);
	            }
	            else //Update value to store that a[i] repeated
	                {
	                int curCount = hs.get(a[i]);
	                curCount++;
	                hs.put(a[i],curCount);
	            }
	        }
	    System.out.println(hs);
	    for(int i=0;i<a.length; i++)
	    {
	    	if(hs.containsKey(k-a[i]) && !seen.contains(a[i]))
            {
                if(k-a[i]!=a[i])
                {	
                	//Multiply frequencies to record all combinations
                	numPairs+= (hs.get(k-a[i]) * hs.get(a[i]));
                	//Add number and it's compliment to seen to skip next time you see it
                	seen.add(a[i]);
                	seen.add(k-a[i]);
                }
                else //Number == compliment
                {
                	//If the number occurs more than twice, use combinations
                	if(hs.get(a[i])>2)
                		numPairs+= combination(hs.get(a[i]),2);
                	else //Else just add the 1 pair
                		numPairs+= (hs.get(a[i])-1);
                	seen.add(a[i]);
                }
            } 
	    }
	    return numPairs;
}
	public static int combination(int n, int k)
	{
	    return permutation(n) / (permutation(k) * permutation(n - k));
	}

	public static int permutation(int i) //fuction calculating factorial of number i
	{
	    if (i == 1)
	    {
	        return 1; // base condition 
	    }
	    return i * permutation(i - 1); //recursive call
	}
}
