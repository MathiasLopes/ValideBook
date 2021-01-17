
//contient le code html nécessaire à l'affichage d'un loading (possible d'utiliser cette constante pour afficher un loader)
const html_loading = '<div class="content-loading"><svg class="spinner" width="65px" height="65px" viewBox="0 0 66 66" xmlns="http://www.w3.org/2000/svg"><circle class="path" fill="none" stroke-width="6" stroke-linecap="round" cx="33" cy="33" r="30"></circle></svg></div>';

//executé lorsque la page a chargé
$(document).ready(function(){
    setTimeout(function(){
        loadListeBook();
    }, 2000);
})

function loadListeBook(){
    $.get(
        "/home/listebooks"
    ).done(function(data){
        var htmlListeBook = fabriqueListeBook(data);
        $("#content-listebook-complete").html(htmlListeBook);
    })
}

function fabriqueListeBook(data){

    console.log(data);

    var htmllistebook = "";        

    if(data != null && data.length > 0){
        
        for(var i = 0; i < data.length; i++){

            var unLivre = data[i];

            htmllistebook += 
                '<div class="content-unbook">' + 
                    '<div class="content-column-unbook">Titre : ' + unLivre.titre + '</div>' +
                    '<div class="content-column-unbook">Langue : ' + unLivre.langue.langue + '</div>' +
                    '<div class="content-column-unbook">Date d\'ajout : ' + new Date(unLivre.dateajout).toLocaleString() + '</div>' +
                '</div>';
        }

    }else{
        htmllistebook = "<div class='book-not-found'>Aucun livre retrouvé</div>";
    }
    
    return htmllistebook;
}





