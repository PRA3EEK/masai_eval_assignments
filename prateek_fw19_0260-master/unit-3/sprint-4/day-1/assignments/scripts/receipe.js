import navbar from "../components/navbar.js";
document.getElementById("nav").innerHTML = navbar;
import { getdata,append } from "../components/fetch.js";
let url = "https://www.themealdb.com/api/json/v1/1/search.php?s=chicken";
let url_1 = "https://www.themealdb.com/api/json/v1/1/search.php?s=beef";
let cont = document.getElementById("cont-3");
getdata(url).then((res)=>{
append(res.meals,cont);
})
getdata(url_1).then((res)=>{
    append(res.meals,cont);
    })