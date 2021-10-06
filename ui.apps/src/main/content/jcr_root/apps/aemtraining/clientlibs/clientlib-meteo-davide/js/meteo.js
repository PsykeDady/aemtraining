console.log("WeatherDavAjax");
var percorso = window.location.pathname
percorso = percorso.split(".")[0]
percorso=percorso+"/jcr:content/root/container/container/weatherdavide.json"

console.log("percorso=",percorso);
$(document).ready(function(){
    $.ajax({
        url: percorso,
        dataType: "json",
        success: function(result){
            var htmlTemplate = $("#weatherTemplate").html();
            var template = Handlebars.compile(htmlTemplate);
            $("#weatherContainer").html(template(result));
            console.log("successo" + result);
        },
        error: function(error){
            console.log("errore" + error);
        }
    });
});
