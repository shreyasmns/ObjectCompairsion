
CS542 Design Patterns
Fall-2016
Assignment 5

README FILE

Due Date: Thursday, December 15, 2016
Submission Date: Thursday, December 15, 2016
Author: Shreyas Mahanthappa Nagaraj
e-mail: smn1@binghamton.edu

PURPOSE: To implement Object comparision functionality, using Java Reflection property
PERCENT COMPLETE: I believe I have completed 100% of this project.

FILES:
		------driver:
				  --Driver.java [Base Class]
		------fileOperations:
				  --FileProcessor.java
		------logger:
				  --Logger.java
		------util:
				  --First.java
				  --PopulateObjects.java
				  --Second.java
				  
SAMPLE OUTPUT:
=====================================================
 Number of Unique First Objects : 4952
 Total Number of First Objects : 4952
 Number of Unique Second Objects : 5017
 Total Number of Second Objects : 5047

=====================================================


TO COMPILE:
=====================================================
ant -buildfile build.xml all

NOTE: Please Place the Input file parallel to the src directory

TO RUN:
=====================================================
Navigate to directory where build.xml is present and run 

ant -buildfile build.xml run -Darg0=input.txt -Darg1=1 -Darg2=0


TO UN-TAR:
tar xvzf mahanthappa_shreyas_assign5.tar.gz

===================================================
Data Structure Used: HashMap

Have used HashMap to store the 'First' and 'Second' type objects, since we can check if the object already
exists or not in the given HashMap and can get the 'Value' of object(Key) before inserting it. Both of these operations
can be done in ~O(1).

Thereby, counting unique and Total number of objects becomes easy.
===================================================

SOURCES REFERRED:
http://stackoverflow.com/questions/113511/best-implementation-for-hashcode-method
http://stackoverflow.com/questions/22683634/why-hash-code-of-different-boolean-instances-is-always-the-same
http://stackoverflow.com/questions/3912303/boolean-hashcode

