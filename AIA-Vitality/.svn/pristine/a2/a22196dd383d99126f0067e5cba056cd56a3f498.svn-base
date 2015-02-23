$.fn.serializeObject = function(excludeIds) {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (excludeIds !== undefined && $.inArray(this.name,excludeIds) !== -1) {
			return;
		}
		if (o[this.name] !== undefined) {
			if (!o[this.name].push) {
				o[this.name] = [o[this.name]];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
};

function createDate(dateId) {
	$("#"+dateId).datepicker({
		dateFormat: 'dd-M-yy',
		autoSize: true,
		changeYear: true,
		changeMonth: true,
		showButtonPanel: true,
		showWeek: true
	});
}

function createButtonHover(buttonId) {
	$('#'+buttonId).hover(
		function() { $(this).addClass('ui-state-hover'); }, 
		function() { $(this).removeClass('ui-state-hover'); }
	);
}

function createDialog(divId, title, height, width) {
	if (width == undefined) width = 500;
	$( "#"+divId ).dialog({
		title: title,
		autoOpen: false,
		width:width,
		height:height,
		closeOnEscape: true,
		modal: true,
		buttons:{"Close":function() {
            $(this).dialog("close");}
        },
		position: "center"
	});
}

function createPopupDialog(divId, textId) {
	$("body").append('<div id="'+divId+'" style="display:none;margin-bottom:5px"> <span id="'+textId+'" style="font-size:10pt; height:20px; width:100%; margin: 5px 5px 5px 5px;" /> </div>');
	createDialog(divId, 'Processing Status');
}

function createAlertDialog(divId, textId) {
	$("body").append('<div id="'+divId+'" style="display:none;margin-bottom:5px"> <span id="'+textId+'" style="font-size:10pt; height:15px; width:75px; margin: 5px 5px 5px 5px;" /> </div>');
	createDialog(divId, 'Processing Status');
}

function showAlertMsg(msg){
	if($('#errorDivMsg').length){
		
	} else {
		createAlertDialog("errorDivMsg","errorTextMsg");
	}
	$("#errorTextMsg").empty().append(msg);
	$("#errorDivMsg").dialog("open");
}

function showErrorMsg(msg) {
	print(msg)
}

function print(msg) {
	$.fancybox('<span class="msg2user">'+msg+'</span>',{'overlayShow':false});
}
function postForm(formId, urlPrefix, excludeIds) {
	createPopupDialog("errorDiv","errorText");
	$("#"+formId).submit(function(event) {
		$("#errorDiv").hide();
		event.preventDefault(); 
		var $form = $(this),
			url = $form.attr('action'),
			formData = JSON.stringify($form.serializeObject(excludeIds));
		if (urlPrefix !== undefined) {
			url = urlPrefix + url;
		}
		// Post the form now
		$.ajax({
			type: "POST",
			url: url,
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			data: formData,
			success: function(json) {
				if (json.message !== undefined) {
					showErrorMsg(json.message);
				}
			},
			error: function (xhr, textStatus, errorThrown) {
				showErrorMsg("Error: "+errorThrown);
			}
		});
	});
}

function fmtJsonDate(date) {
	return $.datepicker.formatDate('yy-mm-dd',new Date(parseInt(date)));
}

function adjustLength(str, max) {
	if (max == undefined) max=100;
	if (str.length > max) {
		return str.substring(0,max) + '...';
	}
	return str;
}

function showRecaptcha(element) {
	Recaptcha.create("6Lca4NYSAAAAAAPaGx334lOtnGI89fGul1GitgJ1", element, {
	theme: "white",
	callback: Recaptcha.focus_response_field});
}

String.prototype.trim = function() {
	return this.replace(/^\s+|\s+$/g,"");
}
String.prototype.ltrim = function() {
	return this.replace(/^\s+/,"");
}
String.prototype.rtrim = function() {	
	return this.replace(/\s+$/,"");
}