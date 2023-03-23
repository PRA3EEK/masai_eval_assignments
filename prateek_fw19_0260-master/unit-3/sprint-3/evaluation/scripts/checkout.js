let details = JSON.parse(localStorage.getItem("hoteldetails"));
let div = document.createElement("div");
div.setAttribute("id","images")
  let img = document.createElement("img");
  img.src = details.Images.one;
  let img1 = document.createElement("img");
   img1.src = details.Images.two;
    let h3 = document.createElement("h3");
    h3.innerText = details.Title;
    let p2 = document.createElement("p");
    p2.innerText = `Price per room :${details.Price}`
    div.append(img,img1);
    document.getElementById("hotel_details").append(div,h3,p2);

    let btn = document.getElementById("book")
btn.addEventListener("click",()=>{
    setTimeout(() => {
        let name = document.getElementById("user_name").value
        alert(`${name}, Your booking is successful`);
    }, 5000);  
       
    })
  
  