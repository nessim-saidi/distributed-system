function myRequest() {
  var xhr = new XMLHttpRequest();
  xhr.open("GET", document.querySelector("#myUrl").value, true);
  xhr.onload = function() {
    handleResponse();
  };
  xhr.send();
}

function handleResponse() {
  console.log(xhr.responseText);
  document.querySelector("#container").innerHTML = xhr.responseText;
}
