// All the JS Code for the Add Students Page Goes Here
let studentData = JSON.parse(localStorage.getItem("admission")) || [];
document.querySelector("#form").addEventListener("submit",addData);
function addData(event){
    event.preventDefault()
    let nm = document.querySelector("#name").value;
    let email = document.querySelector("#email").value;
    let phone = document.querySelector("#phone").value;
    let gender = document.querySelector("#gender").value;
    let course = document.querySelector("#course").value;
    let obj = {
       studentname : nm,
       studentemail : email,
       studentnumber : phone,
       studentgender : gender,
       studentcourse : course,
    };
    studentData.push(obj);
    localStorage.setItem("admission",JSON.stringify(studentData));
}