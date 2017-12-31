class BruteForce
{
	static void search(String text, String pattern)
	{
		int M = pattern.length();
		int N = text.length();

		// a loop to slide pattern one by one
		for(int i=0; i<= N-M; i++)
		{
			int j;
			// for current index i check for pattern match
			for(j=0; j<M; j++)
			{
				if(text.charAt(i+j) != pattern.charAt(j))
					break;
			}
				if(j==M)
					System.out.println("Pattern found at index "+i);
			
		}
	}

	public static void main(String args[])
	{
		String text = "AABAACAADAABAAABAA";
		String pattern = "AABA";

		search(text, pattern);
	}
}