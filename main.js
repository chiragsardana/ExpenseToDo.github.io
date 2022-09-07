function getFormValue() {
  const name = document.getElementById("1").value;
  const costs = document.getElementById("myRange").value;
  const date = document.getElementById("3").value;
  const color = document.getElementById("4").value;
  const url = document.getElementById("5").value;
  const remarks = document.getElementById("6").value;

  console.log(
    name +
      "\n" +
      costs +
      "\n" +
      date +
      "\n" +
      color +
      "\n" +
      url +
      "\n" +
      remarks
  );
  console.log("SUbmit Button CLicks");
  var url_api =
    "https://microservice-based-application.herokuapp.com/ToDoExpense/save";
  var toDoExpense = {
    name: name,
    costs: costs,
    date: date,
    color: color,
    url: url,
    remarks: remarks,
  };
  var data = JSON.stringify(toDoExpense);
  var http = new XMLHttpRequest();
  http.onreadystatechange = function () {
    if (http.readyState == 4 && http.status == 404) {
      var json = JSON.parse(this.responseText);
    } else if (http.readyState == 4 && http.status == 201) {
      alert("Expense Added Succesfully!");
	  location.reload();
    }
  };
  http.open("POST", url_api, true);
  http.setRequestHeader("Content-Type", "application/json");
  http.send(data);
}
var form = document.getElementById("new-task-form");
var form1 = document.getElementById("new-task-search");
function handleForm(event) {
  event.preventDefault();
}
form.addEventListener("submit", handleForm);
form1.addEventListener("submit", handleForm);

function getSearchFormValue() {
	$("#unique").remove();
  const id = document.getElementById("search_id").value;
  console.log(id);
  var url_api =
    "https://microservice-based-application.herokuapp.com/ToDoExpense/getById/" +
    id;
  var http = new XMLHttpRequest();
  http.onreadystatechange = function () {
    if (http.readyState == 4 && http.status == 200) {
      //console.log(http.responseText);
      var json = JSON.parse(this.responseText);
      console.log(json["name"]);
	  
      // <label for="new-task-input" class="new-task-label">Id</label>
      // <label for="new-task-input" class="new-task-label">Name</label>
      // <label for="new-task-input" class="new-task-label">Costs</label>
      // <label for="new-task-input" class="new-task-label">Date</label>
      // <label for="new-task-input" class="new-task-label">Color</label>
      // <label for="new-task-input" class="new-task-label">URL</label>
      // <label for="new-task-input" class="new-task-label">Remarks</label>
      // <br>
      // <div class="break"></div>

      var element_to_be_added = '<div id="unique" style="width: 100%;">';
        element_to_be_added += '<br><div id="new-task-data" style="width: 100%;">';
      element_to_be_added +=
        '<label for="new-task-input" class="new-task-label">';
      element_to_be_added += json["id"];
      element_to_be_added += "</label>";
      element_to_be_added +=
        '<label for="new-task-input" class="new-task-label">';
      element_to_be_added += json["name"];
      element_to_be_added += "</label>";
      element_to_be_added +=
        '<label for="new-task-input" class="new-task-label">';
      element_to_be_added += json["costs"];
      element_to_be_added += "</label>";
      element_to_be_added +=
        '<label for="new-task-input" class="new-task-label">';
      element_to_be_added += json["date"];
      element_to_be_added += "</label>";
      element_to_be_added +=
        '<label for="new-task-input" class="new-task-label">';
      element_to_be_added += json["color"];
      element_to_be_added += "</label>";
      element_to_be_added +=
        '<label for="new-task-input" class="new-task-label">';
      element_to_be_added += json["url"];
      element_to_be_added += "</label>";
      element_to_be_added +=
        '<label for="new-task-input" class="new-task-label">';
      element_to_be_added += json["remarks"];
      element_to_be_added += "</label><br> </div>";
      $("main").append(element_to_be_added);
    } else if (http.readyState == 4 && http.status == 404) {
      //console.log("No Product");
      alert("No Id is Exist.");
    }
  };
  http.open("get", url_api, true);
  http.setRequestHeader("Content-Type", "application/json");
  http.send();
}

window.onload = function getAllExpenses() {
  var url_api =
    "https://microservice-based-application.herokuapp.com/ToDoExpense/get";
  var http = new XMLHttpRequest();
  http.onreadystatechange = function () {
    if (http.readyState == 4 && http.status == 200) {
      //console.log(http.responseText);
      var json = JSON.parse(this.responseText);
      console.log(json);
      // <label for="new-task-input" class="new-task-label">Id</label>
      // <label for="new-task-input" class="new-task-label">Name</label>
      // <label for="new-task-input" class="new-task-label">Costs</label>
      // <label for="new-task-input" class="new-task-label">Date</label>
      // <label for="new-task-input" class="new-task-label">Color</label>
      // <label for="new-task-input" class="new-task-label">URL</label>
      // <label for="new-task-input" class="new-task-label">Remarks</label>
      // <br>
      // <div class="break"></div>
      for (let i = 0; i < json.length; i++) {
        console.log(json[i]);
        var element_to_be_added =
          '<br><div id="new-task-data" style="width: 100%;">';
        element_to_be_added +=
          '<label for="new-task-input" class="new-task-label">';
        element_to_be_added += json[i]["id"];
        element_to_be_added += "</label>";
        element_to_be_added +=
          '<label for="new-task-input" class="new-task-label">';
        element_to_be_added += json[i]["name"];
        element_to_be_added += "</label>";
        element_to_be_added +=
          '<label for="new-task-input" class="new-task-label">';
        element_to_be_added += json[i]["costs"];
        element_to_be_added += "</label>";
        element_to_be_added +=
          '<label for="new-task-input" class="new-task-label">';
        element_to_be_added += json[i]["date"];
        element_to_be_added += "</label>";
        element_to_be_added +=
          '<label for="new-task-input" class="new-task-label">';
        element_to_be_added += json[i]["color"];
        element_to_be_added += "</label>";
        element_to_be_added +=
          '<label for="new-task-input" class="new-task-label">';
        element_to_be_added += json[i]["url"];
        element_to_be_added += "</label>";
        element_to_be_added +=
          '<label for="new-task-input" class="new-task-label">';
        element_to_be_added += json[i]["remarks"];
        element_to_be_added += "</label><br>";

        $("#unique").append(element_to_be_added);
      }
    }
  };
  http.open("get", url_api, true);
  http.setRequestHeader("Content-Type", "application/json");
  http.send();
};
