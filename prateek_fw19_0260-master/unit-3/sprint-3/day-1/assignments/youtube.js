fetchurl_home = async () => {
    let searchname = document.querySelector("#query").value;
    let url = ` https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=60&q=$most%20popular%20videos%20in%20india&key=AIzaSyBCqEmncZRSVptppnQOve0JEd8SI0KJMBA`
    let x = await fetch(url);
    let data = await x.json();
    let arr = data.items;
    // console.log(arr);
    append(arr);
   
 }

 fetchurl_home();
 fetchurl = async () => {
    let searchname = document.querySelector("#query").value;
    let url = ` https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=60&q=${searchname}&key=AIzaSyBCqEmncZRSVptppnQOve0JEd8SI0KJMBA`
    let x = await fetch(url);
    let data = await x.json();
    let arr = data.items;
    console.log(arr);
    append(arr);
   
 }
 
//  https://youtube.googleapis.com/youtube/v3/search?part=snippet&maxResults=60&key=[YOUR_API_KEY]
 document.getElementById("submit").addEventListener("click",fetchurl);

  append = (arr) => {
    document.querySelector("#body").innerHTML = null
    for(x of arr){
        let {snippet:{thumbnails:{medium:{url}},title},id:{videoId}} = x;
    let div = document.createElement("div");
    div.addEventListener("click",function(){
        add(videoId);
    });
    let img = document.createElement("img");
    img.src = url
    let p = document.createElement("p");
     p.innerText = title;
     div.append(img,p);
     document.querySelector("#body").append(div);
    
    }
   
  }

  add = (vi) => {
    localStorage.setItem("video",vi);
    window.location.href = "page3.html";
  }