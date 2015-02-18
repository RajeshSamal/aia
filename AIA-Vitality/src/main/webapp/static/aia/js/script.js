
var ww = document.body.clientWidth;

$(document).ready(function() {
	$(".nav li a").each(function() {
		if ($(this).next().length > 0) {
			$(this).addClass("parent");
		};
	})
	
	$(".toggleMenu").click(function(e) {
		e.preventDefault();
		$(this).toggleClass("active");
		$(".nav").toggle();
	});
	adjustMenu();
	
	$('.footer_quickmenu li a').click( function(e){
		var self = this;	
		$.ajax({
			type: "GET",
			url: self.lang,
			success: function(data) {
				$('div#contentDiv').html(data);
				var hash = "tab"+self.id;
				location.hash=hash;	
				removePrevSelection();
				$(self).addClass("selected");
				$('#'+self.lang).addClass("current_page_item");
			}
		});
	})
	
	$('.nav li a').click(function(e){
		e.preventDefault();
		var self = this;
		$.ajax({
			type: "GET",
			url: self.lang,
			success: function(data) {
				$('div#contentDiv').html(data);
				location.hash=self.id;	
				removePrevSelection();
				$('#'+self.lang).addClass("current_page_item");
			}
		});
	});
	// Get hash parameter from the url, if none assume "doctors"
	var tabParam = document.URL.split('#')[1];
	if (tabParam == undefined || tabParam == null || tabParam.indexOf("tab") == -1) {
		tabParam = "tabHome";
	}
	$('#'+tabParam).click();
	
})

$(window).bind('resize orientationchange', function() {
	ww = document.body.clientWidth;
	adjustMenu();
});

var adjustMenu = function() {
	if (ww < 788) {
		$(".toggleMenu").css("display", "inline-block");
		if (!$(".toggleMenu").hasClass("active")) {
			$(".nav").hide();
		} else {
			$(".nav").show();
		}
		$(".nav li").unbind('mouseenter mouseleave');
		$(".nav li a.parent").unbind('click').bind('click', function(e) {
			// must be attached to anchor element to prevent bubbling
			e.preventDefault();
			$(this).parent("li").toggleClass("hover");
		});
	} 
	else if (ww >= 788) {
		$(".toggleMenu").css("display", "none");
		$(".nav").show();
		$(".nav li").removeClass("hover");
		$(".nav li a").unbind('click');
		$(".nav li").unbind('mouseenter mouseleave').bind('mouseenter mouseleave', function() {
		 	// must be attached to li so that mouseleave is not triggered when hover over submenu
		 	$(this).toggleClass('hover');
		});
	}
}

var removePrevSelection = function(){
	$(".nav li").each(function() {
		$(this).removeClass("current_page_item");	
	})
	$('.footer_quickmenu li a').each(function() {
		$(this).removeClass("selected");	
	})
}

