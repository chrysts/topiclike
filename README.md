# Topiclike
The functionalities : Get topics, increment (upvote), decrement(downvote), and create topics.

Technology used here : 
I use Java as the main application as it is my main language now.
Maven is used to build and release.
Frontend side :
React.js is utilized as it can build a powerful single page application.

Assumptions made here :
1. Topic is unique.
2. There is only maximum of 20 topics are shown (Downvote and Upvote only apply to them in UI).
3. Other topics outside of the list can be upvoted and downvoted through API.


==== DATA STRUCTURE =========
The data structure used in this project is doubly linked list and hashmap.
It is expected to have O(n) with this data structure when insert, increment, or decrement takes place.

e.g. : 
We have three topics A, B, C and they have 15, 11, and 11 upvotes respectively.
A, B, and C would be a node in this data structure.
<-A,15-><-B,11-><-C,11->
"<-" shows a link to the previous node.
"->" shows a link to the next node.


So, if there is one more upvote in topic C, then C would have higher order than B.
<-A,15-><-C,12-><-B,11->

This kind of list update only needs a constant time.


===== Architecture ===========
MVC is used here as Spring does support a MVC architecture.


===== Frontend ===============
Frontend uses React.js with Flux framework as the architecture. 

How to deploy: 
Command : 
1. mvn clean install


How to create bundle.js in ./src/main/webapp/resources/:
Please install using npm: 
- gulp
- react
- react-dom
- babel-preset-react
- babelify
- browserify
- flux
- gulp
- gulp-rename
- gulp-uglify
- react-safe-render

* Then, please run : gulp


How to run Springboot application : 
java -jar ./target/topiclike-0.0.1-SNAPSHOT.war

In local : 
We can access in localhost : http://localhost:8080/


