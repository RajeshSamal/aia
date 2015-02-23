jQuery(document).ready(function(){	
	
	
	function isNonEmptyRow(id) {
		return (id !== '_blank');
	}
	
	function activationFormatter (cellvalue, options, rowObject) {
				
		if (isNonEmptyRow(rowObject.id)) {		
			if(!rowObject.enabled){
				return '<a id="activatePage" class="rdetails highlight" style="color:#000000;font-size:100%" '+
				' onclick="showUrForm(\''+rowObject.userName+'\')">Activate</a>';
			}else{
				return "";
			}
			
		} 
		else {
			return "";
		}
	}
	
	
	grid = $("#users"),
	grid.jqGrid({
		url:'um/userList',
		datatype: "json", 
		
		colNames:['Id', 'Name',  'First Name', 'Last Name', 'Business Email', 'Business Phone', 'Mobile', 'Email Verification status', 
		          'Phone Verification Status', 'Action', 'Corporate Title', 'Company Name',
		          'Company Address', 'City', 'State', 'Country', 'Postal Code', 'User Name'], 
		colModel:[
			{name:'id',index:'id', editable: false, hidden:true},			
			{name:'name', index:'name', editable: false, width:150, sortable:false},
			{name:'firstName',index:'firstName',editable: true, hidden:true , editrules:{edithidden:true}},
			{name:'lastName',index:'lastName', editable: true, hidden:true, editrules:{edithidden:true}},
			{name:'businessEmail',index:'businessEmail', editable: true, width:150, sortable:false},
			{name:'businessPhone',index:'businessPhone', editable: true, hidden:true, editrules:{edithidden:true} },
			{name:'mobile',index:'mobile', editable: true, width:100, sortable:false},
			{name:'emailVerificationStatus',index:'emailVerificationStatus', editable: false, width:150, sortable:false},
			{name:'phoneVerificationStatus',index:'phoneVerificationStatus', editable: false, width:150, sortable:false},
			{name:'action',index:'action', editable: false, width:50, sortable:false,formatter:activationFormatter},		
			
			{name:'corporateTitle',index:'corporateTitle', editable: true, hidden:true, editrules:{edithidden:true} },
			{name:'companyName',index:'companyName', editable: true, hidden:true, editrules:{edithidden:true} },
			{name:'companyAddress1',index:'companyAddress1', editable: true, hidden:true, editrules:{edithidden:true}},			
			{name:'companyCity',index:'companyCity', editable: true, hidden:true, editrules:{edithidden:true}},
			{name:'companyState',index:'companyState', editable: true, hidden:true, editrules:{edithidden:true}},
			{name:'companyCountry',index:'companyCountry', editable: true, hidden:true, editrules:{edithidden:true}},
			{name:'companyPostalCode',index:'companyPostalCode', editable: true, hidden:true, editrules:{edithidden:true}},
			{name:'userName',index:'userName', editable: false, hidden:true, key:true}	
			
		],		
		rowNum:10,
		rowList:[10,20,30], 
		pager: '#userPager', 
		gridview:true,
		rownumbers:true,
		caption: 'Users',
		ignoreCase: true,
		multiselect: false,
		viewrecords: true,
		sortorder: "desc",
		jsonReader: {
			root: 'rows',
			  page: 'page',
			  total: 'total',
			  records: 'records',
			  userdata : 'rows',
			  repeatitems: false
		},
		loadComplete: function() {
			if(grid.getGridParam("records")==0) {
				grid.addRowData(
					"blankRow", {"id":"_blank", "name":"No data was found.", "businessEmail":"",  "mobile":""}
				);
			}
		},
		ajaxGridOptions: { contentType: "application/json" },
	
		ajaxRowOptions: { contentType: "application/json" },
		height: '100%',
		ondblClickRow: function(rowid, ri, ci) {
			if(rowid != 'blankRow'){
				processDbClick(grid, rowid, ri, ci);
			}
		},
		onSelectRow: function(id) {
			//var urDetails= grid.jqGrid('getRowData',id);
			var rows=grid.getGridParam('userData')
			for (i=0;i<rows.length;i++) {
				if (id==rows[i].id) {
					aSelectedUr = true;
					break;
				}
			}
		}
	});
	
	
	grid.jqGrid('navGrid','#userPager',
				{edit:false,add:false,del:false,search:false},
				{ }, //edit options
		        { },  //add options
		        { }, 
				{ 
			    	sopt:['eq', 'ne', 'lt', 'gt', 'cn', 'bw', 'ew'],
			        closeOnEscape: true, 
			       	multipleSearch: false, 
			       	closeAfterSearch: true }
	);		
		
	grid.navButtonAdd('#userPager',	{ 	caption:"Add", 
					buttonicon:"ui-icon-pencil", 
					onClickButton: addRow,
					position: "last", 
					title:"", 
					cursor: "pointer"
				} 
	);
		
	grid.navButtonAdd('#userPager',
				{ 	caption:"Edit", 
					buttonicon:"ui-icon-pencil", 
					onClickButton: editRow,
					position: "last", 
					title:"", 
					cursor: "pointer"
				} 
	);		

	function addRow() {
	
		grid.jqGrid('editGridRow','new',
    		{ 	url: "registerUser", 
			
				ajaxEditOptions : {
	                      type :"POST",
	                      contentType :"application/json; charset=utf-8",
	                      dataType :"json"
	        },
			
			serializeEditData: function(obj){
	             var toPost = {};
						 
				 toPost['id'] = obj.id;				 
				 toPost['firstName'] = obj.firstName;
				 toPost['lastName'] = obj.lastName;
				 toPost['businessEmail'] = obj.businessEmail;
				 toPost['businessPhone'] = obj.businessPhone;
				 toPost['mobile'] = obj.mobile;
				 
				 toPost['corporateTitle']= obj.corporateTitle;
				 toPost['companyName']= obj.companyName;
				 toPost['companyAddress1'] = obj.companyAddress1;						 
				 toPost['companyCity'] = obj.companyCity;
				 toPost['companyState'] = obj.companyState;
				 toPost['companyCountry'] = obj.companyCountry;
				 toPost['companyPostalCode'] = obj.companyPostalCode;						 
						 
	     		 //toPost['emailVerificationStatus'] = obj.emailVerificationStatus;
						 
				 var str = JSON.stringify(toPost);
	             return str;
	       },
					  
					  
	       editData: {  },
		   recreateForm: true,
		   beforeShowForm: function(form) {	    },
		   closeAfterAdd: true,
		   reloadAfterSubmit:true,
		   afterSubmit : function(response, postdata) { 			        
				var result = eval('(' + response.responseText + ')');						
			         
			   	$("#userdialog").text(result.message);
				
			   	$("#userdialog").dialog({ title: 'Success',
									modal: true,
									buttons: {"Ok": function()  {
														$(this).dialog("close");
													} 
									}
				});
				
			    // only used for adding new records
			    var new_id = null;			    	
				return [result.success, result.message, new_id];					
			}
    });

}
		
		
	
function editRow() {
	// Get the currently selected row
	var row = grid.jqGrid('getGridParam','selrow');
	
	if( row != null ) 
		grid.jqGrid('editGridRow',row,
			{	url: "um/editUser", 				
				ajaxEditOptions : {
	                      type :"POST",
	                      contentType :"application/json; charset=utf-8",
	                      dataType :"json"
	        },					  
				
			serializeEditData: function(obj){
				
	                     var toPost = {};
						 toPost['userName'] = obj.id;
						 
						 toPost['firstName'] = obj.firstName;
						 toPost['lastName'] = obj.lastName;
						 toPost['corporateTitle']= obj.corporateTitle;
						 toPost['businessEmail'] = obj.businessEmail;
						 toPost['businessPhone'] = obj.businessPhone;
						 toPost['mobile'] = obj.mobile;
						 
						 toPost['companyName']= obj.companyName;
						 toPost['companyAddress1'] = obj.companyAddress1;						  
						 toPost['companyCity'] = obj.companyCity;
						 toPost['companyState'] = obj.companyState;
						 toPost['companyCountry'] = obj.companyCountry;
						 toPost['companyPostalCode'] = obj.companyPostalCode;
						 
						
						 //toPost['email'] = obj.email;
						 //toPost['emailVerificationStatus'] = obj.emailVerificationStatus;						 
						 
	                     var str = JSON.stringify(toPost);
	                     return str;
	                  },

				
				editData: {
		        },
		        recreateForm: true,
		        beforeShowForm: function(form) {
				
				 $('#tr_email', form).hide(); 
				 $('#tr_mobile', form).hide();
		        },
				closeAfterEdit: true,
				reloadAfterSubmit:true,
				afterSubmit : function(response, postdata) { 
				
				var result = eval('(' + response.responseText + ')');
						
			         
			        	$("#userdialog").text(result.message);
						$("#userdialog").dialog( 
								{	title: 'Success',
									modal: true,
									buttons: {"Ok": function()  {
										$(this).dialog("close");} 
									}
								});
	               
			    	// only used for adding new records
			    	var new_id = null;
			    	
					return [result.success, result.message, new_id];
		
				

				}
			});
	}

	
	
	
	window.showUrForm=function(userName) {
	
		var str='<div id="urMsg" style="display:none"></div>'+
		'<div class="ui-widget-header" style="height:22px;">'+
		'<form id="userActivateForm" name="userActivateForm" action="">'+
			   '<input type="hidden" name="uId" id="uId" value="'+userName+'">'+
				'<table id="userActivateTab">'+
					'<tr>'+
						'<td width="200">'+
							'<span class="formLabel">Activation Comment</span>'+
						'</td>'+
					'</tr>'+
					'<tr>'+
						'<td>'+
							'<textarea id="activationComment" style="font-size:8pt;width:290px;height:30px;padding:5px;margin:2px"></textarea>'+
						'</td>'+
					'</tr>'+
				'</table>'+

				'<div id="submitDiv" style="float:right;width:60%;margin-bottom:4px;">'+
				    '<button id="activateUserBtn" type="submit" style="display:inline-block;" class="ui-state-default"><span style="margin: 0 2px 0 2px; '+'float:left;" class="ui-icon ui-icon-circle-check"></span>Activate</button>'+
				'</div>'+						
		'</form></div>';
				 
		$.fancybox(str);
		
		$('button#activateUserBtn').click(function(){
			
			var data={};			
			data['userName'] = $('input#uId').val();
			data['activationComment'] = $('textarea#activationComment').val();
			
						
			$.ajax({
					type:"POST",
					url:'um/actUser',
					contentType: "application/json; charset=utf-8",
					dataType: "json",
					data:JSON.stringify(data),
					success: function(ret) {
						if (ret.success == true) {
							
							$.fancybox.close();
						} else {
							$('div#urMsg').html('<span class="msg2user">'+ret.message+'</span>').show();
						}
					},
					error: function (xhr, textStatus, errorThrown) {
						alert("Error");
					}
				});
			
		});
	}
	
	
	$('a#activatePage').fancybox({
		'href'   : '#activate',
		'transitionIn'  : 'elastic',
		'scrolling'   : 'no',
		'autoScale' : true,
		'hideOnOverlayClick' : false,
		'transitionOut'  : 'elastic'
	});

});

