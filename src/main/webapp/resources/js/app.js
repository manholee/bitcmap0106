//ajax 시작 전

//자바스크립트 객체 만드는 문법
var app = app || {};
app.path=(()=>{
	var init = x=>{
		alert($('#content').text()); // main에서 호출하면 alert으로 연결 확인 자바스크립트랑 자바 연결되는지 확인하는 것
		app.login_page.onCreate();
		sessionStorage.setItem('x',x);
	};
	var ctx = ()=>{
		return sessionStorage.getItem('x');
	}
	return {init:init,ctx:ctx};
})();

//main이라는 인스턴스 밑에 init 메소드 선언 , function ()=> 로 대체

app.login_page=(()=>{
	return{
		onCreate : ()=>{
			$('#content').empty();
			alert('ppp'+$('#content').text());
			$('#content').html(app.login_page.setContentView());
			$('#pass_div').append();
/*			  +'<button type="submit" class="btn btn-primary" style="width: 20%; margin-left: 30px; margin-right: 20px">로그인</button>'
			  +'<button type="reset" class="btn btn-primary" style="width: 20%; margin-left: 30px; margin-right: 20px">취소</button>'*/
			app.compo.button('login_btn')
			.css({'width':'40%','margin-left':'30px','margin-right':'20px' })
			.text('로 그 인')
			.appendTo($('#pass_div'))
			.click(e=>{
				$.ajax({
					url : app.path.ctx()+'/get/login',
					method : 'POST',
					data : JSON.stringify({
						id : $('#userId').val(),
						pw : $('#password').val()
					}), //Json언어는 자바 언어로 변경하라?
					contentType : 'application/json',
					success : d =>{
						
						alert('ID:' + d.id + ', ID2:' + $('#userId').val());
						alert('PASS:' + d.pw + ', PASS2:' + $('#password').val());
						
						
						if(d.id === $('#userId').val() && d.pw === $('#password').val()) {
							alert("SUCCESS");
						} else {
							alert("FAIL");
						}
						alert('success'+ data.id);
					},
					error : (x,s,m)=>{ //메세지
						alert('오류발생:' +m);
					}
				});
			});
		},
		setContentView : ()=>{
			return '<table style="width: 100%; height: 600px" id="login_table">'
			+'<tr style="width: 100%; height: 30%" >'
				+'<td></td>'
				+'<td><h1 style="text-align:center;">로그인 화면</h1></td>'
				+'<td></td>'
			+'</tr>'
			+'<tr style="width: 100%; height: 30%">'
				+'<td></td>'
				+'<td>'	
					  +'<div class="form-group">'
					    +'<label for="exampleInputEmail1">ID</label>'
					    +'<input id="userId" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter email">'
					    +'<small id="emailHelp" class="form-text text-muted">Well never share your email with anyone else.</small>'
					  +'</div>'
					  +'<div id="pass_div" class="form-group">'
					    +'<label for="exampleInputPassword1">Password</label>'
					    +'<input id="password" type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">'
					  +'</div>'
				+'</td>'
				+'<td></td>'
			+'</tr>'
			+'<tr style="width: 100%; height: 30%">'
				+'<td style="width: 33%;"></td>'
				+'<td style="width: 33%;"></td>'
				+'<td style="width: 33%;"></td>'
			+'</tr>'
			+'</table>';
		}
	};
})(); //(); 실행함수
//composition ? **** IIF(즉시실행O) 방식 객체 리터럴 방식(즉시실행 X) 위에 코드는 IIF 밑에는 리터럴 방식!!!
app.compo={
	button : x =>{
		return $('<button/>',{id: x, class:'btn btn-primary'});
	}
}

