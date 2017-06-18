function ajaxRequest(method, url, data, callback, errorCallback) {
	$.ajax({
	      type: method,
	      url: url,
	      data: data,
	      contentType: 'application/json',
		  dataType: 'json',
	      success: function(result) {
	      	callback(result);
	      },
	      error: function(result) {
	      	if(errorCallback){
	      		errorCallback();
	      	}
	      }
	});
}

var ApiHelper = {
	doGet: function(url, data, callback, errorCallback) {
		return ajaxRequest("GET", url, data, callback, errorCallback);
	},

	doPost: function(url, data, callback,errorCallback) {
		return ajaxRequest("POST", url, JSON.stringify(data), callback,errorCallback);
	}
};

module.exports = ApiHelper;