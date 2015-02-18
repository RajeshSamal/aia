var isLogin = false;

$(document).ajaxError(function(e, xhr, settings, exception) {
	if (xhr.status == 403) {
		isLogin = false;
		window.location.replace('index.jsp');
	}
}); 

$(document).ready(function() {
	$.ajax({
		type: "GET",
		url: "user/profile",
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(data) {
			isLogin = true;
			$('#loginUname').text(data.username);
			$('#userLocation').text(data.location);
			/*if (data.profileImageLocation) {
				$('#profileImage').attr("src",data.profileImageLocation);
			}*/
		}
	});	

	$('div#navigation ul li div').click(function(e){
		e.preventDefault();
		var self = this;
		$.ajax({
			type: "GET",
			url: self.lang,
			success: function(data) {
				$('div#content').html(data);
				location.hash=self.id;
				
			}
		});
	});
	// Get hash parameter from the url, if none assume "users"
	var tabParam = document.URL.split('#')[1];
	if (tabParam == undefined || tabParam == null || tabParam.indexOf("tab") == -1) {
		tabParam = "tabUsers";
	}
	$('#'+tabParam).click();
	

		
});