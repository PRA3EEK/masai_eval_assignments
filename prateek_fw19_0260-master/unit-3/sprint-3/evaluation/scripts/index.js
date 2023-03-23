let logindata = localStorage.getItem("login") || false;
let search = document.querySelector("#query").addEventListener("keypress", () => {
  fetchreq();
})
fetchreq = () => {
  if (event.keyCode == 13) {
    let name = document.getElementById("query").value;
    let url = `https://masai-mock-api.herokuapp.com/hotels/search?city=${name}`
    fetch(url).then((res) => {
      return res.json();
    }).then((res) => {
      localStorage.setItem("hotels_list", JSON.stringify(res.hotels));
      append(res.hotels);
    })
  }

}


document.getElementById("sort_lth").addEventListener("click", () => {
  let data = JSON.parse(localStorage.getItem("hotels_list")) || [];
  let sorteddata = data.sort((a, b) => {
    return a.Price - b.Price
  })
  append(sorteddata);
})
document.getElementById("sort_htl").addEventListener("click", () => {
  let data = JSON.parse(localStorage.getItem("hotels_list")) || [];
  let sorteddata = data.sort((a, b) => {
    return b.Price - a.Price
  })
  append(sorteddata);
})
document.getElementById("filter_ac").addEventListener("click", () => {
  let data = JSON.parse(localStorage.getItem("hotels_list")) || [];
  let filter = data.filter((el) => {
    return el.Ac == true;
  })
  append(filter);
})
document.getElementById("filter_nonac").addEventListener("click", () => {
  let data = JSON.parse(localStorage.getItem("hotels_list")) || [];
  let filter = data.filter((el) => {
    return el.Ac == false;
  })
  append(filter);
})

append = (data) => {
  document.getElementById("hotels_list").innerHTML = "";
  data.forEach((el) => {
    console.log(el);

    let div = document.createElement("div");
    div.setAttribute("id", "hotel");
    let img = document.createElement("img");
    img.src = el.Images.one;
    let h3 = document.createElement("h3");
    h3.innerText = el.Title;
    let p2 = document.createElement("p");
    p2.innerText = `Price per room :${el.Price}`
    let p3 = document.createElement("p");
    p3.innerText = `Ratings :${el.Rating}`
    let p4 = document.createElement("p");
    p4.innerText = `AC :${el.Ac}`
    let p5 = document.createElement("p");
    p5.innerText = `Rooms :${el.Rooms}`
    let btn = document.createElement("button");
    btn.innerText = "Book Room";
    btn.className = "book"
    btn.addEventListener("click", () => {
      hoteldetails(el);
    })
    div.append(img, h3, p2, p3, p4, p5, btn);
    document.getElementById("hotels_list").append(div);
  })
}
hoteldetails = (el) => {
  if(logindata){
    localStorage.setItem("hoteldetails",JSON.stringify(el));
    window.location.href = "checkout.html"
  }else{
    alert ("You are not logged in");
  }

}