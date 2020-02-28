function getCustomers() {
  var url = document.querySelector("#myUrl").value;
  var xhr = new XMLHttpRequest();
  var obj = null;

  xhr.open("GET", url, true);
  xhr.onload = function(){
      console.log(xhr.responseText);
      document.querySelector("#result").innerHTML = xhr.responseText;
      obj = JSON.parse(xhr.responseText);
  };
  xhr.send();

}
