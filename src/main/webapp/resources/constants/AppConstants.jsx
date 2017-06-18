var basePath = applicationBasePathLocation;

module.exports = {

		getTopics : function() {
			return basePath+"/api/topic/get";
		},
		
		incrementTopic: function(){
			return basePath+"/api/topic/increment";
		},
		
		decrementTopic: function(){
			return basePath+"/api/topic/decrement";
		},
		
		createTopic: function(){
			return basePath+"/api/topic/create";
		}
}