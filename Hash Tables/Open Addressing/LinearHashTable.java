class HashItem
{
	String key;
	String data;
	boolean deleted;

	HashItem(String key, String data)
	{
		this.key=key;
		this.data=data;
		deleted=false;
	}

	void setDeleted()
	{
		deleted=true;
	}

	boolean isDeleted()
	{
		return deleted;
	}

	String getKey()
	{
		return key;
	}

	String getData()
	{
		return data;
	}
}

class LinearHastTable
{
	static final int SIZE = 10; 									// size of hash table
	HashItem[] table = new HashItem[SIZE];


	int code(String key)
	{
		return (key.hashCode())%SIZE;
	}

	boolean add(String key, String data)
	{
		int probe;												// for iterating through hash table
		int code = code(key);									// get a hash table index for the key
		if(table[code]==null || table[code].isDeleted())		// if that hashtable index is empty and no object resides inside the table
		{
			// this is the case when hash table index is empty
			table[code]= new HashItem(key, data);				// insert the code directly and set the probe to -1 for searching hash table index
			probe = -1;
		}
		else                                                  
		{
			// this is the case when the hash table index is not empty
			if(code==(table.length-1))							// if code reaches the end of the table
				probe=0;										// start from first
			else
				probe=code+1;									// move probe one index ahead
		}

		while(probe!=-1 && probe!=code)							// continue the loop unitll 
		{
			if(table[probe]==null || table[probe].isDeleted())
			{
				table[probe] = new HashItem(key, data);
				probe = -1;
			}
			else
			{
				if(probe==(table.length-1))
					probe=0;
				else 
					probe = probe+1;

			}

		}

		if(probe==-1)										// if probe == -1 means unable to add item in hash table
			return false;
		else 												// else added successfully
			return true;
	}

	String retrive(String key)
	{
		int probe;
		int code = code(key);

		if(table[code]==null)								// if hash table index is empty means to item in the table
			return null;
		else if(table[code].getKey().equals(key))			// if table's key equals to key entered by users
			return table[code].getData();
		else 
		{
			if(code==(table.length-1))
				probe = 0;
			else 
				probe = code +1;
		}

		while(probe!=1 && probe!=code)
		{
			if(table[probe]==null)
				return null;
			else if(table[probe].getKey().equals(key))
				return table[probe].getData();
			else 
			{
				if(probe==(table.length-1))
					probe=0;
				else 
					probe = probe+1;
			}
		}
		return null;

	}

	boolean delete(String key)
	{
		int probe;
		int code = code(key);

		if(table[code]==null)
			return false;
		else if(table[code].getKey().equals(key))
		{
			table[code].setDeleted();
			probe = -1;
			return true;
		}
		else
		{
			if(code==(table.length-1))
				probe = 0;
			else
				probe = code+1;
		}

		while(probe!=-1 && probe!=code)
		{
			if(table[probe]==null)
				return false;
			else if(table[probe].getKey().equals(key))
			{
				table[code].setDeleted();
				probe=-1;
				return true;
			}
			else
			{
				if(probe == (table.length-1))
					probe = 0;
				else 
					probe = probe + 1;

			}

		}
		return false;
	}

	public static void main(String[] args) 
	{
		LinearHastTable linear = new LinearHastTable();
		linear.add("zack", "Sachin");
		linear.add("umi", "Utkarsha");
		System.out.println(linear.retrive("umi"));
		boolean bool = linear.delete("zack");
		if(bool)
			System.out.println("Deleted");
		
	}
}