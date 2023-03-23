let getdata = async(url) => {
    // fetch(url).then((res)=>{
    //     return res.json();
    //   }).then((res)=>{
    //     return res
    //   })
    let res = await fetch(url);
    let data = await res.json();
     return data
} 

let append = (res ,cont) => {
   
  res.forEach(({strMealThumb,strMeal,strInstructions})=>{
     
    let img = document.createElement("img");
    img.src = strMealThumb;
    let title =  document.createElement("h3");
    title.innerText = strMeal;
    let p = document.createElement("p");
    p.innerText = strInstructions;
    let div = document.createElement("div");
    div.append(img,title,p);
    let div1 = document.createElement("div");
    div1.append(img);
    let div2 = document.createElement("div");
    div2.append(title,p);
    div.append(div1,div2)
    cont.append(div);
  })
}
let error = (cont) => {
  let img = document.createElement("img");
  img.src = "https://thumbs.gfycat.com/AdvancedOptimisticBlowfish-max-1mb.gif"
  img.style.width = "100%"
  cont.append(img);
}

export {getdata,append,error}