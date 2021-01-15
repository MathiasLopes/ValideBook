var langue_used = {
    bienvenu: "Bienvenue sur ValideBook",
    btSeConnecter: "Se connecter",
    champEmail: "Email",
    champPassword: "Mot de passe",
    idInvalideOrPasswordForgotten: "Identifiant ou mot de passe invalide",
    champDisconnected:"Vous avez été déconnecté"
}

var jsonlangueforhtml = [{
    langue: "francais"
},{
    langue: "anglais"
}]

$(document).ready(function(){

    addAllDrapeau();
    addFunctionShowDrapeau();

});

function addFunctionShowDrapeau(){

    $("#chooselanguages").unbind();
    $("#chooselanguages").click(function(){
        showOrHideAllDrapeau();
    });

}

function showOrHideAllDrapeau(){

    if($(".parent-parentlanguagetochoose").hasClass("show")){
        $(".parent-parentlanguagetochoose").removeClass("show")
    }else{
        $(".parent-parentlanguagetochoose").addClass("show")
    }

}

function addAllDrapeau(){

    var htmlToAdd = "";

    for(var i = 0; i < jsonlangueforhtml.length; i++){
        htmlToAdd += '<div onclick="loadLanguagePage(\'' + jsonlangueforhtml[i].langue + '\');" class="parentlanguagetochoose">' +
                        '<div class="imagelanguagetochoose ' + jsonlangueforhtml[i].langue + '"></div>' +
                    '</div>';
    }

    $(".parent-parentlanguagetochoose").html(htmlToAdd)

}

function loadLanguageWithFile(langue, callback){

    var requestbase = "/global/languages/francais.json";

    switch(langue){
        case "francais":
            requestbase = "/global/languages/francais.json";
            break;
        case "anglais":
            requestbase = "/global/languages/anglais.json";
            break;
        default:
            break;
    }

    //set le language dans la variable par default
    loadLangueWithRequest(requestbase, function(data){
        langue_used = data;
        callback();
    });
}

//va chercher le fichier json
function loadLangueWithRequest(request, callback){
    $.get(request).done(function(data){
        callback(data);
    })
}