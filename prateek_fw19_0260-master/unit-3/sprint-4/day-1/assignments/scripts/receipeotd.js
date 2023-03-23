import navbar  from "../components/navbar.js";
document.getElementById("nav").innerHTML = navbar;
import { getdata,append } from "../components/fetch.js";
let url = "https://www.themealdb.com/api/json/v1/1/search.php?s=pasta"
let cont = document.getElementById("cont-2");
getdata(url).then((res)=>{

append(res.meals,cont);
})