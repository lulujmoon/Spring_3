/**
 * 
 */
$("#content").summernote({
	    height:500,
	    placeholder : '본문을 입력하세요.',
	    callbacks: {
		    onImageUpload: function(files) {
				uploadFile(files);
		      // upload image to server and create imgNode...
		      //$summernote.summernote('insertNode', imgNode);
		    },
		    onMediaDelete: function(files){
				deleteFile(files);
			}
		  }
	});

function uploadFile(files){
	const formData = new FormData();	//Form 태그 생성
	formData.append('file', files[0]);		//input type="File" name="file"
	let fileName="";
		
	$.ajax({
		type: "POST",
		url: "./summerFileUpload",
		data: formData,					//key, value로 구성되어 있기 때문에 따로 {} 안 써도 됨
		enctype: "multipart/form-data",
		cache: false,
		processData: false,
		contentType: false,
		success: function(result){
			fileName = result.trim();
			$("#content").summernote('insertImage', fileName);
		}
	});

};

function deleteFile(files){
	let fileName = $(files[0]).attr("src");
	fileName = fileName.substring(fileName.lastIndexOf('/')+1);
	$.post("summerFileDelete", {fileName:fileName}, function(result){
		console.log(result);
	});
};