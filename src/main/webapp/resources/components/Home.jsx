var HomeStore = require('../stores/HomeStore.jsx');
var HomeActions = require('../actions/HomeActions.jsx');

function getState() {
		
	return {topics : HomeStore.getTopics()};
}

var Home = React.createClass ({
	getInitialState: function() {
		return getState();
	},
		
	componentDidMount: function() {
		HomeActions.getTopics(20);
		HomeStore.addChangeListener(this._onChange);
	},

	componentWillUnmount: function() {
		HomeStore.removeChangeListener(this._onChange);
	},
	
	_onChange: function() {
		this.setState(getState());
	},
	
	increment: function(topicName) {
		HomeActions.incrementTopic({topicName : topicName});
	},
	
	decrement: function(topicName) {
		HomeActions.decrementTopic({topicName : topicName});
	},
	
	render: function() {
		var self = this;
		var topicList = HomeStore.getTopics();

		if(topicList!= null && topicList.length > 0){
        return(
        	<div>
        		<table>
        		<tbody>	        		
		        		{Object.keys(topicList).map(function(topic){
		        		console.log(topicList[topic]);
			            	return (
				            	<tr key={topicList[topic].topicName}>
				            		<td>Topic : {topicList[topic].topicName}</td>
				            		<td>UpVote : {topicList[topic].increment}</td>
				            		<td>DownVote : {topicList[topic].decrement}</td>
				            		<td><button onClick={self.increment.bind(self, topicList[topic].topicName)}>UpVote</button></td>
				            		<td><button onClick={self.decrement.bind(self, topicList[topic].topicName)}>DownVote</button></td>
				            	</tr>
			            	);
			            })}
		            
	            </tbody>
	            </table>
            </div>
        );
        }
        else{
        	return(<div>Topic is not created yet</div>);
        }
    }
});

module.exports = Home;