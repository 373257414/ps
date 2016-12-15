function showPicture1()
{
    var keys = document.getElementsByTagName("input");
    var place_holder = document.getElementById("placeholder");
    if(isFilled(keys[0]) == false)
        {
            alert("«Î ‰»Îπÿº¸¥ ");
            return false;
        }
    if(keys[0].value != "main")
        {
            alert("Œ¥’“µΩÕº∆¨");
            place_holder.setAttribute("src","img/placeholder.gif");
            return false;
        }
    if(keys[0].value == "main")
        {
            place_holder.setAttribute("src","img/background.jpg");
            place_holder.setAttribute("width","400px");
        }
}
function isFilled(field)
{
    if(field.value.replace(' ','').length ==0)
        {
            return false;
        }
    var placeholder = field.placeholder || field.getAttribute("placeholder");
    return (field.value != placeholder);
}
addLoadEvent(showPicture1);