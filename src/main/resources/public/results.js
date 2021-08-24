window.onload = function(){
    var HttpClient = function() {
        this.get = function(aUrl, aCallback) {
        var anHttpRequest = new XMLHttpRequest();
        anHttpRequest.onreadystatechange = function() {
            if (anHttpRequest.readyState == 4 && anHttpRequest.status == 200)
                aCallback(anHttpRequest.responseText);
            }
            anHttpRequest.open( "GET", aUrl, true );
            anHttpRequest.send( null );
        }
    }
    var getUrl = function() {
        var res="";
        var queryString = window.location.search;
        var urlParams = new URLSearchParams(queryString);
        var fun = urlParams.get('sl-menu-series');
        var  symbol= urlParams.get('data-exchange');
        res="https://www.alphavantage.co/query?function="+fun+"&symbol="+symbol+"&apikey=B94U975WONAHGDI1"
        return res
    }
    var doc = document.getElementById('btn-success');

    doc.onclick = function (){
        var client = new HttpClient();
        console.log(getUrl());
        client.get(getUrl(), function(response) {
            $('p#flag').text(response);
            let obj = JSON.parse(response);
            obj =obj[$("#sl-menu-series option:selected").text()];
        });
    }
}
