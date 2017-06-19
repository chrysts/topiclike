# topiclike
increment, decrement, and create topics


==== DATA STRUCTURE =========
The data structure used in this project is doubly linked list and hashmap.
It is expected to have O(1) with this data structure when insert, increment, or decrement take place.

e.g. : 
We have three topics A, B, C and they have 15, 11, and 11 increments respectively.
A, B, and C would be a node in this data structure.
<-A,15-><-B,11-><-C,11->
"<-" shows a link to the previous node.
"->" shows a link to the next node.


So, if there is one more increment in topic C, then C would have higher order than B.
<-A,15-><-C,12-><-B,11->

This kind of list update only needs a constant time.


===== Architecture ===========
MVC is used here as Spring does support a MVC architure.


===== Frontend ===============
Frontend uses React.js with Flux framework as the architecture. 

How to deploy: 
Command : 
1. mvn clean install


How to create bundle.js:
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

Then, please run : gulp


How to run Springboot application : 
java -jar ./target/topiclike-0.0.1-SNAPSHOT.war


