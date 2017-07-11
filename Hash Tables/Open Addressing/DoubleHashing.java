// a program for implementing double hashing 
// created by sachin mukherjee
// sachinmukherjee29@gmail.com


class HashItem
{
	String key;
	String data;
	boolean deleted;

	HashItem(String key, String data)
	{
		this.key = key;
		this.data = data;
		deleted = false;
	}

	void setDelete()
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

class DoubleHashing
{
	final static int SIZE = 10;

	HashItem[] table = new HashItem[SIZE];

	int code( String key)
	{
		int code = key.hashCode()%SIZE;
		return code;
	}

	boolean addItem(String key, String data)
	{
		int probe = -1 ;
		int doub = 1;
		int code = code(key);

		if(table[code]==null || table[code].isDeleted())
		{
			table[code] = new HashItem(key, data);
			probe = -1;
			return true;
		}
		else
		{
			int code2 = 1;

			while(probe!=1 && probe!=code)
			{
				code2 = 7 + doub * code;

				if(table[code2]==null)
				{
					table[code2]= new HashItem(key, data);
					probe = -1;
					return true;
				}
				else
				{
					doub++;
				}
			}


		}
		return false;
	}

	String retrieveItem(String key)
	{
		int probe = -1;
		int doub = 1;
		int code = code(key);

		if(table[code]==null)
			return null;

		else if(table[code].getKey().equals(key))
		{
			probe = 0;
			return table[code].getData();
		}
		else
		{
			int code2 = 1;
		   while(probe!=-1 && probe!=code)
			{
				code2 = 7 + doub * code;

				if(table[code2].getKey().equals(key))
				{
					probe = -1;
					return table[code2].getData();
				}
				else
					doub++;
				

			}
		
		}
		return null;

	
	}

	boolean deleteItem(String key)
	{
		int probe = -1;
		int code = code(key);
		int doub = 1;

		if(table[code]==null)
			return false;

		else if(table[code].getKey().equals(key))
		{
			probe = 0;
			table[code].setDelete();
			return true;
		}
		else
		{
			 int code2 = 1;

			while(probe!=code)
			{
				code2 = 7 + doub * code;

				if(table[code2].getKey().equals(key))
				{
					probe = -1;
					table[code2].setDelete();
					return true;

				}
				else 
				{
					doub++;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) 
	{
		DoubleHashing doub  = new DoubleHashing();
		doub.addItem("Zack", "Sachin");
		doub.addItem("Umi", "Utkarsha");
		System.out.println(doub.retrieveItem("Umi"));
		boolean bool = doub.deleteItem("Pra");
		if(bool)
			System.out.println("Deleted Sucessfully");
		else
			System.out.println("Unsucessfull");
		
	}
}