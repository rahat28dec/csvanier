$(document).ready(function() {
      initPage(); 
	  setMinDate();
});

function initPage() {
    var dataFields = [];
    for(var i = 0; i < document.forms["expform"].elements.length; i++) {
        if(document.forms["expform"].elements[i].className === "expenseEntry") {
			dataFields.push(document.forms["expform"].elements[i].value);
            //dataFields[i] = document.forms["expform"].elements[i].value;
            document.forms["expform"].elements[i].onblur = update
        }
    }
	document.forms["expform"].onsubmit = validateForm;
}

function testLength(field) {
	if(field.value.length === 0) {
		field.style.backgroundColor = "yellow";
		return false;
	} else {
		field.style.backgroundColor = "white";
		return true;
	}
}

/**
Return true if regex is valid;
*/
function testPattern(field, regx) {
	if(!regx.test(field.value)) {
		field.style.backgroundColor = "yellow";
		field.style.color = "red";
		return false;
	} else {
		field.style.backgroundColor = "white";
		field.style.color = "black";
		return true;
	}
}


function validateForm() {
	var accountRegx = /^ACT\d{5}$/;
	var ssnRegx = /^\d{9}|\d{3}-\d{2}-\d{4}/;
	var projectRegx = /^PROJ\d{5}$/;
	var deptRegx = /^DEPT\d{3}$/;
	
	var isValid = true;
	
	if(!testLength(document.forms[0].lname)) {
		isValid = false;
	}
	if(!testLength(document.forms[0].fname)) {
		isValid = false;
	}
	if(!testLength(document.forms[0].address)) {
		isValid = false;
	}
	if(!testLength(document.forms[0].summary)) {
		isValid = false;
	}
	if(!testPattern(document.forms[0].account, accountRegx)) {
		isValid = false;	
	}
	if(!testPattern(document.forms[0].department, deptRegx)) {
		isValid = false;	
	}
	if(!testPattern(document.forms[0].project, projectRegx)) {
		isValid = false;	
	}
	if(!testPattern(document.forms[0].ssn, ssnRegx)) {
		isValid = false;	
	}
	if(!isValid) {
		alert("Please fill out all required fields.");
	}
	return isValid;
}

/**
This will calculate a row.
*/
function calcRow(row) {
	var travel = parseFloat(document.forms[0].elements["travel"+row].value);
	var lodge = parseFloat(document.forms[0].elements["lodge"+row].value);
	var meal = parseFloat(document.forms[0].elements["meal"+row].value);
	return parseFloat(travel + lodge + meal).toFixed(2);
}


function calcTotal() {
	var totalExp = 0; 
	// since there are only four rows
	for (var i = 1; i <= 4; i++) { 
		totalExp += parseFloat(calcRow(i)); 
	}
	return totalExp; 
}

function update() {
	var numRegx = /^\d*(\.\d{0,2})?$/;
	if(numRegx.test(this.value)) {
		this.value = parseFloat(this.value).toFixed(2);
		for(var i = 1; i <= 4; i++) {
			document.forms[0].elements["sub"+i].value = calcRow(i);
			document.forms[0].elements.total.value = parseFloat(calcTotal()).toFixed(2);
		}
	} else {
		alert("Invalid currency value.");
		this.value = 0.00; // reset
		this.focus();
	}
}

function getTodayDate() {
	var D = new Date();
	
	var mm = D.getMonth() + 1;
	var cmm = parseFloat(mm) < 10 ? "0"+mm : mm;
	var yyyy = "20" + D.getYear().toString().substring(1);
	var dd = D.getDate();
	var tday = yyyy+"-"+cmm+"-"+dd;
	return tday;
}

function setMinDate() {
	$("input[type=date]").attr("min", getTodayDate());
}














