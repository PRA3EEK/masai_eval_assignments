
    // localStorage.setItem("images", JSON.stringify(images));
 
    let i=0;
    let Z ;
    function slideShow(){
        let images = [
        "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/interstellar2_500x749.jpg?v=1585846823",
        "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/darkknight.building.24x36_500x749.jpg?v=1648745689",
    
    "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/278191178_1171745153585062_1345767940313038136_n_500x749.jpg?v=1655394109",
    "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/108b520c55e3c9760f77a06110d6a73b_e97cf224-d57f-44e3-8477-4f5479cd746b_500x749.jpg?v=1573616089",
    "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/ef4b93ef8f7157de3f97ae1ff5d21b56_0526bb98-1f4a-4da5-b928-b0025f5e6371_500x749.jpg?v=1573585487",
    "https://cdn.shopify.com/s/files/1/0057/3728/3618/products/e50345d7cfee907ad63bb835109b37b9_263eaa00-ac40-4a0e-b2d7-86bb4ac69c90_500x749.jpg?v=1573584652","https://cdn.shopify.com/s/files/1/0057/3728/3618/products/4c143aca11022bf3f2c4457884f3ac67_8bce8abb-c6fb-4437-b057-70880f46d8e6_500x749.jpg?v=1573616101"
        ]
        // let images = JSON.parse(localStorage.getItem("images"));
        let container = document.getElementById("slideshow");
       
    
       Z = setInterval(function(){
        if(i === images.length){
            i = 0;
        } 
    
        let img = document.createElement("img");
        img.src = images[i];
        container.innerHTML = null;
        container.append(img);
        i++;
        },2000);
    }
        //   function pause(){
        //     clearInterval(Z);
        //   }
      
        slideShow();
    
    
    
    
    
    
        function obj(n,rd,p,r){
            this.name = n;
            this.release_date = rd;
            this.poster = p;
            this.rating = r;
        }
        let mobj = new obj("The Shawshank Redemption","22 sept 1994","https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_FMjpg_UX1000_.jpg","9.2");
        let mobj2 = new obj("The Godfather","24 March 1972","https://cdn.shopify.com/s/files/1/0057/3728/3618/products/the-godfather_lkfmijop_500x749.jpg?v=1645738174","9.2");
        let mobj3 = new obj("The Dark Knight","18 July 2008","https://cdn.shopify.com/s/files/1/0057/3728/3618/products/darkknight.building.24x36_500x749.jpg?v=1648745689","9");
        let mobj4 = new obj("Batman Begins","17 june 2005","https://m.media-amazon.com/images/M/MV5BOTY4YjI2N2MtYmFlMC00ZjcyLTg3YjEtMDQyM2ZjYzQ5YWFkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg","8.2");
        let mobj5 = new obj("Batman v Superman: Dawn of Justice","25 March 2016","https://m.media-amazon.com/images/M/MV5BYThjYzcyYzItNTVjNy00NDk0LTgwMWQtYjMwNmNlNWJhMzMyXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg","6.4");
        let mobj6 = new obj("The Batman","4 March 2022","https://m.media-amazon.com/images/M/MV5BMDdmMTBiNTYtMDIzNi00NGVlLWIzMDYtZTk3MTQ3NGQxZGEwXkEyXkFqcGdeQXVyMzMwOTU5MDk@._V1_SX300.jpg","7.9");
        let mobj7 = new obj("Avengers: Endgame","26 April 2019","https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_SX300.jpg","8.4");
        let mobj8 = new obj("Phir Hera Pheri","9 June 2006","https://m.media-amazon.com/images/M/MV5BNzgzYjZjYzMtNjcyYy00NWI3LTg1NDItOTMzMzdhMjhjNWExXkEyXkFqcGdeQXVyNjA3OTI5MjA@._V1_SX300.jpg","7.1");
        let mobj9 = new obj("One Day","23 December 2011","https://m.media-amazon.com/images/M/MV5BMTQ3NTg2MDI3NF5BMl5BanBnXkFtZTcwMjc5MTA1NA@@._V1_SX300.jpg","7");
        let mobj10 = new obj("I Want to Eat Your Pancreas","1 September 2018","https://m.media-amazon.com/images/M/MV5BNDM4MWE3NGQtODlkYS00NWU5LTg3ZjMtMTEyNjljOWI4NWIxXkEyXkFqcGdeQXVyNzkzODk2Mzc@._V1_SX300.jpg","8");
        let mobj11 = new obj("RRR","24 March 2022","https://m.media-amazon.com/images/M/MV5BOTA5NzQwMGMtNDRlZC00YzA4LTliMzQtNGM0NDIwYTk5Y2ZiXkEyXkFqcGdeQXVyMTIyNzY0NTMx._V1_SX300.jpg","9");
        let mobj12 = new obj("Wanted","18 September 2009","https://m.media-amazon.com/images/M/MV5BZWYyYWFhYWEtMzlkOS00NTRiLTg2MTYtMjgwMjdiYWZlYTVjXkEyXkFqcGdeQXVyNjE4MTE3MDY@._V1_SX300.jpg","6.6");
        let mobj13 = new obj("Interstellar","7 November 2014","https://m.media-amazon.com/images/M/MV5BZjdkOTU3MDktN2IxOS00OGEyLWFmMjktY2FiMmZkNWIyODZiXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_SX300.jpg","8.6");
        let mobj14 = new obj("3 Idiots","25 December 2009","https://m.media-amazon.com/images/M/MV5BNTkyOGVjMGEtNmQzZi00NzFlLTlhOWQtODYyMDc2ZGJmYzFhXkEyXkFqcGdeQXVyNjU0OTQ0OTY@._V1_SX300.jpg","8.6"); 
     let moviesdata =  [];
       
     moviesdata.push(mobj,mobj2,mobj3,mobj4,mobj5,mobj6,mobj7,mobj8,mobj9,mobj10,mobj11,mobj12,mobj13,mobj14);
     localStorage.setItem("movies-2",JSON.stringify(moviesdata));
    
     
     moviesdata.forEach(function(el){
        add(el)
     })
      function add(el){
        let div = document.createElement("div");
        let img = document.createElement("img")
        img.src = el.poster;
        let h3 = document.createElement("h3");
          h3.innerText = el.name;
        let p = document.createElement("p");
        p.innerText = `IMDB Rating :- ${el.rating}`;
        let p1 = document.createElement("p");
        p1.innerText = `Release date :- ${el.release_date}`;
        div.append(img,h3,p,p1);
        document.querySelector("#movies").append(div);
       
      }
    function sortdata(){
        document.querySelector("#movies").innerHTML = null;
        let value = document.querySelector("#sort").value;
        if (value == "lth"){
            moviesdata.sort(function(a,b){
        return +a.rating - +b.rating; 
      })
        }else if(value == "htl"){
            moviesdata.sort(function(a,b){
        return +b.rating - +a.rating; 
      })
        }
     
        moviesdata.forEach(function(el){
          add(el);
        })
    }