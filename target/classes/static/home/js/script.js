
//contient le code html nécessaire à l'affichage d'un loading (possible d'utiliser cette constante pour afficher un loader)
const html_loading = '<div class="content-loading"><svg class="spinner" width="65px" height="65px" viewBox="0 0 66 66" xmlns="http://www.w3.org/2000/svg"><circle class="path" fill="none" stroke-width="6" stroke-linecap="round" cx="33" cy="33" r="30"></circle></svg></div>';

//executé lorsque la page a chargé
$(document).ready(function(){

    initElementsIHM();

    setTimeout(function(){
        loadListeBook();
    }, 2000);
})

//permet d'initialiser certaines éléments de l'interface
function initElementsIHM(){

    //initialise l'input de date publication
    $("#datePublication").datepicker({
        dateFormat: "dd/mm/yy"
    });  

}

function loadListeBook(){
    $.get(
        "/home/listebooks"
    ).done(function(data){
        var htmlListeBook = fabriqueListeBook(data);
        $("#content-listebook-complete").html(htmlListeBook);
    })
}

function fabriqueListeBook(data){

    var htmllistebook = "";        

    if(data != null && data.length > 0){
        
        for(var i = 0; i < data.length; i++){

            var unLivre = data[i];

            htmllistebook += 
                '<div class="content-unbook">' + 
                    '<div class="iconeBook"><i class="fas fa-book"></i></div>' + 
                    '<div class="content-column-unbook"><span class="text-for-book text-title-book">' + langue_used.textTitleBook + '</span> ' + unLivre.titre + '</div>' +
                    '<div class="content-column-unbook"><span class="text-for-book text-langue-book">' + langue_used.textLangueBook + '</span> ' + unLivre.langue.langue + '</div>' +
                    '<div class="content-column-unbook"><span class="text-for-book text-date-book">' + langue_used.textDateBook + '</span> ' + new Date(unLivre.dateajout).toLocaleString() + '</div>' +
                '</div>';
        }

    }else{
        htmllistebook = "<div class='book-not-found'>" + langue_used.textAucunBookTrouve + "</div>";
    }
    
    return htmllistebook;
}

function initSearchWithFilter(){

    var filters = {};

    //recupere le titre s'il est recherché
    filters = verifiyTitleValid(filters);
    //recupere la langue si elle est recherché
    filters = verifiyLangueValid(filters);
    //recupere la date de publication sélectionné par l'utilisateur
    filters = verifiyDatePublicationValid(filters);
    
    console.log(filters);

    //execute la methode permettant la recherche
    executeSearchFilter(filters, function(data){

        //executé apres le retour de la requete
        var listeBook = fabriqueListeBook(data);
        $("#content-filtrebook-complete").html(listeBook);

    });
}

function verifiyTitleValid(filters){
    var titre = $("#filtreTitre").val();
    if(titre != null && titre != ""){
        filters.titre = titre;
    }
    return filters;
}

function verifiyLangueValid(filters){
    var langue = $("#selectLangue").val();
    if(langue != null && langue != ""){
        filters.langue = langue;
    }
    return filters;
}

function verifiyDatePublicationValid(filters){
    var datepublication = $("#datePublication").val();
    if(datepublication != null && datepublication != ""){
        datepublication = parseDateToMySqlFormat(datepublication);
        if(datepublication != null){
            filters.datepublication = datepublication;
        }
    }
    return filters;
}

function executeSearchFilter(filters, callback){

    //si la class showsearch n'est pas encore attaché, alors on affiche la fenêtre
    if(!$(".content-listebook").hasClass("showsearch")){

        $(".content-listebook").addClass("toshowsearch");
        
        setTimeout(function(){
            $(".content-listebook").addClass("showsearch");

            setTimeout(function(){
                $(".content-listebook").removeClass("toshowsearch");
                getLivresWithFilters(filters, callback);
            }, 10);

        }, 500);

    //sinon on affiche le loading avant de faire la récupération du filtre
    }else{
        $("#content-filtrebook-complete").html(html_loading);

        setTimeout(function(){
            getLivresWithFilters(filters, callback);
        }, 1000);
    }
}

function getLivresWithFilters(filters, callback){

    $.ajax({
        url:"/home/search",
        type:"POST",
        data: JSON.stringify(filters),
        contentType:"application/json",
        dataType:"json",
        success: function(data){
            callback(data);
        }
    })

}

function annuleFilters(){

    $(".content-listebook").addClass("toshowsearch");
        
    setTimeout(function(){
        $(".content-listebook").removeClass("showsearch");

        setTimeout(function(){
            $(".content-listebook").removeClass("toshowsearch");
            loadListeBook(); //permet de charger la liste des 20 livres
        }, 10);

    }, 500);

}