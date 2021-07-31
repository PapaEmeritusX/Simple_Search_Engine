# Simple Search Engine

#### **(*Technical observations of the project are at the end of the page*)**

### About 
Command line search engine that applies inverted index serach on text files.   
Starting the application the user is provided with command line text menu:

```
1. Search information.
2. Print all data.
0. Exit.
```

This search engine supports three searching strategies: ALL, ANY and NONE. The output of seccesful search is a lines of text to which the searching strategy applies. 
This strategies can be described by this exampels: 

Let's take the file that consists of these 6 lines.
```
Dwight Joseph djo@gmail.com
Rene Webb webb@gmail.com
Katie Jacobs
Erick Harrington harrington@gmail.com
Myrtle Medina
Erick Burgess 
```

If the strategy is ALL, the program should print lines containing all the words from the query.  
Query:  
```Harrington Erick ```

Result:  
```Erick Harrington harrington@gmail.com```

If the strategy is ANY, the program should print the lines containing at least one word from the query.  
Query:  
```Erick Dwight webb@gmail.com```

Result:   
```Erick Harrington harrington@gmail.com```  
```Erick Burgess```  
```Dwight Joseph djo@gmail.com```  
```Rene Webb webb@gmail.com```
  

If the strategy is NONE, the program should print lines that do not contain words from the query at all:  
Query:  
```djo@gmail.com ERICK```  

Result:  
```Katie Jacobs```  
```Myrtle Medina```  
```Rene Webb webb@gmail.com```  

A search query can also be a single word and the search is case-insansetive.


