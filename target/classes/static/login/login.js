
$(document).ready(function(){
    //permet de charger le language dans la page
    loadLangueLogin();
});

//permet de remplacer les champs avec la langues définis
function loadLangueLogin(){
    $("#titreBienvenue").html(langue_used.bienvenu);
    $("#labelEmail").html(langue_used.champEmail);
    $("#labelPassword").html(langue_used.champPassword);
    $("#btnSeConnecter").html(langue_used.btSeConnecter);
    $("#idInvalideOrPasswordForgotten").html(langue_used.idInvalideOrPasswordForgotten);
    $("#champDisconnected").html(langue_used.champDisconnected);
}

//méthode par défaut permettant à chaque site de charger sa langue avec le module de langue ajouté
// /global/languages/base_languages.css et /global/languages/base_languages.js
function loadLanguagePage(langue){
    loadLanguageWithFile(langue, function(){
        loadLangueLogin();
    });
}