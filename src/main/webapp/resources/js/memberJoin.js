/**
 * 
 */
 
 
 let id = document.getElementById("id");
 let pw = document.getElementById("pw");
 let pwc = document.getElementById("pwCheck");
 let etc = document.getElementsByClassName("etc");

let idr = document.getElementById("idResult");  
let pwr = document.getElementById("pwResult");
let pwcr = document.getElementById("pwcResult");

 id.addEventListener("blur", function(){
	
	if(id.value.length<6){
		idr.innerText = "6글자 이상 입력하세요";
		idr.setAttribute("class", "r1");
		}else{
			idr.innerText=" ";
		}
});

pw.addEventListener("blur", function(){
	
	let st = "8글자 이상 입력하세요.";
	let c = "r1";
	if(pw.value.length>7){
		st = "사용할 수 있는 비밀번호입니다.";
		c = "r2";
	}
	pwr.innerText = st;
	pwr.setAttribute("class", c);
});

pw.addEventListener("change", function(){
	pwc.value="";
});


pwc.addEventListener("blur", function(){
	
	let st = "비밀번호가 일치하지 않습니다.";
	let c = "r1";
	
	if(pw.value==pwc.value){
		st ="비밀번호가 일치합니다.";
		c = "r2";
	}
	
	pwcr.innerText = st;
	pwcr.setAttribute("class", c);
});


btn.addEventListener("click", function(){
	
	let idCheck = idr.getAttribute("class") =="r2";
	let pwCheck = pwr.getAttribute("class") =="r2";
	let pwcCheck = pwcr.getAttribute("class") == "r2";
	let etcCheck = true;
	for(e of etc){
		if(e.value==""){
			etcCheck = false;
			break;
		}
	}
	
	if(idCheck&&pwCheck&&pwcCheck&&etcCheck){
		let frm = document.getElementById("frm");
		alert("회원가입이 완료되었습니다.");
		frm.submit();
	}else{
		alert("입력사항을 확인하세요.");	
	}
});


//ID 중복 확인
	$("#id").blur(function(){
		let id = $("#id").val();

		$.get("./memberIdCheck?id="+id, function(result){
			result=result.trim();
			if(result=='0'){
				result='사용할 수 없는 아이디입니다.';
			}else if(result=='1'){
				result="사용할 수 있는 아이디입니다.";
			}
			$("#idCheckResult").text(result);
			$("#idCheckResult").attr("class", "r2");
		});
	});
