
function checkValue() {
    var result = false;
    var idFalg = false;
    var pwFlag = false;
    //비밀번호 검증
    var inputPw1 = $('#inputPw1').val();
    var inputPw2 = $('#inputPw2').val();
    if(inputPw1 == ""){
        pwFlag = false;
        $("#inputPw1_check").text("필수 정보입니다.");
        $("#inputPw1_check").css("color","red");
    }
    if(inputPw2 == ""){
        pwFlag = false;
        $("#inputPw2_check").text("필수 정보입니다.");
        $("#inputPw2_check").css("color","red");
    }

    if(inputPw1 !="" && inputPw2 !=""){
        if (inputPw1 != inputPw2) {
            pwFlag = false;
            $("#inputPw2_check").text("비밀번호가 일치하지 않습니다.");
            $("#inputPw2_check").css("color", "red");
        } else {
            pwFlag = true;
            $("#inputPw1_check").text("");
            $("#inputPw2_check").text("비밀번호가 일치합니다.");
            $("#inputPw2_check").css("color", "green");
        }
    }
    //아이디 검증
    var memberId = $('#inputId').val();
    if(memberId == ""){
        idFalg = false;
        $("#inputId_check").text("필수 정보입니다.");
        $("#inputId_check").css("color","red");
    }
    else{
        $.ajax({
            url:'/member/idCheck?memberId='+memberId,
            type: 'get',
            async: false,   //값을 리턴시 해당코드를 추가하여 동기로 변경
            success : function (data) {
                if(data == 1){
                    idFalg = false;
                    $("#inputId_check").text("이미 사용중인 아이디 입니다.");
                    $("#inputId_check").css("color","red");
                }
                else{
                    idFalg = true;
                    $("#inputId_check").text("사용가능한 아이디 입니다.");
                    $("#inputId_check").css("color","green");
                }
                //회원가입 submit유무
                if(idFalg == true && pwFlag == true)
                    result =  true;
            }
        })
    }
    return result;

}