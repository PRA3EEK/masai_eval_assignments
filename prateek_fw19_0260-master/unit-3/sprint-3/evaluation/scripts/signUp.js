let data = JSON.parse(localStorage.getItem("Users")) || [];
  let login = localStorage.getItem("login");
  if(login){
    document.getElementById("logIn").innerText = "Sign Out";
    document.getElementById("logIn").addEventListener("click",()=>{
      localStorage.removeItem("login")
    })
  }
  class Users{
    constructor(n,e,p){
      this.name = n;
      this.email = e;
      this.password = p;
    }
    adduser(){
      let velidate = false;
      velidate = this.velidateemail(this.email) && this.velidatepassword(this.password);
      if(velidate){
        data.push(this);
        localStorage.setItem("Users",JSON.stringify(data));
        alert("Sign up Successful")
      }else if(!this.velidateemail(this.email)){
        alert("email id already exist");
      }else{
        alert ("Password must be 10 characters long");
      }
      
    }
    velidateemail(email){
      let filter = data.filter((el)=>{
       return el.email == email;
      })
      if(filter.length>0){
        return false;
      }else{
        return true;
      }
    }
    velidatepassword(password){
      if(password.length>=10){
        return true
      }else{
        return false;
      }
    }
  }
  let form  = document.querySelector("form").addEventListener("submit",()=>{
    event.preventDefault();
    console.log("prateek");
    let name = document.getElementById("name").value;
    let email = document.getElementById("email").value;
    let pass = document.getElementById("password").value;
    let u = new Users(name,email,pass);
    u.adduser();
  })