let datafrmLS = JSON.parse(localStorage.getItem("aboutmovie"));

datafrmLS.forEach(function(el,indx){
    let img = document.createElement("img");
    img.setAttribute("src",el.Poster);
    document.getElementById("1st").append(img);
     let h = document.createElement("h3");
     
      h.innerText = el.Title
     let p = document.createElement("p");
     if(el.Type == undefined){
        p.innerText = `Type : N/A`
     }else{
        p.innerText = el.Type;
     }
   
     let p2 = document.createElement("p");
     if(el.imdbRating == undefined){
        p2.innerText = `IMDB Rating : N/A`
     }else{
        p2.innerText = `IMDB Rating : ${el.imdbRating}`
     }
  
     let p3 = document.createElement("p");
     if(el.imdbVotes == undefined){
        p3.innerText = `Votes : N/A`
     }else{
        p3.innerText = `Votes : ${el.imdbVotes}`
     }
     let p4 = document.createElement("p");
     if(el.Released == undefined){
        p4.innerText = `Release Date : N/A`
     }else{
        p4.innerText = `Release Date : ${el.Released}`
     }
     
     let p5 = document.createElement("p");
     if(el.Genre == undefined){
        p5.innerText = `Genre : N/A`
     }else{
        p5.innerText = `Genre : ${el.Genre}`;
     }
    
     let p6 = document.createElement("p");
     if(el.Plot == undefined){
        p6.innerText = `Plot : N/A`
     }else{
        p6.innerText = `Plot : ${el.Plot}`;
     }
  
     let p7 = document.createElement("p");
     if(el.Actors == undefined){
        p7.innerText = `Actors : N/A`
     }else{
        p7.innerText = `Actors : ${el.Actors}`;
     }
     
     let p8 = document.createElement("p");
     if(el.Director == undefined){
        p8.innerText = `Director : N/A`
     }else{
        p8.innerText = `Director : ${el.Director}`;
     }
     
     let p9 = document.createElement("p");
     if(el.Writer == undefined){
        p9.innerText = `Writer : N/A`
     }else{
        p9.innerText = `Writer : ${el.Writer}`;
     }
   
     let p10 = document.createElement("p");
     if(el.Production == undefined){
        p10.innerText = `Production : N/A`
     }else{
        p10.innerText = `Production : ${el.Production}`;
     }
  
     let p11 = document.createElement("p");
     if(el.Country == undefined){
        p11.innerText = `Country : N/A`
     }else{
        p11.innerText = `Country : ${el.Country}`;
     }
     let p12 = document.createElement("p");
     if(el.Language == undefined){
        p12.innerText = `Language : N/A`
     }else{
        p12.innerText = `Language : ${el.Language}`;
     }
   
     let p13 = document.createElement("p");
     if(el.Awards == undefined){
        p13.innerText = `Awards : N/A`
     }else{
        p13.innerText = `Awards : ${el.Awards}`;
     }
     let p14 = document.createElement("p");
     if(el.BoxOffice == undefined){
        p14.innerText = `Box Office : N/A`
     }else{
        p14.innerText = `Box Office : ${el.BoxOffice}`
     }
    
    document.getElementById("2nd").append(h,p,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14);
})