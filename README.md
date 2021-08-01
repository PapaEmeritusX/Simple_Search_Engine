# Simple Search Engine

#### **(*Technical observations of the project are at the end of the page*)**

### About 
Command line search engine that applies [inverted index](https://www.geeksforgeeks.org/inverted-index/) serach on text files.   
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

##  Technical Observations
The program processes the command line argument `<--data>`, and after that, the name of the file with the data, for example, `<--data text.txt>`.
As program starts the file is read line by line and stored to a HashMap as a dataset each with a key that associates with the line number. Consequently, after creating the datamap the method to create inverted index map (`<initInvertedIndexMap(dataset)>`) is called, purpose of which is to split each line from dataset into words and write it into a HashMap of `<Map<String, ArrayList<String>>>` where String is supposed to store a word and ArrayList to store the keys of the wordm which are numbers of lines where the word can be found. By means of inverted index mapping the search speed increase to O(n), through map interface, not going through the whole dataset checking every word for a match.  

Applying various searching strategies (ANY, ALL, NONE), implying three different algorithms for obtaining data, suggested to use [Strategy Deisgn Pattern](https://medium.com/litslink/design-patterns-strategy-in-examples-eae7bf10a817) for performing a task we want to choose at runtime. This pattern is especially good when the number of algorithms increases because it isolates algorithms from the client code. However, this design pattern complicates the system by adding multiple additional classes.
