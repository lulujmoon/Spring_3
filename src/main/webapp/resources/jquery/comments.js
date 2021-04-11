/**
 * 
 */
let num = $("#comments").attr("title");
getList();

function getList(){
$.get("../comments/commentsList?num="+num, function(data){
	console.log(data);
	$("#comments").html(data.trim());
});
};

$("#write").click(function(){
	let writer = $("#usr").val();
	let contents = $("#comment").val();
	
	$.post("../comments/commentsInsert", 
	{
	writer:writer, 
	contents:contents,
	num:num
	}, 
	function(data){
		data = data.trim();
		if(data==1){
			alert('등록 성공');
			$("#usr").val("");
			$("#comment").val("");
		}else{
			alert('등록 실패');

		}
		getList();
	});
});

$("#comments").on("click", "#remove", function(){
	const ar = [];
	
	$(".del").each(function(){
		let ch = $(this).prop("checked");
		if(ch){
			ar.push($(this).attr("value"));
		}
	});
	
	$.ajax({
		type: "POST",
		url: "../comments/commentsDelete",
		traditional: true,
		data:{commentsNum:ar},
		success:function(data){
			alert('삭제 성공');
			getList();
		}
	})
})
