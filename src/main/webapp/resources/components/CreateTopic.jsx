var HomeStore = require('../stores/HomeStore.jsx');
var HomeActions = require('../actions/HomeActions.jsx');

function getState(topicNameText) {
	return {value : topicNameText};
}

var CreateTopic = React.createClass ({
	getInitialState: function() {
		return getState("");
	},
		
	handleChange: function(event) {
		this.setState(getState(event.target.value));
	},
	
	createClick: function() {
		HomeActions.createTopic({topicName : this.state.value});
	},
	
	
	render: function() {
		var self = this;
	
        return(
        	<div>
        		<input name="topicNameText" type="text" value={this.state.value} onChange={this.handleChange}/>
        		<button type="button" data-dismiss="modal" onClick={self.createClick}>Create</button>
        	</div>
        );
    }
});

module.exports = CreateTopic;