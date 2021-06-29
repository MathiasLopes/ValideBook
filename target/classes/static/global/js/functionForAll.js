
//permet de transformer une date au format dd/mm/yyyy vers le format yyyy-mm-dd
function parseDateToMySqlFormat(date){

    if(date.length == 10 && date.indexOf("/") != -1){

        date = date.split("/");

        if(date.length == 3){
            //on renvoie la valeur parsé
            return date[2] + "-" + date[1] + "-" + date[0];
        }
    }

    //s'il arrive ici c'est qu'une condition n'a pas été respecté
    return null;
}