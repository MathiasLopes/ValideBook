


$(document).ready(function(){
    //permet de charger le language dans la page
    loadLangueHome();
});

//permet de remplacer les champs avec la langues définis
function loadLangueHome(){
    $(".text-title-book").html(langue_used.textTitleBook);
    $(".text-langue-book").html(langue_used.textLangueBook);
    $(".text-date-book").html(langue_used.textDateBook);
    $("#btDeconnexion").html(langue_used.textBtDeconnexion);
    $("#title-listbook").html(langue_used.textTitle20livre);
    $("#title-search").html(langue_used.textTitleSearch);
    $("#btnRechercher").html(langue_used.textBtnSearch);
    $(".book-not-found").html(langue_used.textAucunBookTrouve);
    $("#title-filtrebook .title").html(langue_used.textTitleWindowBookFilter);
    $("#textFiltreTitre").html(langue_used.textTitleFilters);
    $("#btAnnulerFiltre").html(langue_used.btAnnulerFilters);
}

//méthode par défaut permettant à chaque site de charger sa langue avec le module de langue ajouté
// /global/languages/base_languages.css et /global/languages/base_languages.js
function loadLanguagePage(langue){
    loadLanguageWithFile(langue, function(){
        loadLangueHome();
    });
}