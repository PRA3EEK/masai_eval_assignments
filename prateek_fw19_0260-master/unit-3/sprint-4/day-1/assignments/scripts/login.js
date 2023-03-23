import navbar from "../components/navbar.js";
document.getElementById("nav").innerHTML = navbar;


let datafrmLS = JSON.parse(localStorage.getItem("Users")) || [];
let logindata = JSON.parse(localStorage.getItem("login")) || [];
if(logindata.length>0){
  document.getElementById("login").setAttribute("href","")
  let name = logindata[0].name.split(" ");
  document.getElementById("login").innerText = `Hello, ${name[0]}`;
  document.getElementById("signup").setAttribute("href","")
  document.getElementById("signup").innerText = "Sign Out";
  document.getElementById("signup").addEventListener("click",()=>{
    localStorage.removeItem("login");
    window.location.reload();
  })
}
let form = document.getElementById("form").addEventListener("submit", () => {
  event.preventDefault();
  verify();
})
 let verify = () => {
  let name = document.getElementById("email").value;
  let pass = document.getElementById("password").value;
  if (logindata.length>0) {
    alert("You are already logged in");
  } else if (check(name, pass)&&logindata.length === 0) {
    alert("logIn Successful");
  } else {
    alert("wrong Credantials!");
  }

}
let check = (name, pass) => {
  let filter = datafrmLS.filter((el) => {
    return el.email.toUpperCase() == name.toUpperCase() && el.password == pass;
  })
  if (filter.length > 0) {
    console.log(filter);
    localStorage.setItem("login",JSON.stringify(filter));
    return true;
  } else {
    return false;
  }
}
