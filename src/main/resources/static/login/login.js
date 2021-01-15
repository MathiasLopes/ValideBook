
$(document).ready(function(){

    //permet de charger le language dans la page
    loadLangueLogin();

});

function loadLangueLogin(){
    $("#titreBienvenue").html(langue_used.bienvenu);
    $("#labelEmail").html(langue_used.champEmail);
    $("#labelPassword").html(langue_used.champPassword);
    $("#btnSeConnecter").html(langue_used.btSeConnecter);
}

function loadLanguagePage(langue){
    loadLanguageWithFile(langue, function(){
        loadLangueLogin();
    });
}