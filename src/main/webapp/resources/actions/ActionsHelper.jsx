var AppDispatcher = require('../dispatcher/AppDispatcher.jsx');

var ActionsHelper = {
	dispatch: function(actionType, data) {
		AppDispatcher.handleAction({
        	actionType : actionType,
        	data: data
        });
	},
	
	customDispatch: function(actionType, data, dispatcher) {
		dispatcher.handleAction({
        	actionType : actionType,
        	data: data
        });
	}
};

module.exports = ActionsHelper;