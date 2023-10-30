
console.log("yo");

var x = function() {console.log("bye")};

setInterval(x,10000);

var pieceSelected;
var movePieceTo;

async function myFunction(button) {

  //var hello = document.getElementById("id").data-x;

  //console.log(hello);

  console.log(button.getAttribute("id"));

  var xCo = button.getAttribute("data-x");
  var yCo = button.getAttribute("data-y");

  document.cookie = "x=xCo";
  document.cookie = "y=yCo";

  var cookie = document.cookie;

  console.log(cookie);

  pieceSelected = { x : xCo, y : yCo};

  console.log(pieceSelected);

  var url = `/makeMove?x=${xCo}&y=${yCo}`

  var response = await fetch(url);

  document.getElementById("board").innerHTML = await response.text();



}




//if (button.disabled === undefined) {
//
//
//   //window.location.href= "/render";
//
//   var response = await fetch("/render")
//
//   //.then(function(data) { console.log(data) })
//
//   console.log(response.data);
//
//   var data = await response.text();
//
//   console.log(data);
//
//   document.getElementById("board").innerHTML = data;
//
//  } else {
//
//   console.log("This move cannot be played")
//
//  }
//
//  return button.disabled = true;
//
//}






