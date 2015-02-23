function processDbClick(grid, rowid, ri, ci) {
	var p = grid[0].p;
	if (p.selrow !== rowid) {
		// prevent the row from be unselected on double-click
		// the implementation is for "multiselect:false" which we use,
		// but one can easy modify the code for "multiselect:true"
		grid.jqGrid('setSelection', rowid);
	}
	grid.jqGrid('editGridRow', rowid, editSettings);
}

function insertBlankRow (grid, data) {
	grid.addRowData("blankRow", data);
}	

function serializeDataHandler(postdata) {
	if (postdata.oper == 'add') { delete postdata.id; }
	delete postdata.oper;
	return JSON.stringify(postdata);
}

function afterSubmitHandler(grid, response, postdata, oper, showRating) {
	var json = response.responseText;
	var result = eval("("+json+")");
	if (result.success == true) {
		if (oper == 'add') {
			grid.addRowData(result.id, postdata);
			if (showRating) {
				initRaty(grid, result.id);
			}
		}

		var titleTxt = result.success ? 'Success' : 'Error';
		$("#msgText").empty().append(result.message);
		$("#statusDialog").dialog({
			title:titleTxt,
			modal:true,
			buttons:{"Ok":function() {
				$(this).dialog("close");}
			}
		});

		// Since we are not reloading grid, If no records exists then insert a blank row,
		// and if from a blank row we found at least one record then delete the blank record
		if(oper == 'add' && grid.getGridParam("records") > 0) {
			var rowData = grid.jqGrid('getRowData','blankRow');
			if (rowData !== undefined) {
				grid.delRowData('blankRow');
			}
		} else if (oper == 'delete' && grid.getGridParam("records") == 1){
			insertBlankRow(grid);
		}
	}
	return [result.success,result.message,null]; 
}

function getEditSettings(grid,editurl,reload) {
	if (reload == undefined) reload = false;
	editSettings = {
		recreateForm:true,
		jqModal:false,
		width:310,
		reloadAfterSubmit:reload,
		closeOnEscape:false,
		closeAfterEdit:true,
		ajaxEditOptions: { contentType: "application/json" },
		url:editurl,
		serializeEditData:serializeDataHandler,
		afterSubmit:function(response,postdata) {
			return afterSubmitHandler(grid,response,postdata,'edit');
		}
	};
	return editSettings;
}

function getAddSettings(grid,addurl,showRating) {
	addSettings = {
		recreateForm:true,
		jqModal:false,
		reloadAfterSubmit:false,
		closeOnEscape:false,
		closeAfterAdd:true,
		closeAfterEdit:true,
		ajaxEditOptions: {contentType: "application/json"},
		url:addurl,
		serializeEditData:serializeDataHandler,
		afterSubmit:function(response,postdata) {
			return afterSubmitHandler(grid,response,postdata,'add',showRating);
		}
	};
	return addSettings;
}

function getDeleteSettings(grid,deleteurl) {
	delSettings = {
		reloadAfterSubmit:false,
		closeAfterDelete:true,
		onclickSubmit: function(rp_ge, postdata) {
			rp_ge.url = deleteurl+postdata;
		},
		afterSubmit:function(response,postdata) {
			return afterSubmitHandler(grid,response,postdata,'delete');
		}
	};
	return delSettings;
}

function autoCompleteLocalData(values, elem) {
    $(elem).autocomplete({
        source: values,
        minLength: 2
    });
}

function handleAutoCompleteHc(item) {
	$("#location").val(item.location);
}

function handleAutoCompleteDr(item) {
	$("#doctorQualification").val(item.specialization);
	$("#location").val(item.location);
	if (item.healthCenterName) {
		$("#healthCenterName").val(item.healthCenterName);
		handleAutoCompleteHc(item);
	}
}

function autoComplete(elem, serverUrl, valueStr, type) {
	setTimeout(function () {
		$(elem).autocomplete({
			source: function( request, response ) {
				$.ajax({
					url: serverUrl+'/'+request.term+'/10',
					contentType: "application/json; charset=utf-8",
					dataType: "json",
					success: function( data ) {
						response( $.map( data, function( item ) {
							var retObj = {};
							retObj.id = item.id;

							if (valueStr == 'name') {
								retObj.value = item.name;
							}

							if (type == 'healthcenter') {
								retObj.healthCenterName = item.name;
								retObj.location = item.location;
							} else if (type == 'doctor') {
								retObj.specialization = item.specialization;
								retObj.location = item.location;
								if(item.healthCenter !=null){
									retObj.healthCenterName = item.healthCenter.name;
								}
								else{
									retObj.healthCenterName = "";
								}
								retObj.doctorName = item.name;
							}

							return retObj;
						}));
					}
				});
			},
			select: function(event, ui) {
				var item = ui.item;
				if (type == 'healthcenter') {
					handleAutoCompleteHc(item);
				} else if (type == 'doctor') {
					handleAutoCompleteDr(item);
				}
			},
			minLength: 3
		});
	}, 100);
}

function autoCompleteSpecialization(elem) {
	autoCompleteLocalData(DR_SPECIALIZATION, elem);
}

function autoCompleteLocation(elem) {
	autoCompleteLocalData(LOCATIONS, elem);
}

function getUserLocation() {
	return $('#userLocation').text();
}

function createDatePicker(elem) {
	$(elem).datepicker({
		dateFormat: 'dd-M-yy',
		autoSize: true,
		changeYear: true,
		changeMonth: true,
		showButtonPanel: true,
		showWeek: true,
		yearRange:"1940:c"
	});
}

