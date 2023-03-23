//store the products array in localstorage as "data"
let datafrmLS = JSON.parse(localStorage.getItem("data")) || [];

let form =  document.querySelector("#form");
form.addEventListener("submit",addData);

 function obj(b,n,p,i){
   this.brand = b;
   this.name = n;
   this.price =  p;
   this.image = i;
 }
 
 function addData(event){
  event.preventDefault();
  let brand = form.product_brand.value;
   let name = form.product_name.value;
   let price = form.product_price.value;
   let image = form.product_image.value;
   let prodobj = new obj(brand,name,price,image);
   datafrmLS.push(prodobj);
   localStorage.setItem("data",JSON.stringify(datafrmLS));
   window.location.reload();
 }

document.querySelector("button").addEventListener("click",func);
function func(){
    window.location.href = "inventory.html";
}
