class KMPString
{
	void kmpSearch(String pattern, String text)
	{
		int M = pattern.length();
		int N = text.length();

		//lps for holding longest values of patterns
		int lps[] = new int[M];
		int j=0;

		computeLPSArray(pattern, M, lps);

		int i= 0;
		while(i < N)
		{
			if(pattern.charAt(j) == text.charAt(i))
			{
				i++;
				j++;
			}

			if(j == M)
			{
				System.out.println("Pattern Found at index "+ (i-j));
				j = lps[j-1];
			}

			//mismatch after j matches
			else if(i <N && pattern.charAt(j) != text.charAt(i))
			{
				// do not match lps[0...lps[j-1]] characters they will match any way
				if(j != 0)
					j = lps[j-1];
				else
					i = i+1;
			}
		}
	}

	void computeLPSArray(String pattern, int M, int lps[])
	{
		//length of previous longest prefix suffix
		int len = 0;
		int i = 1;
		lps[0] = 0;  // lps[0] is always 0

		//loop calculates lps[i] for i=1 to M-1
		while(i<M)
		{
			if(pattern.charAt(i) == pattern.charAt(len))
			{
				len++;
				lps[i] = len;
				i++;
			}
			else
			{
				//pat[i] != pat[len]
				if(len != 0)
				{
					len = lps[len-1];
					// also note we do not increment i here
				}
				else
				{
					lps[i] = len;
					i++;
				}

			}
		}

	}
	public static void main(String args[])
	{
		KMPString kmp = new KMPString();
		String text = "ABABDABACDABABCABAB";
		String pattern = "ABABCABAB";
		kmp.kmpSearch(pattern, text);
	}
}