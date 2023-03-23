let url = "https://grocery-masai.herokuapp.com/items";
let data = [];
fetch(url).then(function(res){
  return res.json();
}).then(function(res){
   addtopage(res.data);
}).catch(function(rej){
  console.log("error");
})


function addtopage(data){
  data.forEach(function(el,indx){
  let div = document.createElement("div");
  div.className = "item";
  let img = document.createElement("img");
  img.src = el.image;
  let p = document.createElement("p");
  p.innerText = el.name;
  let p1 = document.createElement("p");
  p1.innerText = el.price;
  let btn = document.createElement("button");
  btn.className = "add_to_cart";
  btn.innerText = "add to cart";
  btn.addEventListener("click",function(){
   addtocart(el);
  });
  div.append(img,p,p1,btn);
   document.querySelector("#items").append(div);
  })
}
// let wallet = 700;
let sum = Number(localStorage.getItem("cart_total")) || 0;
let cartdatafrmLS = JSON.parse(localStorage.getItem("cart_items")) || [];
function addtocart(item){
   sum = sum + item.price;
   if(sum <= 700){
   
    cartdatafrmLS.push(item);
  localStorage.setItem("cart_items",JSON.stringify(cartdatafrmLS));
  localStorage.setItem("cart_total",Number(sum));
  window.location.reload();
   }else{
    sum = sum - item.price;
    alert("You don't have enough balance in your wallet");
   }
 

}
let remam = 700 - sum;
localStorage.setItem("remaining_amount",remam);
let x = localStorage.getItem("remaining_amount")
document.querySelector("#wallet").append(x);