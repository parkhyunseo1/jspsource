// 추가 클릭 시 form submit 일어나면
// description 요소를 제외한 모든 요소에 값이 있는지 확인
// code는 4자리이고 숫자여야 함 
// price 는 3~10자리 숫자여야 함 
document.querySelector("body div:nth-child(3) form").addEventListener("submit", (e)=>{

e.preventDefault();
	
	const form = e.target;
	const code = document.querySelector("#code");
	const title = document.querySelector("#title");
	const writer = document.querySelector("#writer");
	const price = document.querySelector("#price");
	
	const regEx = /^[0-9]{3,10}$/;
	const regEx2 = /^[0-9]{4}$/;
	const TextReg = /[A-Za-z가-힣0-9]+/;
	
	if (!regEx.test(price.value)) {
		alert("가격을 입력하세요");
		//price.focus();
		price.select();  // focus + 입력값 존재 시 블럭으로 잡아줌
		return;
	}else if (!regEx2.test(code.value)) {
		alert("코드를 입력하세요");
		//price.focus();
		code.select();  // focus + 입력값 존재 시 블럭으로 잡아줌
		return;
	} else if (!TextReg.test(title.value)) {
		alert("제목을 입력하세요");
		title.select();
		return;
	} else if (!TextReg.test(writer.value)) {
		alert("작가명을 입력하세요");
		writer.select();
		return;
	}
	form.submit();
});