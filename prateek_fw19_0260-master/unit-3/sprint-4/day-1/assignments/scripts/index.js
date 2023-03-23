import navbar from "../components/navbar.js";
console.log(navbar);
document.getElementById("nav").innerHTML = navbar;
import { getdata, append, error } from "../components/fetch.js";




let login = JSON.parse(localStorage.getItem("login")) || [];
if(login.length>0){
  document.getElementById("login").innerHTML = "";
  document.getElementById("login").innerText = login[0].name;
  document.getElementById("signup").innerHTML = "";
  document.getElementById("signup").innerText = "Sign Out";
  document.getElementById("signup").addEventListener("click",()=>{
    localStorage.removeItem("login");
    window.location.reload();
  })
}

document.getElementById("query").addEventListener("keypress", () => {
  if (event.keyCode == 13) {
    let search = document.getElementById("query").value;
    console.log(search)
    let cont = document.querySelector("#cont-1");
    cont.innerHTML = "";
    let url = `https://www.themealdb.com/api/json/v1/1/search.php?s=${search}`;
    getdata(url).then((res) => {
      console.log(res)
      console.log(res.meals);
      append(res.meals, cont);
    }).catch((rej) => {
      error(cont);
    })

  }

})


