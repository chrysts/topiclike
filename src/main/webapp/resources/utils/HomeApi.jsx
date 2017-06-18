var ApiHelper = require('./ApiHelper.jsx');
var HomeActions = require('../actions/HomeActions.jsx');
var AppConstants = require('../constants/AppConstants.jsx');


module.exports = {
	getTopics: function(limit){
		data = {limit : limit};
		
		ApiHelper.doGet(AppConstants.getTopics(), data, HomeActions.receiveTopics);
	},
	
	createTopic: function(topicName){
		data = topicName;
		var callBack = function(response){
			HomeActions.getTopics(20);
		};
		ApiHelper.doPost(AppConstants.createTopic(), data, callBack);
	},
	
	incrementTopic: function(topicName){
		data = topicName;
		var callBack = function(response){
			HomeActions.getTopics(20);
		};
		ApiHelper.doPost(AppConstants.incrementTopic(), data, callBack);
	},
	
	decrementTopic: function(topicName){
		data = topicName;
		var callBack = function(response){
			HomeActions.getTopics(20);
		};
		ApiHelper.doPost(AppConstants.decrementTopic(), data, callBack);
	}
	

}