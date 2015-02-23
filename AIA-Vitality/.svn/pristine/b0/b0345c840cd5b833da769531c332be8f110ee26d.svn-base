var validations={	
	isRange:function (data,min,max) {
		var len=$.trim(data).length;
		return len>=min && len<=max;
	},
	isEmpty:function (data,min,max) {
		var stat=(data == undefined || data == null || data == '' || $.trim(data) == '');
		if(!stat && min !== undefined && max!=undefined) return !validations.isRange(data,min,max); 
		return stat;
	},
	isValidLength:function (data,min,max) {
		if (!validations.isEmpty(data)) return validations.isRange(data,min,max);
		return true;
	},
	isEmail:function (data) {
		if (!validations.isEmpty(data)) {
			var pattern=/^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+/;
			return data.match(pattern);
		}
		return true;
	},
	isWWW:function(data){
		if (!validations.isEmpty(data)) {
			var pat=/^(https?:\/\/)?([\w\d\-_]+\.)+\/?/;
			return data.match(pat)
		}
		return true;
	}
}