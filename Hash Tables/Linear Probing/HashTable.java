/* Implementation of HastTable */
class HashTable
{
  int currentSize, maxSize;       // count for current size of hashtable and maximum size of hashtable
  String[] keys;                  // for storing keys
  String[] values;                // for storing values

  HashTable(int capacity)
  {
    currentSize = 0;            // initializing current size to zero
    maxSize = capacity;         // initializing maxSize;
    keys = new String[maxSize];   // initializing both the arrays
    values = new String[maxSize];
  }

  void makeEmpty()
  /* Emptying hash table*/
  {
    currentSize = 0;          // make current size to zero
    keys = new String[maxSize];    // make new String object
    values = new String[maxSize];
  }

  int getSize()
  {
    return currentSize;         // current size of hash table
  }

  boolean isFull()
  {
    return getSize() == maxSize;    // determining whether hashtable is full or not
  }

  boolean isEmpty()
  {
    return getSize() == 0;        // determining whether hashtable if empty or not
  }

  boolean contains(String key)
  {
    return get(key) != null;      // if hashtable has that particular key or not
  }

  int hash(String key)
  {
    return (key.hashCode() & 0x7FFFFFFF) % maxSize;    // returning index for key
    // this Implementation is because hashCode can throws negetive index if value is greater than some range
  }

  void insert(String key, String value)
  {
    int temp = hash(key);           // get index of that key
    int i = temp;                   // initialize i

    do
    {
        if(keys[i] == null)       // if that position of index if empty then directly enter the key and values into arrays
        {
          keys[i] = key;
          values[i] = value;
          currentSize++;
          return;
        }

        if(keys[i].equals(key))   // if that position contains same key than reassign the value to that position
        {
          values[i] = value;
          return;
        }
        i = (i+1) % maxSize;      // else move forward one step at a time
    } while (i != temp);          // untill you reach the same index at the time of initialization
  }

  String get(String key)
  {
    int i = hash(key);        // get the index of that key
    while(keys[i] != null)     // untill that position of index is not null
    {
      if(keys[i].equals(key))    // if key found
          return values[i];     // return value
     i = (i+1) % maxSize;       // move forward one step at a time
    }
    return null;              // else return null;

  }

  void remove(String key)
  {
    if(!contains(key))      //calling contain method if key is there or not
      return;               // key not found
    int i = hash(key);      // initialize index
    while(! keys[i].equals(key))    // unitill key found is not equal to mentioned key
    {
      i = (i+1) % maxSize;      // move forward one step at a time
    }
    keys[i] = null;           // make both the arrays null
    values[i] = null;

    // rehash all keys and values
    for(i = (i+1) % maxSize; keys[i] != null; i = (i+1) % maxSize)
    {
      // from current value of i+1, loop untill key at that position is not null, move forward
      String temp = keys[i];      // key found store in temporary value
      String temp2 = values[i];    // value found store in temporary value
      keys[i] = values[i] = null; // make both key and value at particular index to null
      currentSize--;              // decrease current size
      insert(temp, temp2);        // insert key and value
    }
  }

  public static void main(String args[])
  {
    HashTable table = new HashTable(10);
    table.insert("Sachin", "Mukherjee");
    table.insert("Umi", "Bandhe");
    table.insert("Pragya", "Mishra");
    System.out.println(table.get("Umi"));
  }
}
