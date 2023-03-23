let form = document.querySelector("form");
function obj(n,nu,e,p){
   this.name = n;
   this.number = nu;
   this.email = e;
   this.password = p;
}

form.addEventListener("submit",addData);
let signupdatafrmLs = JSON.parse(localStorage.getItem("signupdata")) || [];

function addData(){
    event.preventDefault();
   
    if(check(signupdatafrmLs) == true){
        alert("You already have an Account");
    }else{
    let name = form.name.value;
    let number = form.no.value;
    let email = form.email.value;
    let password = form.password.value;
    
    let dataobj = new obj(name,number,email,password);
    signupdatafrmLs.push(dataobj);
    localStorage.setItem("signupdata",JSON.stringify(signupdatafrmLs));
    alert("Sign Up Successful");
     window.location.href = "login.html"
    }
}

function check(signupdatafrmLs){
let x = signupdatafrmLs.filter(function(el){
    return el.email.toUpperCase() == form.email.value.toUpperCase();
})

if(x.length > 0){
    return true;
}else{
    return false;
};
}