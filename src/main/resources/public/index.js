window.onload=function(){
    var mb = document.getElementById("myform");
    mb.addEventListener("submit", (e)=>{
        e.preventDefault();
        const formData= new FormData(e.currentTarget)
        traerAlpha(formData).then (data=>{
            console.log($("#sl-menu-series option:selected").text());
            pegarInfo(data[$("#sl-menu-series option:selected").text()])
        })
    });
};
function pegarInfo(obj){
    let text = ''
                    for (let x in obj) {
                      var v1= x;
                      text += '<tr><th scope="row">' + x + '</th>';
                      for ( z in  obj[x] ){
                                       text += '<th scope="row">' + obj[x][z] + '</th>';
                      }
                      text+="</tr>"
                    }
                    text += ""
                    document.getElementById("demo").innerHTML = text;
}

async function traerAlpha(formData){
    const symbol = formData.get("data-exchange");
    const fun = formData.get("sl-menu-series");
    console.log(symbol+"  "+fun);
    //"https://www.alphavantage.co/query?function="+fun+"&symbol="+symbol+"&apikey=B94U975WONAHGDI1"
    const response = await fetch("https://heroku-app-arep.herokuapp.com/facadealpha?se="+fun+"&st="+symbol)
    const data = await response.json()
    return data
};