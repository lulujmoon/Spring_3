/**
 * 
 */
 
 $("#btn").click(function(){
/*	let name = $("#name").val() !="";
	let subject = $("#subject").val() !="";
	let content = $("#content").val().length!=0;*/
	
	$("#frm").submit();
	
/*	$(".myCheck").each(function(s1){
		if($(this).val()==""){
			result = false;
		}
	});
	
	if(result){
		$("#frm").submit();
	}else{
		alert('입력사항을 확인하세요.');
	}*/
});

let r = 1;

$("#add").click(function(){
		
		if(r<6){
			$("#files").append($("#sample").html());
			r++;
		}else{
			alert('파일은 최대 5개까지 첨부할 수 있습니다.')
		}
});


//이벤트 위임
$("#files").on("click", ".delete", function(){
	$(this).parent().remove();
});