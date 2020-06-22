/**
 * 
 */
$(function () {
 $("td").dblclick(function () {
    var OriginalContent = $(this).text();

    $(this).addClass("cellEditing");
    $(this).html("<input type="text" value="&quot; + OriginalContent + &quot;" />");
    $(this).children().first().focus();

    $(this).children().first().keypress(function (e) {
        if (e.which == 13) {
            var newContent = $(this).val();
            $(this).parent().text(newContent);
            $(this).parent().removeClass("cellEditing");
        }
    });

 $(this).children().first().blur(function(){
    $(this).parent().text(OriginalContent);
    $(this).parent().removeClass("cellEditing");
 });
 });
});

window.onload = function()
{
    celdasTD = document.getElementById("tabla").getElementsByTagName("td")
    for ( var i = 0 ; i < celdasTD.length; i++)
    celdasTD.item(i).onclick = function(){celda(this)};
}
 
function celda(obj)
{
    for ( var i = 0 ; i < celdasTD.length; i++)
    celdasTD.item(i).style.backgroundColor = "";
    obj.style.backgroundColor = "red";
}