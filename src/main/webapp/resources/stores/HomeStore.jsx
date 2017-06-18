var AppDispatcher = require('../dispatcher/AppDispatcher.jsx');
var EventEmitter = require('events').EventEmitter;
var _ = require('underscore');

var HomeConstants = require('../constants/HomeConstants.jsx');
var HomeAPI = require('../utils/HomeAPI.jsx');

topics = [];
newTopicAdded = 0;

function getTopics(limit){
	HomeAPI.getTopics(limit);
}

function receiveTopics(data){
	topics = data;
}

function createTopic(topicName){
	HomeAPI.createTopic(topicName);
}

function incrementTopic(topicName){
	HomeAPI.incrementTopic(topicName);
}

function decrementTopic(topicName){
	HomeAPI.decrementTopic(topicName);
}


var HomeStore = _.extend({}, EventEmitter.prototype, {
	getTopics : function() {
		return topics;
	},
	
	addChangeListener: function(callback) {
        this.on('change', callback);
    },
    emitChange: function() {
        this.emit('change');
    },
    removeChangeListener: function(callback) {
      this.removeListener('change', callback);
    }
});

AppDispatcher.register(function(topic) {
    var action = topic.action;

    switch(action.actionType) {
    	case HomeConstants.GET_TOPICS :
    		getTopics(action.data);
    		break;

    	case HomeConstants.RECEIVE_TOPICS :
    		receiveTopics(action.data);
    		break;

    	case HomeConstants.INCREMENT_TOPIC :
    		incrementTopic(action.data);
    		break;

    	case HomeConstants.DECREMENT_TOPIC :
    		decrementTopic(action.data);
    		break;
    		
    	case HomeConstants.CREATE_TOPIC :
    		createTopic(action.data);
    		break;


        default :
        	return true;
    }

    HomeStore.emitChange();
    return true;
});

module.exports = HomeStore;