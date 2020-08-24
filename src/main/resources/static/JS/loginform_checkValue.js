var x = document.getElementById("inputId");
var y = document.getElementById("inputPw");
var errorMsg = document.getElementsByClassName("errmsg")
var e1 = errorMsg[0], e2 = errorMsg[1];
function checkValue() {
    e1.style.display = "none";
    e2.style.display = "none";
    var skip = false;
    if (x.value == "") {
        e1.style.display = "block";
        skip = true;
        return false;
    }
    if (!skip && y.value == "") {
        e2.style.display = "block";
        return false;
    }
}