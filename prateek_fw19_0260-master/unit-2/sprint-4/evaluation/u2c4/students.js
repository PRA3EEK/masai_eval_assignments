// All the Code for All Students Page Goes Here
let admissiondatafrmLS = JSON.parse(localStorage.getItem("admission")) || [];

admissiondatafrmLS.forEach(function(el,indx){
    addtostudentdatabase(el,indx)
})


function addtostudentdatabase(el,indx){
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
    let td6 = document.createElement("td");
    td6.innerText = "Accept";
    td6.style.backgroundColor = "green";
    td6.style.color = "white";
    td6.style.cursor = "pointer";
    td6.addEventListener("click",function(){
      addtoadmitted(el,indx);
    })
    let td7 = document.createElement("td");
    td7.innerText = "Reject";
    td7.style.backgroundColor = "red";
    td7.style.color = "white";
    td7.style.cursor = "pointer";
    td7.addEventListener("click",function(){
      addtorejected(el,indx);
    })
    document.querySelector("tbody").append(tr);
    tr.append(td1,td2,td3,td4,td5,td6,td7);
}





let admittedData = JSON.parse(localStorage.getItem("admission-accepted")) || [];
let rejectedData = JSON.parse(localStorage.getItem("admission-rejected")) || [];
function addtoadmitted(el,indx){
    admittedData.push(el);
    localStorage.setItem("admission-accepted",JSON.stringify(admittedData));
   deletefunction(indx);
}
function addtorejected(el,indx){
    rejectedData.push(el);
    localStorage.setItem("admission-rejected",JSON.stringify(rejectedData));
    deletefunction(indx)
}
function deletefunction(indx){
    admissiondatafrmLS.splice(indx,1);
    localStorage.setItem("admission",JSON.stringify(admissiondatafrmLS));
    window.location.reload();
}

document.querySelector("select").addEventListener("change",function(){
    filterdata(admissiondatafrmLS)
});
 function filterdata(A){
   let course = document.querySelector("select").value;
   document.querySelector("tbody").innerHTML="";
   if(course == "all"){

    A.forEach(function(el,indx){
        addtostudentdatabase(el,indx)
    })
    
   }else{
    let filter =  A.filter(function(el){
        return el.studentcourse == course;
    })
    filter.forEach(function(el,indx){
        addtostudentdatabase(el,indx);
    })
   }
  
    
}

 
