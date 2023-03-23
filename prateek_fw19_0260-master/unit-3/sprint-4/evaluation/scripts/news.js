// Ude Import export (MANDATORY)
import navbar from "../components/navbar.js";
document.getElementById("navbar").innerHTML = navbar;
let details = JSON.parse(localStorage.getItem("news"));
console.log(details)
let img = document.createElement("img");
img.src = details.urlToImage;
let h = document.createElement("h2");
h.innerText = details.title;
let h1 = document.createElement("h3");
h1.innerText = details.description;
let p = document.createElement("p");
p.innerText = details.content;
document.getElementById("detailed_news").append(img,h,h1,p)

document.getElementById("search_input").addEventListener("keypress",()=>{
    if(event.keyCode==13){
        console.log(document.getElementById("search_input").value);
        let val = document.getElementById("search_input").value;
      localStorage.setItem("search",JSON.stringify(val));
        window.location.href = "search.html"
    }
})