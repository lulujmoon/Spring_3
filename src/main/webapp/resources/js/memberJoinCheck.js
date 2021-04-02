/**
 * 
 */
 
let d1=document.getElementById("d1");
let c1 = document.getElementsByClassName("c1");
const btn = document.getElementById("btn");

btn.addEventListener("click", function(){
	if(d1.checked){
		location.href="./memberJoin";
	}else{
		alert("약관에 동의해주세요.")	
	}
});

let head = document.getElementById("head");
head.addEventListener("click", function(){
	head.style.backgroundColor="pink";
});

d1.addEventListener("click", function(){
	if(d1.checked){
		for(let c of c1){
		c.checked = true;
		}
	}else{
		for(let c of c1){
		c.checked = false;
		}
	}
});

for(let c of c1){
	c.addEventListener("click", function(){
		let result = 0;
		for(let c of c1){
			if(c.checked){
				result+=1;
			}
		}
		if(result==3){
			d1.checked=true;
		}else{
			d1.checked=false;
		}
	});


}