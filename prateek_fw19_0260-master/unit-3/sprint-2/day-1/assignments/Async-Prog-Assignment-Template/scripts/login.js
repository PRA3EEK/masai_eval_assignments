let form = document.querySelector("form");
form.addEventListener("submit",Ckeckdetails);
function obj(e,p){
  this.email = e;
  this.password = p;
} 
let logindatafrmLS = JSON.parse(localStorage.getItem("logindata")) || [];
function Ckeckdetails(){
    event.preventDefault();
    let email = form.email.value;
    let password = form.pass.value;
    let loginobj = new obj(email,password);
    if(logindatafrmLS.length === 0 && Check(loginobj) == true){
        
    logindatafrmLS.push(loginobj);
    localStorage.setItem("logindata",JSON.stringify(logindatafrmLS));
    alert("Login Successful");
    window.location.href = "index.html";
    }else{
       if(logindatafrmLS.length > 0){
        alert("You are Already logged in please Sign Out before LogIn again");
       }else if(Check(loginobj) == false){
           alert("Wrong Credentials");
       }
    }
 
}





let signupdatafrmLs = JSON.parse(localStorage.getItem("signupdata")) || [];
function Check(data){
   let filter = signupdatafrmLs.filter(function(el){
    return el.email.toUpperCase() == data.email.toUpperCase() && el.password == data.password;
   })
   if(filter.length > 0){
    return true;
   }else{
    return false;
   }
}

function remove(){
localStorage.removeItem("logindata");
window.location.reload();
window.location.href = "signup.html";
}