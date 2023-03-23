let rating;
      let p1;
     
      document.querySelector("button").addEventListener("click",function(){
        let data = [];
        let box = document.querySelector("#body")
        box.innerHTML = "";
        let name = document.querySelector("input").value;
        let url = `https://www.omdbapi.com/?apikey=830fd63c&s=${name}`;
    fetch(url).then(function(res){
        return res.json();
    })
    // .then(function(res){
    //    console.log(res);
    // })
    .then(function(res){
     let x = res.Search;  
      
     x.forEach(function(el){

      let url1 = `https://www.omdbapi.com/?apikey=830fd63c&i=${el.imdbID}`
          fetch(url1).then(function(res){
           return res.json() ;
          }).then(function(res){

            data.push(res);
            localStorage.setItem("movies",JSON.stringify(data));
            append(res);
          })
       
     });
  
    })
    .catch(function(er){

        let img = document.createElement("img");
        img.src = "https://camo.githubusercontent.com/09229f8318551151d691b58bb82d03a56b13f5ec007b095dcecd42af71710afd/68747470733a2f2f692e70696e696d672e636f6d2f6f726967696e616c732f62642f64662f64362f62646466643665343433346634323636326230303932393563396261623836652e676966";
        img.style.width = "100%"
          document.querySelector("#body").append(img);
          console.log(er);
           })
      })

   

      document.querySelector("#filter").addEventListener("click",function(){
        let year = document.querySelector("#year").value;
        document.getElementById("body").innerHTML = "";
       let datafrmLS = JSON.parse(localStorage.getItem("movies"));
      let y = datafrmLS.filter(function(el){
         return el.Year == year;
       })
       if(y.length > 0){
        y.forEach(function(el){
         append(el);
       })
       }else{
        let img = document.createElement("img");
        img.src = "https://camo.githubusercontent.com/09229f8318551151d691b58bb82d03a56b13f5ec007b095dcecd42af71710afd/68747470733a2f2f692e70696e696d672e636f6d2f6f726967696e616c732f62642f64662f64362f62646466643665343433346634323636326230303932393563396261623836652e676966";
        img.style.width = "100%"
          document.querySelector("#body").append(img);
       }
       document.querySelector("#year").value = null;
      })





   

      function sort(){
        document.getElementById("body").innerHTML = "";
       let datafrmLS = JSON.parse(localStorage.getItem("movies"));
       let select = document.querySelector("#sort").value;
       if(select == "nto"){
        datafrmLS.sort(function(a,b){
        return Number(b.Year) - Number(a.Year);
       })
       }else if(select == "otn"){
        datafrmLS.sort(function(a,b){
        return Number(a.Year) - Number(b.Year);
       })
       }
  
       datafrmLS.forEach(function(el){
        console.log(el);
         append(el);
       })
      }


// function to append to the body
      function append(term){
        let div = document.createElement("div");
        let div1 = document.createElement("div");
        let img = document.createElement("img");
        img.setAttribute("src",term.Poster);
        img.alt = "Poster Image"
        let img2 = document.createElement("img");
        img2.style.width = "80%"
        img2.src = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRLsGSatkQVDUbomDSy5mJJtoi42Nb2HmtWgQ&usqp=CAU"
        let h = document.createElement("h3");
         let p1 = document.createElement("p");
        let p = document.createElement("p");
        let p2 = document.createElement("p");
        let btn = document.createElement("button");
        btn.innerText = "More About the Movie/Series";
        btn.addEventListener("click",function(){
            show(term);
        })
        h.innerText = term.Title;
        p1.innerText = `Rating:- ${term.imdbRating}`;
        p.innerText = `Released year:- ${term.Year}`;
        p2.innerText = `Type:- ${term.Type}` ;
        if(+term.imdbRating > 8.5){
            div1.append(h,p,p1,p2,btn,img2);
        div.append(img,div1);
        }else{
            div1.append(h,p,p1,p2,btn);
        div.append(img,div1);
        }
        document.getElementById("body").append(div);
      }
    
      function show(el){
              
              let data = [];
             const url1 = `https://www.omdbapi.com/?apikey=830fd63c&i=${el.imdbID}`;
             fetch(url1).then(function(res){
               return res.json();
             }).then(function(res){
               data.push(res)
               localStorage.setItem("aboutmovie",JSON.stringify(data));
               console.log(data);
                 window.location.href = "aboutmovie.html"
             })
                }