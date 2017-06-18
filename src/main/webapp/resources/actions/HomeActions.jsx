var ActionsHelper = require('./ActionsHelper.jsx');
var HomeConstants = require('../constants/HomeConstants.jsx');

var HomeActions = {
	getTopics: function(data) {
		ActionsHelper.dispatch(HomeConstants.GET_TOPICS, data);
	},

	receiveTopics: function(data) {
		ActionsHelper.dispatch(HomeConstants.RECEIVE_TOPICS, data);
	},
	
	incrementTopic: function(data) {
		ActionsHelper.dispatch(HomeConstants.INCREMENT_TOPIC, data);
	},
	
	decrementTopic: function(data) {
		ActionsHelper.dispatch(HomeConstants.DECREMENT_TOPIC, data);
	},

	createTopic: function(data) {
		ActionsHelper.dispatch(HomeConstants.CREATE_TOPIC, data);
	}
	
}
	
module.exports = HomeActions;