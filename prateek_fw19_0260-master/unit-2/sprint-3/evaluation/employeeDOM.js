// fill in javascript code here
document.querySelector("form").addEventListener("submit",func);
function func(event){
    event.preventDefault()
    let body = document.querySelector("tbody");
    let tr = document.createElement("tr");
    let td1 = document.createElement("td");
    let td2 = document.createElement("td");
    let td3 = document.createElement("td");
    let td4 = document.createElement("td");
    let td5 = document.createElement("td");
    let td6 = document.createElement("td");
    let td7 = document.createElement("td");
    let td8 = document.createElement("td");
    let name = document.querySelector("#name").value;
    let emplid = document.querySelector("#employeeID").value;
    let depar = document.querySelector("#department").value;
    let expe = document.querySelector("#exp").value;
    let email = document.querySelector("#email").value;
    let no = document.querySelector("#mbl").value;
    body.append(tr);
    tr.append(td1);
    td1.append(name);
    tr.append(td2);
    td2.append(emplid);
    tr.append(td3);
    td3.append(depar);
    tr.append(td4);
    td4.append(expe);
    tr.append(td5);
    td5.append(email);
    tr.append(td6);
    td6.append(no);
    tr.append(td7)
    if(Number(expe) > 5){
       td7.append("Senior");
    }else if(Number(expe) >= 2 && Number(expe) <= 5){
        td7.append("Junior");
    }else if(Number(expe) <= 1 ){
        td7.append("Fresher");
    }
    tr.append(td8);
    td8.append("Delete");
    td8.addEventListener("click",func2);
    td8.style.cursor="pointer";
}
function func2(event){
    event.target.parentNode.remove();
}

