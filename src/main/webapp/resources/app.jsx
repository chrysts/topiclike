window.React = require('react');
var ReactDOM = require('react-dom');

var Home = require('./components/Home.jsx');
var CreateTopic = require('./components/CreateTopic.jsx');

ReactDOM.render(
	  	<Home />,
	  	document.getElementById('main-content')
	);
	
ReactDOM.render(
	  	<CreateTopic />,
	  	document.getElementById('create-topic')
	);