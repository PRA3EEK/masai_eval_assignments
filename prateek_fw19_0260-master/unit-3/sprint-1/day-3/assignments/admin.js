let productarr = JSON.parse(localStorage.getItem("Products")) || [];
   let form =  document.querySelector("form")
   form.addEventListener("submit",function(event){
    event.preventDefault();
    let name = form.name.value;
    let ctg  = form.catagory.value;
    let imgURl = form.image.value;
    let prc = form.price.value;
    let gender = form.gender.value;
    let sld = form.sold.value;
    let productdata = new addproducts(name,ctg,imgURl,prc,gender,sld);
    productarr.push(productdata);
    localStorage.setItem("Products",JSON.stringify(productarr));
    window.location.reload();
    
   })
   function addproducts(n,c,i,p,g,b){
      this.name = n;
      this.ctg = c;
      this.url = i;
      this.price = p;
      this.gender = g;
      this.sold = b;
   }