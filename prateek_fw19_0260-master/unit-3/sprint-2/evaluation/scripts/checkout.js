let func = function(){
    alert("your order has been placed");
  }
    setTimeout(function func(){
    alert("Your order is being Packed");
  },3000);
  setTimeout(function func(){
    alert("Your order is in transit");
  },8000);
  setTimeout(function func(){
    alert(" Your order is out for delivery");
  },10000);
  setTimeout(function func(){
    alert("Order delivered");
  },12000);

  document.querySelector("#submit").addEventListener("click",func)