const formEl = document.querySelector("form");
const tbodyEl = document.querySelector("tbody");
const tableEl = document.querySelector("table");


function validateForm(){
    var name=document.getElementById("inputName")
    if (name.value.trim()==""){  
        name.style.border="solid 2px red";
        return false;
    }
    else{
        name.style.border="solid 2px green";
    }
}
function addStudent(e) {
    e.preventDefault();
    let name = document.getElementById("inputName").value;
    let email = document.getElementById("inputEmail").value;
    let website = document.getElementById("inputWebsiteURL").value;
    var image = document.getElementById("inputImageURL").value;
    var gender = document.querySelector('input[name = "gender"]:checked').value;
    let items = document.getElementsByName("lang");
    let selectedItems = "";

    for (var i = 0; i < items.length; i++) {
        if (items[i].type == "checkbox" && items[i].checked == true) selectedItems += items[i].value + ", ";
    }
    tbodyEl.innerHTML = `
      <tr>
          <td><strong>${name}</strong><br>
          ${gender}<br>${email}<br>
          <a href ="${website}" target="_blank">${website}</a><br>
          ${selectedItems}</td>
      <td><img src="${image}" alt="student image"></td>
      </tr>
  ` + tbodyEl.innerHTML;
}
formEl.addEventListener("submit", addStudent);
