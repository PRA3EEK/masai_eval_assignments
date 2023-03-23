let total = localStorage.getItem("cart_total");
let p = document.createElement("p");
p.innerText = total;
document.querySelector("#cart_total").append(p);
let crtitms = JSON.parse(localStorage.getItem("cart_items"));

addtopage(crtitms);


function addtopage(data){
 data.forEach(function(el,indx){
 let div = document.createElement("div");

 let img = document.createElement("img");
 img.src = el.image;
 let p = document.createElement("p");
 p.innerText = el.name;
 let p1 = document.createElement("p");
 p1.innerText = el.price;
 let btn = document.createElement("button");
 btn.addEventListener("click",function(){
   window.location.reload();
 })

 btn.innerText = "Remove item";
 btn.addEventListener("click",function(){
  removeitem(el,indx);
 });
 div.append(img,p,p1,btn);
  document.querySelector("#cart").append(div);
 })
}


function removeitem(el,indx){
 crtitms.splice(indx,1);
 localStorage.setItem("cart_items",JSON.stringify(crtitms));
let remam = Number(localStorage.getItem("remaining_amount"));
remam = remam + el.price;
localStorage.setItem("remaining_amount",remam);
total = total - el.price;
localStorage.setItem("cart_total",total);

 

}
function redirect(){
window.location.href = "checkout.html"
}