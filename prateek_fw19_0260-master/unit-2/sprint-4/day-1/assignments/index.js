document.querySelector("form").addEventListener("submit",addtotheLS);
let Data =JSON.parse(localStorage.getItem("questData")) || [];
function addtotheLS(event){
    event.preventDefault();
    
        let quest = document.querySelector("#title").value;
        let link = document.querySelector("#link").value;
        let difficulty = document.querySelector("#difficulty").value;
        let obj = {};
        obj["question"] = quest;
        obj["link"] = link;
        obj["diff"] = difficulty;
        Data.push(obj);
        localStorage.setItem("questData",JSON.stringify(Data));
        window.location.reload();
       
}



function addtoTable(Data){

    Data.forEach(function(el,indx){
        let tr = document.createElement("tr");
        let td1 = document.createElement("td");
        let td2 = document.createElement("td");
        let td3 = document.createElement("td");
        let td4 = document.createElement("td");
        let td5 = document.createElement("td");
       td1.innerText = el.question;
       td2.innerText = el.link;
       td3.innerText = el.diff;
       td5.innerText = "DELETE";
       td5.style.backgroundColor = "red";
       td5.style.color = "white";
       td5.style.cursor = "pointer";
       td5.addEventListener("click",function(){
        deletefunc(indx);
       });
       if(el.diff == "Easy"){
        td4.innerText = "No";
       }else if(el.diff == "Medium" || el.diff == "Hard"){
        td4.innerText = "Yes";
       }
      document.querySelector("tbody").append(tr);
      tr.append(td1,td2,td3,td4,td5);
    })
    
}
function deletefunc(indx){
   Data.splice(indx,1);
   localStorage.setItem("questData",JSON.stringify(Data));
   addtoTable(Data);
   window.location.reload();
}
addtoTable(Data);
