/**
 * 
 */
 
 
let frm = document.getElementById("frm");
let subject = document.getElementById("subject");
let content = document.getElementById("content");
let btn = document.getElementById("btn");



btn.addEventListener("click", function(){
	alert("hi");
let check1 = (subject.value.length !=0);
if(check1){
	frm.submit();
}else{
	alert("Caution");
}
	
})