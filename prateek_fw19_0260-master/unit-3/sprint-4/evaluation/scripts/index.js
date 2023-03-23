// Ude Import export (MANDATORY)
// Onclicking store the news in local storage with key "news" so that you can access that on news.html page

import navbar from "../components/navbar.js"
document.getElementById("navbar").innerHTML = navbar;
import {india,china,US,UK,newzeland, search } from "../components/append.js"

document.getElementById("in").addEventListener("click",()=>{
    india();
})
document.getElementById("ch").addEventListener("click",()=>{
    china();
})
document.getElementById("us").addEventListener("click",()=>{
    US();
})
document.getElementById("uk").addEventListener("click",()=>{
    UK();
})
document.getElementById("nz").addEventListener("click",()=>{
    newzeland();
})
document.getElementById("search_input").addEventListener("keypress",()=>{
    if(event.keyCode==13){
        console.log(document.getElementById("search_input").value);
        let val = document.getElementById("search_input").value;
      localStorage.setItem("search",JSON.stringify(val));
        window.location.href = "search.html"
       
    }
})
india();



  