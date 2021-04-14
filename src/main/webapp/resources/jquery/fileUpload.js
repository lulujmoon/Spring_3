/**
 * 
 */
 let count = $("#files").attr("title");

$("#add").click(function(){
		
		if(count<5){
			$("#files").append($("#sample").html());
			count++;
		}else{
			alert('파일은 최대 5개까지 첨부할 수 있습니다.');
		}
});


//이벤트 위임
$("#files").on("click", ".delete", function(){
	$(this).parent().remove();
});