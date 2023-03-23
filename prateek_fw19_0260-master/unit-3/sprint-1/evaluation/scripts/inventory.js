let proddatafrmLS = JSON.parse(localStorage.getItem("data")) || [];
  

proddatafrmLS.forEach(function(el,indx){
  let div = document.createElement("div");
  let img = document.createElement("img");
  img.setAttribute("src",el.image);
  let p1 = document.createElement("p");
  p1.innerText = el.brand;
  let p2 = document.createElement("p");
  p2.innerText = el.name;
  let p3 = document.createElement("p");
  p3.innerText = el.price;
  let btn = document.createElement("button");
  btn.innerText = "Remove";
  btn.addEventListener("click",function(){
      remove(el,indx);
  })

  div.append(img,p1,p2,p3,btn);
  document.querySelector("#products_data").append(div);

})

function remove(el,indx){
    proddatafrmLS.splice(indx,1);
    localStorage.setItem("data",JSON.stringify(proddatafrmLS));
    window.location.reload();
}

document.querySelector("#add_product").addEventListener("click",function(){
    window.location.href = "index.html"
})