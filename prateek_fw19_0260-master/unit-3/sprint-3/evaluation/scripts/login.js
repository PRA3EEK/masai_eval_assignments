let datafrmLS = JSON.parse(localStorage.getItem("Users"));
  let logindata = localStorage.getItem("login") || false;
  let form = document.querySelector("form").addEventListener("submit",()=>{
    event.preventDefault();
    verify();
  })
  verify = () =>{
    let name = document.getElementById("email").value;
    let pass = document.getElementById("password").value;
     if(check(name,pass)){
      alert("logIn Successful");
      let btn = document.createElement("button")
      btn.innerText = "Sign Out";
      btn.addEventListener("click",()=>{
        localStorage.removeItem("login");
        window.location.reload();
      })
      document.getElementById("form").append(btn);
      localStorage.setItem("login",true);
     }else if(logindata){
      alert("You are already logged in");
     }else{
      alert("wrong Credantials!");
     }
  
  }
  check = (name,pass)=>{
    let filter = datafrmLS.filter((el)=>{
    return el.email == name && el.password == pass;
    })
    if(filter.length>0){
      return true;
    }else{
      return false;
    }
  }