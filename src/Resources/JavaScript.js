
console.log("yo");

var x = function() {console.log("bye")};

setInterval(refresh,400);

// can you do something which only refreshes when you make a click rather than refreshing every x amount of time?

const controller = new AbortController();

async function refresh() {

  var response = await fetch("/render")

//  var response = await fetch("/render").then(response => {
//
//    if (response === null) {
//      console.log("empty");
//      } else {
//      var element = document.getElementById("board")
//        element.innerHTML = await response.text();
//      }
//
//
//  }).catch(error => {
//
//   document.getElementById("board").style.display = "none";
//
//  });

  var element = document.getElementById("board")
  element.innerHTML = await response.text();




}

async function stop() {
document.getElementById("board").style.display = "none";

}

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






