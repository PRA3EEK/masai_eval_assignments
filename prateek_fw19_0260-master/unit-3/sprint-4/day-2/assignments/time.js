let convertTime = (time) => {
    let x = time.toString();
    if(x.length <=7&&time<3600000){
     if(x[2]==0 && x[3]==0&&x[4]==0){
         let l = +x/1000;
       if(l>=60){
         let div = +x/60000;
        div = div.toString();
           let z = div.split(".");
           if(z.length == 2){
            return `${z[0]} Minute ${z[1]} Seconds`;
          }
            else{
              return `${z[0]} Minute`
            }
       }else{
         return `${+x/1000} Seconds`
       }
     }else {
         x = +x/1000;
         x = x.toString();
         let y = x.split(".");
         // let l = y[1];
         if(+y[0]>=60){
           // y = +y[0]/60;
          let div = time/60000
           // console.log(div);
           div = div.toString();
           let z = div.split(".");
           return `${z[0]} Minute ${z[1]} Seconds`;
         }else{
           return `${y[0]} seconds ${y[1]} milliseconds`
         }
     }
    }else{
      if(time%3600000===0){
        return `${time/3600000} Hours`
      }else{
      let padTo2Digits = (num) => {
   return num.toString().padStart(2, '0');
 }
 
 
   let seconds = Math.floor(time / 1000);
   let minutes = Math.floor(seconds / 60);
   let hours = Math.floor(minutes / 60);
 
   seconds = seconds % 60;
   minutes = minutes % 60;
   hours = hours % 24;
 
   return `${padTo2Digits(hours)} Hours ${padTo2Digits(minutes)} Minutes ${padTo2Digits(
     seconds,
   )} Seconds`;
 
      }
     
    }
 
 }

 export default convertTime