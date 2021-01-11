$(document).ready(function(){
    var allConteneur = $(".conteneur");
    showAllConteneur(allConteneur, 0);
});

function showAllConteneur(obj, index){
    setTimeout(function(){ 
        if(index < obj.length){
            $(obj[index]).addClass("show");
            index++;
            showAllConteneur(obj, index);
        }
    }, 350 )
}