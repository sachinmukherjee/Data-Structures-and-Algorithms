/* Implementation of HashTable using Quadratic Probing */
class HashTable
{
  int currentSize, maxSize;     //count for current size and maxSize
  String[] keys;                // arrays for storing keys and values
  String[] values;

  HashTable(int capacity)
  {
    maxSize = capacity;       // initialization of  maxSize and currentSize
    currentSize = 0;
    keys = new String[maxSize];   // initialization of arrays of keys and values
    values = new String[maxSize];
  }

  void makeEmpty()
  {
    // make hashtable empty by setting values of all keys and values to null
    currentSize = 0;
    keys = new String[maxSize];
    values = new String[maxSize];
  }

  int getSize()
  {
    // get current size of HashTable
    return currentSize;
  }

  boolean isFull()
  {
    // get if hashtable is full or null;
    return currentSize == maxSize;
  }
  boolean isEmpty()
  {
    // get if hashtable is empty or not
    return currentSize == 0;
  }

  boolean contains(String key)
  {
    // check if given key contains in hash table or not
    return get(key) != null;
  }

  int hash(String key)
  {
    // get hashcode of given hashtable;
    return (key.hashCode() & 0x7fffffff) % maxSize;
  }

  void insert(String key, String value)
  {
    // inserting data into hashtable
    int temp = hash(key);     // get hashCode
    int i = temp;             // set i to that index
    int h = 1;
    do
    {
      if(keys[i] == null)     // if that position in array of keys if empty directly insert it
      {
        keys[i] = key;
        values[i] = value;
        currentSize++;
        return;
      }
      if(keys[i].equals(key))   // if that position in array of keys contain same key then reassing the value
      {
        values[i] = value;
        return;
      }
      i = (i + h* h++) % maxSize;   // else move forward considering Quadratic Probing
    }
    while(i != temp);         // move forward untill we get into current position of i
  }

  String get(String key)
  {
    // get value of a particular key
    int i = hash(key);    // get hashcode of key
    int h = 1;
    while(keys[i] != null)    // move through all the index untill we reach our desired index with null value at that location
    {
      if(keys[i].equals(key))   // if key found
        {
          return values[i];     // return key
        }
        i = (i+ h * h++) % maxSize;   // move forward considering Quadratic Probing
    }
    return null;    // else return null
  }

  void remove(String key)
  {
    // remove key
    if(!contains(key))
        return;         // no key
    int i = hash(key);
    int h = 1;
    while(!key.equals(keys[i]))     // check unitll desired key is found
    {
      i = (i + h * h++) % maxSize;
    }
    keys[i] = values[i] = null;     // make null

    // rehash all keys
    for(i = (i+h * h++) % maxSize; keys[i]!=null; i = (i + h * h++))
    {
      String temp1 = keys[i];
      String temp2 = values[i];
      currentSize--;
      insert(temp1, temp2);
    }
  }

  public static void main(String args[])
  {
    HashTable table = new HashTable(10);
    table.insert("Sachin", "Mukherjee");
    table.insert("Umi", "Bandhe");
    table.insert("Pragya", "Mishra");
    table.insert("Shreya", "Patel");
    System.out.println(table.get("Shreya"));
    System.out.println(table.get("Kiran"));
  }
}
