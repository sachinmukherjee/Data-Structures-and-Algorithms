// A program for implementing Quadratic hash table
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
		deleted=false;
	}

	void setDelete()
	{
		deleted=true;
	}

	boolean isDeleted()
	{
		return deleted;
	}

	String getData()
	{
		return data;
	}

	String getKey()
	{
		return key;
	}

}

class QuadraticProbing
{
	final static int SIZE = 10;	
	HashItem[] table = new HashItem[SIZE];

	int code(String key)
	{
		int code = key.hashCode() % SIZE;
		return code;
	}

	boolean addItem(String key, String data)
	{
		int probe;
		int quad= 1;
		int code  = code(key);

		if(table[code]==null || table[code].isDeleted())
		{
			table[code]=new HashItem(key, data);
			probe=-1;
			return true;
		}
		else
		{
			if(code==table.length-1)
				probe = 0;
			else 
				probe = code +1;
		}

		while(probe!=-1 && probe!=code)
		{
			if(table[probe]==null)
			{
				table[probe]= new HashItem(key, data);
				probe=-1;
				return true;
			}
			else
			{
				if(probe==table.length-1)
					probe = 0;
				else
				{
					probe = probe + quad * quad;
					quad++;
				}
			}
		}
		return false;
	}

	String retrieveItem(String key)
	{
		int probe;
		int quad = 1;
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
			if(code==table.length-1)
				probe = 0;
			else
				probe = code+1;
		}

		while(probe!=-1 && probe!=code)
		{
			if(table[probe]==null)
				return null;

			else if(table[probe].getKey().equals(key))
			{
				probe = 0;
				return table[probe].getData();
			}
			else
			{
				probe = probe + quad * quad;
				quad++;
			}
		}
		return null;

	}

	boolean itemDelete(String key)
	{
		int probe;
		int quad = 0;
		int code = code(key);

		if(table[code]==null)
			return false;
		else if(table[code].getKey().equals(key))
		{
			probe = -1;
			table[code].setDelete();
			return true;
		}
		else
		{
			if(code == table.length-1)
				probe = 0;
			else 
				probe = code + 1;

		}

		while(probe!=-1 && probe!=code)
		{
			if(table[probe]==null)
				return false;

			else if(table[probe].getKey().equals(key))
			{
				probe = -1;
				table[probe].setDelete();
				return true;
			}

			else
			{
				probe = probe + quad * quad;
				quad++;
			}

		}
		return false;
	}

	public static void main(String[] args) 
	{
		QuadraticProbing quad = new QuadraticProbing();
		quad.addItem("Zack", "Sachin");
		quad.addItem("Umi", "Utkarsha");
		System.out.println(quad.retrieveItem("Umi"));
		boolean bool = quad.itemDelete("Pra");
		if(bool)
			System.out.println("Deleted Sucessfully");
		else
			System.out.println("Unsucessfull");

		
	}
}