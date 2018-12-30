## **CREATING A SUBMIT SERVER - USING HASHMAPS, HASHSETS, LINKEDHASH**

##### CONCEPTS:
[OOP, HashMaps, HashSet, LinkedHashMaps, Recursion, Data Structure, Unit Testing Development ]

##### PURPOSE:
- OOP: Project's goal is to design a server for submitting students' project grades. a project is graded with multiple scores. each project submission belongs to a student.
- HashMaps: To utilize a map and know the benefits of using maps. For this project, I used a hashmap. A benefit of a hashmap is that it allows for an easy insert/retrieval of O(1) in case the order does not matter. But if the program has to formulate an order a LinkedHashMaps could serve better. The project uses hashmap to log student's name(String) as key, and project score under (LinkedHashMap - int) as the value)
- HashSet: To utilize sets and know the benefits of using sets. For this project, I did not use a set but a set is a collection of objects. A hashSet benefits by quick insert without order. 
- LinkedHashMaps: To utilize a map and know the benefits of using maps. For this project, I also used linkedHashMaps to order the scores of a project. some scores are duplicated so the score is key, the number of occurences of this score is the value. This way, calculating the total result equals (multiplying key and value) while adding all key/value result.
- Recursion: Utilizing recursion to solve traversal problems such as finding the max value in a map, making subsequent calls to maps until the base case scenario is reached stopping the recursive method.

### COURSE: Program Design and Data Structures
