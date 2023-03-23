// All the Code for the Rejected page goes here
let rejectedDatafrmLS = JSON.parse(localStorage.getItem("admission-rejected")) || [];

rejectedDatafrmLS.forEach(function(el){
    addtorejected(el);
})


function addtorejected(el){
    let tr = document.createElement("tr");
    tr.style.textAlign = "center";
    let td1 = document.createElement("td");
    td1.innerText = el.studentname;
    let td2 = document.createElement("td");
    td2.innerText = el.studentemail;
    let td3 = document.createElement("td");
    td3.innerText = el.studentcourse;
    let td4 = document.createElement("td");
    td4.innerText = el.studentgender;
    let td5 = document.createElement("td");
    td5.innerText = el.studentnumber;
    document.querySelector("tbody").append(tr);
    tr.append(td1,td2,td3,td4,td5);
}