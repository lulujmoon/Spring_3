/**
 * 
 */
 
 $(".fileDelete").click(function(){

	let fileNum = $(this).attr("title");
	let obj = $(this);
	let check = confirm("삭제하시겠습니까?");
	if(check){
	$.ajax({
		url: "./fileDelete",
		type: "GET",
		data: {fileNum:fileNum},
		success: function(result){
			result=result.trim();
			if(result>0){
				alert('삭제 성공');
				obj.parent().remove();
				count--;
			}else{
				alert('삭제 실패');
			}
		}
	});
		
	}
});

$("#btn").click(function(){
	$("#frm").submit();

})