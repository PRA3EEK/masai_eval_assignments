document.querySelector("#roll").addEventListener("click",function(){
       
    document.querySelector("#member1").innerText = Math.floor(Math.random()*(7-1)+1);
    document.querySelector("#member2").innerText = Math.floor(Math.random()*(7-1)+1);  
    document.querySelector("#member3").innerText = Math.floor(Math.random()*(7-1)+1);    
    let first =  document.querySelector("#member1");
    let second = document.querySelector("#member2");
    let third = document.querySelector("#member3");
     
      changecolor(first.innerText,second.innerText,third.innerText);
    })

    function changecolor(first,second,third){
        
       if(+first > +second && +first > +third){
        document.getElementById("member1").style.backgroundColor = "green";
        document.getElementById("winner").innerText = "Member 1 is the Winner"
        if(+second > +third){
            document.getElementById("member2").style.backgroundColor = "yellow";
            document.getElementById("member3").style.backgroundColor = "red";
        }else if(+third > +second){
            document.getElementById("member3").style.backgroundColor = "yellow";
            document.getElementById("member2").style.backgroundColor = "red";
        }else if(+third == +second){
            document.getElementById("member3").style.backgroundColor = "blue";
            document.getElementById("member2").style.backgroundColor = "blue";
        }
       }else if(+second > +first && +second > +third){
        document.getElementById("member2").style.backgroundColor = "green";
        document.getElementById("winner").innerText = "Member 2 is the Winner"
        if(+first > +third){
            document.getElementById("member1").style.backgroundColor = "yellow";
            document.getElementById("member3").style.backgroundColor = "red";
        }else if(+third > +first){
            document.getElementById("member3").style.backgroundColor = "yellow";
            document.getElementById("member1").style.backgroundColor = "red";
        }
        else if(+third == +first){
            document.getElementById("member3").style.backgroundColor = "blue";
            document.getElementById("member1").style.backgroundColor = "blue";
        }
       }else if(+third > +first && +third > +first){
        document.getElementById("member3").style.backgroundColor = "green";
        document.getElementById("winner").innerText = "Member 3 is the Winner"
        if(+first > +second){
            document.getElementById("member1").style.backgroundColor = "yellow";
            document.getElementById("member2").style.backgroundColor = "red";
        }else if(+second > +first){
            document.getElementById("member2").style.backgroundColor = "yellow";
            document.getElementById("member1").style.backgroundColor = "red";
        }
        else if(+second == +first){
            document.getElementById("member2").style.backgroundColor = "blue";
            document.getElementById("member1").style.backgroundColor = "blue";
        }
       }else if(+first == +second && +first > +third){
        document.getElementById("winner").innerText = "Draw between member-1 and member-2"
        document.getElementById("member1").style.backgroundColor = "blue";
        document.getElementById("member2").style.backgroundColor = "blue";
        document.getElementById("member3").style.backgroundColor = "red";
       }
       else if(+first == +third && +first > +second){
        document.getElementById("winner").innerText = "Draw between member-1 and member-3"
        document.getElementById("member1").style.backgroundColor = "blue";
        document.getElementById("member3").style.backgroundColor = "blue";
        document.getElementById("member2").style.backgroundColor = "red";
       }
       else if(+second == +third && (+second > +first || +third > +first)){
        document.getElementById("winner").innerText = "Draw between member-2 and member-3"
        document.getElementById("member2").style.backgroundColor = "blue";
        document.getElementById("member3").style.backgroundColor = "blue";
        document.getElementById("member1").style.backgroundColor = "red";
       }
        else if(+first == +second && +second == +third){
            document.getElementById("winner").innerText = "Draw between member-1, member-2, and member-3"
        document.getElementById("member2").style.backgroundColor = "blue";
        document.getElementById("member3").style.backgroundColor = "blue";
        document.getElementById("member1").style.backgroundColor = "blue";
        }
    }