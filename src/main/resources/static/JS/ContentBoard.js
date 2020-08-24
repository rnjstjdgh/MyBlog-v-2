function checkKeywordEmpty() {
    var keyword = $("#keywordStr").val();
    if(keyword ==""){
        $("#inputKeyword_check").text("검색어를 입력해 주세요.");
        $("#inputKeyword_check").css("color","red");
        return false;
    }
    else
        return true;
}