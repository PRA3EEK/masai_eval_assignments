let append = (data) => {
    document.getElementById("results").innerHTML = null;
    data.forEach((el)=>{
        let div = document.createElement("div");
        div.className = "news"
        div.addEventListener("click",()=>{
            localStorage.setItem("news",JSON.stringify(el));
            window.location.href = "news.html"
        })
        let div1 = document.createElement("div");
        let div2 = document.createElement("div");
        let img = document.createElement("img");
        img.src = el.urlToImage;
        let h = document.createElement("h3");
        h.innerText = el.title;
        let p = document.createElement("p");
        p.innerText = el.description;
        div1.append(img);
        div2.append(h,p);
        div.append(div1,div2);
        document.getElementById("results").append(div)
    })
  }
  let india = () => {
    fetch("https://masai-api.herokuapp.com/news/top-headlines?country=in").then((res)=>{
        return res.json();
    }).then((res)=>{
      console.log(res.articles)
      append(res.articles)
    }).catch((rej)=>{
      console.log(rej.message)
    })
  }
  let china = () => {
    fetch("https://masai-api.herokuapp.com/news/top-headlines?country=ch").then((res)=>{
        return res.json();
    }).then((res)=>{
      console.log(res.articles)
      append(res.articles)
    }).catch((rej)=>{
      console.log(rej.message)
    })
  }
  let US = () => {
    fetch("https://masai-api.herokuapp.com/news/top-headlines?country=us").then((res)=>{
        return res.json();
    }).then((res)=>{
      console.log(res.articles)
      append(res.articles)
    }).catch((rej)=>{
      console.log(rej.message)
    })
  }
  let UK = () => {
    fetch("https://masai-api.herokuapp.com/news/top-headlines?country=uk").then((res)=>{
        return res.json();
    }).then((res)=>{
      console.log(res.articles)
      append(res.articles)
    }).catch((rej)=>{
      console.log(rej.message)
    })
  }
  let newzeland = () => {
    fetch("https://masai-api.herokuapp.com/news/top-headlines?country=nz").then((res)=>{
        return res.json();
    }).then((res)=>{
      console.log(res.articles)
      append(res.articles)
    }).catch((rej)=>{
      console.log(rej.message)
    })
  }
  let search  = (query) => {
   fetch(`https://masai-api.herokuapp.com/news?q=${query}`).then((res)=> {
    return res.json();
   }).then((res)=> {
    console.log(res.articles)
    append(res.articles);
   }).catch((rej)=>{
    console.log(rej.message)
   })
  }
  export {india,china,US,UK,newzeland,search}